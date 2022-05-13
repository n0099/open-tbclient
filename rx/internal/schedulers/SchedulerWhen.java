package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dy9;
import com.repackage.jy9;
import com.repackage.oy9;
import com.repackage.t2a;
import com.repackage.ux9;
import com.repackage.vx9;
import com.repackage.wx9;
import com.repackage.xx9;
import com.repackage.y1a;
import com.repackage.zx9;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes8.dex */
public class SchedulerWhen extends zx9 implements dy9 {
    public static /* synthetic */ Interceptable $ic;
    public static final dy9 d;
    public static final dy9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final zx9 a;
    public final xx9<wx9<ux9>> b;
    public final dy9 c;

    /* loaded from: classes8.dex */
    public static class DelayedAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jy9 action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(jy9 jy9Var, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy9Var, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = jy9Var;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public dy9 callActual(zx9.a aVar, vx9 vx9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, vx9Var)) == null) ? aVar.c(new d(this.action, vx9Var), this.delayTime, this.unit) : (dy9) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class ImmediateAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final jy9 action;

        public ImmediateAction(jy9 jy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = jy9Var;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public dy9 callActual(zx9.a aVar, vx9 vx9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, vx9Var)) == null) ? aVar.b(new d(this.action, vx9Var)) : (dy9) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class ScheduledAction extends AtomicReference<dy9> implements dy9 {
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
        public void call(zx9.a aVar, vx9 vx9Var) {
            dy9 dy9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65538, this, aVar, vx9Var) == null) && (dy9Var = get()) != SchedulerWhen.e && dy9Var == SchedulerWhen.d) {
                dy9 callActual = callActual(aVar, vx9Var);
                if (compareAndSet(SchedulerWhen.d, callActual)) {
                    return;
                }
                callActual.unsubscribe();
            }
        }

        public abstract dy9 callActual(zx9.a aVar, vx9 vx9Var);

        @Override // com.repackage.dy9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get().isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.dy9
        public void unsubscribe() {
            dy9 dy9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                dy9 dy9Var2 = SchedulerWhen.e;
                do {
                    dy9Var = get();
                    if (dy9Var == SchedulerWhen.e) {
                        return;
                    }
                } while (!compareAndSet(dy9Var, dy9Var2));
                if (dy9Var != SchedulerWhen.d) {
                    dy9Var.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements oy9<ScheduledAction, ux9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zx9.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0666a implements ux9.f {
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
            @Override // com.repackage.ux9.f, com.repackage.ky9
            public void call(vx9 vx9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, vx9Var) == null) {
                    vx9Var.onSubscribe(this.a);
                    this.a.call(this.b.a, vx9Var);
                }
            }
        }

        public a(SchedulerWhen schedulerWhen, zx9.a aVar) {
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
        @Override // com.repackage.oy9
        public ux9 call(ScheduledAction scheduledAction) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scheduledAction)) == null) ? ux9.b(new C0666a(this, scheduledAction)) : (ux9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends zx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean a;
        public final /* synthetic */ zx9.a b;
        public final /* synthetic */ xx9 c;

        public b(SchedulerWhen schedulerWhen, zx9.a aVar, xx9 xx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar, xx9Var};
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
            this.c = xx9Var;
            this.a = new AtomicBoolean();
        }

        @Override // com.repackage.zx9.a
        public dy9 b(jy9 jy9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jy9Var)) == null) {
                ImmediateAction immediateAction = new ImmediateAction(jy9Var);
                this.c.onNext(immediateAction);
                return immediateAction;
            }
            return (dy9) invokeL.objValue;
        }

        @Override // com.repackage.zx9.a
        public dy9 c(jy9 jy9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jy9Var, Long.valueOf(j), timeUnit})) == null) {
                DelayedAction delayedAction = new DelayedAction(jy9Var, j, timeUnit);
                this.c.onNext(delayedAction);
                return delayedAction;
            }
            return (dy9) invokeCommon.objValue;
        }

        @Override // com.repackage.dy9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.get() : invokeV.booleanValue;
        }

        @Override // com.repackage.dy9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements dy9 {
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

        @Override // com.repackage.dy9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.dy9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements jy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vx9 a;
        public jy9 b;

        public d(jy9 jy9Var, vx9 vx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jy9Var, vx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jy9Var;
            this.a = vx9Var;
        }

        @Override // com.repackage.jy9
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
        e = t2a.c();
    }

    public SchedulerWhen(oy9<wx9<wx9<ux9>>, ux9> oy9Var, zx9 zx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oy9Var, zx9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = zx9Var;
        PublishSubject D = PublishSubject.D();
        this.b = new y1a(D);
        this.c = oy9Var.call(D.n()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.repackage.xx9<com.repackage.wx9<com.repackage.ux9>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.repackage.zx9
    public zx9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zx9.a createWorker = this.a.createWorker();
            BufferUntilSubscriber D = BufferUntilSubscriber.D();
            y1a y1aVar = new y1a(D);
            Object h = D.h(new a(this, createWorker));
            b bVar = new b(this, createWorker, y1aVar);
            this.b.onNext(h);
            return bVar;
        }
        return (zx9.a) invokeV.objValue;
    }

    @Override // com.repackage.dy9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // com.repackage.dy9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.unsubscribe();
        }
    }
}
