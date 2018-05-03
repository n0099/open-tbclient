package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class b {
    private static b hup;
    private boolean huq;
    private AudioRecord mAudioRecord;
    private static final int[] hum = {1, 0, 5, 7, 6};
    public static int hun = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int huo = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(hun, 16, 2);
        int i = SAMPLES_PER_FRAME * huo;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : hum) {
            try {
                this.mAudioRecord = new AudioRecord(i2, hun, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.huq) {
            this.huq = true;
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
            if (hup != null && !hup.bIk()) {
                hup.release();
            }
            this.mAudioRecord.startRecording();
            hup = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean bIk() {
        return this.huq;
    }

    public AudioRecord bIl() {
        return this.mAudioRecord;
    }
}
