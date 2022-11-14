package rx.internal.operators;

import com.baidu.tieba.n0a;
import com.baidu.tieba.rz9;
import com.baidu.tieba.xz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements rz9.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2817751667698696782L;
    public transient /* synthetic */ FieldHolder $fh;
    public final n0a<T> state;

    public CachedObservable$CachedSubscribe(n0a<T> n0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n0aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = n0aVar;
    }

    @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xz9) ((xz9) obj));
    }

    public void call(xz9<? super T> xz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xz9Var) == null) {
            CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(xz9Var, this.state);
            this.state.c(cachedObservable$ReplayProducer);
            xz9Var.b(cachedObservable$ReplayProducer);
            xz9Var.f(cachedObservable$ReplayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.d();
            }
        }
    }
}
