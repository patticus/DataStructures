/*6.5 Implement a recursive approach to showing all the teams that can be created
from a group (n things taken k at a time). Write the recursive showTeams()
method and a main() method to prompt the user for the group size and the
team size to provide arguments for showTeam(), which then displays all the
possible combinations.*/


import java.io.*; 

public class TeamsApp {
	public static void main(String[] args) throws IOException
	{
		System.out.print("Enter how many players total: "); //Prompts user to enter a number for the groupSize variable
        int totalPlayers = getInt();
        System.out.print("Enter size of team: "); //Prompts user to enter a number for the teamSize variable
        int teamSize = getInt();
        char start = 'A'; //starts the sequence of characters assigned to each team member 
        String team = ""; 
        showTeam(team,start,totalPlayers,teamSize);
    }
	
	static int i = 0;

    public static void showTeam(String team,char start, int n, int k) //showTeam() method to create team combinations through recursion
    {
        if(n == 0||k == 0||k > n)
        {
        	if (k == 0) //this if statement makes sure it will only print out a full sequence and not each step in the recursion
        	{ 
        		i++; //counter for team number
        		System.out.println("Team " + i + ": " + team); //Prints a team combination after recursion concludes  
        	}
            return;
            
        } else 
        { //Using recursion with the showTeam() method to generate all possible team combinations
        	
        	showTeam(team+start,(char)(start+1), n-1, k-1); 
        	showTeam(team,(char)(start+1), n-1, k);
        }
    }
    
    
    
  //-------------------------------------------------------------
  	public static String getString() throws IOException {
  		InputStreamReader isr = new InputStreamReader(System.in);
  		BufferedReader br = new BufferedReader(isr);
  		String s = br.readLine();
  		return s;
  	}

  //--------------------------------------------------------------
  	public static int getInt() throws IOException 
  	{
  		String s = getString();
  		return Integer.parseInt(s);
  	}
  //--------------------------------------------------------------
}
