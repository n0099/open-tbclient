package rx.internal.producers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dv9;
import com.repackage.jv9;
import com.repackage.zu9;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class SingleProducer<T> extends AtomicBoolean implements zu9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3353584923995471404L;
    public transient /* synthetic */ FieldHolder $fh;
    public final dv9<? super T> child;
    public final T value;

    public SingleProducer(dv9<? super T> dv9Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dv9Var, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = dv9Var;
        this.value = t;
    }

    @Override // com.repackage.zu9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0 && compareAndSet(false, true)) {
                    dv9<? super T> dv9Var = this.child;
                    if (dv9Var.isUnsubscribed()) {
                        return;
                    }
                    Object obj = (T) this.value;
                    try {
                        dv9Var.onNext(obj);
                        if (dv9Var.isUnsubscribed()) {
                            return;
                        }
                        dv9Var.onCompleted();
                        return;
                    } catch (Throwable th) {
                        jv9.g(th, dv9Var, obj);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
