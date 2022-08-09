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
import com.repackage.d42;
import com.repackage.v32;
import com.repackage.vj2;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class e42<T extends d42> extends l84<y94> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes6.dex */
    public class a implements v32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y94 a;
        public final /* synthetic */ e42 b;

        public a(e42 e42Var, y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e42Var, y94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e42Var;
            this.a = y94Var;
        }

        @Override // com.repackage.v32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.repackage.v32.c
        public void b(PMSDownloadType pMSDownloadType, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sc3Var) == null) {
                this.b.u(this.a, sc3Var);
            }
        }
    }

    public e42(@NonNull T t) {
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
    @Override // com.repackage.o84
    /* renamed from: l */
    public String d(y94 y94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, y94Var)) == null) ? vj2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.repackage.q84
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

    public final void p(y94 y94Var, sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, y94Var, sc3Var) == null) {
            u(y94Var, sc3Var);
            v32.c().a(y94Var, o(), sc3Var);
        }
    }

    public final void q(@NonNull y94 y94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, y94Var) == null) {
            r(y94Var);
            v32.c().b(y94Var, o());
        }
    }

    public abstract void r(@NonNull y94 y94Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84, com.repackage.o84
    /* renamed from: s */
    public void e(y94 y94Var, r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, y94Var, r94Var) == null) {
            super.e(y94Var, r94Var);
            rw2.b("plugin download error: " + r94Var);
            sc3 sc3Var = new sc3();
            sc3Var.k(17L);
            sc3Var.i((long) r94Var.a);
            sc3Var.d(r94Var.b);
            sc3Var.f(r94Var.toString());
            p(y94Var, sc3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84, com.repackage.o84
    /* renamed from: t */
    public void i(y94 y94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, y94Var) == null) {
            super.i(y94Var);
            if (y94Var == null) {
                rw2.b("download finish, plugin is null");
                sc3 sc3Var = new sc3();
                sc3Var.k(17L);
                sc3Var.i(2201L);
                sc3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, sc3Var);
            } else if (!me3.a(new File(y94Var.a), y94Var.m)) {
                bh4.M(y94Var.a);
                rw2.b("download finish, check zip sign failure");
                sc3 sc3Var2 = new sc3();
                sc3Var2.k(17L);
                sc3Var2.i(2202L);
                sc3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(y94Var, sc3Var2);
            } else {
                File t = vj2.t(y94Var.g, String.valueOf(y94Var.i));
                bh4.l(t);
                if (t != null && t.exists()) {
                    boolean U = bh4.U(y94Var.a, t.getAbsolutePath());
                    bh4.M(y94Var.a);
                    rw2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        sc3 sc3Var3 = new sc3();
                        sc3Var3.k(17L);
                        sc3Var3.i(2320L);
                        sc3Var3.d("plugin unzip fail.");
                        p(y94Var, sc3Var3);
                        return;
                    }
                    y94Var.c = y94Var.b();
                    y94Var.d = y94Var.b();
                    u84.i().m(y94Var);
                    q(y94Var);
                    return;
                }
                bh4.M(y94Var.a);
                rw2.b("download finish, create file failure, name = " + y94Var.g + " ; version = " + y94Var.i);
                sc3 sc3Var4 = new sc3();
                sc3Var4.k(17L);
                sc3Var4.i(2203L);
                sc3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(y94Var, sc3Var4);
            }
        }
    }

    public abstract void u(y94 y94Var, sc3 sc3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84, com.repackage.o84
    /* renamed from: v */
    public void c(y94 y94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, y94Var) == null) {
            super.c(y94Var);
            if (y94Var != null) {
                rw2.b("plugin download start: bundleId = " + y94Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84, com.repackage.o84
    /* renamed from: w */
    public void f(y94 y94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, y94Var) == null) {
            super.f(y94Var);
            if (y94Var != null) {
                rw2.b("plugin on downloading: bundleId = " + y94Var.g);
            }
            x(y94Var);
        }
    }

    public final void x(y94 y94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, y94Var) == null) {
            v32.c().d(y94Var, new a(this, y94Var));
        }
    }
}
