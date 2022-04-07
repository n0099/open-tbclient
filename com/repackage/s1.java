package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s1 extends x1<v3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends h1<v3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public String c;
        public h3 d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(o1 o1Var) {
        super(o1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((o1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.k1
    /* renamed from: d */
    public y6<f1> a(String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, h3Var, aVar)) == null) {
            if (aVar == null || aVar.b == null) {
                return null;
            }
            y6<f1> y6Var = new y6<>();
            y6Var.a(new f1(aVar.b, z3.class));
            return y6Var;
        }
        return (y6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.x1
    /* renamed from: e */
    public v3 c(j1 j1Var, String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLLL;
        h3 h3Var2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, j1Var, str, h3Var, aVar)) == null) {
            v3 v3Var = new v3();
            if (aVar != null && (str2 = aVar.b) != null) {
                v3Var.f(h3Var, (z3) j1Var.j(str2, z3.class), aVar.c);
            } else if (aVar != null && (h3Var2 = aVar.d) != null) {
                v3Var.a(h3Var, h3Var2);
            } else {
                v3Var.a(h3Var, h3Var.i());
            }
            return v3Var;
        }
        return (v3) invokeLLLL.objValue;
    }
}
