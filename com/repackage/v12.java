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
/* loaded from: classes7.dex */
public class v12 implements k12<j12> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Boolean a;
    public volatile k12<j12> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755284102, "Lcom/repackage/v12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755284102, "Lcom/repackage/v12;");
                return;
            }
        }
        c = rf1.a;
    }

    public v12() {
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

    @Override // com.repackage.k12
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            l().b(str, cVar, pMSAppInfo);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.repackage.m12<com.repackage.j12> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.repackage.l12
    public void c(m12<j12> m12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, m12Var) == null) {
            l().c(m12Var);
        }
    }

    @Override // com.repackage.k12
    public void d(h92 h92Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, h92Var) == null) {
            l().d(h92Var);
        }
    }

    @Override // com.repackage.l12
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l().f() : invokeV.booleanValue;
    }

    @Override // com.repackage.l12
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? l().g() : invokeV.booleanValue;
    }

    @Override // com.repackage.l12
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? l().h() : invokeV.booleanValue;
    }

    @Override // com.repackage.k12
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? l().i() : invokeV.booleanValue;
    }

    @Override // com.repackage.k12
    public void j(boolean z, s12 s12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, s12Var) == null) {
            l().j(z, s12Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l12
    /* renamed from: k */
    public j12 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (j12) l().a() : (j12) invokeV.objValue;
    }

    public final k12<j12> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = m() ? new z12() : new u12();
                        if (c) {
                            Log.d("SwanAppMasterProviderWrapper", "provider - " + this.b.getClass().getSimpleName());
                        }
                    }
                }
            }
            return this.b;
        }
        return (k12) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a == null) {
                this.a = Boolean.valueOf(h32.l() > 0 && h32.i());
            }
            if (c) {
                Log.d("SwanAppMasterProviderWrapper", "loaded swan core version - " + b62.U().d0());
                Log.d("SwanAppMasterProviderWrapper", "use multi preload - " + this.a);
            }
            return this.a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l12
    /* renamed from: n */
    public j12 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, pMSAppInfo)) == null) ? (j12) l().e(pMSAppInfo) : (j12) invokeL.objValue;
    }

    @Override // com.repackage.l12
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
