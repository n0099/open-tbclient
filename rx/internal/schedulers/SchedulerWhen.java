package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e0a;
import com.baidu.tieba.j0a;
import com.baidu.tieba.o4a;
import com.baidu.tieba.pz9;
import com.baidu.tieba.qz9;
import com.baidu.tieba.rz9;
import com.baidu.tieba.sz9;
import com.baidu.tieba.t3a;
import com.baidu.tieba.uz9;
import com.baidu.tieba.yz9;
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
/* loaded from: classes9.dex */
public class SchedulerWhen extends uz9 implements yz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final yz9 d;
    public static final yz9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final uz9 a;
    public final sz9<rz9<pz9>> b;
    public final yz9 c;

    /* loaded from: classes9.dex */
    public class a implements j0a<ScheduledAction, pz9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz9.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0724a implements pz9.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScheduledAction a;
            public final /* synthetic */ a b;

            public C0724a(a aVar, ScheduledAction scheduledAction) {
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
            @Override // com.baidu.tieba.pz9.f, com.baidu.tieba.f0a
            public void call(qz9 qz9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, qz9Var) == null) {
                    qz9Var.onSubscribe(this.a);
                    this.a.call(this.b.a, qz9Var);
                }
            }
        }

        public a(SchedulerWhen schedulerWhen, uz9.a aVar) {
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
        @Override // com.baidu.tieba.j0a
        public pz9 call(ScheduledAction scheduledAction) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scheduledAction)) == null) {
                return pz9.b(new C0724a(this, scheduledAction));
            }
            return (pz9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class DelayedAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e0a action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(e0a e0aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e0aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = e0aVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public yz9 callActual(uz9.a aVar, qz9 qz9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, qz9Var)) == null) {
                return aVar.c(new d(this.action, qz9Var), this.delayTime, this.unit);
            }
            return (yz9) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class ImmediateAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e0a action;

        public ImmediateAction(e0a e0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = e0aVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public yz9 callActual(uz9.a aVar, qz9 qz9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, qz9Var)) == null) {
                return aVar.b(new d(this.action, qz9Var));
            }
            return (yz9) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<yz9> implements yz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract yz9 callActual(uz9.a aVar, qz9 qz9Var);

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

        @Override // com.baidu.tieba.yz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return get().isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.yz9
        public void unsubscribe() {
            yz9 yz9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                yz9 yz9Var2 = SchedulerWhen.e;
                do {
                    yz9Var = get();
                    if (yz9Var == SchedulerWhen.e) {
                        return;
                    }
                } while (!compareAndSet(yz9Var, yz9Var2));
                if (yz9Var != SchedulerWhen.d) {
                    yz9Var.unsubscribe();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(uz9.a aVar, qz9 qz9Var) {
            yz9 yz9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(65538, this, aVar, qz9Var) != null) || (yz9Var = get()) == SchedulerWhen.e || yz9Var != SchedulerWhen.d) {
                return;
            }
            yz9 callActual = callActual(aVar, qz9Var);
            if (!compareAndSet(SchedulerWhen.d, callActual)) {
                callActual.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends uz9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean a;
        public final /* synthetic */ uz9.a b;
        public final /* synthetic */ sz9 c;

        public b(SchedulerWhen schedulerWhen, uz9.a aVar, sz9 sz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar, sz9Var};
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
            this.c = sz9Var;
            this.a = new AtomicBoolean();
        }

        @Override // com.baidu.tieba.uz9.a
        public yz9 b(e0a e0aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e0aVar)) == null) {
                ImmediateAction immediateAction = new ImmediateAction(e0aVar);
                this.c.onNext(immediateAction);
                return immediateAction;
            }
            return (yz9) invokeL.objValue;
        }

        @Override // com.baidu.tieba.uz9.a
        public yz9 c(e0a e0aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{e0aVar, Long.valueOf(j), timeUnit})) == null) {
                DelayedAction delayedAction = new DelayedAction(e0aVar, j, timeUnit);
                this.c.onNext(delayedAction);
                return delayedAction;
            }
            return (yz9) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.yz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.get();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.yz9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements yz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.yz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.yz9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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
    }

    /* loaded from: classes9.dex */
    public static class d implements e0a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qz9 a;
        public e0a b;

        public d(e0a e0aVar, qz9 qz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e0aVar, qz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e0aVar;
            this.a = qz9Var;
        }

        @Override // com.baidu.tieba.e0a
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
        e = o4a.c();
    }

    @Override // com.baidu.tieba.yz9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c.isUnsubscribed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yz9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.unsubscribe();
        }
    }

    public SchedulerWhen(j0a<rz9<rz9<pz9>>, pz9> j0aVar, uz9 uz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j0aVar, uz9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = uz9Var;
        PublishSubject D = PublishSubject.D();
        this.b = new t3a(D);
        this.c = j0aVar.call(D.n()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.sz9<com.baidu.tieba.rz9<com.baidu.tieba.pz9>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.uz9
    public uz9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            uz9.a createWorker = this.a.createWorker();
            BufferUntilSubscriber D = BufferUntilSubscriber.D();
            t3a t3aVar = new t3a(D);
            Object h = D.h(new a(this, createWorker));
            b bVar = new b(this, createWorker, t3aVar);
            this.b.onNext(h);
            return bVar;
        }
        return (uz9.a) invokeV.objValue;
    }
}
