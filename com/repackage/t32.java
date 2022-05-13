package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t32 extends u32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean D;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755341762, "Lcom/repackage/t32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755341762, "Lcom/repackage/t32;");
                return;
            }
        }
        D = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t32(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.u32, com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m94Var) == null) {
            super.D(m94Var);
            if (D) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: onFetchError: " + m94Var.toString());
            }
            I0("checkForUpdate", false);
            n0(m94Var.a);
            if (k42.m(m94Var)) {
                k42.c(this.o);
            }
        }
    }

    @Override // com.repackage.n84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            if (this.n != null) {
                v0();
                I0("checkForUpdate", false);
                k42.c(this.o);
            }
        }
    }

    @Override // com.repackage.u32, com.repackage.n84
    public void H(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ae4Var) == null) {
            super.H(ae4Var);
            I0("checkForUpdate", ae4Var != null && ae4Var.f());
        }
    }

    @Override // com.repackage.n84
    public void I(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
            super.I(str, i);
            x94 a = x94.a(str);
            if (a == null) {
                return;
            }
            boolean b = zd4.b(a.c());
            ux1.i("SwanAppPkgAsyncDownloadCallback", "resetCore: " + b + ";statusCode:" + i);
            if (b) {
                kx2 e = kx2.e();
                mx2 mx2Var = new mx2(129);
                mx2Var.f(true);
                e.h(mx2Var);
            }
        }
    }

    public final void I0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(this.o)) {
            return;
        }
        w32.f(str, this.o, z);
    }

    @Override // com.repackage.y32
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.u32
    public PMSDownloadType l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? PMSDownloadType.ASYNC : (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.u32
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.w0();
            this.p.add(new UbcFlowEvent("na_start_update_db"));
            nc3 G0 = G0();
            this.p.add(new UbcFlowEvent("na_end_update_db"));
            if (G0 == null) {
                if (D) {
                    Log.d("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储成功");
                }
                I0("updateReady", true);
                B0("main_async_download", "0");
                k42.c(this.o);
            } else if (D) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 异步更新-> DB 存储失败");
            }
        }
    }

    @Override // com.repackage.u32
    public void x0(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th) == null) {
            I0("updateFailed", false);
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (D) {
                    Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage());
                }
            } else if (D) {
                Log.e("SwanAppPkgAsyncDownloadCallback", "swanAsyncUpdate :: 未知错误：" + th.getMessage());
            }
        }
    }
}
