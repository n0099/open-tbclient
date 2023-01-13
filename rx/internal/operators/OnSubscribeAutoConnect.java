package rx.internal.operators;

import com.baidu.tieba.ica;
import com.baidu.tieba.k8a;
import com.baidu.tieba.oca;
import com.baidu.tieba.q8a;
import com.baidu.tieba.r8a;
import com.baidu.tieba.y8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements k8a.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y8a<? super r8a> connection;
    public final int numberOfSubscribers;
    public final ica<? extends T> source;

    public OnSubscribeAutoConnect(ica<? extends T> icaVar, int i, y8a<? super r8a> y8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {icaVar, Integer.valueOf(i), y8aVar};
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
            this.source = icaVar;
            this.numberOfSubscribers = i;
            this.connection = y8aVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(q8a<? super T> q8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q8aVar) == null) {
            this.source.B(oca.c(q8aVar));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }

    @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((q8a) ((q8a) obj));
    }
}
