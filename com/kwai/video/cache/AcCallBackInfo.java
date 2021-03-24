package com.kwai.video.cache;

import com.kwai.video.hodor.BaseTaskInfo;
import com.kwai.video.hodor.IHodorTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AcCallBackInfo {
    public static final int STOP_REASON_BYTE_RANGE_INVALID = 7;
    public static final int STOP_REASON_CANCELLED = 2;
    public static final int STOP_REASON_CONTENT_LENGTH_INVALID = 6;
    public static final int STOP_REASON_END = 9;
    public static final int STOP_REASON_FAILED = 3;
    public static final int STOP_REASON_FINISHED = 1;
    public static final int STOP_REASON_NO_CONTENT_LENGTH = 5;
    public static final int STOP_REASON_RESOLVE_HOST_FAIL = 8;
    public static final String[] STOP_REASON_STRING = {"STOP_REASON_UNKNOWN", "STOP_REASON_FINISHED", "STOP_REASON_CANCELLED", "STOP_REASON_FAILED", "STOP_REASON_TIMEOUT", "STOP_REASON_NO_CONTENT_LENGTH", "STOP_REASON_CONTENT_LENGTH_INVALID", "STOP_REASON_BYTE_RANGE_INVALID", "STOP_REASON_RESOLVE_HOST_FAIL", "STOP_REASON_END"};
    public static final int STOP_REASON_TIMEOUT = 4;
    public static final int STOP_REASON_UNKNOWN = 0;
    public static final int STOP_REASON_UNNET = -1;
    public String cacheKey;
    @Deprecated
    public long cachedBytes;
    public String cdnStatJson;
    public long contentLength;
    public long currentSpeedKbps;
    public String currentUri;
    public long downloadBytes;
    public String downloadUUID;
    public int errorCode;
    public String errorMsg;
    public String host;
    public int httpResponseCode;
    public String ip;
    public String kwaiSign;
    public long progressPosition;
    public String sessionUUID;
    @DownloadStopReason
    public int stopReason;
    @IHodorTask.HodorTaskState
    public int taskState = -1;
    public long totalBytes;
    public int transferConsumeMs;
    public String xKsCache;

    /* loaded from: classes.dex */
    public @interface DownloadStopReason {
    }

    public static String stopReasonToString(int i) {
        return (i < 0 || i >= 9) ? "innerError, check AcCallBackInfo.stopReasonToString plz" : STOP_REASON_STRING[i];
    }

    public String getPrettyString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cachedBytes", this.cachedBytes);
            jSONObject.put("cdnStatJson", this.cdnStatJson);
            jSONObject.put("contentLength", this.contentLength);
            jSONObject.put("currentSpeedKbps", this.currentSpeedKbps);
            jSONObject.put("currentUri", this.currentUri);
            jSONObject.put("downloadBytes", this.downloadBytes);
            jSONObject.put("downloadUUID", this.downloadUUID);
            jSONObject.put("errorCode", this.errorCode);
            jSONObject.put("host", this.host);
            jSONObject.put("httpResponseCode", this.httpResponseCode);
            jSONObject.put("ip", this.ip);
            jSONObject.put("kwaiSign", this.kwaiSign);
            jSONObject.put("progressPosition", this.progressPosition);
            jSONObject.put("stopReason", this.stopReason);
            jSONObject.put("taskState", this.taskState);
            jSONObject.put("totalBytes", this.totalBytes);
            jSONObject.put("transferConsumeMs", this.transferConsumeMs);
            jSONObject.put("xKsCache", this.xKsCache);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            return jSONObject.toString(4);
        } catch (JSONException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public String getTaskStateString() {
        return BaseTaskInfo.taskStateToString(this.taskState);
    }

    public boolean isFullyCached() {
        long j = this.totalBytes;
        return j > 0 && this.progressPosition == j;
    }
}
