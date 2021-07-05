package com.kwai.player.qos;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.IMediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AppQosLiveAdaptiveRealtime {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public AppLiveReatimeInfoProvider mAppLiveReatimeInfoProvider;
    public boolean mEnableLiveAdaptiveAdditionalQosStat;
    public long mIndex;
    public long mLastLiveAdaptiveRecordTime;
    public long mLastSampleTime;
    public int mLiveAdaptiveGopInfoCollectCnt;
    public long mLiveAdaptiveLastRepFirstDataTime;
    public long mLiveAdaptiveLastRepReadStartTime;
    public int mLiveAdaptiveLastRepSwitchCnt;
    public Object mLiveAdaptiveQosObject;
    public long mLiveAdaptiveQosTickDuration;
    public long mLiveAdaptiveTickStartTime;
    public long mMonitorIntervalMs;
    public IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener;
    public long mPlayStartTime;
    public final long mReportIntervalMs;
    public boolean mStarted;
    public Timer mTimer;
    public TimerTask mTimerTask;

    public AppQosLiveAdaptiveRealtime(long j, long j2, AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), appLiveReatimeInfoProvider, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastSampleTime = 0L;
        this.mLastLiveAdaptiveRecordTime = 0L;
        this.mLiveAdaptiveTickStartTime = 0L;
        this.mPlayStartTime = 0L;
        this.mMonitorIntervalMs = j;
        this.mReportIntervalMs = j2;
        this.mAppLiveReatimeInfoProvider = appLiveReatimeInfoProvider;
        this.mLiveAdaptiveQosObject = obj;
        this.mStarted = false;
        this.mLiveAdaptiveGopInfoCollectCnt = 0;
        this.mLiveAdaptiveLastRepReadStartTime = 0L;
        this.mLiveAdaptiveLastRepFirstDataTime = 0L;
        this.mLiveAdaptiveLastRepSwitchCnt = 0;
        this.mIndex = 0L;
    }

    public JSONObject getLiveAdaptiveQosStatistics(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
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
        return (JSONObject) invokeJ.objValue;
    }

    public void setEnableLiveAdaptiveAdditionalQosStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.mEnableLiveAdaptiveAdditionalQosStat = z;
        }
    }

    public void setPlayStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.mPlayStartTime = j;
        }
    }

    public void startReport(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, onLiveAdaptiveQosStatListener) == null) || this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mOnLiveAdaptiveQosStatListener = onLiveAdaptiveQosStatListener;
        this.mLiveAdaptiveTickStartTime = System.currentTimeMillis();
        this.mTimer = new Timer();
        TimerTask timerTask = new TimerTask(this) { // from class: com.kwai.player.qos.AppQosLiveAdaptiveRealtime.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AppQosLiveAdaptiveRealtime this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - this.this$0.mLastLiveAdaptiveRecordTime;
                    if (j >= this.this$0.mReportIntervalMs) {
                        this.this$0.uploadReport(j);
                        this.this$0.mLastLiveAdaptiveRecordTime = currentTimeMillis;
                    }
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mStarted) {
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && this.mAppLiveReatimeInfoProvider.isMediaPlayerValid()) {
            JSONObject liveAdaptiveQosStatistics = getLiveAdaptiveQosStatistics(j);
            IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener = this.mOnLiveAdaptiveQosStatListener;
            if (onLiveAdaptiveQosStatListener != null && liveAdaptiveQosStatistics != null) {
                onLiveAdaptiveQosStatListener.onLiveAdaptiveQosStat(this.mAppLiveReatimeInfoProvider, liveAdaptiveQosStatistics);
            }
            this.mLiveAdaptiveTickStartTime = System.currentTimeMillis();
        }
    }
}
