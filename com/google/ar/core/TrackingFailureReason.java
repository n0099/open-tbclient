package com.google.ar.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.exceptions.FatalException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class TrackingFailureReason {
    public static final /* synthetic */ TrackingFailureReason[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TrackingFailureReason BAD_STATE;
    public static final TrackingFailureReason EXCESSIVE_MOTION;
    public static final TrackingFailureReason INSUFFICIENT_FEATURES;
    public static final TrackingFailureReason INSUFFICIENT_LIGHT;
    public static final TrackingFailureReason NONE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int nativeCode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2049993106, "Lcom/google/ar/core/TrackingFailureReason;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2049993106, "Lcom/google/ar/core/TrackingFailureReason;");
                return;
            }
        }
        NONE = new TrackingFailureReason(PolyActivity.NONE_PANEL_TYPE, 0, 0);
        BAD_STATE = new TrackingFailureReason("BAD_STATE", 1, 1);
        INSUFFICIENT_LIGHT = new TrackingFailureReason("INSUFFICIENT_LIGHT", 2, 2);
        EXCESSIVE_MOTION = new TrackingFailureReason("EXCESSIVE_MOTION", 3, 3);
        TrackingFailureReason trackingFailureReason = new TrackingFailureReason("INSUFFICIENT_FEATURES", 4, 4);
        INSUFFICIENT_FEATURES = trackingFailureReason;
        $VALUES = new TrackingFailureReason[]{NONE, BAD_STATE, INSUFFICIENT_LIGHT, EXCESSIVE_MOTION, trackingFailureReason};
    }

    public TrackingFailureReason(String str, int i2, int i3) {
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

    public static TrackingFailureReason forNumber(int i2) {
        InterceptResult invokeI;
        TrackingFailureReason[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (TrackingFailureReason trackingFailureReason : values()) {
                if (trackingFailureReason.nativeCode == i2) {
                    return trackingFailureReason;
                }
            }
            StringBuilder sb = new StringBuilder(68);
            sb.append("Unexpected value for native TrackingFailureReason, value=");
            sb.append(i2);
            throw new FatalException(sb.toString());
        }
        return (TrackingFailureReason) invokeI.objValue;
    }

    public static TrackingFailureReason valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TrackingFailureReason) Enum.valueOf(TrackingFailureReason.class, str) : (TrackingFailureReason) invokeL.objValue;
    }

    public static TrackingFailureReason[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TrackingFailureReason[]) $VALUES.clone() : (TrackingFailureReason[]) invokeV.objValue;
    }
}
