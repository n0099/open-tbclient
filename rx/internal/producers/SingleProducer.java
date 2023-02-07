package rx.internal.producers;

import com.baidu.tieba.fda;
import com.baidu.tieba.vca;
import com.baidu.tieba.zca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements vca {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3353584923995471404L;
    public transient /* synthetic */ FieldHolder $fh;
    public final zca<? super T> child;
    public final T value;

    public SingleProducer(zca<? super T> zcaVar, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zcaVar, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.child = zcaVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.vca
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0 && compareAndSet(false, true)) {
                    zca<? super T> zcaVar = this.child;
                    if (zcaVar.isUnsubscribed()) {
                        return;
                    }
                    Object obj = (T) this.value;
                    try {
                        zcaVar.onNext(obj);
                        if (zcaVar.isUnsubscribed()) {
                            return;
                        }
                        zcaVar.onCompleted();
                        return;
                    } catch (Throwable th) {
                        fda.g(th, zcaVar, obj);
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
