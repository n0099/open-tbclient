package g.o.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.g;
import g.k;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;
/* loaded from: classes7.dex */
public final class c extends g.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor a;

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor a;

        /* renamed from: b  reason: collision with root package name */
        public final g.u.b f44957b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f44958c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f44959d;

        /* renamed from: e  reason: collision with root package name */
        public final ScheduledExecutorService f44960e;

        /* renamed from: g.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C2144a implements g.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g.u.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f44961b;

            public C2144a(a aVar, g.u.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44961b = aVar;
                this.a = cVar;
            }

            @Override // g.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44961b.f44957b.b(this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements g.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g.u.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g.n.a f44962b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ k f44963c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ a f44964d;

            public b(a aVar, g.u.c cVar, g.n.a aVar2, k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar, aVar2, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44964d = aVar;
                this.a = cVar;
                this.f44962b = aVar2;
                this.f44963c = kVar;
            }

            @Override // g.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.isUnsubscribed()) {
                    return;
                }
                k b2 = this.f44964d.b(this.f44962b);
                this.a.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f44963c);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = executor;
            this.f44958c = new ConcurrentLinkedQueue<>();
            this.f44959d = new AtomicInteger();
            this.f44957b = new g.u.b();
            this.f44960e = d.a();
        }

        @Override // g.g.a
        public k b(g.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (isUnsubscribed()) {
                    return g.u.e.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(g.r.c.q(aVar), this.f44957b);
                this.f44957b.a(scheduledAction);
                this.f44958c.offer(scheduledAction);
                if (this.f44959d.getAndIncrement() == 0) {
                    try {
                        this.a.execute(this);
                    } catch (RejectedExecutionException e2) {
                        this.f44957b.b(scheduledAction);
                        this.f44959d.decrementAndGet();
                        g.r.c.j(e2);
                        throw e2;
                    }
                }
                return scheduledAction;
            }
            return (k) invokeL.objValue;
        }

        @Override // g.g.a
        public k c(g.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                if (j <= 0) {
                    return b(aVar);
                }
                if (isUnsubscribed()) {
                    return g.u.e.c();
                }
                g.n.a q = g.r.c.q(aVar);
                g.u.c cVar = new g.u.c();
                g.u.c cVar2 = new g.u.c();
                cVar2.a(cVar);
                this.f44957b.a(cVar2);
                k a = g.u.e.a(new C2144a(this, cVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, cVar2, q, a));
                cVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.f44960e.schedule(scheduledAction, j, timeUnit));
                    return a;
                } catch (RejectedExecutionException e2) {
                    g.r.c.j(e2);
                    throw e2;
                }
            }
            return (k) invokeCommon.objValue;
        }

        @Override // g.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44957b.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.f44957b.isUnsubscribed()) {
                    ScheduledAction poll = this.f44958c.poll();
                    if (poll == null) {
                        return;
                    }
                    if (!poll.isUnsubscribed()) {
                        if (!this.f44957b.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.f44958c.clear();
                            return;
                        }
                    }
                    if (this.f44959d.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f44958c.clear();
            }
        }

        @Override // g.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f44957b.unsubscribe();
                this.f44958c.clear();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = executor;
    }

    @Override // g.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.a) : (g.a) invokeV.objValue;
    }
}
