
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Snake_and_Ladder {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random random = new Random();   
		
		System.out.print("\n\n                  Start the Game Snake & Ladder\n                  =============================\n\n\nTotal players: ");
		int t_player=sc.nextInt();
		String players[]= new String[t_player];
		sc.nextLine();
		for(int i=0;i<t_player;i++)
		{
			System.out.print("Enter player "+(i+1)+" :");
			String nm=sc.nextLine();
			players[i]=nm;
		}
		
//		int dices[]= {1,4,5,2,4,2,3,5,2,3,5,4,4,6,1,6,6,4,1,5,4,6,4,3,2,1,2,2};
		HashMap<Integer,Integer> ladder=new HashMap<>();
		HashMap<Integer,Integer> snake=new HashMap<>();
		HashMap<String,ArrayList<Integer>> score=new HashMap<>();
		ladder.put(8, 28);
		ladder.put(15, 27);
		ladder.put(20, 31);
		ladder.put(23, 34);
		snake.put(16, 5);
		snake.put(24, 3);
		snake.put(32, 7);
		snake.put(35, 11);
		
		for(int i=0;i<players.length;i++)
		{
			System.out.println("\n"+(i+1)+"."+players[i]);
		}
		System.out.println("\nwho starts the game= ");
		int start=sc.nextInt()-1;
		int ck=0;
//		ArrayList<Integer> temp=new ArrayList<>();
		String ord_players[]=new String[players.length];
		for(int i=start;i<players.length;i++)
		{
			score.put(players[i], new ArrayList<Integer>(Arrays.asList(0,0,0,0)));
			ord_players[ck++]=players[i];
			if(i==players.length-1)
			{
				i=-1;
			}
			if(ck==players.length)
			{
				break;
			}
		}
		if(ord_players.length>2)
		System.out.println("This is the order of game -> "+Arrays.toString(ord_players));
		int maintain_player_order=0;
		boolean flag=true;
		for(;;)
		{
			if(maintain_player_order==ord_players.length)
			{
				maintain_player_order=0;
			}
			String name=ord_players[maintain_player_order];
			if(flag)
			{
				System.out.println("\n"+name+" start the game!... \nEnter a 'Enter button' to roll the dice: ");
				sc.nextLine();
				flag=false;
			}
			else
			System.out.print("\n"+name+" it's your turn and Now you are in "+score.get(name).get(0)+"\nEnter a dice value: ");
			int dice=0;
			if(sc.nextLine()=="")
			{
				dice=ThreadLocalRandom
			            .current()
			            .nextInt(1, 6 + 1);
				System.out.print(dice+" ");
			}
			else
			{
				System.out.println("Enter the 'Enter button' correctly...");
				continue;
			}
			if(dice==1 || dice==5)
			{
				ArrayList<Integer> tem=new ArrayList<>(score.get(name));
				if(tem.get(0)+dice<=36)
				{
					tem.set(0, tem.get(0)+dice);
					if(tem.get(0)==36)
					{
						tem.set(3, tem.get(3)+1);
						score.put(name, tem);
						System.out.println(score+"\n\n"+"congrates "+name+" you won the game......\n");
						break;
					}
					for(int j=0;j<ord_players.length;j++)
					{
						if(j!=maintain_player_order && tem.get(0)==score.get(ord_players[j]).get(0))
						{
							ArrayList<Integer> set=new ArrayList<>(score.get(ord_players[j]));
							set.set(0,0);
							score.put(ord_players[j], set);
							System.out.println(name+" killed "+ord_players[j]+"\nNow "+ord_players[j]+" restarts the game...");
						}
					}
					if(ladder.containsKey(tem.get(0)))
					{
						tem.set(0,ladder.get(tem.get(0)));
						tem.set(1,tem.get(1)+1);
						System.out.println(name +" used the ladder and moved to "+tem.get(0)+"th place....");
					}
					else if(snake.containsKey(tem.get(0)))
					{
						tem.set(0,snake.get(tem.get(0)));
						tem.set(2,tem.get(2)+1);
						System.out.println(name +" killed by snake,so moved to "+tem.get(0)+"th place....");
					}
					System.out.println(name+" now your place is "+tem.get(0));
				}
				score.put(name, tem);
			}
			else
			{
				ArrayList<Integer> tem=new ArrayList<>(score.get(name));
				if(tem.get(0)+dice<=36)
				{
					tem.set(0, tem.get(0)+dice);
					if(tem.get(0)==36)
					{
						tem.set(3, tem.get(3)+1);
						score.put(name, tem);
						System.out.println(score+"\n\n"+"congrates "+name+" you won the game......\n");
						break;
					}
					for(int j=0;j<ord_players.length;j++)
					{
						if(j!=maintain_player_order &&tem.get(0)==score.get(ord_players[j]).get(0))
						{
							ArrayList<Integer> set=new ArrayList<>(score.get(ord_players[j]));
							set.set(0,0);
							score.put(ord_players[j], set);
							System.out.println(name+" killed "+ord_players[j]+"\nNow "+ord_players[j]+" restarts the game...");
						}
					}
					if(ladder.containsKey(tem.get(0)))
					{
						tem.set(0,ladder.get(tem.get(0)));
						tem.set(1,tem.get(1)+1);
						System.out.println(name +" used the ladder and moved to "+tem.get(0)+"th place....");
					}
					else if(snake.containsKey(tem.get(0)))
					{
						tem.set(0,snake.get(tem.get(0)));
						tem.set(2,tem.get(2)+1);
						System.out.println(name +" killed by snake,so moved to "+tem.get(0)+"th place....");
					}
					System.out.println(name+" now your place is "+tem.get(0));
				}
				score.put(name, tem);
				maintain_player_order++;
			}
//			System.out.println(score+"\n");
		}
		
		
	}

}
