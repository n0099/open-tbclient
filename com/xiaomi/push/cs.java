package com.xiaomi.push;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.module.PushChannelRegion;
import com.yy.gslbsdk.db.ResultTB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class cs {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f39949a;

    /* renamed from: a  reason: collision with other field name */
    public static a f197a;

    /* renamed from: a  reason: collision with other field name */
    public static cs f198a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f199a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, co> f39950b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39951c;

    /* renamed from: d  reason: collision with root package name */
    public static String f39952d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f200a;

    /* renamed from: a  reason: collision with other field name */
    public cr f201a;

    /* renamed from: a  reason: collision with other field name */
    public b f202a;

    /* renamed from: a  reason: collision with other field name */
    public String f203a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, cp> f204a;

    /* renamed from: b  reason: collision with other field name */
    public final long f205b;

    /* renamed from: b  reason: collision with other field name */
    public String f206b;

    /* renamed from: c  reason: collision with other field name */
    public long f207c;

    /* loaded from: classes6.dex */
    public interface a {
        cs a(Context context, cr crVar, b bVar, String str);
    }

    /* loaded from: classes6.dex */
    public interface b {
        String a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56377392, "Lcom/xiaomi/push/cs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56377392, "Lcom/xiaomi/push/cs;");
                return;
            }
        }
        f39950b = new HashMap();
        f199a = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cs(Context context, cr crVar, b bVar, String str) {
        this(context, crVar, bVar, str, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, crVar, bVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (cr) objArr2[1], (b) objArr2[2], (String) objArr2[3], (String) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public cs(Context context, cr crVar, b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, crVar, bVar, str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f204a = new HashMap();
        this.f203a = "0";
        this.f200a = 0L;
        this.f205b = 15L;
        this.f207c = 0L;
        this.f206b = "isp_prov_city_country_ip";
        this.f202a = bVar;
        this.f201a = crVar == null ? new ct(this) : crVar;
        this.f203a = str;
        f39951c = str2 == null ? context.getPackageName() : str2;
        f39952d = str3 == null ? f() : str3;
    }

    public static synchronized cs a() {
        InterceptResult invokeV;
        cs csVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (cs.class) {
                if (f198a == null) {
                    throw new IllegalStateException("the host manager is not initialized yet.");
                }
                csVar = f198a;
            }
            return csVar;
        }
        return (cs) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m228a() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Context context = f39949a;
            if (context == null) {
                return "unknown";
            }
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Throwable unused) {
            }
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() != 1) {
                return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
            }
            WifiManager wifiManager = (WifiManager) f39949a.getSystemService("wifi");
            if (wifiManager != null && wifiManager.getConnectionInfo() != null) {
                return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
            }
            return "unknown";
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                int length = str.length();
                byte[] bytes = str.getBytes("UTF-8");
                for (int i2 = 0; i2 < bytes.length; i2++) {
                    byte b2 = bytes[i2];
                    int i3 = b2 & 240;
                    if (i3 != 240) {
                        bytes[i2] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i3);
                    }
                }
                return new String(bytes);
            } catch (UnsupportedEncodingException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    private ArrayList<co> a(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, arrayList)) == null) {
            m237d();
            synchronized (this.f204a) {
                m233a();
                for (String str : this.f204a.keySet()) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
            boolean isEmpty = f39950b.isEmpty();
            synchronized (f39950b) {
                for (Object obj : f39950b.values().toArray()) {
                    co coVar = (co) obj;
                    if (!coVar.b()) {
                        f39950b.remove(coVar.f194b);
                        isEmpty = true;
                    }
                }
            }
            if (!arrayList.contains(b())) {
                arrayList.add(b());
            }
            ArrayList<co> arrayList2 = new ArrayList<>(arrayList.size());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.add(null);
            }
            try {
                String str2 = bg.e(f39949a) ? "wifi" : "wap";
                String a2 = a(arrayList, str2, this.f203a, isEmpty);
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject3 = new JSONObject(a2);
                    com.xiaomi.channel.commonutils.logger.b.b(a2);
                    if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                        String string = jSONObject4.getString("province");
                        String string2 = jSONObject4.getString("city");
                        String string3 = jSONObject4.getString("isp");
                        String string4 = jSONObject4.getString("ip");
                        String string5 = jSONObject4.getString("country");
                        JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                        com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                        int i3 = 0;
                        while (i3 < arrayList.size()) {
                            String str3 = arrayList.get(i3);
                            JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                            if (optJSONArray == null) {
                                com.xiaomi.channel.commonutils.logger.b.m70a("no bucket found for " + str3);
                                jSONObject = jSONObject5;
                            } else {
                                co coVar2 = new co(str3);
                                int i4 = 0;
                                while (i4 < optJSONArray.length()) {
                                    String string6 = optJSONArray.getString(i4);
                                    if (TextUtils.isEmpty(string6)) {
                                        jSONObject2 = jSONObject5;
                                    } else {
                                        jSONObject2 = jSONObject5;
                                        coVar2.a(new cx(string6, optJSONArray.length() - i4));
                                    }
                                    i4++;
                                    jSONObject5 = jSONObject2;
                                }
                                jSONObject = jSONObject5;
                                arrayList2.set(i3, coVar2);
                                coVar2.f39944g = string5;
                                coVar2.f39940c = string;
                                coVar2.f39942e = string3;
                                coVar2.f39943f = string4;
                                coVar2.f39941d = string2;
                                if (jSONObject4.has("stat-percent")) {
                                    coVar2.a(jSONObject4.getDouble("stat-percent"));
                                }
                                if (jSONObject4.has("stat-domain")) {
                                    coVar2.b(jSONObject4.getString("stat-domain"));
                                }
                                if (jSONObject4.has(ResultTB.TTL)) {
                                    coVar2.a(jSONObject4.getInt(ResultTB.TTL) * 1000);
                                }
                                m232a(coVar2.a());
                            }
                            i3++;
                            jSONObject5 = jSONObject;
                        }
                        JSONObject optJSONObject = jSONObject4.optJSONObject(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
                        if (optJSONObject != null) {
                            long j = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                                if (optJSONArray2 == null) {
                                    com.xiaomi.channel.commonutils.logger.b.m70a("no bucket found for " + next);
                                } else {
                                    co coVar3 = new co(next);
                                    coVar3.a(j);
                                    for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                                        String string7 = optJSONArray2.getString(i5);
                                        if (!TextUtils.isEmpty(string7)) {
                                            coVar3.a(new cx(string7, optJSONArray2.length() - i5));
                                        }
                                    }
                                    synchronized (f39950b) {
                                        if (this.f201a.a(next)) {
                                            f39950b.put(next, coVar3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a("failed to get bucket " + e2.getMessage());
            }
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                co coVar4 = arrayList2.get(i6);
                if (coVar4 != null) {
                    a(arrayList.get(i6), coVar4);
                }
            }
            m236c();
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static synchronized void a(Context context, cr crVar, b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, crVar, bVar, str, str2, str3}) == null) {
            synchronized (cs.class) {
                Context applicationContext = context.getApplicationContext();
                f39949a = applicationContext;
                if (applicationContext == null) {
                    f39949a = context;
                }
                if (f198a == null) {
                    if (f197a == null) {
                        f198a = new cs(context, crVar, bVar, str, str2, str3);
                    } else {
                        f198a = f197a.a(context, crVar, bVar, str);
                    }
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, aVar) == null) {
            synchronized (cs.class) {
                f197a = aVar;
                f198a = null;
            }
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            co coVar = f39950b.get(str);
            synchronized (f39950b) {
                if (coVar == null) {
                    co coVar2 = new co(str);
                    coVar2.a(604800000L);
                    coVar2.m221a(str2);
                    f39950b.put(str, coVar2);
                } else {
                    coVar.m221a(str2);
                }
            }
        }
    }

    private String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            try {
                PackageInfo packageInfo = f39949a.getPackageManager().getPackageInfo(f39949a.getPackageName(), 16384);
                return packageInfo != null ? packageInfo.versionName : "0";
            } catch (Exception unused) {
                return "0";
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public co m229a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("the url is empty");
            }
            return a(new URL(str).getHost(), true);
        }
        return (co) invokeL.objValue;
    }

    public co a(String str, boolean z) {
        InterceptResult invokeLZ;
        co d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("the host is empty");
            }
            if (this.f201a.a(str)) {
                co c2 = c(str);
                return (c2 == null || !c2.b()) ? (z && bg.b(f39949a) && (d2 = d(str)) != null) ? d2 : new cu(this, str, c2) : c2;
            }
            return null;
        }
        return (co) invokeLZ.objValue;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{arrayList, str, str2, Boolean.valueOf(z)})) == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<bf> arrayList3 = new ArrayList();
            arrayList3.add(new bd("type", str));
            if (str.equals("wap")) {
                arrayList3.add(new bd("conpt", a(bg.m172a(f39949a))));
            }
            if (z) {
                arrayList3.add(new bd(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "1"));
            }
            arrayList3.add(new bd("uuid", str2));
            arrayList3.add(new bd("list", bm.a(arrayList, ",")));
            arrayList3.add(new bd("countrycode", com.xiaomi.push.service.a.a(f39949a).b()));
            co c2 = c(b());
            String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", b());
            if (c2 == null) {
                arrayList2.add(format);
                synchronized (f39950b) {
                    co coVar = f39950b.get("resolver.msg.xiaomi.net");
                    if (coVar != null) {
                        Iterator<String> it = coVar.a(true).iterator();
                        while (it.hasNext()) {
                            arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", it.next()));
                        }
                    }
                }
            } else {
                arrayList2 = c2.a(format);
            }
            Iterator<String> it2 = arrayList2.iterator();
            IOException e2 = null;
            while (it2.hasNext()) {
                Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
                for (bf bfVar : arrayList3) {
                    buildUpon.appendQueryParameter(bfVar.a(), bfVar.b());
                }
                try {
                    return this.f202a == null ? bg.a(f39949a, new URL(buildUpon.toString())) : this.f202a.a(buildUpon.toString());
                } catch (IOException e3) {
                    e2 = e3;
                }
            }
            if (e2 == null) {
                return null;
            }
            com.xiaomi.channel.commonutils.logger.b.m70a("network exception: " + e2.getMessage());
            throw e2;
        }
        return (String) invokeCommon.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m230a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.f204a) {
                jSONObject = new JSONObject();
                jSONObject.put("ver", 2);
                JSONArray jSONArray = new JSONArray();
                for (cp cpVar : this.f204a.values()) {
                    jSONArray.put(cpVar.m225a());
                }
                jSONObject.put("data", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                for (co coVar : f39950b.values()) {
                    jSONArray2.put(coVar.m220a());
                }
                jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m231a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f204a) {
                this.f204a.clear();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m232a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f206b = str;
        }
    }

    public void a(String str, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, coVar) == null) {
            if (TextUtils.isEmpty(str) || coVar == null) {
                throw new IllegalArgumentException("the argument is invalid " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + coVar);
            } else if (this.f201a.a(str)) {
                synchronized (this.f204a) {
                    m233a();
                    if (this.f204a.containsKey(str)) {
                        this.f204a.get(str).a(coVar);
                    } else {
                        cp cpVar = new cp(str);
                        cpVar.a(coVar);
                        this.f204a.put(str, cpVar);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m233a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.f204a) {
                if (f199a) {
                    return true;
                }
                f199a = true;
                this.f204a.clear();
                String d2 = d();
                if (TextUtils.isEmpty(d2)) {
                    return false;
                }
                m235b(d2);
                com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public co b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? a(str, true) : (co) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String a2 = com.xiaomi.push.service.a.a(f39949a).a();
            return (TextUtils.isEmpty(a2) || PushChannelRegion.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m234b() {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f204a) {
                m233a();
                arrayList = new ArrayList<>(this.f204a.keySet());
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    cp cpVar = this.f204a.get(arrayList.get(size));
                    if (cpVar != null && cpVar.a() != null) {
                        arrayList.remove(size);
                    }
                }
            }
            ArrayList<co> a2 = a(arrayList);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (a2.get(i2) != null) {
                    a(arrayList.get(i2), a2.get(i2));
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m235b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            synchronized (this.f204a) {
                this.f204a.clear();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("ver") != 2) {
                    throw new JSONException("Bad version");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    cp a2 = new cp().a(optJSONArray.getJSONObject(i2));
                    this.f204a.put(a2.m223a(), a2);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    co a3 = new co("").a(optJSONArray2.getJSONObject(i3));
                    f39950b.put(a3.f194b, a3);
                }
            }
        }
    }

    public co c(String str) {
        InterceptResult invokeL;
        cp cpVar;
        co a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            synchronized (this.f204a) {
                m233a();
                cpVar = this.f204a.get(str);
            }
            if (cpVar == null || (a2 = cpVar.a()) == null) {
                return null;
            }
            return a2;
        }
        return (co) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (this.f204a) {
                for (Map.Entry<String, cp> entry : this.f204a.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(":\n");
                    sb.append(entry.getValue().toString());
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m236c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.f204a) {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(f39949a.openFileOutput(e(), 0)));
                    String jSONObject = m230a().toString();
                    if (!TextUtils.isEmpty(jSONObject)) {
                        bufferedWriter.write(jSONObject);
                    }
                    bufferedWriter.close();
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("persist bucket failure: " + e2.getMessage());
                }
            }
        }
    }

    public co d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (System.currentTimeMillis() - this.f207c > this.f200a * 60 * 1000) {
                this.f207c = System.currentTimeMillis();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                co coVar = a(arrayList).get(0);
                if (coVar != null) {
                    this.f200a = 0L;
                    return coVar;
                }
                long j = this.f200a;
                if (j < 15) {
                    this.f200a = j + 1;
                    return null;
                }
                return null;
            }
            return null;
        }
        return (co) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048592, this)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            file = new File(f39949a.getFilesDir(), e());
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (!file.isFile()) {
            y.a((Closeable) null);
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                com.xiaomi.channel.commonutils.logger.b.m70a("load host exception " + th.getMessage());
                return null;
            } finally {
                y.a(bufferedReader);
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m237d() {
        String next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f204a) {
                for (cp cpVar : this.f204a.values()) {
                    cpVar.a(true);
                }
                while (true) {
                    for (boolean z = false; !z; z = true) {
                        Iterator<String> it = this.f204a.keySet().iterator();
                        while (it.hasNext()) {
                            next = it.next();
                            if (this.f204a.get(next).m224a().isEmpty()) {
                                break;
                            }
                        }
                    }
                    this.f204a.remove(next);
                }
            }
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) f39949a.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "com.xiaomi";
            }
            return "com.xiaomi";
        }
        return (String) invokeV.objValue;
    }
}
