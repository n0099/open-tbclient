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
/* loaded from: classes10.dex */
public class p<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Long f79033e;

    /* renamed from: f  reason: collision with root package name */
    public final i.n.a f79034f;

    /* renamed from: g  reason: collision with root package name */
    public final a.d f79035g;

    /* loaded from: classes10.dex */
    public static final class a<T> extends i.j<T> implements BackpressureDrainManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentLinkedQueue<Object> f79036e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f79037f;

        /* renamed from: g  reason: collision with root package name */
        public final i.j<? super T> f79038g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicBoolean f79039h;

        /* renamed from: i  reason: collision with root package name */
        public final BackpressureDrainManager f79040i;

        /* renamed from: j  reason: collision with root package name */
        public final i.n.a f79041j;
        public final a.d k;

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
            this.f79036e = new ConcurrentLinkedQueue<>();
            this.f79039h = new AtomicBoolean(false);
            this.f79038g = jVar;
            this.f79037f = l != null ? new AtomicLong(l.longValue()) : null;
            this.f79041j = aVar;
            this.f79040i = new BackpressureDrainManager(this);
            this.k = dVar;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (th != null) {
                    this.f79038g.onError(th);
                } else {
                    this.f79038g.onCompleted();
                }
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? NotificationLite.a(this.f79038g, obj) : invokeL.booleanValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x004d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean b() {
            InterceptResult invokeV;
            long j2;
            boolean z;
            i.n.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f79037f == null) {
                    return true;
                }
                do {
                    j2 = this.f79037f.get();
                    if (j2 <= 0) {
                        try {
                        } catch (MissingBackpressureException e2) {
                            if (this.f79039h.compareAndSet(false, true)) {
                                unsubscribe();
                                this.f79038g.onError(e2);
                            }
                        }
                        if (this.k.a() && poll() != null) {
                            z = true;
                            aVar = this.f79041j;
                            if (aVar != null) {
                                try {
                                    aVar.call();
                                } catch (Throwable th) {
                                    i.m.a.e(th);
                                    this.f79040i.terminateAndDrain(th);
                                    return false;
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                        z = false;
                        aVar = this.f79041j;
                        if (aVar != null) {
                        }
                        if (!z) {
                        }
                    }
                } while (!this.f79037f.compareAndSet(j2, j2 - 1));
                return true;
            }
            return invokeV.booleanValue;
        }

        public i.f c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f79040i : (i.f) invokeV.objValue;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f79039h.get()) {
                return;
            }
            this.f79040i.terminateAndDrain();
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, th) == null) || this.f79039h.get()) {
                return;
            }
            this.f79040i.terminateAndDrain(th);
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, t) == null) && b()) {
                this.f79036e.offer(NotificationLite.h(t));
                this.f79040i.drain();
            }
        }

        @Override // i.j
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
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f79036e.peek() : invokeV.objValue;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object poll = this.f79036e.poll();
                AtomicLong atomicLong = this.f79037f;
                if (atomicLong != null && poll != null) {
                    atomicLong.incrementAndGet();
                }
                return poll;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final p<?> f79042a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(130813837, "Li/o/a/p$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(130813837, "Li/o/a/p$b;");
                    return;
                }
            }
            f79042a = new p<>();
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
        this.f79033e = null;
        this.f79034f = null;
        this.f79035g = i.a.f78917b;
    }

    public static <T> p<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (p<T>) b.f79042a : (p) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.f
    /* renamed from: a */
    public i.j<? super T> call(i.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            a aVar = new a(jVar, this.f79033e, this.f79034f, this.f79035g);
            jVar.add(aVar);
            jVar.setProducer(aVar.c());
            return aVar;
        }
        return (i.j) invokeL.objValue;
    }
}
