package com.repackage;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o22;
import com.repackage.oi2;
import com.repackage.w22;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class x22<T extends w22> extends e74<r84> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes7.dex */
    public class a implements o22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r84 a;
        public final /* synthetic */ x22 b;

        public a(x22 x22Var, r84 r84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x22Var, r84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = x22Var;
            this.a = r84Var;
        }

        @Override // com.repackage.o22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.repackage.o22.c
        public void b(PMSDownloadType pMSDownloadType, lb3 lb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, lb3Var) == null) {
                this.b.u(this.a, lb3Var);
            }
        }
    }

    public x22(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.h74
    /* renamed from: l */
    public String d(r84 r84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, r84Var)) == null) ? oi2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.repackage.j74
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
    }

    public PMSDownloadType o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? PMSDownloadType.PLUGIN : (PMSDownloadType) invokeV.objValue;
    }

    public final void p(r84 r84Var, lb3 lb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, r84Var, lb3Var) == null) {
            u(r84Var, lb3Var);
            o22.c().a(r84Var, o(), lb3Var);
        }
    }

    public final void q(@NonNull r84 r84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, r84Var) == null) {
            r(r84Var);
            o22.c().b(r84Var, o());
        }
    }

    public abstract void r(@NonNull r84 r84Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e74, com.repackage.h74
    /* renamed from: s */
    public void e(r84 r84Var, k84 k84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, r84Var, k84Var) == null) {
            super.e(r84Var, k84Var);
            kv2.b("plugin download error: " + k84Var);
            lb3 lb3Var = new lb3();
            lb3Var.k(17L);
            lb3Var.i((long) k84Var.a);
            lb3Var.d(k84Var.b);
            lb3Var.f(k84Var.toString());
            p(r84Var, lb3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e74, com.repackage.h74
    /* renamed from: t */
    public void i(r84 r84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, r84Var) == null) {
            super.i(r84Var);
            if (r84Var == null) {
                kv2.b("download finish, plugin is null");
                lb3 lb3Var = new lb3();
                lb3Var.k(17L);
                lb3Var.i(2201L);
                lb3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, lb3Var);
            } else if (!fd3.a(new File(r84Var.a), r84Var.m)) {
                uf4.M(r84Var.a);
                kv2.b("download finish, check zip sign failure");
                lb3 lb3Var2 = new lb3();
                lb3Var2.k(17L);
                lb3Var2.i(2202L);
                lb3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(r84Var, lb3Var2);
            } else {
                File t = oi2.t(r84Var.g, String.valueOf(r84Var.i));
                uf4.l(t);
                if (t != null && t.exists()) {
                    boolean U = uf4.U(r84Var.a, t.getAbsolutePath());
                    uf4.M(r84Var.a);
                    kv2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        lb3 lb3Var3 = new lb3();
                        lb3Var3.k(17L);
                        lb3Var3.i(2320L);
                        lb3Var3.d("plugin unzip fail.");
                        p(r84Var, lb3Var3);
                        return;
                    }
                    r84Var.c = r84Var.b();
                    r84Var.d = r84Var.b();
                    n74.i().m(r84Var);
                    q(r84Var);
                    return;
                }
                uf4.M(r84Var.a);
                kv2.b("download finish, create file failure, name = " + r84Var.g + " ; version = " + r84Var.i);
                lb3 lb3Var4 = new lb3();
                lb3Var4.k(17L);
                lb3Var4.i(2203L);
                lb3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(r84Var, lb3Var4);
            }
        }
    }

    public abstract void u(r84 r84Var, lb3 lb3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e74, com.repackage.h74
    /* renamed from: v */
    public void c(r84 r84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, r84Var) == null) {
            super.c(r84Var);
            if (r84Var != null) {
                kv2.b("plugin download start: bundleId = " + r84Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e74, com.repackage.h74
    /* renamed from: w */
    public void f(r84 r84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, r84Var) == null) {
            super.f(r84Var);
            if (r84Var != null) {
                kv2.b("plugin on downloading: bundleId = " + r84Var.g);
            }
            x(r84Var);
        }
    }

    public final void x(r84 r84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, r84Var) == null) {
            o22.c().d(r84Var, new a(this, r84Var));
        }
    }
}
