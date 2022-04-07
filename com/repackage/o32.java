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
import com.repackage.f32;
import com.repackage.fj2;
import com.repackage.n32;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class o32<T extends n32> extends w74<j94> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes6.dex */
    public class a implements f32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j94 a;
        public final /* synthetic */ o32 b;

        public a(o32 o32Var, j94 j94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o32Var, j94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o32Var;
            this.a = j94Var;
        }

        @Override // com.repackage.f32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.repackage.f32.c
        public void b(PMSDownloadType pMSDownloadType, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cc3Var) == null) {
                this.b.u(this.a, cc3Var);
            }
        }
    }

    public o32(@NonNull T t) {
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
    @Override // com.repackage.z74
    /* renamed from: l */
    public String d(j94 j94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, j94Var)) == null) ? fj2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.repackage.b84
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

    public final void p(j94 j94Var, cc3 cc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j94Var, cc3Var) == null) {
            u(j94Var, cc3Var);
            f32.c().a(j94Var, o(), cc3Var);
        }
    }

    public final void q(@NonNull j94 j94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, j94Var) == null) {
            r(j94Var);
            f32.c().b(j94Var, o());
        }
    }

    public abstract void r(@NonNull j94 j94Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w74, com.repackage.z74
    /* renamed from: s */
    public void e(j94 j94Var, c94 c94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, j94Var, c94Var) == null) {
            super.e(j94Var, c94Var);
            bw2.b("plugin download error: " + c94Var);
            cc3 cc3Var = new cc3();
            cc3Var.k(17L);
            cc3Var.i((long) c94Var.a);
            cc3Var.d(c94Var.b);
            cc3Var.f(c94Var.toString());
            p(j94Var, cc3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w74, com.repackage.z74
    /* renamed from: t */
    public void i(j94 j94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, j94Var) == null) {
            super.i(j94Var);
            if (j94Var == null) {
                bw2.b("download finish, plugin is null");
                cc3 cc3Var = new cc3();
                cc3Var.k(17L);
                cc3Var.i(2201L);
                cc3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, cc3Var);
            } else if (!wd3.a(new File(j94Var.a), j94Var.m)) {
                ng4.M(j94Var.a);
                bw2.b("download finish, check zip sign failure");
                cc3 cc3Var2 = new cc3();
                cc3Var2.k(17L);
                cc3Var2.i(2202L);
                cc3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(j94Var, cc3Var2);
            } else {
                File t = fj2.t(j94Var.g, String.valueOf(j94Var.i));
                ng4.l(t);
                if (t != null && t.exists()) {
                    boolean U = ng4.U(j94Var.a, t.getAbsolutePath());
                    ng4.M(j94Var.a);
                    bw2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        cc3 cc3Var3 = new cc3();
                        cc3Var3.k(17L);
                        cc3Var3.i(2320L);
                        cc3Var3.d("plugin unzip fail.");
                        p(j94Var, cc3Var3);
                        return;
                    }
                    j94Var.c = j94Var.b();
                    j94Var.d = j94Var.b();
                    f84.i().m(j94Var);
                    q(j94Var);
                    return;
                }
                ng4.M(j94Var.a);
                bw2.b("download finish, create file failure, name = " + j94Var.g + " ; version = " + j94Var.i);
                cc3 cc3Var4 = new cc3();
                cc3Var4.k(17L);
                cc3Var4.i(2203L);
                cc3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(j94Var, cc3Var4);
            }
        }
    }

    public abstract void u(j94 j94Var, cc3 cc3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w74, com.repackage.z74
    /* renamed from: v */
    public void c(j94 j94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, j94Var) == null) {
            super.c(j94Var);
            if (j94Var != null) {
                bw2.b("plugin download start: bundleId = " + j94Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.w74, com.repackage.z74
    /* renamed from: w */
    public void f(j94 j94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, j94Var) == null) {
            super.f(j94Var);
            if (j94Var != null) {
                bw2.b("plugin on downloading: bundleId = " + j94Var.g);
            }
            x(j94Var);
        }
    }

    public final void x(j94 j94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, j94Var) == null) {
            f32.c().d(j94Var, new a(this, j94Var));
        }
    }
}
