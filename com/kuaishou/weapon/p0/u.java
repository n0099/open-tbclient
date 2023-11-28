package com.kuaishou.weapon.p0;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class u implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 0;
    public static final int e = 8;
    public static final int f = 1;
    public static final int g = 3;
    public static final int h = 4;
    public static long o;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> i;
    public Context j;
    public q k;
    public t l;
    public File m;
    public dp n;
    public int p;
    public int q;
    public boolean r;
    public Map<Integer, a> s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1651774390, "Lcom/kuaishou/weapon/p0/u;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1651774390, "Lcom/kuaishou/weapon/p0/u;");
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ u b;

        public a(u uVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uVar;
            this.a = i;
        }
    }

    public u(Context context, int i, boolean z) {
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
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.i = new ArrayList();
        this.s = new HashMap();
        this.j = context;
        this.k = q.a(context);
        this.l = t.a(context);
        this.n = dp.a(context);
        this.m = new File(context.getFilesDir(), ".tmp");
        this.p = i;
        this.r = z;
    }

    private void a(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sVar) == null) {
            try {
                if (!TextUtils.isEmpty(sVar.j) && sVar.j.length() >= 10) {
                    if (!this.m.exists()) {
                        this.m.mkdir();
                    }
                    File file = this.m;
                    File file2 = new File(file, sVar.a + "-" + sVar.d + ".tmp");
                    File file3 = this.m;
                    File file4 = new File(file3, sVar.a + "-" + sVar.d + ".zip");
                    boolean a2 = l.a(this.j).a(sVar.i, file2);
                    if (!a2) {
                        a2 = l.a(this.j).a(sVar.i, file2);
                    }
                    if (a2) {
                        if (file4.exists()) {
                            file4.delete();
                        }
                        int c2 = b.c(file2.getAbsolutePath(), file4.getAbsolutePath(), c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes("utf-8"), 2));
                        if (c2 != 0) {
                            if (file4.exists()) {
                                file4.delete();
                            }
                            a2 = false;
                        }
                        if (c2 == 0 && file2.exists()) {
                            file2.delete();
                        }
                    } else {
                        this.s.put(Integer.valueOf(sVar.a), new a(this, 3));
                    }
                    String a3 = f.a(file4);
                    if (a2 && sVar.j.equals(a3)) {
                        dn.a(file4.getAbsolutePath(), Boolean.TRUE);
                        sVar.e = file4.getAbsolutePath();
                        if (this.k.a(sVar, (String) null, (String) null)) {
                            if (this.s != null && !this.s.containsKey(Integer.valueOf(sVar.a))) {
                                this.s.put(Integer.valueOf(sVar.a), new a(this, 1));
                            }
                            this.n.a(dp.b, System.currentTimeMillis(), true);
                            return;
                        }
                        if (this.s != null && !this.s.containsKey(Integer.valueOf(sVar.a))) {
                            this.s.put(Integer.valueOf(sVar.a), new a(this, 4));
                        }
                        this.k.a(sVar.a, sVar.d, (PackageInfo) null);
                        return;
                    }
                    if (file2.exists()) {
                        file2.length();
                        file2.delete();
                    }
                    this.k.a(sVar.a, sVar.d, (PackageInfo) null);
                    return;
                }
                this.k.a(sVar.a, sVar.d, (PackageInfo) null);
            } catch (Throwable unused) {
                this.k.a(sVar.a, sVar.d, (PackageInfo) null);
            }
        }
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                String str = cu.a + cu.g;
                String a2 = cv.a(this.j);
                if (!TextUtils.isEmpty(a2)) {
                    str = str + "?" + a2;
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject c2 = cv.c(this.j);
                if (c2 != null) {
                    jSONObject.put("data", new bn(this.j).c(c2.toString()));
                }
                l a3 = l.a(this.j);
                m mVar = new m(str, jSONObject);
                mVar.a(WeaponHI.cookieData);
                mVar.b(WeaponHI.encryENV);
                JSONObject jSONObject2 = new JSONObject(a3.a(mVar));
                int optInt = jSONObject2.optInt("result", 0);
                if (optInt == 1) {
                    String a4 = new bn(this.j).a(jSONObject2.getString("antispamPluginManageRsp"));
                    if (TextUtils.isEmpty(a4)) {
                        if (this.q == 0) {
                            this.q = 8;
                        }
                        throw new NetworkErrorException("kuaishou risk pluginloader response is null");
                    }
                    JSONObject jSONObject3 = new JSONObject(a4);
                    if (jSONObject3.optInt("status", 0) == 1) {
                        return jSONObject3.optJSONObject("plugin");
                    }
                    if (this.n != null) {
                        this.n.a(dp.b, System.currentTimeMillis(), true);
                        return null;
                    }
                    return null;
                } else if (optInt == -7) {
                    dp.a(this.j).a(dp.a, 1, false);
                    return null;
                } else {
                    return null;
                }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                try {
                    synchronized (u.class) {
                        if (this.p != 1 && this.p != 2 && this.p != 4 && !this.r && System.currentTimeMillis() - o < 300000) {
                            return;
                        }
                        this.l.d();
                        o = System.currentTimeMillis();
                        if ((System.currentTimeMillis() - this.n.a(dp.b)) - (this.n.a(dp.c, 6) * 3600000) > 0) {
                            List<s> a2 = this.l.a();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList<s> arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            JSONObject a3 = a();
                            if (a3 != null) {
                                boolean z2 = false;
                                try {
                                    boolean b2 = dm.b(this.j);
                                    Iterator<String> keys = a3.keys();
                                    HashSet<String> hashSet = new HashSet();
                                    boolean z3 = false;
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        if (b2 && next.endsWith("64")) {
                                            if (next.length() > 3) {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".32");
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                        } else if (!b2 && next.endsWith(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK)) {
                                            if (next.length() <= 3) {
                                                z3 = true;
                                            } else {
                                                hashSet.add(next.substring(0, next.length() - 3));
                                                hashSet.add(next.substring(0, next.length() - 3) + ".64");
                                                z3 = true;
                                            }
                                        } else {
                                            if (b2 && next.endsWith(V8Engine.TYPE_V8)) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v7");
                                                    z3 = true;
                                                }
                                            } else if (!b2 && next.endsWith("v7")) {
                                                if (next.length() > 3) {
                                                    hashSet.add(next.substring(0, next.length() - 3));
                                                    hashSet.add(next.substring(0, next.length() - 3) + ".v8");
                                                }
                                            }
                                            z3 = true;
                                        }
                                    }
                                    if (z3) {
                                        for (String str : hashSet) {
                                            a3.remove(str);
                                        }
                                    }
                                    z2 = z3;
                                } catch (Throwable unused) {
                                }
                                Iterator<String> keys2 = a3.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    s a4 = o.a(a3.optJSONObject(next2));
                                    if (a4 != null) {
                                        if (z2 && !a4.y && (next2.endsWith(PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK) || next2.endsWith("64") || next2.endsWith("v7") || next2.endsWith(V8Engine.TYPE_V8))) {
                                            a4.y = true;
                                        }
                                        if (a4.v) {
                                            arrayList4.add(next2);
                                        }
                                        if (!a4.y) {
                                            arrayList3.add(a4);
                                        }
                                        int indexOf = a2.indexOf(a4);
                                        if (indexOf >= 0 && a4.y) {
                                            s sVar = a2.get(indexOf);
                                            if (dn.b(a4.d, sVar.d)) {
                                                if (a4.x != sVar.x) {
                                                    this.l.c(a4.a, a4.x);
                                                }
                                                if (!this.l.d(a4.a)) {
                                                    arrayList2.add(a4);
                                                }
                                                it = keys2;
                                                jSONObject = a3;
                                                z = z2;
                                            } else {
                                                jSONObject = a3;
                                                z = z2;
                                                it = keys2;
                                                this.n.a(dp.b, System.currentTimeMillis(), true);
                                                if (a4.x != sVar.x) {
                                                    this.l.c(a4.a, a4.x);
                                                }
                                                arrayList.add(a4);
                                            }
                                            a2.remove(indexOf);
                                        } else {
                                            it = keys2;
                                            jSONObject = a3;
                                            z = z2;
                                            if (a4.y) {
                                                arrayList2.add(a4);
                                            }
                                        }
                                        a3 = jSONObject;
                                        z2 = z;
                                        keys2 = it;
                                    }
                                }
                                for (s sVar2 : a2) {
                                    if (!arrayList4.contains(sVar2.c)) {
                                        if (this.i != null) {
                                            this.i.add(Integer.valueOf(sVar2.a));
                                        }
                                        this.k.a(sVar2.c);
                                    }
                                }
                                for (s sVar3 : arrayList3) {
                                    if (!arrayList4.contains(sVar3.c)) {
                                        if (this.i != null) {
                                            this.i.add(Integer.valueOf(sVar3.a));
                                        }
                                        this.k.a(sVar3.c);
                                    }
                                }
                                ArrayList<s> arrayList5 = new ArrayList();
                                if (arrayList2.size() != 0) {
                                    arrayList5.addAll(arrayList2);
                                }
                                if (arrayList.size() != 0) {
                                    arrayList5.addAll(arrayList);
                                }
                                for (s sVar4 : arrayList5) {
                                    if (sVar4 != null) {
                                        if (arrayList.contains(sVar4)) {
                                            this.k.a(sVar4.a, sVar4.d, (PackageInfo) null);
                                        } else if (arrayList2.contains(sVar4)) {
                                            a(sVar4);
                                        }
                                    }
                                }
                            } else {
                                throw new Exception("pluginJsonObject is null ");
                            }
                        } else {
                            this.k.c();
                            this.l.b();
                        }
                    }
                } finally {
                    WeaponHI.iD();
                }
            } catch (Throwable unused2) {
                this.k.c();
                this.l.b();
            }
        }
    }
}
