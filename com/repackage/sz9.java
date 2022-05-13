package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zx9;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.internal.schedulers.ScheduledAction;
/* loaded from: classes7.dex */
public final class sz9 extends zx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor a;

    /* loaded from: classes7.dex */
    public static final class a extends zx9.a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Executor a;
        public final q2a b;
        public final ConcurrentLinkedQueue<ScheduledAction> c;
        public final AtomicInteger d;
        public final ScheduledExecutorService e;

        /* renamed from: com.repackage.sz9$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0522a implements jy9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r2a a;
            public final /* synthetic */ a b;

            public C0522a(a aVar, r2a r2aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, r2aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = r2aVar;
            }

            @Override // com.repackage.jy9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.b(this.a);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements jy9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r2a a;
            public final /* synthetic */ jy9 b;
            public final /* synthetic */ dy9 c;
            public final /* synthetic */ a d;

            public b(a aVar, r2a r2aVar, jy9 jy9Var, dy9 dy9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, r2aVar, jy9Var, dy9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = r2aVar;
                this.b = jy9Var;
                this.c = dy9Var;
            }

            @Override // com.repackage.jy9
            public void call() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.isUnsubscribed()) {
                    return;
                }
                dy9 b = this.d.b(this.b);
                this.a.a(b);
                if (b.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) b).add(this.c);
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
            this.c = new ConcurrentLinkedQueue<>();
            this.d = new AtomicInteger();
            this.b = new q2a();
            this.e = tz9.a();
        }

        @Override // com.repackage.zx9.a
        public dy9 b(jy9 jy9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jy9Var)) == null) {
                if (isUnsubscribed()) {
                    return t2a.c();
                }
                ScheduledAction scheduledAction = new ScheduledAction(d2a.q(jy9Var), this.b);
                this.b.a(scheduledAction);
                this.c.offer(scheduledAction);
                if (this.d.getAndIncrement() == 0) {
                    try {
                        this.a.execute(this);
                    } catch (RejectedExecutionException e) {
                        this.b.b(scheduledAction);
                        this.d.decrementAndGet();
                        d2a.j(e);
                        throw e;
                    }
                }
                return scheduledAction;
            }
            return (dy9) invokeL.objValue;
        }

        @Override // com.repackage.zx9.a
        public dy9 c(jy9 jy9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jy9Var, Long.valueOf(j), timeUnit})) == null) {
                if (j <= 0) {
                    return b(jy9Var);
                }
                if (isUnsubscribed()) {
                    return t2a.c();
                }
                jy9 q = d2a.q(jy9Var);
                r2a r2aVar = new r2a();
                r2a r2aVar2 = new r2a();
                r2aVar2.a(r2aVar);
                this.b.a(r2aVar2);
                dy9 a = t2a.a(new C0522a(this, r2aVar2));
                ScheduledAction scheduledAction = new ScheduledAction(new b(this, r2aVar2, q, a));
                r2aVar.a(scheduledAction);
                try {
                    scheduledAction.add(this.e.schedule(scheduledAction, j, timeUnit));
                    return a;
                } catch (RejectedExecutionException e) {
                    d2a.j(e);
                    throw e;
                }
            }
            return (dy9) invokeCommon.objValue;
        }

        @Override // com.repackage.dy9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                while (!this.b.isUnsubscribed()) {
                    ScheduledAction poll = this.c.poll();
                    if (poll == null) {
                        return;
                    }
                    if (!poll.isUnsubscribed()) {
                        if (!this.b.isUnsubscribed()) {
                            poll.run();
                        } else {
                            this.c.clear();
                            return;
                        }
                    }
                    if (this.d.decrementAndGet() == 0) {
                        return;
                    }
                }
                this.c.clear();
            }
        }

        @Override // com.repackage.dy9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.unsubscribe();
                this.c.clear();
            }
        }
    }

    public sz9(Executor executor) {
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

    @Override // com.repackage.zx9
    public zx9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this.a) : (zx9.a) invokeV.objValue;
    }
}
