package rx.internal.producers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as9;
import com.repackage.gs9;
import com.repackage.wr9;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class SingleProducer<T> extends AtomicBoolean implements wr9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3353584923995471404L;
    public transient /* synthetic */ FieldHolder $fh;
    public final as9<? super T> child;
    public final T value;

    public SingleProducer(as9<? super T> as9Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {as9Var, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = as9Var;
        this.value = t;
    }

    @Override // com.repackage.wr9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0 && compareAndSet(false, true)) {
                    as9<? super T> as9Var = this.child;
                    if (as9Var.isUnsubscribed()) {
                        return;
                    }
                    Object obj = (T) this.value;
                    try {
                        as9Var.onNext(obj);
                        if (as9Var.isUnsubscribed()) {
                            return;
                        }
                        as9Var.onCompleted();
                        return;
                    } catch (Throwable th) {
                        gs9.g(th, as9Var, obj);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
