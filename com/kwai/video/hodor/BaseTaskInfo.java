package com.kwai.video.hodor;

import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.hodor.IHodorTask;
import com.kwai.video.hodor.util.Timber;
/* loaded from: classes4.dex */
public class BaseTaskInfo {
    String cdnStatJson;
    long currentSpeedKbps;
    String currentUrl;
    long downloadedBytes;
    int errorCode;
    String errorMsg;
    long expectBytes;
    String host;
    public int httpResponseCode;
    String ip;
    String kwaiSign;
    long progressBytes;
    @AcCallBackInfo.DownloadStopReason
    int stopReason;
    @IHodorTask.HodorTaskState
    int taskState = -1;
    long totalBytes;
    int transferConsumeMs;
    String xKsCache;

    public static String taskStateToString(@IHodorTask.HodorTaskState int i) {
        switch (i) {
            case -1:
                return "TaskState_Unknown";
            case 0:
                return "TaskState_Started";
            case 1:
                return "TaskState_Finished";
            case 2:
                return "TaskState_Cancelled";
            case 3:
                return "TaskState_Failed";
            case 4:
                return "TaskState_Paused";
            default:
                Timber.d("taskStateToString unknown state:%d, return InnerError", Integer.valueOf(i));
                return "InnerError";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copyInfoAfterDownload(AcCallBackInfo acCallBackInfo) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copyInfoInProgress(AcCallBackInfo acCallBackInfo) {
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

    public void debugPrintCdnInfo(int i, int i2, String str) {
        Timber.log(i, "[debugPrintCdnInfo][tag:%s] errorCode:%d, errorMsg:%s, httpResponseCode:%d, stopReason:%s, currentSpeedKbps:%d, downloadedBytes:%d, expectBytes:%d, progressBytes:%d, totalBytes:%d, host:%s, ip:%s, transferConsumeMs:%d, currentUrl:%s, kwaiSign:%s, xKsCache:%s", str, Integer.valueOf(this.errorCode), this.errorMsg, Integer.valueOf(this.httpResponseCode), AcCallBackInfo.stopReasonToString(this.stopReason), Long.valueOf(this.currentSpeedKbps), Long.valueOf(this.downloadedBytes), Long.valueOf(this.expectBytes), Long.valueOf(this.progressBytes), Long.valueOf(this.totalBytes), this.host, this.ip, Integer.valueOf(this.transferConsumeMs), this.currentUrl, this.kwaiSign, this.xKsCache);
        Timber.log(i2, "%s cdnStatJson:%s", str, this.cdnStatJson);
    }

    public void debugPrintProgressInfo(int i, String str) {
        Timber.log(i, "[debugPrintProgressInfo][tag:%s] taskState:%s, stopReason:%s, currentSpeedKbps:%d, progressBytes:%d, totalBytes:%d, errorCode:%d, errorMsg:%s, host:%s, ip:%s", str, taskStateToString(this.taskState), AcCallBackInfo.stopReasonToString(this.stopReason), Long.valueOf(this.currentSpeedKbps), Long.valueOf(this.progressBytes), Long.valueOf(this.totalBytes), Integer.valueOf(this.errorCode), this.errorMsg, this.host, this.ip);
    }

    public String getCdnStatJson() {
        return this.cdnStatJson;
    }

    public long getCurrentSpeedKbps() {
        return this.currentSpeedKbps;
    }

    public long getCurrentSpeedKiloBytesPerSecond() {
        return ((this.currentSpeedKbps * 1000) / 8) / 1024;
    }

    public String getCurrentUrl() {
        return this.currentUrl;
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getExpectBytes() {
        return this.expectBytes;
    }

    public String getHost() {
        return this.host;
    }

    public int getHttpResponseCode() {
        return this.httpResponseCode;
    }

    public String getIp() {
        return this.ip;
    }

    public String getKwaiSign() {
        return this.kwaiSign;
    }

    public long getProgressBytes() {
        return this.progressBytes;
    }

    @AcCallBackInfo.DownloadStopReason
    public int getStopReason() {
        return this.stopReason;
    }

    public int getTaskState() {
        return this.taskState;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public int getTransferConsumeMs() {
        return this.transferConsumeMs;
    }

    public String getxKsCache() {
        return this.xKsCache;
    }

    public boolean isComplete() {
        return this.taskState == 1 && this.totalBytes > 0 && this.progressBytes == this.totalBytes;
    }

    public boolean isOver() {
        return (this.taskState == 0 || this.taskState == 4) ? false : true;
    }
}
