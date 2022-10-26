package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
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
    public static volatile o a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f982a;

    /* renamed from: a  reason: collision with other field name */
    public long f983a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f984a;

    /* renamed from: a  reason: collision with other field name */
    public final SharedPreferences f985a;

    /* renamed from: a  reason: collision with other field name */
    public String f986a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicInteger f987a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f988a;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public final AtomicInteger f989b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f990b;
    public final AtomicInteger c;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f991c;

    /* loaded from: classes8.dex */
    public class a {
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
        this.f987a = new AtomicInteger(0);
        this.f986a = null;
        this.f988a = false;
        this.b = null;
        this.f989b = new AtomicInteger(0);
        this.c = new AtomicInteger(0);
        this.f982a = -1;
        this.f984a = context;
        this.f991c = com.xiaomi.push.m.m561a(context);
        this.f990b = ba.a(this.f984a).a(ho.bg.a(), true);
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (TextUtils.isEmpty(this.f986a)) {
                return -1;
            }
            try {
                return this.f985a.getInt(a.a(this.f986a), -1);
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

    private void a(String str, String str2, Map map) {
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
            hnVar.g(this.f984a.getPackageName());
            hnVar.e("com.xiaomi.xmsf");
            if (map == null) {
                map = new HashMap();
            }
            String str3 = null;
            t m680a = u.m680a(this.f984a);
            if (m680a != null && !TextUtils.isEmpty(m680a.f1005a)) {
                String[] split = m680a.f1005a.split("@");
                if (split.length > 0) {
                    str3 = split[0];
                }
            }
            map.put("uuid", str3);
            map.put("model", Build.MODEL);
            Context context = this.f984a;
            map.put("avc", String.valueOf(com.xiaomi.push.h.a(context, context.getPackageName())));
            map.put("pvc", String.valueOf(40090));
            map.put("cvc", String.valueOf(48));
            hnVar.a(map);
            hg a2 = hg.a(this.f984a);
            if (a2 != null) {
                a2.a(hnVar, this.f984a.getPackageName());
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) && m660c()) {
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
                com.xiaomi.channel.commonutils.logger.b.m89a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f989b : this.c).set(0);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m658a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.f987a.get() >= Math.max(ba.a(this.f984a).a(ho.bi.a(), 5), 3) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.f985a.getLong(a.j(), -1L) : invokeV.longValue;
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
                com.xiaomi.channel.commonutils.logger.b.m89a(String.format("[HB] network changed, netid:%s, %s", this.f986a, Boolean.valueOf(this.f988a)));
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
            com.xiaomi.channel.commonutils.logger.b.m89a(String.format("[HB] network changed, netid:%s, %s", this.f986a, Boolean.valueOf(this.f988a)));
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m659b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? (TextUtils.isEmpty(this.f986a) || !this.f986a.startsWith("M-") || ba.a(this.f984a).a(ho.bj.a(), false)) ? false : true : invokeV.booleanValue;
    }

    private long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? ba.a(this.f984a).a(ho.br.a(), 777600000L) : invokeV.longValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && a(str)) {
            this.f985a.edit().putInt(a.a(str), 235000).apply();
            this.f985a.edit().putLong(a.b(this.f986a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m660c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return d() && ba.a(this.f984a).a(ho.bh.a(), true) && com.xiaomi.push.q.a.name().equals(com.xiaomi.push.service.a.a(this.f984a).a());
        }
        return invokeV.booleanValue;
    }

    private void d(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, str) == null) && m660c() && !TextUtils.isEmpty(str)) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            return this.f991c && (this.f990b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.f985a.getBoolean(a.a(), false)) {
            return;
        }
        this.f985a.edit().putBoolean(a.a(), true).apply();
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m661e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            long j = this.f985a.getLong(a.c(), -1L);
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
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m662f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (this.f983a == -1) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f983a;
            return j > currentTimeMillis || currentTimeMillis - j >= ImagesInvalidService.FILE_VALID_TIME;
        }
        return invokeV.booleanValue;
    }

    private void g() {
        int i;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && m660c()) {
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
                        com.xiaomi.channel.commonutils.logger.b.m89a("[HB] report hb changed events.");
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
                com.xiaomi.channel.commonutils.logger.b.m89a("[HB] report support wifi digest events.");
                this.f985a.edit().putBoolean(a.b(), true).apply();
            }
            if (m661e()) {
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
                        com.xiaomi.channel.commonutils.logger.b.m89a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f985a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m662f()) {
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
                        com.xiaomi.channel.commonutils.logger.b.m89a("[HB] report ping timeout count events of mobile network.");
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
                        com.xiaomi.channel.commonutils.logger.b.m89a("[HB] report ping timeout count events of wifi network.");
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
    public long m663a() {
        InterceptResult invokeV;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long b = gc.b();
            if (this.f991c && !m659b() && ((ba.a(this.f984a).a(ho.bg.a(), true) || b() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
                b = a2;
            }
            if (!TextUtils.isEmpty(this.f986a) && !"WIFI-ID-UNKNOWN".equals(this.f986a) && this.f982a == 1) {
                a(b < 300000);
            }
            com.xiaomi.channel.commonutils.logger.b.m89a("[HB] ping interval:" + b);
            return b;
        }
        return invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m664a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f985a.edit().putLong(a.j(), System.currentTimeMillis() + (i * 1000)).apply();
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
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m665a(String str) {
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
    public void m666b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && d()) {
            f();
            if (this.f988a && !TextUtils.isEmpty(this.f986a) && this.f986a.equals(this.b)) {
                this.f987a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m89a("[HB] ping timeout count:" + this.f987a);
                if (m658a()) {
                    com.xiaomi.channel.commonutils.logger.b.m89a("[HB] change hb interval for net:" + this.f986a);
                    c(this.f986a);
                    this.f988a = false;
                    this.f987a.getAndSet(0);
                    d(this.f986a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m667c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && d()) {
            this.b = this.f986a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m668d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && d()) {
            g();
            if (this.f988a) {
                this.f987a.getAndSet(0);
            }
        }
    }
}
