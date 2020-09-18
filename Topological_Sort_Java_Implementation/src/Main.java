import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> adjlist ;
    public static HashMap<Integer, Integer> vis;
    public static ArrayList<Integer> topsort;


    public static void main(String[] args) {

        vis  = new HashMap<Integer, Integer>();
        topsort = new ArrayList<>();
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//number of nodes
        adjlist = new ArrayList<ArrayList<Integer>>(n);

        for(int i=0; i<n; i++){
            adjlist.add(new ArrayList<Integer>());  //Initialising the sub array list  ****very important step as the sub arraylist in not intialized in the declaration.
            vis.put(i,0);                           //Initialising the map
        }

        int m=sc.nextInt(); //number of edges
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            adjlist.get(x).add(y);
        }

        for(int i=0; i<n; i++){
            for(int j = 0; j<adjlist.get(i).size(); j++){
                System.out.print(adjlist.get(i).get(j)+" ");
            }
            System.out.println();
        }
        //now i want to create a topological sort
        //so using dfs with loop detection
        //0 :  unvisi
        //1 : processing
        //2 : visited
        dfs(0);

        Collections.reverse(topsort);
        System.out.println(topsort);


    }
    public static void dfs(int u){
        if(vis.containsKey(u)){
            if(vis.get(u)==1) {
                System.out.println("\n*** LOOP Found  ****  Cant have valid topological ordering of the graph!!!!");
                return;
            }
            else if(vis.get(u)==2){
                return;
            }
        }

        vis.put(u,1);

        for(int i=0; i<adjlist.get(u).size(); i++){
            dfs(adjlist.get(u).get(i));
        }

        topsort.add(u);
        vis.put(u,2);
    }

}
