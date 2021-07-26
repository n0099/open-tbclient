package d.a.o0.a.h0.l.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a1.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.a.h0.l.a f45377a;

    /* renamed from: b  reason: collision with root package name */
    public final List<j> f45378b;

    /* renamed from: c  reason: collision with root package name */
    public volatile PMSAppInfo f45379c;

    /* renamed from: d  reason: collision with root package name */
    public volatile PrefetchEvent.c f45380d;

    /* renamed from: e  reason: collision with root package name */
    public volatile i f45381e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f45382f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f45383g;

    /* renamed from: h  reason: collision with root package name */
    public long f45384h;

    /* renamed from: i  reason: collision with root package name */
    public long f45385i;
    public final boolean j;

    /* renamed from: d.a.o0.a.h0.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0747a extends d.a.o0.a.h0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45386a;

        public C0747a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45386a = aVar;
        }

        @Override // d.a.o0.a.h0.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (a.k) {
                    Log.d("BasePreloadMasterManager", "prepareMaster finish. url: " + str);
                }
                this.f45386a.f45383g = true;
                this.f45386a.f45385i = System.currentTimeMillis();
                this.f45386a.o();
                if (a.k) {
                    Log.d("BasePreloadMasterManager", "createBlankOne cost - " + this.f45386a.f() + "ms");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PMSAppInfo f45387a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent.c f45388b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f45389c;

        public b(a aVar, PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, pMSAppInfo, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45389c = aVar;
            this.f45387a = pMSAppInfo;
            this.f45388b = cVar;
        }

        @Override // d.a.o0.a.h0.l.g.j
        public void onReady() {
            d.a.o0.a.h0.l.a i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f45389c.i()) == null || i2.g() == null || i2.g().isDestroyed()) {
                return;
            }
            this.f45389c.q(this.f45387a);
            d.a.o0.a.o0.a.a(i2.g(), this.f45388b);
            d.a.o0.a.e0.d.l(PrefetchEvent.MODULE, "prefetch master finish - " + this.f45388b.toString());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(455529717, "Ld/a/o0/a/h0/l/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(455529717, "Ld/a/o0/a/h0/l/g/a;");
                return;
            }
        }
        k = d.a.o0.a.k.f46335a;
    }

    public a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45378b = new ArrayList();
        this.j = z2;
        this.f45382f = z;
        e();
    }

    public synchronized void c(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            synchronized (this) {
                if (jVar == null) {
                    return;
                }
                if (this.f45383g) {
                    if (k) {
                        Log.d("BasePreloadMasterManager", "is Ready , call back immediately");
                    }
                    jVar.onReady();
                    return;
                }
                if (!this.f45378b.contains(jVar)) {
                    this.f45378b.add(jVar);
                }
            }
        }
    }

    public void d(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
            this.f45379c = pMSAppInfo;
            h.b().c(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (k) {
                Log.d("BasePreloadMasterManager", "start create a blank preload master manager, is default - " + this.f45382f + ",is v8 - " + this.j);
            }
            this.f45384h = System.currentTimeMillis();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.f45377a = d.a.o0.a.h0.u.g.N().t0(this.j, new C0747a(this));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("BasePreloadMasterManager", "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45385i - this.f45384h : invokeV.longValue;
    }

    public PMSAppInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45379c : (PMSAppInfo) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f45379c != null) {
                return this.f45379c.appId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public d.a.o0.a.h0.l.a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45377a : (d.a.o0.a.h0.l.a) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f45381e != null : invokeV.booleanValue;
    }

    public boolean k(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar, pMSAppInfo)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f45382f : invokeV.booleanValue;
    }

    public boolean m(PrefetchEvent.c cVar, PrefetchEvent.c cVar2) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cVar, cVar2)) == null) {
            if (cVar2 == null) {
                return false;
            }
            if (cVar == null) {
                d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
                str = Q != null ? Q.J().e("dynamicLibPath", null) : null;
            } else {
                str = cVar.h().get("dynamicLibPath");
            }
            String str2 = cVar2.h().get("dynamicLibPath");
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            return !TextUtils.equals(TextUtils.isEmpty(str2) ? null : str2, str);
        }
        return invokeLL.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f45383g : invokeV.booleanValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.d("BasePreloadMasterManager", "notifyAllReady, callback size " + this.f45378b.size());
                }
                for (j jVar : this.f45378b) {
                    if (jVar != null) {
                        jVar.onReady();
                    }
                }
                this.f45378b.clear();
            }
        }
    }

    public void p(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pMSAppInfo) == null) {
            d(pMSAppInfo);
            this.f45381e = null;
            this.f45380d = null;
        }
    }

    public void q(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pMSAppInfo) == null) {
            v(pMSAppInfo);
            d.a.o0.a.h0.q.a.e(pMSAppInfo.appId);
        }
    }

    public void r(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, cVar, pMSAppInfo) == null) {
            if (cVar == null) {
                if (k) {
                    Log.e("BasePreloadMasterManager", "prefetch event is null");
                }
            } else if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                if (this.f45377a == null) {
                    if (k) {
                        Log.i("BasePreloadMasterManager", "mMasterManager not create yet, can not prefetch");
                    }
                } else if (l() && this.f45379c == null) {
                    if (k) {
                        Log.i("BasePreloadMasterManager", "default blank master can not use to prefetch");
                    }
                } else if (k(cVar, pMSAppInfo)) {
                } else {
                    d(pMSAppInfo);
                    s(cVar);
                    t(cVar, pMSAppInfo);
                    u(cVar, pMSAppInfo);
                }
            } else if (k) {
                Log.e("BasePreloadMasterManager", "prefetch currentAppInfo is empty");
            }
        }
    }

    public void s(PrefetchEvent.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.f45380d = cVar;
            if (k) {
                Log.d("BasePreloadMasterManager", "fire prefetch event name - " + cVar.f47037a);
            }
        }
    }

    public final void t(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, cVar, pMSAppInfo) == null) && cVar.i()) {
            this.f45381e = new i();
            this.f45381e.f45399a = pMSAppInfo.appId;
            this.f45381e.f45400b = pMSAppInfo;
            this.f45381e.f45401c = cVar;
        }
    }

    public void u(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, cVar, pMSAppInfo) == null) {
            c(new b(this, pMSAppInfo, cVar));
            if (k) {
                Log.i("BasePreloadMasterManager", "fire prefetch event - " + pMSAppInfo.appId + ", version -" + pMSAppInfo.versionCode);
            }
        }
    }

    public void v(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) {
            d.a.o0.a.h0.l.a aVar = this.f45377a;
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || aVar == null) {
                return;
            }
            if (k) {
                Log.d("BasePreloadMasterManager", "set code cache setting before preload/prefetch");
            }
            d.a.o0.a.h0.f.a g2 = aVar.g();
            String str = e.C0638e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).getPath() + File.separator;
            if (g2 instanceof d.a.o0.a.l0.a) {
                ((d.a.o0.a.l0.a) g2).C0(d.a.o0.a.h0.d.a.a("appjs", str));
            } else if (g2 instanceof NgWebView) {
                ((NgWebView) g2).getSettings().setCodeCacheSetting(d.a.o0.a.h0.d.b.a("appjs", str));
            }
        }
    }
}
