package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class aw2 extends y32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g22<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final j84<t94> g;

    /* loaded from: classes5.dex */
    public class a extends z32<aw2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(aw2 aw2Var, aw2 aw2Var2) {
            super(aw2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw2Var, aw2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((y32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aw2Var;
        }

        @Override // com.repackage.z32
        public void r(@NonNull t94 t94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t94Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.repackage.z32
        public void u(t94 t94Var, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t94Var, nc3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public aw2(String str, String str2, long j, g22<Boolean> g22Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), g22Var};
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
        this.c = g22Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.repackage.n84
    public void D(m94 m94Var) {
        t94 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m94Var) == null) {
            super.D(m94Var);
            if (m94Var != null) {
                if (m94Var.a == 1010 && (p = bw2.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    p84.i().x(p);
                }
                mw2.b("fetch plugin error: " + m94Var.toString());
            } else {
                mw2.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.n84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            mw2.b("fetch plugin success");
        }
    }

    @Override // com.repackage.n84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            mw2.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.n84
    public void H(ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ae4Var) == null) {
            super.H(ae4Var);
        }
    }

    @Override // com.repackage.n84
    public j84<t94> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (j84) invokeV.objValue;
    }
}
