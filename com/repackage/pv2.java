package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class pv2 extends n32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v12<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final y74<i94> g;

    /* loaded from: classes6.dex */
    public class a extends o32<pv2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pv2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pv2 pv2Var, pv2 pv2Var2) {
            super(pv2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv2Var, pv2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((n32) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pv2Var;
        }

        @Override // com.repackage.o32
        public void r(@NonNull i94 i94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, i94Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.repackage.o32
        public void u(i94 i94Var, cc3 cc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i94Var, cc3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public pv2(String str, String str2, long j, v12<Boolean> v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), v12Var};
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
        this.c = v12Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.repackage.c84
    public void D(b94 b94Var) {
        i94 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b94Var) == null) {
            super.D(b94Var);
            if (b94Var != null) {
                if (b94Var.a == 1010 && (p = qv2.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    e84.i().x(p);
                }
                bw2.b("fetch plugin error: " + b94Var.toString());
            } else {
                bw2.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.c84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            bw2.b("fetch plugin success");
        }
    }

    @Override // com.repackage.c84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            bw2.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.repackage.c84
    public void H(pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pd4Var) == null) {
            super.H(pd4Var);
        }
    }

    @Override // com.repackage.c84
    public y74<i94> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (y74) invokeV.objValue;
    }
}
