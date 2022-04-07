package com.repackage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s3;
import com.repackage.z1;
import com.repackage.z3;
/* loaded from: classes6.dex */
public class m1 extends l1<s3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s3.a b;

    /* loaded from: classes6.dex */
    public static class a extends h1<s3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public s3.a f;
        public String g;

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
            this.c = false;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.d = textureFilter;
            this.e = textureFilter;
            this.f = null;
            this.g = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(o1 o1Var) {
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
    /* renamed from: f */
    public y6<f1> a(String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        s3.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, h3Var, aVar)) == null) {
            y6<f1> y6Var = new y6<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return y6Var;
            }
            this.b = new s3.a(h3Var, aVar != null && aVar.b);
            if (aVar != null && (str2 = aVar.g) != null) {
                y6Var.a(new f1(str2, z3.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    h3 b = b(this.b.c(i));
                    z1.b bVar = new z1.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    y6Var.a(new f1(b, Texture.class, bVar));
                }
            }
            return y6Var;
        }
        return (y6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l1
    /* renamed from: g */
    public void c(j1 j1Var, String str, h3 h3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, j1Var, str, h3Var, aVar) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l1
    /* renamed from: h */
    public s3 d(j1 j1Var, String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, j1Var, str, h3Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = h3Var.s(this.b.b[0]).h().toString();
                z3.a f = ((z3) j1Var.j(str2, z3.class)).f(str3);
                if (f != null) {
                    return new s3(h3Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            y6 y6Var = new y6(length);
            for (int i = 0; i < length; i++) {
                y6Var.a(new a4((Texture) j1Var.j(this.b.c(i), Texture.class)));
            }
            return new s3(this.b, (y6<a4>) y6Var, true);
        }
        return (s3) invokeLLLL.objValue;
    }
}
