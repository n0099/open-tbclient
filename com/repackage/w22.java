package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qj2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class w22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public q22 a;
    public final List<f32> b;
    public volatile PMSAppInfo c;
    public volatile PrefetchEvent.c d;
    public volatile e32 e;
    public final boolean f;
    public volatile boolean g;
    public long h;
    public long i;
    public final boolean j;

    /* loaded from: classes7.dex */
    public class a extends iz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w22 a;

        public a(w22 w22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w22Var;
        }

        @Override // com.repackage.iz1
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.a(str);
                if (w22.k) {
                    Log.d("BasePreloadMasterManager", "prepareMaster finish. url: " + str);
                }
                this.a.g = true;
                this.a.i = System.currentTimeMillis();
                this.a.o();
                if (w22.k) {
                    Log.d("BasePreloadMasterManager", "createBlankOne cost - " + this.a.f() + "ms");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PMSAppInfo b;
        public final /* synthetic */ PrefetchEvent.c c;
        public final /* synthetic */ w22 d;

        public b(w22 w22Var, String str, PMSAppInfo pMSAppInfo, PrefetchEvent.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w22Var, str, pMSAppInfo, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = w22Var;
            this.a = str;
            this.b = pMSAppInfo;
            this.c = cVar;
        }

        @Override // com.repackage.f32
        public void onReady() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q22 i = this.d.i();
                if (i == null || i.h() == null || i.h().isDestroyed()) {
                    z = false;
                } else {
                    this.d.q(this.a, this.b);
                    qa2.a(i.h(), this.c);
                    ux1.i(PrefetchEvent.MODULE, "prefetch master finish");
                    z = true;
                }
                x52 d = x52.d();
                d.b(this.a, new UbcFlowEvent("prefetch_end"));
                d.e(this.a, z, false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755253350, "Lcom/repackage/w22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755253350, "Lcom/repackage/w22;");
                return;
            }
        }
        k = eh1.a;
    }

    public w22(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.j = z2;
        this.f = z;
        if (!z) {
            d32.b().c(this);
        }
        e();
    }

    public synchronized void c(f32 f32Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, f32Var) == null) {
            synchronized (this) {
                if (f32Var == null) {
                    return;
                }
                if (this.g) {
                    if (k) {
                        Log.d("BasePreloadMasterManager", "is Ready , call back immediately");
                    }
                    f32Var.onReady();
                    return;
                }
                if (!this.b.contains(f32Var)) {
                    this.b.add(f32Var);
                }
            }
        }
    }

    public void d(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
            this.c = pMSAppInfo;
            d32.b().c(this);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (k) {
                Log.d("BasePreloadMasterManager", "start create a blank preload master manager, is default - " + this.f + ",is v8 - " + this.j);
            }
            this.h = System.currentTimeMillis();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.a = o72.U().D0(this.j, new a(this));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("BasePreloadMasterManager", "create a new master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i - this.h : invokeV.longValue;
    }

    public PMSAppInfo g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (PMSAppInfo) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.c != null) {
                return this.c.appId;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public q22 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (q22) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e != null : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : invokeV.booleanValue;
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
                u03 a0 = u03.a0();
                str = a0 != null ? a0.T().e("dynamicLibPath", null) : null;
            } else {
                str = cVar.t().get("dynamicLibPath");
            }
            String str2 = cVar2.t().get("dynamicLibPath");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public final synchronized void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.d("BasePreloadMasterManager", "notifyAllReady, callback size " + this.b.size());
                }
                for (f32 f32Var : this.b) {
                    if (f32Var != null) {
                        f32Var.onReady();
                    }
                }
                this.b.clear();
            }
        }
    }

    public void p(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pMSAppInfo) == null) {
            d(pMSAppInfo);
            this.e = null;
            this.d = null;
        }
    }

    public void q(String str, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, pMSAppInfo) == null) {
            v(pMSAppInfo);
            d62.c(str, pMSAppInfo.appId);
        }
    }

    public void r(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, cVar, pMSAppInfo) == null) {
            if (cVar == null) {
                if (k) {
                    Log.e("BasePreloadMasterManager", "prefetch event is null");
                }
            } else if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                if (this.a == null) {
                    ux1.k("BasePreloadMasterManager", "mMasterManager not create yet, can not prefetch");
                } else if (l() && this.c == null) {
                    ux1.k("BasePreloadMasterManager", "default blank master can not use to prefetch");
                } else if (k(cVar, pMSAppInfo)) {
                    ux1.k("BasePreloadMasterManager", "intercept before preload/prefetch");
                } else {
                    d(pMSAppInfo);
                    s(cVar);
                    t(cVar, pMSAppInfo);
                    u(str, cVar, pMSAppInfo);
                }
            } else {
                ux1.k("BasePreloadMasterManager", "prefetch currentAppInfo is empty");
            }
        }
    }

    public void s(PrefetchEvent.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.d = cVar;
            if (k) {
                Log.d("BasePreloadMasterManager", "fire prefetch event name - " + cVar.a);
            }
        }
    }

    public final void t(PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, cVar, pMSAppInfo) == null) && cVar.u()) {
            this.e = new e32();
            this.e.a = pMSAppInfo.appId;
            this.e.b = pMSAppInfo;
            this.e.c = cVar;
        }
    }

    public void u(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, cVar, pMSAppInfo) == null) {
            c(new b(this, str, pMSAppInfo, cVar));
            if (k) {
                Log.i("BasePreloadMasterManager", "fire prefetch event - " + pMSAppInfo.appId + ", version -" + pMSAppInfo.versionCode);
            }
        }
    }

    public void v(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pMSAppInfo) == null) {
            q22 q22Var = this.a;
            if (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || q22Var == null) {
                return;
            }
            if (k) {
                Log.d("BasePreloadMasterManager", "set code cache setting before preload/prefetch");
            }
            sz1 h = q22Var.h();
            String str = qj2.e.i(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode)).getPath() + File.separator;
            if (h instanceof c82) {
                ((c82) h).D0(mz1.a("appjs", str));
            } else if (h instanceof NgWebView) {
                ((NgWebView) h).getSettings().setCodeCacheSetting(nz1.a("appjs", str));
            }
        }
    }
}
