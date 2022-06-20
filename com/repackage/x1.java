package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class x1 extends o1<x5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public String c;

    /* loaded from: classes7.dex */
    public static class a extends k1<x5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public String c;
        public boolean d;
        public String e;
        public String f;

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
                    return;
                }
            }
            this.d = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(r1 r1Var) {
        super(r1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ".vert";
        this.c = ".frag";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n1
    /* renamed from: f */
    public a7<i1> a(String str, j3 j3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, j3Var, aVar)) == null) {
            return null;
        }
        return (a7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o1
    /* renamed from: g */
    public void c(m1 m1Var, String str, j3 j3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, m1Var, str, j3Var, aVar) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o1
    /* renamed from: h */
    public x5 d(m1 m1Var, String str, j3 j3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, m1Var, str, j3Var, aVar)) == null) {
            String str3 = null;
            if (aVar != null) {
                String str4 = aVar.b;
                if (str4 == null) {
                    str4 = null;
                }
                str2 = aVar.c;
                if (str2 == null) {
                    str2 = null;
                }
                str3 = str4;
            } else {
                str2 = null;
            }
            if (str3 == null && str.endsWith(this.c)) {
                str3 = str.substring(0, str.length() - this.c.length()) + this.b;
            }
            if (str2 == null && str.endsWith(this.b)) {
                str2 = str.substring(0, str.length() - this.b.length()) + this.c;
            }
            j3 b = str3 == null ? j3Var : b(str3);
            if (str2 != null) {
                j3Var = b(str2);
            }
            String o = b.o();
            String o2 = b.equals(j3Var) ? o : j3Var.o();
            if (aVar != null) {
                if (aVar.e != null) {
                    o = aVar.e + o;
                }
                if (aVar.f != null) {
                    o2 = aVar.f + o2;
                }
            }
            x5 x5Var = new x5(o, o2);
            if ((aVar == null || aVar.d) && !x5Var.o()) {
                m1Var.p().b("ShaderProgram " + str + " failed to compile:\n" + x5Var.l());
            }
            return x5Var;
        }
        return (x5) invokeLLLL.objValue;
    }
}
