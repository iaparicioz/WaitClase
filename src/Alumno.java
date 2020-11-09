import java.util.Scanner;

public class Alumno extends Thread{
    Scanner sc=new Scanner(System.in);

    @Override
    public void run() {
        try{
            while(true){
                synchronized (Main.list) {
                    for (int i=0;i<=8;i++){
                        System.out.println("Alumno"+Main.list.get(i)+" ha llegado");
                        System.out.println("Alumno"+Main.list.get(i)+" espera a que el profesor le desinfecte");
                        llegatarde();
                        Main.list.notify();
                        Main.list.wait();
                        sleep(3000);

                    }
                }
            }
        }catch (InterruptedException e){
                e.printStackTrace();
        }
    }
    public void llegatarde(){
        int sleepingTime;
        boolean llegaTarde = sc.nextBoolean();

        if (!llegaTarde) {
            sleepingTime = sc.nextInt(4000);
        } else {
            sleepingTime = sc.nextInt(20000) + 5000;
        }
    }
}

