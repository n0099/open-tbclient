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
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.yy.gslbsdk.db.ResultTB;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class co {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public double a;

    /* renamed from: a  reason: collision with other field name */
    public long f196a;

    /* renamed from: a  reason: collision with other field name */
    public String f197a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<cx> f198a;

    /* renamed from: b  reason: collision with root package name */
    public long f61167b;

    /* renamed from: b  reason: collision with other field name */
    public String f199b;

    /* renamed from: c  reason: collision with root package name */
    public String f61168c;

    /* renamed from: d  reason: collision with root package name */
    public String f61169d;

    /* renamed from: e  reason: collision with root package name */
    public String f61170e;

    /* renamed from: f  reason: collision with root package name */
    public String f61171f;

    /* renamed from: g  reason: collision with root package name */
    public String f61172g;

    /* renamed from: h  reason: collision with root package name */
    public String f61173h;

    /* renamed from: i  reason: collision with root package name */
    public String f61174i;

    /* renamed from: j  reason: collision with root package name */
    public String f61175j;

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
        this.f197a = "";
        this.f198a = new ArrayList<>();
        this.a = 0.1d;
        this.f61175j = "s.mi1.cc";
        this.f61167b = 86400000L;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f196a = System.currentTimeMillis();
        this.f198a.add(new cx(str, -1));
        this.f197a = cs.m291a();
        this.f199b = str;
    }

    private synchronized void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            synchronized (this) {
                Iterator<cx> it = this.f198a.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().f215a, str)) {
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
                this.f197a = jSONObject.optString("net");
                this.f61167b = jSONObject.getLong(ResultTB.TTL);
                this.a = jSONObject.getDouble("pct");
                this.f196a = jSONObject.getLong(TimeDisplaySetting.TIME_DISPLAY_SETTING);
                this.f61169d = jSONObject.optString("city");
                this.f61168c = jSONObject.optString("prv");
                this.f61172g = jSONObject.optString("cty");
                this.f61170e = jSONObject.optString("isp");
                this.f61171f = jSONObject.optString("ip");
                this.f199b = jSONObject.optString("host");
                this.f61173h = jSONObject.optString("xf");
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
                if (TextUtils.isEmpty(this.f61174i)) {
                    if (TextUtils.isEmpty(this.f61170e)) {
                        return "hardcode_isp";
                    }
                    String a = bm.a(new String[]{this.f61170e, this.f61168c, this.f61169d, this.f61172g, this.f61171f}, "_");
                    this.f61174i = a;
                    return a;
                }
                return this.f61174i;
            }
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m282a() {
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
            if (TextUtils.equals(url.getHost(), this.f199b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    cq a = cq.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a.m290a(), a.a(), url.getFile()).toString());
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
                int size = this.f198a.size();
                cx[] cxVarArr = new cx[size];
                this.f198a.toArray(cxVarArr);
                Arrays.sort(cxVarArr);
                arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < size; i2++) {
                    cx cxVar = cxVarArr[i2];
                    if (z) {
                        substring = cxVar.f215a;
                    } else {
                        int indexOf = cxVar.f215a.indexOf(":");
                        substring = indexOf != -1 ? cxVar.f215a.substring(0, indexOf) : cxVar.f215a;
                    }
                    arrayList.add(substring);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeZ.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m283a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                jSONObject = new JSONObject();
                jSONObject.put("net", this.f197a);
                jSONObject.put(ResultTB.TTL, this.f61167b);
                jSONObject.put("pct", this.a);
                jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, this.f196a);
                jSONObject.put("city", this.f61169d);
                jSONObject.put("prv", this.f61168c);
                jSONObject.put("cty", this.f61172g);
                jSONObject.put("isp", this.f61170e);
                jSONObject.put("ip", this.f61171f);
                jSONObject.put("host", this.f199b);
                jSONObject.put("xf", this.f61173h);
                JSONArray jSONArray = new JSONArray();
                Iterator<cx> it = this.f198a.iterator();
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
            this.a = d2;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            if (j2 > 0) {
                this.f61167b = j2;
                return;
            }
            throw new IllegalArgumentException("the duration is invalid " + j2);
        }
    }

    public synchronized void a(cx cxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cxVar) == null) {
            synchronized (this) {
                c(cxVar.f215a);
                this.f198a.add(cxVar);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m284a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            synchronized (this) {
                a(new cx(str));
            }
        }
    }

    public void a(String str, int i2, long j2, long j3, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), exc}) == null) {
            a(str, new cn(i2, j2, j3, exc));
        }
    }

    public void a(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            try {
                b(new URL(str).getHost(), j2, j3);
            } catch (MalformedURLException unused) {
            }
        }
    }

    public void a(String str, long j2, long j3, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), exc}) == null) {
            try {
                b(new URL(str).getHost(), j2, j3, exc);
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
                Iterator<cx> it = this.f198a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    cx next = it.next();
                    if (TextUtils.equals(str, next.f215a)) {
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
                int size = this.f198a.size() - 1;
                while (true) {
                    i2 = 0;
                    if (size < 0) {
                        break;
                    }
                    int length = strArr.length;
                    while (true) {
                        if (i2 < length) {
                            if (TextUtils.equals(this.f198a.get(size).f215a, strArr[i2])) {
                                this.f198a.remove(size);
                                break;
                            }
                            i2++;
                        }
                    }
                    size--;
                }
                Iterator<cx> it = this.f198a.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    cx next = it.next();
                    if (next.a > i3) {
                        i3 = next.a;
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
    public boolean m285a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? TextUtils.equals(this.f197a, cs.m291a()) : invokeV.booleanValue;
    }

    public boolean a(co coVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, coVar)) == null) ? TextUtils.equals(this.f197a, coVar.f197a) : invokeL.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f61175j = str;
        }
    }

    public void b(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            a(str, 0, j2, j3, null);
        }
    }

    public void b(String str, long j2, long j3, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), exc}) == null) {
            a(str, -1, j2, j3, exc);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? System.currentTimeMillis() - this.f196a < this.f61167b : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            long j2 = this.f61167b;
            if (ImageLoader.f32709d >= j2) {
                j2 = 864000000;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.f196a;
            return currentTimeMillis - j3 > j2 || (currentTimeMillis - j3 > this.f61167b && this.f197a.startsWith("WIFI-"));
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f197a);
            sb.append(StringUtils.LF);
            sb.append(a());
            Iterator<cx> it = this.f198a.iterator();
            while (it.hasNext()) {
                sb.append(StringUtils.LF);
                sb.append(it.next().toString());
            }
            sb.append(StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
