package com.bytedance.sdk.openadsdk.multipro.d;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.e;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f67748a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (f67748a == null || o.a() == null) {
                k.c("The context of SPHelper is null, please initialize sdk in main process");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static ContentResolver b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            try {
                if (a()) {
                    return c().getContentResolver();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ContentResolver) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            Context context = f67748a;
            return context == null ? o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            return e.f67752b + "/t_sp/";
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65561, null, str, str2) == null) && a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    b2.delete(Uri.parse(d() + "long/" + str2 + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            f67748a = context == null ? o.a() : context.getApplicationContext();
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return "?sp_file_name=" + str;
        }
        return (String) invokeL.objValue;
    }

    public static synchronized void a(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, bool) == null) {
            synchronized (a.class) {
                a((String) null, str, bool);
            }
        }
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, str, str2)) == null) ? b((String) null, str, str2) : (String) invokeLL.objValue;
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, str, str2, bool) == null) {
            synchronized (a.class) {
                if (a()) {
                    try {
                        ContentResolver b2 = b();
                        if (b2 != null) {
                            Uri parse = Uri.parse(d() + "boolean/" + str2 + b(str));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("value", bool);
                            b2.update(parse, contentValues, null, null);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static String b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, null, str, str2, str3)) == null) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        String type = b2.getType(Uri.parse(d() + "string/" + str2 + b(str)));
                        if (type != null) {
                            if (!type.equals(StringUtil.NULL_STRING)) {
                                return type;
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                return str3;
            }
            return str3;
        }
        return (String) invokeLLL.objValue;
    }

    @TargetApi(11)
    public static Set<String> b(String str, String str2, Set<String> set) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, str, str2, set)) == null) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        String type = b2.getType(Uri.parse(d() + "string_set/" + str2 + b(str)));
                        if (type == null || type.equals(StringUtil.NULL_STRING) || !type.matches("\\[.*\\]")) {
                            return set;
                        }
                        String[] split = type.substring(1, type.length() - 1).split(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        HashSet hashSet = new HashSet();
                        for (String str3 : split) {
                            hashSet.add(str3.replace("__COMMA__", StringUtil.ARRAY_ELEMENT_SEPARATOR));
                        }
                        return hashSet;
                    }
                } catch (Throwable unused) {
                }
                return set;
            }
            return set;
        }
        return (Set) invokeLLL.objValue;
    }

    public static synchronized void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            synchronized (a.class) {
                a((String) null, str, str2);
            }
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, str3) == null) {
            synchronized (a.class) {
                if (a()) {
                    try {
                        ContentResolver b2 = b();
                        if (b2 != null) {
                            Uri parse = Uri.parse(d() + "string/" + str2 + b(str));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("value", str3);
                            b2.update(parse, contentValues, null, null);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, num) == null) {
            synchronized (a.class) {
                a((String) null, str, num);
            }
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, str, str2, num) == null) {
            synchronized (a.class) {
                if (a()) {
                    try {
                        ContentResolver b2 = b();
                        if (b2 != null) {
                            Uri parse = Uri.parse(d() + "int/" + str2 + b(str));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("value", num);
                            b2.update(parse, contentValues, null, null);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, l) == null) {
            synchronized (a.class) {
                a((String) null, str, l);
            }
        }
    }

    public static synchronized void a(String str, String str2, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, str, str2, l) == null) {
            synchronized (a.class) {
                if (a()) {
                    try {
                        ContentResolver b2 = b();
                        if (b2 != null) {
                            Uri parse = Uri.parse(d() + "long/" + str2 + b(str));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("value", l);
                            b2.update(parse, contentValues, null, null);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, str, str2, f2) == null) {
            synchronized (a.class) {
                if (a()) {
                    try {
                        ContentResolver b2 = b();
                        if (b2 != null) {
                            Uri parse = Uri.parse(d() + ShaderParams.VALUE_TYPE_FLOAT + "/" + str2 + b(str));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("value", f2);
                            b2.update(parse, contentValues, null, null);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, set) == null) {
            synchronized (a.class) {
                if (a()) {
                    try {
                        ContentResolver b2 = b();
                        if (b2 != null) {
                            Uri parse = Uri.parse(d() + "string_set/" + str2 + b(str));
                            ContentValues contentValues = new ContentValues();
                            HashSet hashSet = new HashSet();
                            for (String str3 : set) {
                                hashSet.add(str3.replace(",", "__COMMA__"));
                            }
                            contentValues.put("value", hashSet.toString());
                            b2.update(parse, contentValues, null, null);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static int a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, str, str2, i2)) == null) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        String type = b2.getType(Uri.parse(d() + "int/" + str2 + b(str)));
                        if (type != null && !type.equals(StringUtil.NULL_STRING)) {
                            return Integer.parseInt(type);
                        }
                    }
                } catch (Throwable unused) {
                }
                return i2;
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    public static float a(String str, String str2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, Float.valueOf(f2)})) == null) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        String type = b2.getType(Uri.parse(d() + ShaderParams.VALUE_TYPE_FLOAT + "/" + str2 + b(str)));
                        if (type != null && !type.equals(StringUtil.NULL_STRING)) {
                            return Float.parseFloat(type);
                        }
                    }
                } catch (Throwable unused) {
                }
                return f2;
            }
            return f2;
        }
        return invokeCommon.floatValue;
    }

    public static boolean a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65554, null, str, z)) == null) ? a((String) null, str, z) : invokeLZ.booleanValue;
    }

    public static boolean a(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65553, null, str, str2, z)) == null) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        String type = b2.getType(Uri.parse(d() + "boolean/" + str2 + b(str)));
                        if (type != null && !type.equals(StringUtil.NULL_STRING)) {
                            return Boolean.parseBoolean(type);
                        }
                    }
                } catch (Throwable unused) {
                }
                return z;
            }
            return z;
        }
        return invokeLLZ.booleanValue;
    }

    public static long a(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j2)) == null) ? a((String) null, str, j2) : invokeLJ.longValue;
    }

    public static long a(String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, Long.valueOf(j2)})) == null) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        String type = b2.getType(Uri.parse(d() + "long/" + str2 + b(str)));
                        if (type != null && !type.equals(StringUtil.NULL_STRING)) {
                            return Long.parseLong(type);
                        }
                    }
                } catch (Throwable unused) {
                }
                return j2;
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) && a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    b2.delete(Uri.parse(d() + "clean" + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
