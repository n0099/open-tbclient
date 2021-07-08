package rx.internal.producers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.f;
import h.j;
import h.m.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3353584923995471404L;
    public transient /* synthetic */ FieldHolder $fh;
    public final j<? super T> child;
    public final T value;

    public SingleProducer(j<? super T> jVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = jVar;
        this.value = t;
    }

    @Override // h.f
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 >= 0) {
                if (i2 != 0 && compareAndSet(false, true)) {
                    j<? super T> jVar = this.child;
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    Object obj = (T) this.value;
                    try {
                        jVar.onNext(obj);
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        jVar.onCompleted();
                        return;
                    } catch (Throwable th) {
                        a.g(th, jVar, obj);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
