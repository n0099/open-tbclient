package com.xiaomi.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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

    /* renamed from: a  reason: collision with root package name */
    public double f42924a;

    /* renamed from: a  reason: collision with other field name */
    public long f191a;

    /* renamed from: a  reason: collision with other field name */
    public String f192a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<cx> f193a;

    /* renamed from: b  reason: collision with root package name */
    public long f42925b;

    /* renamed from: b  reason: collision with other field name */
    public String f194b;

    /* renamed from: c  reason: collision with root package name */
    public String f42926c;

    /* renamed from: d  reason: collision with root package name */
    public String f42927d;

    /* renamed from: e  reason: collision with root package name */
    public String f42928e;

    /* renamed from: f  reason: collision with root package name */
    public String f42929f;

    /* renamed from: g  reason: collision with root package name */
    public String f42930g;

    /* renamed from: h  reason: collision with root package name */
    public String f42931h;

    /* renamed from: i  reason: collision with root package name */
    public String f42932i;
    public String j;

    public co(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f192a = "";
        this.f193a = new ArrayList<>();
        this.f42924a = 0.1d;
        this.j = "s.mi1.cc";
        this.f42925b = 86400000L;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f191a = System.currentTimeMillis();
        this.f193a.add(new cx(str, -1));
        this.f192a = cs.m228a();
        this.f194b = str;
    }

    private synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            synchronized (this) {
                Iterator<cx> it = this.f193a.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().f210a, str)) {
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
                this.f192a = jSONObject.optString("net");
                this.f42925b = jSONObject.getLong(ResultTB.TTL);
                this.f42924a = jSONObject.getDouble("pct");
                this.f191a = jSONObject.getLong("ts");
                this.f42927d = jSONObject.optString("city");
                this.f42926c = jSONObject.optString("prv");
                this.f42930g = jSONObject.optString("cty");
                this.f42928e = jSONObject.optString("isp");
                this.f42929f = jSONObject.optString("ip");
                this.f194b = jSONObject.optString("host");
                this.f42931h = jSONObject.optString("xf");
                JSONArray jSONArray = jSONObject.getJSONArray("fbs");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    a(new cx().a(jSONArray.getJSONObject(i2)));
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
                if (TextUtils.isEmpty(this.f42932i)) {
                    if (TextUtils.isEmpty(this.f42928e)) {
                        return "hardcode_isp";
                    }
                    String a2 = bm.a(new String[]{this.f42928e, this.f42926c, this.f42927d, this.f42930g, this.f42929f}, "_");
                    this.f42932i = a2;
                    return a2;
                }
                return this.f42932i;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m219a() {
        InterceptResult invokeV;
        ArrayList<String> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                a2 = a(false);
            }
            return a2;
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
            if (TextUtils.equals(url.getHost(), this.f194b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    cq a2 = cq.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a2.m227a(), a2.a(), url.getFile()).toString());
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
                int size = this.f193a.size();
                cx[] cxVarArr = new cx[size];
                this.f193a.toArray(cxVarArr);
                Arrays.sort(cxVarArr);
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < size; i2++) {
                    cx cxVar = cxVarArr[i2];
                    if (z) {
                        substring = cxVar.f210a;
                    } else {
                        int indexOf = cxVar.f210a.indexOf(":");
                        substring = indexOf != -1 ? cxVar.f210a.substring(0, indexOf) : cxVar.f210a;
                    }
                    arrayList.add(substring);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m220a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put("net", this.f192a);
                jSONObject.put(ResultTB.TTL, this.f42925b);
                jSONObject.put("pct", this.f42924a);
                jSONObject.put("ts", this.f191a);
                jSONObject.put("city", this.f42927d);
                jSONObject.put("prv", this.f42926c);
                jSONObject.put("cty", this.f42930g);
                jSONObject.put("isp", this.f42928e);
                jSONObject.put("ip", this.f42929f);
                jSONObject.put("host", this.f194b);
                jSONObject.put("xf", this.f42931h);
                JSONArray jSONArray = new JSONArray();
                Iterator<cx> it = this.f193a.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().a());
                }
                jSONObject.put("fbs", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f42924a = d2;
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            if (j > 0) {
                this.f42925b = j;
                return;
            }
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
    }

    public synchronized void a(cx cxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cxVar) == null) {
            synchronized (this) {
                c(cxVar.f210a);
                this.f193a.add(cxVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m221a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            synchronized (this) {
                a(new cx(str));
            }
        }
    }

    public void a(String str, int i2, long j, long j2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), exc}) == null) {
            a(str, new cn(i2, j, j2, exc));
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
                Iterator<cx> it = this.f193a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cx next = it.next();
                    if (TextUtils.equals(str, next.f210a)) {
                        break;
                    }
                }
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, strArr) == null) {
            synchronized (this) {
                int size = this.f193a.size() - 1;
                while (true) {
                    i2 = 0;
                    if (size < 0) {
                        break;
                    }
                    int length = strArr.length;
                    while (true) {
                        if (i2 < length) {
                            if (TextUtils.equals(this.f193a.get(size).f210a, strArr[i2])) {
                                this.f193a.remove(size);
                                break;
                            }
                            i2++;
                        }
                    }
                    size--;
                }
                Iterator<cx> it = this.f193a.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    cx next = it.next();
                    if (next.f42943a > i3) {
                        i3 = next.f42943a;
                    }
                }
                while (i2 < strArr.length) {
                    a(new cx(strArr[i2], (strArr.length + i3) - i2));
                    i2++;
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m222a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TextUtils.equals(this.f192a, cs.m228a()) : invokeV.booleanValue;
    }

    public boolean a(co coVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, coVar)) == null) ? TextUtils.equals(this.f192a, coVar.f192a) : invokeL.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? System.currentTimeMillis() - this.f191a < this.f42925b : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            long j = this.f42925b;
            if (ImageLoader.f3775d >= j) {
                j = 864000000;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f191a;
            return currentTimeMillis - j2 > j || (currentTimeMillis - j2 > this.f42925b && this.f192a.startsWith("WIFI-"));
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f192a);
            sb.append("\n");
            sb.append(a());
            Iterator<cx> it = this.f193a.iterator();
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
