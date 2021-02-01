package com.kwai.player.qos;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MetricMonitor {
    private static final String TAG = "MetricMonitor";
    private static final boolean VERBOSE = false;
    private AppLiveReatimeInfoProvider mRealtimeInfoProvider;
    public static String[] AUDIO_BUFFER_LEN_FIELDS = {"0~2", "2~4", "4~5", "5+"};
    public static int[] AUDIO_BUFFER_LEN_SCALE = {0, 2000, 4000, 5000};
    public static String[] VIDEO_BUFFER_LEN_FIELDS = {"0~2", "2~4", "4~5", "5+"};
    public static int[] VIDEO_BUFFER_LEN_SCALE = {0, 2000, 4000, 5000};
    private long[] audioBufferLenMetric = new long[AUDIO_BUFFER_LEN_FIELDS.length];
    private long[] videoBufferLenMetric = new long[VIDEO_BUFFER_LEN_FIELDS.length];

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
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public JSONObject getVideoBufferLenMetric() {
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < this.videoBufferLenMetric.length; i++) {
            try {
                jSONObject.put(VIDEO_BUFFER_LEN_FIELDS[i], (int) this.videoBufferLenMetric[i]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void recordAudioBufferLenStat(long j) {
        long audioCachedDuration = this.mRealtimeInfoProvider.getAudioCachedDuration();
        for (int i = 0; i < AUDIO_BUFFER_LEN_SCALE.length; i++) {
            if (audioCachedDuration >= AUDIO_BUFFER_LEN_SCALE[i]) {
                if (i == AUDIO_BUFFER_LEN_SCALE.length - 1) {
                    long[] jArr = this.audioBufferLenMetric;
                    jArr[i] = jArr[i] + j;
                    return;
                } else if (audioCachedDuration < AUDIO_BUFFER_LEN_SCALE[i + 1]) {
                    long[] jArr2 = this.audioBufferLenMetric;
                    jArr2[i] = jArr2[i] + j;
                    return;
                }
            }
        }
    }

    public void recordVideoBufferLenStat(long j) {
        long videoCachedDuration = this.mRealtimeInfoProvider.getVideoCachedDuration();
        for (int i = 0; i < VIDEO_BUFFER_LEN_SCALE.length; i++) {
            if (videoCachedDuration >= VIDEO_BUFFER_LEN_SCALE[i]) {
                if (i == VIDEO_BUFFER_LEN_SCALE.length - 1) {
                    long[] jArr = this.videoBufferLenMetric;
                    jArr[i] = jArr[i] + j;
                    return;
                } else if (videoCachedDuration < VIDEO_BUFFER_LEN_SCALE[i + 1]) {
                    long[] jArr2 = this.videoBufferLenMetric;
                    jArr2[i] = jArr2[i] + j;
                    return;
                }
            }
        }
    }

    public void sample(long j) {
        recordAudioBufferLenStat(j);
        recordVideoBufferLenStat(j);
    }
}
