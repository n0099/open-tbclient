package com.win.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
/* loaded from: classes10.dex */
public class Z1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(Context context, String str, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, Float.valueOf(f)})) == null) ? context.getSharedPreferences("_prefs", 0).getFloat(str, f) : invokeCommon.floatValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putString(str, "");
            edit.commit();
        }
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            String trim = str.toUpperCase().trim();
            if (trim.length() % 2 != 0) {
                return null;
            }
            byte[] bArr = new byte[trim.length() / 2];
            int i3 = 0;
            while (i3 < trim.length()) {
                char charAt = trim.charAt(i3);
                if (charAt < '0' || charAt > '9') {
                    if (charAt >= 'A' && charAt <= 'F') {
                        i = charAt - '7';
                    }
                    return null;
                }
                i = charAt - '0';
                int i4 = i * 16;
                int i5 = i3 + 1;
                char charAt2 = trim.charAt(i5);
                if (charAt2 < '0' || charAt2 > '9') {
                    if (charAt2 >= 'A' && charAt2 <= 'F') {
                        i2 = charAt2 - '7';
                    }
                    return null;
                }
                i2 = charAt2 - '0';
                bArr[i5 / 2] = (byte) (i4 + i2);
                i3 = i5 + 1;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static Object b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("_prefs", 0);
                if (sharedPreferences.contains(str)) {
                    String string = sharedPreferences.getString(str, "");
                    if (TextUtils.isEmpty(string)) {
                        return null;
                    }
                    return new ObjectInputStream(new ByteArrayInputStream(a(string))).readObject();
                }
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) ? context.getSharedPreferences("res_prefs", 0).getString("key_local_res", "") : (String) invokeL.objValue;
    }

    public static long a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getLong("bdts", 0L);
        }
        return invokeL.longValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getString("bp", "");
        }
        return (String) invokeL.objValue;
    }

    public static long c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getLong("ck_al", 0L);
        }
        return invokeL.longValue;
    }

    public static long d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getLong("spl_dev_timeout", 2000L);
        }
        return invokeL.longValue;
    }

    public static long e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getLong("draw_video_timeout", 20000L);
        }
        return invokeL.longValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getString("p_i", "");
        }
        return (String) invokeL.objValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getInt("bro_high", 0);
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getInt("jumpsw", 0);
        }
        return invokeL.intValue;
    }

    public static long i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getLong("lu_date", 0L);
        }
        return invokeL.longValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getString("oaid", "");
        }
        return (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getString("oid", "");
        }
        return (String) invokeL.objValue;
    }

    public static String m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getString(TiebaStatic.Params.PID_MERGE, "[]");
        }
        return (String) invokeL.objValue;
    }

    public static int n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getInt("re_pro", 4);
        }
        return invokeL.intValue;
    }

    public static long o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getLong("las", 12L) * 3600 * 1000;
        }
        return invokeL.longValue;
    }

    public static String p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getString("key_show_institial_adid", "");
        }
        return (String) invokeL.objValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getString("key_show_native_adid", "");
        }
        return (String) invokeL.objValue;
    }

    public static long r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getLong("spl_timeout", 1000L);
        }
        return invokeL.longValue;
    }

    public static int s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            return context.getSharedPreferences("_prefs", 0).getInt("timeout_sec", 15);
        }
        return invokeL.intValue;
    }

    public static void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putLong("bdts", currentTimeMillis);
            edit.apply();
        }
    }

    public static void a(Context context, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65538, null, context, f) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("draw_video_height", f);
            edit.apply();
        }
    }

    public static void b(Context context, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65546, null, context, f) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("splash_height", f);
            edit.apply();
        }
    }

    public static void c(Context context, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65550, null, context, f) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putFloat("splash_width", f);
            edit.apply();
        }
    }

    public static void d(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65554, null, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putLong("spl_timeout", j);
            edit.apply();
        }
    }

    public static void e(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, context, str) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putString("lcss", str);
            edit.apply();
        }
    }

    public static void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, context, str) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putString("oaid", str);
            edit.apply();
        }
    }

    public static void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, context, str) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putString("oid", str);
            edit.apply();
        }
    }

    public static void a(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65539, null, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putLong("spl_dev_timeout", j);
            edit.apply();
        }
    }

    public static void b(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, null, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putLong("draw_video_timeout", j);
            edit.apply();
        }
    }

    public static void c(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65551, null, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putLong("lu_date", j);
            edit.apply();
        }
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65555, null, context, str) == null) && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putString("p_i", str);
            edit.apply();
        }
    }

    public static void a(Context context, String str, Object obj) {
        String stringBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, str, obj) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray == null) {
                    stringBuffer = null;
                } else if (byteArray.length == 0) {
                    stringBuffer = "";
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer(byteArray.length);
                    for (byte b : byteArray) {
                        String hexString = Integer.toHexString(b & 255);
                        if (hexString.length() < 2) {
                            stringBuffer2.append(0);
                        }
                        stringBuffer2.append(hexString.toUpperCase());
                    }
                    stringBuffer = stringBuffer2.toString();
                }
                edit.putString(str, stringBuffer);
                edit.commit();
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("", "保存obj失败");
            }
        }
    }

    public static void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, context, str, z) == null) {
            String p = p(context);
            if (!TextUtils.isEmpty(p) && !z) {
                str = p + "," + str;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putString("key_show_institial_adid", str);
            edit.apply();
        }
    }

    public static void b(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65548, null, context, str, z) == null) {
            String q = q(context);
            if (!TextUtils.isEmpty(q) && !z) {
                str = q + "," + str;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            edit.putString("key_show_native_adid", str);
            edit.apply();
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, null, context, str) != null) || context.getSharedPreferences("_prefs", 0).contains("sever_tk")) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("sever_tk", str);
        edit.apply();
    }
}
