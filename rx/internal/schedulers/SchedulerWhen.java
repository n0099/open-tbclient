package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.av9;
import com.baidu.tieba.bv9;
import com.baidu.tieba.cz9;
import com.baidu.tieba.dv9;
import com.baidu.tieba.hv9;
import com.baidu.tieba.nv9;
import com.baidu.tieba.sv9;
import com.baidu.tieba.xz9;
import com.baidu.tieba.yu9;
import com.baidu.tieba.zu9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes8.dex */
public class SchedulerWhen extends dv9 implements hv9 {
    public static /* synthetic */ Interceptable $ic;
    public static final hv9 d;
    public static final hv9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final dv9 a;
    public final bv9<av9<yu9>> b;
    public final hv9 c;

    /* loaded from: classes8.dex */
    public static class DelayedAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final nv9 action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(nv9 nv9Var, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv9Var, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = nv9Var;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public hv9 callActual(dv9.a aVar, zu9 zu9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, zu9Var)) == null) ? aVar.c(new d(this.action, zu9Var), this.delayTime, this.unit) : (hv9) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class ImmediateAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final nv9 action;

        public ImmediateAction(nv9 nv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = nv9Var;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public hv9 callActual(dv9.a aVar, zu9 zu9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, zu9Var)) == null) ? aVar.b(new d(this.action, zu9Var)) : (hv9) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class ScheduledAction extends AtomicReference<hv9> implements hv9 {
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
        public void call(dv9.a aVar, zu9 zu9Var) {
            hv9 hv9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65538, this, aVar, zu9Var) == null) && (hv9Var = get()) != SchedulerWhen.e && hv9Var == SchedulerWhen.d) {
                hv9 callActual = callActual(aVar, zu9Var);
                if (compareAndSet(SchedulerWhen.d, callActual)) {
                    return;
                }
                callActual.unsubscribe();
            }
        }

        public abstract hv9 callActual(dv9.a aVar, zu9 zu9Var);

        @Override // com.baidu.tieba.hv9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get().isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.hv9
        public void unsubscribe() {
            hv9 hv9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                hv9 hv9Var2 = SchedulerWhen.e;
                do {
                    hv9Var = get();
                    if (hv9Var == SchedulerWhen.e) {
                        return;
                    }
                } while (!compareAndSet(hv9Var, hv9Var2));
                if (hv9Var != SchedulerWhen.d) {
                    hv9Var.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements sv9<ScheduledAction, yu9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv9.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0716a implements yu9.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScheduledAction a;
            public final /* synthetic */ a b;

            public C0716a(a aVar, ScheduledAction scheduledAction) {
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
            @Override // com.baidu.tieba.yu9.f, com.baidu.tieba.ov9
            public void call(zu9 zu9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zu9Var) == null) {
                    zu9Var.onSubscribe(this.a);
                    this.a.call(this.b.a, zu9Var);
                }
            }
        }

        public a(SchedulerWhen schedulerWhen, dv9.a aVar) {
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
        @Override // com.baidu.tieba.sv9
        public yu9 call(ScheduledAction scheduledAction) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scheduledAction)) == null) ? yu9.b(new C0716a(this, scheduledAction)) : (yu9) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends dv9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean a;
        public final /* synthetic */ dv9.a b;
        public final /* synthetic */ bv9 c;

        public b(SchedulerWhen schedulerWhen, dv9.a aVar, bv9 bv9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar, bv9Var};
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
            this.c = bv9Var;
            this.a = new AtomicBoolean();
        }

        @Override // com.baidu.tieba.dv9.a
        public hv9 b(nv9 nv9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nv9Var)) == null) {
                ImmediateAction immediateAction = new ImmediateAction(nv9Var);
                this.c.onNext(immediateAction);
                return immediateAction;
            }
            return (hv9) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dv9.a
        public hv9 c(nv9 nv9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{nv9Var, Long.valueOf(j), timeUnit})) == null) {
                DelayedAction delayedAction = new DelayedAction(nv9Var, j, timeUnit);
                this.c.onNext(delayedAction);
                return delayedAction;
            }
            return (hv9) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.hv9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.get() : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.hv9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements hv9 {
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

        @Override // com.baidu.tieba.hv9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.hv9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements nv9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public zu9 a;
        public nv9 b;

        public d(nv9 nv9Var, zu9 zu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nv9Var, zu9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nv9Var;
            this.a = zu9Var;
        }

        @Override // com.baidu.tieba.nv9
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
        e = xz9.c();
    }

    public SchedulerWhen(sv9<av9<av9<yu9>>, yu9> sv9Var, dv9 dv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sv9Var, dv9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = dv9Var;
        PublishSubject D = PublishSubject.D();
        this.b = new cz9(D);
        this.c = sv9Var.call(D.n()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.bv9<com.baidu.tieba.av9<com.baidu.tieba.yu9>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.dv9
    public dv9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            dv9.a createWorker = this.a.createWorker();
            BufferUntilSubscriber D = BufferUntilSubscriber.D();
            cz9 cz9Var = new cz9(D);
            Object h = D.h(new a(this, createWorker));
            b bVar = new b(this, createWorker, cz9Var);
            this.b.onNext(h);
            return bVar;
        }
        return (dv9.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hv9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hv9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.unsubscribe();
        }
    }
}
