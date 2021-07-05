package com.kwai.video.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.hodor.BaseTaskInfo;
import com.kwai.video.hodor.IHodorTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AcCallBackInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STOP_REASON_BYTE_RANGE_INVALID = 7;
    public static final int STOP_REASON_CANCELLED = 2;
    public static final int STOP_REASON_CONTENT_LENGTH_INVALID = 6;
    public static final int STOP_REASON_END = 9;
    public static final int STOP_REASON_FAILED = 3;
    public static final int STOP_REASON_FINISHED = 1;
    public static final int STOP_REASON_NO_CONTENT_LENGTH = 5;
    public static final int STOP_REASON_RESOLVE_HOST_FAIL = 8;
    public static final String[] STOP_REASON_STRING;
    public static final int STOP_REASON_TIMEOUT = 4;
    public static final int STOP_REASON_UNKNOWN = 0;
    public static final int STOP_REASON_UNNET = -1;
    public transient /* synthetic */ FieldHolder $fh;
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
    public int taskState;
    public long totalBytes;
    public int transferConsumeMs;
    public String xKsCache;

    /* loaded from: classes7.dex */
    public @interface DownloadStopReason {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371690436, "Lcom/kwai/video/cache/AcCallBackInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(371690436, "Lcom/kwai/video/cache/AcCallBackInfo;");
                return;
            }
        }
        STOP_REASON_STRING = new String[]{"STOP_REASON_UNKNOWN", "STOP_REASON_FINISHED", "STOP_REASON_CANCELLED", "STOP_REASON_FAILED", "STOP_REASON_TIMEOUT", "STOP_REASON_NO_CONTENT_LENGTH", "STOP_REASON_CONTENT_LENGTH_INVALID", "STOP_REASON_BYTE_RANGE_INVALID", "STOP_REASON_RESOLVE_HOST_FAIL", "STOP_REASON_END"};
    }

    public AcCallBackInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.taskState = -1;
    }

    public static String stopReasonToString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? (i2 < 0 || i2 >= 9) ? "innerError, check AcCallBackInfo.stopReasonToString plz" : STOP_REASON_STRING[i2] : (String) invokeI.objValue;
    }

    public String getPrettyString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cachedBytes", this.cachedBytes);
                jSONObject.put("cdnStatJson", this.cdnStatJson);
                jSONObject.put(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, this.contentLength);
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
        return (String) invokeV.objValue;
    }

    public String getTaskStateString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BaseTaskInfo.taskStateToString(this.taskState) : (String) invokeV.objValue;
    }

    public boolean isFullyCached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = this.totalBytes;
            return j > 0 && this.progressPosition == j;
        }
        return invokeV.booleanValue;
    }
}
