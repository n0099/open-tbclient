package com.kuaishou.weapon.p0;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public bg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = -1;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        }
        return invokeL.booleanValue;
    }

    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            try {
                KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
                if (Build.VERSION.SDK_INT >= 28) {
                    return keyguardManager.isKeyguardLocked();
                }
                return keyguardManager.inKeyguardRestrictedInputMode();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
            }
            return g(context);
        }
        return invokeL.booleanValue;
    }

    private boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            try {
                Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
                return ((Boolean) cls.getMethod("isSecure", new Class[0]).invoke(cls.getConstructor(Context.class).newInstance(context), new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager == null) {
                    return bi.b;
                }
                int streamMaxVolume = audioManager.getStreamMaxVolume(0);
                int streamVolume = audioManager.getStreamVolume(0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", streamMaxVolume + ":" + streamVolume);
                int streamMaxVolume2 = audioManager.getStreamMaxVolume(1);
                int streamVolume2 = audioManager.getStreamVolume(1);
                jSONObject.put("1", streamMaxVolume2 + ":" + streamVolume2);
                int streamMaxVolume3 = audioManager.getStreamMaxVolume(2);
                int streamVolume3 = audioManager.getStreamVolume(2);
                jSONObject.put("2", streamMaxVolume3 + ":" + streamVolume3);
                int streamMaxVolume4 = audioManager.getStreamMaxVolume(3);
                int streamVolume4 = audioManager.getStreamVolume(3);
                jSONObject.put("3", streamMaxVolume4 + ":" + streamVolume4);
                int streamMaxVolume5 = audioManager.getStreamMaxVolume(4);
                int streamVolume5 = audioManager.getStreamVolume(4);
                jSONObject.put("4", streamMaxVolume5 + ":" + streamVolume5);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return bi.c;
                }
                return jSONObject2;
            } catch (Throwable unused) {
                return bi.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public JSONObject f(Context context) {
        List<Sensor> sensorList;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (Sensor sensor : sensorList) {
                        jSONObject.put(sensor.getName(), sensor.getVendor());
                    }
                    return jSONObject;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
