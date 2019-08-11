public class DoorsPuzzle {
    static int[] door=new int[101];

    public static void main(String[] args)
    {
        int j =1;
        for(int i=1; i<=100; i++)
        {
            door[i]=check(i);

            if(door[i]==1)
                System.out.println(i + " th door is closed");
            else
                System.out.println(i + " th door is open");
        }

    }

    public static int check(int a)
    {
        int count=0,k;
        for(k=2;k<=a;k++)
        {
            if(a%k==0)
                count++;
        }

        if(count%2==0)
            return 2;

        return 1;
    }

}

