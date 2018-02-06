package com.faceunity.a;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hXh;
    private boolean hXi;
    private AudioRecord mAudioRecord;
    private static final int[] hXe = {1, 0, 5, 7, 6};
    public static int hXf = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hXg = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hXf, 16, 2);
        int i = SAMPLES_PER_FRAME * hXg;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hXe) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hXf, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hXi) {
            this.hXi = true;
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
            if (hXh != null && !hXh.bMH()) {
                hXh.release();
            }
            this.mAudioRecord.startRecording();
            hXh = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean bMH() {
        return this.hXi;
    }

    public AudioRecord bMI() {
        return this.mAudioRecord;
    }
}
