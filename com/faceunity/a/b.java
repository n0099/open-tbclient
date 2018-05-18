package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hvt;
    private boolean hvu;
    private AudioRecord mAudioRecord;
    private static final int[] hvq = {1, 0, 5, 7, 6};
    public static int hvr = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int hvs = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hvr, 16, 2);
        int i = SAMPLES_PER_FRAME * hvs;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hvq) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hvr, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.hvu) {
            this.hvu = true;
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
            if (hvt != null && !hvt.bIi()) {
                hvt.release();
            }
            this.mAudioRecord.startRecording();
            hvt = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean bIi() {
        return this.hvu;
    }

    public AudioRecord bIj() {
        return this.mAudioRecord;
    }
}
