package com.google.ar.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.exceptions.FatalException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class TrackingState {
    public static final /* synthetic */ TrackingState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TrackingState PAUSED;
    public static final TrackingState STOPPED;
    public static final TrackingState TRACKING;
    public transient /* synthetic */ FieldHolder $fh;
    public final int nativeCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-614015281, "Lcom/google/ar/core/TrackingState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-614015281, "Lcom/google/ar/core/TrackingState;");
                return;
            }
        }
        TRACKING = new TrackingState("TRACKING", 0, 0);
        PAUSED = new TrackingState("PAUSED", 1, 1);
        TrackingState trackingState = new TrackingState("STOPPED", 2, 2);
        STOPPED = trackingState;
        $VALUES = new TrackingState[]{TRACKING, PAUSED, trackingState};
    }

    public TrackingState(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.nativeCode = i3;
    }

    public static TrackingState forNumber(int i2) {
        InterceptResult invokeI;
        TrackingState[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (TrackingState trackingState : values()) {
                if (trackingState.nativeCode == i2) {
                    return trackingState;
                }
            }
            StringBuilder sb = new StringBuilder(60);
            sb.append("Unexpected value for native TrackingState, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
        return (TrackingState) invokeI.objValue;
    }

    public static TrackingState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TrackingState) Enum.valueOf(TrackingState.class, str) : (TrackingState) invokeL.objValue;
    }

    public static TrackingState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TrackingState[]) $VALUES.clone() : (TrackingState[]) invokeV.objValue;
    }
}
