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
import com.repackage.q32;
import com.repackage.qj2;
import com.repackage.y32;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class z32<T extends y32> extends g84<t94> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes7.dex */
    public class a implements q32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t94 a;
        public final /* synthetic */ z32 b;

        public a(z32 z32Var, t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z32Var, t94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z32Var;
            this.a = t94Var;
        }

        @Override // com.repackage.q32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.repackage.q32.c
        public void b(PMSDownloadType pMSDownloadType, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nc3Var) == null) {
                this.b.u(this.a, nc3Var);
            }
        }
    }

    public z32(@NonNull T t) {
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
    @Override // com.repackage.j84
    /* renamed from: l */
    public String d(t94 t94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t94Var)) == null) ? qj2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.repackage.l84
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

    public final void p(t94 t94Var, nc3 nc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t94Var, nc3Var) == null) {
            u(t94Var, nc3Var);
            q32.c().a(t94Var, o(), nc3Var);
        }
    }

    public final void q(@NonNull t94 t94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t94Var) == null) {
            r(t94Var);
            q32.c().b(t94Var, o());
        }
    }

    public abstract void r(@NonNull t94 t94Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.g84, com.repackage.j84
    /* renamed from: s */
    public void e(t94 t94Var, m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, t94Var, m94Var) == null) {
            super.e(t94Var, m94Var);
            mw2.b("plugin download error: " + m94Var);
            nc3 nc3Var = new nc3();
            nc3Var.k(17L);
            nc3Var.i((long) m94Var.a);
            nc3Var.d(m94Var.b);
            nc3Var.f(m94Var.toString());
            p(t94Var, nc3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.g84, com.repackage.j84
    /* renamed from: t */
    public void i(t94 t94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t94Var) == null) {
            super.i(t94Var);
            if (t94Var == null) {
                mw2.b("download finish, plugin is null");
                nc3 nc3Var = new nc3();
                nc3Var.k(17L);
                nc3Var.i(2201L);
                nc3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, nc3Var);
            } else if (!he3.a(new File(t94Var.a), t94Var.m)) {
                xg4.M(t94Var.a);
                mw2.b("download finish, check zip sign failure");
                nc3 nc3Var2 = new nc3();
                nc3Var2.k(17L);
                nc3Var2.i(2202L);
                nc3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(t94Var, nc3Var2);
            } else {
                File t = qj2.t(t94Var.g, String.valueOf(t94Var.i));
                xg4.l(t);
                if (t != null && t.exists()) {
                    boolean U = xg4.U(t94Var.a, t.getAbsolutePath());
                    xg4.M(t94Var.a);
                    mw2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        nc3 nc3Var3 = new nc3();
                        nc3Var3.k(17L);
                        nc3Var3.i(2320L);
                        nc3Var3.d("plugin unzip fail.");
                        p(t94Var, nc3Var3);
                        return;
                    }
                    t94Var.c = t94Var.b();
                    t94Var.d = t94Var.b();
                    p84.i().m(t94Var);
                    q(t94Var);
                    return;
                }
                xg4.M(t94Var.a);
                mw2.b("download finish, create file failure, name = " + t94Var.g + " ; version = " + t94Var.i);
                nc3 nc3Var4 = new nc3();
                nc3Var4.k(17L);
                nc3Var4.i(2203L);
                nc3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(t94Var, nc3Var4);
            }
        }
    }

    public abstract void u(t94 t94Var, nc3 nc3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.g84, com.repackage.j84
    /* renamed from: v */
    public void c(t94 t94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, t94Var) == null) {
            super.c(t94Var);
            if (t94Var != null) {
                mw2.b("plugin download start: bundleId = " + t94Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.g84, com.repackage.j84
    /* renamed from: w */
    public void f(t94 t94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, t94Var) == null) {
            super.f(t94Var);
            if (t94Var != null) {
                mw2.b("plugin on downloading: bundleId = " + t94Var.g);
            }
            x(t94Var);
        }
    }

    public final void x(t94 t94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, t94Var) == null) {
            q32.c().d(t94Var, new a(this, t94Var));
        }
    }
}
