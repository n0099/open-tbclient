package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.j;
import i.k;
import i.n.b;
import i.p.a;
import i.q.f;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b<? super k> connection;
    public final int numberOfSubscribers;
    public final a<? extends T> source;

    public OnSubscribeAutoConnect(a<? extends T> aVar, int i2, b<? super k> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i2), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i2 > 0) {
            this.source = aVar;
            this.numberOfSubscribers = i2;
            this.connection = bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // i.d.a, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public void call(j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            this.source.D(f.c(jVar));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.E(this.connection);
            }
        }
    }
}
