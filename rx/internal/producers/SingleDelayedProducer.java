package rx.internal.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d3a;
import com.baidu.tieba.h3a;
import com.baidu.tieba.n3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements d3a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public transient /* synthetic */ FieldHolder $fh;
    public final h3a<? super T> child;
    public T value;

    public SingleDelayedProducer(h3a<? super T> h3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = h3aVar;
    }

    public void setValue(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            do {
                int i = get();
                if (i == 0) {
                    this.value = t;
                } else if (i == 2 && compareAndSet(2, 3)) {
                    emit(this.child, t);
                    return;
                } else {
                    return;
                }
            } while (!compareAndSet(0, 1));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void emit(h3a<? super T> h3aVar, T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, h3aVar, t) != null) || h3aVar.isUnsubscribed()) {
            return;
        }
        try {
            h3aVar.onNext(t);
            if (h3aVar.isUnsubscribed()) {
                return;
            }
            h3aVar.onCompleted();
        } catch (Throwable th) {
            n3a.g(th, h3aVar, t);
        }
    }

    @Override // com.baidu.tieba.d3a
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i == 0) {
                    return;
                }
                do {
                    int i2 = get();
                    if (i2 != 0) {
                        if (i2 == 1 && compareAndSet(1, 3)) {
                            emit(this.child, this.value);
                            return;
                        }
                        return;
                    }
                } while (!compareAndSet(0, 2));
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
