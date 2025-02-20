import java.util.Scanner;
import java.util.Random;;

public class Esercizio
{
    public static void main(String[] args)
    {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int n, a, i, j, grossezza;
        do
        {
            System.out.println("Inserisci il numero di animali che arrivano al lago.");
            a = in.nextInt();
        } while (a <= 0);
        int[] lago = new int[a + 10];
        n = 0;
        i = 0;
        while (i < a)
        {
            grossezza = random.nextInt(8) + 3 * 10;
            System.out.println("Sta arrivando un animale grosso " + grossezza + " cm");
            n = inserisciElemento(lago, n, grossezza, n);
            j = 0;
            while (j < n)
            {
                if (grossezza > lago[j])
                {
                    n = eliminaElemento(lago, n, j);
                }
                else
                {
                    j = j + 1;
                }
            }
            i = i + 1;
            visualizzaVettore(lago, n);
        }
        System.out.println("Ecco le tipologie di grossezze presenti nel lago: ");
        n = rimuoviDuplicati(lago, n);
        visualizzaVettore(lago, n);
        System.out.println("Programma terminato.");
    }
    
    public static int eliminaElemento(int[] v, int n, int ie)
    {
        int i, n2;
        n2 = n - 1;
        for (i = ie; i <= n - 2; i++)
        {
            v[i] = v[i + 1];
        }
        
        return n2;
    }
    
    public static int inserisciElemento(int[] v, int n, int e, int ie)
    {
        int i, n2;
        n2 = n + 1;
        i = n2 - 1;
        while (i >= ie + 1)
        {
            v[i] = v[i - 1];
            i = i - 1;
        }
        v[ie] = e;
        
        return n2;
    }
    
    public static int rimuoviDuplicati(int[] v, int n)
    {
        int i, j;
        i = 0;
        while (i <= n - 2)
        {
            j = i + 1;
            while (j <= n - 1)
            {
                if (v[i] == v[j])
                {
                    System.out.println("Elimino " + v[j] + " da cella: " + j);
                    n = eliminaElemento(v, n, j);
                }
                else
                {
                    j = j + 1;
                }
            }
            i = i + 1;
        }
        
        return n;
    }
    
    public static void visualizzaVettore(int[] v, int n)
    {
        int i;
        if (n == 0)
        {
            System.out.println("Vuoto.");
        }
        else
        {
            for (i = 0; i <= n - 1; i++)
            {
                System.out.println("Animale numero " + i + ": " + v[i] + " | ");
            }
        }
    }
}
