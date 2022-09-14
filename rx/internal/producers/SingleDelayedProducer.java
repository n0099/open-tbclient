package rx.internal.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cx9;
import com.baidu.tieba.sw9;
import com.baidu.tieba.ww9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements sw9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public transient /* synthetic */ FieldHolder $fh;
    public final ww9<? super T> child;
    public T value;

    public SingleDelayedProducer(ww9<? super T> ww9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ww9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = ww9Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void emit(ww9<? super T> ww9Var, T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, ww9Var, t) == null) || ww9Var.isUnsubscribed()) {
            return;
        }
        try {
            ww9Var.onNext(t);
            if (ww9Var.isUnsubscribed()) {
                return;
            }
            ww9Var.onCompleted();
        } catch (Throwable th) {
            cx9.g(th, ww9Var, t);
        }
    }

    @Override // com.baidu.tieba.sw9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
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
        }
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
}
