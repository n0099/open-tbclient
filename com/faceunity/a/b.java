package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b klG;
    private boolean klH;
    private AudioRecord mAudioRecord;
    private static final int[] klD = {1, 0, 5, 7, 6};
    public static int klE = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int klF = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(klE, 16, 2);
        int i = SAMPLES_PER_FRAME * klF;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : klD) {
            try {
                this.mAudioRecord = new AudioRecord(i2, klE, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.klH) {
            this.klH = true;
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
            if (klG != null && !klG.cLI()) {
                klG.release();
            }
            this.mAudioRecord.startRecording();
            klG = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean cLI() {
        return this.klH;
    }

    public AudioRecord cLJ() {
        return this.mAudioRecord;
    }
}
