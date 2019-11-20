package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import com.baidu.ala.livePlayer.StreamConfig;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b kmE;
    private boolean kmF;
    private AudioRecord mAudioRecord;
    private static final int[] kmB = {1, 0, 5, 7, 6};
    public static int kmC = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int kmD = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(kmC, 16, 2);
        int i = SAMPLES_PER_FRAME * kmD;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : kmB) {
            try {
                this.mAudioRecord = new AudioRecord(i2, kmC, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.kmF) {
            this.kmF = true;
            if (this.mAudioRecord != null) {
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
        }
    }

    public int b(@NonNull ByteBuffer byteBuffer, int i) {
        if (this.mAudioRecord == null) {
            return 0;
        }
        return this.mAudioRecord.read(byteBuffer, i);
    }

    public void yy() {
        if (this.mAudioRecord != null) {
            if (kmE != null && !kmE.cJM()) {
                kmE.release();
            }
            this.mAudioRecord.startRecording();
            kmE = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean cJM() {
        return this.kmF;
    }

    public AudioRecord cJN() {
        return this.mAudioRecord;
    }
}
