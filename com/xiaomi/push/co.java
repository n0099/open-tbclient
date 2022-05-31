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
public class co {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;

    /* renamed from: a  reason: collision with other field name */
    public long f172a;

    /* renamed from: a  reason: collision with other field name */
    public String f173a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<cx> f174a;
    public long b;

    /* renamed from: b  reason: collision with other field name */
    public String f175b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public co(String str) {
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
        this.f173a = "";
        this.f174a = new ArrayList<>();
        this.a = 0.1d;
        this.j = "s.mi1.cc";
        this.b = 86400000L;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f172a = System.currentTimeMillis();
        this.f174a.add(new cx(str, -1));
        this.f173a = cs.m266a();
        this.f175b = str;
    }

    private synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            synchronized (this) {
                Iterator<cx> it = this.f174a.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().f191a, str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    public synchronized co a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            synchronized (this) {
                this.f173a = jSONObject.optString("net");
                this.b = jSONObject.getLong(ResultTB.TTL);
                this.a = jSONObject.getDouble("pct");
                this.f172a = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
                this.d = jSONObject.optString("city");
                this.c = jSONObject.optString("prv");
                this.g = jSONObject.optString("cty");
                this.e = jSONObject.optString("isp");
                this.f = jSONObject.optString("ip");
                this.f175b = jSONObject.optString("host");
                this.h = jSONObject.optString("xf");
                JSONArray jSONArray = jSONObject.getJSONArray("fbs");
                for (int i = 0; i < jSONArray.length(); i++) {
                    a(new cx().a(jSONArray.getJSONObject(i)));
                }
            }
            return this;
        }
        return (co) invokeL.objValue;
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
                    String a = bm.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
                    this.i = a;
                    return a;
                }
                return this.i;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m257a() {
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
            if (TextUtils.equals(url.getHost(), this.f175b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    cq a = cq.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a.m265a(), a.a(), url.getFile()).toString());
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
                int size = this.f174a.size();
                cx[] cxVarArr = new cx[size];
                this.f174a.toArray(cxVarArr);
                Arrays.sort(cxVarArr);
                arrayList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    cx cxVar = cxVarArr[i];
                    if (z) {
                        substring = cxVar.f191a;
                    } else {
                        int indexOf = cxVar.f191a.indexOf(":");
                        substring = indexOf != -1 ? cxVar.f191a.substring(0, indexOf) : cxVar.f191a;
                    }
                    arrayList.add(substring);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m258a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put("net", this.f173a);
                jSONObject.put(ResultTB.TTL, this.b);
                jSONObject.put("pct", this.a);
                jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f172a);
                jSONObject.put("city", this.d);
                jSONObject.put("prv", this.c);
                jSONObject.put("cty", this.g);
                jSONObject.put("isp", this.e);
                jSONObject.put("ip", this.f);
                jSONObject.put("host", this.f175b);
                jSONObject.put("xf", this.h);
                JSONArray jSONArray = new JSONArray();
                Iterator<cx> it = this.f174a.iterator();
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

    public synchronized void a(cx cxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cxVar) == null) {
            synchronized (this) {
                c(cxVar.f191a);
                this.f174a.add(cxVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m259a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            synchronized (this) {
                a(new cx(str));
            }
        }
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), exc}) == null) {
            a(str, new cn(i, j, j2, exc));
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
    public synchronized void a(String str, cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, cnVar) == null) {
            synchronized (this) {
                Iterator<cx> it = this.f174a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cx next = it.next();
                    if (TextUtils.equals(str, next.f191a)) {
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
                int size = this.f174a.size() - 1;
                while (true) {
                    i = 0;
                    if (size < 0) {
                        break;
                    }
                    int length = strArr.length;
                    while (true) {
                        if (i < length) {
                            if (TextUtils.equals(this.f174a.get(size).f191a, strArr[i])) {
                                this.f174a.remove(size);
                                break;
                            }
                            i++;
                        }
                    }
                    size--;
                }
                Iterator<cx> it = this.f174a.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    cx next = it.next();
                    if (next.a > i2) {
                        i2 = next.a;
                    }
                }
                while (i < strArr.length) {
                    a(new cx(strArr[i], (strArr.length + i2) - i));
                    i++;
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m260a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TextUtils.equals(this.f173a, cs.m266a()) : invokeV.booleanValue;
    }

    public boolean a(co coVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, coVar)) == null) ? TextUtils.equals(this.f173a, coVar.f173a) : invokeL.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? System.currentTimeMillis() - this.f172a < this.b : invokeV.booleanValue;
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
            long j2 = this.f172a;
            return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.b && this.f173a.startsWith("WIFI-"));
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f173a);
            sb.append("\n");
            sb.append(a());
            Iterator<cx> it = this.f174a.iterator();
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
