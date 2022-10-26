package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.ky9;
import com.baidu.tieba.p2a;
import com.baidu.tieba.sy9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes9.dex */
public final class OperatorWindowWithSize$WindowSkip extends dy9 implements ky9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dy9 e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public p2a j;

    /* loaded from: classes9.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements zx9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4625807964358024108L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OperatorWindowWithSize$WindowSkip this$0;

        public WindowSkipProducer(OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operatorWindowWithSize$WindowSkip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorWindowWithSize$WindowSkip;
        }

        @Override // com.baidu.tieba.zx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i != 0) {
                        OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = this.this$0;
                        if (get() || !compareAndSet(false, true)) {
                            operatorWindowWithSize$WindowSkip.e(sy9.c(j, operatorWindowWithSize$WindowSkip.g));
                            return;
                        } else {
                            operatorWindowWithSize$WindowSkip.e(sy9.a(sy9.c(j, operatorWindowWithSize$WindowSkip.f), sy9.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                            return;
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }
    }

    @Override // com.baidu.tieba.ky9
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p2a p2aVar = this.j;
            if (p2aVar != null) {
                this.j = null;
                p2aVar.onCompleted();
            }
            this.e.onCompleted();
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            p2a p2aVar = this.j;
            if (p2aVar != null) {
                this.j = null;
                p2aVar.onError(th);
            }
            this.e.onError(th);
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            int i = this.i;
            p2a p2aVar = this.j;
            if (i == 0) {
                this.h.getAndIncrement();
                p2aVar = UnicastSubject.D(this.f, this);
                this.j = p2aVar;
                this.e.onNext(p2aVar);
            }
            int i2 = i + 1;
            if (p2aVar != null) {
                p2aVar.onNext(obj);
            }
            if (i2 == this.f) {
                this.i = i2;
                this.j = null;
                p2aVar.onCompleted();
            } else if (i2 == this.g) {
                this.i = 0;
            } else {
                this.i = i2;
            }
        }
    }
}
