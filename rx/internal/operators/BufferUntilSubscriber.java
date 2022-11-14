package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e0a;
import com.baidu.tieba.j4a;
import com.baidu.tieba.o4a;
import com.baidu.tieba.rz9;
import com.baidu.tieba.sz9;
import com.baidu.tieba.xz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class BufferUntilSubscriber<T> extends j4a<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public static final sz9 d;
    public transient /* synthetic */ FieldHolder $fh;
    public final State<T> b;
    public boolean c;

    /* loaded from: classes9.dex */
    public static final class b<T> implements rz9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final State<T> a;

        /* loaded from: classes9.dex */
        public class a implements e0a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.e0a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.set(BufferUntilSubscriber.d);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = state;
        }

        @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((xz9) ((xz9) obj));
        }

        public void call(xz9<? super T> xz9Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xz9Var) == null) {
                if (this.a.casObserverRef(null, xz9Var)) {
                    xz9Var.b(o4a.a(new a(this)));
                    synchronized (this.a.guard) {
                        z = true;
                        if (!this.a.emitting) {
                            this.a.emitting = true;
                        } else {
                            z = false;
                        }
                    }
                    if (!z) {
                        return;
                    }
                    while (true) {
                        Object poll = this.a.buffer.poll();
                        if (poll != null) {
                            NotificationLite.a(this.a.get(), poll);
                        } else {
                            synchronized (this.a.guard) {
                                if (this.a.buffer.isEmpty()) {
                                    this.a.emitting = false;
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    xz9Var.onError(new IllegalStateException("Only one subscriber allowed!"));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class State<T> extends AtomicReference<sz9<? super T>> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.guard = new Object();
            this.buffer = new ConcurrentLinkedQueue<>();
        }

        public boolean casObserverRef(sz9<? super T> sz9Var, sz9<? super T> sz9Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sz9Var, sz9Var2)) == null) {
                return compareAndSet(sz9Var, sz9Var2);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class a implements sz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.sz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.sz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            }
        }

        @Override // com.baidu.tieba.sz9
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
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
        d = new a();
    }

    public static <T> BufferUntilSubscriber<T> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new BufferUntilSubscriber<>(new State());
        }
        return (BufferUntilSubscriber) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.c) {
                this.b.get().onCompleted();
            } else {
                E(NotificationLite.b());
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rz9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = state;
    }

    public final void E(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            synchronized (this.b.guard) {
                this.b.buffer.add(obj);
                if (this.b.get() != null && !this.b.emitting) {
                    this.c = true;
                    this.b.emitting = true;
                }
            }
            if (!this.c) {
                return;
            }
            while (true) {
                Object poll = this.b.buffer.poll();
                if (poll != null) {
                    NotificationLite.a(this.b.get(), poll);
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.sz9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            if (this.c) {
                this.b.get().onError(th);
            } else {
                E(NotificationLite.c(th));
            }
        }
    }

    @Override // com.baidu.tieba.sz9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            if (this.c) {
                this.b.get().onNext(t);
            } else {
                E(NotificationLite.h(t));
            }
        }
    }
}
