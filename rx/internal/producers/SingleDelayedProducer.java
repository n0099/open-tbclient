package rx.internal.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class SingleDelayedProducer extends AtomicInteger implements zx9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public transient /* synthetic */ FieldHolder $fh;
    public final dy9 child;
    public Object value;

    public SingleDelayedProducer(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dy9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = dy9Var;
    }

    public void setValue(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            do {
                int i = get();
                if (i == 0) {
                    this.value = obj;
                } else if (i == 2 && compareAndSet(2, 3)) {
                    emit(this.child, obj);
                    return;
                } else {
                    return;
                }
            } while (!compareAndSet(0, 1));
        }
    }

    public static void emit(dy9 dy9Var, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, dy9Var, obj) != null) || dy9Var.isUnsubscribed()) {
            return;
        }
        try {
            dy9Var.onNext(obj);
            if (dy9Var.isUnsubscribed()) {
                return;
            }
            dy9Var.onCompleted();
        } catch (Throwable th) {
            jy9.g(th, dy9Var, obj);
        }
    }

    @Override // com.baidu.tieba.zx9
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
