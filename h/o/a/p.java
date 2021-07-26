package h.o.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.a;
import h.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BackpressureDrainManager;
/* loaded from: classes9.dex */
public class p<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Long f72958e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.a f72959f;

    /* renamed from: g  reason: collision with root package name */
    public final a.d f72960g;

    /* loaded from: classes9.dex */
    public static final class a<T> extends h.j<T> implements BackpressureDrainManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentLinkedQueue<Object> f72961e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f72962f;

        /* renamed from: g  reason: collision with root package name */
        public final h.j<? super T> f72963g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f72964h;

        /* renamed from: i  reason: collision with root package name */
        public final BackpressureDrainManager f72965i;
        public final h.n.a j;
        public final a.d k;

        public a(h.j<? super T> jVar, Long l, h.n.a aVar, a.d dVar) {
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
            this.f72961e = new ConcurrentLinkedQueue<>();
            this.f72964h = new AtomicBoolean(false);
            this.f72963g = jVar;
            this.f72962f = l != null ? new AtomicLong(l.longValue()) : null;
            this.j = aVar;
            this.f72965i = new BackpressureDrainManager(this);
            this.k = dVar;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (th != null) {
                    this.f72963g.onError(th);
                } else {
                    this.f72963g.onCompleted();
                }
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? NotificationLite.a(this.f72963g, obj) : invokeL.booleanValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x004d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean b() {
            InterceptResult invokeV;
            long j;
            boolean z;
            h.n.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f72962f == null) {
                    return true;
                }
                do {
                    j = this.f72962f.get();
                    if (j <= 0) {
                        try {
                        } catch (MissingBackpressureException e2) {
                            if (this.f72964h.compareAndSet(false, true)) {
                                unsubscribe();
                                this.f72963g.onError(e2);
                            }
                        }
                        if (this.k.a() && poll() != null) {
                            z = true;
                            aVar = this.j;
                            if (aVar != null) {
                                try {
                                    aVar.call();
                                } catch (Throwable th) {
                                    h.m.a.e(th);
                                    this.f72965i.terminateAndDrain(th);
                                    return false;
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                        z = false;
                        aVar = this.j;
                        if (aVar != null) {
                        }
                        if (!z) {
                        }
                    }
                } while (!this.f72962f.compareAndSet(j, j - 1));
                return true;
            }
            return invokeV.booleanValue;
        }

        public h.f c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72965i : (h.f) invokeV.objValue;
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f72964h.get()) {
                return;
            }
            this.f72965i.terminateAndDrain();
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, th) == null) || this.f72964h.get()) {
                return;
            }
            this.f72965i.terminateAndDrain(th);
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, t) == null) && b()) {
                this.f72961e.offer(NotificationLite.h(t));
                this.f72965i.drain();
            }
        }

        @Override // h.j
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                request(Long.MAX_VALUE);
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f72961e.peek() : invokeV.objValue;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object poll = this.f72961e.poll();
                AtomicLong atomicLong = this.f72962f;
                if (atomicLong != null && poll != null) {
                    atomicLong.incrementAndGet();
                }
                return poll;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final p<?> f72966a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(327327342, "Lh/o/a/p$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(327327342, "Lh/o/a/p$b;");
                    return;
                }
            }
            f72966a = new p<>();
        }
    }

    public p() {
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
        this.f72958e = null;
        this.f72959f = null;
        this.f72960g = h.a.f72846b;
    }

    public static <T> p<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (p<T>) b.f72966a : (p) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            a aVar = new a(jVar, this.f72958e, this.f72959f, this.f72960g);
            jVar.add(aVar);
            jVar.setProducer(aVar.c());
            return aVar;
        }
        return (h.j) invokeL.objValue;
    }
}
