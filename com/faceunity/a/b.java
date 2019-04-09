package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b jLJ;
    private boolean jLK;
    private AudioRecord mAudioRecord;
    private static final int[] jLG = {1, 0, 5, 7, 6};
    public static int jLH = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int jLI = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(jLH, 16, 2);
        int i = SAMPLES_PER_FRAME * jLI;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : jLG) {
            try {
                this.mAudioRecord = new AudioRecord(i2, jLH, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.jLK) {
            this.jLK = true;
            if (this.mAudioRecord != null) {
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
        }
    }

    public int read(@NonNull ByteBuffer byteBuffer, int i) {
        if (this.mAudioRecord == null) {
            return 0;
        }
        return this.mAudioRecord.read(byteBuffer, i);
    }

    public void startRecording() {
        if (this.mAudioRecord != null) {
            if (jLJ != null && !jLJ.isReleased()) {
                jLJ.release();
            }
            this.mAudioRecord.startRecording();
            jLJ = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.jLK;
    }

    public AudioRecord cAH() {
        return this.mAudioRecord;
    }
}
