package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.b.z;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.aa;
import com.vivo.push.util.t;
import com.vivo.push.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f63068b;

    /* renamed from: c  reason: collision with root package name */
    public long f63069c;

    /* renamed from: d  reason: collision with root package name */
    public long f63070d;

    /* renamed from: e  reason: collision with root package name */
    public long f63071e;

    /* renamed from: f  reason: collision with root package name */
    public long f63072f;

    /* renamed from: g  reason: collision with root package name */
    public long f63073g;

    /* renamed from: h  reason: collision with root package name */
    public Context f63074h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f63075i;

    /* renamed from: j  reason: collision with root package name */
    public com.vivo.push.util.b f63076j;

    /* renamed from: k  reason: collision with root package name */
    public String f63077k;
    public String l;
    public SparseArray<a> m;
    public int n;
    public Boolean o;
    public Long p;
    public boolean q;
    public IPushClientFactory r;
    public int s;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63068b = -1L;
        this.f63069c = -1L;
        this.f63070d = -1L;
        this.f63071e = -1L;
        this.f63072f = -1L;
        this.f63073g = -1L;
        this.f63075i = true;
        this.m = new SparseArray<>();
        this.n = 0;
        this.r = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.l = null;
            this.f63076j.b("APP_ALIAS");
        }
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (this.o == null) {
                this.o = Boolean.valueOf(l() >= 1230 && aa.e(this.f63074h));
            }
            return this.o.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f63074h == null) {
                com.vivo.push.util.p.d("PushClientManager", "support:context is null");
                return false;
            }
            Boolean valueOf = Boolean.valueOf(n());
            this.o = valueOf;
            return valueOf.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (!TextUtils.isEmpty(this.f63077k)) {
                return this.f63077k;
            }
            com.vivo.push.util.b bVar = this.f63076j;
            String b2 = bVar != null ? bVar.b("APP_TOKEN", (String) null) : "";
            c(b2);
            return b2;
        }
        return (String) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f63075i : invokeV.booleanValue;
    }

    public final Context h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f63074h : (Context) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f63076j.a();
        }
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.s : invokeV.intValue;
    }

    public final long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Context context = this.f63074h;
            if (context == null) {
                return -1L;
            }
            if (this.p == null) {
                this.p = Long.valueOf(aa.b(context));
            }
            return this.p.longValue();
        }
        return invokeV.longValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            m.a(new k(this, str));
        }
    }

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
                eVar = a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public final void b() throws VivoPushException {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (context = this.f63074h) == null) {
            return;
        }
        aa.c(context);
    }

    public final List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            String b2 = this.f63076j.b("APP_TAGS", (String) null);
            ArrayList arrayList = new ArrayList();
            try {
            } catch (JSONException unused) {
                this.f63076j.b("APP_TAGS");
                arrayList.clear();
                com.vivo.push.util.p.d("PushClientManager", "getTags error");
            }
            if (TextUtils.isEmpty(b2)) {
                return arrayList;
            }
            Iterator<String> keys = new JSONObject(b2).keys();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IPushActionListener a;

        /* renamed from: b  reason: collision with root package name */
        public com.vivo.push.b.c f63078b;

        /* renamed from: c  reason: collision with root package name */
        public IPushActionListener f63079c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f63080d;

        /* renamed from: e  reason: collision with root package name */
        public Object[] f63081e;

        public a(com.vivo.push.b.c cVar, IPushActionListener iPushActionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, iPushActionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63078b = cVar;
            this.a = iPushActionListener;
        }

        public final void a(int i2, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, objArr) == null) {
                this.f63081e = objArr;
                IPushActionListener iPushActionListener = this.f63079c;
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(i2);
                }
                IPushActionListener iPushActionListener2 = this.a;
                if (iPushActionListener2 != null) {
                    iPushActionListener2.onStateChanged(i2);
                }
            }
        }

        public final Object[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63081e : (Object[]) invokeV.objValue;
        }

        public final void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
                this.f63080d = runnable;
            }
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Runnable runnable = this.f63080d;
                if (runnable == null) {
                    com.vivo.push.util.p.a("PushClientManager", "task is null");
                } else {
                    runnable.run();
                }
            }
        }

        public final void a(IPushActionListener iPushActionListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iPushActionListener) == null) {
                this.f63079c = iPushActionListener;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            synchronized (this) {
                if (str != null) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        a aVar = this.m.get(parseInt);
                        this.m.delete(parseInt);
                        return aVar;
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                String b2 = this.f63076j.b("APP_TAGS", (String) null);
                if (TextUtils.isEmpty(b2)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(b2);
                }
                for (String str : list) {
                    jSONObject.remove(str);
                }
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    this.f63076j.b("APP_TAGS");
                } else {
                    this.f63076j.a("APP_TAGS", jSONObject2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f63076j.b("APP_TAGS");
            }
        }
    }

    public final synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (this) {
                if (this.f63074h == null) {
                    this.f63074h = ContextDelegate.getContext(context);
                    this.q = t.c(context, context.getPackageName());
                    x.b().a(this.f63074h);
                    a(new com.vivo.push.b.g());
                    com.vivo.push.util.b bVar = new com.vivo.push.util.b();
                    this.f63076j = bVar;
                    bVar.a(this.f63074h, "com.vivo.push_preferences.appconfig_v1");
                    this.f63077k = f();
                    this.l = this.f63076j.b("APP_ALIAS", (String) null);
                }
            }
        }
    }

    public final void c(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && list.contains(this.l)) {
            m();
        }
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            m.c(new f(this, str));
        }
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                String b2 = this.f63076j.b("APP_TAGS", (String) null);
                if (TextUtils.isEmpty(b2)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(b2);
                }
                for (String str : list) {
                    jSONObject.put(str, System.currentTimeMillis());
                }
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    this.f63076j.b("APP_TAGS");
                } else {
                    this.f63076j.a("APP_TAGS", jSONObject2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.f63076j.b("APP_TAGS");
            }
        }
    }

    public final void b(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iPushActionListener) == null) {
            if (this.f63074h == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if ("".equals(this.f63077k)) {
                iPushActionListener.onStateChanged(0);
            } else if (!a(this.f63069c)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                }
            } else {
                this.f63069c = SystemClock.elapsedRealtime();
                String packageName = this.f63074h.getPackageName();
                a aVar = null;
                if (this.f63074h != null) {
                    com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
                    bVar.d();
                    bVar.e();
                    bVar.g();
                    bVar.a(100);
                    if (this.q) {
                        if (n()) {
                            aVar = new a(bVar, iPushActionListener);
                            String a2 = a(aVar);
                            bVar.b(a2);
                            aVar.a(new j(this, bVar, a2));
                        } else if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    } else if (bVar.a(this.f63074h) == 2) {
                        aVar = a(bVar, iPushActionListener);
                    } else {
                        a(bVar);
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(0);
                        }
                    }
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
                if (aVar == null) {
                    return;
                }
                aVar.a(new i(this));
                aVar.a();
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f63077k = str;
            this.f63076j.a("APP_TOKEN", str);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f63075i = z;
        }
    }

    public final void a(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iPushActionListener) == null) {
            if (this.f63074h == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            String f2 = f();
            this.f63077k = f2;
            if (!TextUtils.isEmpty(f2)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!a(this.f63068b)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                }
            } else {
                this.f63068b = SystemClock.elapsedRealtime();
                String packageName = this.f63074h.getPackageName();
                a aVar = null;
                if (this.f63074h != null) {
                    com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
                    bVar.g();
                    bVar.d();
                    bVar.e();
                    bVar.a(100);
                    if (this.q) {
                        if (n()) {
                            aVar = a(bVar, iPushActionListener);
                        } else if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
                    } else if (bVar.a(this.f63074h) == 2) {
                        aVar = a(bVar, iPushActionListener);
                    } else {
                        a(bVar);
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(0);
                        }
                    }
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
                if (aVar == null) {
                    return;
                }
                aVar.a(new g(this, aVar));
                aVar.a();
            }
        }
    }

    public final void b(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, iPushActionListener) == null) {
            if (this.f63074h == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if (TextUtils.isEmpty(this.l)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.f63074h.getPackageName(), arrayList);
                aVar.a(100);
                if (this.q) {
                    if (!n()) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                            return;
                        }
                        return;
                    } else if (!a(this.f63071e)) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(1002);
                            return;
                        }
                        return;
                    } else {
                        this.f63071e = SystemClock.elapsedRealtime();
                        String a2 = a(new a(aVar, iPushActionListener));
                        aVar.b(a2);
                        if (TextUtils.isEmpty(this.f63077k)) {
                            a(a2, 30001);
                            return;
                        } else if (TextUtils.isEmpty(str)) {
                            a(a2, 30002);
                            return;
                        } else if (str.length() > 70) {
                            a(a2, 30003);
                            return;
                        } else {
                            a(aVar);
                            e(a2);
                            return;
                        }
                    }
                }
                a(aVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            }
        }
    }

    private a a(com.vivo.push.b.b bVar, IPushActionListener iPushActionListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, bVar, iPushActionListener)) == null) {
            a aVar = new a(bVar, iPushActionListener);
            String a2 = a(aVar);
            bVar.b(a2);
            aVar.a(new h(this, bVar, a2));
            return aVar;
        }
        return (a) invokeLL.objValue;
    }

    public final void a(String str, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, objArr) == null) {
            a d2 = d(str);
            if (d2 != null) {
                d2.a(i2, objArr);
            } else {
                com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
            }
        }
    }

    public final void a(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, iPushActionListener) == null) {
            if (this.f63074h == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if (!TextUtils.isEmpty(this.l) && this.l.equals(str)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.f63074h.getPackageName(), arrayList);
                aVar.a(100);
                if (this.q) {
                    if (!n()) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                            return;
                        }
                        return;
                    } else if (!a(this.f63070d)) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(1002);
                            return;
                        }
                        return;
                    } else {
                        this.f63070d = SystemClock.elapsedRealtime();
                        String a2 = a(new a(aVar, iPushActionListener));
                        aVar.b(a2);
                        if (TextUtils.isEmpty(this.f63077k)) {
                            a(a2, 30001);
                            return;
                        } else if (TextUtils.isEmpty(str)) {
                            a(a2, 30002);
                            return;
                        } else if (str.length() > 70) {
                            a(a2, 30003);
                            return;
                        } else {
                            a(aVar);
                            e(a2);
                            return;
                        }
                    }
                }
                a(aVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.l = str;
            this.f63076j.a("APP_ALIAS", str);
        }
    }

    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, arrayList, iPushActionListener) == null) {
            Context context = this.f63074h;
            if (context == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            z zVar = new z(false, context.getPackageName(), arrayList);
            zVar.a(500);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f63073g)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f63073g = SystemClock.elapsedRealtime();
                    String a2 = a(new a(zVar, iPushActionListener));
                    zVar.b(a2);
                    if (TextUtils.isEmpty(this.f63077k)) {
                        a(a2, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        return;
                    } else if (arrayList.size() < 0) {
                        a(a2, 20002);
                        return;
                    } else if (arrayList.size() > 500) {
                        a(a2, 20004);
                        return;
                    } else {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (it.next().length() > 70) {
                                a(a2, 20003);
                                return;
                            }
                        }
                        a(zVar);
                        e(a2);
                        return;
                    }
                }
            }
            a(zVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public static boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j2)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            return j2 == -1 || elapsedRealtime <= j2 || elapsedRealtime >= j2 + 2000;
        }
        return invokeJ.booleanValue;
    }

    public final void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            a d2 = d(str);
            if (d2 != null) {
                d2.a(i2, new Object[0]);
            } else {
                com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
            }
        }
    }

    private synchronized String a(a aVar) {
        InterceptResult invokeL;
        String num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar)) == null) {
            synchronized (this) {
                this.m.put(this.n, aVar);
                int i2 = this.n;
                this.n = i2 + 1;
                num = Integer.toString(i2);
            }
            return num;
        }
        return (String) invokeL.objValue;
    }

    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, iPushActionListener) == null) {
            Context context = this.f63074h;
            if (context == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            z zVar = new z(true, context.getPackageName(), arrayList);
            zVar.a(500);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f63072f)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f63072f = SystemClock.elapsedRealtime();
                    String a2 = a(new a(zVar, iPushActionListener));
                    zVar.b(a2);
                    if (TextUtils.isEmpty(this.f63077k)) {
                        a(a2, ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        return;
                    } else if (arrayList.size() < 0) {
                        a(a2, 20002);
                        return;
                    } else {
                        if (arrayList.size() + c().size() > 500) {
                            a(a2, 20004);
                            return;
                        }
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (it.next().length() > 70) {
                                a(a2, 20003);
                                return;
                            }
                        }
                        a(zVar);
                        e(a2);
                        return;
                    }
                }
            }
            a(zVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, pushMessageCallback) == null) {
            o createReceiverCommand = this.r.createReceiverCommand(intent);
            Context context = a().f63074h;
            if (createReceiverCommand == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                    return;
                }
                return;
            }
            com.vivo.push.c.z createReceiveTask = this.r.createReceiveTask(createReceiverCommand);
            if (createReceiveTask == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(createReceiverCommand)));
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                    return;
                }
                return;
            }
            if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
                com.vivo.push.util.p.a(context, "[接收指令]".concat(String.valueOf(createReceiverCommand)));
            }
            createReceiveTask.a(pushMessageCallback);
            m.a((l) createReceiveTask);
        }
    }

    public final void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) {
            Context context = a().f63074h;
            if (oVar == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                    return;
                }
                return;
            }
            l createTask = this.r.createTask(oVar);
            if (createTask == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(oVar)));
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令" + oVar + "任务空！");
                    return;
                }
                return;
            }
            com.vivo.push.util.p.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(oVar)));
            m.a(createTask);
        }
    }
}
