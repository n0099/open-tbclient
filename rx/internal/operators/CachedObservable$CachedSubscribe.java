package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dv9;
import com.repackage.tv9;
import com.repackage.xu9;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements xu9.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2817751667698696782L;
    public transient /* synthetic */ FieldHolder $fh;
    public final tv9<T> state;

    public CachedObservable$CachedSubscribe(tv9<T> tv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = tv9Var;
    }

    @Override // com.repackage.xu9.a, com.repackage.lv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dv9) ((dv9) obj));
    }

    public void call(dv9<? super T> dv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
            CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(dv9Var, this.state);
            this.state.c(cachedObservable$ReplayProducer);
            dv9Var.b(cachedObservable$ReplayProducer);
            dv9Var.f(cachedObservable$ReplayProducer);
            if (get() || !compareAndSet(false, true)) {
                return;
            }
            this.state.d();
        }
    }
}
