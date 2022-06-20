package com.repackage;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a7;
import com.repackage.b4;
import com.repackage.c2;
/* loaded from: classes5.dex */
public class b2 extends a2<b4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b4.c b;

    /* loaded from: classes5.dex */
    public static class a extends k1<b4> {
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
    public b2(r1 r1Var) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.n1
    /* renamed from: d */
    public a7<i1> a(String str, j3 j3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, j3Var, aVar)) == null) {
            j3 i = j3Var.i();
            if (aVar != null) {
                this.b = new b4.c(j3Var, i, aVar.b);
            } else {
                this.b = new b4.c(j3Var, i, false);
            }
            a7<i1> a7Var = new a7<>();
            a7.b<b4.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                b4.c.p next = it.next();
                c2.b bVar = new c2.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                a7Var.a(new i1(next.a, Texture.class, bVar));
            }
            return a7Var;
        }
        return (a7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.a2
    /* renamed from: e */
    public b4 c(m1 m1Var, String str, j3 j3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, m1Var, str, j3Var, aVar)) == null) {
            a7.b<b4.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                b4.c.p next = it.next();
                next.b = (Texture) m1Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            b4 b4Var = new b4(this.b);
            this.b = null;
            return b4Var;
        }
        return (b4) invokeLLLL.objValue;
    }
}
