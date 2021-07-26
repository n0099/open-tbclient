package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.e;
import h.j;
import h.t.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class BufferUntilSubscriber<T> extends d<T, T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final e f73631h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final State<T> f73632f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f73633g;

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicReference<e<? super T>> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8026705089538090368L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConcurrentLinkedQueue<Object> buffer;
        public boolean emitting;
        public final Object guard;

        public State() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.guard = new Object();
            this.buffer = new ConcurrentLinkedQueue<>();
        }

        public boolean casObserverRef(e<? super T> eVar, e<? super T> eVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, eVar2)) == null) ? compareAndSet(eVar, eVar2) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            }
        }

        @Override // h.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b<T> implements d.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final State<T> f73634e;

        /* loaded from: classes9.dex */
        public class a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f73635e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73635e = bVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73635e.f73634e.set(BufferUntilSubscriber.f73631h);
                }
            }
        }

        public b(State<T> state) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {state};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73634e = state;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, jVar) != null) {
                return;
            }
            if (this.f73634e.casObserverRef(null, jVar)) {
                jVar.add(h.u.e.a(new a(this)));
                synchronized (this.f73634e.guard) {
                    z = true;
                    if (this.f73634e.emitting) {
                        z = false;
                    } else {
                        this.f73634e.emitting = true;
                    }
                }
                if (!z) {
                    return;
                }
                while (true) {
                    Object poll = this.f73634e.buffer.poll();
                    if (poll != null) {
                        NotificationLite.a(this.f73634e.get(), poll);
                    } else {
                        synchronized (this.f73634e.guard) {
                            if (this.f73634e.buffer.isEmpty()) {
                                this.f73634e.emitting = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                jVar.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-381439062, "Lrx/internal/operators/BufferUntilSubscriber;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-381439062, "Lrx/internal/operators/BufferUntilSubscriber;");
                return;
            }
        }
        f73631h = new a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferUntilSubscriber(State<T> state) {
        super(new b(state));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {state};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73632f = state;
    }

    public static <T> BufferUntilSubscriber<T> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new BufferUntilSubscriber<>(new State()) : (BufferUntilSubscriber) invokeV.objValue;
    }

    public final void L(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, obj) != null) {
            return;
        }
        synchronized (this.f73632f.guard) {
            this.f73632f.buffer.add(obj);
            if (this.f73632f.get() != null && !this.f73632f.emitting) {
                this.f73633g = true;
                this.f73632f.emitting = true;
            }
        }
        if (!this.f73633g) {
            return;
        }
        while (true) {
            Object poll = this.f73632f.buffer.poll();
            if (poll == null) {
                return;
            }
            NotificationLite.a(this.f73632f.get(), poll);
        }
    }

    @Override // h.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f73633g) {
                this.f73632f.get().onCompleted();
            } else {
                L(NotificationLite.b());
            }
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            if (this.f73633g) {
                this.f73632f.get().onError(th);
            } else {
                L(NotificationLite.c(th));
            }
        }
    }

    @Override // h.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            if (this.f73633g) {
                this.f73632f.get().onNext(t);
            } else {
                L(NotificationLite.h(t));
            }
        }
    }
}
