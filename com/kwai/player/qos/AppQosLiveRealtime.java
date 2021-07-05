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
public class AppQosLiveRealtime {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AppQosLiveRealtime";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public long lastLiveRecordTime;
    public long lastSampleTime;
    public volatile boolean mIsFirstQosStatReport;
    public volatile boolean mIsLastQosStatReport;
    public MetricMonitor mMetricMonitor;
    public long mMoniterintervalMs;
    public IMediaPlayer.OnQosStatListener mOnQosStatListener;
    public Object mQosObject;
    public AppLiveReatimeInfoProvider mRealtimeInfoProvider;
    public final long mReportIntervalMs;
    public boolean mStarted;
    public long mTickStartTime;
    public Timer timer;
    public TimerTask timerTask;

    public AppQosLiveRealtime(long j, long j2, AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, Object obj) {
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
        this.lastSampleTime = 0L;
        this.lastLiveRecordTime = 0L;
        this.mTickStartTime = 0L;
        this.mMoniterintervalMs = j;
        this.mReportIntervalMs = j2;
        this.mRealtimeInfoProvider = appLiveReatimeInfoProvider;
        this.mQosObject = obj;
        this.mStarted = false;
        this.mIsFirstQosStatReport = true;
        this.mIsLastQosStatReport = false;
        this.mMetricMonitor = new MetricMonitor(appLiveReatimeInfoProvider);
    }

    public JSONObject getQosStatistics(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            synchronized (this.mQosObject) {
                int i2 = this.mIsFirstQosStatReport ? 1 : 0;
                int i3 = this.mIsLastQosStatReport ? 1 : 0;
                if (this.mIsFirstQosStatReport) {
                    this.mIsFirstQosStatReport = false;
                }
                String liveRealTimeQosJson = this.mRealtimeInfoProvider.getLiveRealTimeQosJson(i2, i3, this.mTickStartTime, j, this.mReportIntervalMs);
                if (liveRealTimeQosJson != null) {
                    try {
                        return new JSONObject(liveRealTimeQosJson);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            }
        }
        return (JSONObject) invokeJ.objValue;
    }

    public void startReport(IMediaPlayer.OnQosStatListener onQosStatListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onQosStatListener) == null) || this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mOnQosStatListener = onQosStatListener;
        this.mTickStartTime = System.currentTimeMillis();
        this.timer = new Timer();
        TimerTask timerTask = new TimerTask(this) { // from class: com.kwai.player.qos.AppQosLiveRealtime.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AppQosLiveRealtime this$0;

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
                    this.this$0.lastSampleTime = currentTimeMillis;
                    this.this$0.mMetricMonitor.sample(currentTimeMillis - this.this$0.lastSampleTime);
                    long j = currentTimeMillis - this.this$0.lastLiveRecordTime;
                    if (j >= this.this$0.mReportIntervalMs) {
                        this.this$0.uploadReport(j);
                        this.this$0.lastLiveRecordTime = currentTimeMillis;
                        this.this$0.mMetricMonitor.clear();
                    }
                }
            }
        };
        this.timerTask = timerTask;
        Timer timer = this.timer;
        long j = this.mMoniterintervalMs;
        timer.schedule(timerTask, j, j);
        long currentTimeMillis = System.currentTimeMillis();
        this.lastSampleTime = currentTimeMillis;
        this.lastLiveRecordTime = currentTimeMillis;
    }

    public void stopReport() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mStarted) {
            this.mStarted = false;
            TimerTask timerTask = this.timerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.timerTask = null;
            }
            Timer timer = this.timer;
            if (timer != null) {
                timer.cancel();
                this.timer = null;
            }
            this.mIsLastQosStatReport = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.lastSampleTime = currentTimeMillis;
            this.mMetricMonitor.sample(currentTimeMillis - this.lastSampleTime);
            uploadReport(currentTimeMillis - this.lastLiveRecordTime);
            this.lastLiveRecordTime = currentTimeMillis;
            this.mMetricMonitor.clear();
        }
    }

    public void uploadReport(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048579, this, j) == null) && this.mRealtimeInfoProvider.isMediaPlayerValid()) {
            JSONObject qosStatistics = getQosStatistics(j);
            IMediaPlayer.OnQosStatListener onQosStatListener = this.mOnQosStatListener;
            if (onQosStatListener != null && qosStatistics != null) {
                onQosStatListener.onQosStat(this.mRealtimeInfoProvider, qosStatistics);
            }
            this.mTickStartTime = System.currentTimeMillis();
        }
    }
}
