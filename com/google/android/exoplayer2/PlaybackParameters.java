package com.google.android.exoplayer2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
/* loaded from: classes7.dex */
public final class PlaybackParameters {
    public static /* synthetic */ Interceptable $ic;
    public static final PlaybackParameters DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;
    public final float pitch;
    public final int scaledUsPerMs;
    public final float speed;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-572094856, "Lcom/google/android/exoplayer2/PlaybackParameters;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-572094856, "Lcom/google/android/exoplayer2/PlaybackParameters;");
                return;
            }
        }
        DEFAULT = new PlaybackParameters(1.0f, 1.0f);
    }

    public PlaybackParameters(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.speed = f2;
        this.pitch = f3;
        this.scaledUsPerMs = Math.round(f2 * 1000.0f);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PlaybackParameters.class != obj.getClass()) {
                return false;
            }
            PlaybackParameters playbackParameters = (PlaybackParameters) obj;
            return this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch;
        }
        return invokeL.booleanValue;
    }

    public long getSpeedAdjustedDurationUs(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? j2 * this.scaledUsPerMs : invokeJ.longValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((PayBeanFactory.BEAN_ID_WIDTHDRAW + Float.floatToRawIntBits(this.speed)) * 31) + Float.floatToRawIntBits(this.pitch) : invokeV.intValue;
    }
}
