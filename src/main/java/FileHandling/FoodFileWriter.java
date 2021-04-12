package FileHandling;

import StringHandling.JerkSONParser;
import StringHandling.OutputBuilder;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class FoodFileWriter {

    private String outputString;
    private OutputBuilder outputBuilder;

    public FoodFileWriter() {
        this.outputBuilder = new OutputBuilder();
        this.outputString = outputBuilder.buildString();
    }


    public void writeOutputStringToFile() throws IOException {

        try {
            String fileContent = outputBuilder.buildString();

            RandomAccessFile stream = new RandomAccessFile("/Users/kelly/Projects/Labs/HurtLocker/src/main/resources/FoodInventory.txt", "rw");
            FileChannel channel = stream.getChannel();

            byte[] strBytes = fileContent.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);

            buffer.put(strBytes);
            buffer.flip();
            channel.write(buffer);

            stream.close();
            channel.close();
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }


    }


}
