package com.mycoding.tictactoe1;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {
    private int[][] gameBoard;
    private int player = 1;
    private int[] winType = {-1, -1, -1};
    private String [] names = {"Player 1", "Player 2"};
    private Button playAgainBTN, homeBTN;
    private TextView playerTurn;

    GameLogic(){
        gameBoard = new int[3][3];
        for(int r = 0; r< 3; r++){
            for(int c = 0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col){
        if(gameBoard[row-1][col-1] == 0) {
            gameBoard[row -1][col-1] = player;

            if (player == 1){
                playerTurn.setText((names[1]+"'s Turn"));
            }
            else{
                playerTurn.setText((names[0]+"'s Turn"));
            }
            return true;
        }
        else{
            return false;
        }
    }

    public boolean winnerCheck(){
        boolean isWinner = false;
        for (int r= 0; r<3; r++){
            if(gameBoard[r][0] == gameBoard[r][1] && gameBoard[r][0] == gameBoard[r][2] && gameBoard[r][0] != 0){
                winType = new int[] {r, 0, 1};
                isWinner = true;
            }
        }
        for (int c= 0; c<3; c++){
            if(gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] == gameBoard[2][c] && gameBoard[0][c] != 0){
                winType = new int[] {0, c, 2};
                isWinner = true;
            }
        }
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != 0) {
            winType = new int[] {0, 2, 3};
            isWinner =true;
        }
        if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0] && gameBoard[0][2] != 0) {
            winType = new int[] {2, 2, 4};
            isWinner =true;
        }

        int boardFilled = 0;
        for(int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                if (gameBoard[r][c] != 0){
                    boardFilled += 1;
                }
            }
        }

        if (isWinner){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((names[player-1] + " Won!!"));
            return true;
        }
        else if(boardFilled == 9){
            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText("Tie Game!!!!!!!!");
            return true;
        }
        else{
            return false;
        }
    }

    public void resetGame(){
        for(int r = 0; r< 3; r++){
            for(int c = 0; c<3; c++){
                gameBoard[r][c] = 0;
            }
        }
        player =1;
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
        winType = new int[]{-1, -1, -1};
        playerTurn.setText((names[0] + "'s turn"));
    }

    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;
    }

    public void setHomeBTN(Button homeBTN) {
        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
