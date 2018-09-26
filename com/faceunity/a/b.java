package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hMM;
    private boolean hMN;
    private AudioRecord mAudioRecord;
    private static final int[] hMJ = {1, 0, 5, 7, 6};
    public static int hMK = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hML = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hMK, 16, 2);
        int i = SAMPLES_PER_FRAME * hML;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hMJ) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hMK, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hMN) {
            this.hMN = true;
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
            if (hMM != null && !hMM.isReleased()) {
                hMM.release();
            }
            this.mAudioRecord.startRecording();
            hMM = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.hMN;
    }

    public AudioRecord bMB() {
        return this.mAudioRecord;
    }
}
