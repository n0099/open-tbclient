package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.yy.gslbsdk.db.ResultTB;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class cr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;

    /* renamed from: a  reason: collision with other field name */
    public long f180a;

    /* renamed from: a  reason: collision with other field name */
    public String f181a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<da> f182a;
    public long b;

    /* renamed from: b  reason: collision with other field name */
    public String f183b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public cr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f181a = "";
        this.f182a = new ArrayList<>();
        this.a = 0.1d;
        this.j = "s.mi1.cc";
        this.b = 86400000L;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f180a = System.currentTimeMillis();
        this.f182a.add(new da(str, -1));
        this.f181a = cv.m251a();
        this.f183b = str;
    }

    private synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            synchronized (this) {
                Iterator<da> it = this.f182a.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().f199a, str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public synchronized cr a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            synchronized (this) {
                this.f181a = jSONObject.optString("net");
                this.b = jSONObject.getLong(ResultTB.TTL);
                this.a = jSONObject.getDouble("pct");
                this.f180a = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
                this.d = jSONObject.optString("city");
                this.c = jSONObject.optString("prv");
                this.g = jSONObject.optString("cty");
                this.e = jSONObject.optString("isp");
                this.f = jSONObject.optString("ip");
                this.f183b = jSONObject.optString("host");
                this.h = jSONObject.optString("xf");
                JSONArray jSONArray = jSONObject.getJSONArray("fbs");
                for (int i = 0; i < jSONArray.length(); i++) {
                    a(new da().a(jSONArray.getJSONObject(i)));
                }
            }
            return this;
        }
        return (cr) invokeL.objValue;
    }

    public synchronized String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.i)) {
                    if (TextUtils.isEmpty(this.e)) {
                        return "hardcode_isp";
                    }
                    String a = bp.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
                    this.i = a;
                    return a;
                }
                return this.i;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m242a() {
        InterceptResult invokeV;
        ArrayList<String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                a = a(false);
            }
            return a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ArrayList<String> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("the url is empty.");
            }
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f183b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    ct a = ct.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a.m250a(), a.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        return (ArrayList) invokeL.objValue;
    }

    public synchronized ArrayList<String> a(boolean z) {
        InterceptResult invokeZ;
        ArrayList<String> arrayList;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            synchronized (this) {
                int size = this.f182a.size();
                da[] daVarArr = new da[size];
                this.f182a.toArray(daVarArr);
                Arrays.sort(daVarArr);
                arrayList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    da daVar = daVarArr[i];
                    if (z) {
                        substring = daVar.f199a;
                    } else {
                        int indexOf = daVar.f199a.indexOf(":");
                        substring = indexOf != -1 ? daVar.f199a.substring(0, indexOf) : daVar.f199a;
                    }
                    arrayList.add(substring);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m243a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put("net", this.f181a);
                jSONObject.put(ResultTB.TTL, this.b);
                jSONObject.put("pct", this.a);
                jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f180a);
                jSONObject.put("city", this.d);
                jSONObject.put("prv", this.c);
                jSONObject.put("cty", this.g);
                jSONObject.put("isp", this.e);
                jSONObject.put("ip", this.f);
                jSONObject.put("host", this.f183b);
                jSONObject.put("xf", this.h);
                JSONArray jSONArray = new JSONArray();
                Iterator<da> it = this.f182a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().a());
                }
                jSONObject.put("fbs", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void a(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d)}) == null) {
            this.a = d;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            if (j > 0) {
                this.b = j;
                return;
            }
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
    }

    public synchronized void a(da daVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, daVar) == null) {
            synchronized (this) {
                c(daVar.f199a);
                this.f182a.add(daVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m244a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            synchronized (this) {
                a(new da(str));
            }
        }
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), exc}) == null) {
            a(str, new cq(i, j, j2, exc));
        }
    }

    public void a(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            try {
                b(new URL(str).getHost(), j, j2);
            } catch (MalformedURLException unused) {
            }
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), exc}) == null) {
            try {
                b(new URL(str).getHost(), j, j2, exc);
            } catch (MalformedURLException unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        r1.a(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(String str, cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, cqVar) == null) {
            synchronized (this) {
                Iterator<da> it = this.f182a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    da next = it.next();
                    if (TextUtils.equals(str, next.f199a)) {
                        break;
                    }
                }
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, strArr) == null) {
            synchronized (this) {
                int size = this.f182a.size() - 1;
                while (true) {
                    i = 0;
                    if (size < 0) {
                        break;
                    }
                    int length = strArr.length;
                    while (true) {
                        if (i < length) {
                            if (TextUtils.equals(this.f182a.get(size).f199a, strArr[i])) {
                                this.f182a.remove(size);
                                break;
                            }
                            i++;
                        }
                    }
                    size--;
                }
                Iterator<da> it = this.f182a.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    da next = it.next();
                    if (next.a > i2) {
                        i2 = next.a;
                    }
                }
                while (i < strArr.length) {
                    a(new da(strArr[i], (strArr.length + i2) - i));
                    i++;
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m245a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TextUtils.equals(this.f181a, cv.m251a()) : invokeV.booleanValue;
    }

    public boolean a(cr crVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, crVar)) == null) ? TextUtils.equals(this.f181a, crVar.f181a) : invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.j = str;
        }
    }

    public void b(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            a(str, 0, j, j2, null);
        }
    }

    public void b(String str, long j, long j2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), exc}) == null) {
            a(str, -1, j, j2, exc);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? System.currentTimeMillis() - this.f180a < this.b : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            long j = this.b;
            if (864000000 >= j) {
                j = 864000000;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f180a;
            return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.b && this.f181a.startsWith("WIFI-"));
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f181a);
            sb.append("\n");
            sb.append(a());
            Iterator<da> it = this.f182a.iterator();
            while (it.hasNext()) {
                sb.append("\n");
                sb.append(it.next().toString());
            }
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
