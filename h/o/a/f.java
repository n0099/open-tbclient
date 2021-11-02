package h.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
/* loaded from: classes2.dex */
public final class f<T, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d.a<T> f71893e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b<? extends R, ? super T> f71894f;

    public f(d.a<T> aVar, d.b<? extends R, ? super T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71893e = aVar;
        this.f71894f = bVar;
    }

    @Override // h.d.a, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h.j) ((h.j) obj));
    }

    public void call(h.j<? super R> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            try {
                h.j jVar2 = (h.j) h.r.c.n(this.f71894f).call(jVar);
                jVar2.d();
                this.f71893e.call(jVar2);
            } catch (Throwable th) {
                h.m.a.e(th);
                jVar.onError(th);
            }
        }
    }
}
