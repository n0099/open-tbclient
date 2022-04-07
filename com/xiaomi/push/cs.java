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
/* loaded from: classes8.dex */
public class cs {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static a f178a;

    /* renamed from: a  reason: collision with other field name */
    public static cs f179a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f180a;
    public static Map<String, co> b;
    public static String c;
    public static String d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f181a;

    /* renamed from: a  reason: collision with other field name */
    public cr f182a;

    /* renamed from: a  reason: collision with other field name */
    public b f183a;

    /* renamed from: a  reason: collision with other field name */
    public String f184a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, cp> f185a;

    /* renamed from: b  reason: collision with other field name */
    public final long f186b;

    /* renamed from: b  reason: collision with other field name */
    public String f187b;

    /* renamed from: c  reason: collision with other field name */
    public long f188c;

    /* loaded from: classes8.dex */
    public interface a {
        cs a(Context context, cr crVar, b bVar, String str);
    }

    /* loaded from: classes8.dex */
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
        b = new HashMap();
        f180a = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f185a = new HashMap();
        this.f184a = "0";
        this.f181a = 0L;
        this.f186b = 15L;
        this.f188c = 0L;
        this.f187b = "isp_prov_city_country_ip";
        this.f183a = bVar;
        this.f182a = crVar == null ? new ct(this) : crVar;
        this.f184a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? f() : str3;
    }

    public static synchronized cs a() {
        InterceptResult invokeV;
        cs csVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (cs.class) {
                if (f179a == null) {
                    throw new IllegalStateException("the host manager is not initialized yet.");
                }
                csVar = f179a;
            }
            return csVar;
        }
        return (cs) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m266a() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Context context = a;
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
            WifiManager wifiManager = (WifiManager) a.getSystemService("wifi");
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                int length = str.length();
                byte[] bytes = str.getBytes("UTF-8");
                for (int i = 0; i < bytes.length; i++) {
                    byte b2 = bytes[i];
                    int i2 = b2 & 240;
                    if (i2 != 240) {
                        bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, arrayList)) == null) {
            m275d();
            synchronized (this.f185a) {
                m271a();
                for (String str : this.f185a.keySet()) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
            boolean isEmpty = b.isEmpty();
            synchronized (b) {
                for (Object obj : b.values().toArray()) {
                    co coVar = (co) obj;
                    if (!coVar.b()) {
                        b.remove(coVar.f175b);
                        isEmpty = true;
                    }
                }
            }
            if (!arrayList.contains(b())) {
                arrayList.add(b());
            }
            ArrayList<co> arrayList2 = new ArrayList<>(arrayList.size());
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(null);
            }
            try {
                String str2 = bg.e(a) ? "wifi" : "wap";
                String a2 = a(arrayList, str2, this.f184a, isEmpty);
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
                        int i2 = 0;
                        while (i2 < arrayList.size()) {
                            String str3 = arrayList.get(i2);
                            JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                            if (optJSONArray == null) {
                                com.xiaomi.channel.commonutils.logger.b.m108a("no bucket found for " + str3);
                                jSONObject = jSONObject5;
                            } else {
                                co coVar2 = new co(str3);
                                int i3 = 0;
                                while (i3 < optJSONArray.length()) {
                                    String string6 = optJSONArray.getString(i3);
                                    if (TextUtils.isEmpty(string6)) {
                                        jSONObject2 = jSONObject5;
                                    } else {
                                        jSONObject2 = jSONObject5;
                                        coVar2.a(new cx(string6, optJSONArray.length() - i3));
                                    }
                                    i3++;
                                    jSONObject5 = jSONObject2;
                                }
                                jSONObject = jSONObject5;
                                arrayList2.set(i2, coVar2);
                                coVar2.g = string5;
                                coVar2.c = string;
                                coVar2.e = string3;
                                coVar2.f = string4;
                                coVar2.d = string2;
                                if (jSONObject4.has("stat-percent")) {
                                    coVar2.a(jSONObject4.getDouble("stat-percent"));
                                }
                                if (jSONObject4.has("stat-domain")) {
                                    coVar2.b(jSONObject4.getString("stat-domain"));
                                }
                                if (jSONObject4.has(ResultTB.TTL)) {
                                    coVar2.a(jSONObject4.getInt(ResultTB.TTL) * 1000);
                                }
                                m270a(coVar2.a());
                            }
                            i2++;
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
                                    com.xiaomi.channel.commonutils.logger.b.m108a("no bucket found for " + next);
                                } else {
                                    co coVar3 = new co(next);
                                    coVar3.a(j);
                                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                        String string7 = optJSONArray2.getString(i4);
                                        if (!TextUtils.isEmpty(string7)) {
                                            coVar3.a(new cx(string7, optJSONArray2.length() - i4));
                                        }
                                    }
                                    synchronized (b) {
                                        if (this.f182a.a(next)) {
                                            b.put(next, coVar3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m108a("failed to get bucket " + e.getMessage());
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                co coVar4 = arrayList2.get(i5);
                if (coVar4 != null) {
                    a(arrayList.get(i5), coVar4);
                }
            }
            m274c();
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static synchronized void a(Context context, cr crVar, b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, crVar, bVar, str, str2, str3}) == null) {
            synchronized (cs.class) {
                Context applicationContext = context.getApplicationContext();
                a = applicationContext;
                if (applicationContext == null) {
                    a = context;
                }
                if (f179a == null) {
                    if (f178a == null) {
                        f179a = new cs(context, crVar, bVar, str, str2, str3);
                    } else {
                        f179a = f178a.a(context, crVar, bVar, str);
                    }
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, aVar) == null) {
            synchronized (cs.class) {
                f178a = aVar;
                f179a = null;
            }
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            co coVar = b.get(str);
            synchronized (b) {
                if (coVar == null) {
                    co coVar2 = new co(str);
                    coVar2.a(604800000L);
                    coVar2.m259a(str2);
                    b.put(str, coVar2);
                } else {
                    coVar.m259a(str2);
                }
            }
        }
    }

    private String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            try {
                PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 16384);
                return packageInfo != null ? packageInfo.versionName : "0";
            } catch (Exception unused) {
                return "0";
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public co m267a(String str) {
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
            if (this.f182a.a(str)) {
                co c2 = c(str);
                return (c2 == null || !c2.b()) ? (z && bg.b(a) && (d2 = d(str)) != null) ? d2 : new cu(this, str, c2) : c2;
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
                arrayList3.add(new bd("conpt", a(bg.m210a(a))));
            }
            if (z) {
                arrayList3.add(new bd(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "1"));
            }
            arrayList3.add(new bd("uuid", str2));
            arrayList3.add(new bd("list", bm.a(arrayList, ",")));
            arrayList3.add(new bd("countrycode", com.xiaomi.push.service.a.a(a).b()));
            co c2 = c(b());
            String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", b());
            if (c2 == null) {
                arrayList2.add(format);
                synchronized (b) {
                    co coVar = b.get("resolver.msg.xiaomi.net");
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
            IOException e = null;
            while (it2.hasNext()) {
                Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
                for (bf bfVar : arrayList3) {
                    buildUpon.appendQueryParameter(bfVar.a(), bfVar.b());
                }
                try {
                    return this.f183a == null ? bg.a(a, new URL(buildUpon.toString())) : this.f183a.a(buildUpon.toString());
                } catch (IOException e2) {
                    e = e2;
                }
            }
            if (e == null) {
                return null;
            }
            com.xiaomi.channel.commonutils.logger.b.m108a("network exception: " + e.getMessage());
            throw e;
        }
        return (String) invokeCommon.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m268a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.f185a) {
                jSONObject = new JSONObject();
                jSONObject.put("ver", 2);
                JSONArray jSONArray = new JSONArray();
                for (cp cpVar : this.f185a.values()) {
                    jSONArray.put(cpVar.m263a());
                }
                jSONObject.put("data", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                for (co coVar : b.values()) {
                    jSONArray2.put(coVar.m258a());
                }
                jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m269a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f185a) {
                this.f185a.clear();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m270a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f187b = str;
        }
    }

    public void a(String str, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, coVar) == null) {
            if (TextUtils.isEmpty(str) || coVar == null) {
                throw new IllegalArgumentException("the argument is invalid " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + coVar);
            } else if (this.f182a.a(str)) {
                synchronized (this.f185a) {
                    m271a();
                    if (this.f185a.containsKey(str)) {
                        this.f185a.get(str).a(coVar);
                    } else {
                        cp cpVar = new cp(str);
                        cpVar.a(coVar);
                        this.f185a.put(str, cpVar);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m271a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.f185a) {
                if (f180a) {
                    return true;
                }
                f180a = true;
                this.f185a.clear();
                String d2 = d();
                if (TextUtils.isEmpty(d2)) {
                    return false;
                }
                m273b(d2);
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
            String a2 = com.xiaomi.push.service.a.a(a).a();
            return (TextUtils.isEmpty(a2) || PushChannelRegion.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m272b() {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f185a) {
                m271a();
                arrayList = new ArrayList<>(this.f185a.keySet());
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    cp cpVar = this.f185a.get(arrayList.get(size));
                    if (cpVar != null && cpVar.a() != null) {
                        arrayList.remove(size);
                    }
                }
            }
            ArrayList<co> a2 = a(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                if (a2.get(i) != null) {
                    a(arrayList.get(i), a2.get(i));
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m273b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            synchronized (this.f185a) {
                this.f185a.clear();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("ver") != 2) {
                    throw new JSONException("Bad version");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    cp a2 = new cp().a(optJSONArray.getJSONObject(i));
                    this.f185a.put(a2.m261a(), a2);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    co a3 = new co("").a(optJSONArray2.getJSONObject(i2));
                    b.put(a3.f175b, a3);
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
            synchronized (this.f185a) {
                m271a();
                cpVar = this.f185a.get(str);
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
            synchronized (this.f185a) {
                for (Map.Entry<String, cp> entry : this.f185a.entrySet()) {
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
    public void m274c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.f185a) {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(a.openFileOutput(e(), 0)));
                    String jSONObject = m268a().toString();
                    if (!TextUtils.isEmpty(jSONObject)) {
                        bufferedWriter.write(jSONObject);
                    }
                    bufferedWriter.close();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m108a("persist bucket failure: " + e.getMessage());
                }
            }
        }
    }

    public co d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (System.currentTimeMillis() - this.f188c > this.f181a * 60 * 1000) {
                this.f188c = System.currentTimeMillis();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                co coVar = a(arrayList).get(0);
                if (coVar != null) {
                    this.f181a = 0L;
                    return coVar;
                }
                long j = this.f181a;
                if (j < 15) {
                    this.f181a = j + 1;
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
            file = new File(a.getFilesDir(), e());
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
                com.xiaomi.channel.commonutils.logger.b.m108a("load host exception " + th.getMessage());
                return null;
            } finally {
                y.a(bufferedReader);
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m275d() {
        String next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f185a) {
                for (cp cpVar : this.f185a.values()) {
                    cpVar.a(true);
                }
                while (true) {
                    for (boolean z = false; !z; z = true) {
                        Iterator<String> it = this.f185a.keySet().iterator();
                        while (it.hasNext()) {
                            next = it.next();
                            if (this.f185a.get(next).m262a().isEmpty()) {
                                break;
                            }
                        }
                    }
                    this.f185a.remove(next);
                }
            }
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) a.getSystemService("activity")).getRunningAppProcesses();
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
