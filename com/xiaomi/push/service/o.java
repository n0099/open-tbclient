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
    public long f979a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f980a;

    /* renamed from: a  reason: collision with other field name */
    public final SharedPreferences f981a;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f986b;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f987c;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicInteger f983a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public String f982a = null;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f984a = false;
    public String b = null;

    /* renamed from: b  reason: collision with other field name */
    public final AtomicInteger f985b = new AtomicInteger(0);
    public final AtomicInteger c = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public int f978a = -1;

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
        this.f980a = context;
        this.f987c = com.xiaomi.push.j.m721a(context);
        this.f986b = ba.a(this.f980a).a(hm.IntelligentHeartbeatSwitchBoolean.a(), true);
        this.f981a = this.f980a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f981a.getLong(a.c(), -1L) == -1) {
            this.f981a.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j = this.f981a.getLong(a.i(), -1L);
        this.f979a = j;
        if (j == -1) {
            this.f979a = currentTimeMillis;
            this.f981a.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        if (TextUtils.isEmpty(this.f982a)) {
            return -1;
        }
        try {
            return this.f981a.getInt(a.a(this.f982a), -1);
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
        hlVar.g(this.f980a.getPackageName());
        hlVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        t m846a = u.m846a(this.f980a);
        if (m846a != null && !TextUtils.isEmpty(m846a.f1001a)) {
            String[] split = m846a.f1001a.split("@");
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put("uuid", str3);
        map.put("model", Build.MODEL);
        Context context = this.f980a;
        map.put("avc", String.valueOf(com.xiaomi.push.g.a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(50005));
        map.put("cvc", String.valueOf(48));
        hlVar.a(map);
        hf a2 = hf.a(this.f980a);
        if (a2 != null) {
            a2.a(hlVar, this.f980a.getPackageName());
        }
    }

    private void a(boolean z) {
        if (m826c()) {
            int incrementAndGet = (z ? this.f985b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d = z ? a.d() : a.e();
                int i = this.f981a.getInt(d, 0) + incrementAndGet;
                this.f981a.edit().putInt(d, i).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i);
                com.xiaomi.channel.commonutils.logger.b.m190a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f985b : this.c).set(0);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m824a() {
        return this.f983a.get() >= Math.max(ba.a(this.f980a).a(hm.IntelligentHeartbeatNATCountInt.a(), 5), 3);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private long b() {
        return this.f981a.getLong(a.j(), -1L);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(String str) {
        int i;
        SharedPreferences.Editor remove;
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f982a;
            if (str2 == null || !str2.startsWith("W-")) {
                str = null;
            }
            i = this.f981a.getInt(a.a(this.f982a), -1);
            long j = this.f981a.getLong(a.b(this.f982a), -1L);
            long currentTimeMillis = System.currentTimeMillis();
            if (i != -1) {
                if (j == -1) {
                    remove = this.f981a.edit().putLong(a.b(this.f982a), currentTimeMillis + c());
                } else if (currentTimeMillis > j) {
                    remove = this.f981a.edit().remove(a.a(this.f982a)).remove(a.b(this.f982a));
                }
                remove.apply();
            }
            this.f983a.getAndSet(0);
            if (TextUtils.isEmpty(this.f982a) && a() == -1) {
                this.f984a = true;
            } else {
                this.f984a = false;
            }
            com.xiaomi.channel.commonutils.logger.b.m190a(String.format("[HB] network changed, netid:%s, %s", this.f982a, Boolean.valueOf(this.f984a)));
        }
        this.f982a = str;
        i = this.f981a.getInt(a.a(this.f982a), -1);
        long j2 = this.f981a.getLong(a.b(this.f982a), -1L);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (i != -1) {
        }
        this.f983a.getAndSet(0);
        if (TextUtils.isEmpty(this.f982a)) {
        }
        this.f984a = false;
        com.xiaomi.channel.commonutils.logger.b.m190a(String.format("[HB] network changed, netid:%s, %s", this.f982a, Boolean.valueOf(this.f984a)));
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m825b() {
        return (TextUtils.isEmpty(this.f982a) || !this.f982a.startsWith("M-") || ba.a(this.f980a).a(hm.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) ? false : true;
    }

    private long c() {
        return ba.a(this.f980a).a(hm.ShortHeartbeatEffectivePeriodMsLong.a(), 777600000L);
    }

    private void c(String str) {
        if (a(str)) {
            this.f981a.edit().putInt(a.a(str), 235000).apply();
            this.f981a.edit().putLong(a.b(this.f982a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m826c() {
        return d() && ba.a(this.f980a).a(hm.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && com.xiaomi.push.n.China.name().equals(com.xiaomi.push.service.a.a(this.f980a).a());
    }

    private void d(String str) {
        String str2;
        String str3;
        if (m826c() && !TextUtils.isEmpty(str)) {
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
            String string = this.f981a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f981a.edit().putString(a.f(), str3).apply();
        }
    }

    private boolean d() {
        return this.f987c && (this.f986b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    private void e() {
        if (this.f981a.getBoolean(a.a(), false)) {
            return;
        }
        this.f981a.edit().putBoolean(a.a(), true).apply();
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m827e() {
        long j = this.f981a.getLong(a.c(), -1L);
        if (j == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void f() {
        int i = this.f978a;
        String h = i != 0 ? i != 1 ? null : a.h() : a.g();
        if (TextUtils.isEmpty(h)) {
            return;
        }
        if (this.f981a.getLong(a.i(), -1L) == -1) {
            this.f979a = System.currentTimeMillis();
            this.f981a.edit().putLong(a.i(), this.f979a).apply();
        }
        this.f981a.edit().putInt(h, this.f981a.getInt(h, 0) + 1).apply();
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m828f() {
        if (this.f979a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f979a;
        return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
    }

    private void g() {
        int i;
        String[] split;
        String[] split2;
        if (m826c()) {
            String string = this.f981a.getString(a.f(), null);
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
                        com.xiaomi.channel.commonutils.logger.b.m190a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f981a.edit().remove(a.f()).apply();
            }
            if (this.f981a.getBoolean(a.a(), false) && !this.f981a.getBoolean(a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put("model", Build.MODEL);
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                com.xiaomi.channel.commonutils.logger.b.m190a("[HB] report support wifi digest events.");
                this.f981a.edit().putBoolean(a.b(), true).apply();
            }
            if (m827e()) {
                int i3 = this.f981a.getInt(a.d(), 0);
                int i4 = this.f981a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j = this.f981a.getLong(a.c(), -1L);
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
                        com.xiaomi.channel.commonutils.logger.b.m190a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f981a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m828f()) {
                String valueOf4 = String.valueOf(this.f979a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f981a.getInt(a.g(), 0);
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
                        com.xiaomi.channel.commonutils.logger.b.m190a("[HB] report ping timeout count events of mobile network.");
                        this.f981a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f981a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f981a.getInt(a.h(), i);
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
                        com.xiaomi.channel.commonutils.logger.b.m190a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f981a.edit().putInt(a.h(), 0).apply();
                }
                this.f979a = System.currentTimeMillis();
                this.f981a.edit().putLong(a.i(), this.f979a).apply();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m829a() {
        int a2;
        long b = gb.b();
        if (this.f987c && !m825b() && ((ba.a(this.f980a).a(hm.IntelligentHeartbeatSwitchBoolean.a(), true) || b() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
            b = a2;
        }
        if (!TextUtils.isEmpty(this.f982a) && !"WIFI-ID-UNKNOWN".equals(this.f982a) && this.f978a == 1) {
            a(b < 300000);
        }
        com.xiaomi.channel.commonutils.logger.b.m190a("[HB] ping interval:" + b);
        return b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m830a() {
    }

    public void a(int i) {
        this.f981a.edit().putLong(a.j(), System.currentTimeMillis() + (i * 1000)).apply();
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
                this.f978a = 0;
            } else {
                if (networkInfo.getType() != 1 && networkInfo.getType() != 6) {
                    b(null);
                }
                b("WIFI-ID-UNKNOWN");
                this.f978a = 1;
            }
            this.f978a = -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m831a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m832b() {
        if (d()) {
            f();
            if (this.f984a && !TextUtils.isEmpty(this.f982a) && this.f982a.equals(this.b)) {
                this.f983a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m190a("[HB] ping timeout count:" + this.f983a);
                if (m824a()) {
                    com.xiaomi.channel.commonutils.logger.b.m190a("[HB] change hb interval for net:" + this.f982a);
                    c(this.f982a);
                    this.f984a = false;
                    this.f983a.getAndSet(0);
                    d(this.f982a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m833c() {
        if (d()) {
            this.b = this.f982a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m834d() {
        if (d()) {
            g();
            if (this.f984a) {
                this.f983a.getAndSet(0);
            }
        }
    }
}
