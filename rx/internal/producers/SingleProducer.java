package rx.internal.producers;

import com.baidu.tieba.d0a;
import com.baidu.tieba.tz9;
import com.baidu.tieba.xz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements tz9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3353584923995471404L;
    public transient /* synthetic */ FieldHolder $fh;
    public final xz9<? super T> child;
    public final T value;

    public SingleProducer(xz9<? super T> xz9Var, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xz9Var, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = xz9Var;
        this.value = t;
    }

    @Override // com.baidu.tieba.tz9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0 && compareAndSet(false, true)) {
                    xz9<? super T> xz9Var = this.child;
                    if (xz9Var.isUnsubscribed()) {
                        return;
                    }
                    Object obj = (T) this.value;
                    try {
                        xz9Var.onNext(obj);
                        if (xz9Var.isUnsubscribed()) {
                            return;
                        }
                        xz9Var.onCompleted();
                        return;
                    } catch (Throwable th) {
                        d0a.g(th, xz9Var, obj);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
