package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.tieba.a1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.w0b;
import com.baidu.tieba.x0b;
import com.baidu.tieba.z0b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "c";
    public static Map<String, String> b;
    public static final Object c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "2A57086C86EF54970C1E6EB37BFC72B1" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1676230712, "Lcom/huawei/hms/opendevice/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1676230712, "Lcom/huawei/hms/opendevice/c;");
                return;
            }
        }
        b = new HashMap();
        c = new Object();
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return a(d(), e(), c(), g());
        }
        return (byte[]) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return a("d");
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return a("m");
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return a("p");
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return a("s");
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return a("t");
        }
        return (String) invokeV.objValue;
    }

    public static z0b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return z0b.d(d(), e(), c(), g());
        }
        return (z0b) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return !TextUtils.isEmpty(f());
        }
        return invokeV.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = b.get(str);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static void a(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, context) == null) {
            String c2 = p.c(context.getApplicationContext());
            if (!TextUtils.isEmpty(c2)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c2);
                    sb.append("/files/s");
                    a("s", str, sb.toString());
                } catch (IOException unused) {
                    HMSLog.e(a, "save keyS IOException.");
                }
            }
        }
    }

    public static void a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3) == null) {
            HMSLog.i(a, "save local secret key.");
            BufferedWriter bufferedWriter = null;
            try {
                File file = new File(str3);
                s.a(file);
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter);
                    try {
                        bufferedWriter2.write(str2);
                        bufferedWriter2.flush();
                        b.put(str, str2);
                        IOUtils.closeQuietly((Writer) outputStreamWriter);
                        IOUtils.closeQuietly((Writer) bufferedWriter2);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        IOUtils.closeQuietly((Writer) outputStreamWriter);
                        IOUtils.closeQuietly((Writer) bufferedWriter);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = null;
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, str4, str5, context}) == null) {
            String c2 = p.c(context.getApplicationContext());
            if (!TextUtils.isEmpty(c2)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c2);
                    sb.append("/files/math/m");
                    a("m", str, sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(c2);
                    sb2.append("/files/panda/p");
                    a("p", str2, sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(c2);
                    sb3.append("/files/panda/d");
                    a("d", str3, sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(c2);
                    sb4.append("/files/math/t");
                    a("t", str4, sb4.toString());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(c2);
                    sb5.append("/files/s");
                    a("s", str5, sb5.toString());
                } catch (IOException unused) {
                    HMSLog.e(a, "save key IOException.");
                }
            }
        }
    }

    public static byte[] a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return a(a(a(a.a(context.getString(R.string.obfuscated_res_0x7f0f103b)), a.a(context.getString(R.string.obfuscated_res_0x7f0f103a))), a.a(a())));
        }
        return (byte[]) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (!i()) {
                HMSLog.i(a, "work key is empty, execute init.");
                c(context);
            }
            String b2 = a1b.b(f(), b());
            if (t.a(b2)) {
                return b2;
            }
            return e(context);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, str, str2, str3, str4)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return w0b.e(str, str2, str3, str4, 32, true);
            }
            return w0b.e(str, str2, str3, str4, 32, false);
        }
        return (byte[]) invokeLLLL.objValue;
    }

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            if (bArr != null && bArr.length != 0) {
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] >> 2);
                }
                return bArr;
            }
            return new byte[0];
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bArr, bArr2)) == null) {
            if (bArr != null && bArr2 != null && bArr.length != 0 && bArr2.length != 0) {
                int length = bArr.length;
                if (length != bArr2.length) {
                    return new byte[0];
                }
                byte[] bArr3 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
                }
                return bArr3;
            }
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, context) == null) {
            synchronized (c) {
                d(context.getApplicationContext());
                if (i()) {
                    HMSLog.i(a, "The local secret is already in separate file mode.");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(p.c(context.getApplicationContext()));
                sb.append("/shared_prefs/LocalAvengers.xml");
                File file = new File(sb.toString());
                if (file.exists()) {
                    s1b.d(file);
                    HMSLog.i(a, "destroy C, delete file LocalAvengers.xml.");
                }
                byte[] c2 = x0b.c(32);
                byte[] c3 = x0b.c(32);
                byte[] c4 = x0b.c(32);
                byte[] c5 = x0b.c(32);
                String a2 = a.a(c2);
                String a3 = a.a(c3);
                String a4 = a.a(c4);
                String a5 = a.a(c5);
                a(a2, a3, a4, a5, a1b.c(a.a(x0b.c(32)), a(a2, a3, a4, a5)), context);
                HMSLog.i(a, "generate D.");
            }
        }
    }

    public static synchronized String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            synchronized (c.class) {
                String b2 = a1b.b(f(), b());
                if (t.a(b2)) {
                    HMSLog.i(a, "keyS has been upgraded, no require operate again.");
                    return b2;
                }
                String a2 = a1b.a(f(), h());
                if (t.a(a2)) {
                    HMSLog.i(a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                    a(a1b.c(a2, b()), context);
                    return a2;
                }
                String b3 = a1b.b(f(), w0b.e(d(), e(), c(), g(), 32, false));
                if (t.a(b3)) {
                    HMSLog.i(a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                    a(a1b.c(b3, b()), context);
                    return b3;
                }
                HMSLog.e(a, "all mode unable to decrypt root key.");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, context) == null) {
            if (i()) {
                HMSLog.i(a, "secretKeyCache not empty.");
                return;
            }
            b.clear();
            String c2 = p.c(context);
            if (!TextUtils.isEmpty(c2)) {
                String a2 = s.a(c2 + "/files/math/m");
                String a3 = s.a(c2 + "/files/panda/p");
                String a4 = s.a(c2 + "/files/panda/d");
                String a5 = s.a(c2 + "/files/math/t");
                String a6 = s.a(c2 + "/files/s");
                if (t.a(a2, a3, a4, a5, a6)) {
                    b.put("m", a2);
                    b.put("p", a3);
                    b.put("d", a4);
                    b.put("t", a5);
                    b.put("s", a6);
                }
            }
        }
    }
}
