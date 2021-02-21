package com.faceunity.a;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class b {
    private static b pOn;
    private AudioRecord mAudioRecord;
    private boolean pOo;
    private static final int[] pOl = {1, 0, 5, 7, 6};
    public static int SAMPLE_RATE = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int pOm = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, 16, 2);
        int i = SAMPLES_PER_FRAME * pOm;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : pOl) {
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
        if (!this.pOo) {
            this.pOo = true;
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
            if (pOn != null && !pOn.isReleased()) {
                pOn.release();
            }
            this.mAudioRecord.startRecording();
            pOn = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.pOo;
    }

    public AudioRecord eAt() {
        return this.mAudioRecord;
    }
}
