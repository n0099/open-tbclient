package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.f;
import i.j;
import i.n.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes4.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends j<T> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final j<? super d<T>> f64960i;

    /* renamed from: j  reason: collision with root package name */
    public final int f64961j;

    /* renamed from: k  reason: collision with root package name */
    public final int f64962k;
    public final AtomicInteger l;
    public int m;
    public i.t.d<T, T> n;

    /* loaded from: classes4.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorWindowWithSize$WindowSkip;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j2);
                } else if (i2 != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = this.this$0;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(i.o.a.a.c(j2, operatorWindowWithSize$WindowSkip.f64962k));
                    } else {
                        operatorWindowWithSize$WindowSkip.e(i.o.a.a.a(i.o.a.a.c(j2, operatorWindowWithSize$WindowSkip.f64961j), i.o.a.a.c(operatorWindowWithSize$WindowSkip.f64962k - operatorWindowWithSize$WindowSkip.f64961j, j2 - 1)));
                    }
                }
            }
        }
    }

    @Override // i.n.a
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.l.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i.t.d<T, T> dVar = this.n;
            if (dVar != null) {
                this.n = null;
                dVar.onCompleted();
            }
            this.f64960i.onCompleted();
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            i.t.d<T, T> dVar = this.n;
            if (dVar != null) {
                this.n = null;
                dVar.onError(th);
            }
            this.f64960i.onError(th);
        }
    }

    @Override // i.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            int i2 = this.m;
            UnicastSubject unicastSubject = this.n;
            if (i2 == 0) {
                this.l.getAndIncrement();
                unicastSubject = UnicastSubject.F(this.f64961j, this);
                this.n = unicastSubject;
                this.f64960i.onNext(unicastSubject);
            }
            int i3 = i2 + 1;
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
            }
            if (i3 == this.f64961j) {
                this.m = i3;
                this.n = null;
                unicastSubject.onCompleted();
            } else if (i3 == this.f64962k) {
                this.m = 0;
            } else {
                this.m = i3;
            }
        }
    }
}
