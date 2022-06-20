package com.repackage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b4;
import com.repackage.c2;
import com.repackage.u3;
/* loaded from: classes6.dex */
public class p1 extends o1<u3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u3.a b;

    /* loaded from: classes6.dex */
    public static class a extends k1<u3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public u3.a f;
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
    public p1(r1 r1Var) {
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
    /* renamed from: f */
    public a7<i1> a(String str, j3 j3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        u3.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, j3Var, aVar)) == null) {
            a7<i1> a7Var = new a7<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return a7Var;
            }
            this.b = new u3.a(j3Var, aVar != null && aVar.b);
            if (aVar != null && (str2 = aVar.g) != null) {
                a7Var.a(new i1(str2, b4.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    j3 b = b(this.b.c(i));
                    c2.b bVar = new c2.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    a7Var.a(new i1(b, Texture.class, bVar));
                }
            }
            return a7Var;
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
    public u3 d(m1 m1Var, String str, j3 j3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, m1Var, str, j3Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = j3Var.s(this.b.b[0]).h().toString();
                b4.a f = ((b4) m1Var.j(str2, b4.class)).f(str3);
                if (f != null) {
                    return new u3(j3Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            a7 a7Var = new a7(length);
            for (int i = 0; i < length; i++) {
                a7Var.a(new c4((Texture) m1Var.j(this.b.c(i), Texture.class)));
            }
            return new u3(this.b, (a7<c4>) a7Var, true);
        }
        return (u3) invokeLLLL.objValue;
    }
}
