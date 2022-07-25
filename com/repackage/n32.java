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
import com.repackage.e32;
import com.repackage.ej2;
import com.repackage.m32;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class n32<T extends m32> extends u74<h94> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes6.dex */
    public class a implements e32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h94 a;
        public final /* synthetic */ n32 b;

        public a(n32 n32Var, h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n32Var, h94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n32Var;
            this.a = h94Var;
        }

        @Override // com.repackage.e32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.repackage.e32.c
        public void b(PMSDownloadType pMSDownloadType, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, bc3Var) == null) {
                this.b.u(this.a, bc3Var);
            }
        }
    }

    public n32(@NonNull T t) {
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
    @Override // com.repackage.x74
    /* renamed from: l */
    public String d(h94 h94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, h94Var)) == null) ? ej2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.repackage.z74
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

    public final void p(h94 h94Var, bc3 bc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h94Var, bc3Var) == null) {
            u(h94Var, bc3Var);
            e32.c().a(h94Var, o(), bc3Var);
        }
    }

    public final void q(@NonNull h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, h94Var) == null) {
            r(h94Var);
            e32.c().b(h94Var, o());
        }
    }

    public abstract void r(@NonNull h94 h94Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u74, com.repackage.x74
    /* renamed from: s */
    public void e(h94 h94Var, a94 a94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, h94Var, a94Var) == null) {
            super.e(h94Var, a94Var);
            aw2.b("plugin download error: " + a94Var);
            bc3 bc3Var = new bc3();
            bc3Var.k(17L);
            bc3Var.i((long) a94Var.a);
            bc3Var.d(a94Var.b);
            bc3Var.f(a94Var.toString());
            p(h94Var, bc3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u74, com.repackage.x74
    /* renamed from: t */
    public void i(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, h94Var) == null) {
            super.i(h94Var);
            if (h94Var == null) {
                aw2.b("download finish, plugin is null");
                bc3 bc3Var = new bc3();
                bc3Var.k(17L);
                bc3Var.i(2201L);
                bc3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, bc3Var);
            } else if (!vd3.a(new File(h94Var.a), h94Var.m)) {
                kg4.M(h94Var.a);
                aw2.b("download finish, check zip sign failure");
                bc3 bc3Var2 = new bc3();
                bc3Var2.k(17L);
                bc3Var2.i(2202L);
                bc3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(h94Var, bc3Var2);
            } else {
                File t = ej2.t(h94Var.g, String.valueOf(h94Var.i));
                kg4.l(t);
                if (t != null && t.exists()) {
                    boolean U = kg4.U(h94Var.a, t.getAbsolutePath());
                    kg4.M(h94Var.a);
                    aw2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        bc3 bc3Var3 = new bc3();
                        bc3Var3.k(17L);
                        bc3Var3.i(2320L);
                        bc3Var3.d("plugin unzip fail.");
                        p(h94Var, bc3Var3);
                        return;
                    }
                    h94Var.c = h94Var.b();
                    h94Var.d = h94Var.b();
                    d84.i().m(h94Var);
                    q(h94Var);
                    return;
                }
                kg4.M(h94Var.a);
                aw2.b("download finish, create file failure, name = " + h94Var.g + " ; version = " + h94Var.i);
                bc3 bc3Var4 = new bc3();
                bc3Var4.k(17L);
                bc3Var4.i(2203L);
                bc3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(h94Var, bc3Var4);
            }
        }
    }

    public abstract void u(h94 h94Var, bc3 bc3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u74, com.repackage.x74
    /* renamed from: v */
    public void c(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, h94Var) == null) {
            super.c(h94Var);
            if (h94Var != null) {
                aw2.b("plugin download start: bundleId = " + h94Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.u74, com.repackage.x74
    /* renamed from: w */
    public void f(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, h94Var) == null) {
            super.f(h94Var);
            if (h94Var != null) {
                aw2.b("plugin on downloading: bundleId = " + h94Var.g);
            }
            x(h94Var);
        }
    }

    public final void x(h94 h94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, h94Var) == null) {
            e32.c().d(h94Var, new a(this, h94Var));
        }
    }
}
