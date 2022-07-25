package com.kuaishou.weapon.p0;

import android.app.KeyguardManager;
import android.content.Context;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public g1() {
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r7 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (r7 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        r7.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject a(Context context, String str) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, context, str)) != null) {
            return (JSONObject) invokeLL.objValue;
        }
        jSONObject = new JSONObject();
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://settings/" + str), null, null, null, null);
            while (cursor.moveToNext()) {
                try {
                    String string = cursor.getString(cursor.getColumnIndex("name"));
                    String string2 = cursor.getString(cursor.getColumnIndex("value"));
                    if (!TextUtils.isEmpty(string) && !string.equals(HttpRequest.ANDROID_ID) && !TextUtils.isEmpty(string2) && string2.length() < 20) {
                        jSONObject.put(string, string2);
                    }
                } catch (Throwable unused) {
                }
            }
            cursor.close();
        } catch (Throwable unused2) {
            cursor = null;
        }
        return jSONObject;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static JSONObject g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String[] strArr = {"system", "global", ClientCookie.SECURE_ATTR};
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < 3; i++) {
                try {
                    String str = strArr[i];
                    JSONObject a = a(context, str);
                    if (a != null && a.length() > 0) {
                        jSONObject.put(str, a);
                    }
                } catch (Exception unused) {
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            try {
                Class<?> cls = Class.forName("com.android.internal.widget.LockPatternUtils");
                return ((Boolean) cls.getMethod("isSecure", new Class[0]).invoke(cls.getConstructor(Context.class).newInstance(context), new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? Build.VERSION.SDK_INT >= 16 ? ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure() : h(context) : invokeL.booleanValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager == null) {
                    return i1.b;
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
                return TextUtils.isEmpty(jSONObject2) ? i1.c : jSONObject2;
            } catch (Throwable unused) {
                return i1.d;
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }

    public JSONObject c(Context context) {
        List<Sensor> sensorList;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                for (Sensor sensor : sensorList) {
                    jSONObject.put(sensor.getName(), sensor.getVendor());
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode() : invokeL.booleanValue;
    }

    public boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            try {
                KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
                return Build.VERSION.SDK_INT >= 28 ? keyguardManager.isKeyguardLocked() : keyguardManager.inKeyguardRestrictedInputMode();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
