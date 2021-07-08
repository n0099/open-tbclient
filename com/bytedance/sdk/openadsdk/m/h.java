package com.bytedance.sdk.openadsdk.m;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SensorManager f31519a;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3) {
                return i2;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public static void a(Context context, SensorEventListener sensorEventListener, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, sensorEventListener, i2) == null) || sensorEventListener == null || context == null) {
            return;
        }
        try {
            SensorManager b2 = b(context);
            b2.registerListener(sensorEventListener, b2.getDefaultSensor(1), a(i2));
        } catch (Throwable th) {
            e.a("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static SensorManager b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (f31519a == null) {
                synchronized (h.class) {
                    if (f31519a == null) {
                        f31519a = (SensorManager) context.getSystemService("sensor");
                    }
                }
            }
            return f31519a;
        }
        return (SensorManager) invokeL.objValue;
    }

    public static void a(Context context, SensorEventListener sensorEventListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, context, sensorEventListener) == null) || sensorEventListener == null || context == null) {
            return;
        }
        try {
            b(context).unregisterListener(sensorEventListener);
        } catch (Throwable th) {
            e.a("SensorHub", "stopListen error", th);
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(300L);
    }

    public static void b(Context context, SensorEventListener sensorEventListener, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, context, sensorEventListener, i2) == null) || sensorEventListener == null || context == null) {
            return;
        }
        try {
            SensorManager b2 = b(context);
            b2.registerListener(sensorEventListener, b2.getDefaultSensor(4), a(i2));
        } catch (Throwable th) {
            e.a("SensorHub", "startListenGyroscope error", th);
        }
    }
}
