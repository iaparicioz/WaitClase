public class Profesor extends Thread{
    @Override
    public void run() {
        try{
            while(true){
                synchronized (Main.list){
                    Main.list.wait();
                    desinfectar();
                    Main.list.notify();
                    sleep(5000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private void desinfectar() throws InterruptedException{
        int i=0;
        System.out.println("El profesor empieza a desinfectar al Alumno "+i);
        //le lleva un segundo por alumno
        sleep(1000);
        System.out.println("Alumno" +i+ " desinfectado");
        Main.list.remove(i);
    }
}
