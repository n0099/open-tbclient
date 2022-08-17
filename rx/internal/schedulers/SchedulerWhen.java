package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ev9;
import com.repackage.jv9;
import com.repackage.oz9;
import com.repackage.pu9;
import com.repackage.qu9;
import com.repackage.ru9;
import com.repackage.su9;
import com.repackage.ty9;
import com.repackage.uu9;
import com.repackage.yu9;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes8.dex */
public class SchedulerWhen extends uu9 implements yu9 {
    public static /* synthetic */ Interceptable $ic;
    public static final yu9 d;
    public static final yu9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final uu9 a;
    public final su9<ru9<pu9>> b;
    public final yu9 c;

    /* loaded from: classes8.dex */
    public static class DelayedAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ev9 action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(ev9 ev9Var, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev9Var, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = ev9Var;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public yu9 callActual(uu9.a aVar, qu9 qu9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, qu9Var)) == null) ? aVar.c(new d(this.action, qu9Var), this.delayTime, this.unit) : (yu9) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class ImmediateAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ev9 action;

        public ImmediateAction(ev9 ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = ev9Var;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public yu9 callActual(uu9.a aVar, qu9 qu9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, qu9Var)) == null) ? aVar.b(new d(this.action, qu9Var)) : (yu9) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class ScheduledAction extends AtomicReference<yu9> implements yu9 {
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
        public void call(uu9.a aVar, qu9 qu9Var) {
            yu9 yu9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65538, this, aVar, qu9Var) == null) && (yu9Var = get()) != SchedulerWhen.e && yu9Var == SchedulerWhen.d) {
                yu9 callActual = callActual(aVar, qu9Var);
                if (compareAndSet(SchedulerWhen.d, callActual)) {
                    return;
                }
                callActual.unsubscribe();
            }
        }

        public abstract yu9 callActual(uu9.a aVar, qu9 qu9Var);

        @Override // com.repackage.yu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get().isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.yu9
        public void unsubscribe() {
            yu9 yu9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                yu9 yu9Var2 = SchedulerWhen.e;
                do {
                    yu9Var = get();
                    if (yu9Var == SchedulerWhen.e) {
                        return;
                    }
                } while (!compareAndSet(yu9Var, yu9Var2));
                if (yu9Var != SchedulerWhen.d) {
                    yu9Var.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements jv9<ScheduledAction, pu9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uu9.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0715a implements pu9.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScheduledAction a;
            public final /* synthetic */ a b;

            public C0715a(a aVar, ScheduledAction scheduledAction) {
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
            @Override // com.repackage.pu9.f, com.repackage.fv9
            public void call(qu9 qu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, qu9Var) == null) {
                    qu9Var.onSubscribe(this.a);
                    this.a.call(this.b.a, qu9Var);
                }
            }
        }

        public a(SchedulerWhen schedulerWhen, uu9.a aVar) {
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
        @Override // com.repackage.jv9
        public pu9 call(ScheduledAction scheduledAction) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scheduledAction)) == null) ? pu9.b(new C0715a(this, scheduledAction)) : (pu9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends uu9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean a;
        public final /* synthetic */ uu9.a b;
        public final /* synthetic */ su9 c;

        public b(SchedulerWhen schedulerWhen, uu9.a aVar, su9 su9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar, su9Var};
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
            this.c = su9Var;
            this.a = new AtomicBoolean();
        }

        @Override // com.repackage.uu9.a
        public yu9 b(ev9 ev9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ev9Var)) == null) {
                ImmediateAction immediateAction = new ImmediateAction(ev9Var);
                this.c.onNext(immediateAction);
                return immediateAction;
            }
            return (yu9) invokeL.objValue;
        }

        @Override // com.repackage.uu9.a
        public yu9 c(ev9 ev9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ev9Var, Long.valueOf(j), timeUnit})) == null) {
                DelayedAction delayedAction = new DelayedAction(ev9Var, j, timeUnit);
                this.c.onNext(delayedAction);
                return delayedAction;
            }
            return (yu9) invokeCommon.objValue;
        }

        @Override // com.repackage.yu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.get() : invokeV.booleanValue;
        }

        @Override // com.repackage.yu9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements yu9 {
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

        @Override // com.repackage.yu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.yu9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements ev9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qu9 a;
        public ev9 b;

        public d(ev9 ev9Var, qu9 qu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev9Var, qu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ev9Var;
            this.a = qu9Var;
        }

        @Override // com.repackage.ev9
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
        e = oz9.c();
    }

    public SchedulerWhen(jv9<ru9<ru9<pu9>>, pu9> jv9Var, uu9 uu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jv9Var, uu9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = uu9Var;
        PublishSubject D = PublishSubject.D();
        this.b = new ty9(D);
        this.c = jv9Var.call(D.n()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.repackage.su9<com.repackage.ru9<com.repackage.pu9>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.repackage.uu9
    public uu9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            uu9.a createWorker = this.a.createWorker();
            BufferUntilSubscriber D = BufferUntilSubscriber.D();
            ty9 ty9Var = new ty9(D);
            Object h = D.h(new a(this, createWorker));
            b bVar = new b(this, createWorker, ty9Var);
            this.b.onNext(h);
            return bVar;
        }
        return (uu9.a) invokeV.objValue;
    }

    @Override // com.repackage.yu9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // com.repackage.yu9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.unsubscribe();
        }
    }
}
