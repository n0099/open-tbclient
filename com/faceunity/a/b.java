package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b kpj;
    private boolean kpk;
    private AudioRecord mAudioRecord;
    private static final int[] kpg = {1, 0, 5, 7, 6};
    public static int kph = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int kpi = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(kph, 16, 2);
        int i = SAMPLES_PER_FRAME * kpi;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : kpg) {
            try {
                this.mAudioRecord = new AudioRecord(i2, kph, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.kpk) {
            this.kpk = true;
            if (this.mAudioRecord != null) {
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
        }
    }

    public int b(@NonNull ByteBuffer byteBuffer, int i) {
        if (this.mAudioRecord == null) {
            return 0;
        }
        return this.mAudioRecord.read(byteBuffer, i);
    }

    public void tE() {
        if (this.mAudioRecord != null) {
            if (kpj != null && !kpj.cMR()) {
                kpj.release();
            }
            this.mAudioRecord.startRecording();
            kpj = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean cMR() {
        return this.kpk;
    }

    public AudioRecord cMS() {
        return this.mAudioRecord;
    }
}
