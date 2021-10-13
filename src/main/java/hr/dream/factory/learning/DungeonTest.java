package hr.dream.factory.learning;

import java.io.*;

class DungeonGame implements Serializable{
    public int x = 3;
    transient long y =4;
    private short z = 5;
    int getX(){
        return x;
    }
    long getY(){
        return y;
    }
    short getZ(){
        return z;
    }
}

public class DungeonTest {
    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();
        try{
            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();
            System.out.println(d.getX() + d.getY() + d.getZ());
        } catch (Exception e){
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);) {
            d = (DungeonGame) ois.readObject();
            System.out.println(d.getX() + d.getY() + d.getZ());
        }catch (Exception e){
            throw new DankoException(e);
        }

    }

    public static class DankoException extends RuntimeException{
        public DankoException(Throwable cause) {
            super(cause);
        }
    }
}
