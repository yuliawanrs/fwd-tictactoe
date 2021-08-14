package com.example.fwdtictactoe;

public class GameState {
    private int fieldSizes;
    private int status = 1;
    private int countStepsNow = 0;
    private int[][] fieldState;

    private void checkWinning() {
        if(countStepsNow != (fieldSizes * fieldSizes)) {
            for(int i = 0; i < fieldSizes; i++) {
                checkWin(false, i);
            }
            checkWin(true, 0);
        } else {
            status = 3;
        }
    }

    public void setFieldSizes(int fieldSizes) {
        this.fieldSizes = fieldSizes;
        this.fieldState = new int[fieldSizes][fieldSizes];
    }

    public String getStatus() {
        this.checkWinning();
        String statusToText;
        switch (status) {
            case 1:
                statusToText = "X turn";
                countStepsNow++;
                break;
            case 2:
                statusToText = "O turn";
                countStepsNow++;
                break;
            default:
                statusToText = "Game Ends!";
                break;
        }
        return statusToText;
    }

    public String drawField() {
        StringBuilder field = new StringBuilder();
        field.append("<table>");
        for(int i = 0 ; i < fieldSizes; i++) {
            field.append("<tr>");
            for (int j = 0; j < fieldSizes; j++) {
                field.append("<td>");
                switch (fieldState[i][j]) {
                    case 1:
                        field.append("X");
                        break;
                    case 2:
                        field.append("O");
                        break;
                    default:
                        if(status == 0) {
                            field.append("<div> </div>");
                        } else {
                            field.append("<a href='game?i=").append(i).append("&j=").append(j).append("'><div> </div></a>");
                        }
                        break;
                }
                field.append("</td>");
            }
            field.append("</tr>");
        }
        field.append("</table>");
        return field.toString();
    }

    public void setStep(int i, int j) {
        this.fieldState[i][j] = status;
        status = status == 1 ? 2 : 1;
    }

    private void checkWin(boolean diagonal, int ident) {
        if(diagonal) {
            int temp = fieldState[0][0];
            for (int i = 1; i < fieldSizes; i++) {
                if(temp != fieldState[i][i] || temp == 0) {
                    break;
                } else if (i == (fieldSizes - 1)){
                    status = 0;
                }
            }
            temp = fieldState[0][fieldSizes - 1];
            for (int i = 1; i < fieldSizes; i++) {
                if(temp != fieldState[i][fieldSizes - (i + 1)] || temp == 0) {
                    break;
                } else if (i == (fieldSizes - 1)){
                    status = 0;
                }
            }
        } else {
            int temp = fieldState[ident][0];
            for (int i = 1; i < fieldSizes; i++) {
                if(temp != fieldState[ident][i] || temp == 0) {
                    break;
                } else if ( i == (fieldSizes - 1)  ) {
                    status = 0;
                }
            }
            temp = fieldState[0][ident];
            for (int i = 1; i < fieldSizes; i++) {
                if(temp != fieldState[i][ident] || temp == 0) {
                    break;
                } else if ( i == (fieldSizes - 1) ) {
                    status = 0;
                }
            }
        }
    }
}
