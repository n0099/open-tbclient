package rx.internal.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import i.j;
import i.m.a;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public transient /* synthetic */ FieldHolder $fh;
    public final j<? super T> child;
    public T value;

    public SingleDelayedProducer(j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
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
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void emit(j<? super T> jVar, T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, jVar, t) == null) || jVar.isUnsubscribed()) {
            return;
        }
        try {
            jVar.onNext(t);
            if (jVar.isUnsubscribed()) {
                return;
            }
            jVar.onCompleted();
        } catch (Throwable th) {
            a.g(th, jVar, t);
        }
    }

    @Override // i.f
    public void request(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (i2 == 0) {
                return;
            }
            do {
                int i3 = get();
                if (i3 != 0) {
                    if (i3 == 1 && compareAndSet(1, 3)) {
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
                int i2 = get();
                if (i2 == 0) {
                    this.value = t;
                } else if (i2 == 2 && compareAndSet(2, 3)) {
                    emit(this.child, t);
                    return;
                } else {
                    return;
                }
            } while (!compareAndSet(0, 1));
        }
    }
}
