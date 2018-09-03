package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hEs;
    private boolean hEt;
    private AudioRecord mAudioRecord;
    private static final int[] hEp = {1, 0, 5, 7, 6};
    public static int hEq = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hEr = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hEq, 16, 2);
        int i = SAMPLES_PER_FRAME * hEr;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hEp) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hEq, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hEt) {
            this.hEt = true;
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
            if (hEs != null && !hEs.isReleased()) {
                hEs.release();
            }
            this.mAudioRecord.startRecording();
            hEs = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.hEt;
    }

    public AudioRecord bJK() {
        return this.mAudioRecord;
    }
}
