import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Captcha {

    public static void main(String[] args) {
        // Example usage:
        String captchaText = "Hello, please type this";
        String audioFilePath = "captcha.wav";

        generateAudioCaptcha(captchaText, audioFilePath);
    }

    public static void generateAudioCaptcha(String captchaText, String audioFilePath) {
        try {
            AudioFormat audioFormat = new AudioFormat(8000.0f, 16, 1, true, false);
            byte[] captchaBytes = captchaText.getBytes();

            AudioInputStream audioInputStream = new AudioInputStream(
                    new java.io.ByteArrayInputStream(captchaBytes), audioFormat,
                    captchaBytes.length);

            File audioFile = new File(audioFilePath);
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, audioFile);

            System.out.println("CAPTCHA audio generated successfully.");
        } catch (IOException ex) {
            System.err.println("Error generating CAPTCHA audio: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
