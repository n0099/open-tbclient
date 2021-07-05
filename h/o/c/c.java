package h.o.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.k;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;
/* loaded from: classes10.dex */
public final class c extends h.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f75573a;

    /* loaded from: classes10.dex */
    public static final class a extends g.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Executor f75574e;

        /* renamed from: f  reason: collision with root package name */
        public final h.u.b f75575f;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f75576g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f75577h;

        /* renamed from: i  reason: collision with root package name */
        public final ScheduledExecutorService f75578i;

        /* renamed from: h.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2108a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f75579e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f75580f;

            public C2108a(a aVar, h.u.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f75580f = aVar;
                this.f75579e = cVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f75580f.f75575f.b(this.f75579e);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.u.c f75581e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.n.a f75582f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f75583g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f75584h;

            public b(a aVar, h.u.c cVar, h.n.a aVar2, k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar, aVar2, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f75584h = aVar;
                this.f75581e = cVar;
                this.f75582f = aVar2;
                this.f75583g = kVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f75581e.isUnsubscribed()) {
                    return;
                }
                k b2 = this.f75584h.b(this.f75582f);
                this.f75581e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f75583g);
                }
            }
        }

        public a(Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75574e = executor;
            this.f75576g = new ConcurrentLinkedQueue<>();
            this.f75577h = new AtomicInteger();
            this.f75575f = new h.u.b();
            this.f75578i = d.a();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (isUnsubscribed()) {
                    return h.u.e.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(h.r.c.q(aVar), this.f75575f);
                this.f75575f.a(scheduledAction);
                this.f75576g.offer(scheduledAction);
                if (this.f75577h.getAndIncrement() == 0) {
                    try {
                        this.f75574e.execute(this);
                    } catch (RejectedExecutionException e2) {
                        this.f75575f.b(scheduledAction);
                        this.f75577h.decrementAndGet();
                        h.r.c.j(e2);
                        throw e2;
                    }
                }
                return scheduledAction;
            }
            return (k) invokeL.objValue;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                if (j <= 0) {
                    return b(aVar);
                }
                if (isUnsubscribed()) {
                    return h.u.e.c();
                }
                h.n.a q = h.r.c.q(aVar);
                h.u.c cVar = new h.u.c();
                h.u.c cVar2 = new h.u.c();
                cVar2.a(cVar);
                this.f75575f.a(cVar2);
                k a2 = h.u.e.a(new C2108a(this, cVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, cVar2, q, a2));
                cVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.f75578i.schedule(scheduledAction, j, timeUnit));
                    return a2;
                } catch (RejectedExecutionException e2) {
                    h.r.c.j(e2);
                    throw e2;
                }
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f75575f.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.f75575f.isUnsubscribed()) {
                    ScheduledAction poll = this.f75576g.poll();
                    if (poll == null) {
                        return;
                    }
                    if (!poll.isUnsubscribed()) {
                        if (!this.f75575f.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.f75576g.clear();
                            return;
                        }
                    }
                    if (this.f75577h.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f75576g.clear();
            }
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f75575f.unsubscribe();
                this.f75576g.clear();
            }
        }
    }

    public c(Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f75573a = executor;
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.f75573a) : (g.a) invokeV.objValue;
    }
}
