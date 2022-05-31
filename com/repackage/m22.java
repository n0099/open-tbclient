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
import com.repackage.d22;
import com.repackage.di2;
import com.repackage.l22;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class m22<T extends l22> extends t64<g84> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes6.dex */
    public class a implements d22.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g84 a;
        public final /* synthetic */ m22 b;

        public a(m22 m22Var, g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m22Var, g84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m22Var;
            this.a = g84Var;
        }

        @Override // com.repackage.d22.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.repackage.d22.c
        public void b(PMSDownloadType pMSDownloadType, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ab3Var) == null) {
                this.b.u(this.a, ab3Var);
            }
        }
    }

    public m22(@NonNull T t) {
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
    @Override // com.repackage.w64
    /* renamed from: l */
    public String d(g84 g84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g84Var)) == null) ? di2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.repackage.y64
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

    public final void p(g84 g84Var, ab3 ab3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g84Var, ab3Var) == null) {
            u(g84Var, ab3Var);
            d22.c().a(g84Var, o(), ab3Var);
        }
    }

    public final void q(@NonNull g84 g84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, g84Var) == null) {
            r(g84Var);
            d22.c().b(g84Var, o());
        }
    }

    public abstract void r(@NonNull g84 g84Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t64, com.repackage.w64
    /* renamed from: s */
    public void e(g84 g84Var, z74 z74Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, g84Var, z74Var) == null) {
            super.e(g84Var, z74Var);
            zu2.b("plugin download error: " + z74Var);
            ab3 ab3Var = new ab3();
            ab3Var.k(17L);
            ab3Var.i((long) z74Var.a);
            ab3Var.d(z74Var.b);
            ab3Var.f(z74Var.toString());
            p(g84Var, ab3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t64, com.repackage.w64
    /* renamed from: t */
    public void i(g84 g84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, g84Var) == null) {
            super.i(g84Var);
            if (g84Var == null) {
                zu2.b("download finish, plugin is null");
                ab3 ab3Var = new ab3();
                ab3Var.k(17L);
                ab3Var.i(2201L);
                ab3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, ab3Var);
            } else if (!uc3.a(new File(g84Var.a), g84Var.m)) {
                kf4.M(g84Var.a);
                zu2.b("download finish, check zip sign failure");
                ab3 ab3Var2 = new ab3();
                ab3Var2.k(17L);
                ab3Var2.i(2202L);
                ab3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(g84Var, ab3Var2);
            } else {
                File t = di2.t(g84Var.g, String.valueOf(g84Var.i));
                kf4.l(t);
                if (t != null && t.exists()) {
                    boolean U = kf4.U(g84Var.a, t.getAbsolutePath());
                    kf4.M(g84Var.a);
                    zu2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        ab3 ab3Var3 = new ab3();
                        ab3Var3.k(17L);
                        ab3Var3.i(2320L);
                        ab3Var3.d("plugin unzip fail.");
                        p(g84Var, ab3Var3);
                        return;
                    }
                    g84Var.c = g84Var.b();
                    g84Var.d = g84Var.b();
                    c74.i().m(g84Var);
                    q(g84Var);
                    return;
                }
                kf4.M(g84Var.a);
                zu2.b("download finish, create file failure, name = " + g84Var.g + " ; version = " + g84Var.i);
                ab3 ab3Var4 = new ab3();
                ab3Var4.k(17L);
                ab3Var4.i(2203L);
                ab3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(g84Var, ab3Var4);
            }
        }
    }

    public abstract void u(g84 g84Var, ab3 ab3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t64, com.repackage.w64
    /* renamed from: v */
    public void c(g84 g84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, g84Var) == null) {
            super.c(g84Var);
            if (g84Var != null) {
                zu2.b("plugin download start: bundleId = " + g84Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t64, com.repackage.w64
    /* renamed from: w */
    public void f(g84 g84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, g84Var) == null) {
            super.f(g84Var);
            if (g84Var != null) {
                zu2.b("plugin on downloading: bundleId = " + g84Var.g);
            }
            x(g84Var);
        }
    }

    public final void x(g84 g84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, g84Var) == null) {
            d22.c().d(g84Var, new a(this, g84Var));
        }
    }
}
