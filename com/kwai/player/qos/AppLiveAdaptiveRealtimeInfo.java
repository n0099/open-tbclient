package com.kwai.player.qos;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes7.dex */
public class AppLiveAdaptiveRealtimeInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LiveAdaptiveRealtimeInfo_audioBufferTime = "audioBufferTime";
    public static final String LiveAdaptiveRealtimeInfo_bandwidthCurrent = "bandwidthCurrent";
    public static final String LiveAdaptiveRealtimeInfo_bandwidthFragment = "bandwidthFragment";
    public static final String LiveAdaptiveRealtimeInfo_bitrateDownloading = "bitrateDownloading";
    public static final String LiveAdaptiveRealtimeInfo_bitratePlaying = "bitratePlaying";
    public static final String LiveAdaptiveRealtimeInfo_cachedTagDurationMs = "cachedTagDurationMs";
    public static final String LiveAdaptiveRealtimeInfo_cachedTotalDurationMs = "cachedTotalDurationMs";
    public static final String LiveAdaptiveRealtimeInfo_curRepFirstDataTime = "curRepFirstDataTime";
    public static final String LiveAdaptiveRealtimeInfo_curRepReadStartTime = "curRepReadStartTime";
    public static final String LiveAdaptiveRealtimeInfo_curRepStartTime = "curRepStartTime";
    public static final String LiveAdaptiveRealtimeInfo_currentBufferMs = "currentBufferMs";
    public static final String LiveAdaptiveRealtimeInfo_estimateBufferMs = "estimateBufferMs";
    public static final String LiveAdaptiveRealtimeInfo_predictedBufferMs = "predictedBufferMs";
    public static final String LiveAdaptiveRealtimeInfo_repSwitchCnt = "repSwitchCnt";
    public static final String LiveAdaptiveRealtimeInfo_repSwitchGapTime = "repSwitchGapTime";
    public static final String LiveAdaptiveRealtimeInfo_repSwitchPointVideoBufferTime = "repSwitchPointVideoBufferTime";
    public static final String LiveAdaptiveRealtimeInfo_videoBufferTime = "videoBufferTime";
    public transient /* synthetic */ FieldHolder $fh;
    public long audioBufferTime;
    public int bandwidthCurrent;
    public int bandwidthFragment;
    public int bitrateDownloading;
    public int bitratePlaying;
    public long cachedTagDurationMs;
    public long cachedTotalDurationMs;
    public long curRepFirstDataTime;
    public long curRepReadStartTime;
    public long curRepStartTime;
    public int currentBufferMs;
    public int estimateBufferMs;
    public int predictedBufferMs;
    public int repSwitchCnt;
    public long repSwitchGapTime;
    public int repSwitchPointVideoBufferTime;
    public long videoBufferTime;

    public AppLiveAdaptiveRealtimeInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static AppLiveAdaptiveRealtimeInfo from(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundle)) == null) {
            if (bundle == null) {
                return null;
            }
            AppLiveAdaptiveRealtimeInfo appLiveAdaptiveRealtimeInfo = new AppLiveAdaptiveRealtimeInfo();
            appLiveAdaptiveRealtimeInfo.videoBufferTime = bundle.getLong(LiveAdaptiveRealtimeInfo_videoBufferTime, 0L);
            appLiveAdaptiveRealtimeInfo.audioBufferTime = bundle.getLong(LiveAdaptiveRealtimeInfo_audioBufferTime, 0L);
            appLiveAdaptiveRealtimeInfo.bandwidthCurrent = bundle.getInt(LiveAdaptiveRealtimeInfo_bandwidthCurrent, 0);
            appLiveAdaptiveRealtimeInfo.bandwidthFragment = bundle.getInt(LiveAdaptiveRealtimeInfo_bandwidthFragment, 0);
            appLiveAdaptiveRealtimeInfo.bitrateDownloading = bundle.getInt(LiveAdaptiveRealtimeInfo_bitrateDownloading, 0);
            appLiveAdaptiveRealtimeInfo.bitratePlaying = bundle.getInt(LiveAdaptiveRealtimeInfo_bitratePlaying, 0);
            appLiveAdaptiveRealtimeInfo.currentBufferMs = bundle.getInt(LiveAdaptiveRealtimeInfo_currentBufferMs, 0);
            appLiveAdaptiveRealtimeInfo.estimateBufferMs = bundle.getInt(LiveAdaptiveRealtimeInfo_estimateBufferMs, 0);
            appLiveAdaptiveRealtimeInfo.predictedBufferMs = bundle.getInt(LiveAdaptiveRealtimeInfo_predictedBufferMs, 0);
            appLiveAdaptiveRealtimeInfo.curRepReadStartTime = bundle.getLong(LiveAdaptiveRealtimeInfo_curRepReadStartTime, 0L);
            appLiveAdaptiveRealtimeInfo.curRepFirstDataTime = bundle.getLong(LiveAdaptiveRealtimeInfo_curRepFirstDataTime, 0L);
            appLiveAdaptiveRealtimeInfo.curRepStartTime = bundle.getLong(LiveAdaptiveRealtimeInfo_curRepStartTime, 0L);
            appLiveAdaptiveRealtimeInfo.repSwitchGapTime = bundle.getLong(LiveAdaptiveRealtimeInfo_repSwitchGapTime, 0L);
            appLiveAdaptiveRealtimeInfo.repSwitchCnt = bundle.getInt(LiveAdaptiveRealtimeInfo_repSwitchCnt, 0);
            appLiveAdaptiveRealtimeInfo.repSwitchPointVideoBufferTime = bundle.getInt(LiveAdaptiveRealtimeInfo_repSwitchPointVideoBufferTime, 0);
            appLiveAdaptiveRealtimeInfo.cachedTagDurationMs = bundle.getLong(LiveAdaptiveRealtimeInfo_cachedTagDurationMs, 0L);
            appLiveAdaptiveRealtimeInfo.cachedTotalDurationMs = bundle.getLong(LiveAdaptiveRealtimeInfo_cachedTotalDurationMs, 0L);
            return appLiveAdaptiveRealtimeInfo;
        }
        return (AppLiveAdaptiveRealtimeInfo) invokeL.objValue;
    }
}
