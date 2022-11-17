package rx.internal.operators;

import com.baidu.tieba.o0a;
import com.baidu.tieba.sz9;
import com.baidu.tieba.yz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements sz9.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2817751667698696782L;
    public transient /* synthetic */ FieldHolder $fh;
    public final o0a<T> state;

    public CachedObservable$CachedSubscribe(o0a<T> o0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o0aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = o0aVar;
    }

    @Override // com.baidu.tieba.sz9.a, com.baidu.tieba.g0a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((yz9) ((yz9) obj));
    }

    public void call(yz9<? super T> yz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yz9Var) == null) {
            CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(yz9Var, this.state);
            this.state.c(cachedObservable$ReplayProducer);
            yz9Var.b(cachedObservable$ReplayProducer);
            yz9Var.f(cachedObservable$ReplayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.d();
            }
        }
    }
}
