package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.b;
import h.e;
import h.g;
import h.k;
import h.n.f;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.operators.BufferUntilSubscriber;
import rx.subjects.PublishSubject;
/* loaded from: classes3.dex */
public class SchedulerWhen extends g implements k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final k f72648h;

    /* renamed from: i  reason: collision with root package name */
    public static final k f72649i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final g f72650e;

    /* renamed from: f  reason: collision with root package name */
    public final e<h.d<h.b>> f72651f;

    /* renamed from: g  reason: collision with root package name */
    public final k f72652g;

    /* loaded from: classes3.dex */
    public static class DelayedAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final h.n.a action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(h.n.a aVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = aVar;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public k callActual(g.a aVar, h.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, cVar)) == null) ? aVar.c(new d(this.action, cVar), this.delayTime, this.unit) : (k) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class ImmediateAction extends ScheduledAction {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final h.n.a action;

        public ImmediateAction(h.n.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.action = aVar;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        public k callActual(g.a aVar, h.c cVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, aVar, cVar)) == null) ? aVar.b(new d(this.action, cVar)) : (k) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ScheduledAction extends AtomicReference<k> implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScheduledAction() {
            super(SchedulerWhen.f72648h);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(g.a aVar, h.c cVar) {
            k kVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65538, this, aVar, cVar) == null) && (kVar = get()) != SchedulerWhen.f72649i && kVar == SchedulerWhen.f72648h) {
                k callActual = callActual(aVar, cVar);
                if (compareAndSet(SchedulerWhen.f72648h, callActual)) {
                    return;
                }
                callActual.unsubscribe();
            }
        }

        public abstract k callActual(g.a aVar, h.c cVar);

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get().isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            k kVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                k kVar2 = SchedulerWhen.f72649i;
                do {
                    kVar = get();
                    if (kVar == SchedulerWhen.f72649i) {
                        return;
                    }
                } while (!compareAndSet(kVar, kVar2));
                if (kVar != SchedulerWhen.f72648h) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements f<ScheduledAction, h.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g.a f72653e;

        /* renamed from: rx.internal.schedulers.SchedulerWhen$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C2087a implements b.f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ScheduledAction f72654e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f72655f;

            public C2087a(a aVar, ScheduledAction scheduledAction) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, scheduledAction};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72655f = aVar;
                this.f72654e = scheduledAction;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.b.f, h.n.b
            public void call(h.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    cVar.onSubscribe(this.f72654e);
                    this.f72654e.call(this.f72655f.f72653e, cVar);
                }
            }
        }

        public a(SchedulerWhen schedulerWhen, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72653e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        public h.b call(ScheduledAction scheduledAction) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scheduledAction)) == null) ? h.b.b(new C2087a(this, scheduledAction)) : (h.b) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f72656e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g.a f72657f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f72658g;

        public b(SchedulerWhen schedulerWhen, g.a aVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {schedulerWhen, aVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72657f = aVar;
            this.f72658g = eVar;
            this.f72656e = new AtomicBoolean();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                ImmediateAction immediateAction = new ImmediateAction(aVar);
                this.f72658g.onNext(immediateAction);
                return immediateAction;
            }
            return (k) invokeL.objValue;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                DelayedAction delayedAction = new DelayedAction(aVar, j, timeUnit);
                this.f72658g.onNext(delayedAction);
                return delayedAction;
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72656e.get() : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f72656e.compareAndSet(false, true)) {
                this.f72657f.unsubscribe();
                this.f72658g.onCompleted();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public h.c f72659e;

        /* renamed from: f  reason: collision with root package name */
        public h.n.a f72660f;

        public d(h.n.a aVar, h.c cVar) {
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
            this.f72660f = aVar;
            this.f72659e = cVar;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f72660f.call();
                } finally {
                    this.f72659e.onCompleted();
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
        f72648h = new c();
        f72649i = h.u.e.c();
    }

    public SchedulerWhen(f<h.d<h.d<h.b>>, h.b> fVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72650e = gVar;
        PublishSubject F = PublishSubject.F();
        this.f72651f = new h.q.d(F);
        this.f72652g = fVar.call(F.n()).f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: h.e<h.d<h.b>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            g.a createWorker = this.f72650e.createWorker();
            BufferUntilSubscriber F = BufferUntilSubscriber.F();
            h.q.d dVar = new h.q.d(F);
            Object h2 = F.h(new a(this, createWorker));
            b bVar = new b(this, createWorker, dVar);
            this.f72651f.onNext(h2);
            return bVar;
        }
        return (g.a) invokeV.objValue;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72652g.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // h.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f72652g.unsubscribe();
        }
    }
}
