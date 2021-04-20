package d.q.a.a.c.a;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f68362a;

    /* renamed from: b  reason: collision with root package name */
    public String f68363b;

    /* renamed from: c  reason: collision with root package name */
    public ReentrantLock f68364c;

    public a() {
        this.f68363b = "";
        this.f68364c = new ReentrantLock();
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return b.f68365a;
    }

    public static String b(Context context) {
        try {
            if (!h()) {
                String g2 = g();
                if (!TextUtils.isEmpty(g2)) {
                    return g2;
                }
            }
            boolean z = false;
            if (Build.VERSION.SDK_INT >= 29) {
                String str = Build.MODEL;
                if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("redmi") && str.toLowerCase().contains("note 7")) {
                    z = true;
                }
            }
            if (!z) {
                String e2 = Orange.a().e();
                if (!TextUtils.isEmpty(e2) && !e2.startsWith("KWE")) {
                    return e2;
                }
            }
            if (d.q.a.a.c.b.e.e(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                String serial = Build.getSerial();
                if (!TextUtils.isEmpty(serial) && !serial.equals("unknown")) {
                    return serial;
                }
            }
            String str2 = Build.SERIAL;
            return !TextUtils.isEmpty(str2) ? !str2.equals("unknown") ? str2 : "KWE_N" : "KWE_N";
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "KWE_N";
        }
    }

    public static String f(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        } catch (Throwable unused) {
            return "KWE_PE";
        }
    }

    public static String g() {
        BufferedReader bufferedReader;
        try {
            try {
                File file = new File("/sys/class/android_usb/android0/iSerial");
                if (file.exists()) {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    try {
                        String readLine = bufferedReader.readLine();
                        if (!TextUtils.isEmpty(readLine)) {
                            String trim = readLine.trim();
                            try {
                                bufferedReader.close();
                            } catch (Throwable th) {
                                d.q.a.a.c.b.b.c(th);
                            }
                            return trim;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            d.q.a.a.c.b.b.c(th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return null;
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th4) {
                                    d.q.a.a.c.b.b.c(th4);
                                }
                            }
                            throw th3;
                        }
                    }
                } else {
                    bufferedReader = null;
                }
            } catch (Throwable th5) {
                d.q.a.a.c.b.b.c(th5);
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return null;
    }

    public static boolean h() {
        try {
            return Build.VERSION.SDK_INT >= 26;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return false;
        }
    }

    public static long i() {
        try {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(Context context, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f68364c.lock();
        } finally {
            try {
                this.f68364c.unlock();
                if (TextUtils.isEmpty(this.f68363b)) {
                }
                d.q.a.a.c.b.b.e("mini cost : " + (System.currentTimeMillis() - currentTimeMillis));
                return this.f68363b;
            } finally {
            }
        }
        if (TextUtils.isEmpty(this.f68363b)) {
            JSONObject jSONObject = new JSONObject();
            String str = Build.MODEL;
            jSONObject.put("k27", d.q.a.a.c.b.e.f(TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace("&", "")));
            jSONObject.put("k64", d.q.a.a.c.b.e.f(b(context)));
            jSONObject.put("k31", d.q.a.a.c.b.e.f(z ? d.d(context, true) : d.a()));
            jSONObject.put("k66", d.q.a.a.c.b.e.f(f(context)));
            jSONObject.put("k39", d.q.a.a.c.b.e.f(Long.toString(i())));
            jSONObject.put("k101", d.q.a.a.c.b.e.f(d.q.a.a.c.b.e.c(new String(Base64.decode("Y2F0IC9zeXMvZGV2aWNlcy9zb2MwL3NlcmlhbF9udW1iZXI=", 0)))));
            jSONObject.put("k102", d.q.a.a.c.b.e.f(d.q.a.a.c.b.e.c(new String(Base64.decode("Y2F0IC9wcm9jL3N5cy9rZXJuZWwvcmFuZG9tL2Jvb3RfaWQ=", 0)))));
            jSONObject.put("k57", d.q.a.a.c.b.e.f(d.h(context)));
            jSONObject.put("k68", d.q.a.a.c.b.e.f(d.b(context)));
            jSONObject.put("k105", d.q.a.a.c.b.e.f(Orange.a().c()));
            jSONObject.put("k83", d.q.a.a.c.b.e.f(d.k(context)));
            jSONObject.put("k86", d.q.a.a.c.b.e.f(d.n(context)));
            jSONObject.put("k3", d.q.a.a.c.b.e.f(d.j(context)));
            if (z2) {
                d.q.a.a.a.a.b.c().i();
            }
            String str2 = d.q.a.a.b.f68355h;
            if (TextUtils.isEmpty(str2) || str2.startsWith("KWE")) {
                str2 = new e(context).e();
            }
            jSONObject.put("k97", d.q.a.a.c.b.e.f(str2));
            jSONObject.put("k36", d.q.a.a.c.b.e.f(d.q.a.a.c.b.b.a()));
            jSONObject.put("k14", d.q.a.a.c.b.e.f(d.q.a.a.c.b.b.d()));
            CRC32 crc32 = new CRC32();
            for (int i = 1; i <= 106; i++) {
                String str3 = Config.APP_KEY + i;
                if (jSONObject.has(str3)) {
                    crc32.update(jSONObject.optString(str3).getBytes());
                }
            }
            jSONObject.put("k14", d.q.a.a.c.b.e.f(d.q.a.a.c.b.b.d() + ":" + String.valueOf(crc32.getValue())));
            d.q.a.a.c.b.b.e("mimi :" + jSONObject.toString() + " " + jSONObject.toString().getBytes().length + " " + (System.currentTimeMillis() - currentTimeMillis));
            byte[] d2 = Orange.a().d(context, jSONObject.toString().getBytes(), 0);
            StringBuilder sb = new StringBuilder("get mini lenth ");
            sb.append(d2.length);
            d.q.a.a.c.b.b.b(sb.toString());
            this.f68363b = URLEncoder.encode(Base64.encodeToString(d2, 0), "utf-8");
            this.f68364c.unlock();
            if (TextUtils.isEmpty(this.f68363b)) {
                this.f68363b = "KWE_N";
            }
            d.q.a.a.c.b.b.e("mini cost : " + (System.currentTimeMillis() - currentTimeMillis));
            return this.f68363b;
        }
        return this.f68363b;
    }

    public final void d(String str) {
        this.f68362a = str;
    }

    public final String e() {
        try {
            return !TextUtils.isEmpty(this.f68362a) ? this.f68362a : "KWE_N";
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "KWE_N";
        }
    }
}
