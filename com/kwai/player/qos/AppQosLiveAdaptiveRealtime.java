package com.kwai.player.qos;

import com.kwai.video.player.IMediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AppQosLiveAdaptiveRealtime {
    public static final boolean VERBOSE = false;
    public AppLiveReatimeInfoProvider mAppLiveReatimeInfoProvider;
    public boolean mEnableLiveAdaptiveAdditionalQosStat;
    public Object mLiveAdaptiveQosObject;
    public long mLiveAdaptiveQosTickDuration;
    public long mMonitorIntervalMs;
    public IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener;
    public final long mReportIntervalMs;
    public Timer mTimer;
    public TimerTask mTimerTask;
    public long mLastSampleTime = 0;
    public long mLastLiveAdaptiveRecordTime = 0;
    public long mLiveAdaptiveTickStartTime = 0;
    public long mPlayStartTime = 0;
    public boolean mStarted = false;
    public int mLiveAdaptiveGopInfoCollectCnt = 0;
    public long mLiveAdaptiveLastRepReadStartTime = 0;
    public long mLiveAdaptiveLastRepFirstDataTime = 0;
    public int mLiveAdaptiveLastRepSwitchCnt = 0;
    public long mIndex = 0;

    public AppQosLiveAdaptiveRealtime(long j, long j2, AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, Object obj) {
        this.mMonitorIntervalMs = j;
        this.mReportIntervalMs = j2;
        this.mAppLiveReatimeInfoProvider = appLiveReatimeInfoProvider;
        this.mLiveAdaptiveQosObject = obj;
    }

    public JSONObject getLiveAdaptiveQosStatistics(long j) {
        synchronized (this.mLiveAdaptiveQosObject) {
            AppLiveAdaptiveRealtimeInfo appLiveAdaptiveRealtimeInfo = this.mAppLiveReatimeInfoProvider.getAppLiveAdaptiveRealtimeInfo();
            if (appLiveAdaptiveRealtimeInfo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("play_url", this.mAppLiveReatimeInfoProvider.getKflvVideoPlayingUrl());
                jSONObject.put("play_start_time", this.mPlayStartTime);
                jSONObject.put("tick_start", this.mLiveAdaptiveTickStartTime);
                jSONObject.put("stream_id", this.mAppLiveReatimeInfoProvider.getStreamId());
                jSONObject.put("server_ip", this.mAppLiveReatimeInfoProvider.getServerAddress());
                jSONObject.put("v_buf_time", appLiveAdaptiveRealtimeInfo.videoBufferTime);
                jSONObject.put("a_buf_time", appLiveAdaptiveRealtimeInfo.audioBufferTime);
                long j2 = this.mIndex + 1;
                this.mIndex = j2;
                jSONObject.put("index", j2);
                if (this.mEnableLiveAdaptiveAdditionalQosStat) {
                    jSONObject.put("bandwidth_current", appLiveAdaptiveRealtimeInfo.bandwidthCurrent);
                    jSONObject.put("bandwidth_fragment", appLiveAdaptiveRealtimeInfo.bandwidthFragment);
                    jSONObject.put("bitrate_downloading", appLiveAdaptiveRealtimeInfo.bitrateDownloading);
                    jSONObject.put("bitrate_playing", appLiveAdaptiveRealtimeInfo.bitratePlaying);
                    jSONObject.put("current_buffer", appLiveAdaptiveRealtimeInfo.currentBufferMs);
                    jSONObject.put("estimated_buffer", appLiveAdaptiveRealtimeInfo.estimateBufferMs);
                    jSONObject.put("predicted_buffer", appLiveAdaptiveRealtimeInfo.predictedBufferMs);
                    jSONObject.put("switch_time_gap", appLiveAdaptiveRealtimeInfo.repSwitchGapTime);
                    jSONObject.put("cached_tag_duration", appLiveAdaptiveRealtimeInfo.cachedTagDurationMs);
                    jSONObject.put("cached_total_duration", appLiveAdaptiveRealtimeInfo.cachedTotalDurationMs);
                    jSONObject.put("switch_cnt", appLiveAdaptiveRealtimeInfo.repSwitchCnt - this.mLiveAdaptiveLastRepSwitchCnt);
                    this.mLiveAdaptiveLastRepSwitchCnt = appLiveAdaptiveRealtimeInfo.repSwitchCnt;
                    jSONObject.put("switch_point_v_buf_time", appLiveAdaptiveRealtimeInfo.repSwitchPointVideoBufferTime);
                    long j3 = appLiveAdaptiveRealtimeInfo.curRepReadStartTime;
                    if (this.mLiveAdaptiveLastRepReadStartTime != j3) {
                        if (j3 == 0) {
                            this.mLiveAdaptiveGopInfoCollectCnt = 0;
                        }
                        long j4 = appLiveAdaptiveRealtimeInfo.curRepFirstDataTime;
                        if (j4 == 0) {
                            jSONObject.put("cur_rep_first_data_time", (this.mLiveAdaptiveGopInfoCollectCnt + 1) * this.mLiveAdaptiveQosTickDuration);
                            this.mLiveAdaptiveGopInfoCollectCnt++;
                        } else {
                            long j5 = j4 - j3;
                            this.mLiveAdaptiveLastRepFirstDataTime = j5;
                            jSONObject.put("cur_rep_first_data_time", j5);
                            jSONObject.put("cur_rep_switch_time", this.mLiveAdaptiveLastRepFirstDataTime);
                            this.mLiveAdaptiveGopInfoCollectCnt = 0;
                            this.mLiveAdaptiveLastRepReadStartTime = j3;
                        }
                    } else {
                        jSONObject.put("cur_rep_first_data_time", this.mLiveAdaptiveLastRepFirstDataTime);
                        jSONObject.put("cur_rep_switch_time", 0);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    public void setEnableLiveAdaptiveAdditionalQosStat(boolean z) {
        this.mEnableLiveAdaptiveAdditionalQosStat = z;
    }

    public void setPlayStartTime(long j) {
        this.mPlayStartTime = j;
    }

    public void startReport(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mOnLiveAdaptiveQosStatListener = onLiveAdaptiveQosStatListener;
        this.mLiveAdaptiveTickStartTime = System.currentTimeMillis();
        this.mTimer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.kwai.player.qos.AppQosLiveAdaptiveRealtime.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis - AppQosLiveAdaptiveRealtime.this.mLastLiveAdaptiveRecordTime;
                if (j >= AppQosLiveAdaptiveRealtime.this.mReportIntervalMs) {
                    AppQosLiveAdaptiveRealtime.this.uploadReport(j);
                    AppQosLiveAdaptiveRealtime.this.mLastLiveAdaptiveRecordTime = currentTimeMillis;
                }
            }
        };
        this.mTimerTask = timerTask;
        Timer timer = this.mTimer;
        long j = this.mMonitorIntervalMs;
        timer.schedule(timerTask, j, j);
        long currentTimeMillis = System.currentTimeMillis();
        this.mLastSampleTime = currentTimeMillis;
        this.mLastLiveAdaptiveRecordTime = currentTimeMillis;
    }

    public void stopReport() {
        if (this.mStarted) {
            this.mStarted = false;
            TimerTask timerTask = this.mTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.mTimerTask = null;
            }
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            uploadReport(currentTimeMillis - this.mLastLiveAdaptiveRecordTime);
            this.mLastLiveAdaptiveRecordTime = currentTimeMillis;
        }
    }

    public void uploadReport(long j) {
        if (this.mAppLiveReatimeInfoProvider.isMediaPlayerValid()) {
            JSONObject liveAdaptiveQosStatistics = getLiveAdaptiveQosStatistics(j);
            IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener = this.mOnLiveAdaptiveQosStatListener;
            if (onLiveAdaptiveQosStatListener != null && liveAdaptiveQosStatistics != null) {
                onLiveAdaptiveQosStatListener.onLiveAdaptiveQosStat(this.mAppLiveReatimeInfoProvider, liveAdaptiveQosStatistics);
            }
            this.mLiveAdaptiveTickStartTime = System.currentTimeMillis();
        }
    }
}
