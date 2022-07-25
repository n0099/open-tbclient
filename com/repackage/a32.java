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
import com.repackage.y22;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class a32 implements l22<k22>, t22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile z22 a;
    public volatile z22 b;
    public final LinkedList<ia2> c;
    public final List<n22<k22>> d;
    public z22 e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public boolean i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755907791, "Lcom/repackage/a32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755907791, "Lcom/repackage/a32;");
                return;
            }
        }
        k = sg1.a;
        l = i42.l() == 1;
    }

    public a32() {
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
        this.c = new LinkedList<>();
        this.d = new LinkedList();
        this.j = new Object();
        this.f = false;
        this.g = false;
        this.i = false;
        this.h = false;
    }

    @Override // com.repackage.l22
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProviderMulti", "get a prefetch event - " + cVar);
            }
            if (!this.f) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "can not prefetch before default mater ready");
                    return;
                }
                return;
            }
            ix1.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str2 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str2)) {
                    if (k) {
                        y22.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.g) {
                        i03 b0 = i03.b0();
                        if (b0 != null && TextUtils.equals(str2, b0.getAppId())) {
                            ix1.i(PrefetchEvent.MODULE, "prefetch after app start");
                            this.e.r(str, cVar, pMSAppInfo);
                            return;
                        } else if (k) {
                            Log.w("SwanAppMasterProviderMulti", "can not prefetch after swan app start, only same app allowed");
                            return;
                        } else {
                            return;
                        }
                    }
                    synchronized (this.j) {
                        if (this.g) {
                            return;
                        }
                        if (this.b == null || this.b.w(pMSAppInfo, cVar)) {
                            m(this.b);
                            this.b = l(false, this.i);
                        }
                        this.b.r(str, cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "prefetch currentAppInfo is empty or appId is empty");
            }
        }
    }

    @Override // com.repackage.m22
    public void c(n22<k22> n22Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, n22Var) == null) || n22Var == null) {
            return;
        }
        synchronized (this.j) {
            if (this.g) {
                if (k) {
                    Log.d("SwanAppMasterProviderMulti", "app already start , call back immediately");
                }
                n22Var.a(this.h, this.e);
                return;
            }
            if (!this.d.contains(n22Var)) {
                this.d.add(n22Var);
            }
        }
    }

    @Override // com.repackage.l22
    public void d(ia2 ia2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, ia2Var) == null) || ia2Var == null || this.g) {
            return;
        }
        synchronized (this.j) {
            this.c.add(ia2Var);
        }
    }

    @Override // com.repackage.m22
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    @Override // com.repackage.m22
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : invokeV.booleanValue;
    }

    @Override // com.repackage.m22
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f : invokeV.booleanValue;
    }

    @Override // com.repackage.l22
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : invokeV.booleanValue;
    }

    @Override // com.repackage.l22
    public void j(boolean z, t22 t22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, t22Var) == null) {
            if (this.a == null) {
                synchronized (this.j) {
                    if (this.a == null) {
                        this.i = z;
                        this.a = l(true, z);
                        this.a.c(this);
                        this.a.c(t22Var);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "call prepareDefault repeat");
            }
            if (this.a != null) {
                this.a.c(t22Var);
            }
        }
    }

    public final void k(z22 z22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, z22Var) == null) {
            z22 z22Var2 = z22Var == this.b ? this.a : this.b;
            this.a = z22Var;
            m(z22Var2);
            this.b = null;
        }
    }

    public z22 l(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            y22.c().b(!z);
            return new z22(z, z2);
        }
        return (z22) invokeCommon.objValue;
    }

    public final void m(z22 z22Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, z22Var) == null) || z22Var == null || z22Var.i() == null) {
            return;
        }
        z22Var.i().destroy();
        if (k) {
            Log.i("SwanAppMasterProviderMulti", "master destroy, id - " + z22Var.i().b() + ", isReady - " + z22Var.n() + ", is Default - " + z22Var.l());
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !this.c.isEmpty() && this.g) {
            synchronized (this.j) {
                Iterator<ia2> it = this.c.iterator();
                while (it.hasNext()) {
                    ia2 next = it.next();
                    if (k) {
                        Log.d("SwanAppMasterProviderMulti", "dispatchPendingEvents event: " + next.a);
                    }
                    c72.U().U0(next);
                }
                this.c.clear();
            }
        }
    }

    public final void o(boolean z, z22 z22Var, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), z22Var, pMSAppInfo}) == null) {
            this.h = z;
            this.e = z22Var;
            z22Var.p(pMSAppInfo);
            this.g = true;
            n();
            k(z22Var);
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "clear useless master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
            q(z, z22Var);
            y22.c().a();
        }
    }

    @Override // com.repackage.t22
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.m22
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public z22 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.g) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProviderMulti", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.e;
        }
        return (z22) invokeV.objValue;
    }

    public final void q(boolean z, z22 z22Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048593, this, z, z22Var) == null) || this.d.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (n22<k22> n22Var : this.d) {
                n22Var.a(z, z22Var);
            }
            this.d.clear();
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
    @Override // com.repackage.m22
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public z22 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        z22 z22Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            long currentTimeMillis = k ? System.currentTimeMillis() : 0L;
            if ((pMSAppInfo == null || !this.f) && k) {
                Log.e("SwanAppMasterProviderMulti", Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished")));
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "real start a swan app - " + pMSAppInfo);
                Log.w("SwanAppMasterProviderMulti", "is default master ready - " + this.f);
            }
            if (this.g) {
                return this.e;
            }
            synchronized (this.j) {
                if (!this.g) {
                    if (k) {
                        y22.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.b != null && this.b.n() && pMSAppInfo != null) {
                        if (this.b.w(pMSAppInfo, null)) {
                            z22Var = this.a;
                            z = false;
                            o(z, z22Var, pMSAppInfo);
                        } else {
                            if (this.b.j()) {
                                z22Var = this.b;
                            } else {
                                y22.a aVar = new y22.a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f = y22.c().f(aVar);
                                boolean g = y22.c().g(aVar);
                                boolean e = y22.c().e();
                                if (k) {
                                    Log.d("SwanAppMasterProviderMulti", "app - " + aVar + ", is loaded - " + f);
                                    Log.d("SwanAppMasterProviderMulti", "app - " + aVar + ", is loading - " + g);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("has loading app now - ");
                                    sb.append(e);
                                    Log.d("SwanAppMasterProviderMulti", sb.toString());
                                }
                                if (e && !g) {
                                    if (f && l) {
                                        z22Var = z ? this.b : this.a;
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                if (z) {
                                }
                            }
                            o(z, z22Var, pMSAppInfo);
                        }
                    }
                    z22Var = this.a;
                    z = false;
                    o(z, z22Var, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "get right master cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("final master id - ");
                sb2.append(this.e.i().b());
                Log.i("SwanAppMasterProviderMulti", sb2.toString());
            }
            return this.e;
        }
        return (z22) invokeL.objValue;
    }

    @Override // com.repackage.m22
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (k) {
                Log.d("SwanAppMasterProviderMulti", "release master provider");
            }
            this.f = false;
            this.g = false;
            this.i = false;
            this.h = false;
            m(this.a);
            m(this.b);
            this.a = null;
            this.b = null;
            this.e = null;
            synchronized (this.j) {
                this.c.clear();
                this.d.clear();
            }
            o22.c();
            r22.b().d();
            y22.c().a();
        }
    }
}
