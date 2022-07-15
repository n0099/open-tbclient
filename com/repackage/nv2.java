package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nv2 extends l32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t12<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final w74<g94> g;

    /* loaded from: classes6.dex */
    public class a extends m32<nv2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nv2 nv2Var, nv2 nv2Var2) {
            super(nv2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv2Var, nv2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((l32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv2Var;
        }

        @Override // com.repackage.m32
        public void r(@NonNull g94 g94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g94Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.repackage.m32
        public void u(g94 g94Var, ac3 ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g94Var, ac3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public nv2(String str, String str2, long j, t12<Boolean> t12Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), t12Var};
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
        this.c = t12Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.repackage.a84
    public void C(z84 z84Var) {
        g94 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z84Var) == null) {
            super.C(z84Var);
            if (z84Var != null) {
                if (z84Var.a == 1010 && (p = ov2.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    c84.i().x(p);
                }
                zv2.b("fetch plugin error: " + z84Var.toString());
            } else {
                zv2.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.a84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            zv2.b("fetch plugin success");
        }
    }

    @Override // com.repackage.a84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            zv2.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.a84
    public void G(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nd4Var) == null) {
            super.G(nd4Var);
        }
    }

    @Override // com.repackage.a84
    public w74<g94> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (w74) invokeV.objValue;
    }
}
