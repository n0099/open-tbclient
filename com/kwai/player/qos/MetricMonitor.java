package com.kwai.player.qos;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
        for (int i = 0; i < VIDEO_BUFFER_LEN_SCALE.length; i++) {
            this.videoBufferLenMetric[i] = 0;
        }
        for (int i2 = 0; i2 < AUDIO_BUFFER_LEN_SCALE.length; i2++) {
            this.audioBufferLenMetric[i2] = 0;
        }
    }

    public JSONObject getAudioBufferLenMetric() {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < this.audioBufferLenMetric.length; i++) {
            try {
                jSONObject.put(AUDIO_BUFFER_LEN_FIELDS[i], (int) this.audioBufferLenMetric[i]);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public JSONObject getVideoBufferLenMetric() {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < this.videoBufferLenMetric.length; i++) {
            try {
                jSONObject.put(VIDEO_BUFFER_LEN_FIELDS[i], (int) this.videoBufferLenMetric[i]);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void recordAudioBufferLenStat(long j) {
        long audioCachedDuration = this.mRealtimeInfoProvider.getAudioCachedDuration();
        int i = 0;
        while (true) {
            int[] iArr = AUDIO_BUFFER_LEN_SCALE;
            if (i >= iArr.length) {
                return;
            }
            if (audioCachedDuration >= iArr[i]) {
                if (i == iArr.length - 1) {
                    long[] jArr = this.audioBufferLenMetric;
                    jArr[i] = jArr[i] + j;
                    return;
                } else if (audioCachedDuration < iArr[i + 1]) {
                    long[] jArr2 = this.audioBufferLenMetric;
                    jArr2[i] = jArr2[i] + j;
                    return;
                }
            }
            i++;
        }
    }

    public void recordVideoBufferLenStat(long j) {
        long videoCachedDuration = this.mRealtimeInfoProvider.getVideoCachedDuration();
        int i = 0;
        while (true) {
            int[] iArr = VIDEO_BUFFER_LEN_SCALE;
            if (i >= iArr.length) {
                return;
            }
            if (videoCachedDuration >= iArr[i]) {
                if (i == iArr.length - 1) {
                    long[] jArr = this.videoBufferLenMetric;
                    jArr[i] = jArr[i] + j;
                    return;
                } else if (videoCachedDuration < iArr[i + 1]) {
                    long[] jArr2 = this.videoBufferLenMetric;
                    jArr2[i] = jArr2[i] + j;
                    return;
                }
            }
            i++;
        }
    }

    public void sample(long j) {
        recordAudioBufferLenStat(j);
        recordVideoBufferLenStat(j);
    }
}
