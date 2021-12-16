package i.o.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.k;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;
/* loaded from: classes4.dex */
public final class c extends i.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor a;

    /* loaded from: classes4.dex */
    public static final class a extends g.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Executor f64393e;

        /* renamed from: f  reason: collision with root package name */
        public final i.u.b f64394f;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f64395g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f64396h;

        /* renamed from: i  reason: collision with root package name */
        public final ScheduledExecutorService f64397i;

        /* renamed from: i.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C2268a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.u.c f64398e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f64399f;

            public C2268a(a aVar, i.u.c cVar) {
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
                this.f64399f = aVar;
                this.f64398e = cVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f64399f.f64394f.b(this.f64398e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.u.c f64400e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i.n.a f64401f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f64402g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f64403h;

            public b(a aVar, i.u.c cVar, i.n.a aVar2, k kVar) {
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
                this.f64403h = aVar;
                this.f64400e = cVar;
                this.f64401f = aVar2;
                this.f64402g = kVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f64400e.isUnsubscribed()) {
                    return;
                }
                k b2 = this.f64403h.b(this.f64401f);
                this.f64400e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f64402g);
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
            this.f64393e = executor;
            this.f64395g = new ConcurrentLinkedQueue<>();
            this.f64396h = new AtomicInteger();
            this.f64394f = new i.u.b();
            this.f64397i = d.a();
        }

        @Override // i.g.a
        public k b(i.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (isUnsubscribed()) {
                    return i.u.e.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(i.r.c.q(aVar), this.f64394f);
                this.f64394f.a(scheduledAction);
                this.f64395g.offer(scheduledAction);
                if (this.f64396h.getAndIncrement() == 0) {
                    try {
                        this.f64393e.execute(this);
                    } catch (RejectedExecutionException e2) {
                        this.f64394f.b(scheduledAction);
                        this.f64396h.decrementAndGet();
                        i.r.c.j(e2);
                        throw e2;
                    }
                }
                return scheduledAction;
            }
            return (k) invokeL.objValue;
        }

        @Override // i.g.a
        public k c(i.n.a aVar, long j2, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j2), timeUnit})) == null) {
                if (j2 <= 0) {
                    return b(aVar);
                }
                if (isUnsubscribed()) {
                    return i.u.e.c();
                }
                i.n.a q = i.r.c.q(aVar);
                i.u.c cVar = new i.u.c();
                i.u.c cVar2 = new i.u.c();
                cVar2.a(cVar);
                this.f64394f.a(cVar2);
                k a = i.u.e.a(new C2268a(this, cVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, cVar2, q, a));
                cVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.f64397i.schedule(scheduledAction, j2, timeUnit));
                    return a;
                } catch (RejectedExecutionException e2) {
                    i.r.c.j(e2);
                    throw e2;
                }
            }
            return (k) invokeCommon.objValue;
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64394f.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.f64394f.isUnsubscribed()) {
                    ScheduledAction poll = this.f64395g.poll();
                    if (poll == null) {
                        return;
                    }
                    if (!poll.isUnsubscribed()) {
                        if (!this.f64394f.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.f64395g.clear();
                            return;
                        }
                    }
                    if (this.f64396h.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f64395g.clear();
            }
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f64394f.unsubscribe();
                this.f64395g.clear();
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
        this.a = executor;
    }

    @Override // i.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.a) : (g.a) invokeV.objValue;
    }
}
