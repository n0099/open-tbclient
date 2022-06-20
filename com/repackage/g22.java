package com.repackage;

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
/* loaded from: classes6.dex */
public class g22 implements v12<u12> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Boolean a;
    public volatile v12<u12> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755730006, "Lcom/repackage/g22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755730006, "Lcom/repackage/g22;");
                return;
            }
        }
        c = cg1.a;
    }

    public g22() {
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
        this.a = null;
    }

    @Override // com.repackage.v12
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            l().b(str, cVar, pMSAppInfo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.x12<com.repackage.u12> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.repackage.w12
    public void c(x12<u12> x12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x12Var) == null) {
            l().c(x12Var);
        }
    }

    @Override // com.repackage.v12
    public void d(s92 s92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s92Var) == null) {
            l().d(s92Var);
        }
    }

    @Override // com.repackage.w12
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l().f() : invokeV.booleanValue;
    }

    @Override // com.repackage.w12
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? l().g() : invokeV.booleanValue;
    }

    @Override // com.repackage.w12
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? l().h() : invokeV.booleanValue;
    }

    @Override // com.repackage.v12
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? l().i() : invokeV.booleanValue;
    }

    @Override // com.repackage.v12
    public void j(boolean z, d22 d22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, d22Var) == null) {
            l().j(z, d22Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w12
    /* renamed from: k */
    public u12 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (u12) l().a() : (u12) invokeV.objValue;
    }

    public final v12<u12> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = m() ? new k22() : new f22();
                        if (c) {
                            Log.d("SwanAppMasterProviderWrapper", "provider - " + this.b.getClass().getSimpleName());
                        }
                    }
                }
            }
            return this.b;
        }
        return (v12) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                this.a = Boolean.valueOf(s32.l() > 0 && s32.i());
            }
            if (c) {
                Log.d("SwanAppMasterProviderWrapper", "loaded swan core version - " + m62.U().d0());
                Log.d("SwanAppMasterProviderWrapper", "use multi preload - " + this.a);
            }
            return this.a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w12
    /* renamed from: n */
    public u12 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pMSAppInfo)) == null) ? (u12) l().e(pMSAppInfo) : (u12) invokeL.objValue;
    }

    @Override // com.repackage.w12
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            l().reset();
            synchronized (this) {
                this.a = null;
                this.b = null;
            }
        }
    }
}
