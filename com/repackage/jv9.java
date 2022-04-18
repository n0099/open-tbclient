package com.repackage;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.mobstat.Config;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.hdid.DeviceManagerV2;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.NetworkInterface;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class jv9 {
    public static /* synthetic */ Interceptable $ic;
    public static final jv9 b;
    public static final Object c;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static String a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-258186361, "Lcom/repackage/jv9$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-258186361, "Lcom/repackage/jv9$a;");
            }
        }

        @SuppressLint({"NewApi"})
        public static String a() {
            InterceptResult invokeV;
            byte[] hardwareAddress;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                String str = null;
                try {
                    if (Build.VERSION.SDK_INT >= 9) {
                        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                        while (networkInterfaces.hasMoreElements()) {
                            NetworkInterface nextElement = networkInterfaces.nextElement();
                            if (nextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                                StringBuilder sb = new StringBuilder();
                                int length = hardwareAddress.length;
                                for (int i = 0; i < length; i++) {
                                    sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                                }
                                if (sb.length() > 0) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                str = sb.toString();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return str;
            }
            return (String) invokeV.objValue;
        }

        public static String b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (a != null) {
                    return a;
                }
                a = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                return a;
            }
            return (String) invokeL.objValue;
        }

        public static boolean c(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
                boolean z = false;
                try {
                    if (Build.VERSION.SDK_INT < 23 ? context.getPackageManager().checkPermission(str, context.getPackageName()) == 0 : context.checkSelfPermission(str) == 0) {
                        z = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return z;
            }
            return invokeLL.booleanValue;
        }

        public static boolean d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TextUtils.isEmpty(str) || str.equalsIgnoreCase(Config.DEF_MAC_ID)) ? false : true : invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final char[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-258186330, "Lcom/repackage/jv9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-258186330, "Lcom/repackage/jv9$b;");
                    return;
                }
            }
            a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        }

        public static int a(char c) {
            InterceptResult invokeCommon;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c)})) == null) {
                if (c < 'A' || c > 'Z') {
                    if (c >= 'a' && c <= 'z') {
                        i = c - 'a';
                    } else if (c < '0' || c > '9') {
                        if (c != '+') {
                            if (c != '/') {
                                if (c == '=') {
                                    return 0;
                                }
                                throw new RuntimeException("unexpected code: ".concat(String.valueOf(c)));
                            }
                            return 63;
                        }
                        return 62;
                    } else {
                        i = (c - '0') + 26;
                    }
                    return i + 26;
                }
                return c - 'A';
            }
            return invokeCommon.intValue;
        }

        public static String b(byte[] bArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
                int length = bArr.length;
                StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
                int i = length - 3;
                int i2 = 0;
                while (i2 <= i) {
                    int i3 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
                    stringBuffer.append(a[(i3 >> 18) & 63]);
                    stringBuffer.append(a[(i3 >> 12) & 63]);
                    stringBuffer.append(a[(i3 >> 6) & 63]);
                    stringBuffer.append(a[i3 & 63]);
                    i2 += 3;
                }
                int i4 = length + 0;
                if (i2 != i4 - 2) {
                    if (i2 == i4 - 1) {
                        int i5 = (bArr[i2] & 255) << 16;
                        stringBuffer.append(a[(i5 >> 18) & 63]);
                        stringBuffer.append(a[(i5 >> 12) & 63]);
                        str = "==";
                    }
                    return stringBuffer.toString();
                }
                int i6 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
                stringBuffer.append(a[(i6 >> 18) & 63]);
                stringBuffer.append(a[(i6 >> 12) & 63]);
                stringBuffer.append(a[(i6 >> 6) & 63]);
                str = "=";
                stringBuffer.append(str);
                return stringBuffer.toString();
            }
            return (String) invokeL.objValue;
        }

        public static void c(String str, OutputStream outputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(65539, null, str, outputStream) != null) {
                return;
            }
            int length = str.length();
            int i = 0;
            while (true) {
                if (i < length && str.charAt(i) <= ' ') {
                    i++;
                } else if (i == length) {
                    return;
                } else {
                    int i2 = i + 2;
                    int i3 = i + 3;
                    int a2 = (a(str.charAt(i)) << 18) + (a(str.charAt(i + 1)) << 12) + (a(str.charAt(i2)) << 6) + a(str.charAt(i3));
                    outputStream.write((a2 >> 16) & 255);
                    if (str.charAt(i2) == '=') {
                        return;
                    }
                    outputStream.write((a2 >> 8) & 255);
                    if (str.charAt(i3) == '=') {
                        return;
                    }
                    outputStream.write(a2 & 255);
                    i += 4;
                }
            }
        }

        public static byte[] d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    c(str, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        PrintStream printStream = System.err;
                        printStream.println("Error while decoding BASE64: " + e.toString());
                    }
                    return byteArray;
                } catch (IOException unused) {
                    throw new RuntimeException();
                }
            }
            return (byte[]) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? c(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))) : (String) invokeL.objValue;
        }

        public static String b(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? b.b(d(str.getBytes("UTF-8"), str2.getBytes("UTF-8"))) : (String) invokeLL.objValue;
        }

        public static String c(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
                StringBuilder sb = new StringBuilder();
                if (bArr != null) {
                    for (byte b : bArr) {
                        sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
                    }
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        public static byte[] d(byte[] bArr, byte[] bArr2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, bArr2)) == null) {
                SecureRandom secureRandom = new SecureRandom();
                SecretKey generateSecret = SecretKeyFactory.getInstance(Coder.KEY_DES).generateSecret(new DESKeySpec(bArr2));
                Cipher cipher = Cipher.getInstance(Coder.KEY_DES);
                cipher.init(1, generateSecret, secureRandom);
                return cipher.doFinal(bArr);
            }
            return (byte[]) invokeLL.objValue;
        }

        public static String e(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
                if (str == null) {
                    return null;
                }
                return f(g(b.d(str), str2.getBytes("UTF-8")));
            }
            return (String) invokeLL.objValue;
        }

        public static String f(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? new String(bArr, "UTF-8") : (String) invokeL.objValue;
        }

        public static byte[] g(byte[] bArr, byte[] bArr2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bArr, bArr2)) == null) {
                SecureRandom secureRandom = new SecureRandom();
                SecretKey generateSecret = SecretKeyFactory.getInstance(Coder.KEY_DES).generateSecret(new DESKeySpec(bArr2));
                Cipher cipher = Cipher.getInstance(Coder.KEY_DES);
                cipher.init(2, generateSecret, secureRandom);
                return cipher.doFinal(bArr);
            }
            return (byte[]) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public JSONObject f;
        public long g;
        public int h;
        public String i;

        public d() {
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
            this.d = "0";
            this.g = 0L;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: Removed duplicated region for block: B:47:0x0078 A[Catch: IOException -> 0x0074, TRY_LEAVE, TryCatch #2 {IOException -> 0x0074, blocks: (B:43:0x0070, B:47:0x0078), top: B:55:0x0070 }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final String a(String str) {
            InterceptResult invokeL;
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, str)) != null) {
                return (String) invokeL.objValue;
            }
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return null;
                }
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            String trim = new String(byteArrayOutputStream.toByteArray(), "UTF-8").trim();
                            try {
                                fileInputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return trim;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return null;
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    if (fileInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                fileInputStream = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755575068, "Lcom/repackage/jv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755575068, "Lcom/repackage/jv9;");
                return;
            }
        }
        b = new jv9();
        c = FilenameFilter.class;
    }

    public jv9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public static d a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject == null) {
                return null;
            }
            String e3 = e(jSONObject, "hdid");
            String e4 = e(jSONObject, "type");
            String e5 = e(jSONObject, "imei");
            String e6 = e(jSONObject, "mac");
            if (k(e3 + e5 + e6).equals(e(jSONObject, "key"))) {
                d dVar = new d((byte) 0);
                dVar.f = jSONObject;
                dVar.a = e3;
                dVar.b = e5;
                dVar.c = e6;
                dVar.d = e4;
                dVar.e = e(jSONObject, BaseStatisContent.ARID);
                dVar.g = i(jSONObject, "crtTime");
                return dVar;
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return c.a(UUID.randomUUID().toString() + System.currentTimeMillis() + System.nanoTime() + new Random().nextInt(LocalConstant.NEXTSUFFIX));
            } catch (Exception unused) {
                return UUID.randomUUID().toString().replace("-", "");
            }
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? b.m(context).a : (String) invokeL.objValue;
    }

    public static String d(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dVar)) == null) {
            if (dVar.f == null) {
                dVar.f = new JSONObject();
            }
            h(dVar.f, "hdid", dVar.a);
            h(dVar.f, "type", dVar.d);
            h(dVar.f, "imei", dVar.b);
            h(dVar.f, "mac", dVar.c);
            h(dVar.f, BaseStatisContent.ARID, dVar.e);
            JSONObject jSONObject = dVar.f;
            h(jSONObject, "key", k(dVar.a + dVar.b + dVar.c));
            g(dVar.f, "crtTime", dVar.g);
            return dVar.f.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String e(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, str)) == null) {
            if (jSONObject.has(str)) {
                try {
                    return jSONObject.getString(str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void f(Context context, d dVar) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, dVar) == null) {
            try {
                String j = j(context);
                String b2 = c.b(d(dVar), "!qazxsw@v2#edcvfr$v2");
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        File file = new File(j);
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdir();
                        }
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(b2.getBytes("UTF-8"));
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                } catch (Exception e4) {
                    fileOutputStream2 = fileOutputStream;
                    e = e4;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    fileOutputStream2 = fileOutputStream;
                    th = th2;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    public static boolean g(JSONObject jSONObject, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{jSONObject, str, Long.valueOf(j)})) == null) {
            try {
                jSONObject.put(str, j);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static boolean h(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, jSONObject, str, str2)) == null) {
            try {
                jSONObject.put(str, str2);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static long i(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            if (jSONObject.has(str)) {
                try {
                    return jSONObject.getLong(str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                stringBuffer.append(context.getFilesDir().getAbsolutePath());
                stringBuffer.append(File.separator);
                stringBuffer.append("hdid_v2");
                String stringBuffer2 = stringBuffer.toString();
                stringBuffer.setLength(0);
                return stringBuffer2;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            try {
                return c.a(str + "!qazxsw@v2#edcvfr$v2");
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void l(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, context, dVar) == null) && a.c(context, "android.permission.WRITE_SETTINGS")) {
            try {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                Settings.System.putString(context.getContentResolver(), DeviceManagerV2.SETTING_KEY, c.b(d(dVar), DeviceManagerV2.KEY_MAGIC2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static d n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            d dVar = new d((byte) 0);
            String str = "";
            dVar.b = "";
            String a2 = a.a();
            dVar.e = a.b(context);
            dVar.g = System.currentTimeMillis();
            try {
                int i = !TextUtils.isEmpty(dVar.e) ? 1 : 0;
                boolean d2 = a.d(a2);
                if (i == 0 && !d2) {
                    dVar.d = "0";
                    dVar.a = b();
                    return dVar;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(i | (d2 ? 2 : 0));
                dVar.d = sb.toString();
                String str2 = dVar.e == null ? "" : dVar.e;
                if (a2 != null) {
                    str = a2;
                }
                dVar.a = c.a(str2 + "_" + str);
                return dVar;
            } catch (Exception unused) {
                dVar.d = "0";
                dVar.a = b();
                return dVar;
            }
        }
        return (d) invokeL.objValue;
    }

    public static d o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            try {
                String a2 = e.a(j(context));
                if (a2 != null) {
                    return a(c.e(a2, "!qazxsw@v2#edcvfr$v2"));
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (d) invokeL.objValue;
    }

    public static d p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            try {
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                String string = Settings.System.getString(context.getContentResolver(), DeviceManagerV2.SETTING_KEY);
                if (string != null) {
                    return a(c.e(string, DeviceManagerV2.KEY_MAGIC2));
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (d) invokeL.objValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
                boolean c2 = a.c(context, "android.permission.WRITE_SETTINGS");
                StringBuilder sb = new StringBuilder();
                sb.append(c2 ? 4 : 0);
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
        if (r9 == null) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c3 A[Catch: all -> 0x00f5, TryCatch #12 {, blocks: (B:9:0x000c, B:11:0x0010, B:12:0x0012, B:38:0x0076, B:43:0x0080, B:47:0x0088, B:50:0x008d, B:78:0x00bf, B:80:0x00c3, B:81:0x00c9, B:82:0x00d1, B:46:0x0085, B:41:0x007b, B:64:0x00a5, B:69:0x00af, B:74:0x00b9, B:72:0x00b4, B:67:0x00aa, B:87:0x00d8, B:92:0x00e2, B:97:0x00ec, B:101:0x00f4, B:100:0x00f1, B:95:0x00e7, B:90:0x00dd), top: B:126:0x000c, inners: #0, #3, #5, #10, #13, #15, #16 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d m(Context context) {
        InterceptResult invokeL;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            d dVar = this.a;
            if (dVar != null) {
                return dVar;
            }
            synchronized (c) {
                if (this.a != null) {
                    return this.a;
                }
                FileLock fileLock = null;
                try {
                    fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), "hdidlock.txt"));
                    try {
                        fileChannel = fileOutputStream.getChannel();
                        try {
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                while (System.currentTimeMillis() - currentTimeMillis < PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL) {
                                    try {
                                        fileLock = fileChannel.lock();
                                    } catch (Exception unused) {
                                        Thread.sleep(2L);
                                    }
                                    if (fileLock.isValid()) {
                                        d o = o(context);
                                        d p = p(context);
                                        if (o == null) {
                                            if (p == null) {
                                                o = n(context);
                                                f(context, o);
                                                l(context, o);
                                                this.a = o;
                                                break;
                                                break;
                                            }
                                            p.h = 6;
                                            f(context, p);
                                            o = p;
                                            this.a = o;
                                            break;
                                        }
                                        o.h = 4;
                                    } else {
                                        Thread.sleep(2L);
                                    }
                                }
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                    e = e4;
                                    e.printStackTrace();
                                    if (this.a == null) {
                                    }
                                    this.a.i = q(context);
                                    return this.a;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                e.printStackTrace();
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (Exception e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                    } catch (Exception e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e8) {
                                        e = e8;
                                        e.printStackTrace();
                                        if (this.a == null) {
                                        }
                                        this.a.i = q(context);
                                        return this.a;
                                    }
                                }
                                if (this.a == null) {
                                }
                                this.a.i = q(context);
                                return this.a;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (Exception e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        fileChannel = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel = null;
                        if (fileLock != null) {
                        }
                        if (fileChannel != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                } catch (Exception e13) {
                    e = e13;
                    fileChannel = null;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    fileOutputStream = null;
                }
                if (this.a == null) {
                    this.a = n(context);
                }
                this.a.i = q(context);
                return this.a;
            }
        }
        return (d) invokeL.objValue;
    }
}
