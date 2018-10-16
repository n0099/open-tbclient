package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b ijf;
    private boolean ijg;
    private AudioRecord mAudioRecord;
    private static final int[] ijc = {1, 0, 5, 7, 6};
    public static int ijd = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int ije = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(ijd, 16, 2);
        int i = SAMPLES_PER_FRAME * ije;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : ijc) {
            try {
                this.mAudioRecord = new AudioRecord(i2, ijd, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.ijg) {
            this.ijg = true;
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
            if (ijf != null && !ijf.isReleased()) {
                ijf.release();
            }
            this.mAudioRecord.startRecording();
            ijf = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.ijg;
    }

    public AudioRecord bYx() {
        return this.mAudioRecord;
    }
}
