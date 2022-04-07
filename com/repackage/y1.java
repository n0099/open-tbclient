package com.repackage;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.y6;
import com.repackage.z1;
import com.repackage.z3;
/* loaded from: classes7.dex */
public class y1 extends x1<z3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z3.c b;

    /* loaded from: classes7.dex */
    public static class a extends h1<z3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;

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
            this.b = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(o1 o1Var) {
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
            h3 i = h3Var.i();
            if (aVar != null) {
                this.b = new z3.c(h3Var, i, aVar.b);
            } else {
                this.b = new z3.c(h3Var, i, false);
            }
            y6<f1> y6Var = new y6<>();
            y6.b<z3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                z3.c.p next = it.next();
                z1.b bVar = new z1.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                y6Var.a(new f1(next.a, Texture.class, bVar));
            }
            return y6Var;
        }
        return (y6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.x1
    /* renamed from: e */
    public z3 c(j1 j1Var, String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, j1Var, str, h3Var, aVar)) == null) {
            y6.b<z3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                z3.c.p next = it.next();
                next.b = (Texture) j1Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            z3 z3Var = new z3(this.b);
            this.b = null;
            return z3Var;
        }
        return (z3) invokeLLLL.objValue;
    }
}
