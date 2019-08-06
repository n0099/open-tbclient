package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b kmM;
    private boolean kmN;
    private AudioRecord mAudioRecord;
    private static final int[] kmJ = {1, 0, 5, 7, 6};
    public static int kmK = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int kmL = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(kmK, 16, 2);
        int i = SAMPLES_PER_FRAME * kmL;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : kmJ) {
            try {
                this.mAudioRecord = new AudioRecord(i2, kmK, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.kmN) {
            this.kmN = true;
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

    public void tE() {
        if (this.mAudioRecord != null) {
            if (kmM != null && !kmM.cMd()) {
                kmM.release();
            }
            this.mAudioRecord.startRecording();
            kmM = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean cMd() {
        return this.kmN;
    }

    public AudioRecord cMe() {
        return this.mAudioRecord;
    }
}
