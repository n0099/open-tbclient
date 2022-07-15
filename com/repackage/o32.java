package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.l32;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class o32<T extends l32> extends t74<f94> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755490717, "Lcom/repackage/o32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755490717, "Lcom/repackage/o32;");
                return;
            }
        }
        b = rg1.a;
    }

    public o32(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = t;
    }

    @Override // com.repackage.t74
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? super.g() : invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.y74
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
            Bundle bundle2 = new Bundle();
            if (set.contains("event_performance_ubc")) {
                this.a.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
                set.remove("event_performance_ubc");
            }
            return bundle2;
        }
        return (Bundle) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w74
    /* renamed from: o */
    public String d(f94 f94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f94Var)) == null) {
            if (TextUtils.isEmpty(f94Var.o)) {
                f94Var.o = l();
            }
            int i = f94Var.h;
            if (i == 0) {
                return a42.b(f94Var.o, String.valueOf(f94Var.i));
            }
            if (i == 1) {
                return a42.d(f94Var.o, String.valueOf(f94Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @CallSuper
    public void p(@NonNull f94 f94Var, @Nullable ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, f94Var, ac3Var) == null) {
        }
    }

    @CallSuper
    public void q(f94 f94Var, z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f94Var, z84Var) == null) {
            super.e(f94Var, z84Var);
            hx1.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + f94Var.a);
            jg4.M(f94Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + f94Var + ", error=" + z84Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t74, com.repackage.w74
    /* renamed from: r */
    public final void i(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, f94Var) == null) {
            super.i(f94Var);
            p(f94Var, t(f94Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + f94Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t74, com.repackage.w74
    /* renamed from: s */
    public void c(f94 f94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, f94Var) == null) {
            super.c(f94Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + f94Var);
            }
        }
    }

    public final ac3 t(f94 f94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, f94Var)) == null) {
            if (!ud3.a(new File(f94Var.a), f94Var.m)) {
                ac3 ac3Var = new ac3();
                ac3Var.k(12L);
                ac3Var.b(2300L);
                ac3Var.d("分包签名校验失败");
                return ac3Var;
            } else if (a42.g(f94Var)) {
                return null;
            } else {
                ac3 ac3Var2 = new ac3();
                ac3Var2.k(12L);
                ac3Var2.b(2320L);
                ac3Var2.d("分包解压失败");
                return ac3Var2;
            }
        }
        return (ac3) invokeL.objValue;
    }
}
