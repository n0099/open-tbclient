package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b iwt;
    private boolean iwu;
    private AudioRecord mAudioRecord;
    private static final int[] iwq = {1, 0, 5, 7, 6};
    public static int iwr = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int iws = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(iwr, 16, 2);
        int i = SAMPLES_PER_FRAME * iws;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : iwq) {
            try {
                this.mAudioRecord = new AudioRecord(i2, iwr, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.iwu) {
            this.iwu = true;
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
            if (iwt != null && !iwt.isReleased()) {
                iwt.release();
            }
            this.mAudioRecord.startRecording();
            iwt = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.iwu;
    }

    public AudioRecord cbw() {
        return this.mAudioRecord;
    }
}
