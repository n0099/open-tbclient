package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.f;
import g.j;
import g.n.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.subjects.UnicastSubject;
/* loaded from: classes8.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends j<T> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final j<? super d<T>> f45438e;

    /* renamed from: f  reason: collision with root package name */
    public final int f45439f;

    /* renamed from: g  reason: collision with root package name */
    public final int f45440g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicInteger f45441h;
    public int i;
    public g.t.d<T, T> j;

    /* loaded from: classes8.dex */
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

        @Override // g.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = this.this$0;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(g.o.a.a.c(j, operatorWindowWithSize$WindowSkip.f45440g));
                    } else {
                        operatorWindowWithSize$WindowSkip.e(g.o.a.a.a(g.o.a.a.c(j, operatorWindowWithSize$WindowSkip.f45439f), g.o.a.a.c(operatorWindowWithSize$WindowSkip.f45440g - operatorWindowWithSize$WindowSkip.f45439f, j - 1)));
                    }
                }
            }
        }
    }

    @Override // g.n.a
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45441h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // g.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            g.t.d<T, T> dVar = this.j;
            if (dVar != null) {
                this.j = null;
                dVar.onCompleted();
            }
            this.f45438e.onCompleted();
        }
    }

    @Override // g.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            g.t.d<T, T> dVar = this.j;
            if (dVar != null) {
                this.j = null;
                dVar.onError(th);
            }
            this.f45438e.onError(th);
        }
    }

    @Override // g.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            int i = this.i;
            UnicastSubject unicastSubject = this.j;
            if (i == 0) {
                this.f45441h.getAndIncrement();
                unicastSubject = UnicastSubject.F(this.f45439f, this);
                this.j = unicastSubject;
                this.f45438e.onNext(unicastSubject);
            }
            int i2 = i + 1;
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
            }
            if (i2 == this.f45439f) {
                this.i = i2;
                this.j = null;
                unicastSubject.onCompleted();
            } else if (i2 == this.f45440g) {
                this.i = 0;
            } else {
                this.i = i2;
            }
        }
    }
}
