package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz9;
import com.repackage.hz9;
import com.repackage.mz9;
import com.repackage.s3a;
import com.repackage.sy9;
import com.repackage.ty9;
import com.repackage.uy9;
import com.repackage.vy9;
import com.repackage.x2a;
import com.repackage.xy9;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes8.dex */
public class SchedulerWhen extends xy9 implements bz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final bz9 d;
    public static final bz9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final xy9 a;
    public final vy9<uy9<sy9>> b;
    public final bz9 c;

    /* loaded from: classes8.dex */
    public static class DelayedAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final hz9 action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(hz9 hz9Var, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz9Var, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = hz9Var;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public bz9 callActual(xy9.a aVar, ty9 ty9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, ty9Var)) == null) ? aVar.c(new d(this.action, ty9Var), this.delayTime, this.unit) : (bz9) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class ImmediateAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final hz9 action;

        public ImmediateAction(hz9 hz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = hz9Var;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public bz9 callActual(xy9.a aVar, ty9 ty9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, ty9Var)) == null) ? aVar.b(new d(this.action, ty9Var)) : (bz9) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class ScheduledAction extends AtomicReference<bz9> implements bz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScheduledAction() {
            super(SchedulerWhen.d);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(xy9.a aVar, ty9 ty9Var) {
            bz9 bz9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65538, this, aVar, ty9Var) == null) && (bz9Var = get()) != SchedulerWhen.e && bz9Var == SchedulerWhen.d) {
                bz9 callActual = callActual(aVar, ty9Var);
                if (compareAndSet(SchedulerWhen.d, callActual)) {
                    return;
                }
                callActual.unsubscribe();
            }
        }

        public abstract bz9 callActual(xy9.a aVar, ty9 ty9Var);

        @Override // com.repackage.bz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get().isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.bz9
        public void unsubscribe() {
            bz9 bz9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                bz9 bz9Var2 = SchedulerWhen.e;
                do {
                    bz9Var = get();
                    if (bz9Var == SchedulerWhen.e) {
                        return;
                    }
                } while (!compareAndSet(bz9Var, bz9Var2));
                if (bz9Var != SchedulerWhen.d) {
                    bz9Var.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements mz9<ScheduledAction, sy9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy9.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0666a implements sy9.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScheduledAction a;
            public final /* synthetic */ a b;

            public C0666a(a aVar, ScheduledAction scheduledAction) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, scheduledAction};
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
                this.a = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.sy9.f, com.repackage.iz9
            public void call(ty9 ty9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ty9Var) == null) {
                    ty9Var.onSubscribe(this.a);
                    this.a.call(this.b.a, ty9Var);
                }
            }
        }

        public a(SchedulerWhen schedulerWhen, xy9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mz9
        public sy9 call(ScheduledAction scheduledAction) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scheduledAction)) == null) ? sy9.b(new C0666a(this, scheduledAction)) : (sy9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends xy9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean a;
        public final /* synthetic */ xy9.a b;
        public final /* synthetic */ vy9 c;

        public b(SchedulerWhen schedulerWhen, xy9.a aVar, vy9 vy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar, vy9Var};
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
            this.c = vy9Var;
            this.a = new AtomicBoolean();
        }

        @Override // com.repackage.xy9.a
        public bz9 b(hz9 hz9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, hz9Var)) == null) {
                ImmediateAction immediateAction = new ImmediateAction(hz9Var);
                this.c.onNext(immediateAction);
                return immediateAction;
            }
            return (bz9) invokeL.objValue;
        }

        @Override // com.repackage.xy9.a
        public bz9 c(hz9 hz9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hz9Var, Long.valueOf(j), timeUnit})) == null) {
                DelayedAction delayedAction = new DelayedAction(hz9Var, j, timeUnit);
                this.c.onNext(delayedAction);
                return delayedAction;
            }
            return (bz9) invokeCommon.objValue;
        }

        @Override // com.repackage.bz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.get() : invokeV.booleanValue;
        }

        @Override // com.repackage.bz9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements bz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.bz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.bz9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements hz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ty9 a;
        public hz9 b;

        public d(hz9 hz9Var, ty9 ty9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz9Var, ty9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hz9Var;
            this.a = ty9Var;
        }

        @Override // com.repackage.hz9
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.call();
                } finally {
                    this.a.onCompleted();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-692296952, "Lrx/internal/schedulers/SchedulerWhen;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-692296952, "Lrx/internal/schedulers/SchedulerWhen;");
                return;
            }
        }
        d = new c();
        e = s3a.c();
    }

    public SchedulerWhen(mz9<uy9<uy9<sy9>>, sy9> mz9Var, xy9 xy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mz9Var, xy9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = xy9Var;
        PublishSubject F = PublishSubject.F();
        this.b = new x2a(F);
        this.c = mz9Var.call(F.n()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.repackage.vy9<com.repackage.uy9<com.repackage.sy9>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.repackage.xy9
    public xy9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xy9.a createWorker = this.a.createWorker();
            BufferUntilSubscriber F = BufferUntilSubscriber.F();
            x2a x2aVar = new x2a(F);
            Object h = F.h(new a(this, createWorker));
            b bVar = new b(this, createWorker, x2aVar);
            this.b.onNext(h);
            return bVar;
        }
        return (xy9.a) invokeV.objValue;
    }

    @Override // com.repackage.bz9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // com.repackage.bz9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.unsubscribe();
        }
    }
}
