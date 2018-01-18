package com.faceunity.a;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hVp;
    private boolean hVq;
    private AudioRecord mAudioRecord;
    private static final int[] hVm = {1, 0, 5, 7, 6};
    public static int hVn = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hVo = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hVn, 16, 2);
        int i = SAMPLES_PER_FRAME * hVo;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hVm) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hVn, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hVq) {
            this.hVq = true;
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
            if (hVp != null && !hVp.bLT()) {
                hVp.release();
            }
            this.mAudioRecord.startRecording();
            hVp = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean bLT() {
        return this.hVq;
    }

    public AudioRecord bLU() {
        return this.mAudioRecord;
    }
}
