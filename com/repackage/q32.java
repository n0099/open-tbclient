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
import com.repackage.n32;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class q32<T extends n32> extends v74<h94> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755431135, "Lcom/repackage/q32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755431135, "Lcom/repackage/q32;");
                return;
            }
        }
        b = tg1.a;
    }

    public q32(@NonNull T t) {
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

    @Override // com.repackage.v74
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

    @Override // com.repackage.a84
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
    @Override // com.repackage.y74
    /* renamed from: o */
    public String d(h94 h94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, h94Var)) == null) {
            if (TextUtils.isEmpty(h94Var.o)) {
                h94Var.o = l();
            }
            int i = h94Var.h;
            if (i == 0) {
                return c42.b(h94Var.o, String.valueOf(h94Var.i));
            }
            if (i == 1) {
                return c42.d(h94Var.o, String.valueOf(h94Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @CallSuper
    public void p(@NonNull h94 h94Var, @Nullable cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, h94Var, cc3Var) == null) {
        }
    }

    @CallSuper
    public void q(h94 h94Var, b94 b94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h94Var, b94Var) == null) {
            super.e(h94Var, b94Var);
            jx1.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + h94Var.a);
            mg4.M(h94Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + h94Var + ", error=" + b94Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.v74, com.repackage.y74
    /* renamed from: r */
    public final void i(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, h94Var) == null) {
            super.i(h94Var);
            p(h94Var, t(h94Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + h94Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.v74, com.repackage.y74
    /* renamed from: s */
    public void c(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, h94Var) == null) {
            super.c(h94Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + h94Var);
            }
        }
    }

    public final cc3 t(h94 h94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, h94Var)) == null) {
            if (!wd3.a(new File(h94Var.a), h94Var.m)) {
                cc3 cc3Var = new cc3();
                cc3Var.k(12L);
                cc3Var.b(2300L);
                cc3Var.d("分包签名校验失败");
                return cc3Var;
            } else if (c42.g(h94Var)) {
                return null;
            } else {
                cc3 cc3Var2 = new cc3();
                cc3Var2.k(12L);
                cc3Var2.b(2320L);
                cc3Var2.d("分包解压失败");
                return cc3Var2;
            }
        }
        return (cc3) invokeL.objValue;
    }
}
