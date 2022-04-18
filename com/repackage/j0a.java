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
import com.repackage.bz9;
import com.repackage.yy9;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes6.dex */
public class j0a<T> implements bz9.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Long a;
    public final oz9 b;
    public final yy9.d c;

    /* loaded from: classes6.dex */
    public static final class a<T> extends hz9<T> implements BackpressureDrainManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConcurrentLinkedQueue<Object> e;
        public final AtomicLong f;
        public final hz9<? super T> g;
        public final AtomicBoolean h;
        public final BackpressureDrainManager i;
        public final oz9 j;
        public final yy9.d k;

        public a(hz9<? super T> hz9Var, Long l, oz9 oz9Var, yy9.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz9Var, l, oz9Var, dVar};
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
            this.g = hz9Var;
            this.f = l != null ? new AtomicLong(l.longValue()) : null;
            this.j = oz9Var;
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

        @Override // com.repackage.hz9
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
            oz9 oz9Var;
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
                            oz9Var = this.j;
                            if (oz9Var != null) {
                                try {
                                    oz9Var.call();
                                } catch (Throwable th) {
                                    nz9.e(th);
                                    this.i.terminateAndDrain(th);
                                    return false;
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                        z = false;
                        oz9Var = this.j;
                        if (oz9Var != null) {
                        }
                        if (!z) {
                        }
                    }
                } while (!this.f.compareAndSet(j, j - 1));
                return true;
            }
            return invokeV.booleanValue;
        }

        public dz9 h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (dz9) invokeV.objValue;
        }

        @Override // com.repackage.cz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.h.get()) {
                return;
            }
            this.i.terminateAndDrain();
        }

        @Override // com.repackage.cz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, th) == null) || this.h.get()) {
                return;
            }
            this.i.terminateAndDrain(th);
        }

        @Override // com.repackage.cz9
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

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final j0a<?> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-321641160, "Lcom/repackage/j0a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-321641160, "Lcom/repackage/j0a$b;");
                    return;
                }
            }
            a = new j0a<>();
        }
    }

    public j0a() {
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
        this.c = yy9.b;
    }

    public static <T> j0a<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (j0a<T>) b.a : (j0a) invokeV.objValue;
    }

    @Override // com.repackage.bz9.b, com.repackage.tz9
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((hz9) ((hz9) obj));
    }

    public hz9<? super T> call(hz9<? super T> hz9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hz9Var)) == null) {
            a aVar = new a(hz9Var, this.a, this.b, this.c);
            hz9Var.b(aVar);
            hz9Var.f(aVar.h());
            return aVar;
        }
        return (hz9) invokeL.objValue;
    }
}
