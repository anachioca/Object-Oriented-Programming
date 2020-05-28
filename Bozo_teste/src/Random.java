import java.util.Calendar;

public class Random {

    private long p = 2147483648L;
    private long m = 843314861;
    private long a = 453816693;

    //long xi = 1023; //metodo 1
    private long xi;

    //metodo 3 - o melhor
    public Random(int k) { //construtor
        xi = k % p;
    }

    public Random(){
        Calendar cal = Calendar.getInstance();
        xi = cal.getTimeInMillis() % p;
    }

    public double getRand() {
        //calcula o proximo valor de xi
        //calcula valor entre 0 e 1 dividindo por p
        xi = (a + m * xi)%p;
        double d = xi;
        return d/p;
    }

    public int getIntRand(int max) {
        double x = max * getRand();
        return (int) x;
    }

    public void setSemente(int n){
        xi = n % p;
    }

}
