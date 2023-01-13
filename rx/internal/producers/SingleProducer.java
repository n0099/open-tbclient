package rx.internal.producers;

import com.baidu.tieba.m8a;
import com.baidu.tieba.q8a;
import com.baidu.tieba.w8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements m8a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3353584923995471404L;
    public transient /* synthetic */ FieldHolder $fh;
    public final q8a<? super T> child;
    public final T value;

    public SingleProducer(q8a<? super T> q8aVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q8aVar, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = q8aVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.m8a
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0 && compareAndSet(false, true)) {
                    q8a<? super T> q8aVar = this.child;
                    if (q8aVar.isUnsubscribed()) {
                        return;
                    }
                    Object obj = (T) this.value;
                    try {
                        q8aVar.onNext(obj);
                        if (q8aVar.isUnsubscribed()) {
                            return;
                        }
                        q8aVar.onCompleted();
                        return;
                    } catch (Throwable th) {
                        w8a.g(th, q8aVar, obj);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
