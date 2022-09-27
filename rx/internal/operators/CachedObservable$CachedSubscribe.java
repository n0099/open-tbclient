package rx.internal.operators;

import com.baidu.tieba.by9;
import com.baidu.tieba.fx9;
import com.baidu.tieba.lx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements fx9.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2817751667698696782L;
    public transient /* synthetic */ FieldHolder $fh;
    public final by9<T> state;

    public CachedObservable$CachedSubscribe(by9<T> by9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {by9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = by9Var;
    }

    @Override // com.baidu.tieba.fx9.a, com.baidu.tieba.tx9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((lx9) ((lx9) obj));
    }

    public void call(lx9<? super T> lx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lx9Var) == null) {
            CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(lx9Var, this.state);
            this.state.c(cachedObservable$ReplayProducer);
            lx9Var.b(cachedObservable$ReplayProducer);
            lx9Var.f(cachedObservable$ReplayProducer);
            if (get() || !compareAndSet(false, true)) {
                return;
            }
            this.state.d();
        }
    }
}
