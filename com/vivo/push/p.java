package com.vivo.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.PlayerProps;
import com.vivo.push.b.ab;
import com.vivo.push.b.ac;
import com.vivo.push.b.ad;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f42179a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile p f42180b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public long f42181c;

    /* renamed from: d  reason: collision with root package name */
    public long f42182d;

    /* renamed from: e  reason: collision with root package name */
    public long f42183e;

    /* renamed from: f  reason: collision with root package name */
    public long f42184f;

    /* renamed from: g  reason: collision with root package name */
    public long f42185g;

    /* renamed from: h  reason: collision with root package name */
    public long f42186h;

    /* renamed from: i  reason: collision with root package name */
    public Context f42187i;
    public boolean j;
    public com.vivo.push.util.a k;
    public String l;
    public String m;
    public SparseArray<a> n;
    public int o;
    public Boolean p;
    public Long q;
    public boolean r;
    public IPushClientFactory s;
    public int t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1612095337, "Lcom/vivo/push/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1612095337, "Lcom/vivo/push/p;");
                return;
            }
        }
        f42179a = new Object();
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42181c = -1L;
        this.f42182d = -1L;
        this.f42183e = -1L;
        this.f42184f = -1L;
        this.f42185g = -1L;
        this.f42186h = -1L;
        this.j = true;
        this.n = new SparseArray<>();
        this.o = 0;
        this.s = new o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.m = null;
            this.k.c("APP_ALIAS");
        }
    }

    private long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            Context context = this.f42187i;
            if (context == null) {
                return -1L;
            }
            if (this.q == null) {
                this.q = Long.valueOf(com.vivo.push.util.z.b(context));
            }
            return this.q.longValue();
        }
        return invokeV.longValue;
    }

    private boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (this.p == null) {
                this.p = Boolean.valueOf(u() >= 1230 && com.vivo.push.util.z.e(this.f42187i));
            }
            return this.p.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (this.f42187i == null) {
                com.vivo.push.util.p.d("PushClientManager", "support:context is null");
                return false;
            }
            Boolean valueOf = Boolean.valueOf(v());
            this.p = valueOf;
            return valueOf.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String a2 = this.k.a("APP_TOKEN");
            if (TextUtils.isEmpty(a2)) {
                return a2;
            }
            Context context = this.f42187i;
            if (com.vivo.push.util.z.a(context, context.getPackageName(), a2)) {
                this.k.a();
                return null;
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final Context h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f42187i : (Context) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            a(new com.vivo.push.b.f());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            a(new ac());
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.k.a();
        }
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            a(new com.vivo.push.b.d(true));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            a(new com.vivo.push.b.d(false));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            a(new com.vivo.push.b.y());
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f42187i.getPackageManager().getComponentEnabledSetting(new ComponentName(this.f42187i, "com.vivo.push.sdk.service.PushService")) != 2 : invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            a(new com.vivo.push.b.i());
        }
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.t : invokeV.intValue;
    }

    public final Map<String, String> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? com.vivo.push.util.z.f(this.f42187i) : (Map) invokeV.objValue;
    }

    public final List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String a2 = this.k.a("APP_TAGS");
            ArrayList arrayList = new ArrayList();
            try {
            } catch (JSONException unused) {
                this.k.c("APP_TAGS");
                arrayList.clear();
                com.vivo.push.util.p.d("PushClientManager", "getTags error");
            }
            if (TextUtils.isEmpty(a2)) {
                return arrayList;
            }
            Iterator<String> keys = new JSONObject(a2).keys();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static p a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f42180b == null) {
                synchronized (f42179a) {
                    if (f42180b == null) {
                        f42180b = new p();
                    }
                }
            }
            return f42180b;
        }
        return (p) invokeV.objValue;
    }

    public final void b() throws VivoPushException {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (context = this.f42187i) == null) {
            return;
        }
        com.vivo.push.util.z.c(context);
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public IPushActionListener f42188a;

        /* renamed from: b  reason: collision with root package name */
        public com.vivo.push.b.c f42189b;

        /* renamed from: c  reason: collision with root package name */
        public IPushActionListener f42190c;

        /* renamed from: d  reason: collision with root package name */
        public Runnable f42191d;

        /* renamed from: e  reason: collision with root package name */
        public Object[] f42192e;

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
            this.f42189b = cVar;
            this.f42188a = iPushActionListener;
        }

        public final void a(int i2, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, objArr) == null) {
                this.f42192e = objArr;
                IPushActionListener iPushActionListener = this.f42190c;
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(i2);
                }
                IPushActionListener iPushActionListener2 = this.f42188a;
                if (iPushActionListener2 != null) {
                    iPushActionListener2.onStateChanged(i2);
                }
            }
        }

        public final Object[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42192e : (Object[]) invokeV.objValue;
        }

        public final void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
                this.f42191d = runnable;
            }
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Runnable runnable = this.f42191d;
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
                this.f42190c = iPushActionListener;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            w.a(new u(this, str));
        }
    }

    public final void b(List<String> list) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, list) == null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                String a2 = this.k.a("APP_TAGS");
                if (TextUtils.isEmpty(a2)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(a2);
                }
                for (String str : list) {
                    jSONObject.remove(str);
                }
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    this.k.c("APP_TAGS");
                } else {
                    this.k.a("APP_TAGS", jSONObject2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.k.c("APP_TAGS");
            }
        }
    }

    public final synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            synchronized (this) {
                if (this.f42187i == null) {
                    this.f42187i = context.getApplicationContext();
                    this.r = com.vivo.push.util.s.b(context, context.getPackageName());
                    com.vivo.push.util.w.b().a(this.f42187i);
                    a(new com.vivo.push.b.h());
                    com.vivo.push.util.a aVar = new com.vivo.push.util.a();
                    this.k = aVar;
                    aVar.a(context, "com.vivo.push_preferences.appconfig_v1");
                    this.l = f();
                    this.m = this.k.a("APP_ALIAS");
                }
            }
        }
    }

    public final void c(List<String> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, list) == null) && list.contains(this.m)) {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, str)) == null) {
            synchronized (this) {
                if (str != null) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        a aVar = this.n.get(parseInt);
                        this.n.delete(parseInt);
                        return aVar;
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public final void b(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iPushActionListener) == null) {
            if (this.f42187i == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if ("".equals(this.l)) {
                iPushActionListener.onStateChanged(0);
            } else if (!a(this.f42182d)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                }
            } else {
                this.f42182d = SystemClock.elapsedRealtime();
                String packageName = this.f42187i.getPackageName();
                a aVar = null;
                if (this.f42187i != null) {
                    com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
                    bVar.d();
                    bVar.e();
                    bVar.g();
                    bVar.a(100);
                    if (this.r) {
                        if (v()) {
                            aVar = new a(bVar, iPushActionListener);
                            String a2 = a(aVar);
                            bVar.b(a2);
                            aVar.a(new t(this, bVar, a2));
                        } else if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
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
                aVar.a(new s(this));
                aVar.a();
            }
        }
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.t = i2;
        }
    }

    public final void a(List<String> list) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                String a2 = this.k.a("APP_TAGS");
                if (TextUtils.isEmpty(a2)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(a2);
                }
                for (String str : list) {
                    jSONObject.put(str, System.currentTimeMillis());
                }
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    this.k.c("APP_TAGS");
                } else {
                    this.k.a("APP_TAGS", jSONObject2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                this.k.c("APP_TAGS");
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.l = str;
            this.k.a("APP_TOKEN", str);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.j = z;
        }
    }

    public final void a(IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iPushActionListener) == null) {
            if (this.f42187i == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            String f2 = f();
            this.l = f2;
            if (!TextUtils.isEmpty(f2)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else if (!a(this.f42181c)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(1002);
                }
            } else {
                this.f42181c = SystemClock.elapsedRealtime();
                String packageName = this.f42187i.getPackageName();
                a aVar = null;
                if (this.f42187i != null) {
                    com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
                    bVar.g();
                    bVar.d();
                    bVar.e();
                    bVar.a(100);
                    if (this.r) {
                        if (v()) {
                            aVar = new a(bVar, iPushActionListener);
                            String a2 = a(aVar);
                            bVar.b(a2);
                            aVar.a(new r(this, bVar, a2));
                        } else if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                        }
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
                aVar.a(new q(this, aVar));
                aVar.a();
            }
        }
    }

    public final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) || this.f42187i == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, str, this.f42187i.getPackageName(), arrayList);
        aVar.a(100);
        a(aVar);
    }

    public final void b(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, iPushActionListener) == null) {
            if (this.f42187i == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if (TextUtils.isEmpty(this.m)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, null, this.f42187i.getPackageName(), arrayList);
                aVar.a(100);
                if (this.r) {
                    if (!v()) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                            return;
                        }
                        return;
                    } else if (!a(this.f42184f)) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(1002);
                            return;
                        }
                        return;
                    } else {
                        this.f42184f = SystemClock.elapsedRealtime();
                        String a2 = a(new a(aVar, iPushActionListener));
                        aVar.b(a2);
                        if (TextUtils.isEmpty(this.l)) {
                            a(a2, PlayerProps.FFP_PROP_FLOAT_MIN_AVDIFF_REALTIME);
                            return;
                        } else if (TextUtils.isEmpty(str)) {
                            a(a2, PlayerProps.FFP_PROP_INT64_CPU);
                            return;
                        } else if (str.length() > 70) {
                            a(a2, PlayerProps.FFP_PROP_INT64_MEMORY);
                            return;
                        } else {
                            a(aVar);
                            d(a2);
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

    public final void a(String str, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, str, i2, objArr) == null) {
            a c2 = c(str);
            if (c2 != null) {
                c2.a(i2, objArr);
            } else {
                com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
            }
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) || this.f42187i == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, str, this.f42187i.getPackageName(), arrayList);
        aVar.a(100);
        a(aVar);
    }

    public final void a(String str, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, iPushActionListener) == null) {
            if (this.f42187i == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                }
            } else if (!TextUtils.isEmpty(this.m) && this.m.equals(str)) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, null, this.f42187i.getPackageName(), arrayList);
                aVar.a(100);
                if (this.r) {
                    if (!v()) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(101);
                            return;
                        }
                        return;
                    } else if (!a(this.f42183e)) {
                        if (iPushActionListener != null) {
                            iPushActionListener.onStateChanged(1002);
                            return;
                        }
                        return;
                    } else {
                        this.f42183e = SystemClock.elapsedRealtime();
                        String a2 = a(new a(aVar, iPushActionListener));
                        aVar.b(a2);
                        if (TextUtils.isEmpty(this.l)) {
                            a(a2, PlayerProps.FFP_PROP_FLOAT_MIN_AVDIFF_REALTIME);
                            return;
                        } else if (TextUtils.isEmpty(str)) {
                            a(a2, PlayerProps.FFP_PROP_INT64_CPU);
                            return;
                        } else if (str.length() > 70) {
                            a(a2, PlayerProps.FFP_PROP_INT64_MEMORY);
                            return;
                        } else {
                            a(aVar);
                            d(a2);
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
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.m = str;
            this.k.a("APP_ALIAS", str);
        }
    }

    public final void b(String str, ArrayList<String> arrayList) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, str, arrayList) == null) || (context = this.f42187i) == null) {
            return;
        }
        ad adVar = new ad(false, str, context.getPackageName(), arrayList);
        adVar.a(500);
        a(adVar);
    }

    public final void b(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, arrayList, iPushActionListener) == null) {
            Context context = this.f42187i;
            if (context == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            ad adVar = new ad(false, null, context.getPackageName(), arrayList);
            adVar.a(500);
            if (this.r) {
                if (!v()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f42186h)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f42186h = SystemClock.elapsedRealtime();
                    String a2 = a(new a(adVar, iPushActionListener));
                    adVar.b(a2);
                    if (TextUtils.isEmpty(this.l)) {
                        a(a2, 20001);
                        return;
                    } else if (arrayList.size() < 0) {
                        a(a2, PlayerProps.FFP_PROP_INT64_SELECTED_AUDIO_STREAM);
                        return;
                    } else if (arrayList.size() > 500) {
                        a(a2, PlayerProps.FFP_PROP_INT64_AUDIO_DECODER);
                        return;
                    } else {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (it.next().length() > 70) {
                                a(a2, PlayerProps.FFP_PROP_INT64_VIDEO_DECODER);
                                return;
                            }
                        }
                        a(adVar);
                        d(a2);
                        return;
                    }
                }
            }
            a(adVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public static boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j)) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            return j == -1 || elapsedRealtime <= j || elapsedRealtime >= j + 2000;
        }
        return invokeJ.booleanValue;
    }

    public final void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            a c2 = c(str);
            if (c2 != null) {
                c2.a(i2, new Object[0]);
            } else {
                com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
            }
        }
    }

    private synchronized String a(a aVar) {
        InterceptResult invokeL;
        String num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, aVar)) == null) {
            synchronized (this) {
                this.n.put(this.o, aVar);
                int i2 = this.o;
                this.o = i2 + 1;
                num = Integer.toString(i2);
            }
            return num;
        }
        return (String) invokeL.objValue;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (!com.vivo.push.b.g.a(i2)) {
                com.vivo.push.util.p.d("PushClientManager", "切换环境失败，非法的环境：" + i2);
                Context context = this.f42187i;
                com.vivo.push.util.p.a(context, "切换环境失败，非法的环境：" + i2);
                return;
            }
            a(new ab());
            com.vivo.push.b.g gVar = new com.vivo.push.b.g();
            gVar.b(i2);
            a(gVar);
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            com.vivo.push.util.p.a(z);
            com.vivo.push.b.z zVar = new com.vivo.push.b.z();
            zVar.a(z ? 1 : 0);
            a(zVar);
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 >= 4 && u() < 1260) {
                com.vivo.push.util.p.b("PushClientManager", "current push version " + this.q + " is not support this mode");
                return;
            }
            com.vivo.push.util.p.a((i2 & 1) != 0);
            com.vivo.push.b.z zVar = new com.vivo.push.b.z();
            zVar.a(i2);
            a(zVar);
        }
    }

    public final void a(ArrayList<String> arrayList, IPushActionListener iPushActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, iPushActionListener) == null) {
            Context context = this.f42187i;
            if (context == null) {
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(102);
                    return;
                }
                return;
            }
            ad adVar = new ad(true, null, context.getPackageName(), arrayList);
            adVar.a(500);
            if (this.r) {
                if (!v()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                        return;
                    }
                    return;
                } else if (!a(this.f42185g)) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(1002);
                        return;
                    }
                    return;
                } else {
                    this.f42185g = SystemClock.elapsedRealtime();
                    String a2 = a(new a(adVar, iPushActionListener));
                    adVar.b(a2);
                    if (TextUtils.isEmpty(this.l)) {
                        a(a2, 20001);
                        return;
                    } else if (arrayList.size() < 0) {
                        a(a2, PlayerProps.FFP_PROP_INT64_SELECTED_AUDIO_STREAM);
                        return;
                    } else {
                        if (arrayList.size() + c().size() > 500) {
                            a(a2, PlayerProps.FFP_PROP_INT64_AUDIO_DECODER);
                            return;
                        }
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            if (it.next().length() > 70) {
                                a(a2, PlayerProps.FFP_PROP_INT64_VIDEO_DECODER);
                                return;
                            }
                        }
                        a(adVar);
                        d(a2);
                        return;
                    }
                }
            }
            a(adVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
            }
        }
    }

    public final void a(String str, ArrayList<String> arrayList) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, arrayList) == null) || (context = this.f42187i) == null) {
            return;
        }
        ad adVar = new ad(true, str, context.getPackageName(), arrayList);
        adVar.a(500);
        a(adVar);
    }

    public final void a(Intent intent, PushMessageCallback pushMessageCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, intent, pushMessageCallback) == null) {
            y createReceiverCommand = this.s.createReceiverCommand(intent);
            Context context = a().f42187i;
            if (createReceiverCommand == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                    return;
                }
                return;
            }
            com.vivo.push.c.ab createReceiveTask = this.s.createReceiveTask(createReceiverCommand);
            if (createReceiveTask == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = " + createReceiverCommand);
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
                    return;
                }
                return;
            }
            if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.p)) {
                com.vivo.push.util.p.a(context, "[接收指令]" + createReceiverCommand);
            }
            createReceiveTask.a(pushMessageCallback);
            w.a((v) createReceiveTask);
        }
    }

    public final void a(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yVar) == null) {
            Context context = a().f42187i;
            if (yVar == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                    return;
                }
                return;
            }
            v createTask = this.s.createTask(yVar);
            if (createTask == null) {
                com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = " + yVar);
                if (context != null) {
                    com.vivo.push.util.p.c(context, "[执行指令失败]指令" + yVar + "任务空！");
                    return;
                }
                return;
            }
            com.vivo.push.util.p.d("PushClientManager", "client--sendCommand, command = " + yVar);
            w.a(createTask);
        }
    }
}
