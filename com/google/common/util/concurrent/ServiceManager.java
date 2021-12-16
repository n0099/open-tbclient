package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.j;
import c.i.d.a.n;
import c.i.d.a.p;
import c.i.d.c.e1;
import c.i.d.c.o1;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes3.dex */
public final class ServiceManager {
    public static /* synthetic */ Interceptable $ic;
    public static final ListenerCallQueue.Event<Listener> HEALTHY_EVENT;
    public static final ListenerCallQueue.Event<Listener> STOPPED_EVENT;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImmutableList<Service> services;
    public final ServiceManagerState state;

    /* loaded from: classes3.dex */
    public static final class EmptyServiceManagerWarning extends Throwable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public EmptyServiceManagerWarning() {
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
    }

    /* loaded from: classes3.dex */
    public static abstract class Listener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Listener() {
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

        public void failure(Service service) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, service) == null) {
            }
        }

        public void healthy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void stopped() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class NoOpService extends AbstractService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public NoOpService() {
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

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                notifyStarted();
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                notifyStopped();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class ServiceListener extends Service.Listener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Service service;
        public final WeakReference<ServiceManagerState> state;

        public ServiceListener(Service service, WeakReference<ServiceManagerState> weakReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {service, weakReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.service = service;
            this.state = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State state, Throwable th) {
            ServiceManagerState serviceManagerState;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, state, th) == null) || (serviceManagerState = this.state.get()) == null) {
                return;
            }
            if (!(this.service instanceof NoOpService)) {
                Logger logger = ServiceManager.logger;
                Level level = Level.SEVERE;
                logger.log(level, "Service " + this.service + " has failed in the " + state + " state.", th);
            }
            serviceManagerState.transitionService(this.service, state, Service.State.FAILED);
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            ServiceManagerState serviceManagerState;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (serviceManagerState = this.state.get()) == null) {
                return;
            }
            serviceManagerState.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            ServiceManagerState serviceManagerState;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (serviceManagerState = this.state.get()) == null) {
                return;
            }
            serviceManagerState.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
            if (this.service instanceof NoOpService) {
                return;
            }
            ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.service);
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State state) {
            ServiceManagerState serviceManagerState;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, state) == null) || (serviceManagerState = this.state.get()) == null) {
                return;
            }
            serviceManagerState.transitionService(this.service, state, Service.State.STOPPING);
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State state) {
            ServiceManagerState serviceManagerState;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, state) == null) || (serviceManagerState = this.state.get()) == null) {
                return;
            }
            if (!(this.service instanceof NoOpService)) {
                ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, state});
            }
            serviceManagerState.transitionService(this.service, state, Service.State.TERMINATED);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1074103120, "Lcom/google/common/util/concurrent/ServiceManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1074103120, "Lcom/google/common/util/concurrent/ServiceManager;");
                return;
            }
        }
        logger = Logger.getLogger(ServiceManager.class.getName());
        HEALTHY_EVENT = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "healthy()" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Listener listener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, listener) == null) {
                    listener.healthy();
                }
            }
        };
        STOPPED_EVENT = new ListenerCallQueue.Event<Listener>() { // from class: com.google.common.util.concurrent.ServiceManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "stopped()" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Listener listener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, listener) == null) {
                    listener.stopped();
                }
            }
        };
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ImmutableList<Service> copyOf = ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new EmptyServiceManagerWarning());
            copyOf = ImmutableList.of(new NoOpService());
        }
        this.state = new ServiceManagerState(copyOf);
        this.services = copyOf;
        WeakReference weakReference = new WeakReference(this.state);
        o1<Service> it = copyOf.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            next.addListener(new ServiceListener(next, weakReference), MoreExecutors.directExecutor());
            n.k(next.state() == Service.State.NEW, "Can only manage NEW services, %s", next);
        }
        this.state.markReady();
    }

    public void addListener(Listener listener, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listener, executor) == null) {
            this.state.addListener(listener, executor);
        }
    }

    public void awaitHealthy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.state.awaitHealthy();
        }
    }

    public void awaitStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.state.awaitStopped();
        }
    }

    public boolean isHealthy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            o1<Service> it = this.services.iterator();
            while (it.hasNext()) {
                if (!it.next().isRunning()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public ImmutableMultimap<Service.State, Service> servicesByState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.state.servicesByState() : (ImmutableMultimap) invokeV.objValue;
    }

    public ServiceManager startAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            o1<Service> it = this.services.iterator();
            while (it.hasNext()) {
                Service next = it.next();
                Service.State state = next.state();
                n.B(state == Service.State.NEW, "Service %s is %s, cannot start it.", next, state);
            }
            o1<Service> it2 = this.services.iterator();
            while (it2.hasNext()) {
                Service next2 = it2.next();
                try {
                    this.state.tryStartTiming(next2);
                    next2.startAsync();
                } catch (IllegalStateException e2) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    logger2.log(level, "Unable to start Service " + next2, (Throwable) e2);
                }
            }
            return this;
        }
        return (ServiceManager) invokeV.objValue;
    }

    public ImmutableMap<Service, Long> startupTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.state.startupTimes() : (ImmutableMap) invokeV.objValue;
    }

    public ServiceManager stopAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            o1<Service> it = this.services.iterator();
            while (it.hasNext()) {
                it.next().stopAsync();
            }
            return this;
        }
        return (ServiceManager) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            j.b b2 = j.b(ServiceManager.class);
            b2.d("services", c.i.d.c.n.c(this.services, Predicates.j(Predicates.h(NoOpService.class))));
            return b2.toString();
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public static final class ServiceManagerState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Monitor.Guard awaitHealthGuard;
        public final ListenerCallQueue<Listener> listeners;
        public final Monitor monitor;
        public final int numberOfServices;
        public boolean ready;
        public final e1<Service.State, Service> servicesByState;
        public final Map<Service, p> startupTimers;
        public final s0<Service.State> states;
        public final Monitor.Guard stoppedGuard;
        public boolean transitioned;

        /* loaded from: classes3.dex */
        public final class AwaitHealthGuard extends Monitor.Guard {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ServiceManagerState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AwaitHealthGuard(ServiceManagerState serviceManagerState) {
                super(serviceManagerState.monitor);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {serviceManagerState};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Monitor) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = serviceManagerState;
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    int count = this.this$0.states.count(Service.State.RUNNING);
                    ServiceManagerState serviceManagerState = this.this$0;
                    return count == serviceManagerState.numberOfServices || serviceManagerState.states.contains(Service.State.STOPPING) || this.this$0.states.contains(Service.State.TERMINATED) || this.this$0.states.contains(Service.State.FAILED);
                }
                return invokeV.booleanValue;
            }
        }

        /* loaded from: classes3.dex */
        public final class StoppedGuard extends Monitor.Guard {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ServiceManagerState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StoppedGuard(ServiceManagerState serviceManagerState) {
                super(serviceManagerState.monitor);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {serviceManagerState};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Monitor) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = serviceManagerState;
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            public boolean isSatisfied() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.states.count(Service.State.TERMINATED) + this.this$0.states.count(Service.State.FAILED) == this.this$0.numberOfServices : invokeV.booleanValue;
            }
        }

        public ServiceManagerState(ImmutableCollection<Service> immutableCollection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {immutableCollection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.monitor = new Monitor();
            e1<Service.State, Service> b2 = MultimapBuilder.a(Service.State.class).b().b();
            this.servicesByState = b2;
            this.states = b2.keys();
            this.startupTimers = Maps.u();
            this.awaitHealthGuard = new AwaitHealthGuard(this);
            this.stoppedGuard = new StoppedGuard(this);
            this.listeners = new ListenerCallQueue<>();
            this.numberOfServices = immutableCollection.size();
            this.servicesByState.putAll(Service.State.NEW, immutableCollection);
        }

        public void addListener(Listener listener, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, listener, executor) == null) {
                this.listeners.addListener(listener, executor);
            }
        }

        public void awaitHealthy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
                try {
                    checkHealthy();
                } finally {
                    this.monitor.leave();
                }
            }
        }

        public void awaitStopped() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
                this.monitor.leave();
            }
        }

        public void checkHealthy() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.states.count(Service.State.RUNNING) == this.numberOfServices) {
                return;
            }
            throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.e(this.servicesByState, Predicates.j(Predicates.f(Service.State.RUNNING))));
        }

        public void dispatchListenerEvents() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                n.x(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
                this.listeners.dispatch();
            }
        }

        public void enqueueFailedEvent(Service service) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, service) == null) {
                this.listeners.enqueue(new ListenerCallQueue.Event<Listener>(this, service) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceManagerState this$0;
                    public final /* synthetic */ Service val$service;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, service};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$service = service;
                    }

                    public String toString() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return "failed({service=" + this.val$service + "})";
                        }
                        return (String) invokeV.objValue;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
                    public void call(Listener listener) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, listener) == null) {
                            listener.failure(this.val$service);
                        }
                    }
                });
            }
        }

        public void enqueueHealthyEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.listeners.enqueue(ServiceManager.HEALTHY_EVENT);
            }
        }

        public void enqueueStoppedEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.listeners.enqueue(ServiceManager.STOPPED_EVENT);
            }
        }

        public void markReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                this.monitor.enter();
                try {
                    if (!this.transitioned) {
                        this.ready = true;
                        return;
                    }
                    ArrayList i2 = Lists.i();
                    o1<Service> it = servicesByState().values().iterator();
                    while (it.hasNext()) {
                        Service next = it.next();
                        if (next.state() != Service.State.NEW) {
                            i2.add(next);
                        }
                    }
                    throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + i2);
                } finally {
                    this.monitor.leave();
                }
            }
        }

        public ImmutableMultimap<Service.State, Service> servicesByState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                ImmutableSetMultimap.a builder = ImmutableSetMultimap.builder();
                this.monitor.enter();
                try {
                    for (Map.Entry<Service.State, Service> entry : this.servicesByState.entries()) {
                        if (!(entry.getValue() instanceof NoOpService)) {
                            builder.h(entry);
                        }
                    }
                    this.monitor.leave();
                    return builder.f();
                } catch (Throwable th) {
                    this.monitor.leave();
                    throw th;
                }
            }
            return (ImmutableMultimap) invokeV.objValue;
        }

        public ImmutableMap<Service, Long> startupTimes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                this.monitor.enter();
                try {
                    ArrayList l = Lists.l(this.startupTimers.size());
                    for (Map.Entry<Service, p> entry : this.startupTimers.entrySet()) {
                        Service key = entry.getKey();
                        p value = entry.getValue();
                        if (!value.g() && !(key instanceof NoOpService)) {
                            l.add(Maps.l(key, Long.valueOf(value.e(TimeUnit.MILLISECONDS))));
                        }
                    }
                    this.monitor.leave();
                    Collections.sort(l, Ordering.natural().onResultOf(new g<Map.Entry<Service, Long>, Long>(this) { // from class: com.google.common.util.concurrent.ServiceManager.ServiceManagerState.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ServiceManagerState this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // c.i.d.a.g
                        public Long apply(Map.Entry<Service, Long> entry2) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, entry2)) == null) ? entry2.getValue() : (Long) invokeL.objValue;
                        }
                    }));
                    return ImmutableMap.copyOf(l);
                } catch (Throwable th) {
                    this.monitor.leave();
                    throw th;
                }
            }
            return (ImmutableMap) invokeV.objValue;
        }

        public void transitionService(Service service, Service.State state, Service.State state2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, service, state, state2) == null) {
                n.p(service);
                n.d(state != state2);
                this.monitor.enter();
                try {
                    this.transitioned = true;
                    if (this.ready) {
                        n.B(this.servicesByState.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                        n.B(this.servicesByState.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                        p pVar = this.startupTimers.get(service);
                        if (pVar == null) {
                            pVar = p.c();
                            this.startupTimers.put(service, pVar);
                        }
                        if (state2.compareTo(Service.State.RUNNING) >= 0 && pVar.g()) {
                            pVar.i();
                            if (!(service instanceof NoOpService)) {
                                ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, pVar});
                            }
                        }
                        if (state2 == Service.State.FAILED) {
                            enqueueFailedEvent(service);
                        }
                        if (this.states.count(Service.State.RUNNING) == this.numberOfServices) {
                            enqueueHealthyEvent();
                        } else if (this.states.count(Service.State.TERMINATED) + this.states.count(Service.State.FAILED) == this.numberOfServices) {
                            enqueueStoppedEvent();
                        }
                    }
                } finally {
                    this.monitor.leave();
                    dispatchListenerEvents();
                }
            }
        }

        public void tryStartTiming(Service service) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, service) == null) {
                this.monitor.enter();
                try {
                    if (this.startupTimers.get(service) == null) {
                        this.startupTimers.put(service, p.c());
                    }
                } finally {
                    this.monitor.leave();
                }
            }
        }

        public void awaitStopped(long j2, TimeUnit timeUnit) throws TimeoutException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048580, this, j2, timeUnit) == null) {
                this.monitor.enter();
                try {
                    if (this.monitor.waitForUninterruptibly(this.stoppedGuard, j2, timeUnit)) {
                        return;
                    }
                    throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.e(this.servicesByState, Predicates.j(Predicates.g(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                } finally {
                    this.monitor.leave();
                }
            }
        }

        public void awaitHealthy(long j2, TimeUnit timeUnit) throws TimeoutException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, timeUnit) == null) {
                this.monitor.enter();
                try {
                    if (this.monitor.waitForUninterruptibly(this.awaitHealthGuard, j2, timeUnit)) {
                        checkHealthy();
                        return;
                    }
                    throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.e(this.servicesByState, Predicates.g(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
                } finally {
                    this.monitor.leave();
                }
            }
        }
    }

    public void addListener(Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, listener) == null) {
            this.state.addListener(listener, MoreExecutors.directExecutor());
        }
    }

    public void awaitHealthy(long j2, TimeUnit timeUnit) throws TimeoutException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j2, timeUnit) == null) {
            this.state.awaitHealthy(j2, timeUnit);
        }
    }

    public void awaitStopped(long j2, TimeUnit timeUnit) throws TimeoutException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048581, this, j2, timeUnit) == null) {
            this.state.awaitStopped(j2, timeUnit);
        }
    }
}
