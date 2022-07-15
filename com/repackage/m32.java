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
import com.repackage.d32;
import com.repackage.dj2;
import com.repackage.l32;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class m32<T extends l32> extends t74<g94> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes6.dex */
    public class a implements d32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g94 a;
        public final /* synthetic */ m32 b;

        public a(m32 m32Var, g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m32Var, g94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m32Var;
            this.a = g94Var;
        }

        @Override // com.repackage.d32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.repackage.d32.c
        public void b(PMSDownloadType pMSDownloadType, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ac3Var) == null) {
                this.b.u(this.a, ac3Var);
            }
        }
    }

    public m32(@NonNull T t) {
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
    @Override // com.repackage.w74
    /* renamed from: l */
    public String d(g94 g94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g94Var)) == null) ? dj2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.repackage.y74
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

    public final void p(g94 g94Var, ac3 ac3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g94Var, ac3Var) == null) {
            u(g94Var, ac3Var);
            d32.c().a(g94Var, o(), ac3Var);
        }
    }

    public final void q(@NonNull g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, g94Var) == null) {
            r(g94Var);
            d32.c().b(g94Var, o());
        }
    }

    public abstract void r(@NonNull g94 g94Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t74, com.repackage.w74
    /* renamed from: s */
    public void e(g94 g94Var, z84 z84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, g94Var, z84Var) == null) {
            super.e(g94Var, z84Var);
            zv2.b("plugin download error: " + z84Var);
            ac3 ac3Var = new ac3();
            ac3Var.k(17L);
            ac3Var.i((long) z84Var.a);
            ac3Var.d(z84Var.b);
            ac3Var.f(z84Var.toString());
            p(g94Var, ac3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t74, com.repackage.w74
    /* renamed from: t */
    public void i(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, g94Var) == null) {
            super.i(g94Var);
            if (g94Var == null) {
                zv2.b("download finish, plugin is null");
                ac3 ac3Var = new ac3();
                ac3Var.k(17L);
                ac3Var.i(2201L);
                ac3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, ac3Var);
            } else if (!ud3.a(new File(g94Var.a), g94Var.m)) {
                jg4.M(g94Var.a);
                zv2.b("download finish, check zip sign failure");
                ac3 ac3Var2 = new ac3();
                ac3Var2.k(17L);
                ac3Var2.i(2202L);
                ac3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(g94Var, ac3Var2);
            } else {
                File t = dj2.t(g94Var.g, String.valueOf(g94Var.i));
                jg4.l(t);
                if (t != null && t.exists()) {
                    boolean U = jg4.U(g94Var.a, t.getAbsolutePath());
                    jg4.M(g94Var.a);
                    zv2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        ac3 ac3Var3 = new ac3();
                        ac3Var3.k(17L);
                        ac3Var3.i(2320L);
                        ac3Var3.d("plugin unzip fail.");
                        p(g94Var, ac3Var3);
                        return;
                    }
                    g94Var.c = g94Var.b();
                    g94Var.d = g94Var.b();
                    c84.i().m(g94Var);
                    q(g94Var);
                    return;
                }
                jg4.M(g94Var.a);
                zv2.b("download finish, create file failure, name = " + g94Var.g + " ; version = " + g94Var.i);
                ac3 ac3Var4 = new ac3();
                ac3Var4.k(17L);
                ac3Var4.i(2203L);
                ac3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(g94Var, ac3Var4);
            }
        }
    }

    public abstract void u(g94 g94Var, ac3 ac3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t74, com.repackage.w74
    /* renamed from: v */
    public void c(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, g94Var) == null) {
            super.c(g94Var);
            if (g94Var != null) {
                zv2.b("plugin download start: bundleId = " + g94Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.t74, com.repackage.w74
    /* renamed from: w */
    public void f(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, g94Var) == null) {
            super.f(g94Var);
            if (g94Var != null) {
                zv2.b("plugin on downloading: bundleId = " + g94Var.g);
            }
            x(g94Var);
        }
    }

    public final void x(g94 g94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, g94Var) == null) {
            d32.c().d(g94Var, new a(this, g94Var));
        }
    }
}
