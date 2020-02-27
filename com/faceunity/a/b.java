package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import com.baidu.ala.player.StreamConfig;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class b {
    private static b lXA;
    private boolean lXB;
    private AudioRecord mAudioRecord;
    private static final int[] AUDIO_SOURCES = {1, 0, 5, 7, 6};
    public static int lXy = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int lXz = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(lXy, 16, 2);
        int i = SAMPLES_PER_FRAME * lXz;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : AUDIO_SOURCES) {
            try {
                this.mAudioRecord = new AudioRecord(i2, lXy, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.lXB) {
            this.lXB = true;
            if (this.mAudioRecord != null) {
                this.mAudioRecord.release();
                this.mAudioRecord = null;
            }
        }
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i) {
        if (this.mAudioRecord == null) {
            return 0;
        }
        return this.mAudioRecord.read(byteBuffer, i);
    }

    public void Db() {
        if (this.mAudioRecord != null) {
            if (lXA != null && !lXA.isReleased()) {
                lXA.release();
            }
            this.mAudioRecord.startRecording();
            lXA = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.lXB;
    }

    public AudioRecord dsD() {
        return this.mAudioRecord;
    }
}
