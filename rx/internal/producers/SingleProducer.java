package rx.internal.producers;

import com.baidu.tieba.dy9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer extends AtomicBoolean implements zx9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3353584923995471404L;
    public transient /* synthetic */ FieldHolder $fh;
    public final dy9 child;
    public final Object value;

    public SingleProducer(dy9 dy9Var, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dy9Var, obj};
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
        this.value = obj;
    }

    @Override // com.baidu.tieba.zx9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0 && compareAndSet(false, true)) {
                    dy9 dy9Var = this.child;
                    if (dy9Var.isUnsubscribed()) {
                        return;
                    }
                    Object obj = this.value;
                    try {
                        dy9Var.onNext(obj);
                        if (dy9Var.isUnsubscribed()) {
                            return;
                        }
                        dy9Var.onCompleted();
                        return;
                    } catch (Throwable th) {
                        jy9.g(th, dy9Var, obj);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
