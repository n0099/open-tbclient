package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f5;
import com.repackage.u7;
import com.repackage.y6;
/* loaded from: classes5.dex */
public class e5 extends l1<d5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y6<u7.b<String, f5<d5>>> b;

    /* loaded from: classes5.dex */
    public static class a extends h1<d5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public y6<g5<?>> b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e5(o1 o1Var) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [V, com.repackage.f5] */
    @Override // com.repackage.k1
    /* renamed from: f */
    public y6<f1> a(String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLL;
        y6<f5.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, h3Var, aVar)) == null) {
            ?? r0 = (f5) new m7().d(f5.class, h3Var);
            synchronized (this.b) {
                u7.b<String, f5<d5>> bVar = new u7.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            y6<f1> y6Var = new y6<>();
            y6.b<f5.a> it = b.iterator();
            while (it.hasNext()) {
                f5.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = h3Var.i().a(b1.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == d5.class) {
                    y6Var.a(new f1(next.a, cls, aVar));
                } else {
                    y6Var.a(new f1(next.a, cls));
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
    public d5 d(j1 j1Var, String str, h3 h3Var, a aVar) {
        InterceptResult invokeLLLL;
        f5<d5> f5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, j1Var, str, h3Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i >= this.b.b) {
                        f5Var = null;
                        break;
                    }
                    u7.b<String, f5<d5>> bVar = this.b.get(i);
                    if (bVar.a.equals(str)) {
                        f5Var = bVar.b;
                        this.b.i(i);
                        break;
                    }
                    i++;
                }
            }
            f5Var.d.a(j1Var, f5Var);
            if (aVar != null) {
                y6<g5<?>> y6Var = aVar.b;
                if (y6Var != null) {
                    y6.b<g5<?>> it = y6Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(j1Var, f5Var);
                    }
                }
                f5Var.d.f(aVar.b);
            }
            return f5Var.d;
        }
        return (d5) invokeLLLL.objValue;
    }
}
