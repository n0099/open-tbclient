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
/* renamed from: com.kuaishou.weapon.p0.ʻᐧ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public final class C0309 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String f49 = "Y29tLmt3YWkud2VhcG9u";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String f50 = "Y29tLmt3YWkud2VhcG9uLnNldHRpbmdz";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String f51 = "Y29tLmt3YWkud2VhcG9uLmZpbGU=";

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final String f52 = "weapon.set";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static String f53;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335318923, "Lcom/kuaishou/weapon/p0/ʻᐧ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335318923, "Lcom/kuaishou/weapon/p0/ʻᐧ;");
                return;
            }
        }
        f49 = C0446.m976("Y29tLmt3YWkud2VhcG9u", 2);
        f50 = C0446.m976(f50, 2);
        f51 = C0446.m976(f51, 2);
    }

    public C0309() {
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

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:5:0x0006, B:11:0x0021, B:13:0x0027, B:14:0x002f, B:20:0x004b, B:22:0x0051, B:25:0x005b, B:19:0x0047, B:10:0x001d), top: B:32:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051 A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #0 {all -> 0x0094, blocks: (B:5:0x0006, B:11:0x0021, B:13:0x0027, B:14:0x002f, B:20:0x004b, B:22:0x0051, B:25:0x005b, B:19:0x0047, B:10:0x001d), top: B:32:0x0006 }] */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m194(Context context) {
        InterceptResult invokeL;
        String m865;
        String m894;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                C0374 m389 = C0374.m389(context);
                boolean m408 = m389.m408("a1_p_s_p_s");
                boolean m4082 = m389.m408("a1_p_s_p_s_c_b");
                if (!m408 && !m4082) {
                    m865 = "";
                    if (TextUtils.isEmpty(m865)) {
                        m865 = UUID.randomUUID().toString();
                    }
                    String str = m865 + f49;
                    if (!m408 && !m4082) {
                        m894 = "";
                        String stringBuffer = new StringBuffer((!TextUtils.isEmpty(m894) || m894.startsWith("RISK")) ? "0" : "0").reverse().toString();
                        String m174 = C0304.m174(str);
                        return new C0297(context).m152(m174.toUpperCase() + "|" + stringBuffer.toUpperCase(), C0453.f719);
                    }
                    m894 = C0433.m894(context);
                    String stringBuffer2 = new StringBuffer((!TextUtils.isEmpty(m894) || m894.startsWith("RISK")) ? "0" : "0").reverse().toString();
                    String m1742 = C0304.m174(str);
                    return new C0297(context).m152(m1742.toUpperCase() + "|" + stringBuffer2.toUpperCase(), C0453.f719);
                }
                m865 = C0433.m865(context);
                if (TextUtils.isEmpty(m865)) {
                }
                String str2 = m865 + f49;
                if (!m408) {
                    m894 = "";
                    String stringBuffer22 = new StringBuffer((!TextUtils.isEmpty(m894) || m894.startsWith("RISK")) ? "0" : "0").reverse().toString();
                    String m17422 = C0304.m174(str2);
                    return new C0297(context).m152(m17422.toUpperCase() + "|" + stringBuffer22.toUpperCase(), C0453.f719);
                }
                m894 = C0433.m894(context);
                String stringBuffer222 = new StringBuffer((!TextUtils.isEmpty(m894) || m894.startsWith("RISK")) ? "0" : "0").reverse().toString();
                String m174222 = C0304.m174(str2);
                return new C0297(context).m152(m174222.toUpperCase() + "|" + stringBuffer222.toUpperCase(), C0453.f719);
            } catch (Throwable unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m195(Context context, String str) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static synchronized String m196(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (C0309.class) {
                if (TextUtils.isEmpty(f53)) {
                    String m203 = m203(context);
                    f53 = m203;
                    return m203;
                }
                return f53;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x001b: INVOKE  (r1v0 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m197(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            try {
                if (m199(context)) {
                    ContentResolver contentResolver = context.getContentResolver();
                    Settings.System.putString(contentResolver, f50, str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(System.currentTimeMillis());
                    Settings.System.putString(contentResolver, f52, sb.toString());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static void m198(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, context, str) == null) {
            C0374.m389(context).m423(str);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static boolean m199(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(context.getApplicationContext()) : invokeL.booleanValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String m200(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                return C0374.m389(context).m419();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public static void m201(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            m197(context, str);
            m198(context, str);
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public static String m202(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            String m195 = m195(context, f50);
            String m200 = m200(context);
            if (TextUtils.isEmpty(m195) || !TextUtils.equals(m195, m200)) {
                if (!TextUtils.isEmpty(m195)) {
                    m198(context, m195);
                    return m195;
                } else if (TextUtils.isEmpty(m200)) {
                    return "";
                } else {
                    m197(context, m200);
                    return m200;
                }
            }
            return m195;
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ˆ  reason: contains not printable characters */
    public static String m203(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            String m202 = m202(context);
            if (TextUtils.isEmpty(m202)) {
                String m194 = m194(context);
                if (!TextUtils.isEmpty(m194)) {
                    m201(context, m194);
                }
                return m194;
            }
            return m202;
        }
        return (String) invokeL.objValue;
    }
}
