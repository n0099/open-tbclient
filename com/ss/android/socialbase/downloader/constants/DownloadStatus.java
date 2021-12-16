package com.ss.android.socialbase.downloader.constants;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class DownloadStatus {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CANCELED = -4;
    public static final int CONNECTED = 3;
    public static final int DOWNLOAD_COMPLETE_HANDLE = 11;
    public static final int FAILED = -1;
    public static final int FIRST_START = 6;
    public static final int FIRST_SUCCESS = -6;
    public static final int IDLE_STATUS = 0;
    public static final int INTERCEPT = -7;
    public static final int PAUSED = -2;
    public static final int PAUSED_BY_DB_INIT = -5;
    public static final int PREPARE = 1;
    public static final int PROGRESS = 4;
    public static final int RETRY = 5;
    public static final int RETRY_DELAY = 7;
    public static final int SINGLE_CHUNK_DELAY_RETRY = 10;
    public static final int SINGLE_CHUNK_RETRY = 9;
    public static final int START = 2;
    public static final int SUCCESSED = -3;
    public static final int WAITING_ASYNC_HANDLER = 8;
    public transient /* synthetic */ FieldHolder $fh;

    public DownloadStatus() {
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

    public static boolean isDownloadOver(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? (i2 >= 0 || i2 == -2 || i2 == -5) ? false : true : invokeI.booleanValue;
    }

    public static boolean isDownloading(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? (i2 <= 0 || i2 == 7 || i2 == 8 || i2 == 10) ? false : true : invokeI.booleanValue;
    }

    public static boolean isFailedStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == -1 || i2 == -7 : invokeI.booleanValue;
    }

    public static boolean isMonitorStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 == 2 || i2 == -3 || i2 == -1 || i2 == -4 || i2 == -2 || i2 == 6 || i2 == 0 : invokeI.booleanValue;
    }

    public static boolean isRealTimeUploadStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) ? i2 == -3 || i2 == -1 || i2 == -4 || i2 == -2 || i2 == 5 || i2 == 7 || i2 == 8 : invokeI.booleanValue;
    }

    public static boolean isTimeUploadStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? i2 == -3 || i2 == -1 || i2 == -4 : invokeI.booleanValue;
    }

    public static boolean isUnCompletedStatus(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 == -1 || i2 == -2 || i2 == -7 || i2 == -4 || i2 == -5 : invokeI.booleanValue;
    }
}
