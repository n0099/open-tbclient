package i.o.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.a;
import i.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes3.dex */
public class n<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Long f63712e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.a f63713f;

    /* renamed from: g  reason: collision with root package name */
    public final a.d f63714g;

    /* loaded from: classes3.dex */
    public static final class a<T> extends i.j<T> implements BackpressureDrainManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final ConcurrentLinkedQueue<Object> f63715i;

        /* renamed from: j  reason: collision with root package name */
        public final AtomicLong f63716j;

        /* renamed from: k  reason: collision with root package name */
        public final i.j<? super T> f63717k;
        public final AtomicBoolean l;
        public final BackpressureDrainManager m;
        public final i.n.a n;
        public final a.d o;

        public a(i.j<? super T> jVar, Long l, i.n.a aVar, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, l, aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63715i = new ConcurrentLinkedQueue<>();
            this.l = new AtomicBoolean(false);
            this.f63717k = jVar;
            this.f63716j = l != null ? new AtomicLong(l.longValue()) : null;
            this.n = aVar;
            this.m = new BackpressureDrainManager(this);
            this.o = dVar;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (th != null) {
                    this.f63717k.onError(th);
                } else {
                    this.f63717k.onCompleted();
                }
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? NotificationLite.a(this.f63717k, obj) : invokeL.booleanValue;
        }

        @Override // i.j
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
            long j2;
            boolean z;
            i.n.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f63716j == null) {
                    return true;
                }
                do {
                    j2 = this.f63716j.get();
                    if (j2 <= 0) {
                        try {
                        } catch (MissingBackpressureException e2) {
                            if (this.l.compareAndSet(false, true)) {
                                unsubscribe();
                                this.f63717k.onError(e2);
                            }
                        }
                        if (this.o.a() && poll() != null) {
                            z = true;
                            aVar = this.n;
                            if (aVar != null) {
                                try {
                                    aVar.call();
                                } catch (Throwable th) {
                                    i.m.a.e(th);
                                    this.m.terminateAndDrain(th);
                                    return false;
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                        z = false;
                        aVar = this.n;
                        if (aVar != null) {
                        }
                        if (!z) {
                        }
                    }
                } while (!this.f63716j.compareAndSet(j2, j2 - 1));
                return true;
            }
            return invokeV.booleanValue;
        }

        public i.f h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (i.f) invokeV.objValue;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.l.get()) {
                return;
            }
            this.m.terminateAndDrain();
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, th) == null) || this.l.get()) {
                return;
            }
            this.m.terminateAndDrain(th);
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, t) == null) && g()) {
                this.f63715i.offer(NotificationLite.h(t));
                this.m.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f63715i.peek() : invokeV.objValue;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object poll = this.f63715i.poll();
                AtomicLong atomicLong = this.f63716j;
                if (atomicLong != null && poll != null) {
                    atomicLong.incrementAndGet();
                }
                return poll;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final n<?> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(130754255, "Li/o/a/n$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(130754255, "Li/o/a/n$b;");
                    return;
                }
            }
            a = new n<>();
        }
    }

    public n() {
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
        this.f63712e = null;
        this.f63713f = null;
        this.f63714g = i.a.f63616b;
    }

    public static <T> n<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (n<T>) b.a : (n) invokeV.objValue;
    }

    @Override // i.d.b, i.n.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((i.j) ((i.j) obj));
    }

    public i.j<? super T> call(i.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            a aVar = new a(jVar, this.f63712e, this.f63713f, this.f63714g);
            jVar.b(aVar);
            jVar.f(aVar.h());
            return aVar;
        }
        return (i.j) invokeL.objValue;
    }
}
