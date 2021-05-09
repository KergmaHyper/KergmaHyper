import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        String str="Hi! test msg. ";
        Date curdt=new Date();
        str += curdt.toString()+"\r\n";
        System.out.println(str);
       // String filename1 = "oneout.txt";
        File fl = new File("oneout.txt");
        //try(BufferedOutputStream fos=new BufferedOutputStream( new FileOutputStream(filename1,true)))
        try(BufferedOutputStream fos=new BufferedOutputStream( new FileOutputStream(fl,true)))
        {
            byte[] buff = str.getBytes(StandardCharsets.UTF_8);
            fos.write(buff,0, buff.length);
            fos.flush();
        }
        catch (IOException ex){ System.out.println(ex.getMessage());    }

        //try( BufferedInputStream fis=new BufferedInputStream(new FileInputStream(filename1)))
        try( BufferedInputStream fis=new BufferedInputStream(new FileInputStream(fl)))
        {
          System.out.printf("file %s avalable %d bytes. \r\n<-----    start  file :      ----->\r\n"
                  ,fl.getCanonicalPath(),fis.available());
          byte[] buffr= new byte[fis.available()];
          fis.read(buffr,0,fis.available());

          for(byte b: buffr) { System.out.print( (char)b );   }
            System.out.print("<-----    end  file :     ----->\r\n");
        }
        catch (IOException ex){  System.out.println(ex.getMessage());     }


    }
}
  //test GIT
