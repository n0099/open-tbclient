package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.gc;
import com.xiaomi.push.hg;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile o a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f974a;

    /* renamed from: a  reason: collision with other field name */
    public long f975a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f976a;

    /* renamed from: a  reason: collision with other field name */
    public final SharedPreferences f977a;

    /* renamed from: a  reason: collision with other field name */
    public String f978a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicInteger f979a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f980a;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public final AtomicInteger f981b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f982b;
    public final AtomicInteger c;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f983c;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? "support_wifi_digest" : (String) invokeV.objValue;
        }

        public static String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? String.format("HB_%s", str) : (String) invokeL.objValue;
        }

        public static String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "record_support_wifi_digest_reported" : (String) invokeV.objValue;
        }

        public static String b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? String.format("HB_dead_time_%s", str) : (String) invokeL.objValue;
        }

        public static String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "record_hb_count_start" : (String) invokeV.objValue;
        }

        public static String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? "record_short_hb_count" : (String) invokeV.objValue;
        }

        public static String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? "record_long_hb_count" : (String) invokeV.objValue;
        }

        public static String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? "record_hb_change" : (String) invokeV.objValue;
        }

        public static String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? "record_mobile_ptc" : (String) invokeV.objValue;
        }

        public static String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? "record_wifi_ptc" : (String) invokeV.objValue;
        }

        public static String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? "record_ptc_start" : (String) invokeV.objValue;
        }

        public static String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? "keep_short_hb_effective_time" : (String) invokeV.objValue;
        }
    }

    public o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f979a = new AtomicInteger(0);
        this.f978a = null;
        this.f980a = false;
        this.b = null;
        this.f981b = new AtomicInteger(0);
        this.c = new AtomicInteger(0);
        this.f974a = -1;
        this.f976a = context;
        this.f983c = com.xiaomi.push.m.m556a(context);
        this.f982b = ba.a(this.f976a).a(ho.bg.a(), true);
        this.f977a = this.f976a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f977a.getLong(a.c(), -1L) == -1) {
            this.f977a.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j = this.f977a.getLong(a.i(), -1L);
        this.f975a = j;
        if (j == -1) {
            this.f975a = currentTimeMillis;
            this.f977a.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (TextUtils.isEmpty(this.f978a)) {
                return -1;
            }
            try {
                return this.f977a.getInt(a.a(this.f978a), -1);
            } catch (Throwable unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public static o a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (o.class) {
                    if (a == null) {
                        a = new o(context);
                    }
                }
            }
            return a;
        }
        return (o) invokeL.objValue;
    }

    private void a(String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, str, str2, map) == null) {
            hn hnVar = new hn();
            hnVar.d(str);
            hnVar.c("hb_name");
            hnVar.a("hb_channel");
            hnVar.a(1L);
            hnVar.b(str2);
            hnVar.a(false);
            hnVar.b(System.currentTimeMillis());
            hnVar.g(this.f976a.getPackageName());
            hnVar.e("com.xiaomi.xmsf");
            if (map == null) {
                map = new HashMap<>();
            }
            String str3 = null;
            t m675a = u.m675a(this.f976a);
            if (m675a != null && !TextUtils.isEmpty(m675a.f997a)) {
                String[] split = m675a.f997a.split("@");
                if (split.length > 0) {
                    str3 = split[0];
                }
            }
            map.put("uuid", str3);
            map.put("model", Build.MODEL);
            Context context = this.f976a;
            map.put("avc", String.valueOf(com.xiaomi.push.h.a(context, context.getPackageName())));
            map.put("pvc", String.valueOf(40090));
            map.put("cvc", String.valueOf(48));
            hnVar.a(map);
            hg a2 = hg.a(this.f976a);
            if (a2 != null) {
                a2.a(hnVar, this.f976a.getPackageName());
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) && m655c()) {
            int incrementAndGet = (z ? this.f981b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d = z ? a.d() : a.e();
                int i = this.f977a.getInt(d, 0) + incrementAndGet;
                this.f977a.edit().putInt(d, i).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i);
                com.xiaomi.channel.commonutils.logger.b.m84a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f981b : this.c).set(0);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m653a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.f979a.get() >= Math.max(ba.a(this.f976a).a(ho.bi.a(), 5), 3) : invokeV.booleanValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("W-") || str.startsWith("M-");
        }
        return invokeL.booleanValue;
    }

    private long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.f977a.getLong(a.j(), -1L) : invokeV.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(String str) {
        int i;
        SharedPreferences.Editor remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            if ("WIFI-ID-UNKNOWN".equals(str)) {
                String str2 = this.f978a;
                if (str2 == null || !str2.startsWith("W-")) {
                    str = null;
                }
                i = this.f977a.getInt(a.a(this.f978a), -1);
                long j = this.f977a.getLong(a.b(this.f978a), -1L);
                long currentTimeMillis = System.currentTimeMillis();
                if (i != -1) {
                    if (j == -1) {
                        remove = this.f977a.edit().putLong(a.b(this.f978a), currentTimeMillis + c());
                    } else if (currentTimeMillis > j) {
                        remove = this.f977a.edit().remove(a.a(this.f978a)).remove(a.b(this.f978a));
                    }
                    remove.apply();
                }
                this.f979a.getAndSet(0);
                if (TextUtils.isEmpty(this.f978a) && a() == -1) {
                    this.f980a = true;
                } else {
                    this.f980a = false;
                }
                com.xiaomi.channel.commonutils.logger.b.m84a(String.format("[HB] network changed, netid:%s, %s", this.f978a, Boolean.valueOf(this.f980a)));
            }
            this.f978a = str;
            i = this.f977a.getInt(a.a(this.f978a), -1);
            long j2 = this.f977a.getLong(a.b(this.f978a), -1L);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (i != -1) {
            }
            this.f979a.getAndSet(0);
            if (TextUtils.isEmpty(this.f978a)) {
            }
            this.f980a = false;
            com.xiaomi.channel.commonutils.logger.b.m84a(String.format("[HB] network changed, netid:%s, %s", this.f978a, Boolean.valueOf(this.f980a)));
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m654b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? (TextUtils.isEmpty(this.f978a) || !this.f978a.startsWith("M-") || ba.a(this.f976a).a(ho.bj.a(), false)) ? false : true : invokeV.booleanValue;
    }

    private long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? ba.a(this.f976a).a(ho.br.a(), 777600000L) : invokeV.longValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && a(str)) {
            this.f977a.edit().putInt(a.a(str), 235000).apply();
            this.f977a.edit().putLong(a.b(this.f978a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m655c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return d() && ba.a(this.f976a).a(ho.bh.a(), true) && com.xiaomi.push.q.a.name().equals(com.xiaomi.push.service.a.a(this.f976a).a());
        }
        return invokeV.booleanValue;
    }

    private void d(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, str) == null) && m655c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = "W";
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
            String string = this.f977a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f977a.edit().putString(a.f(), str3).apply();
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            return this.f983c && (this.f982b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.f977a.getBoolean(a.a(), false)) {
            return;
        }
        this.f977a.edit().putBoolean(a.a(), true).apply();
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m656e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            long j = this.f977a.getLong(a.c(), -1L);
            if (j == -1) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            return j > currentTimeMillis || currentTimeMillis - j >= ImagesInvalidService.FILE_VALID_TIME;
        }
        return invokeV.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            int i = this.f974a;
            String h = i != 0 ? i != 1 ? null : a.h() : a.g();
            if (TextUtils.isEmpty(h)) {
                return;
            }
            if (this.f977a.getLong(a.i(), -1L) == -1) {
                this.f975a = System.currentTimeMillis();
                this.f977a.edit().putLong(a.i(), this.f975a).apply();
            }
            this.f977a.edit().putInt(h, this.f977a.getInt(h, 0) + 1).apply();
        }
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m657f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (this.f975a == -1) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f975a;
            return j > currentTimeMillis || currentTimeMillis - j >= ImagesInvalidService.FILE_VALID_TIME;
        }
        return invokeV.booleanValue;
    }

    private void g() {
        int i;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && m655c()) {
            String string = this.f977a.getString(a.f(), null);
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
                        com.xiaomi.channel.commonutils.logger.b.m84a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f977a.edit().remove(a.f()).apply();
            }
            if (this.f977a.getBoolean(a.a(), false) && !this.f977a.getBoolean(a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put("model", Build.MODEL);
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                com.xiaomi.channel.commonutils.logger.b.m84a("[HB] report support wifi digest events.");
                this.f977a.edit().putBoolean(a.b(), true).apply();
            }
            if (m656e()) {
                int i3 = this.f977a.getInt(a.d(), 0);
                int i4 = this.f977a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j = this.f977a.getLong(a.c(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("interval", valueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, valueOf2);
                        jSONObject.put("end_time", valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        com.xiaomi.channel.commonutils.logger.b.m84a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f977a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m657f()) {
                String valueOf4 = String.valueOf(this.f975a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f977a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("net_type", "M");
                        jSONObject3.put("ptc", i5);
                        jSONObject3.put(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, valueOf4);
                        jSONObject3.put("end_time", valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        com.xiaomi.channel.commonutils.logger.b.m84a("[HB] report ping timeout count events of mobile network.");
                        this.f977a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f977a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f977a.getInt(a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("net_type", "W");
                        jSONObject5.put("ptc", i6);
                        jSONObject5.put(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY, valueOf4);
                        jSONObject5.put("end_time", valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        com.xiaomi.channel.commonutils.logger.b.m84a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f977a.edit().putInt(a.h(), 0).apply();
                }
                this.f975a = System.currentTimeMillis();
                this.f977a.edit().putLong(a.i(), this.f975a).apply();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m658a() {
        InterceptResult invokeV;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long b = gc.b();
            if (this.f983c && !m654b() && ((ba.a(this.f976a).a(ho.bg.a(), true) || b() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
                b = a2;
            }
            if (!TextUtils.isEmpty(this.f978a) && !"WIFI-ID-UNKNOWN".equals(this.f978a) && this.f974a == 1) {
                a(b < 300000);
            }
            com.xiaomi.channel.commonutils.logger.b.m84a("[HB] ping interval:" + b);
            return b;
        }
        return invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m659a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f977a.edit().putLong(a.j(), System.currentTimeMillis() + (i * 1000)).apply();
        }
    }

    public synchronized void a(NetworkInfo networkInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, networkInfo) == null) {
            synchronized (this) {
                if (d()) {
                    String str = null;
                    if (networkInfo == null) {
                        b(null);
                    } else if (networkInfo.getType() == 0) {
                        String subtypeName = networkInfo.getSubtypeName();
                        if (!TextUtils.isEmpty(subtypeName) && !RomUtils.UNKNOWN.equalsIgnoreCase(subtypeName)) {
                            str = "M-" + subtypeName;
                        }
                        b(str);
                        this.f974a = 0;
                    } else {
                        if (networkInfo.getType() != 1 && networkInfo.getType() != 6) {
                            b(null);
                        }
                        b("WIFI-ID-UNKNOWN");
                        this.f974a = 1;
                    }
                    this.f974a = -1;
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m660a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str)) {
                    e();
                }
                if (d() && !TextUtils.isEmpty(str)) {
                    b("W-" + str);
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m661b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && d()) {
            f();
            if (this.f980a && !TextUtils.isEmpty(this.f978a) && this.f978a.equals(this.b)) {
                this.f979a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m84a("[HB] ping timeout count:" + this.f979a);
                if (m653a()) {
                    com.xiaomi.channel.commonutils.logger.b.m84a("[HB] change hb interval for net:" + this.f978a);
                    c(this.f978a);
                    this.f980a = false;
                    this.f979a.getAndSet(0);
                    d(this.f978a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m662c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && d()) {
            this.b = this.f978a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m663d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && d()) {
            g();
            if (this.f980a) {
                this.f979a.getAndSet(0);
            }
        }
    }
}
