package com.faceunity.a;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hWU;
    private boolean hWV;
    private AudioRecord mAudioRecord;
    private static final int[] hWR = {1, 0, 5, 7, 6};
    public static int hWS = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hWT = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hWS, 16, 2);
        int i = SAMPLES_PER_FRAME * hWT;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hWR) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hWS, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hWV) {
            this.hWV = true;
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
            if (hWU != null && !hWU.bMG()) {
                hWU.release();
            }
            this.mAudioRecord.startRecording();
            hWU = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean bMG() {
        return this.hWV;
    }

    public AudioRecord bMH() {
        return this.mAudioRecord;
    }
}
