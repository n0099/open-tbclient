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
/* loaded from: classes2.dex */
public class n<T> implements d.b<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Long f72853e;

    /* renamed from: f  reason: collision with root package name */
    public final h.n.a f72854f;

    /* renamed from: g  reason: collision with root package name */
    public final a.d f72855g;

    /* loaded from: classes2.dex */
    public static final class a<T> extends h.j<T> implements BackpressureDrainManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final ConcurrentLinkedQueue<Object> f72856i;
        public final AtomicLong j;
        public final h.j<? super T> k;
        public final AtomicBoolean l;
        public final BackpressureDrainManager m;
        public final h.n.a n;
        public final a.d o;

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
            this.f72856i = new ConcurrentLinkedQueue<>();
            this.l = new AtomicBoolean(false);
            this.k = jVar;
            this.j = l != null ? new AtomicLong(l.longValue()) : null;
            this.n = aVar;
            this.m = new BackpressureDrainManager(this);
            this.o = dVar;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                if (th != null) {
                    this.k.onError(th);
                } else {
                    this.k.onCompleted();
                }
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public boolean accept(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? NotificationLite.a(this.k, obj) : invokeL.booleanValue;
        }

        @Override // h.j
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
            h.n.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.j == null) {
                    return true;
                }
                do {
                    j = this.j.get();
                    if (j <= 0) {
                        try {
                        } catch (MissingBackpressureException e2) {
                            if (this.l.compareAndSet(false, true)) {
                                unsubscribe();
                                this.k.onError(e2);
                            }
                        }
                        if (this.o.a() && poll() != null) {
                            z = true;
                            aVar = this.n;
                            if (aVar != null) {
                                try {
                                    aVar.call();
                                } catch (Throwable th) {
                                    h.m.a.e(th);
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
                } while (!this.j.compareAndSet(j, j - 1));
                return true;
            }
            return invokeV.booleanValue;
        }

        public h.f h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (h.f) invokeV.objValue;
        }

        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.l.get()) {
                return;
            }
            this.m.terminateAndDrain();
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, th) == null) || this.l.get()) {
                return;
            }
            this.m.terminateAndDrain(th);
        }

        @Override // h.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, t) == null) && g()) {
                this.f72856i.offer(NotificationLite.h(t));
                this.m.drain();
            }
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object peek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f72856i.peek() : invokeV.objValue;
        }

        @Override // rx.internal.util.BackpressureDrainManager.a
        public Object poll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                Object poll = this.f72856i.poll();
                AtomicLong atomicLong = this.j;
                if (atomicLong != null && poll != null) {
                    atomicLong.incrementAndGet();
                }
                return poll;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final n<?> f72857a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(327267760, "Lh/o/a/n$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(327267760, "Lh/o/a/n$b;");
                    return;
                }
            }
            f72857a = new n<>();
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
        this.f72853e = null;
        this.f72854f = null;
        this.f72855g = h.a.f72765b;
    }

    public static <T> n<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? (n<T>) b.f72857a : (n) invokeV.objValue;
    }

    @Override // h.d.b, h.n.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((h.j) ((h.j) obj));
    }

    public h.j<? super T> call(h.j<? super T> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
            a aVar = new a(jVar, this.f72853e, this.f72854f, this.f72855g);
            jVar.b(aVar);
            jVar.f(aVar.h());
            return aVar;
        }
        return (h.j) invokeL.objValue;
    }
}
