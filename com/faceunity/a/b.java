package com.faceunity.a;

import android.media.AudioRecord;
import android.support.annotation.NonNull;
import com.baidu.ala.livePlayer.StreamConfig;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class b {
    private static b knv;
    private boolean knw;
    private AudioRecord mAudioRecord;
    private static final int[] kns = {1, 0, 5, 7, 6};
    public static int knt = StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K;
    public static int SAMPLES_PER_FRAME = 2048;
    public static int knu = 24;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(knt, 16, 2);
        int i = SAMPLES_PER_FRAME * knu;
        i = i < minBufferSize ? ((minBufferSize / SAMPLES_PER_FRAME) + 1) * SAMPLES_PER_FRAME * 2 : i;
        for (int i2 : kns) {
            try {
                this.mAudioRecord = new AudioRecord(i2, knt, 16, 2, i);
                if (this.mAudioRecord.getState() != 1) {
                    this.mAudioRecord = null;
                }
            } catch (Exception e) {
                this.mAudioRecord = null;
            }
        }
    }

    public void release() {
        if (!this.knw) {
            this.knw = true;
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

    public void yx() {
        if (this.mAudioRecord != null) {
            if (knv != null && !knv.cJO()) {
                knv.release();
            }
            this.mAudioRecord.startRecording();
            knv = this;
        }
    }

    public void stop() {
        if (this.mAudioRecord != null) {
            this.mAudioRecord.stop();
        }
    }

    public boolean cJO() {
        return this.knw;
    }

    public AudioRecord cJP() {
        return this.mAudioRecord;
    }
}
