package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hLt;
    private boolean hLu;
    private AudioRecord mAudioRecord;
    private static final int[] hLq = {1, 0, 5, 7, 6};
    public static int hLr = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hLs = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hLr, 16, 2);
        int i = SAMPLES_PER_FRAME * hLs;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hLq) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hLr, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hLu) {
            this.hLu = true;
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
            if (hLt != null && !hLt.isReleased()) {
                hLt.release();
            }
            this.mAudioRecord.startRecording();
            hLt = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.hLu;
    }

    public AudioRecord bNN() {
        return this.mAudioRecord;
    }
}
