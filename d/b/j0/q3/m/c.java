package d.b.j0.q3.m;

import android.media.AudioRecord;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
/* loaded from: classes5.dex */
public class c {
    public static int a() {
        AudioRecord audioRecord;
        int minBufferSize = AudioRecord.getMinBufferSize(SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 16, 2);
        short[] sArr = new short[minBufferSize];
        AudioRecord audioRecord2 = null;
        try {
            audioRecord = new AudioRecord(0, SwanAudioPlayer.DEFAULT_SAMPLE_RATE, 16, 2, minBufferSize * 100);
        } catch (Exception unused) {
        }
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                c(audioRecord);
                audioRecord.release();
                return -2;
            } else if (audioRecord.read(sArr, 0, minBufferSize) <= 0) {
                c(audioRecord);
                audioRecord.release();
                return -2;
            } else {
                c(audioRecord);
                audioRecord.release();
                return 1;
            }
        } catch (Exception unused2) {
            audioRecord2 = audioRecord;
            if (audioRecord2 != null) {
                audioRecord2.release();
            }
            return -2;
        }
    }

    public static boolean b() {
        return a() != -2;
    }

    public static void c(AudioRecord audioRecord) {
        if (audioRecord == null) {
            return;
        }
        try {
            audioRecord.stop();
        } catch (Throwable unused) {
        }
    }
}
