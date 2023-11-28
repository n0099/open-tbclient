package com.kuaishou.weapon.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes10.dex */
public final class bs {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "weapon.set";
    public static String b = "Y29tLmt3YWkud2VhcG9u";
    public static String c = "Y29tLmt3YWkud2VhcG9uLnNldHRpbmdz";
    public static String d = "Y29tLmt3YWkud2VhcG9uLmZpbGU=";
    public static String e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334584998, "Lcom/kuaishou/weapon/p0/bs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334584998, "Lcom/kuaishou/weapon/p0/bs;");
                return;
            }
        }
        b = c.b("Y29tLmt3YWkud2VhcG9u", 2);
        c = c.b(c, 2);
        d = c.b(d, 2);
    }

    public bs() {
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

    public static synchronized String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (bs.class) {
                if (!TextUtils.isEmpty(e)) {
                    return e;
                }
                String c2 = c(context);
                e = c2;
                return c2;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 23 && !Settings.System.canWrite(context.getApplicationContext())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String e2 = e(context);
            if (!TextUtils.isEmpty(e2)) {
                return e2;
            }
            String d2 = d(context);
            if (!TextUtils.isEmpty(d2)) {
                b(context, d2);
            }
            return d2;
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                return df.a(context).d();
            } catch (Exception unused) {
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
                return ApiReplaceUtil.getString(context.getContentResolver(), str);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            c(context, str);
            d(context, str);
        }
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            df.a(context).c(str);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x001b: INVOKE  (r1v0 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            try {
                if (!b(context)) {
                    return;
                }
                ContentResolver contentResolver = context.getContentResolver();
                Settings.System.putString(contentResolver, c, str);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                Settings.System.putString(contentResolver, a, sb.toString());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:5:0x0006, B:11:0x0023, B:15:0x0032, B:21:0x004e, B:23:0x0054, B:26:0x005e, B:20:0x004a, B:14:0x002a, B:10:0x001f), top: B:33:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054 A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:5:0x0006, B:11:0x0023, B:15:0x0032, B:21:0x004e, B:23:0x0054, B:26:0x005e, B:20:0x004a, B:14:0x002a, B:10:0x001f), top: B:33:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context) {
        InterceptResult invokeL;
        String f;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                h a2 = h.a(context, "re_po_rt");
                boolean e2 = a2.e("a1_p_s_p_s");
                boolean e3 = a2.e("a1_p_s_p_s_c_b");
                if (!e2 && !e3) {
                    f = "";
                    if (!TextUtils.isEmpty(f)) {
                        f = UUID.randomUUID().toString();
                    }
                    String str = f + b;
                    if (!e2 && !e3) {
                        c2 = "";
                        String stringBuffer = new StringBuffer((!TextUtils.isEmpty(c2) || c2.startsWith("RISK")) ? "0" : "0").reverse().toString();
                        String a3 = f.a(str);
                        return new bn(context).a(a3.toUpperCase() + "|" + stringBuffer.toUpperCase(), bi.u);
                    }
                    c2 = bh.c(context);
                    String stringBuffer2 = new StringBuffer((!TextUtils.isEmpty(c2) || c2.startsWith("RISK")) ? "0" : "0").reverse().toString();
                    String a32 = f.a(str);
                    return new bn(context).a(a32.toUpperCase() + "|" + stringBuffer2.toUpperCase(), bi.u);
                }
                f = bh.f(context);
                if (!TextUtils.isEmpty(f)) {
                }
                String str2 = f + b;
                if (!e2) {
                    c2 = "";
                    String stringBuffer22 = new StringBuffer((!TextUtils.isEmpty(c2) || c2.startsWith("RISK")) ? "0" : "0").reverse().toString();
                    String a322 = f.a(str2);
                    return new bn(context).a(a322.toUpperCase() + "|" + stringBuffer22.toUpperCase(), bi.u);
                }
                c2 = bh.c(context);
                String stringBuffer222 = new StringBuffer((!TextUtils.isEmpty(c2) || c2.startsWith("RISK")) ? "0" : "0").reverse().toString();
                String a3222 = f.a(str2);
                return new bn(context).a(a3222.toUpperCase() + "|" + stringBuffer222.toUpperCase(), bi.u);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            String a2 = a(context, c);
            String f = f(context);
            if (!TextUtils.isEmpty(a2) && TextUtils.equals(a2, f)) {
                return a2;
            }
            if (!TextUtils.isEmpty(a2)) {
                d(context, a2);
                return a2;
            } else if (!TextUtils.isEmpty(f)) {
                c(context, f);
                return f;
            } else {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
