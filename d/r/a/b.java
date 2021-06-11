package d.r.a;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ABTestConstants;
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
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final b f71431b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final Object f71432c = FilenameFilter.class;

    /* renamed from: a  reason: collision with root package name */
    public d f71433a = null;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static String f71434a;

        @SuppressLint({"NewApi"})
        public static String a() {
            byte[] hardwareAddress;
            String str = null;
            try {
                if (Build.VERSION.SDK_INT >= 9) {
                    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface nextElement = networkInterfaces.nextElement();
                        if (nextElement.getName().equalsIgnoreCase(NetworkInfoUtils.NETWORK_NAME) && (hardwareAddress = nextElement.getHardwareAddress()) != null && hardwareAddress.length != 0) {
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            str = sb.toString();
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str;
        }

        public static String b(Context context) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (f71434a != null) {
                return f71434a;
            }
            f71434a = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            return f71434a;
        }

        public static boolean c(Context context, String str) {
            boolean z = false;
            try {
                if (Build.VERSION.SDK_INT < 23 ? context.getPackageManager().checkPermission(str, context.getPackageName()) == 0 : context.checkSelfPermission(str) == 0) {
                    z = true;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return z;
        }

        public static boolean d(String str) {
            return (TextUtils.isEmpty(str) || str.equalsIgnoreCase(Config.DEF_MAC_ID)) ? false : true;
        }
    }

    /* renamed from: d.r.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1958b {

        /* renamed from: a  reason: collision with root package name */
        public static final char[] f71435a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

        public static int a(char c2) {
            int i2;
            if (c2 < 'A' || c2 > 'Z') {
                if (c2 >= 'a' && c2 <= 'z') {
                    i2 = c2 - 'a';
                } else if (c2 < '0' || c2 > '9') {
                    if (c2 != '+') {
                        if (c2 != '/') {
                            if (c2 == '=') {
                                return 0;
                            }
                            throw new RuntimeException("unexpected code: ".concat(String.valueOf(c2)));
                        }
                        return 63;
                    }
                    return 62;
                } else {
                    i2 = (c2 - '0') + 26;
                }
                return i2 + 26;
            }
            return c2 - 'A';
        }

        public static String b(byte[] bArr) {
            String str;
            int length = bArr.length;
            StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
            int i2 = length - 3;
            int i3 = 0;
            while (i3 <= i2) {
                int i4 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                stringBuffer.append(f71435a[(i4 >> 18) & 63]);
                stringBuffer.append(f71435a[(i4 >> 12) & 63]);
                stringBuffer.append(f71435a[(i4 >> 6) & 63]);
                stringBuffer.append(f71435a[i4 & 63]);
                i3 += 3;
            }
            int i5 = length + 0;
            if (i3 != i5 - 2) {
                if (i3 == i5 - 1) {
                    int i6 = (bArr[i3] & 255) << 16;
                    stringBuffer.append(f71435a[(i6 >> 18) & 63]);
                    stringBuffer.append(f71435a[(i6 >> 12) & 63]);
                    str = "==";
                }
                return stringBuffer.toString();
            }
            int i7 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            stringBuffer.append(f71435a[(i7 >> 18) & 63]);
            stringBuffer.append(f71435a[(i7 >> 12) & 63]);
            stringBuffer.append(f71435a[(i7 >> 6) & 63]);
            str = "=";
            stringBuffer.append(str);
            return stringBuffer.toString();
        }

        public static void c(String str, OutputStream outputStream) {
            int length = str.length();
            int i2 = 0;
            while (true) {
                if (i2 < length && str.charAt(i2) <= ' ') {
                    i2++;
                } else if (i2 == length) {
                    return;
                } else {
                    int i3 = i2 + 2;
                    int i4 = i2 + 3;
                    int a2 = (a(str.charAt(i2)) << 18) + (a(str.charAt(i2 + 1)) << 12) + (a(str.charAt(i3)) << 6) + a(str.charAt(i4));
                    outputStream.write((a2 >> 16) & 255);
                    if (str.charAt(i3) == '=') {
                        return;
                    }
                    outputStream.write((a2 >> 8) & 255);
                    if (str.charAt(i4) == '=') {
                        return;
                    }
                    outputStream.write(a2 & 255);
                    i2 += 4;
                }
            }
        }

        public static byte[] d(String str) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c(str, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    PrintStream printStream = System.err;
                    printStream.println("Error while decoding BASE64: " + e2.toString());
                }
                return byteArray;
            } catch (IOException unused) {
                throw new RuntimeException();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static String a(String str) {
            return c(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
        }

        public static String b(String str, String str2) {
            return C1958b.b(d(str.getBytes("UTF-8"), str2.getBytes("UTF-8")));
        }

        public static String c(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            if (bArr != null) {
                for (byte b2 : bArr) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
            }
            return sb.toString();
        }

        public static byte[] d(byte[] bArr, byte[] bArr2) {
            SecureRandom secureRandom = new SecureRandom();
            SecretKey generateSecret = SecretKeyFactory.getInstance(Coder.KEY_DES).generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance(Coder.KEY_DES);
            cipher.init(1, generateSecret, secureRandom);
            return cipher.doFinal(bArr);
        }

        public static String e(String str, String str2) {
            if (str == null) {
                return null;
            }
            return f(g(C1958b.d(str), str2.getBytes("UTF-8")));
        }

        public static String f(byte[] bArr) {
            return new String(bArr, "UTF-8");
        }

        public static byte[] g(byte[] bArr, byte[] bArr2) {
            SecureRandom secureRandom = new SecureRandom();
            SecretKey generateSecret = SecretKeyFactory.getInstance(Coder.KEY_DES).generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance(Coder.KEY_DES);
            cipher.init(2, generateSecret, secureRandom);
            return cipher.doFinal(bArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public String f71436a;

        /* renamed from: b  reason: collision with root package name */
        public String f71437b;

        /* renamed from: c  reason: collision with root package name */
        public String f71438c;

        /* renamed from: d  reason: collision with root package name */
        public String f71439d;

        /* renamed from: e  reason: collision with root package name */
        public String f71440e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f71441f;

        /* renamed from: g  reason: collision with root package name */
        public long f71442g;

        /* renamed from: h  reason: collision with root package name */
        public int f71443h;

        /* renamed from: i  reason: collision with root package name */
        public String f71444i;

        public d() {
            this.f71439d = "0";
            this.f71442g = 0L;
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0042 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0069 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r6v6, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r6v9, types: [java.io.FileInputStream] */
        public static final String a(String str) {
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream2;
            try {
                try {
                    File file = new File((String) str);
                    if (!file.exists()) {
                        return null;
                    }
                    str = new FileInputStream(file);
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = str.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, read);
                            }
                            String trim = new String(byteArrayOutputStream2.toByteArray(), "UTF-8").trim();
                            try {
                                str.close();
                                byteArrayOutputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return trim;
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            if (str != 0) {
                                try {
                                    str.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return null;
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                byteArrayOutputStream2.close();
                            }
                            return null;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        th = th2;
                        if (str != 0) {
                            try {
                                str.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e7) {
                e = e7;
                str = 0;
                byteArrayOutputStream2 = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                str = 0;
            }
        }
    }

    public static d a(String str) {
        JSONObject jSONObject;
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
            dVar.f71441f = jSONObject;
            dVar.f71436a = e3;
            dVar.f71437b = e5;
            dVar.f71438c = e6;
            dVar.f71439d = e4;
            dVar.f71440e = e(jSONObject, BaseStatisContent.ARID);
            dVar.f71442g = i(jSONObject, "crtTime");
            return dVar;
        }
        return null;
    }

    public static String b() {
        try {
            return c.a(UUID.randomUUID().toString() + System.currentTimeMillis() + System.nanoTime() + new Random().nextInt(ABTestConstants.MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT));
        } catch (Exception unused) {
            return UUID.randomUUID().toString().replace("-", "");
        }
    }

    public static String c(Context context) {
        return f71431b.m(context).f71436a;
    }

    public static String d(d dVar) {
        if (dVar.f71441f == null) {
            dVar.f71441f = new JSONObject();
        }
        h(dVar.f71441f, "hdid", dVar.f71436a);
        h(dVar.f71441f, "type", dVar.f71439d);
        h(dVar.f71441f, "imei", dVar.f71437b);
        h(dVar.f71441f, "mac", dVar.f71438c);
        h(dVar.f71441f, BaseStatisContent.ARID, dVar.f71440e);
        JSONObject jSONObject = dVar.f71441f;
        h(jSONObject, "key", k(dVar.f71436a + dVar.f71437b + dVar.f71438c));
        g(dVar.f71441f, "crtTime", dVar.f71442g);
        return dVar.f71441f.toString();
    }

    public static String e(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void f(Context context, d dVar) {
        FileOutputStream fileOutputStream;
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

    public static boolean g(JSONObject jSONObject, String str, long j) {
        try {
            jSONObject.put(str, j);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static boolean h(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static long i(JSONObject jSONObject, String str) {
        if (jSONObject.has(str)) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    public static String j(Context context) {
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

    public static String k(String str) {
        try {
            return c.a(str + "!qazxsw@v2#edcvfr$v2");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void l(Context context, d dVar) {
        if (a.c(context, "android.permission.WRITE_SETTINGS")) {
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
        d dVar = new d((byte) 0);
        String str = "";
        dVar.f71437b = "";
        String a2 = a.a();
        dVar.f71440e = a.b(context);
        dVar.f71442g = System.currentTimeMillis();
        try {
            int i2 = !TextUtils.isEmpty(dVar.f71440e) ? 1 : 0;
            boolean d2 = a.d(a2);
            if (i2 == 0 && !d2) {
                dVar.f71439d = "0";
                dVar.f71436a = b();
                return dVar;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i2 | (d2 ? 2 : 0));
            dVar.f71439d = sb.toString();
            String str2 = dVar.f71440e == null ? "" : dVar.f71440e;
            if (a2 != null) {
                str = a2;
            }
            dVar.f71436a = c.a(str2 + "_" + str);
            return dVar;
        } catch (Exception unused) {
            dVar.f71439d = "0";
            dVar.f71436a = b();
            return dVar;
        }
    }

    public static d o(Context context) {
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

    public static d p(Context context) {
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

    public static String q(Context context) {
        try {
            boolean c2 = a.c(context, "android.permission.WRITE_SETTINGS");
            StringBuilder sb = new StringBuilder();
            sb.append(c2 ? 4 : 0);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        if (r9 == null) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00bf A[Catch: all -> 0x00f1, TryCatch #10 {, blocks: (B:7:0x0008, B:9:0x000c, B:10:0x000e, B:36:0x0072, B:41:0x007c, B:45:0x0084, B:48:0x0089, B:76:0x00bb, B:78:0x00bf, B:79:0x00c5, B:80:0x00cd, B:44:0x0081, B:39:0x0077, B:62:0x00a1, B:67:0x00ab, B:72:0x00b5, B:70:0x00b0, B:65:0x00a6, B:85:0x00d4, B:90:0x00de, B:95:0x00e8, B:99:0x00f0, B:98:0x00ed, B:93:0x00e3, B:88:0x00d9), top: B:118:0x0008, inners: #0, #2, #4, #5, #8, #15, #16 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d m(Context context) {
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        d dVar = this.f71433a;
        if (dVar != null) {
            return dVar;
        }
        synchronized (f71432c) {
            if (this.f71433a != null) {
                return this.f71433a;
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
                                            this.f71433a = o;
                                            break;
                                            break;
                                        }
                                        p.f71443h = 6;
                                        f(context, p);
                                        o = p;
                                        this.f71433a = o;
                                        break;
                                    }
                                    o.f71443h = 4;
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
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e7) {
                                    e = e7;
                                    e.printStackTrace();
                                    if (this.f71433a == null) {
                                    }
                                    this.f71433a.f71444i = q(context);
                                    return this.f71433a;
                                }
                            }
                            if (this.f71433a == null) {
                            }
                            this.f71433a.f71444i = q(context);
                            return this.f71433a;
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e8) {
                            e = e8;
                            e.printStackTrace();
                            if (this.f71433a == null) {
                            }
                            this.f71433a.f71444i = q(context);
                            return this.f71433a;
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
            if (this.f71433a == null) {
                this.f71433a = n(context);
            }
            this.f71433a.f71444i = q(context);
            return this.f71433a;
        }
    }
}
