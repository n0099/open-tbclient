package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class v implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 4;
    public static final int n = 0;
    public static final int o = 8;
    public static final int p = 1;
    public static final int q = 3;
    public static final int r = 4;
    public static long s;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public r b;
    public u c;
    public File d;
    public p3 e;
    public int f;
    public int g;
    public boolean h;
    public List<Integer> i;
    public Map<Integer, a> j;

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ v b;

        public a(v vVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vVar;
            this.a = i;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1651774359, "Lcom/kuaishou/weapon/p0/v;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1651774359, "Lcom/kuaishou/weapon/p0/v;");
        }
    }

    public v(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = new ArrayList();
        this.j = new HashMap();
        this.a = context;
        this.b = r.a(context);
        this.c = u.a(context);
        this.e = p3.a(context);
        this.d = new File(context.getFilesDir(), ".tmp");
        this.f = i;
        this.h = z;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v10 long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v4 long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0135: IGET  (r8v1 int A[REMOVE]) = (r20v0 com.kuaishou.weapon.p0.t) com.kuaishou.weapon.p0.t.a int)] */
    private void a(t tVar) {
        File file;
        Object obj;
        long j;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, tVar) == null) {
            try {
                if (TextUtils.isEmpty(tVar.j) || tVar.j.length() < 10) {
                    this.b.a(tVar.a, tVar.d, (PackageInfo) null);
                    return;
                }
                if (!this.d.exists()) {
                    this.d.mkdir();
                }
                File file2 = this.d;
                File file3 = new File(file2, tVar.a + "-" + tVar.d + ".tmp");
                File file4 = this.d;
                File file5 = new File(file4, tVar.a + "-" + tVar.d + ".zip");
                boolean a2 = m.a(this.a).a(tVar.i, file3);
                if (!a2) {
                    a2 = m.a(this.a).a(tVar.i, file3);
                }
                if (a2) {
                    if (file5.exists()) {
                        file5.delete();
                    }
                    int b = b.b(file3.getAbsolutePath(), file5.getAbsolutePath(), d.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                    if (b != 0) {
                        long length = file5.exists() ? file5.length() : -1L;
                        if (file5.exists()) {
                            file5.delete();
                        }
                        HashMap hashMap = new HashMap();
                        file = file5;
                        hashMap.put("e", l2.p);
                        StringBuilder sb = new StringBuilder();
                        obj2 = "e";
                        sb.append(tVar.a);
                        hashMap.put(PushConstants.URI_PACKAGE_NAME, sb.toString());
                        hashMap.put("pv", tVar.d);
                        hashMap.put("m", tVar.j);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(length);
                        hashMap.put("len", sb2.toString());
                        hashMap.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                        h1.a(this.a, "1002001", hashMap);
                        a2 = false;
                    } else {
                        file = file5;
                        obj2 = "e";
                    }
                    if (b == 0 && file3.exists()) {
                        file3.delete();
                    }
                    obj = obj2;
                } else {
                    file = file5;
                    HashMap hashMap2 = new HashMap();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(tVar.a);
                    hashMap2.put(PushConstants.URI_PACKAGE_NAME, sb3.toString());
                    hashMap2.put("pv", tVar.d);
                    hashMap2.put("m", tVar.j);
                    obj = "e";
                    hashMap2.put(obj, "download fail");
                    hashMap2.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                    h1.a(this.a, "1002001", hashMap2);
                    this.j.put(Integer.valueOf(tVar.a), new a(this, 3));
                }
                String a3 = g.a(file);
                if (a2 && tVar.j.equals(a3)) {
                    n3.a(file.getAbsolutePath(), Boolean.TRUE);
                    tVar.e = file.getAbsolutePath();
                    if (this.b.a(tVar, (String) null, (String) null)) {
                        if (this.j != null && !this.j.containsKey(Integer.valueOf(tVar.a))) {
                            this.j.put(Integer.valueOf(tVar.a), new a(this, 1));
                        }
                        this.e.a(p3.d, System.currentTimeMillis(), true);
                        return;
                    }
                    if (this.j != null && !this.j.containsKey(Integer.valueOf(tVar.a))) {
                        this.j.put(Integer.valueOf(tVar.a), new a(this, 4));
                    }
                    this.b.a(tVar.a, tVar.d, (PackageInfo) null);
                    return;
                }
                if (file3.exists()) {
                    j = file3.length();
                    file3.delete();
                } else {
                    j = -1;
                }
                this.b.a(tVar.a, tVar.d, (PackageInfo) null);
                HashMap hashMap3 = new HashMap();
                hashMap3.put(obj, l2.q);
                hashMap3.put("ret", a2 ? "1" : "0");
                hashMap3.put(FunAdSdk.PLATFORM_AM, tVar.j);
                hashMap3.put("acm", a3);
                hashMap3.put("p", file.getAbsolutePath());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(j);
                hashMap3.put("len", sb4.toString());
                hashMap3.put("l", ExifInterface.GPS_DIRECTION_TRUE);
                h1.a(this.a, "1002001", hashMap3);
            } catch (Throwable unused) {
                this.b.a(tVar.a, tVar.d, (PackageInfo) null);
            }
        }
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                String str = v2.a + v2.g;
                String d = w2.d(this.a);
                if (!TextUtils.isEmpty(d)) {
                    str = str + "?" + d;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject c = w2.c(this.a);
                if (c != null) {
                    jSONObject.put("data", new n1(this.a).b(c.toString()));
                }
                m a2 = m.a(this.a);
                n nVar = new n(str, jSONObject);
                nVar.a(WeaponHI.cookieData);
                nVar.b(WeaponHI.encryENV);
                JSONObject jSONObject2 = new JSONObject(a2.a(nVar));
                int optInt = jSONObject2.optInt("result", 0);
                if (optInt != 1) {
                    if (optInt == -7) {
                        p3.a(this.a).a(p3.c, 1, false);
                        return null;
                    }
                    return null;
                }
                String a3 = new n1(this.a).a(jSONObject2.getString("antispamPluginManageRsp"));
                if (TextUtils.isEmpty(a3)) {
                    if (this.g == 0) {
                        this.g = 8;
                    }
                    throw new NetworkErrorException("kuaishou risk pluginloader response is null");
                }
                JSONObject jSONObject3 = new JSONObject(a3);
                if (jSONObject3.optInt("status", 0) == 1) {
                    return jSONObject3.optJSONObject("plugin");
                }
                if (this.e != null) {
                    this.e.a(p3.d, System.currentTimeMillis(), true);
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<String> it;
        JSONObject jSONObject;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                try {
                } finally {
                    WeaponHI.iD();
                }
            } catch (Throwable unused) {
                this.b.c();
                this.c.a();
            }
            synchronized (v.class) {
                if (this.f == 1 || this.f == 2 || this.f == 4 || this.h || System.currentTimeMillis() - s >= 300000) {
                    this.c.d();
                    s = System.currentTimeMillis();
                    if ((System.currentTimeMillis() - this.e.b(p3.d)) - (this.e.a(p3.e, 6) * 3600000) > 0) {
                        List<t> b = this.c.b();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<t> arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        JSONObject a2 = a();
                        if (a2 == null) {
                            throw new Exception("pluginJsonObject is null ");
                        }
                        boolean z2 = false;
                        try {
                            boolean c = m3.c(this.a);
                            Iterator<String> keys = a2.keys();
                            HashSet<String> hashSet = new HashSet();
                            boolean z3 = false;
                            while (keys.hasNext()) {
                                String next = keys.next();
                                if (c && next.endsWith("64")) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".32";
                                        hashSet.add(str);
                                    }
                                    z3 = true;
                                } else if (!c && next.endsWith(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK)) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".64";
                                        hashSet.add(str);
                                    }
                                    z3 = true;
                                } else if (c && next.endsWith(V8Engine.TYPE_V8)) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".v7";
                                        hashSet.add(str);
                                    }
                                    z3 = true;
                                } else if (!c && next.endsWith("v7")) {
                                    if (next.length() > 3) {
                                        hashSet.add(next.substring(0, next.length() - 3));
                                        str = next.substring(0, next.length() - 3) + ".v8";
                                        hashSet.add(str);
                                    }
                                    z3 = true;
                                }
                            }
                            if (z3) {
                                for (String str2 : hashSet) {
                                    a2.remove(str2);
                                }
                            }
                            z2 = z3;
                        } catch (Throwable unused2) {
                        }
                        Iterator<String> keys2 = a2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            t b2 = p.b(a2.optJSONObject(next2));
                            if (b2 != null) {
                                if (z2 && !b2.y && (next2.endsWith(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK) || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith(V8Engine.TYPE_V8))) {
                                    b2.y = true;
                                }
                                if (b2.v) {
                                    arrayList4.add(next2);
                                }
                                if (!b2.y) {
                                    arrayList3.add(b2);
                                }
                                int indexOf = b.indexOf(b2);
                                if (indexOf < 0 || !b2.y) {
                                    it = keys2;
                                    jSONObject = a2;
                                    z = z2;
                                    if (b2.y) {
                                        arrayList2.add(b2);
                                    }
                                } else {
                                    t tVar = b.get(indexOf);
                                    if (n3.b(b2.d, tVar.d)) {
                                        if (b2.x != tVar.x) {
                                            this.c.c(b2.a, b2.x);
                                        }
                                        if (!this.c.c(b2.a)) {
                                            arrayList2.add(b2);
                                        }
                                        it = keys2;
                                        jSONObject = a2;
                                        z = z2;
                                    } else {
                                        jSONObject = a2;
                                        z = z2;
                                        it = keys2;
                                        this.e.a(p3.d, System.currentTimeMillis(), true);
                                        if (b2.x != tVar.x) {
                                            this.c.c(b2.a, b2.x);
                                        }
                                        arrayList.add(b2);
                                    }
                                    b.remove(indexOf);
                                }
                                a2 = jSONObject;
                                z2 = z;
                                keys2 = it;
                            }
                        }
                        for (t tVar2 : b) {
                            if (!arrayList4.contains(tVar2.c)) {
                                if (this.i != null) {
                                    this.i.add(Integer.valueOf(tVar2.a));
                                }
                                this.b.a(tVar2.c);
                            }
                        }
                        for (t tVar3 : arrayList3) {
                            if (!arrayList4.contains(tVar3.c)) {
                                if (this.i != null) {
                                    this.i.add(Integer.valueOf(tVar3.a));
                                }
                                this.b.a(tVar3.c);
                            }
                        }
                        ArrayList<t> arrayList5 = new ArrayList();
                        if (arrayList2.size() != 0) {
                            arrayList5.addAll(arrayList2);
                        }
                        if (arrayList.size() != 0) {
                            arrayList5.addAll(arrayList);
                        }
                        for (t tVar4 : arrayList5) {
                            if (tVar4 != null) {
                                if (arrayList.contains(tVar4)) {
                                    this.b.a(tVar4.a, tVar4.d, (PackageInfo) null);
                                } else if (arrayList2.contains(tVar4)) {
                                    a(tVar4);
                                }
                            }
                        }
                    } else {
                        this.b.c();
                        this.c.a();
                    }
                }
            }
        }
    }
}
