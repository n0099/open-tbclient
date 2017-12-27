package com.faceunity.a;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hXw;
    private boolean hXx;
    private AudioRecord mAudioRecord;
    private static final int[] hXt = {1, 0, 5, 7, 6};
    public static int hXu = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hXv = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hXu, 16, 2);
        int i = SAMPLES_PER_FRAME * hXv;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hXt) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hXu, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hXx) {
            this.hXx = true;
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
            if (hXw != null && !hXw.bPD()) {
                hXw.release();
            }
            this.mAudioRecord.startRecording();
            hXw = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean bPD() {
        return this.hXx;
    }

    public AudioRecord bPE() {
        return this.mAudioRecord;
    }
}
