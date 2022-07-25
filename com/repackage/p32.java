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
import com.repackage.m32;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class p32<T extends m32> extends u74<g94> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755460926, "Lcom/repackage/p32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755460926, "Lcom/repackage/p32;");
                return;
            }
        }
        b = sg1.a;
    }

    public p32(@NonNull T t) {
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

    @Override // com.repackage.u74
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

    @Override // com.repackage.z74
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
    @Override // com.repackage.x74
    /* renamed from: o */
    public String d(g94 g94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, g94Var)) == null) {
            if (TextUtils.isEmpty(g94Var.o)) {
                g94Var.o = l();
            }
            int i = g94Var.h;
            if (i == 0) {
                return b42.b(g94Var.o, String.valueOf(g94Var.i));
            }
            if (i == 1) {
                return b42.d(g94Var.o, String.valueOf(g94Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @CallSuper
    public void p(@NonNull g94 g94Var, @Nullable bc3 bc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, g94Var, bc3Var) == null) {
        }
    }

    @CallSuper
    public void q(g94 g94Var, a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g94Var, a94Var) == null) {
            super.e(g94Var, a94Var);
            ix1.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + g94Var.a);
            kg4.M(g94Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + g94Var + ", error=" + a94Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u74, com.repackage.x74
    /* renamed from: r */
    public final void i(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, g94Var) == null) {
            super.i(g94Var);
            p(g94Var, t(g94Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + g94Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u74, com.repackage.x74
    /* renamed from: s */
    public void c(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, g94Var) == null) {
            super.c(g94Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + g94Var);
            }
        }
    }

    public final bc3 t(g94 g94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, g94Var)) == null) {
            if (!vd3.a(new File(g94Var.a), g94Var.m)) {
                bc3 bc3Var = new bc3();
                bc3Var.k(12L);
                bc3Var.b(2300L);
                bc3Var.d("分包签名校验失败");
                return bc3Var;
            } else if (b42.g(g94Var)) {
                return null;
            } else {
                bc3 bc3Var2 = new bc3();
                bc3Var2.k(12L);
                bc3Var2.b(2320L);
                bc3Var2.d("分包解压失败");
                return bc3Var2;
            }
        }
        return (bc3) invokeL.objValue;
    }
}
