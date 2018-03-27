package com.faceunity.a;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hXs;
    private boolean hXt;
    private AudioRecord mAudioRecord;
    private static final int[] hXp = {1, 0, 5, 7, 6};
    public static int hXq = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hXr = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hXq, 16, 2);
        int i = SAMPLES_PER_FRAME * hXr;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hXp) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hXq, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hXt) {
            this.hXt = true;
            if (this.mAudioRecord != null) {
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
        }
    }

    public int read(ByteBuffer byteBuffer, int i) {
        if (this.mAudioRecord == null) {
            return 0;
        }
        return this.mAudioRecord.read(byteBuffer, i);
    }

    public void startRecording() {
        if (this.mAudioRecord != null) {
            if (hXs != null && !hXs.bML()) {
                hXs.release();
            }
            this.mAudioRecord.startRecording();
            hXs = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean bML() {
        return this.hXt;
    }

    public AudioRecord bMM() {
        return this.mAudioRecord;
    }
}
