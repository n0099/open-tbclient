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
import com.repackage.y32;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class b42<T extends y32> extends g84<s94> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755877039, "Lcom/repackage/b42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755877039, "Lcom/repackage/b42;");
                return;
            }
        }
        b = eh1.a;
    }

    public b42(@NonNull T t) {
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

    @Override // com.repackage.g84
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

    @Override // com.repackage.l84
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
    @Override // com.repackage.j84
    /* renamed from: o */
    public String d(s94 s94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, s94Var)) == null) {
            if (TextUtils.isEmpty(s94Var.o)) {
                s94Var.o = l();
            }
            int i = s94Var.h;
            if (i == 0) {
                return n42.b(s94Var.o, String.valueOf(s94Var.i));
            }
            if (i == 1) {
                return n42.d(s94Var.o, String.valueOf(s94Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @CallSuper
    public void p(@NonNull s94 s94Var, @Nullable nc3 nc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, s94Var, nc3Var) == null) {
        }
    }

    @CallSuper
    public void q(s94 s94Var, m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s94Var, m94Var) == null) {
            super.e(s94Var, m94Var);
            ux1.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + s94Var.a);
            xg4.M(s94Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + s94Var + ", error=" + m94Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.g84, com.repackage.j84
    /* renamed from: r */
    public final void i(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, s94Var) == null) {
            super.i(s94Var);
            p(s94Var, t(s94Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + s94Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.g84, com.repackage.j84
    /* renamed from: s */
    public void c(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, s94Var) == null) {
            super.c(s94Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + s94Var);
            }
        }
    }

    public final nc3 t(s94 s94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, s94Var)) == null) {
            if (!he3.a(new File(s94Var.a), s94Var.m)) {
                nc3 nc3Var = new nc3();
                nc3Var.k(12L);
                nc3Var.b(2300L);
                nc3Var.d("分包签名校验失败");
                return nc3Var;
            } else if (n42.g(s94Var)) {
                return null;
            } else {
                nc3 nc3Var2 = new nc3();
                nc3Var2.k(12L);
                nc3Var2.b(2320L);
                nc3Var2.d("分包解压失败");
                return nc3Var2;
            }
        }
        return (nc3) invokeL.objValue;
    }
}
