package com.kwai.video.player.kwai_player;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.NativeErrorCode;
@Keep
/* loaded from: classes7.dex */
public class Util {
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

    public static boolean isCriticalErrorInMediaPlayer(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
            if (i2 != -5108 && i2 != -5107 && i2 != -5104 && i2 != -5101 && i2 != -5013 && i2 != -1010 && i2 != -1007 && i2 != -1004 && i2 != -110 && i2 != 1 && i2 != 100 && i2 != 200) {
                switch (i2) {
                    case NativeErrorCode.EKS_AVERROR_INVALIDDATA /* -5011 */:
                    case NativeErrorCode.EKS_AVERROR_HTTP_SERVER_ERROR /* -5010 */:
                    case NativeErrorCode.EKS_AVERROR_HTTP_OTHER_4XX /* -5009 */:
                    case NativeErrorCode.EKS_AVERROR_HTTP_NOT_FOUND /* -5008 */:
                    case NativeErrorCode.EKS_AVERROR_HTTP_FORBIDDEN /* -5007 */:
                    case NativeErrorCode.EKS_AVERROR_HTTP_UNAUTHORIZED /* -5006 */:
                    case NativeErrorCode.EKS_AVERROR_HTTP_BAD_REQUEST /* -5005 */:
                    case NativeErrorCode.EKS_AVERROR_ETIMEDOUT /* -5004 */:
                    case NativeErrorCode.EKS_AVERROR_EMFILE /* -5003 */:
                    case NativeErrorCode.EKS_AVERROR_EIO /* -5002 */:
                    case NativeErrorCode.EKS_AVERROR_PROTOCOL_NOT_FOUND /* -5001 */:
                        break;
                    default:
                        return (i2 == -5012 && i3 < 0) || i2 < -20000;
                }
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    public static boolean isHttpForbiddenErrorInMediaPlayer(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) ? -5007 == i2 || -2403 == i3 : invokeII.booleanValue;
    }

    public static boolean isMarlinTokenInvalidInMediaPlayer(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? -5122 == i2 || -5123 == i2 : invokeII.booleanValue;
    }
}
