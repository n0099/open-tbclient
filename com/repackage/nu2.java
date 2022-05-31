package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nu2 extends l22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t02<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final w64<g84> g;

    /* loaded from: classes6.dex */
    public class a extends m22<nu2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nu2 nu2Var, nu2 nu2Var2) {
            super(nu2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nu2Var, nu2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l22) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nu2Var;
        }

        @Override // com.repackage.m22
        public void r(@NonNull g84 g84Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g84Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.repackage.m22
        public void u(g84 g84Var, ab3 ab3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g84Var, ab3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public nu2(String str, String str2, long j, t02<Boolean> t02Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), t02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, this);
        this.c = t02Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.repackage.a74
    public void D(z74 z74Var) {
        g84 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z74Var) == null) {
            super.D(z74Var);
            if (z74Var != null) {
                if (z74Var.a == 1010 && (p = ou2.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    c74.i().x(p);
                }
                zu2.b("fetch plugin error: " + z74Var.toString());
            } else {
                zu2.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.a74
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            zu2.b("fetch plugin success");
        }
    }

    @Override // com.repackage.a74
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            zu2.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.a74
    public void H(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nc4Var) == null) {
            super.H(nc4Var);
        }
    }

    @Override // com.repackage.a74
    public w64<g84> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (w64) invokeV.objValue;
    }
}
