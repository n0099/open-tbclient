package g.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
/* loaded from: classes7.dex */
public final class f<T, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d.a<T> a;

    /* renamed from: b  reason: collision with root package name */
    public final d.b<? extends R, ? super T> f44835b;

    public f(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.f44835b = bVar;
    }

    @Override // g.d.a, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((g.j) ((g.j) obj));
    }

    public void call(g.j<? super R> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            try {
                g.j jVar2 = (g.j) g.r.c.n(this.f44835b).call(jVar);
                jVar2.d();
                this.a.call(jVar2);
            } catch (Throwable th) {
                g.m.a.e(th);
                jVar.onError(th);
            }
        }
    }
}
