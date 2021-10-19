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
/* loaded from: classes10.dex */
public final class c extends i.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f79141a;

    /* loaded from: classes10.dex */
    public static final class a extends g.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Executor f79142e;

        /* renamed from: f  reason: collision with root package name */
        public final i.u.b f79143f;

        /* renamed from: g  reason: collision with root package name */
        public final ConcurrentLinkedQueue<ScheduledAction> f79144g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f79145h;

        /* renamed from: i  reason: collision with root package name */
        public final ScheduledExecutorService f79146i;

        /* renamed from: i.o.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2137a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.u.c f79147e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f79148f;

            public C2137a(a aVar, i.u.c cVar) {
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
                this.f79148f = aVar;
                this.f79147e = cVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f79148f.f79143f.b(this.f79147e);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i.u.c f79149e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i.n.a f79150f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f79151g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f79152h;

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
                this.f79152h = aVar;
                this.f79149e = cVar;
                this.f79150f = aVar2;
                this.f79151g = kVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f79149e.isUnsubscribed()) {
                    return;
                }
                k b2 = this.f79152h.b(this.f79150f);
                this.f79149e.a(b2);
                if (b2.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b2).add(this.f79151g);
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
            this.f79142e = executor;
            this.f79144g = new ConcurrentLinkedQueue<>();
            this.f79145h = new AtomicInteger();
            this.f79143f = new i.u.b();
            this.f79146i = d.a();
        }

        @Override // i.g.a
        public k b(i.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (isUnsubscribed()) {
                    return i.u.e.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(i.r.c.q(aVar), this.f79143f);
                this.f79143f.a(scheduledAction);
                this.f79144g.offer(scheduledAction);
                if (this.f79145h.getAndIncrement() == 0) {
                    try {
                        this.f79142e.execute(this);
                    } catch (RejectedExecutionException e2) {
                        this.f79143f.b(scheduledAction);
                        this.f79145h.decrementAndGet();
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
                this.f79143f.a(cVar2);
                k a2 = i.u.e.a(new C2137a(this, cVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, cVar2, q, a2));
                cVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.f79146i.schedule(scheduledAction, j2, timeUnit));
                    return a2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f79143f.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.f79143f.isUnsubscribed()) {
                    ScheduledAction poll = this.f79144g.poll();
                    if (poll == null) {
                        return;
                    }
                    if (!poll.isUnsubscribed()) {
                        if (!this.f79143f.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.f79144g.clear();
                            return;
                        }
                    }
                    if (this.f79145h.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f79144g.clear();
            }
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f79143f.unsubscribe();
                this.f79144g.clear();
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
        this.f79141a = executor;
    }

    @Override // i.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.f79141a) : (g.a) invokeV.objValue;
    }
}
