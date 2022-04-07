package com.kuaishou.weapon.un;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.qq.e.comm.constants.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class v0 implements Runnable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A = 7;
    public static final int B = 8;
    public static final int C = 9;
    public static final int D = 10;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final int H = 4;
    public static final int I = 5;
    public static final int J = 6;
    public static long K = 0;
    public static volatile boolean L = false;
    public static boolean M = false;
    public static int N = 0;
    public static boolean O = false;
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 3;
    public static final int s = 4;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 3;
    public static final int x = 4;
    public static final int y = 5;
    public static final int z = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public n b;
    public x c;
    public File d;
    public d e;
    public int f;
    public int g;
    public boolean h;
    public Map<Integer, String> i;
    public Map<Integer, String> j;
    public List<Integer> k;
    public List<Integer> l;
    public Map<Integer, a> m;
    public int n;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ v0 b;

        public a(v0 v0Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v0Var;
            this.a = i;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(535006198, "Lcom/kuaishou/weapon/un/v0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(535006198, "Lcom/kuaishou/weapon/un/v0;");
        }
    }

    public v0(Context context, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z2)};
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
        this.j = new HashMap();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new HashMap();
        this.n = -2;
        this.a = context;
        this.b = n.a(context);
        this.c = x.a(context);
        this.e = new d(context);
        this.d = new File(context.getFilesDir(), ".tmp");
        this.f = i;
        this.h = z2;
    }

    private void a(p pVar) {
        Object obj;
        Object obj2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65538, this, pVar) != null) {
            return;
        }
        try {
            try {
                if (!TextUtils.isEmpty(pVar.j) && pVar.j.length() >= 10) {
                    if (!this.d.exists()) {
                        this.d.mkdir();
                    }
                    File file = new File(this.d, pVar.a + "-" + pVar.d + ".tmp");
                    File file2 = new File(this.d, pVar.a + "-" + pVar.d + ".zip");
                    boolean a2 = new p1(this.a, null).a(pVar.i, file);
                    try {
                        if (a2) {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            int b = i1.b(file.getAbsolutePath(), file2.getAbsolutePath(), k1.a(r1.t.getBytes(IMAudioTransRequest.CHARSET), 2));
                            if (b != 0) {
                                long length = file2.exists() ? file2.length() : -1L;
                                if (file2.exists()) {
                                    file2.delete();
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put("e", q0.z);
                                StringBuilder sb = new StringBuilder();
                                obj2 = "e";
                                sb.append(pVar.a);
                                sb.append("");
                                hashMap.put(PushConstants.URI_PACKAGE_NAME, sb.toString());
                                hashMap.put("pv", pVar.d);
                                hashMap.put("m", pVar.j);
                                hashMap.put("len", length + "");
                                hashMap.put("l", "T");
                                l1.a(this.a, "1002001", hashMap);
                                a2 = false;
                            } else {
                                obj2 = "e";
                            }
                            if (b == 0 && file.exists()) {
                                file.delete();
                            }
                        } else {
                            obj2 = "e";
                            this.m.put(Integer.valueOf(pVar.a), new a(this, 3));
                            this.b.f();
                        }
                        String a3 = s1.a(file2);
                        if (a2 && pVar.j.equals(a3)) {
                            l1.a(file2.getAbsolutePath(), Boolean.TRUE);
                            pVar.e = file2.getAbsolutePath();
                            if (this.b.a(pVar, (String) null, (String) null)) {
                                if (this.m != null && !this.m.containsKey(Integer.valueOf(pVar.a))) {
                                    this.m.put(Integer.valueOf(pVar.a), new a(this, 1));
                                }
                                this.e.a(d.j, System.currentTimeMillis());
                                return;
                            }
                            if (this.m != null && !this.m.containsKey(Integer.valueOf(pVar.a))) {
                                this.m.put(Integer.valueOf(pVar.a), new a(this, 4));
                            }
                            this.b.f();
                            this.b.a(pVar.a, pVar.d, (PackageInfo) null);
                            return;
                        }
                        this.b.f();
                        if (file.exists()) {
                            j = file.length();
                            file.delete();
                        } else {
                            j = -1;
                        }
                        this.b.a(pVar.a, pVar.d, (PackageInfo) null);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(obj2, q0.A);
                        hashMap2.put(Constants.KEYS.RET, a2 ? "1" : "0");
                        hashMap2.put("am", pVar.j);
                        hashMap2.put("acm", a3);
                        hashMap2.put("len", j + "");
                        hashMap2.put("l", "T");
                        l1.a(this.a, "1002001", hashMap2);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        obj = 65538;
                        l1.a(th);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put(obj, th.getMessage());
                        hashMap3.put("l", "T");
                        l1.a(this.a, "1002001", hashMap3);
                        this.b.a(pVar.a, pVar.d, (PackageInfo) null);
                        return;
                    }
                }
                this.b.a(pVar.a, pVar.d, (PackageInfo) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            obj = "e";
        }
    }

    private void a(p pVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, pVar, i) == null) {
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
        }
    }

    public JSONObject a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            try {
                String str3 = r0.a + r0.c;
                String a2 = p1.a(str, str2);
                JSONObject b = s0.b(this.a);
                if (!TextUtils.isEmpty(a2)) {
                    str3 = str3 + "?" + a2;
                }
                JSONObject jSONObject = new JSONObject();
                if (b != null) {
                    jSONObject.put("data", new m1(this.a).b(b.toString()));
                }
                JSONObject jSONObject2 = new JSONObject(new p1(this.a, null).a(str3, jSONObject.toString().getBytes()));
                if (jSONObject2.optInt("result", 0) == 1) {
                    String a3 = new m1(this.a).a(jSONObject2.getString("antispamPluginManageRsp"));
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
                        this.e.a(d.j, System.currentTimeMillis());
                    }
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (JSONObject) invokeLL.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        Iterator<String> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                synchronized (v0.class) {
                    if (this.f != 1 && this.f != 2 && this.f != 4 && !this.h && System.currentTimeMillis() - K < 300000) {
                        if (this.g == 0) {
                            this.g = 2;
                            a((String) null);
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("e", q0.p);
                        hashMap.put("l", "T");
                        return;
                    }
                    this.c.h();
                    String[] a2 = l1.a(this.a);
                    if (a2 == null || a2.length != 2 || TextUtils.isEmpty(a2[0]) || TextUtils.isEmpty(a2[1])) {
                        str = "16";
                        str2 = l1.d;
                    } else {
                        str = a2[0];
                        str2 = a2[1];
                    }
                    String c = l1.c(this.a);
                    if (!TextUtils.isEmpty(c) && this.e != null) {
                        this.e.f(c);
                    }
                    String h = l1.h();
                    if (!TextUtils.isEmpty(h) && this.e != null) {
                        this.e.g(h);
                    }
                    K = System.currentTimeMillis();
                    if ((System.currentTimeMillis() - this.e.d(d.j)) - (this.e.b(d.Z, 6) * 3600000) > 0) {
                        List<p> b = this.c.b();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<p> arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        JSONObject a3 = a(str, str2);
                        if (a3 == null) {
                            this.b.f();
                            throw new Exception("pluginJsonObject is null ");
                        }
                        Iterator<String> keys = a3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            p b2 = i.b(a3.optJSONObject(next));
                            if (b2 != null) {
                                if (b2.w) {
                                    arrayList4.add(next);
                                }
                                if (!b2.z) {
                                    arrayList3.add(b2);
                                }
                                int indexOf = b.indexOf(b2);
                                if (indexOf < 0 || !b2.z) {
                                    it = keys;
                                    if (b2.z) {
                                        arrayList2.add(b2);
                                    }
                                } else {
                                    p pVar = b.get(indexOf);
                                    if (l1.b(b2.d, pVar.d)) {
                                        if (b2.y != pVar.y) {
                                            this.c.e(b2.a, b2.y);
                                        }
                                        if (!this.c.e(b2.a)) {
                                            arrayList2.add(b2);
                                        }
                                        it = keys;
                                    } else {
                                        it = keys;
                                        this.e.a(d.j, System.currentTimeMillis());
                                        if (b2.y != pVar.y) {
                                            this.c.e(b2.a, b2.y);
                                        }
                                        arrayList.add(b2);
                                    }
                                    b.remove(indexOf);
                                }
                                keys = it;
                            }
                        }
                        for (p pVar2 : b) {
                            if (!arrayList4.contains(pVar2.c)) {
                                if (this.k != null) {
                                    this.k.add(Integer.valueOf(pVar2.a));
                                }
                                this.b.b(pVar2.c);
                            }
                        }
                        for (p pVar3 : arrayList3) {
                            if (!arrayList4.contains(pVar3.c)) {
                                if (this.k != null) {
                                    this.k.add(Integer.valueOf(pVar3.a));
                                }
                                this.b.b(pVar3.c);
                            }
                        }
                        List<Integer> j = this.e.j();
                        List<Integer> b3 = this.e.b();
                        for (int i = 0; i < b3.size(); i++) {
                            if (!j.contains(b3.get(i))) {
                                j.add(b3.get(i));
                            }
                        }
                        ArrayList<p> arrayList5 = new ArrayList();
                        if (arrayList2.size() != 0) {
                            arrayList5.addAll(arrayList2);
                        }
                        if (arrayList.size() != 0) {
                            arrayList5.addAll(arrayList);
                        }
                        for (p pVar4 : arrayList5) {
                            if (pVar4 != null) {
                                if (arrayList.contains(pVar4)) {
                                    this.b.a(pVar4.a, pVar4.d, (PackageInfo) null);
                                } else if (arrayList2.contains(pVar4)) {
                                    try {
                                        if (!pVar4.c.contains(ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT)) {
                                            Thread.sleep(5000L);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    a(pVar4);
                                }
                            }
                        }
                    } else {
                        this.b.g();
                        this.c.a();
                    }
                }
            } catch (Throwable th) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("slct", K + "");
                hashMap2.put("e", th.getMessage());
                hashMap2.put("l", "T");
                l1.a(this.a, "1002001", hashMap2);
                this.b.g();
                this.c.a();
            }
        }
    }
}
