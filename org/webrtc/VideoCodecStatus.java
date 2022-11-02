package org.webrtc;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class VideoCodecStatus {
    public static final /* synthetic */ VideoCodecStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final VideoCodecStatus ERROR;
    public static final VideoCodecStatus ERR_PARAMETER;
    public static final VideoCodecStatus ERR_REQUEST_SLI;
    public static final VideoCodecStatus ERR_SIZE;
    public static final VideoCodecStatus FALLBACK_SOFTWARE;
    public static final VideoCodecStatus LEVEL_EXCEEDED;
    public static final VideoCodecStatus MEMORY;
    public static final VideoCodecStatus NO_OUTPUT;
    public static final VideoCodecStatus OK;
    public static final VideoCodecStatus REQUEST_SLI;
    public static final VideoCodecStatus TARGET_BITRATE_OVERSHOOT;
    public static final VideoCodecStatus TIMEOUT;
    public static final VideoCodecStatus UNINITIALIZED;
    public transient /* synthetic */ FieldHolder $fh;
    public final int number;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(769164707, "Lorg/webrtc/VideoCodecStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(769164707, "Lorg/webrtc/VideoCodecStatus;");
                return;
            }
        }
        REQUEST_SLI = new VideoCodecStatus("REQUEST_SLI", 0, 2);
        NO_OUTPUT = new VideoCodecStatus("NO_OUTPUT", 1, 1);
        OK = new VideoCodecStatus("OK", 2, 0);
        ERROR = new VideoCodecStatus("ERROR", 3, -1);
        LEVEL_EXCEEDED = new VideoCodecStatus("LEVEL_EXCEEDED", 4, -2);
        MEMORY = new VideoCodecStatus("MEMORY", 5, -3);
        ERR_PARAMETER = new VideoCodecStatus("ERR_PARAMETER", 6, -4);
        ERR_SIZE = new VideoCodecStatus("ERR_SIZE", 7, -5);
        TIMEOUT = new VideoCodecStatus("TIMEOUT", 8, -6);
        UNINITIALIZED = new VideoCodecStatus("UNINITIALIZED", 9, -7);
        ERR_REQUEST_SLI = new VideoCodecStatus("ERR_REQUEST_SLI", 10, -12);
        FALLBACK_SOFTWARE = new VideoCodecStatus("FALLBACK_SOFTWARE", 11, -13);
        VideoCodecStatus videoCodecStatus = new VideoCodecStatus("TARGET_BITRATE_OVERSHOOT", 12, -14);
        TARGET_BITRATE_OVERSHOOT = videoCodecStatus;
        $VALUES = new VideoCodecStatus[]{REQUEST_SLI, NO_OUTPUT, OK, ERROR, LEVEL_EXCEEDED, MEMORY, ERR_PARAMETER, ERR_SIZE, TIMEOUT, UNINITIALIZED, ERR_REQUEST_SLI, FALLBACK_SOFTWARE, videoCodecStatus};
    }

    public VideoCodecStatus(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.number = i2;
    }

    public static VideoCodecStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (VideoCodecStatus) Enum.valueOf(VideoCodecStatus.class, str);
        }
        return (VideoCodecStatus) invokeL.objValue;
    }

    public static VideoCodecStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (VideoCodecStatus[]) $VALUES.clone();
        }
        return (VideoCodecStatus[]) invokeV.objValue;
    }

    @CalledByNative
    public int getNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.number;
        }
        return invokeV.intValue;
    }
}
