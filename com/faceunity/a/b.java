package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import com.baidu.ala.player.StreamConfig;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class b {
    private static b lZt;
    private boolean lZu;
    private AudioRecord mAudioRecord;
    private static final int[] AUDIO_SOURCES = {1, 0, 5, 7, 6};
    public static int lZr = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int lZs = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(lZr, 16, 2);
        int i = SAMPLES_PER_FRAME * lZs;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : AUDIO_SOURCES) {
            try {
                this.mAudioRecord = new AudioRecord(i2, lZr, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.lZu) {
            this.lZu = true;
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

    public void Dk() {
        if (this.mAudioRecord != null) {
            if (lZt != null && !lZt.isReleased()) {
                lZt.release();
            }
            this.mAudioRecord.startRecording();
            lZt = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean isReleased() {
        return this.lZu;
    }

    public AudioRecord dtd() {
        return this.mAudioRecord;
    }
}
