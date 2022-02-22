package com.kuaishou.weapon.un;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.kuaishou.weapon.IWeaponInitParams;
import com.kuaishou.weapon.WeaponRECE;
import com.kuaishou.weapon.i.WeaponCB;
import com.kuaishou.weapon.i.WeaponI;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static n f55376j = null;
    public static int k = 0;
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 4;
    public static final int s = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f55377b;

    /* renamed from: c  reason: collision with root package name */
    public com.kuaishou.weapon.un.d f55378c;

    /* renamed from: d  reason: collision with root package name */
    public Context f55379d;

    /* renamed from: e  reason: collision with root package name */
    public x f55380e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f55381f;

    /* renamed from: g  reason: collision with root package name */
    public HandlerThread f55382g;

    /* renamed from: h  reason: collision with root package name */
    public int f55383h;

    /* renamed from: i  reason: collision with root package name */
    public IWeaponInitParams f55384i;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WeaponCB a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f55385b;

        public a(n nVar, WeaponCB weaponCB) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, weaponCB};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55385b = nVar;
            this.a = weaponCB;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55385b.a(true, this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(true, (WeaponCB) null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f55378c.a(com.kuaishou.weapon.un.d.f55253j, 0L);
                this.a.a(false, (WeaponCB) null);
                n.b(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Comparator<p> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f55386b;

        public d(n nVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55386b = nVar;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(p pVar, p pVar2) {
            InterceptResult invokeLL;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pVar, pVar2)) == null) {
                if (pVar.y != -1 || pVar2.y == -1) {
                    if ((pVar.y == -1 || pVar2.y != -1) && (i2 = pVar.y) >= (i3 = pVar2.y)) {
                        if (i2 > i3) {
                            return 1;
                        }
                        List list = this.a;
                        int indexOf = (list == null || !list.contains(Integer.valueOf(pVar.a))) ? -1 : this.a.indexOf(Integer.valueOf(pVar.a));
                        List list2 = this.a;
                        int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(pVar2.a))) ? -1 : this.a.indexOf(Integer.valueOf(pVar2.a));
                        if (indexOf == -1 || indexOf2 != -1) {
                            if ((indexOf != -1 || indexOf2 == -1) && indexOf <= indexOf2) {
                                return indexOf < indexOf2 ? -1 : 0;
                            }
                            return 1;
                        }
                        return -1;
                    }
                    return -1;
                }
                return 1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f55387b;

        /* loaded from: classes3.dex */
        public class a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ p f55388b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f55389c;

            public a(e eVar, o oVar, p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, oVar, pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55389c = eVar;
                this.a = oVar;
                this.f55388b = pVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.e(this.f55389c.a);
                    this.f55389c.f55387b.f55380e.a(this.f55389c.a);
                    File file = new File(this.f55388b.f55408e);
                    if (file.exists()) {
                        com.kuaishou.weapon.un.b.a(file);
                        file.delete();
                    }
                }
            }
        }

        public e(n nVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55387b = nVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            o a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (TextUtils.isEmpty(this.a) || (a2 = o.a(this.f55387b.f55379d.getApplicationContext(), true)) == null) {
                        return;
                    }
                    p a3 = a2.a(this.a);
                    if (a3 == null) {
                        p b2 = this.f55387b.f55380e.b(this.a);
                        if (b2 != null) {
                            this.f55387b.a(this.a, b2.f55408e);
                            return;
                        }
                        return;
                    }
                    Class<?> a4 = ((q) a3.f55410g).a(a3.f55406c + r1.f55448f);
                    Object invoke = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, this.f55387b.f55379d);
                    if (invoke == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("e", q0.s);
                        hashMap.put("l", "CBH");
                        hashMap.put("pkg", this.a);
                        l1.a(this.f55387b.f55379d, "1002001", hashMap);
                        return;
                    }
                    new Timer().schedule(new a(this, a2, a3), 600000L);
                    l1.a(invoke, "unload", null, new Object[0]);
                    a2.e(this.a);
                    this.f55387b.f55380e.a(this.a);
                    File file = new File(a3.f55408e);
                    if (file.exists()) {
                        com.kuaishou.weapon.un.b.a(file);
                        file.delete();
                    }
                } catch (Throwable th) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("e", th.getMessage());
                    hashMap2.put("l", "CBH");
                    hashMap2.put("c", q0.t);
                    l1.a(th);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WeaponCB f55390b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f55391c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Class[] f55392d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object[] f55393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n f55394f;

        public f(n nVar, int i2, WeaponCB weaponCB, String str, Class[] clsArr, Object[] objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {nVar, Integer.valueOf(i2), weaponCB, str, clsArr, objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55394f = nVar;
            this.a = i2;
            this.f55390b = weaponCB;
            this.f55391c = str;
            this.f55392d = clsArr;
            this.f55393e = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f55394f.f55380e.d(this.a)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (this.f55394f.f55380e.d(this.a) && System.currentTimeMillis() - currentTimeMillis < 5000) {
                            SystemClock.sleep(500L);
                        }
                    }
                    if (!this.f55394f.a) {
                        n.c(2);
                        this.f55394f.d();
                    }
                    o a = o.a(this.f55394f.f55379d.getApplicationContext(), true);
                    p pVar = null;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    while (System.currentTimeMillis() - currentTimeMillis2 <= 200000) {
                        pVar = this.f55394f.f55380e.b(this.a);
                        if (pVar != null) {
                            if (a.a(pVar.f55406c) != null) {
                                z = true;
                                break;
                            } else if (pVar.f55405b == -1) {
                                break;
                            }
                        }
                        SystemClock.sleep(2000L);
                    }
                    z = false;
                    if (!z) {
                        if (this.f55390b != null) {
                            this.f55390b.onHappenError(4);
                            return;
                        }
                        return;
                    }
                    p a2 = a.a(pVar.f55406c);
                    Object a3 = l1.a(((q) a2.f55410g).a(a2.f55406c + r1.f55448f).getDeclaredMethod("getInstance", Context.class).invoke(this.f55390b, this.f55394f.f55379d), this.f55391c, this.f55392d, this.f55393e);
                    if (this.f55390b != null) {
                        this.f55390b.onEndTask(a3);
                    }
                } catch (Throwable th) {
                    l1.a(th);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1645309960, "Lcom/kuaishou/weapon/un/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1645309960, "Lcom/kuaishou/weapon/un/n;");
        }
    }

    public n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f55377b = false;
        this.f55382g = new HandlerThread("pluginFKHandlerThread");
        this.f55383h = 0;
        this.f55379d = context;
        this.f55378c = new com.kuaishou.weapon.un.d(context);
        this.f55380e = x.a(context);
    }

    public static synchronized n a(Context context) {
        InterceptResult invokeL;
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (n.class) {
                try {
                    if (f55376j == null) {
                        f55376j = new n(context);
                    }
                    nVar = f55376j;
                } catch (Exception e2) {
                    e2.getMessage();
                    return null;
                }
            }
            return nVar;
        }
        return (n) invokeL.objValue;
    }

    private synchronized boolean a(int i2, String str, String str2, boolean z, PackageInfo packageInfo) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), str, str2, Boolean.valueOf(z), packageInfo})) == null) {
            synchronized (this) {
                if (z) {
                    if (this.f55380e.c(i2) != 1) {
                        return false;
                    }
                }
                p b2 = this.f55380e.b(i2);
                if (b2 == null) {
                    this.f55380e.c(i2, -1);
                    HashMap hashMap = new HashMap();
                    hashMap.put(PushConstants.URI_PACKAGE_NAME, i2 + "");
                    hashMap.put("pv", str);
                    hashMap.put("e", q0.u);
                    l1.a(this.f55379d, "1002001", hashMap);
                    return false;
                } else if (!l1.a(new File(b2.f55408e))) {
                    this.f55380e.c(i2, -1);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(PushConstants.URI_PACKAGE_NAME, i2 + "");
                    hashMap2.put("pv", str);
                    hashMap2.put("e", q0.v);
                    hashMap2.put("l", "CBH");
                    l1.a(this.f55379d, "1002001", hashMap2);
                    return false;
                } else {
                    if (packageInfo != null) {
                        b2.s = packageInfo;
                    }
                    o a2 = o.a(this.f55379d.getApplicationContext(), true);
                    if (!a2.a(b2, false)) {
                        this.f55380e.c(i2, -1);
                        a2.f(b2.f55408e);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put(PushConstants.URI_PACKAGE_NAME, i2 + "");
                        hashMap3.put("pv", str);
                        hashMap3.put("e", q0.w);
                        hashMap3.put("l", "CBH");
                        l1.a(this.f55379d, "1002001", hashMap3);
                        f55376j.f();
                        return false;
                    }
                    String[] a3 = l1.a(this.f55379d);
                    if (a3 == null || a3.length != 2 || TextUtils.isEmpty(a3[0]) || TextUtils.isEmpty(a3[1])) {
                        str3 = "16";
                        str4 = l1.f55363d;
                    } else {
                        str3 = a3[0];
                        str4 = a3[1];
                    }
                    p b3 = a2.b(b2.f55408e);
                    q qVar = (q) b3.f55410g;
                    Class<?> a4 = qVar.a(b3.f55406c + r1.f55448f);
                    if (a4 == null) {
                        qVar.a("java.lang.String");
                        this.f55380e.c(i2, -1);
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put(PushConstants.URI_PACKAGE_NAME, i2 + "");
                        hashMap4.put("pv", str);
                        hashMap4.put("e", q0.x);
                        hashMap4.put("l", "CBH");
                        l1.a(this.f55379d, "1002001", hashMap4);
                        return false;
                    }
                    Object invoke = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, this.f55379d);
                    l1.a(invoke, "setWeaponSecurityVerifyInfo", new Class[]{String.class, String.class, String.class, String.class, String.class}, str3, str4, "2.8.3", l1.g(this.f55379d), l1.l());
                    if (this.f55378c.a(com.kuaishou.weapon.un.d.g0, 0) == 1) {
                        String b4 = l1.b();
                        if (!TextUtils.isEmpty(b4)) {
                            l1.a(invoke, "setWeaponInfo", new Class[]{String.class}, b4);
                        }
                    }
                    if (((Boolean) l1.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE, Object.class}, Integer.valueOf(b3.x), Boolean.valueOf(this.f55378c.b(com.kuaishou.weapon.un.d.K)), null)).booleanValue()) {
                        b3.f55405b = 1;
                        b3.p = 1;
                        this.f55380e.a(b3);
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException e2) {
                            l1.a(e2);
                        }
                        return true;
                    }
                    this.f55380e.c(i2, -1);
                    a2.f(b3.f55408e);
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put(PushConstants.URI_PACKAGE_NAME, i2 + "");
                    hashMap5.put("pv", str);
                    hashMap5.put("e", q0.y);
                    hashMap5.put("l", "CBH");
                    l1.a(this.f55379d, "1002001", hashMap5);
                    return false;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public static /* synthetic */ int b(n nVar) {
        int i2 = nVar.f55383h;
        nVar.f55383h = i2 + 1;
        return i2;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            try {
                com.kuaishou.weapon.un.d dVar = new com.kuaishou.weapon.un.d(context);
                long g2 = dVar.g();
                long currentTimeMillis = (System.currentTimeMillis() - g2) - (dVar.b(com.kuaishou.weapon.un.d.V, 12) * 3600000);
                if (g2 < 1 || currentTimeMillis > 0) {
                    t1.a().a(new u0(context));
                }
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            k = i2;
        }
    }

    public static int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? k : invokeV.intValue;
    }

    public static n i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f55376j : (n) invokeV.objValue;
    }

    public synchronized void a() {
        o c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                try {
                    c2 = o.c();
                } catch (Throwable th) {
                    l1.a(th);
                }
                if (c2 == null) {
                    return;
                }
                new n0(this.f55379d).a();
                for (p pVar : c2.a()) {
                    p a2 = c2 != null ? c2.a(pVar.f55406c) : null;
                    if (a2 != null && !TextUtils.isEmpty(a2.f55406c) && a2.f55406c.contains(ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT)) {
                        Class loadClass = ((q) a2.f55410g).loadClass(a2.f55406c + r1.f55449g);
                        ((WeaponI) loadClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClass, this.f55379d)).a();
                    }
                }
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            try {
                p b2 = this.f55380e.b(i2);
                if (b2 == null) {
                    return;
                }
                this.f55380e.a(i2);
                File file = new File(b2.f55408e);
                if (file.exists()) {
                    com.kuaishou.weapon.un.b.a(file);
                    file.delete();
                }
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            a(i2, str, (WeaponCB) null);
        }
    }

    public void a(int i2, String str, WeaponCB weaponCB) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, weaponCB) == null) {
            a(i2, str, weaponCB, (Class<?>[]) null, new Object[0]);
        }
    }

    public void a(int i2, String str, WeaponCB weaponCB, Class<?>[] clsArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, weaponCB, clsArr, objArr}) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    t1.a().a(new f(this, i2, weaponCB, str, clsArr, objArr));
                } else if (weaponCB != null) {
                    weaponCB.onHappenError(1);
                }
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void a(int i2, String str, Class<?>[] clsArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), str, clsArr, objArr}) == null) {
            a(i2, str, (WeaponCB) null, clsArr, objArr);
        }
    }

    public void a(IWeaponInitParams iWeaponInitParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iWeaponInitParams) == null) {
            this.f55384i = iWeaponInitParams;
        }
    }

    public synchronized void a(WeaponCB weaponCB) {
        String[] a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, weaponCB) == null) {
            synchronized (this) {
                try {
                    a2 = l1.a(this.f55379d);
                } catch (Throwable th) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("e", th.getMessage());
                    hashMap.put("l", "CBH");
                    l1.a(this.f55379d, "1002001", hashMap);
                    l1.a(th);
                }
                if (a2 != null && a2.length == 2 && !TextUtils.isEmpty(a2[0]) && !TextUtils.isEmpty(a2[1])) {
                    if (this.a) {
                        if (weaponCB != null) {
                            weaponCB.onEndTask(new Object[0]);
                        }
                        return;
                    }
                    this.a = true;
                    this.f55378c.b(com.kuaishou.weapon.un.d.f55252i, "2.8.3");
                    b(this.f55379d);
                    if (this.f55378c.a(com.kuaishou.weapon.un.d.g0, 0) == 1) {
                        String b2 = l1.b();
                        if (!TextUtils.isEmpty(b2)) {
                            r0.a(b2);
                        }
                    }
                    new t0(this.f55379d).a();
                    new d0(this.f55379d).a();
                    v.a(this.f55379d);
                    WeaponRECE weaponRECE = new WeaponRECE();
                    IntentFilter intentFilter = new IntentFilter(PackageChangedReceiver.ACTION_UNINSTALL);
                    intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                    intentFilter.addDataScheme("package");
                    this.f55379d.registerReceiver(weaponRECE, intentFilter);
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    this.f55379d.registerReceiver(weaponRECE, intentFilter2);
                    if (this.f55382g != null) {
                        this.f55382g.start();
                        this.f55381f = new Handler(this.f55382g.getLooper());
                    }
                    this.f55381f.removeCallbacksAndMessages(null);
                    this.f55381f.postDelayed(new a(this, weaponCB), 5000L);
                    return;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("e", q0.o);
                l1.a(this.f55379d, "1002001", hashMap2);
            }
        }
    }

    public synchronized void a(String str) {
        o c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            synchronized (this) {
                try {
                    c2 = o.c();
                } catch (Throwable th) {
                    l1.a(th);
                }
                if (c2 == null) {
                    return;
                }
                for (p pVar : c2.a()) {
                    p a2 = c2 != null ? c2.a(pVar.f55406c) : null;
                    if (a2 != null && !TextUtils.isEmpty(a2.f55406c) && a2.f55406c.contains(ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT)) {
                        Class<?> a3 = ((q) a2.f55410g).a(a2.f55406c + r1.f55448f);
                        Object invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, this.f55379d);
                        if (!TextUtils.isEmpty(str)) {
                            l1.a(invoke, "setWeaponInfo", new Class[]{String.class}, str);
                        }
                    }
                }
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            this.f55380e.a(str);
            File file = new File(str2);
            if (file.exists()) {
                com.kuaishou.weapon.un.b.a(file);
                file.delete();
            }
        }
    }

    public synchronized void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048586, this, str, str2, str3, str4, str5) == null) {
            synchronized (this) {
                try {
                    for (p pVar : this.f55380e.b()) {
                        o c2 = o.c();
                        p a2 = c2 != null ? c2.a(pVar.f55406c) : null;
                        if (a2 != null && !TextUtils.isEmpty(a2.f55406c) && a2.f55406c.contains(ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT)) {
                            Class loadClass = ((q) a2.f55410g).loadClass(a2.f55406c + r1.f55449g);
                            ((WeaponI) loadClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClass, this.f55379d)).b(str, str2, str3, str4, str5);
                        }
                    }
                } catch (Throwable th) {
                    l1.a(th);
                }
            }
        }
    }

    public synchronized void a(boolean z, WeaponCB weaponCB) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, weaponCB) == null) {
            synchronized (this) {
                if (this.f55377b && z) {
                    return;
                }
                this.f55377b = true;
                if (z) {
                    for (p pVar : this.f55380e.b()) {
                        String canonicalPath = this.f55379d.getFilesDir().getCanonicalPath();
                        if (canonicalPath != null) {
                            pVar.m = canonicalPath + r1.k + pVar.a;
                            StringBuilder sb = new StringBuilder();
                            sb.append(pVar.m);
                            sb.append("/lib");
                            l1.b(sb.toString());
                            l1.c(pVar.m);
                        }
                    }
                    new o0(this.f55379d).a();
                }
                this.f55380e.a();
                if (this.f55378c.b(com.kuaishou.weapon.un.d.l)) {
                    this.f55380e.g();
                } else {
                    this.f55378c.a(com.kuaishou.weapon.un.d.l, Boolean.TRUE);
                }
                t1.a().a(new v0(this.f55379d, 1, false));
                if (weaponCB != null) {
                    weaponCB.onEndTask(new Object[0]);
                }
            }
        }
    }

    public synchronized boolean a(int i2, String str, PackageInfo packageInfo) {
        InterceptResult invokeILL;
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048588, this, i2, str, packageInfo)) == null) {
            synchronized (this) {
                a2 = a(i2, str, (String) null, false, packageInfo);
            }
            return a2;
        }
        return invokeILL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021a A[Catch: Exception -> 0x0292, TRY_LEAVE, TryCatch #7 {Exception -> 0x0292, blocks: (B:63:0x01e8, B:65:0x021a, B:61:0x01c7), top: B:114:0x01c7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(p pVar, String str, String str2) {
        InterceptResult invokeLLL;
        File file;
        p pVar2;
        String str3;
        String str4;
        HashMap hashMap;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, pVar, str, str2)) == null) {
            if (pVar == null) {
                hashMap = new HashMap();
                str5 = q0.B;
            } else {
                File file2 = new File(pVar.f55408e);
                if (l1.a(file2)) {
                    try {
                        if (!this.f55380e.f(pVar.a)) {
                            try {
                                this.f55380e.a(pVar);
                            } catch (Exception e2) {
                                e = e2;
                                pVar2 = pVar;
                                file = file2;
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("e", e.getMessage());
                                hashMap2.put("l", "CBH");
                                hashMap2.put("apk", pVar2.toString());
                                l1.a(this.f55379d, "1002001", hashMap2);
                                l1.a(e);
                                try {
                                    com.kuaishou.weapon.un.b.a(file);
                                    c(pVar2.f55406c);
                                    file.delete();
                                    this.f55380e.b(pVar2.a, 0);
                                    return false;
                                } catch (Throwable th) {
                                    l1.a(th);
                                    return false;
                                }
                            }
                        }
                        o a2 = o.a(this.f55379d.getApplicationContext(), true);
                        this.f55380e.b(pVar.a, 1);
                        c(pVar.f55406c);
                        if (!a2.a(pVar, true)) {
                            com.kuaishou.weapon.un.b.a(file2);
                            file2.delete();
                            a(pVar.a, pVar.f55407d, (String) null, true, (PackageInfo) null);
                            this.f55380e.b(pVar.a, 0);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("e", q0.E);
                            hashMap3.put("l", "CBH");
                            hashMap3.put("apk", pVar.toString());
                            l1.a(this.f55379d, "1002001", hashMap3);
                            return false;
                        }
                        String[] a3 = l1.a(this.f55379d);
                        if (a3 == null || a3.length != 2 || TextUtils.isEmpty(a3[0]) || TextUtils.isEmpty(a3[1])) {
                            str3 = "16";
                            str4 = l1.f55363d;
                        } else {
                            str3 = a3[0];
                            str4 = a3[1];
                        }
                        pVar2 = a2.b(pVar.f55408e);
                        try {
                            if (pVar2 == null) {
                                this.f55380e.b(pVar2.a, 0);
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("e", q0.C);
                                hashMap4.put("l", "CBH");
                                l1.a(this.f55379d, "1002001", hashMap4);
                                return false;
                            }
                            Class<?> a4 = ((q) pVar2.f55410g).a(pVar2.f55406c + r1.f55448f);
                            if (a4 == null) {
                                com.kuaishou.weapon.un.b.a(file2);
                                file2.delete();
                                this.f55380e.b(pVar2.a, 0);
                                HashMap hashMap5 = new HashMap();
                                hashMap5.put("e", q0.F);
                                hashMap5.put("l", "CBH");
                                hashMap5.put("apk", pVar2.toString());
                                l1.a(this.f55379d, "1002001", hashMap5);
                                return false;
                            }
                            Object invoke = a4.getDeclaredMethod("getInstance", Context.class).invoke(a4, this.f55379d);
                            if (invoke == null) {
                                HashMap hashMap6 = new HashMap();
                                hashMap6.put("e", q0.G);
                                hashMap6.put("l", "CBH");
                                hashMap6.put("apk", pVar2.toString());
                                l1.a(this.f55379d, "1002001", hashMap6);
                                return false;
                            }
                            try {
                                file = file2;
                                try {
                                    l1.a(invoke, "setWeaponSecurityVerifyInfo", new Class[]{String.class, String.class, String.class, String.class, String.class}, str3, str4, "2.8.3", l1.g(this.f55379d), l1.l());
                                    if (this.f55378c.a(com.kuaishou.weapon.un.d.g0, 0) == 1) {
                                        String b2 = l1.b();
                                        if (!TextUtils.isEmpty(b2)) {
                                            l1.a(invoke, "setWeaponInfo", new Class[]{String.class}, b2);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        HashMap hashMap7 = new HashMap();
                                        hashMap7.put("e", th.getMessage());
                                        hashMap7.put("l", "CBH");
                                        hashMap7.put("apk", pVar2.toString());
                                        l1.a(this.f55379d, "1002001", hashMap7);
                                        l1.a(th);
                                        File file3 = null;
                                        if (((Boolean) l1.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE, Object.class}, Integer.valueOf(pVar2.x), Boolean.FALSE, null)).booleanValue()) {
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        HashMap hashMap22 = new HashMap();
                                        hashMap22.put("e", e.getMessage());
                                        hashMap22.put("l", "CBH");
                                        hashMap22.put("apk", pVar2.toString());
                                        l1.a(this.f55379d, "1002001", hashMap22);
                                        l1.a(e);
                                        com.kuaishou.weapon.un.b.a(file);
                                        c(pVar2.f55406c);
                                        file.delete();
                                        this.f55380e.b(pVar2.a, 0);
                                        return false;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                file = file2;
                            }
                            File file32 = null;
                            if (((Boolean) l1.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE, Object.class}, Integer.valueOf(pVar2.x), Boolean.FALSE, null)).booleanValue()) {
                                com.kuaishou.weapon.un.b.a(file);
                                c(pVar2.f55406c);
                                file.delete();
                                this.f55380e.b(pVar2.a, 0);
                                HashMap hashMap8 = new HashMap();
                                hashMap8.put("e", q0.H);
                                hashMap8.put("l", "CBH");
                                hashMap8.put("apk", pVar2.toString());
                                l1.a(this.f55379d, "1002001", hashMap8);
                                return false;
                            }
                            try {
                                p b3 = this.f55380e.b(pVar2.a);
                                if (b3 != null && !b3.f55407d.equals(pVar2.f55407d)) {
                                    file32 = new File(b3.f55408e);
                                }
                                pVar2.f55405b = 1;
                                pVar2.p = 1;
                                if (this.f55380e.a(pVar2) > 0 && file32 != null && file32.exists()) {
                                    com.kuaishou.weapon.un.b.a(file32);
                                    file32.delete();
                                }
                                this.f55380e.b(pVar2.a, 0);
                                return true;
                            } catch (Throwable th4) {
                                l1.a(th4);
                                return false;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            file = file2;
                            HashMap hashMap222 = new HashMap();
                            hashMap222.put("e", e.getMessage());
                            hashMap222.put("l", "CBH");
                            hashMap222.put("apk", pVar2.toString());
                            l1.a(this.f55379d, "1002001", hashMap222);
                            l1.a(e);
                            com.kuaishou.weapon.un.b.a(file);
                            c(pVar2.f55406c);
                            file.delete();
                            this.f55380e.b(pVar2.a, 0);
                            return false;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        file = file2;
                        pVar2 = pVar;
                    }
                } else {
                    hashMap = new HashMap();
                    str5 = q0.D;
                }
            }
            hashMap.put("e", str5);
            hashMap.put("l", "CBH");
            l1.a(this.f55379d, "1002001", hashMap);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public IWeaponInitParams b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f55384i : (IWeaponInitParams) invokeV.objValue;
    }

    public synchronized void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            synchronized (this) {
                try {
                    for (p pVar : this.f55380e.b()) {
                        o c2 = o.c();
                        p a2 = c2 != null ? c2.a(pVar.f55406c) : null;
                        if (a2 != null && !TextUtils.isEmpty(a2.f55406c) && a2.f55406c.contains(ZeusPerformanceTiming.KEY_WEBVIEWCHROMIUM_CONSTRUCT)) {
                            Class loadClass = ((q) a2.f55410g).loadClass(a2.f55406c + r1.f55449g);
                            ((WeaponI) loadClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClass, this.f55379d)).e(i2);
                        }
                    }
                } catch (Throwable th) {
                    l1.a(th);
                }
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            try {
                t1.a().a(new e(this, str));
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        l1.d(str, str2);
        this.f55378c.c(str, str2);
    }

    public com.kuaishou.weapon.un.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f55378c : (com.kuaishou.weapon.un.d) invokeV.objValue;
    }

    public void c(String str) {
        o c2;
        p a2;
        q qVar;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            try {
                if (TextUtils.isEmpty(str) || (c2 = o.c()) == null || (a2 = c2.a(str)) == null || (qVar = (q) a2.f55410g) == null) {
                    return;
                }
                Class<?> a3 = qVar.a(a2.f55406c + r1.f55448f);
                if (a3 == null || (invoke = a3.getDeclaredMethod("getInstance", Context.class).invoke(a3, this.f55379d)) == null) {
                    return;
                }
                l1.a(invoke, "unload", null, new Object[0]);
                c2.e(str);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            a((WeaponCB) null);
        }
    }

    public void e() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (handler = this.f55381f) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.f55381f.post(new b(this));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                if (this.f55378c.b(com.kuaishou.weapon.un.d.W, 0) != 1) {
                    return;
                }
                int b2 = this.f55378c.b(com.kuaishou.weapon.un.d.X, 3);
                int b3 = this.f55378c.b(com.kuaishou.weapon.un.d.Y, 15);
                if (this.f55381f == null) {
                    return;
                }
                if (this.f55383h >= b2) {
                    this.f55381f.removeCallbacksAndMessages(null);
                    return;
                }
                this.f55381f.removeCallbacksAndMessages(null);
                this.f55381f.postDelayed(new c(this), b3 * 60000);
            } catch (Exception unused) {
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            List<p> b2 = this.f55380e.b();
            List<Integer> b3 = this.f55378c.b();
            List<Integer> j2 = this.f55378c.j();
            for (int i2 = 0; i2 < b3.size(); i2++) {
                if (!j2.contains(b3.get(i2))) {
                    j2.add(b3.get(i2));
                }
            }
            Collections.sort(b2, new d(this, j2));
            for (p pVar : b2) {
                o c2 = o.c();
                if ((c2 != null ? c2.a(pVar.f55406c) : null) == null) {
                    if (this.f55378c.d()) {
                        File file = new File(this.f55379d.getFilesDir(), r1.f55452j);
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(pVar.f55408e);
                        File file3 = new File(file, pVar.a + "-" + pVar.f55407d);
                        if (!l1.a(file3)) {
                            l1.a(file2, file3);
                        }
                        com.kuaishou.weapon.un.b.a(file2, file3);
                    }
                    a(pVar.a, pVar.f55407d, (PackageInfo) null);
                }
            }
        }
    }
}
