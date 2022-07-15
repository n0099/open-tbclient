package com.repackage;

import android.annotation.SuppressLint;
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
/* loaded from: classes7.dex */
public class u22 implements k22<j22>, s22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public final p22 a;
    public final LinkedList<ha2> b;
    public final List<m22<j22>> c;
    public t22 d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public boolean i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755312932, "Lcom/repackage/u22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755312932, "Lcom/repackage/u22;");
                return;
            }
        }
        k = rg1.a;
        l = 2;
    }

    public u22() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new LinkedList<>();
        this.c = new LinkedList();
        this.a = new p22(l);
        this.j = new Object();
        this.e = false;
        this.f = false;
        this.g = false;
        this.i = false;
        this.h = false;
    }

    @Override // com.repackage.k22
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
            }
            hx1.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch currentAppInfo is empty");
                    return;
                }
                return;
            }
            String str2 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str2)) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch appId is empty");
                }
            } else if (this.f) {
                h03 b0 = h03.b0();
                if (b0 == null) {
                    return;
                }
                if (TextUtils.equals(str2, b0.getAppId())) {
                    hx1.i(PrefetchEvent.MODULE, "prefetch after app start");
                    this.d.r(str, cVar, pMSAppInfo);
                    if (k) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str2);
                    }
                } else if (k) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            } else if (!this.e) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
                }
            } else {
                synchronized (this.j) {
                    if (this.f) {
                        return;
                    }
                    t22 d = this.a.d(str2);
                    if (d == null) {
                        d = k(false, this.i);
                        this.a.f(d);
                    }
                    if (d.w(pMSAppInfo, cVar)) {
                        this.a.c(str2);
                        d = k(false, this.i);
                        this.a.f(d);
                    }
                    this.a.g(Collections.singletonList(d));
                    d.r(str, cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // com.repackage.l22
    public void c(m22<j22> m22Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m22Var) == null) || m22Var == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f) {
                if (k) {
                    Log.d("SwanAppMasterProvider", "app already start , call back immediately");
                }
                m22Var.a(this.h, this.d);
                return;
            }
            if (!this.c.contains(m22Var)) {
                this.c.add(m22Var);
            }
        }
    }

    @Override // com.repackage.k22
    public void d(ha2 ha2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ha2Var) == null) || ha2Var == null || this.f) {
            return;
        }
        synchronized (this.j) {
            this.b.add(ha2Var);
        }
    }

    @Override // com.repackage.l22
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g : invokeV.booleanValue;
    }

    @Override // com.repackage.l22
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : invokeV.booleanValue;
    }

    @Override // com.repackage.l22
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : invokeV.booleanValue;
    }

    @Override // com.repackage.k22
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // com.repackage.k22
    public void j(boolean z, s22 s22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, s22Var) == null) {
            if (!this.g) {
                synchronized (this.j) {
                    if (!this.g) {
                        this.i = z;
                        t22 k2 = k(true, z);
                        k2.c(this);
                        k2.c(s22Var);
                        this.a.f(k2);
                        this.g = true;
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
            }
            t22 d = this.f ? this.d : this.a.d("_default_id_");
            if (d != null) {
                d.c(s22Var);
            }
        }
    }

    public t22 k(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new t22(z, z2) : (t22) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.b.isEmpty() && this.f) {
            synchronized (this.j) {
                Iterator<ha2> it = this.b.iterator();
                while (it.hasNext()) {
                    ha2 next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.a);
                    }
                    b72.U().U0(next);
                }
                this.b.clear();
            }
        }
    }

    public final void m(boolean z, t22 t22Var, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), t22Var, pMSAppInfo}) == null) {
            this.h = z;
            this.d = t22Var;
            t22Var.p(pMSAppInfo);
            this.f = true;
            l();
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            this.a.a(Collections.singletonList(t22Var));
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            o(z, t22Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l22
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: n */
    public t22 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.d;
        }
        return (t22) invokeV.objValue;
    }

    public final void o(boolean z, t22 t22Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048590, this, z, t22Var) == null) || this.c.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (m22<j22> m22Var : this.c) {
                m22Var.a(z, t22Var);
            }
            this.c.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProvider", "is hit prefetch env - " + z);
        }
    }

    @Override // com.repackage.s22
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l22
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public t22 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        t22 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (pMSAppInfo == null && k) {
                Log.e("SwanAppMasterProvider", Log.getStackTraceString(new Exception("currentAppInfo can not be null")));
            }
            if (k) {
                Log.w("SwanAppMasterProvider", "real start a swan app - " + pMSAppInfo);
            }
            if (!this.e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            String str = pMSAppInfo == null ? null : pMSAppInfo.appId;
            if (this.f) {
                return this.d;
            }
            synchronized (this.j) {
                if (!this.f) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(str) && pMSAppInfo != null) {
                        d = this.a.d(str);
                        if (d == null || !d.n() || d.w(pMSAppInfo, null)) {
                            d = this.a.d("_default_id_");
                        } else {
                            z = true;
                        }
                        m(z, d, pMSAppInfo);
                    }
                    d = this.a.d("_default_id_");
                    m(z, d, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb = new StringBuilder();
                sb.append("final master id - ");
                sb.append(this.d.i().b());
                Log.i("SwanAppMasterProvider", sb.toString());
            }
            return this.d;
        }
        return (t22) invokeL.objValue;
    }

    @Override // com.repackage.l22
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.e = false;
            this.f = false;
            this.g = false;
            this.i = false;
            this.h = false;
            this.d = null;
            this.a.a(null);
            synchronized (this.j) {
                this.b.clear();
                this.c.clear();
            }
            n22.c();
            q22.b().d();
        }
    }
}
