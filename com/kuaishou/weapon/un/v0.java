package com.kuaishou.weapon.un;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes7.dex */
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

    /* renamed from: b  reason: collision with root package name */
    public n f53834b;

    /* renamed from: c  reason: collision with root package name */
    public x f53835c;

    /* renamed from: d  reason: collision with root package name */
    public File f53836d;

    /* renamed from: e  reason: collision with root package name */
    public d f53837e;

    /* renamed from: f  reason: collision with root package name */
    public int f53838f;

    /* renamed from: g  reason: collision with root package name */
    public int f53839g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53840h;

    /* renamed from: i  reason: collision with root package name */
    public Map<Integer, String> f53841i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, String> f53842j;
    public List<Integer> k;
    public List<Integer> l;
    public Map<Integer, a> m;
    public int n;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v0 f53843b;

        public a(v0 v0Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53843b = v0Var;
            this.a = i2;
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

    public v0(Context context, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53838f = 0;
        this.f53839g = 0;
        this.f53840h = false;
        this.f53842j = new HashMap();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new HashMap();
        this.n = -2;
        this.a = context;
        this.f53834b = n.a(context);
        this.f53835c = x.a(context);
        this.f53837e = new d(context);
        this.f53836d = new File(context.getFilesDir(), ".tmp");
        this.f53838f = i2;
        this.f53840h = z2;
    }

    private void a(p pVar) {
        Object obj;
        Object obj2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65538, this, pVar) != null) {
            return;
        }
        try {
            try {
                if (!TextUtils.isEmpty(pVar.f53763j) && pVar.f53763j.length() >= 10) {
                    if (!this.f53836d.exists()) {
                        this.f53836d.mkdir();
                    }
                    File file = new File(this.f53836d, pVar.a + "-" + pVar.f53757d + ".tmp");
                    File file2 = new File(this.f53836d, pVar.a + "-" + pVar.f53757d + ".zip");
                    boolean a2 = new p1(this.a, null).a(pVar.f53762i, file);
                    try {
                        if (a2) {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            int b2 = i1.b(file.getAbsolutePath(), file2.getAbsolutePath(), k1.a(r1.t.getBytes("utf-8"), 2));
                            if (b2 != 0) {
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
                                hashMap.put("pv", pVar.f53757d);
                                hashMap.put("m", pVar.f53763j);
                                hashMap.put("len", length + "");
                                hashMap.put("l", "T");
                                l1.a(this.a, "1002001", hashMap);
                                a2 = false;
                            } else {
                                obj2 = "e";
                            }
                            if (b2 == 0 && file.exists()) {
                                file.delete();
                            }
                        } else {
                            obj2 = "e";
                            this.m.put(Integer.valueOf(pVar.a), new a(this, 3));
                            this.f53834b.f();
                        }
                        String a3 = s1.a(file2);
                        if (a2 && pVar.f53763j.equals(a3)) {
                            l1.a(file2.getAbsolutePath(), Boolean.TRUE);
                            pVar.f53758e = file2.getAbsolutePath();
                            if (this.f53834b.a(pVar, (String) null, (String) null)) {
                                if (this.m != null && !this.m.containsKey(Integer.valueOf(pVar.a))) {
                                    this.m.put(Integer.valueOf(pVar.a), new a(this, 1));
                                }
                                this.f53837e.a(d.f53603j, System.currentTimeMillis());
                                return;
                            }
                            if (this.m != null && !this.m.containsKey(Integer.valueOf(pVar.a))) {
                                this.m.put(Integer.valueOf(pVar.a), new a(this, 4));
                            }
                            this.f53834b.f();
                            this.f53834b.a(pVar.a, pVar.f53757d, (PackageInfo) null);
                            return;
                        }
                        this.f53834b.f();
                        if (file.exists()) {
                            j2 = file.length();
                            file.delete();
                        } else {
                            j2 = -1;
                        }
                        this.f53834b.a(pVar.a, pVar.f53757d, (PackageInfo) null);
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(obj2, q0.A);
                        hashMap2.put(Constants.KEYS.RET, a2 ? "1" : "0");
                        hashMap2.put("am", pVar.f53763j);
                        hashMap2.put("acm", a3);
                        hashMap2.put("len", j2 + "");
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
                        this.f53834b.a(pVar.a, pVar.f53757d, (PackageInfo) null);
                        return;
                    }
                }
                this.f53834b.a(pVar.a, pVar.f53757d, (PackageInfo) null);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            obj = "e";
        }
    }

    private void a(p pVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, pVar, i2) == null) {
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
                String str3 = r0.a + r0.f53792c;
                String a2 = p1.a(str, str2);
                JSONObject b2 = s0.b(this.a);
                if (!TextUtils.isEmpty(a2)) {
                    str3 = str3 + "?" + a2;
                }
                JSONObject jSONObject = new JSONObject();
                if (b2 != null) {
                    jSONObject.put("data", new m1(this.a).b(b2.toString()));
                }
                JSONObject jSONObject2 = new JSONObject(new p1(this.a, null).a(str3, jSONObject.toString().getBytes()));
                if (jSONObject2.optInt("result", 0) == 1) {
                    String a3 = new m1(this.a).a(jSONObject2.getString("antispamPluginManageRsp"));
                    if (TextUtils.isEmpty(a3)) {
                        if (this.f53839g == 0) {
                            this.f53839g = 8;
                        }
                        throw new NetworkErrorException("kuaishou risk pluginloader response is null");
                    }
                    JSONObject jSONObject3 = new JSONObject(a3);
                    if (jSONObject3.optInt("status", 0) == 1) {
                        return jSONObject3.optJSONObject("plugin");
                    }
                    if (this.f53837e != null) {
                        this.f53837e.a(d.f53603j, System.currentTimeMillis());
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
                    if (this.f53838f != 1 && this.f53838f != 2 && this.f53838f != 4 && !this.f53840h && System.currentTimeMillis() - K < 300000) {
                        if (this.f53839g == 0) {
                            this.f53839g = 2;
                            a((String) null);
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("e", q0.p);
                        hashMap.put("l", "T");
                        return;
                    }
                    this.f53835c.h();
                    String[] a2 = l1.a(this.a);
                    if (a2 == null || a2.length != 2 || TextUtils.isEmpty(a2[0]) || TextUtils.isEmpty(a2[1])) {
                        str = "16";
                        str2 = l1.f53713d;
                    } else {
                        str = a2[0];
                        str2 = a2[1];
                    }
                    String c2 = l1.c(this.a);
                    if (!TextUtils.isEmpty(c2) && this.f53837e != null) {
                        this.f53837e.f(c2);
                    }
                    String h2 = l1.h();
                    if (!TextUtils.isEmpty(h2) && this.f53837e != null) {
                        this.f53837e.g(h2);
                    }
                    K = System.currentTimeMillis();
                    if ((System.currentTimeMillis() - this.f53837e.d(d.f53603j)) - (this.f53837e.b(d.Z, 6) * 3600000) > 0) {
                        List<p> b2 = this.f53835c.b();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList<p> arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        JSONObject a3 = a(str, str2);
                        if (a3 == null) {
                            this.f53834b.f();
                            throw new Exception("pluginJsonObject is null ");
                        }
                        Iterator<String> keys = a3.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            p b3 = i.b(a3.optJSONObject(next));
                            if (b3 != null) {
                                if (b3.w) {
                                    arrayList4.add(next);
                                }
                                if (!b3.z) {
                                    arrayList3.add(b3);
                                }
                                int indexOf = b2.indexOf(b3);
                                if (indexOf < 0 || !b3.z) {
                                    it = keys;
                                    if (b3.z) {
                                        arrayList2.add(b3);
                                    }
                                } else {
                                    p pVar = b2.get(indexOf);
                                    if (l1.b(b3.f53757d, pVar.f53757d)) {
                                        if (b3.y != pVar.y) {
                                            this.f53835c.e(b3.a, b3.y);
                                        }
                                        if (!this.f53835c.e(b3.a)) {
                                            arrayList2.add(b3);
                                        }
                                        it = keys;
                                    } else {
                                        it = keys;
                                        this.f53837e.a(d.f53603j, System.currentTimeMillis());
                                        if (b3.y != pVar.y) {
                                            this.f53835c.e(b3.a, b3.y);
                                        }
                                        arrayList.add(b3);
                                    }
                                    b2.remove(indexOf);
                                }
                                keys = it;
                            }
                        }
                        for (p pVar2 : b2) {
                            if (!arrayList4.contains(pVar2.f53756c)) {
                                if (this.k != null) {
                                    this.k.add(Integer.valueOf(pVar2.a));
                                }
                                this.f53834b.b(pVar2.f53756c);
                            }
                        }
                        for (p pVar3 : arrayList3) {
                            if (!arrayList4.contains(pVar3.f53756c)) {
                                if (this.k != null) {
                                    this.k.add(Integer.valueOf(pVar3.a));
                                }
                                this.f53834b.b(pVar3.f53756c);
                            }
                        }
                        List<Integer> j2 = this.f53837e.j();
                        List<Integer> b4 = this.f53837e.b();
                        for (int i2 = 0; i2 < b4.size(); i2++) {
                            if (!j2.contains(b4.get(i2))) {
                                j2.add(b4.get(i2));
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
                                    this.f53834b.a(pVar4.a, pVar4.f53757d, (PackageInfo) null);
                                } else if (arrayList2.contains(pVar4)) {
                                    try {
                                        if (!pVar4.f53756c.contains(ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT)) {
                                            Thread.sleep(5000L);
                                        }
                                    } catch (Exception unused) {
                                    }
                                    a(pVar4);
                                }
                            }
                        }
                    } else {
                        this.f53834b.g();
                        this.f53835c.a();
                    }
                }
            } catch (Throwable th) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("slct", K + "");
                hashMap2.put("e", th.getMessage());
                hashMap2.put("l", "T");
                l1.a(this.a, "1002001", hashMap2);
                this.f53834b.g();
                this.f53835c.a();
            }
        }
    }
}
