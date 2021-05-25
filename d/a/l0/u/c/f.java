package d.a.l0.u.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
/* loaded from: classes3.dex */
public class f implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public Context f48506a;

    public f(Context context) {
        this.f48506a = context.getApplicationContext();
    }

    public static byte[] g(byte[]... bArr) {
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            i2 += bArr2.length;
        }
        byte[] bArr3 = new byte[i2];
        int i3 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i3, bArr4.length);
            i3 += bArr4.length;
        }
        return bArr3;
    }

    @Override // d.a.l0.u.c.b
    public boolean a() {
        return false;
    }

    public final String b() {
        byte[] g2;
        byte[] bytes = d().getBytes(StandardCharsets.UTF_8);
        byte[] bytes2 = "com.baidu.swan".getBytes(StandardCharsets.UTF_8);
        if (Build.VERSION.SDK_INT < 23) {
            g2 = g(bytes2, UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8), String.valueOf(System.nanoTime()).getBytes(StandardCharsets.UTF_8), bytes);
        } else {
            g2 = g(bytes2, bytes);
        }
        return d.a.l0.u.d.b.b(g2, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.u.c.b
    /* renamed from: c */
    public String get() {
        return b();
    }

    @SuppressLint({"HardwareIds"})
    public final String d() {
        String string = Settings.Secure.getString(this.f48506a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (TextUtils.isEmpty(string)) {
            string = e();
        }
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
        }
        return string == null ? "" : string;
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public final String e() {
        String str;
        try {
            str = (String) Build.class.getField("SERIAL").get(null);
            try {
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                    Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
                    declaredMethod.setAccessible(true);
                    str = (String) declaredMethod.invoke(null, "ro.serialno");
                }
                if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
                    str = f("ro.serialno");
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
            return null;
        }
        return str;
    }

    public final String f(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 256);
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            d.a.l0.u.d.a.a(bufferedReader);
            return readLine == null ? "" : readLine;
        } catch (IOException unused2) {
            bufferedReader2 = bufferedReader;
            d.a.l0.u.d.a.a(bufferedReader2);
            d.a.l0.u.d.a.a(bufferedReader2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            d.a.l0.u.d.a.a(bufferedReader2);
            throw th;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.u.c.b
    /* renamed from: h */
    public void put(String str) {
    }
}
