package com.repackage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a7;
import com.repackage.c2;
import com.repackage.o5;
import com.repackage.t1.a;
import com.repackage.w7;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class t1<P extends a> extends o1<g4, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a7<w7.b<String, v4>> b;
    public a c;

    /* loaded from: classes7.dex */
    public static class a extends k1<g4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c2.b b;

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
            c2.b bVar = new c2.b();
            this.b = bVar;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Linear;
            bVar.g = textureFilter;
            bVar.f = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.Repeat;
            bVar.i = textureWrap;
            bVar.h = textureWrap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t1(r1 r1Var) {
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
        this.b = new a7<>();
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [V, com.repackage.v4] */
    @Override // com.repackage.n1
    /* renamed from: f */
    public a7<i1> a(String str, j3 j3Var, P p) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, j3Var, p)) == null) {
            a7<i1> a7Var = new a7<>();
            ?? h = h(j3Var, p);
            if (h == 0) {
                return a7Var;
            }
            w7.b<String, v4> bVar = new w7.b<>();
            bVar.a = str;
            bVar.b = h;
            synchronized (this.b) {
                this.b.a(bVar);
            }
            c2.b bVar2 = p != null ? p.b : this.c.b;
            a7.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                a7<c5> a7Var2 = it.next().i;
                if (a7Var2 != null) {
                    a7.b<c5> it2 = a7Var2.iterator();
                    while (it2.hasNext()) {
                        a7Var.a(new i1(it2.next().a, Texture.class, bVar2));
                    }
                }
            }
            return a7Var;
        }
        return (a7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o1
    /* renamed from: g */
    public void c(m1 m1Var, String str, j3 j3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, m1Var, str, j3Var, p) == null) {
        }
    }

    public abstract v4 h(j3 j3Var, P p);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.o1
    /* renamed from: i */
    public g4 d(m1 m1Var, String str, j3 j3Var, P p) {
        InterceptResult invokeLLLL;
        v4 v4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, m1Var, str, j3Var, p)) == null) {
            synchronized (this.b) {
                v4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        v4Var = this.b.get(i).b;
                        this.b.i(i);
                    }
                }
            }
            if (v4Var == null) {
                return null;
            }
            g4 g4Var = new g4(v4Var, new o5.a(m1Var));
            Iterator<h7> it = g4Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return g4Var;
        }
        return (g4) invokeLLLL.objValue;
    }
}
