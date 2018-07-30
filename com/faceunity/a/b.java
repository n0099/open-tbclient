package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hEq;
    private boolean hEr;
    private AudioRecord mAudioRecord;
    private static final int[] hEn = {1, 0, 5, 7, 6};
    public static int hEo = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hEp = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hEo, 16, 2);
        int i = SAMPLES_PER_FRAME * hEp;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hEn) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hEo, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hEr) {
            this.hEr = true;
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
            if (hEq != null && !hEq.isReleased()) {
                hEq.release();
            }
            this.mAudioRecord.startRecording();
            hEq = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.hEr;
    }

    public AudioRecord bJG() {
        return this.mAudioRecord;
    }
}
