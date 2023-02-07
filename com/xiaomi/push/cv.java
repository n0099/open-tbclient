package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
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
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class cv {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static a f210a;

    /* renamed from: a  reason: collision with other field name */
    public static cv f211a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f212a;
    public static final Map<String, cr> b;
    public static String c;
    public static String d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public long f213a;

    /* renamed from: a  reason: collision with other field name */
    public cu f214a;

    /* renamed from: a  reason: collision with other field name */
    public b f215a;

    /* renamed from: a  reason: collision with other field name */
    public String f216a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, cs> f217a;

    /* renamed from: b  reason: collision with other field name */
    public final long f218b;

    /* renamed from: b  reason: collision with other field name */
    public String f219b;

    /* renamed from: c  reason: collision with other field name */
    public long f220c;

    /* loaded from: classes8.dex */
    public interface a {
        cv a(Context context, cu cuVar, b bVar, String str);
    }

    /* loaded from: classes8.dex */
    public interface b {
        String a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56377299, "Lcom/xiaomi/push/cv;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56377299, "Lcom/xiaomi/push/cv;");
                return;
            }
        }
        b = new HashMap();
        f212a = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cv(Context context, cu cuVar, b bVar, String str) {
        this(context, cuVar, bVar, str, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cuVar, bVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (cu) objArr2[1], (b) objArr2[2], (String) objArr2[3], (String) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public cv(Context context, cu cuVar, b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cuVar, bVar, str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f217a = new HashMap();
        this.f216a = "0";
        this.f213a = 0L;
        this.f218b = 15L;
        this.f220c = 0L;
        this.f219b = "isp_prov_city_country_ip";
        this.f215a = bVar;
        this.f214a = cuVar == null ? new cw(this) : cuVar;
        this.f216a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? f() : str3;
    }

    public static synchronized cv a() {
        InterceptResult invokeV;
        cv cvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (cv.class) {
                if (f211a == null) {
                    throw new IllegalStateException("the host manager is not initialized yet.");
                }
                cvVar = f211a;
            }
            return cvVar;
        }
        return (cv) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m268a() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Context context = a;
            if (context == null) {
                return "unknown";
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                    return "unknown";
                }
                if (activeNetworkInfo.getType() == 1) {
                    return "WIFI-UNKNOWN";
                }
                return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
            } catch (Throwable unused) {
                return "unknown";
            }
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

    private ArrayList<cr> a(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, arrayList)) == null) {
            m277d();
            synchronized (this.f217a) {
                m273a();
                for (String str : this.f217a.keySet()) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
            synchronized (b) {
                for (Object obj : b.values().toArray()) {
                    cr crVar = (cr) obj;
                    if (!crVar.b()) {
                        b.remove(crVar.f207b);
                    }
                }
            }
            if (!arrayList.contains(b())) {
                arrayList.add(b());
            }
            ArrayList<cr> arrayList2 = new ArrayList<>(arrayList.size());
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(null);
            }
            try {
                String str2 = bj.e(a) ? "wifi" : "wap";
                String a2 = a(arrayList, str2, this.f216a, true);
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject3 = new JSONObject(a2);
                    com.xiaomi.channel.commonutils.logger.b.b(a2);
                    if ("OK".equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
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
                                com.xiaomi.channel.commonutils.logger.b.m105a("no bucket found for " + str3);
                                jSONObject = jSONObject5;
                            } else {
                                cr crVar2 = new cr(str3);
                                int i3 = 0;
                                while (i3 < optJSONArray.length()) {
                                    String string6 = optJSONArray.getString(i3);
                                    if (TextUtils.isEmpty(string6)) {
                                        jSONObject2 = jSONObject5;
                                    } else {
                                        jSONObject2 = jSONObject5;
                                        crVar2.a(new da(string6, optJSONArray.length() - i3));
                                    }
                                    i3++;
                                    jSONObject5 = jSONObject2;
                                }
                                jSONObject = jSONObject5;
                                arrayList2.set(i2, crVar2);
                                crVar2.g = string5;
                                crVar2.c = string;
                                crVar2.e = string3;
                                crVar2.f = string4;
                                crVar2.d = string2;
                                if (jSONObject4.has("stat-percent")) {
                                    crVar2.a(jSONObject4.getDouble("stat-percent"));
                                }
                                if (jSONObject4.has("stat-domain")) {
                                    crVar2.b(jSONObject4.getString("stat-domain"));
                                }
                                if (jSONObject4.has("ttl")) {
                                    crVar2.a(jSONObject4.getInt("ttl") * 1000);
                                }
                                m272a(crVar2.a());
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
                                    com.xiaomi.channel.commonutils.logger.b.m105a("no bucket found for " + next);
                                } else {
                                    cr crVar3 = new cr(next);
                                    crVar3.a(j);
                                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                        String string7 = optJSONArray2.getString(i4);
                                        if (!TextUtils.isEmpty(string7)) {
                                            crVar3.a(new da(string7, optJSONArray2.length() - i4));
                                        }
                                    }
                                    synchronized (b) {
                                        if (this.f214a.a(next)) {
                                            b.put(next, crVar3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m105a("failed to get bucket " + e.getMessage());
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                cr crVar4 = arrayList2.get(i5);
                if (crVar4 != null) {
                    a(arrayList.get(i5), crVar4);
                }
            }
            m276c();
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static synchronized void a(Context context, cu cuVar, b bVar, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, cuVar, bVar, str, str2, str3}) == null) {
            synchronized (cv.class) {
                Context applicationContext = context.getApplicationContext();
                a = applicationContext;
                if (applicationContext == null) {
                    a = context;
                }
                if (f211a == null) {
                    if (f210a == null) {
                        f211a = new cv(context, cuVar, bVar, str, str2, str3);
                    } else {
                        f211a = f210a.a(context, cuVar, bVar, str);
                    }
                }
            }
        }
    }

    public static synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, aVar) == null) {
            synchronized (cv.class) {
                f210a = aVar;
                f211a = null;
            }
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            cr crVar = b.get(str);
            synchronized (b) {
                if (crVar == null) {
                    cr crVar2 = new cr(str);
                    crVar2.a(604800000L);
                    crVar2.m261a(str2);
                    b.put(str, crVar2);
                } else {
                    crVar.m261a(str2);
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
    public cr m269a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("the url is empty");
            }
            return a(new URL(str).getHost(), true);
        }
        return (cr) invokeL.objValue;
    }

    public cr a(String str, boolean z) {
        InterceptResult invokeLZ;
        cr e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("the host is empty");
            }
            if (this.f214a.a(str)) {
                cr c2 = c(str);
                return (c2 == null || !c2.b()) ? (z && bj.b(a) && (e = e(str)) != null) ? e : new cx(this, str, c2) : c2;
            }
            return null;
        }
        return (cr) invokeLZ.objValue;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{arrayList, str, str2, Boolean.valueOf(z)})) == null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<bi> arrayList3 = new ArrayList();
            arrayList3.add(new bg("type", str));
            if (str.equals("wap")) {
                arrayList3.add(new bg("conpt", a(bj.m211a(a))));
            }
            if (z) {
                arrayList3.add(new bg(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, "1"));
            }
            arrayList3.add(new bg("uuid", str2));
            arrayList3.add(new bg("list", bp.a(arrayList, ",")));
            arrayList3.add(new bg("countrycode", com.xiaomi.push.service.a.a(a).b()));
            String b2 = b();
            cr c2 = c(b2);
            String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", b2);
            if (c2 == null) {
                arrayList2.add(format);
                synchronized (b) {
                    cr crVar = b.get(b2);
                    if (crVar != null) {
                        Iterator<String> it = crVar.a(true).iterator();
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
                for (bi biVar : arrayList3) {
                    buildUpon.appendQueryParameter(biVar.a(), biVar.b());
                }
                try {
                    return this.f215a == null ? bj.a(a, new URL(buildUpon.toString())) : this.f215a.a(buildUpon.toString());
                } catch (IOException e2) {
                    e = e2;
                }
            }
            if (e == null) {
                return null;
            }
            com.xiaomi.channel.commonutils.logger.b.m105a("network exception: " + e.getMessage());
            throw e;
        }
        return (String) invokeCommon.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m270a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.f217a) {
                jSONObject = new JSONObject();
                jSONObject.put("ver", 2);
                JSONArray jSONArray = new JSONArray();
                for (cs csVar : this.f217a.values()) {
                    jSONArray.put(csVar.m265a());
                }
                jSONObject.put("data", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                for (cr crVar : b.values()) {
                    jSONArray2.put(crVar.m260a());
                }
                jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED, jSONArray2);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m271a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.f217a) {
                this.f217a.clear();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m272a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f219b = str;
        }
    }

    public void a(String str, cr crVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, crVar) == null) {
            if (TextUtils.isEmpty(str) || crVar == null) {
                throw new IllegalArgumentException("the argument is invalid " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + crVar);
            } else if (this.f214a.a(str)) {
                synchronized (this.f217a) {
                    m273a();
                    if (this.f217a.containsKey(str)) {
                        this.f217a.get(str).a(crVar);
                    } else {
                        cs csVar = new cs(str);
                        csVar.a(crVar);
                        this.f217a.put(str, csVar);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m273a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.f217a) {
                if (f212a) {
                    return true;
                }
                f212a = true;
                this.f217a.clear();
                String d2 = d();
                if (TextUtils.isEmpty(d2)) {
                    return false;
                }
                m275b(d2);
                com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public cr b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? a(str, true) : (cr) invokeL.objValue;
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
    public void m274b() {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f217a) {
                m273a();
                arrayList = new ArrayList<>(this.f217a.keySet());
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    cs csVar = this.f217a.get(arrayList.get(size));
                    if (csVar != null && csVar.a() != null) {
                        arrayList.remove(size);
                    }
                }
            }
            ArrayList<cr> a2 = a(arrayList);
            for (int i = 0; i < arrayList.size(); i++) {
                if (a2.get(i) != null) {
                    a(arrayList.get(i), a2.get(i));
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m275b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            synchronized (this.f217a) {
                this.f217a.clear();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("ver") != 2) {
                    throw new JSONException("Bad version");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        cs a2 = new cs().a(optJSONArray.getJSONObject(i));
                        this.f217a.put(a2.m263a(), a2);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray(GestureAR.SDK_TO_LUA_GESTURE_RESULT_RESERVED);
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                        String optString = jSONObject2.optString("host");
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                cr a3 = new cr(optString).a(jSONObject2);
                                b.put(a3.f207b, a3);
                                com.xiaomi.channel.commonutils.logger.b.m105a("load local reserved host for " + a3.f207b);
                            } catch (JSONException unused) {
                                com.xiaomi.channel.commonutils.logger.b.m105a("parse reserved host fail.");
                            }
                        }
                    }
                }
            }
        }
    }

    public cr c(String str) {
        InterceptResult invokeL;
        cs csVar;
        cr a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            synchronized (this.f217a) {
                m273a();
                csVar = this.f217a.get(str);
            }
            if (csVar == null || (a2 = csVar.a()) == null) {
                return null;
            }
            return a2;
        }
        return (cr) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            StringBuilder sb = new StringBuilder();
            synchronized (this.f217a) {
                for (Map.Entry<String, cs> entry : this.f217a.entrySet()) {
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
    public void m276c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this.f217a) {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(a.openFileOutput(e(), 0)));
                    String jSONObject = m270a().toString();
                    if (!TextUtils.isEmpty(jSONObject)) {
                        bufferedWriter.write(jSONObject);
                    }
                    bufferedWriter.close();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m105a("persist bucket failure: " + e.getMessage());
                }
            }
        }
    }

    public cr d(String str) {
        InterceptResult invokeL;
        cr crVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (b) {
                crVar = b.get(str);
            }
            return crVar;
        }
        return (cr) invokeL.objValue;
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
            ab.a((Closeable) null);
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
                com.xiaomi.channel.commonutils.logger.b.m105a("load host exception " + th.getMessage());
                return null;
            } finally {
                ab.a(bufferedReader);
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m277d() {
        String next;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f217a) {
                for (cs csVar : this.f217a.values()) {
                    csVar.a(true);
                }
                while (true) {
                    for (boolean z = false; !z; z = true) {
                        Iterator<String> it = this.f217a.keySet().iterator();
                        while (it.hasNext()) {
                            next = it.next();
                            if (this.f217a.get(next).m264a().isEmpty()) {
                                break;
                            }
                        }
                    }
                    this.f217a.remove(next);
                }
            }
        }
    }

    public cr e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (System.currentTimeMillis() - this.f220c > this.f213a * 60 * 1000) {
                this.f220c = System.currentTimeMillis();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                cr crVar = a(arrayList).get(0);
                if (crVar != null) {
                    this.f213a = 0L;
                    return crVar;
                }
                long j = this.f213a;
                if (j < 15) {
                    this.f213a = j + 1;
                    return null;
                }
                return null;
            }
            return null;
        }
        return (cr) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if ("com.xiaomi.xmsf".equals(c)) {
                return c;
            }
            return c + ":pushservice";
        }
        return (String) invokeV.objValue;
    }
}
