package com.kwai.player.qos;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.kwai.video.player.IMediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AppQosLiveAdaptiveRealtime {
    private static final boolean VERBOSE = false;
    private AppLiveReatimeInfoProvider mAppLiveReatimeInfoProvider;
    private boolean mEnableLiveAdaptiveAdditionalQosStat;
    private Object mLiveAdaptiveQosObject;
    private long mLiveAdaptiveQosTickDuration;
    private long mMonitorIntervalMs;
    IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener;
    private final long mReportIntervalMs;
    private Timer mTimer;
    private TimerTask mTimerTask;
    private long mLastSampleTime = 0;
    private long mLastLiveAdaptiveRecordTime = 0;
    private long mLiveAdaptiveTickStartTime = 0;
    private long mPlayStartTime = 0;
    private boolean mStarted = false;
    private int mLiveAdaptiveGopInfoCollectCnt = 0;
    private long mLiveAdaptiveLastRepReadStartTime = 0;
    private long mLiveAdaptiveLastRepFirstDataTime = 0;
    private int mLiveAdaptiveLastRepSwitchCnt = 0;
    private long mIndex = 0;

    public AppQosLiveAdaptiveRealtime(long j, long j2, AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, Object obj) {
        this.mMonitorIntervalMs = j;
        this.mReportIntervalMs = j2;
        this.mAppLiveReatimeInfoProvider = appLiveReatimeInfoProvider;
        this.mLiveAdaptiveQosObject = obj;
    }

    public JSONObject getLiveAdaptiveQosStatistics(long j) {
        JSONObject jSONObject;
        synchronized (this.mLiveAdaptiveQosObject) {
            AppLiveAdaptiveRealtimeInfo appLiveAdaptiveRealtimeInfo = this.mAppLiveReatimeInfoProvider.getAppLiveAdaptiveRealtimeInfo();
            if (appLiveAdaptiveRealtimeInfo == null) {
                jSONObject = null;
            } else {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("play_url", this.mAppLiveReatimeInfoProvider.getKflvVideoPlayingUrl());
                    jSONObject.put("play_start_time", this.mPlayStartTime);
                    jSONObject.put("tick_start", this.mLiveAdaptiveTickStartTime);
                    jSONObject.put(BdStatsConstant.StatsKey.STREAM_ID, this.mAppLiveReatimeInfoProvider.getStreamId());
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
                                this.mLiveAdaptiveLastRepFirstDataTime = j4 - j3;
                                jSONObject.put("cur_rep_first_data_time", this.mLiveAdaptiveLastRepFirstDataTime);
                                jSONObject.put("cur_rep_switch_time", this.mLiveAdaptiveLastRepFirstDataTime);
                                this.mLiveAdaptiveGopInfoCollectCnt = 0;
                                this.mLiveAdaptiveLastRepReadStartTime = j3;
                            }
                        } else {
                            jSONObject.put("cur_rep_first_data_time", this.mLiveAdaptiveLastRepFirstDataTime);
                            jSONObject.put("cur_rep_switch_time", 0);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
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
        this.mTimerTask = new TimerTask() { // from class: com.kwai.player.qos.AppQosLiveAdaptiveRealtime.1
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
        this.mTimer.schedule(this.mTimerTask, this.mMonitorIntervalMs, this.mMonitorIntervalMs);
        this.mLastSampleTime = System.currentTimeMillis();
        this.mLastLiveAdaptiveRecordTime = this.mLastSampleTime;
    }

    public void stopReport() {
        if (this.mStarted) {
            this.mStarted = false;
            if (this.mTimerTask != null) {
                this.mTimerTask.cancel();
                this.mTimerTask = null;
            }
            if (this.mTimer != null) {
                this.mTimer.cancel();
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
            if (this.mOnLiveAdaptiveQosStatListener != null && liveAdaptiveQosStatistics != null) {
                this.mOnLiveAdaptiveQosStatListener.onLiveAdaptiveQosStat(this.mAppLiveReatimeInfoProvider, liveAdaptiveQosStatistics);
            }
            this.mLiveAdaptiveTickStartTime = System.currentTimeMillis();
        }
    }
}
