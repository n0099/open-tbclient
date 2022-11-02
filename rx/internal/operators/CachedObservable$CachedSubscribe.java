package rx.internal.operators;

import com.baidu.tieba.c0a;
import com.baidu.tieba.gz9;
import com.baidu.tieba.mz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements gz9.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2817751667698696782L;
    public transient /* synthetic */ FieldHolder $fh;
    public final c0a<T> state;

    public CachedObservable$CachedSubscribe(c0a<T> c0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = c0aVar;
    }

    @Override // com.baidu.tieba.gz9.a, com.baidu.tieba.uz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mz9) ((mz9) obj));
    }

    public void call(mz9<? super T> mz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mz9Var) == null) {
            CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(mz9Var, this.state);
            this.state.c(cachedObservable$ReplayProducer);
            mz9Var.b(cachedObservable$ReplayProducer);
            mz9Var.f(cachedObservable$ReplayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.d();
            }
        }
    }
}
