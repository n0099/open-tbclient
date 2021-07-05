package com.kwai.video.hodor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.hodor.IHodorTask;
import com.kwai.video.hodor.util.Timber;
/* loaded from: classes7.dex */
public class BaseTaskInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String cdnStatJson;
    public long currentSpeedKbps;
    public String currentUrl;
    public long downloadedBytes;
    public int errorCode;
    public String errorMsg;
    public long expectBytes;
    public String host;
    public int httpResponseCode;
    public String ip;
    public String kwaiSign;
    public long progressBytes;
    @AcCallBackInfo.DownloadStopReason
    public int stopReason;
    @IHodorTask.HodorTaskState
    public int taskState;
    public long totalBytes;
    public int transferConsumeMs;
    public String xKsCache;

    public BaseTaskInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.taskState = -1;
    }

    public static String taskStateToString(@IHodorTask.HodorTaskState int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    Timber.d("taskStateToString unknown state:%d, return InnerError", Integer.valueOf(i2));
                                    return "InnerError";
                                }
                                return "TaskState_Paused";
                            }
                            return "TaskState_Failed";
                        }
                        return "TaskState_Cancelled";
                    }
                    return "TaskState_Finished";
                }
                return "TaskState_Started";
            }
            return "TaskState_Unknown";
        }
        return (String) invokeI.objValue;
    }

    public void copyInfoAfterDownload(AcCallBackInfo acCallBackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, acCallBackInfo) == null) {
            Timber.d("[copyInfoAfterDownload]progressBytes:%d, acInfo.progressPosition:%d, acInfo.httpResponseCode:%d", Long.valueOf(this.progressBytes), Long.valueOf(acCallBackInfo.progressPosition), Integer.valueOf(acCallBackInfo.httpResponseCode));
            this.taskState = acCallBackInfo.taskState;
            this.expectBytes = acCallBackInfo.contentLength;
            this.downloadedBytes = acCallBackInfo.downloadBytes;
            this.progressBytes = acCallBackInfo.progressPosition;
            this.currentSpeedKbps = acCallBackInfo.currentSpeedKbps;
            this.totalBytes = acCallBackInfo.totalBytes;
            this.stopReason = acCallBackInfo.stopReason;
            this.errorCode = acCallBackInfo.errorCode;
            this.errorMsg = acCallBackInfo.errorMsg;
            this.httpResponseCode = acCallBackInfo.httpResponseCode;
            this.currentUrl = acCallBackInfo.currentUri;
            this.host = acCallBackInfo.host;
            this.ip = acCallBackInfo.ip;
            this.transferConsumeMs = acCallBackInfo.transferConsumeMs;
            this.kwaiSign = acCallBackInfo.kwaiSign;
            this.xKsCache = acCallBackInfo.xKsCache;
            this.cdnStatJson = acCallBackInfo.cdnStatJson;
        }
    }

    public void copyInfoInProgress(AcCallBackInfo acCallBackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acCallBackInfo) == null) {
            this.taskState = acCallBackInfo.taskState;
            this.expectBytes = acCallBackInfo.contentLength;
            this.downloadedBytes = acCallBackInfo.downloadBytes;
            this.progressBytes = acCallBackInfo.progressPosition;
            this.currentSpeedKbps = acCallBackInfo.currentSpeedKbps;
            this.totalBytes = acCallBackInfo.totalBytes;
            this.errorCode = acCallBackInfo.errorCode;
            this.stopReason = acCallBackInfo.stopReason;
            this.errorMsg = acCallBackInfo.errorMsg;
            this.host = acCallBackInfo.host;
            this.ip = acCallBackInfo.ip;
        }
    }

    public void debugPrintCdnInfo(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            Timber.log(i2, "[debugPrintCdnInfo][tag:%s] errorCode:%d, errorMsg:%s, httpResponseCode:%d, stopReason:%s, currentSpeedKbps:%d, downloadedBytes:%d, expectBytes:%d, progressBytes:%d, totalBytes:%d, host:%s, ip:%s, transferConsumeMs:%d, currentUrl:%s, kwaiSign:%s, xKsCache:%s", str, Integer.valueOf(this.errorCode), this.errorMsg, Integer.valueOf(this.httpResponseCode), AcCallBackInfo.stopReasonToString(this.stopReason), Long.valueOf(this.currentSpeedKbps), Long.valueOf(this.downloadedBytes), Long.valueOf(this.expectBytes), Long.valueOf(this.progressBytes), Long.valueOf(this.totalBytes), this.host, this.ip, Integer.valueOf(this.transferConsumeMs), this.currentUrl, this.kwaiSign, this.xKsCache);
            Timber.log(i3, "%s cdnStatJson:%s", str, this.cdnStatJson);
        }
    }

    public void debugPrintProgressInfo(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            Timber.log(i2, "[debugPrintProgressInfo][tag:%s] taskState:%s, stopReason:%s, currentSpeedKbps:%d, progressBytes:%d, totalBytes:%d, errorCode:%d, errorMsg:%s, host:%s, ip:%s", str, taskStateToString(this.taskState), AcCallBackInfo.stopReasonToString(this.stopReason), Long.valueOf(this.currentSpeedKbps), Long.valueOf(this.progressBytes), Long.valueOf(this.totalBytes), Integer.valueOf(this.errorCode), this.errorMsg, this.host, this.ip);
        }
    }

    public String getCdnStatJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cdnStatJson : (String) invokeV.objValue;
    }

    public long getCurrentSpeedKbps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.currentSpeedKbps : invokeV.longValue;
    }

    public long getCurrentSpeedKiloBytesPerSecond() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ((this.currentSpeedKbps * 1000) / 8) / 1024 : invokeV.longValue;
    }

    public String getCurrentUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.currentUrl : (String) invokeV.objValue;
    }

    public long getDownloadedBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.downloadedBytes : invokeV.longValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.errorCode : invokeV.intValue;
    }

    public String getErrorMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.errorMsg : (String) invokeV.objValue;
    }

    public long getExpectBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.expectBytes : invokeV.longValue;
    }

    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.host : (String) invokeV.objValue;
    }

    public int getHttpResponseCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.httpResponseCode : invokeV.intValue;
    }

    public String getIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.ip : (String) invokeV.objValue;
    }

    public String getKwaiSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.kwaiSign : (String) invokeV.objValue;
    }

    public long getProgressBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.progressBytes : invokeV.longValue;
    }

    @AcCallBackInfo.DownloadStopReason
    public int getStopReason() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.stopReason : invokeV.intValue;
    }

    public int getTaskState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.taskState : invokeV.intValue;
    }

    public long getTotalBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.totalBytes : invokeV.longValue;
    }

    public int getTransferConsumeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.transferConsumeMs : invokeV.intValue;
    }

    public String getxKsCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.xKsCache : (String) invokeV.objValue;
    }

    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.taskState == 1) {
                long j = this.totalBytes;
                if (j > 0 && this.progressBytes == j) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i2 = this.taskState;
            return (i2 == 0 || i2 == 4) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
