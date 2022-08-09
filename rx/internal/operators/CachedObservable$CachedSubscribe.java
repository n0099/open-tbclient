package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lv9;
import com.repackage.pu9;
import com.repackage.vu9;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements pu9.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -2817751667698696782L;
    public transient /* synthetic */ FieldHolder $fh;
    public final lv9<T> state;

    public CachedObservable$CachedSubscribe(lv9<T> lv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.state = lv9Var;
    }

    @Override // com.repackage.pu9.a, com.repackage.dv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((vu9) ((vu9) obj));
    }

    public void call(vu9<? super T> vu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vu9Var) == null) {
            CachedObservable$ReplayProducer<T> cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer<>(vu9Var, this.state);
            this.state.c(cachedObservable$ReplayProducer);
            vu9Var.b(cachedObservable$ReplayProducer);
            vu9Var.f(cachedObservable$ReplayProducer);
            if (get() || !compareAndSet(false, true)) {
                return;
            }
            this.state.d();
        }
    }
}
