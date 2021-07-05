package d.a.q0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.h0.l.g.d;
import d.a.q0.a.h0.l.g.h;
import d.a.q0.a.h0.l.g.j;
import d.a.q0.a.h0.l.g.o.a;
import d.a.q0.a.h0.u.g;
import d.a.q0.a.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements d.a.q0.a.h0.l.g.b<d.a.q0.a.h0.l.g.a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile b f48243a;

    /* renamed from: b  reason: collision with root package name */
    public volatile b f48244b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<d.a.q0.a.o0.d.a> f48245c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d<d.a.q0.a.h0.l.g.a>> f48246d;

    /* renamed from: e  reason: collision with root package name */
    public b f48247e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f48248f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f48249g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f48250h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48251i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1343265839, "Ld/a/q0/a/h0/l/g/o/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1343265839, "Ld/a/q0/a/h0/l/g/o/c;");
                return;
            }
        }
        k = k.f49133a;
        l = d.a.q0.a.h0.o.e.a.j() == 1;
    }

    public c() {
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
        this.f48245c = new LinkedList<>();
        this.f48246d = new LinkedList();
        this.j = new Object();
        this.f48248f = false;
        this.f48249g = false;
        this.f48251i = false;
        this.f48250h = false;
    }

    @Override // d.a.q0.a.h0.l.g.c
    public void b(d<d.a.q0.a.h0.l.g.a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f48249g) {
                if (k) {
                    Log.d("SwanAppMasterProviderMulti", "app already start , call back immediately");
                }
                dVar.a(this.f48250h, this.f48247e);
                return;
            }
            if (!this.f48246d.contains(dVar)) {
                this.f48246d.add(dVar);
            }
        }
    }

    @Override // d.a.q0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProviderMulti", "get a prefetch event - " + cVar);
            }
            if (!this.f48248f) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "can not prefetch before default mater ready");
                    return;
                }
                return;
            }
            d.a.q0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str)) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.f48249g) {
                        e Q = e.Q();
                        if (Q != null && TextUtils.equals(str, Q.getAppId())) {
                            d.a.q0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                            this.f48247e.r(cVar, pMSAppInfo);
                            return;
                        } else if (k) {
                            Log.w("SwanAppMasterProviderMulti", "can not prefetch after swan app start, only same app allowed");
                            return;
                        } else {
                            return;
                        }
                    }
                    synchronized (this.j) {
                        if (this.f48249g) {
                            return;
                        }
                        if (this.f48244b == null || this.f48244b.w(pMSAppInfo, cVar)) {
                            m(this.f48244b);
                            this.f48244b = l(false, this.f48251i);
                        }
                        this.f48244b.r(cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "prefetch currentAppInfo is empty or appId is empty");
            }
        }
    }

    @Override // d.a.q0.a.h0.l.g.b
    public void d(d.a.q0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || this.f48249g) {
            return;
        }
        synchronized (this.j) {
            this.f48245c.add(aVar);
        }
    }

    @Override // d.a.q0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48243a != null : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f48249g : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48248f : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f48251i : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (this.f48243a == null) {
                synchronized (this.j) {
                    if (this.f48243a == null) {
                        this.f48251i = z;
                        this.f48243a = l(true, z);
                        this.f48243a.c(this);
                        this.f48243a.c(jVar);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "call prepareDefault repeat");
            }
            if (this.f48243a != null) {
                this.f48243a.c(jVar);
            }
        }
    }

    public final void k(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            b bVar2 = bVar == this.f48244b ? this.f48243a : this.f48244b;
            this.f48243a = bVar;
            m(bVar2);
            this.f48244b = null;
        }
    }

    public b l(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            a.c().b(!z);
            return new b(z, z2);
        }
        return (b) invokeCommon.objValue;
    }

    public final void m(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null || bVar.i() == null) {
            return;
        }
        bVar.i().destroy();
        if (k) {
            Log.i("SwanAppMasterProviderMulti", "master destroy, id - " + bVar.i().b() + ", isReady - " + bVar.n() + ", is Default - " + bVar.l());
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.f48245c.isEmpty() && this.f48249g) {
            synchronized (this.j) {
                Iterator<d.a.q0.a.o0.d.a> it = this.f48245c.iterator();
                while (it.hasNext()) {
                    d.a.q0.a.o0.d.a next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProviderMulti", "dispatchPendingEvents event: " + next.f49835a);
                    }
                    g.N().H0(next);
                }
                this.f48245c.clear();
            }
        }
    }

    public final void o(boolean z, b bVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), bVar, pMSAppInfo}) == null) {
            this.f48250h = z;
            this.f48247e = bVar;
            bVar.p(pMSAppInfo);
            this.f48249g = true;
            n();
            k(bVar);
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            q(z, bVar);
            a.c().a();
        }
    }

    @Override // d.a.q0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f48248f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.h0.l.g.c
    /* renamed from: p */
    public b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.f48249g) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProviderMulti", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.f48247e;
        }
        return (b) invokeV.objValue;
    }

    public final void q(boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, bVar) == null) || this.f48246d.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<d.a.q0.a.h0.l.g.a> dVar : this.f48246d) {
                dVar.a(z, bVar);
            }
            this.f48246d.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProviderMulti", "is hit prefetch env - " + z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0128, code lost:
        if (r7 == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:23:0x0065, B:25:0x0069, B:27:0x006d, B:28:0x0076, B:30:0x007c, B:34:0x0088, B:36:0x0091, B:58:0x0135, B:37:0x0095, B:39:0x009d, B:40:0x00a1, B:42:0x00c6, B:47:0x011f, B:54:0x012c, B:55:0x012f, B:56:0x0132, B:59:0x0138), top: B:72:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:23:0x0065, B:25:0x0069, B:27:0x006d, B:28:0x0076, B:30:0x007c, B:34:0x0088, B:36:0x0091, B:58:0x0135, B:37:0x0095, B:39:0x009d, B:40:0x00a1, B:42:0x00c6, B:47:0x011f, B:54:0x012c, B:55:0x012f, B:56:0x0132, B:59:0x0138), top: B:72:0x0065 }] */
    @Override // d.a.q0.a.h0.l.g.c
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if ((pMSAppInfo == null || !this.f48248f) && k) {
                Log.e("SwanAppMasterProviderMulti", Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished")));
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "real start a swan app - " + pMSAppInfo);
                Log.w("SwanAppMasterProviderMulti", "is default master ready - " + this.f48248f);
            }
            if (this.f48249g) {
                return this.f48247e;
            }
            synchronized (this.j) {
                if (!this.f48249g) {
                    if (k) {
                        a.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.f48244b != null && this.f48244b.n() && pMSAppInfo != null) {
                        if (this.f48244b.w(pMSAppInfo, null)) {
                            bVar = this.f48243a;
                            z = false;
                            o(z, bVar, pMSAppInfo);
                        } else {
                            if (this.f48244b.j()) {
                                bVar = this.f48244b;
                            } else {
                                a.C0794a c0794a = new a.C0794a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f2 = a.c().f(c0794a);
                                boolean g2 = a.c().g(c0794a);
                                boolean e2 = a.c().e();
                                if (k) {
                                    Log.d("SwanAppMasterProviderMulti", "app - " + c0794a + ", is loaded - " + f2);
                                    Log.d("SwanAppMasterProviderMulti", "app - " + c0794a + ", is loading - " + g2);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("has loading app now - ");
                                    sb.append(e2);
                                    Log.d("SwanAppMasterProviderMulti", sb.toString());
                                }
                                if (e2 && !g2) {
                                    if (f2 && l) {
                                        bVar = z ? this.f48244b : this.f48243a;
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                if (z) {
                                }
                            }
                            o(z, bVar, pMSAppInfo);
                        }
                    }
                    bVar = this.f48243a;
                    z = false;
                    o(z, bVar, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("final master id - ");
                sb2.append(this.f48247e.i().b());
                Log.i("SwanAppMasterProviderMulti", sb2.toString());
            }
            return this.f48247e;
        }
        return (b) invokeL.objValue;
    }

    @Override // d.a.q0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (k) {
                Log.d("SwanAppMasterProviderMulti", "release master provider");
            }
            this.f48248f = false;
            this.f48249g = false;
            this.f48251i = false;
            this.f48250h = false;
            m(this.f48243a);
            m(this.f48244b);
            this.f48243a = null;
            this.f48244b = null;
            this.f48247e = null;
            synchronized (this.j) {
                this.f48245c.clear();
                this.f48246d.clear();
            }
            d.a.q0.a.h0.l.g.e.c();
            h.b().d();
            a.c().a();
        }
    }
}
