
package chess;

import java.util.Scanner;

/**
 *
 * @author Nikesh
 */
public class Chess {
static String board[][]=new String[8][8];
    void new_board()
    {
        board[0][0]="E_B_1";
        board[0][1]="H_B_1";
        board[0][2]="B_B_1";
        board[0][3]=" K_B ";
        board[0][4]=" Q_B ";
        board[0][5]="B_B_2";
        board[0][6]="H_B_2";
        board[0][7]="E_B_2";
        board[1][0]="S_B_1";
        board[1][1]="S_B_2";
        board[1][2]="S_B_3";
        board[1][3]="S_B_4";
        board[1][4]="S_B_5";
        board[1][5]="S_B_6";
        board[1][6]="S_B_7";
        board[1][7]="S_B_8";
        //Give a break
        board[7][0]="E_W_1";
        board[7][1]="H_W_1";
        board[7][2]="B_W_1";
        board[7][3]=" Q_W ";
        board[7][4]=" K_W ";
        board[7][5]="B_W_2";
        board[7][6]="H_W_2";
        board[7][7]="E_W_2";
        board[6][0]="S_W_1";
        board[6][1]="S_W_2";
        board[6][2]="S_W_3";
        board[6][3]="S_W_4";
        board[6][4]="S_W_5";
        board[6][5]="S_W_6";
        board[6][6]="S_W_7";
        board[6][7]="S_W_8";
        for(int i=2;i<=5;i++)
        {
            for(int j=0;j<=7;j++)
            {
                board[i][j]="     ";
            }
        }
    }
    void disp()
    {
        System.out.println("\t |  0     |   1    |    2   |    3   |    4   |    5   |    6   |    7  |");
        System.out.print(" _________________________________________________________________________________\n");
        for(int i=0;i<=7;i++)
        {   
            System.out.println("\t");
            System.out.print("|    "+i);
            System.out.print("\t");
            for(int j=0;j<=7;j++)
            {
                System.out.print(" | "+board[i][j]+" ");
            }
            System.out.print("|");
            System.out.print("\n _________________________________________________________________________________ ");
            System.out.print("\t\n");
        }
    }
    public static void main(String[] args) {
       Chess obj=new Chess();
       obj.new_board();
       obj.disp();
       int opt;
        Scanner sc=new Scanner(System.in);
        System.out.println("NOTE : \nPlayer 1 -> Black(TOP)\nPlayer 2 -> White(BOTTOM)");
        System.out.println("1 -> Player 1 starts the game\n2 -> Player 2 starts the game");
        System.out.println("Waiting for the input.... ");
        opt=sc.nextInt();
        switch(opt)
        {
            case 1 : obj.pl1_play();
                break;
            case 2:  obj.pl2_play();
                break;
        }
        
        
    }
    int chk_mate()
    {
        int flag=0;
        for(int i=0;i<=7;i++)
        {
            for(int j=0;j<=7;j++)
            {
                if(board[i][j]==" K_W "&&board[i][j]!=" K_B ")
                {
                flag++;
                }
                else if(board[i][j]!=" K_W "&&board[i][j]==" K_B ")
                {
                flag--;
                }
            }
            
        }
        if(flag==1)
            {
                return 1;
            }
            else if(flag==-1)
            {
                return -1;
            }
    return 0;
    }
    void pl1_play()
    {   
        Chess obj_pl1=new Chess();
        int chk=obj_pl1.chk_mate();
        if(chk==1)
        {
            System.out.println("\n\n\t\t\t\tPlayer 2 Wins");
            System.exit(1);
        }
        else if(chk==-1)
        {
            System.out.println("\n\n\t\t\t\tPlayer 1 Wins");
            System.exit(1);
        }
        else if(chk==0)
        {
        System.out.println("PLAYER 1 <><><><><><><><><>");
        int row_pl1,clmn_pl1,row_pl1_des,clmn_pl1_des;
        Scanner sc_pl1=new Scanner(System.in);
        System.out.println("Enter the row : "); 
        row_pl1=sc_pl1.nextInt();
        System.out.println("Enter the column : "); 
        clmn_pl1=sc_pl1.nextInt();
        System.out.println(row_pl1+" row AND "+clmn_pl1+" column SELECTED");
        System.out.println("Enter the row to be placed in : "); 
        row_pl1_des=sc_pl1.nextInt();
        System.out.println("Enter the column to be placed in : "); 
        clmn_pl1_des=sc_pl1.nextInt();
        if(board[row_pl1][clmn_pl1]=="S_B_1"||board[row_pl1][clmn_pl1]=="S_B_2"||board[row_pl1][clmn_pl1]=="S_B_3"||board[row_pl1][clmn_pl1]=="S_B_4"||board[row_pl1][clmn_pl1]=="S_B_5"||board[row_pl1][clmn_pl1]=="S_B_6"||board[row_pl1][clmn_pl1]=="S_B_7"||board[row_pl1][clmn_pl1]=="S_B_8")
        {
            obj_pl1.sb1_chk(row_pl1,row_pl1_des,clmn_pl1,clmn_pl1_des);
        }
        else if(board[row_pl1][clmn_pl1]=="E_B_1"||board[row_pl1][clmn_pl1]=="E_B_2")
        {
            obj_pl1.eb1_chk(row_pl1,row_pl1_des,clmn_pl1,clmn_pl1_des);
        }
        else if(board[row_pl1][clmn_pl1]=="H_B_1"||board[row_pl1][clmn_pl1]=="H_B_2")
        {
            obj_pl1.hb1_chk(row_pl1,row_pl1_des,clmn_pl1,clmn_pl1_des);
        }
        else if(board[row_pl1][clmn_pl1]=="B_B_1"||board[row_pl1][clmn_pl1]=="B_B_2")
        {
            obj_pl1.bb1_chk(row_pl1,row_pl1_des,clmn_pl1,clmn_pl1_des);
        }
        else if(board[row_pl1][clmn_pl1]==" Q_B ")
        {
            obj_pl1.qn1_chk(row_pl1,row_pl1_des,clmn_pl1,clmn_pl1_des);
        }
        else if(board[row_pl1][clmn_pl1]==" K_B ")
        {
            obj_pl1.k1_chk(row_pl1,row_pl1_des,clmn_pl1,clmn_pl1_des);
        }
        }
    }
    void k1_chk(int row_pl1,int row_pl1_des,int clmn_pl1,int clmn_pl1_des)
    {
        Chess obj_k1_chk=new Chess();
        if((row_pl1_des==row_pl1&&clmn_pl1_des==clmn_pl1+1)||(row_pl1_des==row_pl1+1&&clmn_pl1_des==clmn_pl1+1)||(row_pl1_des==row_pl1+1&&clmn_pl1_des==clmn_pl1)||(row_pl1_des==row_pl1+1&&clmn_pl1_des==clmn_pl1-1)||(row_pl1_des==row_pl1&&clmn_pl1_des==clmn_pl1-1)||(row_pl1_des==row_pl1-1&&clmn_pl1_des==clmn_pl1-1)||(row_pl1_des==row_pl1-1&&clmn_pl1_des==clmn_pl1)||(row_pl1_des==row_pl1-1&&clmn_pl1_des==clmn_pl1+1))
        {
           board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_k1_chk.remove(row_pl1, clmn_pl1);
                  obj_k1_chk.disp();
                  obj_k1_chk.pl2_play(); 
        }
        else
        {
                  System.out.println("Wrong Move");
                  System.exit(1);
        }
    }
    void qn1_chk(int row_pl1,int row_pl1_des,int clmn_pl1,int clmn_pl1_des)
    {
        Chess obj_qn1_chk=new Chess();
        int flag=0,i,j;
          if(row_pl1_des>row_pl1&&clmn_pl1_des>clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i<=row_pl1_des&&j<=clmn_pl1_des;i++,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1_des-row_pl1)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else if(flag!=row_pl1_des-row_pl1&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des<row_pl1&&clmn_pl1_des<clmn_pl1)
          {
              for(i=row_pl1_des,j=clmn_pl1_des;i<=row_pl1&&j<=clmn_pl1;i++,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else if(flag!=row_pl1-row_pl1_des&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des<row_pl1&&clmn_pl1_des>clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i>=row_pl1_des&&j<=clmn_pl1_des;i--,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else if(flag!=row_pl1-row_pl1_des&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des>row_pl1&&clmn_pl1_des<clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i<=row_pl1_des&&j>=clmn_pl1_des;i++,j--)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1_des-row_pl1)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else if(flag!=row_pl1_des-row_pl1&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1==row_pl1_des)
        {
            
            if(clmn_pl1_des>clmn_pl1)
            {
             for(i=clmn_pl1;i<=clmn_pl1_des;i++)
            {
              if(board[row_pl1][i]=="     ")
              {
                  flag++;
              }
            }
            }
            else if(clmn_pl1>clmn_pl1_des)
            {
              for(i=clmn_pl1_des;i<=clmn_pl1;i++)
             {
              if(board[row_pl1][i]=="     ")
              {
                  flag++;
              }
             }  
            }
            
              if(flag==clmn_pl1_des-clmn_pl1||flag==clmn_pl1-clmn_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]=="     ")
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          
        }
        else if(clmn_pl1==clmn_pl1_des)
        {
            if(row_pl1_des>row_pl1)
            {
            for(i=row_pl1;i<=row_pl1_des;i++)
            {
                if(board[i][clmn_pl1]=="     ")
              {
                  flag++;
              }
            }  
            }
            else if(row_pl1>row_pl1_des)
            {
              for(i=row_pl1_des;i<=row_pl1;i++)
            {
                if(board[i][clmn_pl1]=="     ")
              {
                  flag++;
              }
            }  
            }
              if(flag==row_pl1_des-row_pl1||flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]=="     ")
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
              else if((flag!=row_pl1_des-row_pl1||flag!=row_pl1-row_pl1_des)&& board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
            
        }
        else
        {
            System.out.println("Wrong Move");
            System.exit(1);
        }
          
    }
    void bb1_chk(int row_pl1,int row_pl1_des,int clmn_pl1,int clmn_pl1_des)  
    {
        Chess obj_bb1_chk=new Chess();
        if((row_pl1_des-row_pl1==clmn_pl1_des-clmn_pl1)||(row_pl1_des-row_pl1==clmn_pl1-clmn_pl1_des)||(row_pl1-row_pl1_des==clmn_pl1_des-clmn_pl1)||(row_pl1-row_pl1_des==clmn_pl1-clmn_pl1_des))
        {
            int flag=0,i,j;
          if(row_pl1_des>row_pl1&&clmn_pl1_des>clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i<=row_pl1_des&&j<=clmn_pl1_des;i++,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1_des-row_pl1)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_bb1_chk.remove(row_pl1, clmn_pl1);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl2_play();
              }
              else if(flag!=row_pl1_des-row_pl1&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_bb1_chk.remove(row_pl1, clmn_pl1);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des<row_pl1&&clmn_pl1_des<clmn_pl1)
          {
              for(i=row_pl1_des,j=clmn_pl1_des;i<=row_pl1&&j<=clmn_pl1;i++,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_bb1_chk.remove(row_pl1, clmn_pl1);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl2_play();
              }
              else if(flag!=row_pl1-row_pl1_des&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_bb1_chk.remove(row_pl1, clmn_pl1);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des<row_pl1&&clmn_pl1_des>clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i>=row_pl1_des&&j<=clmn_pl1_des;i--,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_bb1_chk.remove(row_pl1, clmn_pl1);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl2_play();
              }
              else if(flag!=row_pl1-row_pl1_des&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_bb1_chk.remove(row_pl1, clmn_pl1);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des>row_pl1&&clmn_pl1_des<clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i<=row_pl1_des&&j>=clmn_pl1_des;i++,j--)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1_des-row_pl1)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_bb1_chk.remove(row_pl1, clmn_pl1);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl2_play();
              }
              else if(flag!=row_pl1_des-row_pl1&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_bb1_chk.remove(row_pl1, clmn_pl1);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          
          
        }
    }
    void hb1_chk(int row_pl1,int row_pl1_des,int clmn_pl1,int clmn_pl1_des)
    {
        Chess obj_hb1_chk=new Chess();
        if((row_pl1_des==row_pl1-1 && clmn_pl1_des==clmn_pl1+2)||(row_pl1_des==row_pl1-2 && clmn_pl1_des==clmn_pl1+1)||(row_pl1_des==row_pl1-2 && clmn_pl1_des==clmn_pl1-1)||(row_pl1_des==row_pl1-1 && clmn_pl1_des==clmn_pl1-2)||(row_pl1_des==row_pl1+1 && clmn_pl1_des==clmn_pl1-2)||(row_pl1_des==row_pl1+1 && clmn_pl1_des==clmn_pl1+2)||(row_pl1_des==row_pl1+2 && clmn_pl1_des==clmn_pl1-1)||(row_pl1_des==row_pl1+2 && clmn_pl1_des==clmn_pl1+1))
        {
            board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_hb1_chk.remove(row_pl1, clmn_pl1);
                  obj_hb1_chk.disp();
                  obj_hb1_chk.pl2_play();  
        }
        else
        {
            System.out.println("Wrong Move");
            System.exit(1);
        }
    }
    void eb1_chk(int row_pl1,int row_pl1_des,int clmn_pl1,int clmn_pl1_des)
    {
        Chess obj_eb1_chk=new Chess();
        if(row_pl1==row_pl1_des)
        {
            int flag=0;
            if(clmn_pl1_des>clmn_pl1)
            {
             for(int i=clmn_pl1;i<=clmn_pl1_des;i++)
            {
              if(board[row_pl1][i]=="     ")
              {
                  flag++;
              }
            }
            }
            else if(clmn_pl1>clmn_pl1_des)
            {
              for(int i=clmn_pl1_des;i<=clmn_pl1;i++)
             {
              if(board[row_pl1][i]=="     ")
              {
                  flag++;
              }
             }  
            }
            
              if(flag==clmn_pl1_des-clmn_pl1||flag==clmn_pl1-clmn_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_eb1_chk.remove(row_pl1, clmn_pl1);
                  obj_eb1_chk.disp();
                  obj_eb1_chk.pl2_play();
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]=="     ")
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_eb1_chk.remove(row_pl1, clmn_pl1);
                  obj_eb1_chk.disp();
                  obj_eb1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          
        }
        else if(clmn_pl1==clmn_pl1_des)
        {
            int flag=0;
            if(row_pl1_des>row_pl1)
            {
            for(int i=row_pl1;i<=row_pl1_des;i++)
            {
                if(board[i][clmn_pl1]=="     ")
              {
                  flag++;
              }
            }  
            }
            else if(row_pl1>row_pl1_des)
            {
              for(int i=row_pl1_des;i<=row_pl1;i++)
            {
                if(board[i][clmn_pl1]=="     ")
              {
                  flag++;
              }
            }  
            }
              if(flag==row_pl1_des-row_pl1||flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_eb1_chk.remove(row_pl1, clmn_pl1);
                  obj_eb1_chk.disp();
                  obj_eb1_chk.pl2_play();
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]=="     ")
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
              else if((flag!=row_pl1_des-row_pl1||flag!=row_pl1-row_pl1_des)&& board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_eb1_chk.remove(row_pl1, clmn_pl1);
                  obj_eb1_chk.disp();
                  obj_eb1_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
            
        }
        else
        {
            System.out.println("Wrong Move");
            System.exit(1);
        }
    }
    void sb1_chk(int row_pl1,int row_pl1_des,int clmn_pl1,int clmn_pl1_des)
    {
        Chess obj_sb1_chk=new Chess();
        if((row_pl1==1)&&(row_pl1_des==(row_pl1+1)||row_pl1_des==(row_pl1+2))&&(clmn_pl1_des==clmn_pl1))
        {
            board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
        }
        else if((row_pl1_des==(row_pl1+1))&&(clmn_pl1_des==clmn_pl1))
        {
            
            if(board[row_pl1_des][clmn_pl1_des]=="S_B_1"||board[row_pl1_des][clmn_pl1_des]=="S_B_2"||board[row_pl1_des][clmn_pl1_des]=="S_B_3"||board[row_pl1_des][clmn_pl1_des]=="S_B_4"||board[row_pl1_des][clmn_pl1_des]=="S_B_5"||board[row_pl1_des][clmn_pl1_des]=="S_B_6"||board[row_pl1_des][clmn_pl1_des]=="S_B_7"||board[row_pl1_des][clmn_pl1_des]=="S_B_8")
            {
                System.out.println("Sorry.U killed your own player.");
                System.exit(1);
            }
            else if(board[row_pl1_des][clmn_pl1_des]!=null)
            {
            board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
            }
            else
            {
                System.out.println("Wrong Move");
                System.exit(1);
            }
        }
        else if((((row_pl1_des==row_pl1+1)&&(clmn_pl1_des==clmn_pl1+1))||((row_pl1_des==row_pl1+1)&&(clmn_pl1_des==clmn_pl1-1)))&&board[row_pl1_des][clmn_pl1_des]!="     ")
        {
            board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
        }
        else
        {
            System.out.println("Wrong Move");
            System.exit(1);
        }
        obj_sb1_chk.remove(row_pl1, clmn_pl1);
        obj_sb1_chk.disp();
        obj_sb1_chk.pl2_play();
    }
    void remove(int row_pl,int clmn_pl)
    {
        board[row_pl][clmn_pl]="     ";
    }
    
    //player 2 
    
    void pl2_play()
    {   
        Chess obj_pl2=new Chess();
        int chk=obj_pl2.chk_mate();
        if(chk==1)
        {
            System.out.println("\t\tPlayer 2 Wins");
            System.exit(1);
        }
        else if(chk==-1)
        {
            System.out.println("\t\tPlayer 1 Wins");
            System.exit(1);
        }
        else if(chk==0)
        {
        System.out.println("PLAYER 2 <><><><><><><><><>");
        int row_pl2,clmn_pl2,row_pl2_des,clmn_pl2_des;
        Scanner sc_pl2=new Scanner(System.in);
        System.out.println("Enter the row : "); 
        row_pl2=sc_pl2.nextInt();
        System.out.println("Enter the column : "); 
        clmn_pl2=sc_pl2.nextInt();
        System.out.println(row_pl2+" row AND "+clmn_pl2+" column SELECTED");
        System.out.println("Enter the row to be placed in : "); 
        row_pl2_des=sc_pl2.nextInt();
        System.out.println("Enter the column to be placed in : "); 
        clmn_pl2_des=sc_pl2.nextInt();
        if(board[row_pl2][clmn_pl2]=="S_W_1"||board[row_pl2][clmn_pl2]=="S_W_2"||board[row_pl2][clmn_pl2]=="S_W_3"||board[row_pl2][clmn_pl2]=="S_W_4"||board[row_pl2][clmn_pl2]=="S_W_5"||board[row_pl2][clmn_pl2]=="S_W_6"||board[row_pl2][clmn_pl2]=="S_W_7"||board[row_pl2][clmn_pl2]=="S_W_8")
        {
           obj_pl2.sb2_chk(row_pl2,row_pl2_des,clmn_pl2,clmn_pl2_des);
        }
        else if(board[row_pl2][clmn_pl2]=="E_W_1"||board[row_pl2][clmn_pl2]=="E_W_2")
        {
            obj_pl2.eb2_chk(row_pl2,row_pl2_des,clmn_pl2,clmn_pl2_des);
        }
        else if(board[row_pl2][clmn_pl2]=="H_W_1"||board[row_pl2][clmn_pl2]=="H_W_2")
        {
            obj_pl2.hb2_chk(row_pl2, row_pl2_des, clmn_pl2, clmn_pl2_des);
        }
        else if(board[row_pl2][clmn_pl2]=="B_W_1"||board[row_pl2][clmn_pl2]=="B_W_2")
        {
            obj_pl2.bb1_chk(row_pl2,row_pl2_des,clmn_pl2,clmn_pl2_des);
        }
        else if(board[row_pl2][clmn_pl2]==" Q_W ")
        {
            obj_pl2.qn2_chk(row_pl2,row_pl2_des,clmn_pl2,clmn_pl2_des);
        }
        else if(board[row_pl2][clmn_pl2]==" K_W ")
        {
            obj_pl2.k2_chk(row_pl2,row_pl2_des,clmn_pl2,clmn_pl2_des);
        }
        }
    }
    void k2_chk(int row_pl1,int row_pl1_des,int clmn_pl1,int clmn_pl1_des)
    {
        Chess obj_k1_chk=new Chess();
        if((row_pl1_des==row_pl1&&clmn_pl1_des==clmn_pl1+1)||(row_pl1_des==row_pl1+1&&clmn_pl1_des==clmn_pl1+1)||(row_pl1_des==row_pl1+1&&clmn_pl1_des==clmn_pl1)||(row_pl1_des==row_pl1+1&&clmn_pl1_des==clmn_pl1-1)||(row_pl1_des==row_pl1&&clmn_pl1_des==clmn_pl1-1)||(row_pl1_des==row_pl1-1&&clmn_pl1_des==clmn_pl1-1)||(row_pl1_des==row_pl1-1&&clmn_pl1_des==clmn_pl1)||(row_pl1_des==row_pl1-1&&clmn_pl1_des==clmn_pl1+1))
        {
           board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_k1_chk.remove(row_pl1, clmn_pl1);
                  obj_k1_chk.disp();
                  obj_k1_chk.pl1_play(); 
        }
        else
        {
                  System.out.println("Wrong Move");
                  System.exit(1);
        }
    }
    void qn2_chk(int row_pl1,int row_pl1_des,int clmn_pl1,int clmn_pl1_des)
    {
        Chess obj_qn1_chk=new Chess();
        int flag=0,i,j;
          if(row_pl1_des>row_pl1&&clmn_pl1_des>clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i<=row_pl1_des&&j<=clmn_pl1_des;i++,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1_des-row_pl1)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else if(flag!=row_pl1_des-row_pl1&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des<row_pl1&&clmn_pl1_des<clmn_pl1)
          {
              for(i=row_pl1_des,j=clmn_pl1_des;i<=row_pl1&&j<=clmn_pl1;i++,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else if(flag!=row_pl1-row_pl1_des&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des<row_pl1&&clmn_pl1_des>clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i>=row_pl1_des&&j<=clmn_pl1_des;i--,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else if(flag!=row_pl1-row_pl1_des&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1_des>row_pl1&&clmn_pl1_des<clmn_pl1)
          {
              for(i=row_pl1,j=clmn_pl1;i<=row_pl1_des&&j>=clmn_pl1_des;i++,j--)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl1_des-row_pl1)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else if(flag!=row_pl1_des-row_pl1&&board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl1==row_pl1_des)
        {
            
            if(clmn_pl1_des>clmn_pl1)
            {
             for(i=clmn_pl1;i<=clmn_pl1_des;i++)
            {
              if(board[row_pl1][i]=="     ")
              {
                  flag++;
              }
            }
            }
            else if(clmn_pl1>clmn_pl1_des)
            {
              for(i=clmn_pl1_des;i<=clmn_pl1;i++)
             {
              if(board[row_pl1][i]=="     ")
              {
                  flag++;
              }
             }  
            }
            
              if(flag==clmn_pl1_des-clmn_pl1||flag==clmn_pl1-clmn_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]=="     ")
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          
        }
        else if(clmn_pl1==clmn_pl1_des)
        {
            if(row_pl1_des>row_pl1)
            {
            for(i=row_pl1;i<=row_pl1_des;i++)
            {
                if(board[i][clmn_pl1]=="     ")
              {
                  flag++;
              }
            }  
            }
            else if(row_pl1>row_pl1_des)
            {
              for(i=row_pl1_des;i<=row_pl1;i++)
            {
                if(board[i][clmn_pl1]=="     ")
              {
                  flag++;
              }
            }  
            }
              if(flag==row_pl1_des-row_pl1||flag==row_pl1-row_pl1_des)
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else if((flag!=clmn_pl1_des-clmn_pl1||flag!=clmn_pl1-clmn_pl1_des)&& board[row_pl1_des][clmn_pl1_des]=="     ")
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
              else if((flag!=row_pl1_des-row_pl1||flag!=row_pl1-row_pl1_des)&& board[row_pl1_des][clmn_pl1_des]!="     ")
              {
                  board[row_pl1_des][clmn_pl1_des]=board[row_pl1][clmn_pl1];
                  obj_qn1_chk.remove(row_pl1, clmn_pl1);
                  obj_qn1_chk.disp();
                  obj_qn1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
            
        }
        else
        {
            System.out.println("Wrong Move");
            System.exit(1);
        }
          
    }
    void bb2_chk(int row_pl2,int row_pl2_des,int clmn_pl2,int clmn_pl2_des)  
    {
        Chess obj_bb1_chk=new Chess();
        if((row_pl2_des-row_pl2==clmn_pl2_des-clmn_pl2)||(row_pl2_des-row_pl2==clmn_pl2-clmn_pl2_des)||(row_pl2-row_pl2_des==clmn_pl2_des-clmn_pl2)||(row_pl2-row_pl2_des==clmn_pl2-clmn_pl2_des))
        {
            int flag=0,i,j;
          if(row_pl2_des>row_pl2&&clmn_pl2_des>clmn_pl2)
          {
              for(i=row_pl2,j=clmn_pl2;i<=row_pl2_des&&j<=clmn_pl2_des;i++,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl2_des-row_pl2)
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_bb1_chk.remove(row_pl2, clmn_pl2);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl1_play();
              }
              else if(flag!=row_pl2_des-row_pl2&&board[row_pl2_des][clmn_pl2_des]!="     ")
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_bb1_chk.remove(row_pl2, clmn_pl2);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl2_des<row_pl2&&clmn_pl2_des<clmn_pl2)
          {
              for(i=row_pl2_des,j=clmn_pl2_des;i<=row_pl2&&j<=clmn_pl2;i++,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl2-row_pl2_des)
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_bb1_chk.remove(row_pl2, clmn_pl2);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl1_play();
              }
              else if(flag!=row_pl2-row_pl2_des&&board[row_pl2_des][clmn_pl2_des]!="     ")
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_bb1_chk.remove(row_pl2, clmn_pl2);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl2_des<row_pl2&&clmn_pl2_des>clmn_pl2)
          {
              for(i=row_pl2,j=clmn_pl2;i>=row_pl2_des&&j<=clmn_pl2_des;i--,j++)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl2-row_pl2_des)
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_bb1_chk.remove(row_pl2, clmn_pl2);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl1_play();
              }
              else if(flag!=row_pl2-row_pl2_des&&board[row_pl2_des][clmn_pl2_des]!="     ")
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_bb1_chk.remove(row_pl2, clmn_pl2);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          else if(row_pl2_des>row_pl2&&clmn_pl2_des<clmn_pl2)
          {
              for(i=row_pl2,j=clmn_pl2;i<=row_pl2_des&&j>=clmn_pl2_des;i++,j--)
              {
                  if(board[i][j]=="     ")
                  {
                      flag++;
                  }
              }
              if(flag==row_pl2_des-row_pl2)
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_bb1_chk.remove(row_pl2, clmn_pl2);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl1_play();
              }
              else if(flag!=row_pl2_des-row_pl2&&board[row_pl2_des][clmn_pl2_des]!="     ")
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_bb1_chk.remove(row_pl2, clmn_pl2);
                  obj_bb1_chk.disp();
                  obj_bb1_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          }
          
          
        }
    }
    void hb2_chk(int row_pl2,int row_pl2_des,int clmn_pl2,int clmn_pl2_des)
    {
        Chess obj_hb2_chk=new Chess();
        if((row_pl2_des==row_pl2-1 && clmn_pl2_des==clmn_pl2+2)||(row_pl2_des==row_pl2-2 && clmn_pl2_des==clmn_pl2+1)||(row_pl2_des==row_pl2-2 && clmn_pl2_des==clmn_pl2-1)||(row_pl2_des==row_pl2-1 && clmn_pl2_des==clmn_pl2-2)||(row_pl2_des==row_pl2+1 && clmn_pl2_des==clmn_pl2-2)||(row_pl2_des==row_pl2+1 && clmn_pl2_des==clmn_pl2+2)||(row_pl2_des==row_pl2+2 && clmn_pl2_des==clmn_pl2-1)||(row_pl2_des==row_pl2+2 && clmn_pl2_des==clmn_pl2+1))
        {
            board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_hb2_chk.remove(row_pl2, clmn_pl2);
                  obj_hb2_chk.disp();
                  obj_hb2_chk.pl1_play();  
        }
        else
        {
            System.out.println("Wrong Move");
            System.exit(1);
        }
    }
    void eb2_chk(int row_pl2,int row_pl2_des,int clmn_pl2,int clmn_pl2_des)
    {
        Chess obj_eb2_chk=new Chess();
        if(row_pl2==row_pl2_des)
        {
            int flag=0;
            if(clmn_pl2_des>clmn_pl2)
            {
             for(int i=clmn_pl2;i<=clmn_pl2_des;i++)
            {
              if(board[row_pl2][i]=="     ")
              {
                  flag++;
              }
            }
            }
            else if(clmn_pl2>clmn_pl2_des)
            {
              for(int i=clmn_pl2_des;i<=clmn_pl2;i++)
             {
              if(board[row_pl2][i]=="     ")
              {
                  flag++;
              }
             }  
            }
            
              if(flag==clmn_pl2_des-clmn_pl2||flag==clmn_pl2-clmn_pl2_des)
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_eb2_chk.remove(row_pl2, clmn_pl2);
                  obj_eb2_chk.disp();
                  obj_eb2_chk.pl2_play();
              }
              else if((flag!=clmn_pl2_des-clmn_pl2||flag!=clmn_pl2-clmn_pl2_des)&& board[row_pl2_des][clmn_pl2_des]=="     ")
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
              else if((flag!=clmn_pl2_des-clmn_pl2||flag!=clmn_pl2-clmn_pl2_des)&& board[row_pl2_des][clmn_pl2_des]!="     ")
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_eb2_chk.remove(row_pl2, clmn_pl2);
                  obj_eb2_chk.disp();
                  obj_eb2_chk.pl2_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
          
        }
        else if(clmn_pl2==clmn_pl2_des)
        {
            int flag=0;
            if(row_pl2_des>row_pl2)
            {
            for(int i=row_pl2;i<=row_pl2_des;i++)
            {
                if(board[i][clmn_pl2]=="     ")
              {
                  flag++;
              }
            }  
            }
            else if(row_pl2>row_pl2_des)
            {
              for(int i=row_pl2_des;i<=row_pl2;i++)
            {
                if(board[i][clmn_pl2]=="     ")
              {
                  flag++;
              }
            }  
            }
              if(flag==row_pl2_des-row_pl2||flag==row_pl2-row_pl2_des)
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_eb2_chk.remove(row_pl2, clmn_pl2);
                  obj_eb2_chk.disp();
                  obj_eb2_chk.pl1_play();
              }
              else if((flag!=clmn_pl2_des-clmn_pl2||flag!=clmn_pl2-clmn_pl2_des)&& board[row_pl2_des][clmn_pl2_des]=="     ")
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
              else if((flag!=row_pl2_des-row_pl2||flag!=row_pl2-row_pl2_des)&& board[row_pl2_des][clmn_pl2_des]!="     ")
              {
                  board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
                  obj_eb2_chk.remove(row_pl2, clmn_pl2);
                  obj_eb2_chk.disp();
                  obj_eb2_chk.pl1_play();
              }
              else
              {
                  System.out.println("Wrong Move");
                  System.exit(1);
              }
            
        }
        else
        {
            System.out.println("Wrong Move");
            System.exit(1);
        }
    }
    void sb2_chk(int row_pl2,int row_pl2_des,int clmn_pl2,int clmn_pl2_des)
    {
        Chess obj_sb2_chk=new Chess();
        if((row_pl2==6)&&(row_pl2_des==(row_pl2-1)||row_pl2_des==(row_pl2-2))&&(clmn_pl2_des==clmn_pl2))
        {
            board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
        }
        else if((row_pl2_des==(row_pl2-1))&&(clmn_pl2_des==clmn_pl2))
        {
            if(board[row_pl2_des][clmn_pl2_des]=="S_W_1"||board[row_pl2_des][clmn_pl2_des]=="S_W_2"||board[row_pl2_des][clmn_pl2_des]=="S_W_3"||board[row_pl2_des][clmn_pl2_des]=="S_W_4"||board[row_pl2_des][clmn_pl2_des]=="S_W_5"||board[row_pl2_des][clmn_pl2_des]=="S_W_6"||board[row_pl2_des][clmn_pl2_des]=="S_W_7"||board[row_pl2_des][clmn_pl2_des]=="S_W_8")
            {
                System.out.println("Sorry.U killed your own player.");
                System.exit(1);
            }
            else if(board[row_pl2_des][clmn_pl2_des]!=null)
            {
            board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
            }
            else
            {
                System.out.println("Wrong Move");
                System.exit(1);
            }
        }
        else if(((row_pl2_des==(row_pl2-1))&&(clmn_pl2_des==clmn_pl2+1))||((row_pl2_des==(row_pl2-1))&&(clmn_pl2_des==clmn_pl2-1)))
        {
            board[row_pl2_des][clmn_pl2_des]=board[row_pl2][clmn_pl2];
        }
        else
        {
            System.out.println("Wrong Move");
            System.exit(1);
        }
        obj_sb2_chk.remove(row_pl2, clmn_pl2);
        obj_sb2_chk.disp();
        obj_sb2_chk.pl1_play();
    }
}
