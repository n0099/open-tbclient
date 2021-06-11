package com.kwai.player.qos;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class MetricMonitor {
    public static final String TAG = "MetricMonitor";
    public static final boolean VERBOSE = false;
    public AppLiveReatimeInfoProvider mRealtimeInfoProvider;
    public static String[] AUDIO_BUFFER_LEN_FIELDS = {"0~2", "2~4", "4~5", "5+"};
    public static int[] AUDIO_BUFFER_LEN_SCALE = {0, 2000, 4000, 5000};
    public static String[] VIDEO_BUFFER_LEN_FIELDS = {"0~2", "2~4", "4~5", "5+"};
    public static int[] VIDEO_BUFFER_LEN_SCALE = {0, 2000, 4000, 5000};
    public long[] audioBufferLenMetric = new long[AUDIO_BUFFER_LEN_FIELDS.length];
    public long[] videoBufferLenMetric = new long[VIDEO_BUFFER_LEN_FIELDS.length];

    public MetricMonitor(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider) {
        this.mRealtimeInfoProvider = appLiveReatimeInfoProvider;
    }

    public void clear() {
        for (int i2 = 0; i2 < VIDEO_BUFFER_LEN_SCALE.length; i2++) {
            this.videoBufferLenMetric[i2] = 0;
        }
        for (int i3 = 0; i3 < AUDIO_BUFFER_LEN_SCALE.length; i3++) {
            this.audioBufferLenMetric[i3] = 0;
        }
    }

    public JSONObject getAudioBufferLenMetric() {
        JSONObject jSONObject = new JSONObject();
        for (int i2 = 0; i2 < this.audioBufferLenMetric.length; i2++) {
            try {
                jSONObject.put(AUDIO_BUFFER_LEN_FIELDS[i2], (int) this.audioBufferLenMetric[i2]);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public JSONObject getVideoBufferLenMetric() {
        JSONObject jSONObject = new JSONObject();
        for (int i2 = 0; i2 < this.videoBufferLenMetric.length; i2++) {
            try {
                jSONObject.put(VIDEO_BUFFER_LEN_FIELDS[i2], (int) this.videoBufferLenMetric[i2]);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void recordAudioBufferLenStat(long j) {
        long audioCachedDuration = this.mRealtimeInfoProvider.getAudioCachedDuration();
        int i2 = 0;
        while (true) {
            int[] iArr = AUDIO_BUFFER_LEN_SCALE;
            if (i2 >= iArr.length) {
                return;
            }
            if (audioCachedDuration >= iArr[i2]) {
                if (i2 == iArr.length - 1) {
                    long[] jArr = this.audioBufferLenMetric;
                    jArr[i2] = jArr[i2] + j;
                    return;
                } else if (audioCachedDuration < iArr[i2 + 1]) {
                    long[] jArr2 = this.audioBufferLenMetric;
                    jArr2[i2] = jArr2[i2] + j;
                    return;
                }
            }
            i2++;
        }
    }

    public void recordVideoBufferLenStat(long j) {
        long videoCachedDuration = this.mRealtimeInfoProvider.getVideoCachedDuration();
        int i2 = 0;
        while (true) {
            int[] iArr = VIDEO_BUFFER_LEN_SCALE;
            if (i2 >= iArr.length) {
                return;
            }
            if (videoCachedDuration >= iArr[i2]) {
                if (i2 == iArr.length - 1) {
                    long[] jArr = this.videoBufferLenMetric;
                    jArr[i2] = jArr[i2] + j;
                    return;
                } else if (videoCachedDuration < iArr[i2 + 1]) {
                    long[] jArr2 = this.videoBufferLenMetric;
                    jArr2[i2] = jArr2[i2] + j;
                    return;
                }
            }
            i2++;
        }
    }

    public void sample(long j) {
        recordAudioBufferLenStat(j);
        recordVideoBufferLenStat(j);
    }
}
