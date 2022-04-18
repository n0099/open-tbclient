package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz9;
import com.repackage.dz9;
import com.repackage.hz9;
import com.repackage.oz9;
import com.repackage.u3a;
import com.repackage.wz9;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes8.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends hz9<T> implements oz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hz9<? super bz9<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public int i;
    public u3a<T, T> j;

    /* loaded from: classes8.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements dz9 {
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

        @Override // com.repackage.dz9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = this.this$0;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(wz9.c(j, operatorWindowWithSize$WindowSkip.g));
                    } else {
                        operatorWindowWithSize$WindowSkip.e(wz9.a(wz9.c(j, operatorWindowWithSize$WindowSkip.f), wz9.c(operatorWindowWithSize$WindowSkip.g - operatorWindowWithSize$WindowSkip.f, j - 1)));
                    }
                }
            }
        }
    }

    @Override // com.repackage.oz9
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.repackage.cz9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u3a<T, T> u3aVar = this.j;
            if (u3aVar != null) {
                this.j = null;
                u3aVar.onCompleted();
            }
            this.e.onCompleted();
        }
    }

    @Override // com.repackage.cz9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            u3a<T, T> u3aVar = this.j;
            if (u3aVar != null) {
                this.j = null;
                u3aVar.onError(th);
            }
            this.e.onError(th);
        }
    }

    @Override // com.repackage.cz9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            int i = this.i;
            UnicastSubject unicastSubject = this.j;
            if (i == 0) {
                this.h.getAndIncrement();
                unicastSubject = UnicastSubject.F(this.f, this);
                this.j = unicastSubject;
                this.e.onNext(unicastSubject);
            }
            int i2 = i + 1;
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
            }
            if (i2 == this.f) {
                this.i = i2;
                this.j = null;
                unicastSubject.onCompleted();
            } else if (i2 == this.g) {
                this.i = 0;
            } else {
                this.i = i2;
            }
        }
    }
}
