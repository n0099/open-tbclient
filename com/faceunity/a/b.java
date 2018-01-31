package com.faceunity.a;

import android.media.AudioRecord;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hVJ;
    private boolean hVK;
    private AudioRecord mAudioRecord;
    private static final int[] hVG = {1, 0, 5, 7, 6};
    public static int hVH = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hVI = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hVH, 16, 2);
        int i = SAMPLES_PER_FRAME * hVI;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hVG) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hVH, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hVK) {
            this.hVK = true;
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
            if (hVJ != null && !hVJ.bLV()) {
                hVJ.release();
            }
            this.mAudioRecord.startRecording();
            hVJ = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean bLV() {
        return this.hVK;
    }

    public AudioRecord bLW() {
        return this.mAudioRecord;
    }
}
