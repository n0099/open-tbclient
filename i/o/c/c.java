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
        public final Executor f62018e;

        /* renamed from: f  reason: collision with root package name */
        public final i.u.b f62019f;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f62020g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f62021h;

        /* renamed from: i  reason: collision with root package name */
        public final ScheduledExecutorService f62022i;

        /* renamed from: i.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C2299a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.u.c f62023e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f62024f;

            public C2299a(a aVar, i.u.c cVar) {
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
                this.f62024f = aVar;
                this.f62023e = cVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f62024f.f62019f.b(this.f62023e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.u.c f62025e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i.n.a f62026f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f62027g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f62028h;

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
                this.f62028h = aVar;
                this.f62025e = cVar;
                this.f62026f = aVar2;
                this.f62027g = kVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62025e.isUnsubscribed()) {
                    return;
                }
                k b2 = this.f62028h.b(this.f62026f);
                this.f62025e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f62027g);
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
            this.f62018e = executor;
            this.f62020g = new ConcurrentLinkedQueue<>();
            this.f62021h = new AtomicInteger();
            this.f62019f = new i.u.b();
            this.f62022i = d.a();
        }

        @Override // i.g.a
        public k b(i.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (isUnsubscribed()) {
                    return i.u.e.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(i.r.c.q(aVar), this.f62019f);
                this.f62019f.a(scheduledAction);
                this.f62020g.offer(scheduledAction);
                if (this.f62021h.getAndIncrement() == 0) {
                    try {
                        this.f62018e.execute(this);
                    } catch (RejectedExecutionException e2) {
                        this.f62019f.b(scheduledAction);
                        this.f62021h.decrementAndGet();
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
                this.f62019f.a(cVar2);
                k a = i.u.e.a(new C2299a(this, cVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, cVar2, q, a));
                cVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.f62022i.schedule(scheduledAction, j2, timeUnit));
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62019f.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.f62019f.isUnsubscribed()) {
                    ScheduledAction poll = this.f62020g.poll();
                    if (poll == null) {
                        return;
                    }
                    if (!poll.isUnsubscribed()) {
                        if (!this.f62019f.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.f62020g.clear();
                            return;
                        }
                    }
                    if (this.f62021h.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f62020g.clear();
            }
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f62019f.unsubscribe();
                this.f62020g.clear();
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
