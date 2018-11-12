package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b ikP;
    private boolean ikQ;
    private AudioRecord mAudioRecord;
    private static final int[] ikM = {1, 0, 5, 7, 6};
    public static int ikN = 48000;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int ikO = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(ikN, 16, 2);
        int i = SAMPLES_PER_FRAME * ikO;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : ikM) {
            try {
                this.mAudioRecord = new AudioRecord(i2, ikN, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.ikQ) {
            this.ikQ = true;
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
            if (ikP != null && !ikP.isReleased()) {
                ikP.release();
            }
            this.mAudioRecord.startRecording();
            ikP = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.ikQ;
    }

    public AudioRecord bXS() {
        return this.mAudioRecord;
    }
}
