package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ov2 extends m32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u12<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final x74<h94> g;

    /* loaded from: classes6.dex */
    public class a extends n32<ov2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ov2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ov2 ov2Var, ov2 ov2Var2) {
            super(ov2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ov2Var, ov2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((m32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ov2Var;
        }

        @Override // com.repackage.n32
        public void r(@NonNull h94 h94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h94Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.repackage.n32
        public void u(h94 h94Var, bc3 bc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h94Var, bc3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public ov2(String str, String str2, long j, u12<Boolean> u12Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), u12Var};
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
        this.c = u12Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.repackage.b84
    public void C(a94 a94Var) {
        h94 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a94Var) == null) {
            super.C(a94Var);
            if (a94Var != null) {
                if (a94Var.a == 1010 && (p = pv2.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    d84.i().x(p);
                }
                aw2.b("fetch plugin error: " + a94Var.toString());
            } else {
                aw2.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.b84
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            aw2.b("fetch plugin success");
        }
    }

    @Override // com.repackage.b84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            aw2.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.b84
    public void G(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, od4Var) == null) {
            super.G(od4Var);
        }
    }

    @Override // com.repackage.b84
    public x74<h94> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (x74) invokeV.objValue;
    }
}
