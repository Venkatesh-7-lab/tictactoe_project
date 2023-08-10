import java.util.*;
import java.io.*;
class twoplayers_tictactoe
{
    static HashSet<Integer> ur_set=new HashSet<Integer>(); 
    static HashSet<Integer> comp_set=new HashSet<Integer>();
    public static void main(String args[])
    {

        char [][]b={
            {' ','|',' ','|',' '},
            {'-','|','-','|','-'},
            {' ','|',' ','|',' '},
            {'-','|','-','|','-'},
            {' ','|',' ','|',' '},
        };
        print_board(b);
        Scanner sc=new Scanner(System.in);
        while(true) 
        {
            System.out.print("Enter number player1 from 1 to 9:");
            int user_pos=sc.nextInt(); 
            while(ur_set.contains(user_pos)||comp_set.contains(user_pos)) 
            {
                System.out.println();
                System.out.print("Retry, Enter number from 1 to 9:");
                user_pos=sc.nextInt();    
            }
            place_holder(b,user_pos,"YOU"); 
            String res=check_winner(); 
            if(res.length()>0) {
                System.out.println(res);
                break;
            }

            System.out.print("Enter number player2 from 1 to 9:");
            int comp_pos=sc.nextInt(); 
            while(ur_set.contains(comp_pos)||comp_set.contains(comp_pos)) 
            {
                System.out.println();
                System.out.print("Retry, Enter number player2 from 1 to 9:");
                comp_pos=sc.nextInt();    
            }
            place_holder(b,comp_pos,"COMP"); 
            res=check_winner(); 
            if(res.length()>0) {
                System.out.println(res);
                break;
            }
        }
    } 
    static String check_winner() {
        HashSet<Integer> r1=new HashSet<Integer>(); 
        r1.add(1);r1.add(2);r1.add(3); 
        HashSet<Integer> r2=new HashSet<Integer>(); 
        r2.add(4);r2.add(5);r2.add(6); 
        HashSet<Integer> r3=new HashSet<Integer>(); 
        r3.add(7);r3.add(8);r3.add(9);
        HashSet<Integer> c1=new HashSet<Integer>(); 
        c1.add(1);c1.add(4);c1.add(7); 
        HashSet<Integer> c2=new HashSet<Integer>();
        c2.add(2);c2.add(5);c2.add(8); 
        HashSet<Integer> c3=new HashSet<Integer>(); 
        c3.add(3);c3.add(6);c3.add(9); 
        HashSet<Integer> d1=new HashSet<Integer>(); 
        d1.add(1);d1.add(5);d1.add(9); 
        HashSet<Integer> d2=new HashSet<Integer>(); 
        d2.add(3);d2.add(5);d2.add(7); 
        HashSet<HashSet> set=new HashSet<HashSet>(); 
        set.add(r1);set.add(r2);set.add(r3); 
        set.add(c1);set.add(c2);set.add(c3); 
        set.add(d1);set.add(d2);
        for(HashSet c:set) 
        {
            if(ur_set.containsAll(c)) 
            {
                return "YOU WON"; 
            }
            else if(comp_set.containsAll(c)) 
            {
                return "YOU LOST";
            }
        } 
        if(ur_set.size()+comp_set.size()==9) 
            return "DRAW"; 
        return "";
    }
    /* static int gen_random() 
    {
        int max=9; 
        int min=1; 
        int range=max-min+1; 
        int res=(int)((Math.random()*range)+min);
        return res;
    } */
    static void print_board(char [][]b) 
    {
        for(int i=0;i<b.length;i++) 
        {
            for(int j=0;j<b[0].length;j++) 
            {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    } 
    static void place_holder(char [][]b,int pos,String usr) 
    {
        char sym='V'; 
        if(usr.equals("YOU")) 
        {
            sym='V';
            ur_set.add(pos);
        } 
        else if(usr.equals("COMP")) 
        {
            sym='S'; 
            comp_set.add(pos);
        } 
        switch(pos) 
        {
            case 1:b[0][0]=sym;break;
            case 2:b[0][2]=sym;break;
            case 3:b[0][4]=sym;break;
            case 4:b[2][0]=sym;break;
            case 5:b[2][2]=sym;break;
            case 6:b[2][4]=sym;break;
            case 7:b[4][0]=sym;break;
            case 8:b[4][2]=sym;break;
            case 9:b[4][4]=sym;break;
        }
        print_board(b);
    }
}