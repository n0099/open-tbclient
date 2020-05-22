package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import com.baidu.ala.player.StreamConfig;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class b {
    private static b mAZ;
    private AudioRecord mAudioRecord;
    private boolean mBa;
    private static final int[] mAX = {1, 0, 5, 7, 6};
    public static int SAMPLE_RATE = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int mAY = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(SAMPLE_RATE, 16, 2);
        int i = SAMPLES_PER_FRAME * mAY;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : mAX) {
            try {
                this.mAudioRecord = new AudioRecord(i2, SAMPLE_RATE, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.mBa) {
            this.mBa = true;
            if (this.mAudioRecord != null) {
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
        }
    }

    public int e(@NonNull ByteBuffer byteBuffer, int i) {
        if (this.mAudioRecord == null) {
            return 0;
        }
        return this.mAudioRecord.read(byteBuffer, i);
    }

    public void startRecording() {
        if (this.mAudioRecord != null) {
            if (mAZ != null && !mAZ.LL()) {
                mAZ.release();
            }
            this.mAudioRecord.startRecording();
            mAZ = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean LL() {
        return this.mBa;
    }

    public AudioRecord dCo() {
        return this.mAudioRecord;
    }
}
