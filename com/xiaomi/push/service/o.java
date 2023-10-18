package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.push.gb;
import com.xiaomi.push.hf;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class o {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile o a;

    /* renamed from: a  reason: collision with other field name */
    public long f983a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f984a;

    /* renamed from: a  reason: collision with other field name */
    public final SharedPreferences f985a;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f990b;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f991c;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicInteger f987a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public String f986a = null;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f988a = false;
    public String b = null;

    /* renamed from: b  reason: collision with other field name */
    public final AtomicInteger f989b = new AtomicInteger(0);
    public final AtomicInteger c = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public int f982a = -1;

    /* loaded from: classes10.dex */
    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b() {
            return "record_support_wifi_digest_reported";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    public o(Context context) {
        this.f984a = context;
        this.f991c = com.xiaomi.push.j.m713a(context);
        this.f990b = ba.a(this.f984a).a(hm.IntelligentHeartbeatSwitchBoolean.a(), true);
        this.f985a = this.f984a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f985a.getLong(a.c(), -1L) == -1) {
            this.f985a.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j = this.f985a.getLong(a.i(), -1L);
        this.f983a = j;
        if (j == -1) {
            this.f983a = currentTimeMillis;
            this.f985a.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        if (TextUtils.isEmpty(this.f986a)) {
            return -1;
        }
        try {
            return this.f985a.getInt(a.a(this.f986a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static o a(Context context) {
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    a = new o(context);
                }
            }
        }
        return a;
    }

    private void a(String str, String str2, Map<String, String> map) {
        hl hlVar = new hl();
        hlVar.d(str);
        hlVar.c("hb_name");
        hlVar.a("hb_channel");
        hlVar.a(1L);
        hlVar.b(str2);
        hlVar.a(false);
        hlVar.b(System.currentTimeMillis());
        hlVar.g(this.f984a.getPackageName());
        hlVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        t m838a = u.m838a(this.f984a);
        if (m838a != null && !TextUtils.isEmpty(m838a.f1005a)) {
            String[] split = m838a.f1005a.split("@");
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put("uuid", str3);
        map.put("model", Build.MODEL);
        Context context = this.f984a;
        map.put("avc", String.valueOf(com.xiaomi.push.g.a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(50005));
        map.put("cvc", String.valueOf(48));
        hlVar.a(map);
        hf a2 = hf.a(this.f984a);
        if (a2 != null) {
            a2.a(hlVar, this.f984a.getPackageName());
        }
    }

    private void a(boolean z) {
        if (m818c()) {
            int incrementAndGet = (z ? this.f989b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d = z ? a.d() : a.e();
                int i = this.f985a.getInt(d, 0) + incrementAndGet;
                this.f985a.edit().putInt(d, i).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i);
                com.xiaomi.channel.commonutils.logger.b.m182a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f989b : this.c).set(0);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m816a() {
        return this.f987a.get() >= Math.max(ba.a(this.f984a).a(hm.IntelligentHeartbeatNATCountInt.a(), 5), 3);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private long b() {
        return this.f985a.getLong(a.j(), -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(String str) {
        int i;
        SharedPreferences.Editor remove;
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f986a;
            if (str2 == null || !str2.startsWith("W-")) {
                str = null;
            }
            i = this.f985a.getInt(a.a(this.f986a), -1);
            long j = this.f985a.getLong(a.b(this.f986a), -1L);
            long currentTimeMillis = System.currentTimeMillis();
            if (i != -1) {
                if (j == -1) {
                    remove = this.f985a.edit().putLong(a.b(this.f986a), currentTimeMillis + c());
                } else if (currentTimeMillis > j) {
                    remove = this.f985a.edit().remove(a.a(this.f986a)).remove(a.b(this.f986a));
                }
                remove.apply();
            }
            this.f987a.getAndSet(0);
            if (TextUtils.isEmpty(this.f986a) && a() == -1) {
                this.f988a = true;
            } else {
                this.f988a = false;
            }
            com.xiaomi.channel.commonutils.logger.b.m182a(String.format("[HB] network changed, netid:%s, %s", this.f986a, Boolean.valueOf(this.f988a)));
        }
        this.f986a = str;
        i = this.f985a.getInt(a.a(this.f986a), -1);
        long j2 = this.f985a.getLong(a.b(this.f986a), -1L);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (i != -1) {
        }
        this.f987a.getAndSet(0);
        if (TextUtils.isEmpty(this.f986a)) {
        }
        this.f988a = false;
        com.xiaomi.channel.commonutils.logger.b.m182a(String.format("[HB] network changed, netid:%s, %s", this.f986a, Boolean.valueOf(this.f988a)));
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m817b() {
        return (TextUtils.isEmpty(this.f986a) || !this.f986a.startsWith("M-") || ba.a(this.f984a).a(hm.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) ? false : true;
    }

    private long c() {
        return ba.a(this.f984a).a(hm.ShortHeartbeatEffectivePeriodMsLong.a(), 777600000L);
    }

    private void c(String str) {
        if (a(str)) {
            this.f985a.edit().putInt(a.a(str), 235000).apply();
            this.f985a.edit().putLong(a.b(this.f986a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m818c() {
        return d() && ba.a(this.f984a).a(hm.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && com.xiaomi.push.n.China.name().equals(com.xiaomi.push.service.a.a(this.f984a).a());
    }

    private void d(String str) {
        String str2;
        String str3;
        if (m818c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = ExifInterface.LONGITUDE_WEST;
            } else if (!str.startsWith("M-")) {
                return;
            } else {
                str2 = "M";
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(valueOf);
            sb.append(":::");
            sb.append(valueOf2);
            String string = this.f985a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f985a.edit().putString(a.f(), str3).apply();
        }
    }

    private boolean d() {
        return this.f991c && (this.f990b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    private void e() {
        if (this.f985a.getBoolean(a.a(), false)) {
            return;
        }
        this.f985a.edit().putBoolean(a.a(), true).apply();
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m819e() {
        long j = this.f985a.getLong(a.c(), -1L);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void f() {
        int i = this.f982a;
        String h = i != 0 ? i != 1 ? null : a.h() : a.g();
        if (TextUtils.isEmpty(h)) {
            return;
        }
        if (this.f985a.getLong(a.i(), -1L) == -1) {
            this.f983a = System.currentTimeMillis();
            this.f985a.edit().putLong(a.i(), this.f983a).apply();
        }
        this.f985a.edit().putInt(h, this.f985a.getInt(h, 0) + 1).apply();
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m820f() {
        if (this.f983a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f983a;
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void g() {
        int i;
        String[] split;
        String[] split2;
        if (m818c()) {
            String string = this.f985a.getString(a.f(), null);
            char c = 1;
            char c2 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i2 = 0;
                while (i2 < split.length) {
                    if (!TextUtils.isEmpty(split[i2]) && (split2 = split[i2].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c2];
                        String str2 = split2[c];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "change");
                        hashMap.put("model", Build.MODEL);
                        hashMap.put("net_type", str2);
                        hashMap.put("net_name", str);
                        hashMap.put("interval", str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", null, hashMap);
                        com.xiaomi.channel.commonutils.logger.b.m182a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f985a.edit().remove(a.f()).apply();
            }
            if (this.f985a.getBoolean(a.a(), false) && !this.f985a.getBoolean(a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put("model", Build.MODEL);
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                com.xiaomi.channel.commonutils.logger.b.m182a("[HB] report support wifi digest events.");
                this.f985a.edit().putBoolean(a.b(), true).apply();
            }
            if (m819e()) {
                int i3 = this.f985a.getInt(a.d(), 0);
                int i4 = this.f985a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j = this.f985a.getLong(a.c(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("interval", valueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put("start_time", valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        com.xiaomi.channel.commonutils.logger.b.m182a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f985a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m820f()) {
                String valueOf4 = String.valueOf(this.f983a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f985a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put("start_time", valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        com.xiaomi.channel.commonutils.logger.b.m182a("[HB] report ping timeout count events of mobile network.");
                        this.f985a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f985a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f985a.getInt(a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", ExifInterface.LONGITUDE_WEST);
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put("start_time", valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        com.xiaomi.channel.commonutils.logger.b.m182a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f985a.edit().putInt(a.h(), 0).apply();
                }
                this.f983a = System.currentTimeMillis();
                this.f985a.edit().putLong(a.i(), this.f983a).apply();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m821a() {
        int a2;
        long b = gb.b();
        if (this.f991c && !m817b() && ((ba.a(this.f984a).a(hm.IntelligentHeartbeatSwitchBoolean.a(), true) || b() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
            b = a2;
        }
        if (!TextUtils.isEmpty(this.f986a) && !"WIFI-ID-UNKNOWN".equals(this.f986a) && this.f982a == 1) {
            a(b < 300000);
        }
        com.xiaomi.channel.commonutils.logger.b.m182a("[HB] ping interval:" + b);
        return b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m822a() {
    }

    public void a(int i) {
        this.f985a.edit().putLong(a.j(), System.currentTimeMillis() + (i * 1000)).apply();
    }

    public synchronized void a(NetworkInfo networkInfo) {
        if (d()) {
            String str = null;
            if (networkInfo == null) {
                b(null);
            } else if (networkInfo.getType() == 0) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName) && !"UNKNOWN".equalsIgnoreCase(subtypeName)) {
                    str = "M-" + subtypeName;
                }
                b(str);
                this.f982a = 0;
            } else {
                if (networkInfo.getType() != 1 && networkInfo.getType() != 6) {
                    b(null);
                }
                b("WIFI-ID-UNKNOWN");
                this.f982a = 1;
            }
            this.f982a = -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m823a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m824b() {
        if (d()) {
            f();
            if (this.f988a && !TextUtils.isEmpty(this.f986a) && this.f986a.equals(this.b)) {
                this.f987a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m182a("[HB] ping timeout count:" + this.f987a);
                if (m816a()) {
                    com.xiaomi.channel.commonutils.logger.b.m182a("[HB] change hb interval for net:" + this.f986a);
                    c(this.f986a);
                    this.f988a = false;
                    this.f987a.getAndSet(0);
                    d(this.f986a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m825c() {
        if (d()) {
            this.b = this.f986a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m826d() {
        if (d()) {
            g();
            if (this.f988a) {
                this.f987a.getAndSet(0);
            }
        }
    }
}
