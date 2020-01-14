package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import com.baidu.ala.player.StreamConfig;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class b {
    private static b lWU;
    private boolean lWV;
    private AudioRecord mAudioRecord;
    private static final int[] AUDIO_SOURCES = {1, 0, 5, 7, 6};
    public static int lWS = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int lWT = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(lWS, 16, 2);
        int i = SAMPLES_PER_FRAME * lWT;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : AUDIO_SOURCES) {
            try {
                this.mAudioRecord = new AudioRecord(i2, lWS, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.lWV) {
            this.lWV = true;
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

    public void AL() {
        if (this.mAudioRecord != null) {
            if (lWU != null && !lWU.isReleased()) {
                lWU.release();
            }
            this.mAudioRecord.startRecording();
            lWU = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.lWV;
    }

    public AudioRecord drr() {
        return this.mAudioRecord;
    }
}
