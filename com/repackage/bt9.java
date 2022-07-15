package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rr9;
import com.repackage.ur9;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes5.dex */
public class bt9<T> implements ur9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Long a;
    public final hs9 b;
    public final rr9.d c;

    /* loaded from: classes5.dex */
    public static final class a<T> extends as9<T> implements BackpressureDrainManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConcurrentLinkedQueue<Object> e;
        public final AtomicLong f;
        public final as9<? super T> g;
        public final AtomicBoolean h;
        public final BackpressureDrainManager i;
        public final hs9 j;
        public final rr9.d k;

        public a(as9<? super T> as9Var, Long l, hs9 hs9Var, rr9.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as9Var, l, hs9Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = new ConcurrentLinkedQueue<>();
            this.h = new AtomicBoolean(false);
            this.g = as9Var;
            this.f = l != null ? new AtomicLong(l.longValue()) : null;
            this.j = hs9Var;
            this.i = new BackpressureDrainManager(this);
            this.k = dVar;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (th != null) {
                    this.g.onError(th);
                } else {
                    this.g.onCompleted();
                }
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? NotificationLite.a(this.g, obj) : invokeL.booleanValue;
        }

        @Override // com.repackage.as9
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                e(Long.MAX_VALUE);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x004d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean g() {
            InterceptResult invokeV;
            long j;
            boolean z;
            hs9 hs9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f == null) {
                    return true;
                }
                do {
                    j = this.f.get();
                    if (j <= 0) {
                        try {
                        } catch (MissingBackpressureException e) {
                            if (this.h.compareAndSet(false, true)) {
                                unsubscribe();
                                this.g.onError(e);
                            }
                        }
                        if (this.k.a() && poll() != null) {
                            z = true;
                            hs9Var = this.j;
                            if (hs9Var != null) {
                                try {
                                    hs9Var.call();
                                } catch (Throwable th) {
                                    gs9.e(th);
                                    this.i.terminateAndDrain(th);
                                    return false;
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                        z = false;
                        hs9Var = this.j;
                        if (hs9Var != null) {
                        }
                        if (!z) {
                        }
                    }
                } while (!this.f.compareAndSet(j, j - 1));
                return true;
            }
            return invokeV.booleanValue;
        }

        public wr9 h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (wr9) invokeV.objValue;
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.h.get()) {
                return;
            }
            this.i.terminateAndDrain();
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, th) == null) || this.h.get()) {
                return;
            }
            this.i.terminateAndDrain(th);
        }

        @Override // com.repackage.vr9
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, t) == null) && g()) {
                this.e.offer(NotificationLite.h(t));
                this.i.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e.peek() : invokeV.objValue;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object poll = this.e.poll();
                AtomicLong atomicLong = this.f;
                if (atomicLong != null && poll != null) {
                    atomicLong.incrementAndGet();
                }
                return poll;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final bt9<?> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-489066580, "Lcom/repackage/bt9$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-489066580, "Lcom/repackage/bt9$b;");
                    return;
                }
            }
            a = new bt9<>();
        }
    }

    public bt9() {
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
        this.a = null;
        this.b = null;
        this.c = rr9.b;
    }

    public static <T> bt9<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (bt9<T>) b.a : (bt9) invokeV.objValue;
    }

    @Override // com.repackage.ur9.b, com.repackage.ms9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((as9) ((as9) obj));
    }

    public as9<? super T> call(as9<? super T> as9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, as9Var)) == null) {
            a aVar = new a(as9Var, this.a, this.b, this.c);
            as9Var.b(aVar);
            as9Var.f(aVar.h());
            return aVar;
        }
        return (as9) invokeL.objValue;
    }
}
