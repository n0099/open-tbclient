package com.repackage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m5;
import com.repackage.q1.a;
import com.repackage.u7;
import com.repackage.y6;
import com.repackage.z1;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class q1<P extends a> extends l1<e4, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y6<u7.b<String, t4>> b;
    public a c;

    /* loaded from: classes6.dex */
    public static class a extends h1<e4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public z1.b b;

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
            z1.b bVar = new z1.b();
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
    public q1(o1 o1Var) {
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
        this.b = new y6<>();
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.repackage.t4, V] */
    @Override // com.repackage.k1
    /* renamed from: f */
    public y6<f1> a(String str, h3 h3Var, P p) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, h3Var, p)) == null) {
            y6<f1> y6Var = new y6<>();
            ?? h = h(h3Var, p);
            if (h == 0) {
                return y6Var;
            }
            u7.b<String, t4> bVar = new u7.b<>();
            bVar.a = str;
            bVar.b = h;
            synchronized (this.b) {
                this.b.a(bVar);
            }
            z1.b bVar2 = p != null ? p.b : this.c.b;
            y6.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                y6<a5> y6Var2 = it.next().i;
                if (y6Var2 != null) {
                    y6.b<a5> it2 = y6Var2.iterator();
                    while (it2.hasNext()) {
                        y6Var.a(new f1(it2.next().a, Texture.class, bVar2));
                    }
                }
            }
            return y6Var;
        }
        return (y6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l1
    /* renamed from: g */
    public void c(j1 j1Var, String str, h3 h3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, j1Var, str, h3Var, p) == null) {
        }
    }

    public abstract t4 h(h3 h3Var, P p);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l1
    /* renamed from: i */
    public e4 d(j1 j1Var, String str, h3 h3Var, P p) {
        InterceptResult invokeLLLL;
        t4 t4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, j1Var, str, h3Var, p)) == null) {
            synchronized (this.b) {
                t4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        t4Var = this.b.get(i).b;
                        this.b.i(i);
                    }
                }
            }
            if (t4Var == null) {
                return null;
            }
            e4 e4Var = new e4(t4Var, new m5.a(j1Var));
            Iterator<f7> it = e4Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return e4Var;
        }
        return (e4) invokeLLLL.objValue;
    }
}
