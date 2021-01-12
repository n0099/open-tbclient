package com.faceunity.a;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import com.baidu.ala.helper.StreamConfig;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class b {
    private static b pDE;
    private AudioRecord mAudioRecord;
    private boolean pDF;
    private static final int[] pDC = {1, 0, 5, 7, 6};
    public static int SAMPLE_RATE = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int pDD = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, 16, 2);
        int i = SAMPLES_PER_FRAME * pDD;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : pDC) {
            try {
                this.mAudioRecord = new AudioRecord(i2, SAMPLE_RATE, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.pDF) {
            this.pDF = true;
            if (this.mAudioRecord != null) {
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
        }
    }

    public int e(@NonNull ByteBuffer byteBuffer, int i) {
        if (this.mAudioRecord == null) {
            return 0;
        }
        return this.mAudioRecord.read(byteBuffer, i);
    }

    public void startRecording() {
        if (this.mAudioRecord != null) {
            if (pDE != null && !pDE.ZP()) {
                pDE.release();
            }
            this.mAudioRecord.startRecording();
            pDE = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean ZP() {
        return this.pDF;
    }

    public AudioRecord exT() {
        return this.mAudioRecord;
    }
}
