package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
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
    public int f1005a;

    /* renamed from: a  reason: collision with other field name */
    public long f1006a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f1007a;

    /* renamed from: a  reason: collision with other field name */
    public final SharedPreferences f1008a;

    /* renamed from: a  reason: collision with other field name */
    public String f1009a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicInteger f1010a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f1011a;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public final AtomicInteger f1012b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f1013b;
    public final AtomicInteger c;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f1014c;

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
        this.f1010a = new AtomicInteger(0);
        this.f1009a = null;
        this.f1011a = false;
        this.b = null;
        this.f1012b = new AtomicInteger(0);
        this.c = new AtomicInteger(0);
        this.f1005a = -1;
        this.f1007a = context;
        this.f1014c = com.xiaomi.push.m.m635a(context);
        this.f1013b = ba.a(this.f1007a).a(ho.bg.a(), true);
        this.f1008a = this.f1007a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f1008a.getLong(a.c(), -1L) == -1) {
            this.f1008a.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j = this.f1008a.getLong(a.i(), -1L);
        this.f1006a = j;
        if (j == -1) {
            this.f1006a = currentTimeMillis;
            this.f1008a.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            if (TextUtils.isEmpty(this.f1009a)) {
                return -1;
            }
            try {
                return this.f1008a.getInt(a.a(this.f1009a), -1);
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
            hnVar.g(this.f1007a.getPackageName());
            hnVar.e("com.xiaomi.xmsf");
            if (map == null) {
                map = new HashMap<>();
            }
            String str3 = null;
            t m754a = u.m754a(this.f1007a);
            if (m754a != null && !TextUtils.isEmpty(m754a.f1028a)) {
                String[] split = m754a.f1028a.split("@");
                if (split.length > 0) {
                    str3 = split[0];
                }
            }
            map.put("uuid", str3);
            map.put("model", Build.MODEL);
            Context context = this.f1007a;
            map.put("avc", String.valueOf(com.xiaomi.push.h.a(context, context.getPackageName())));
            map.put("pvc", String.valueOf(40090));
            map.put("cvc", String.valueOf(48));
            hnVar.a(map);
            hg a2 = hg.a(this.f1007a);
            if (a2 != null) {
                a2.a(hnVar, this.f1007a.getPackageName());
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) && m734c()) {
            int incrementAndGet = (z ? this.f1012b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d = z ? a.d() : a.e();
                int i = this.f1008a.getInt(d, 0) + incrementAndGet;
                this.f1008a.edit().putInt(d, i).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i);
                com.xiaomi.channel.commonutils.logger.b.m103a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f1012b : this.c).set(0);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m732a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.f1010a.get() >= Math.max(ba.a(this.f1007a).a(ho.bi.a(), 5), 3) : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? this.f1008a.getLong(a.j(), -1L) : invokeV.longValue;
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
                String str2 = this.f1009a;
                if (str2 == null || !str2.startsWith("W-")) {
                    str = null;
                }
                i = this.f1008a.getInt(a.a(this.f1009a), -1);
                long j = this.f1008a.getLong(a.b(this.f1009a), -1L);
                long currentTimeMillis = System.currentTimeMillis();
                if (i != -1) {
                    if (j == -1) {
                        remove = this.f1008a.edit().putLong(a.b(this.f1009a), currentTimeMillis + c());
                    } else if (currentTimeMillis > j) {
                        remove = this.f1008a.edit().remove(a.a(this.f1009a)).remove(a.b(this.f1009a));
                    }
                    remove.apply();
                }
                this.f1010a.getAndSet(0);
                if (TextUtils.isEmpty(this.f1009a) && a() == -1) {
                    this.f1011a = true;
                } else {
                    this.f1011a = false;
                }
                com.xiaomi.channel.commonutils.logger.b.m103a(String.format("[HB] network changed, netid:%s, %s", this.f1009a, Boolean.valueOf(this.f1011a)));
            }
            this.f1009a = str;
            i = this.f1008a.getInt(a.a(this.f1009a), -1);
            long j2 = this.f1008a.getLong(a.b(this.f1009a), -1L);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (i != -1) {
            }
            this.f1010a.getAndSet(0);
            if (TextUtils.isEmpty(this.f1009a)) {
            }
            this.f1011a = false;
            com.xiaomi.channel.commonutils.logger.b.m103a(String.format("[HB] network changed, netid:%s, %s", this.f1009a, Boolean.valueOf(this.f1011a)));
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m733b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? (TextUtils.isEmpty(this.f1009a) || !this.f1009a.startsWith("M-") || ba.a(this.f1007a).a(ho.bj.a(), false)) ? false : true : invokeV.booleanValue;
    }

    private long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? ba.a(this.f1007a).a(ho.br.a(), 777600000L) : invokeV.longValue;
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, this, str) == null) && a(str)) {
            this.f1008a.edit().putInt(a.a(str), 235000).apply();
            this.f1008a.edit().putLong(a.b(this.f1009a), System.currentTimeMillis() + c()).apply();
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m734c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return d() && ba.a(this.f1007a).a(ho.bh.a(), true) && com.xiaomi.push.q.a.name().equals(com.xiaomi.push.service.a.a(this.f1007a).a());
        }
        return invokeV.booleanValue;
    }

    private void d(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, str) == null) && m734c() && !TextUtils.isEmpty(str)) {
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
            String string = this.f1008a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f1008a.edit().putString(a.f(), str3).apply();
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            return this.f1014c && (this.f1013b || ((b() > System.currentTimeMillis() ? 1 : (b() == System.currentTimeMillis() ? 0 : -1)) >= 0));
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.f1008a.getBoolean(a.a(), false)) {
            return;
        }
        this.f1008a.edit().putBoolean(a.a(), true).apply();
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m735e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            long j = this.f1008a.getLong(a.c(), -1L);
            if (j == -1) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
        }
        return invokeV.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            int i = this.f1005a;
            String h = i != 0 ? i != 1 ? null : a.h() : a.g();
            if (TextUtils.isEmpty(h)) {
                return;
            }
            if (this.f1008a.getLong(a.i(), -1L) == -1) {
                this.f1006a = System.currentTimeMillis();
                this.f1008a.edit().putLong(a.i(), this.f1006a).apply();
            }
            this.f1008a.edit().putInt(h, this.f1008a.getInt(h, 0) + 1).apply();
        }
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m736f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (this.f1006a == -1) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f1006a;
            return j > currentTimeMillis || currentTimeMillis - j >= 259200000;
        }
        return invokeV.booleanValue;
    }

    private void g() {
        int i;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && m734c()) {
            String string = this.f1008a.getString(a.f(), null);
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
                        com.xiaomi.channel.commonutils.logger.b.m103a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f1008a.edit().remove(a.f()).apply();
            }
            if (this.f1008a.getBoolean(a.a(), false) && !this.f1008a.getBoolean(a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put("model", Build.MODEL);
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                com.xiaomi.channel.commonutils.logger.b.m103a("[HB] report support wifi digest events.");
                this.f1008a.edit().putBoolean(a.b(), true).apply();
            }
            if (m735e()) {
                int i3 = this.f1008a.getInt(a.d(), 0);
                int i4 = this.f1008a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j = this.f1008a.getLong(a.c(), -1L);
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
                        com.xiaomi.channel.commonutils.logger.b.m103a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f1008a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m736f()) {
                String valueOf4 = String.valueOf(this.f1006a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f1008a.getInt(a.g(), 0);
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
                        com.xiaomi.channel.commonutils.logger.b.m103a("[HB] report ping timeout count events of mobile network.");
                        this.f1008a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f1008a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i = 0;
                int i6 = this.f1008a.getInt(a.h(), i);
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
                        com.xiaomi.channel.commonutils.logger.b.m103a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f1008a.edit().putInt(a.h(), 0).apply();
                }
                this.f1006a = System.currentTimeMillis();
                this.f1008a.edit().putLong(a.i(), this.f1006a).apply();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m737a() {
        InterceptResult invokeV;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long b = gc.b();
            if (this.f1014c && !m733b() && ((ba.a(this.f1007a).a(ho.bg.a(), true) || b() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
                b = a2;
            }
            if (!TextUtils.isEmpty(this.f1009a) && !"WIFI-ID-UNKNOWN".equals(this.f1009a) && this.f1005a == 1) {
                a(b < 300000);
            }
            com.xiaomi.channel.commonutils.logger.b.m103a("[HB] ping interval:" + b);
            return b;
        }
        return invokeV.longValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m738a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f1008a.edit().putLong(a.j(), System.currentTimeMillis() + (i * 1000)).apply();
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
                        this.f1005a = 0;
                    } else {
                        if (networkInfo.getType() != 1 && networkInfo.getType() != 6) {
                            b(null);
                        }
                        b("WIFI-ID-UNKNOWN");
                        this.f1005a = 1;
                    }
                    this.f1005a = -1;
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m739a(String str) {
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
    public void m740b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && d()) {
            f();
            if (this.f1011a && !TextUtils.isEmpty(this.f1009a) && this.f1009a.equals(this.b)) {
                this.f1010a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m103a("[HB] ping timeout count:" + this.f1010a);
                if (m732a()) {
                    com.xiaomi.channel.commonutils.logger.b.m103a("[HB] change hb interval for net:" + this.f1009a);
                    c(this.f1009a);
                    this.f1011a = false;
                    this.f1010a.getAndSet(0);
                    d(this.f1009a);
                }
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m741c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && d()) {
            this.b = this.f1009a;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m742d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && d()) {
            g();
            if (this.f1011a) {
                this.f1010a.getAndSet(0);
            }
        }
    }
}
