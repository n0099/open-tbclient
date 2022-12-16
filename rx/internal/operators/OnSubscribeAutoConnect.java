package rx.internal.operators;

import com.baidu.tieba.b3a;
import com.baidu.tieba.f7a;
import com.baidu.tieba.h3a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.p3a;
import com.baidu.tieba.z6a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements b3a.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p3a<? super i3a> connection;
    public final int numberOfSubscribers;
    public final z6a<? extends T> source;

    public OnSubscribeAutoConnect(z6a<? extends T> z6aVar, int i, p3a<? super i3a> p3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z6aVar, Integer.valueOf(i), p3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i > 0) {
            this.source = z6aVar;
            this.numberOfSubscribers = i;
            this.connection = p3aVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(h3a<? super T> h3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h3aVar) == null) {
            this.source.B(f7a.c(h3aVar));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }

    @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h3a) ((h3a) obj));
    }
}
