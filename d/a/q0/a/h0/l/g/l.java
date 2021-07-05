package d.a.q0.a.h0.l.g;

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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class l implements b<a>, j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final g f48200a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<d.a.q0.a.o0.d.a> f48201b;

    /* renamed from: c  reason: collision with root package name */
    public final List<d<a>> f48202c;

    /* renamed from: d  reason: collision with root package name */
    public k f48203d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f48204e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f48205f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f48206g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f48207h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48208i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-555587192, "Ld/a/q0/a/h0/l/g/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-555587192, "Ld/a/q0/a/h0/l/g/l;");
                return;
            }
        }
        k = d.a.q0.a.k.f49133a;
        l = 2;
    }

    public l() {
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
        this.f48201b = new LinkedList<>();
        this.f48202c = new LinkedList();
        this.f48200a = new g(l);
        this.j = new Object();
        this.f48204e = false;
        this.f48205f = false;
        this.f48206g = false;
        this.f48208i = false;
        this.f48207h = false;
    }

    @Override // d.a.q0.a.h0.l.g.c
    public void b(d<a> dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f48205f) {
                if (k) {
                    Log.d("SwanAppMasterProvider", "app already start , call back immediately");
                }
                dVar.a(this.f48207h, this.f48203d);
                return;
            }
            if (!this.f48202c.contains(dVar)) {
                this.f48202c.add(dVar);
            }
        }
    }

    @Override // d.a.q0.a.h0.l.g.b
    public void c(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
            }
            d.a.q0.a.e0.d.l(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch currentAppInfo is empty");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str)) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch appId is empty");
                }
            } else if (this.f48205f) {
                d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
                if (Q == null) {
                    return;
                }
                if (TextUtils.equals(str, Q.getAppId())) {
                    d.a.q0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch after app start");
                    this.f48203d.r(cVar, pMSAppInfo);
                    if (k) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str);
                    }
                } else if (k) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            } else if (!this.f48204e) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
                }
            } else {
                synchronized (this.j) {
                    if (this.f48205f) {
                        return;
                    }
                    k d2 = this.f48200a.d(str);
                    if (d2 == null) {
                        d2 = k(false, this.f48208i);
                        this.f48200a.f(d2);
                    }
                    if (d2.w(pMSAppInfo, cVar)) {
                        this.f48200a.c(str);
                        d2 = k(false, this.f48208i);
                        this.f48200a.f(d2);
                    }
                    this.f48200a.g(Collections.singletonList(d2));
                    d2.r(cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // d.a.q0.a.h0.l.g.b
    public void d(d.a.q0.a.o0.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || this.f48205f) {
            return;
        }
        synchronized (this.j) {
            this.f48201b.add(aVar);
        }
    }

    @Override // d.a.q0.a.h0.l.g.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48206g : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.l.g.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f48205f : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.l.g.c
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48204e : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.l.g.b
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f48208i : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.h0.l.g.b
    public void j(boolean z, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, jVar) == null) {
            if (!this.f48206g) {
                synchronized (this.j) {
                    if (!this.f48206g) {
                        this.f48208i = z;
                        k k2 = k(true, z);
                        k2.c(this);
                        k2.c(jVar);
                        this.f48200a.f(k2);
                        this.f48206g = true;
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
            }
            k d2 = this.f48205f ? this.f48203d : this.f48200a.d("_default_id_");
            if (d2 != null) {
                d2.c(jVar);
            }
        }
    }

    public k k(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new k(z, z2) : (k) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.f48201b.isEmpty() && this.f48205f) {
            synchronized (this.j) {
                Iterator<d.a.q0.a.o0.d.a> it = this.f48201b.iterator();
                while (it.hasNext()) {
                    d.a.q0.a.o0.d.a next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.f49835a);
                    }
                    d.a.q0.a.h0.u.g.N().H0(next);
                }
                this.f48201b.clear();
            }
        }
    }

    public final void m(boolean z, k kVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), kVar, pMSAppInfo}) == null) {
            this.f48207h = z;
            this.f48203d = kVar;
            kVar.p(pMSAppInfo);
            this.f48205f = true;
            l();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.f48200a.a(Collections.singletonList(kVar));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            o(z, kVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.h0.l.g.c
    /* renamed from: n */
    public k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f48205f) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.f48203d;
        }
        return (k) invokeV.objValue;
    }

    public final void o(boolean z, k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, kVar) == null) || this.f48202c.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (d<a> dVar : this.f48202c) {
                dVar.a(z, kVar);
            }
            this.f48202c.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProvider", "is hit prefetch env - " + z);
        }
    }

    @Override // d.a.q0.a.h0.l.g.j
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f48204e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.h0.l.g.c
    /* renamed from: p */
    public k e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        k d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (pMSAppInfo == null && k) {
                Log.e("SwanAppMasterProvider", Log.getStackTraceString(new Exception("currentAppInfo can not be null")));
            }
            if (k) {
                Log.w("SwanAppMasterProvider", "real start a swan app - " + pMSAppInfo);
            }
            if (!this.f48204e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f48205f) {
                return this.f48203d;
            }
            synchronized (this.j) {
                if (!this.f48205f) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(str) && pMSAppInfo != null) {
                        d2 = this.f48200a.d(str);
                        if (d2 == null || !d2.n() || d2.w(pMSAppInfo, null)) {
                            d2 = this.f48200a.d("_default_id_");
                        } else {
                            z = true;
                        }
                        m(z, d2, pMSAppInfo);
                    }
                    d2 = this.f48200a.d("_default_id_");
                    m(z, d2, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb = new StringBuilder();
                sb.append("final master id - ");
                sb.append(this.f48203d.i().b());
                Log.i("SwanAppMasterProvider", sb.toString());
            }
            return this.f48203d;
        }
        return (k) invokeL.objValue;
    }

    @Override // d.a.q0.a.h0.l.g.c
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f48204e = false;
            this.f48205f = false;
            this.f48206g = false;
            this.f48208i = false;
            this.f48207h = false;
            this.f48203d = null;
            this.f48200a.a(null);
            synchronized (this.j) {
                this.f48201b.clear();
                this.f48202c.clear();
            }
            e.c();
            h.b().d();
        }
    }
}
