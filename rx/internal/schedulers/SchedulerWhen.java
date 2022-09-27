package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c2a;
import com.baidu.tieba.dx9;
import com.baidu.tieba.ex9;
import com.baidu.tieba.fx9;
import com.baidu.tieba.gx9;
import com.baidu.tieba.h1a;
import com.baidu.tieba.ix9;
import com.baidu.tieba.mx9;
import com.baidu.tieba.sx9;
import com.baidu.tieba.xx9;
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
public class SchedulerWhen extends ix9 implements mx9 {
    public static /* synthetic */ Interceptable $ic;
    public static final mx9 d;
    public static final mx9 e;
    public transient /* synthetic */ FieldHolder $fh;
    public final ix9 a;
    public final gx9<fx9<dx9>> b;
    public final mx9 c;

    /* loaded from: classes9.dex */
    public static class DelayedAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final sx9 action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(sx9 sx9Var, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = sx9Var;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public mx9 callActual(ix9.a aVar, ex9 ex9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, ex9Var)) == null) ? aVar.c(new d(this.action, ex9Var), this.delayTime, this.unit) : (mx9) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class ImmediateAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final sx9 action;

        public ImmediateAction(sx9 sx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = sx9Var;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public mx9 callActual(ix9.a aVar, ex9 ex9Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, ex9Var)) == null) ? aVar.b(new d(this.action, ex9Var)) : (mx9) invokeLL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ScheduledAction extends AtomicReference<mx9> implements mx9 {
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
        public void call(ix9.a aVar, ex9 ex9Var) {
            mx9 mx9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65538, this, aVar, ex9Var) == null) && (mx9Var = get()) != SchedulerWhen.e && mx9Var == SchedulerWhen.d) {
                mx9 callActual = callActual(aVar, ex9Var);
                if (compareAndSet(SchedulerWhen.d, callActual)) {
                    return;
                }
                callActual.unsubscribe();
            }
        }

        public abstract mx9 callActual(ix9.a aVar, ex9 ex9Var);

        @Override // com.baidu.tieba.mx9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get().isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.mx9
        public void unsubscribe() {
            mx9 mx9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                mx9 mx9Var2 = SchedulerWhen.e;
                do {
                    mx9Var = get();
                    if (mx9Var == SchedulerWhen.e) {
                        return;
                    }
                } while (!compareAndSet(mx9Var, mx9Var2));
                if (mx9Var != SchedulerWhen.d) {
                    mx9Var.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements xx9<ScheduledAction, dx9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix9.a a;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0717a implements dx9.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ScheduledAction a;
            public final /* synthetic */ a b;

            public C0717a(a aVar, ScheduledAction scheduledAction) {
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
            @Override // com.baidu.tieba.dx9.f, com.baidu.tieba.tx9
            public void call(ex9 ex9Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ex9Var) == null) {
                    ex9Var.onSubscribe(this.a);
                    this.a.call(this.b.a, ex9Var);
                }
            }
        }

        public a(SchedulerWhen schedulerWhen, ix9.a aVar) {
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
        @Override // com.baidu.tieba.xx9
        public dx9 call(ScheduledAction scheduledAction) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scheduledAction)) == null) ? dx9.b(new C0717a(this, scheduledAction)) : (dx9) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends ix9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicBoolean a;
        public final /* synthetic */ ix9.a b;
        public final /* synthetic */ gx9 c;

        public b(SchedulerWhen schedulerWhen, ix9.a aVar, gx9 gx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar, gx9Var};
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
            this.c = gx9Var;
            this.a = new AtomicBoolean();
        }

        @Override // com.baidu.tieba.ix9.a
        public mx9 b(sx9 sx9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sx9Var)) == null) {
                ImmediateAction immediateAction = new ImmediateAction(sx9Var);
                this.c.onNext(immediateAction);
                return immediateAction;
            }
            return (mx9) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ix9.a
        public mx9 c(sx9 sx9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{sx9Var, Long.valueOf(j), timeUnit})) == null) {
                DelayedAction delayedAction = new DelayedAction(sx9Var, j, timeUnit);
                this.c.onNext(delayedAction);
                return delayedAction;
            }
            return (mx9) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.mx9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.get() : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.mx9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.a.compareAndSet(false, true)) {
                this.b.unsubscribe();
                this.c.onCompleted();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements mx9 {
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

        @Override // com.baidu.tieba.mx9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.mx9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements sx9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ex9 a;
        public sx9 b;

        public d(sx9 sx9Var, ex9 ex9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx9Var, ex9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sx9Var;
            this.a = ex9Var;
        }

        @Override // com.baidu.tieba.sx9
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
        e = c2a.c();
    }

    public SchedulerWhen(xx9<fx9<fx9<dx9>>, dx9> xx9Var, ix9 ix9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xx9Var, ix9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = ix9Var;
        PublishSubject D = PublishSubject.D();
        this.b = new h1a(D);
        this.c = xx9Var.call(D.n()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.baidu.tieba.gx9<com.baidu.tieba.fx9<com.baidu.tieba.dx9>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.ix9
    public ix9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ix9.a createWorker = this.a.createWorker();
            BufferUntilSubscriber D = BufferUntilSubscriber.D();
            h1a h1aVar = new h1a(D);
            Object h = D.h(new a(this, createWorker));
            b bVar = new b(this, createWorker, h1aVar);
            this.b.onNext(h);
            return bVar;
        }
        return (ix9.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mx9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mx9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.unsubscribe();
        }
    }
}
