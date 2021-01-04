package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.webkit.internal.ETAG;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URLEncoder;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f14680a;

    /* renamed from: b  reason: collision with root package name */
    private String f14681b;
    private ReentrantLock phb;

    private a() {
        this.f14681b = "";
        this.phb = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(byte b2) {
        this();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: Throwable -> 0x008c, TryCatch #0 {Throwable -> 0x008c, blocks: (B:3:0x0002, B:5:0x0008, B:8:0x0013, B:10:0x0019, B:12:0x0021, B:14:0x002e, B:18:0x003e, B:20:0x004c, B:22:0x0055, B:24:0x0064, B:26:0x006e, B:28:0x0077, B:30:0x007f), top: B:36:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064 A[Catch: Throwable -> 0x008c, TryCatch #0 {Throwable -> 0x008c, blocks: (B:3:0x0002, B:5:0x0008, B:8:0x0013, B:10:0x0019, B:12:0x0021, B:14:0x002e, B:18:0x003e, B:20:0x004c, B:22:0x0055, B:24:0x0064, B:26:0x006e, B:28:0x0077, B:30:0x007f), top: B:36:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: Throwable -> 0x008c, TRY_LEAVE, TryCatch #0 {Throwable -> 0x008c, blocks: (B:3:0x0002, B:5:0x0008, B:8:0x0013, B:10:0x0019, B:12:0x0021, B:14:0x002e, B:18:0x003e, B:20:0x004c, B:22:0x0055, B:24:0x0064, B:26:0x006e, B:28:0x0077, B:30:0x007f), top: B:36:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context) {
        boolean z;
        String str;
        try {
            if (!d()) {
                String c = c();
                if (!TextUtils.isEmpty(c)) {
                    return c;
                }
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            String str2 = Build.MODEL;
            if (!TextUtils.isEmpty(str2) && str2.toLowerCase().contains("redmi") && str2.toLowerCase().contains("note 7")) {
                z = true;
                if (!z) {
                    String c2 = Orange.eKw().c();
                    if (!TextUtils.isEmpty(c2) && !c2.startsWith("KWE")) {
                        return c2;
                    }
                }
                if (com.yxcorp.kuaishou.addfp.android.b.e.a(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
                    String serial = Build.getSerial();
                    if (!TextUtils.isEmpty(serial) && !serial.equals("unknown")) {
                        return serial;
                    }
                }
                str = Build.SERIAL;
                if (!TextUtils.isEmpty(str)) {
                    if (!str.equals("unknown")) {
                        return str;
                    }
                }
                return "KWE_N";
            }
        }
        z = false;
        if (!z) {
        }
        if (com.yxcorp.kuaishou.addfp.android.b.e.a(context, new String[]{"android.permission.READ_PHONE_STATE"})) {
        }
        str = Build.SERIAL;
        if (!TextUtils.isEmpty(str)) {
        }
        return "KWE_N";
    }

    private static String b(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            return "KWE_PE";
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION, IF] complete} */
    private static String c() {
        BufferedReader bufferedReader;
        File file;
        String readLine;
        String str = null;
        try {
            file = new File("/sys/class/android_usb/android0/iSerial");
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (file.exists()) {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                readLine = bufferedReader.readLine();
            } catch (Throwable th2) {
                th = th2;
                try {
                    com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            com.yxcorp.kuaishou.addfp.android.b.b.a(th3);
                        }
                    }
                    return str;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th4) {
                            com.yxcorp.kuaishou.addfp.android.b.b.a(th4);
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(readLine)) {
                str = readLine.trim();
                try {
                    bufferedReader.close();
                } catch (Throwable th5) {
                    com.yxcorp.kuaishou.addfp.android.b.b.a(th5);
                }
                return str;
            }
        } else {
            bufferedReader = null;
        }
        return str;
    }

    private static boolean d() {
        try {
            return Build.VERSION.SDK_INT >= 26;
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return false;
        }
    }

    private static long e() {
        try {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return 0L;
        }
    }

    public static a eKx() {
        return b.qeM;
    }

    public final void a(String str) {
        this.f14680a = str;
    }

    public final String b() {
        try {
            if (!TextUtils.isEmpty(this.f14680a)) {
                return this.f14680a;
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return "KWE_N";
    }

    public final String c(Context context, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.phb.lock();
        } catch (Throwable th) {
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                this.f14681b = "KWE_PE";
                this.phb.unlock();
            } finally {
                this.phb.unlock();
            }
        }
        if (TextUtils.isEmpty(this.f14681b)) {
            JSONObject jSONObject = new JSONObject();
            String str = Build.MODEL;
            jSONObject.put("k27", com.yxcorp.kuaishou.addfp.android.b.e.b(TextUtils.isEmpty(str) ? "KWE_N" : str.replace("=", "").replace(ETAG.ITEM_SEPARATOR, "")));
            jSONObject.put("k64", com.yxcorp.kuaishou.addfp.android.b.e.b(a(context)));
            jSONObject.put("k31", com.yxcorp.kuaishou.addfp.android.b.e.b(z ? d.a(context, true) : d.a()));
            jSONObject.put("k66", com.yxcorp.kuaishou.addfp.android.b.e.b(b(context)));
            jSONObject.put("k39", com.yxcorp.kuaishou.addfp.android.b.e.b(Long.toString(e())));
            jSONObject.put("k101", com.yxcorp.kuaishou.addfp.android.b.e.b(com.yxcorp.kuaishou.addfp.android.b.e.a(new String(Base64.decode("Y2F0IC9zeXMvZGV2aWNlcy9zb2MwL3NlcmlhbF9udW1iZXI=", 0)))));
            jSONObject.put("k102", com.yxcorp.kuaishou.addfp.android.b.e.b(com.yxcorp.kuaishou.addfp.android.b.e.a(new String(Base64.decode("Y2F0IC9wcm9jL3N5cy9rZXJuZWwvcmFuZG9tL2Jvb3RfaWQ=", 0)))));
            jSONObject.put("k57", com.yxcorp.kuaishou.addfp.android.b.e.b(d.b(context)));
            jSONObject.put("k68", com.yxcorp.kuaishou.addfp.android.b.e.b(d.a(context)));
            jSONObject.put("k105", com.yxcorp.kuaishou.addfp.android.b.e.b(Orange.eKw().b()));
            jSONObject.put("k83", com.yxcorp.kuaishou.addfp.android.b.e.b(d.d(context)));
            jSONObject.put("k86", com.yxcorp.kuaishou.addfp.android.b.e.b(d.e(context)));
            jSONObject.put("k3", com.yxcorp.kuaishou.addfp.android.b.e.b(d.c(context)));
            if (z2) {
                com.yxcorp.kuaishou.addfp.a.a.b.eKr().c();
            }
            String str2 = com.yxcorp.kuaishou.addfp.a.f14632a;
            if (TextUtils.isEmpty(str2) || str2.startsWith("KWE")) {
                str2 = new e(context).c();
            }
            jSONObject.put("k97", com.yxcorp.kuaishou.addfp.android.b.e.b(str2));
            jSONObject.put("k36", com.yxcorp.kuaishou.addfp.android.b.e.b(com.yxcorp.kuaishou.addfp.android.b.b.a()));
            jSONObject.put("k14", com.yxcorp.kuaishou.addfp.android.b.e.b(com.yxcorp.kuaishou.addfp.android.b.b.b()));
            CRC32 crc32 = new CRC32();
            for (int i = 1; i <= 106; i++) {
                String str3 = "k" + i;
                if (jSONObject.has(str3)) {
                    crc32.update(jSONObject.optString(str3).getBytes());
                }
            }
            jSONObject.put("k14", com.yxcorp.kuaishou.addfp.android.b.e.b(com.yxcorp.kuaishou.addfp.android.b.b.b() + ":" + String.valueOf(crc32.getValue())));
            com.yxcorp.kuaishou.addfp.android.b.b.b("mimi :" + jSONObject.toString() + " " + jSONObject.toString().getBytes().length + " " + (System.currentTimeMillis() - currentTimeMillis));
            byte[] b2 = Orange.eKw().b(context, jSONObject.toString().getBytes(), 0);
            com.yxcorp.kuaishou.addfp.android.b.b.a("get mini lenth " + b2.length);
            this.f14681b = URLEncoder.encode(Base64.encodeToString(b2, 0), "utf-8");
            if (TextUtils.isEmpty(this.f14681b)) {
                this.f14681b = "KWE_N";
            }
            com.yxcorp.kuaishou.addfp.android.b.b.b("mini cost : " + (System.currentTimeMillis() - currentTimeMillis));
            return this.f14681b;
        }
        return this.f14681b;
    }
}
