package com.kwai.video.cache;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface CacheSessionListener {
    public static final int STOP_REASON_BYTE_RANGE_INVALID = 7;
    public static final int STOP_REASON_CANCELLED = 2;
    public static final int STOP_REASON_CONTENT_LENGTH_INVALID = 6;
    public static final int STOP_REASON_END = 9;
    public static final int STOP_REASON_FAILED = 3;
    public static final int STOP_REASON_FINISHED = 1;
    public static final int STOP_REASON_NO_CONTENT_LENGTH = 5;
    public static final int STOP_REASON_RESOLVE_HOST_FAIL = 8;
    public static final int STOP_REASON_TIMEOUT = 4;
    public static final int STOP_REASON_UNKNOWN = 0;
    public static final int STOP_REASON_UNNET = -1;

    /* loaded from: classes7.dex */
    public static class Util {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Util() {
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

        public static boolean needRetryOnThisStopReasonCode(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? (i2 == 1 || i2 == 2) ? false : true : invokeI.booleanValue;
        }

        public static String stopReasonToString(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? AcCallBackInfo.stopReasonToString(i2) : (String) invokeI.objValue;
        }
    }

    void onDownloadPaused();

    void onDownloadProgress(long j, long j2);

    void onDownloadResumed();

    void onDownloadStarted(long j, String str, String str2, String str3, int i2, long j2);

    void onDownloadStopped(int i2, long j, long j2, String str, int i3, String str2, String str3, String str4, String str5);

    void onSessionClosed(int i2, long j, long j2, long j3, String str, boolean z);

    void onSessionStart(String str, long j, long j2, long j3);
}
