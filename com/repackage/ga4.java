package com.repackage;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class ga4<T> implements y74<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final jd4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public y74<T> a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755684777, "Lcom/repackage/ga4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755684777, "Lcom/repackage/ga4;");
                return;
            }
        }
        c = jd4.e();
    }

    public ga4(y74<T> y74Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y74Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.a = y74Var;
    }

    @Override // com.repackage.y74
    public void a(T t) {
        y74<T> y74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (y74Var = this.a) == null) {
            return;
        }
        try {
            y74Var.a(t);
        } catch (Exception e) {
            c.g("PMSDownStreamCallbackGuard", "#onDownloadProgress 错误", e);
        }
    }

    @Override // com.repackage.y74
    public void c(T t) {
        y74<T> y74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) || (y74Var = this.a) == null) {
            return;
        }
        try {
            y74Var.c(t);
        } catch (Exception e) {
            c.g("PMSDownStreamCallbackGuard", "#onDownloadStart 错误", e);
        }
    }

    @Override // com.repackage.y74
    public String d(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            y74<T> y74Var = this.a;
            String d = y74Var != null ? y74Var.d(t) : null;
            if (d == null) {
                try {
                    return nd4.d(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e) {
                    c.g("PMSDownStreamCallbackGuard", "#getDownloadPath getPmsDir出错", e);
                    return d;
                }
            }
            return d;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.y74
    public void e(T t, b94 b94Var) {
        y74<T> y74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, t, b94Var) == null) || (y74Var = this.a) == null) {
            return;
        }
        try {
            y74Var.e(t, b94Var);
        } catch (Exception e) {
            c.g("PMSDownStreamCallbackGuard", "#onDownloadError 错误", e);
        }
    }

    @Override // com.repackage.y74
    public void f(T t) {
        y74<T> y74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || (y74Var = this.a) == null) {
            return;
        }
        try {
            y74Var.f(t);
        } catch (Exception e) {
            c.g("PMSDownStreamCallbackGuard", "#onDownloading 错误", e);
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.y74
    public b94 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) {
            y74<T> y74Var = this.a;
            if (y74Var != null) {
                return y74Var.h(t, file, j, readableByteChannel);
            }
            return new b94(2302, "业务层默认不处理下载流");
        }
        return (b94) invokeCommon.objValue;
    }

    @Override // com.repackage.y74
    public void i(T t) {
        y74<T> y74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, t) == null) || (y74Var = this.a) == null) {
            return;
        }
        try {
            y74Var.i(t);
        } catch (Exception e) {
            c.g("PMSDownStreamCallbackGuard", "#onDownloadFinish 错误", e);
        }
    }

    @Override // com.repackage.y74
    public void j(T t) {
        y74<T> y74Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) || (y74Var = this.a) == null) {
            return;
        }
        try {
            y74Var.j(t);
        } catch (Exception e) {
            c.g("PMSDownStreamCallbackGuard", "#onDownloadStop 错误", e);
        }
    }

    @Override // com.repackage.y74
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.k() : (Map) invokeV.objValue;
    }

    @Override // com.repackage.a84
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            y74<T> y74Var = this.a;
            return y74Var == null ? new Bundle() : y74Var.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }
}
