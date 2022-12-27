package rx.internal.producers;

import com.baidu.tieba.e3a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.o3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements e3a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3353584923995471404L;
    public transient /* synthetic */ FieldHolder $fh;
    public final i3a<? super T> child;
    public final T value;

    public SingleProducer(i3a<? super T> i3aVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i3aVar, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = i3aVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.e3a
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0 && compareAndSet(false, true)) {
                    i3a<? super T> i3aVar = this.child;
                    if (i3aVar.isUnsubscribed()) {
                        return;
                    }
                    Object obj = (T) this.value;
                    try {
                        i3aVar.onNext(obj);
                        if (i3aVar.isUnsubscribed()) {
                            return;
                        }
                        i3aVar.onCompleted();
                        return;
                    } catch (Throwable th) {
                        o3a.g(th, i3aVar, obj);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
