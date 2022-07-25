package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class s1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "Y29tLmt3YWkud2VhcG9u";
    public static String b = "Y29tLmt3YWkud2VhcG9uLnNldHRpbmdz";
    public static String c = "Y29tLmt3YWkud2VhcG9uLmZpbGU=";
    public static final String d = "weapon.set";
    public static String e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334599289, "Lcom/kuaishou/weapon/p0/s1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334599289, "Lcom/kuaishou/weapon/p0/s1;");
                return;
            }
        }
        a = d.b("Y29tLmt3YWkud2VhcG9u", 2);
        b = d.b(b, 2);
        c = d.b(c, 2);
    }

    public s1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029 A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:5:0x0006, B:11:0x0023, B:13:0x0029, B:14:0x0031, B:20:0x004d, B:22:0x0053, B:25:0x005d, B:19:0x0049, B:10:0x001f), top: B:32:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[Catch: all -> 0x0096, TRY_LEAVE, TryCatch #0 {all -> 0x0096, blocks: (B:5:0x0006, B:11:0x0023, B:13:0x0029, B:14:0x0031, B:20:0x004d, B:22:0x0053, B:25:0x005d, B:19:0x0049, B:10:0x001f), top: B:32:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        InterceptResult invokeL;
        String c2;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                i a2 = i.a(context, "re_po_rt");
                boolean b2 = a2.b("a1_p_s_p_s");
                boolean b3 = a2.b("a1_p_s_p_s_c_b");
                if (!b2 && !b3) {
                    c2 = "";
                    if (TextUtils.isEmpty(c2)) {
                        c2 = UUID.randomUUID().toString();
                    }
                    String str = c2 + a;
                    if (!b2 && !b3) {
                        p = "";
                        String stringBuffer = new StringBuffer((!TextUtils.isEmpty(p) || p.startsWith("RISK")) ? "0" : "0").reverse().toString();
                        String a3 = g.a(str);
                        return new n1(context).c(a3.toUpperCase() + "|" + stringBuffer.toUpperCase(), i1.s);
                    }
                    p = h1.p(context);
                    String stringBuffer2 = new StringBuffer((!TextUtils.isEmpty(p) || p.startsWith("RISK")) ? "0" : "0").reverse().toString();
                    String a32 = g.a(str);
                    return new n1(context).c(a32.toUpperCase() + "|" + stringBuffer2.toUpperCase(), i1.s);
                }
                c2 = h1.c(context);
                if (TextUtils.isEmpty(c2)) {
                }
                String str2 = c2 + a;
                if (!b2) {
                    p = "";
                    String stringBuffer22 = new StringBuffer((!TextUtils.isEmpty(p) || p.startsWith("RISK")) ? "0" : "0").reverse().toString();
                    String a322 = g.a(str2);
                    return new n1(context).c(a322.toUpperCase() + "|" + stringBuffer22.toUpperCase(), i1.s);
                }
                p = h1.p(context);
                String stringBuffer222 = new StringBuffer((!TextUtils.isEmpty(p) || p.startsWith("RISK")) ? "0" : "0").reverse().toString();
                String a3222 = g.a(str2);
                return new n1(context).c(a3222.toUpperCase() + "|" + stringBuffer222.toUpperCase(), i1.s);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                return Settings.System.getString(context.getContentResolver(), str);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (s1.class) {
                if (TextUtils.isEmpty(e)) {
                    String f = f(context);
                    e = f;
                    return f;
                }
                return e;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x001b: INVOKE  (r1v0 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            try {
                if (c(context)) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Settings.System.putString(contentResolver, b, str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    Settings.System.putString(contentResolver, d, sb.toString());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            f3.a(context).c(str);
        }
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext()) : invokeL.booleanValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return f3.a(context).d();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            b(context, str);
            c(context, str);
        }
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            String a2 = a(context, b);
            String d2 = d(context);
            if (TextUtils.isEmpty(a2) || !TextUtils.equals(a2, d2)) {
                if (!TextUtils.isEmpty(a2)) {
                    c(context, a2);
                    return a2;
                } else if (TextUtils.isEmpty(d2)) {
                    return "";
                } else {
                    b(context, d2);
                    return d2;
                }
            }
            return a2;
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            String e2 = e(context);
            if (TextUtils.isEmpty(e2)) {
                String a2 = a(context);
                if (!TextUtils.isEmpty(a2)) {
                    d(context, a2);
                }
                return a2;
            }
            return e2;
        }
        return (String) invokeL.objValue;
    }
}
