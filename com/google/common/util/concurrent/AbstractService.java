package com.google.common.util.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import d.f.d.a.n;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes6.dex */
public abstract class AbstractService implements Service {
    public static /* synthetic */ Interceptable $ic;
    public static final ListenerCallQueue.Event<Service.Listener> RUNNING_EVENT;
    public static final ListenerCallQueue.Event<Service.Listener> STARTING_EVENT;
    public static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_RUNNING_EVENT;
    public static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_STARTING_EVENT;
    public static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_NEW_EVENT;
    public static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_RUNNING_EVENT;
    public static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STARTING_EVENT;
    public static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STOPPING_EVENT;
    public transient /* synthetic */ FieldHolder $fh;
    public final Monitor.Guard hasReachedRunning;
    public final Monitor.Guard isStartable;
    public final Monitor.Guard isStoppable;
    public final Monitor.Guard isStopped;
    public final ListenerCallQueue<Service.Listener> listeners;
    public final Monitor monitor;
    public volatile StateSnapshot snapshot;

    /* renamed from: com.google.common.util.concurrent.AbstractService$6  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-780500375, "Lcom/google/common/util/concurrent/AbstractService$6;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-780500375, "Lcom/google/common/util/concurrent/AbstractService$6;");
                    return;
                }
            }
            int[] iArr = new int[Service.State.values().length];
            $SwitchMap$com$google$common$util$concurrent$Service$State = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$common$util$concurrent$Service$State[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class HasReachedRunningGuard extends Monitor.Guard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbstractService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HasReachedRunningGuard(AbstractService abstractService) {
            super(abstractService.monitor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractService};
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
            this.this$0 = abstractService;
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.state().compareTo(Service.State.RUNNING) >= 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class IsStartableGuard extends Monitor.Guard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbstractService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IsStartableGuard(AbstractService abstractService) {
            super(abstractService.monitor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractService};
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
            this.this$0 = abstractService;
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.state() == Service.State.NEW : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class IsStoppableGuard extends Monitor.Guard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbstractService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IsStoppableGuard(AbstractService abstractService) {
            super(abstractService.monitor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractService};
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
            this.this$0 = abstractService;
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.state().compareTo(Service.State.RUNNING) <= 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public final class IsStoppedGuard extends Monitor.Guard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbstractService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IsStoppedGuard(AbstractService abstractService) {
            super(abstractService.monitor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractService};
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
            this.this$0 = abstractService;
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.state().isTerminal() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class StateSnapshot {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Throwable failure;
        public final boolean shutdownWhenStartupFinishes;
        public final Service.State state;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public StateSnapshot(Service.State state) {
            this(state, false, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {state};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Service.State) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (Throwable) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Service.State externalState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.shutdownWhenStartupFinishes && this.state == Service.State.STARTING) {
                    return Service.State.STOPPING;
                }
                return this.state;
            }
            return (Service.State) invokeV.objValue;
        }

        public Throwable failureCause() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                n.A(this.state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", this.state);
                return this.failure;
            }
            return (Throwable) invokeV.objValue;
        }

        public StateSnapshot(Service.State state, boolean z, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {state, Boolean.valueOf(z), th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            n.k(!z || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            n.l(!((state == Service.State.FAILED) ^ (th != null)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.state = state;
            this.shutdownWhenStartupFinishes = z;
            this.failure = th;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(946672827, "Lcom/google/common/util/concurrent/AbstractService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(946672827, "Lcom/google/common/util/concurrent/AbstractService;");
                return;
            }
        }
        STARTING_EVENT = new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.1
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "starting()" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Service.Listener listener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, listener) == null) {
                    listener.starting();
                }
            }
        };
        RUNNING_EVENT = new ListenerCallQueue.Event<Service.Listener>() { // from class: com.google.common.util.concurrent.AbstractService.2
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
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "running()" : (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Service.Listener listener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, listener) == null) {
                    listener.running();
                }
            }
        };
        STOPPING_FROM_STARTING_EVENT = stoppingEvent(Service.State.STARTING);
        STOPPING_FROM_RUNNING_EVENT = stoppingEvent(Service.State.RUNNING);
        TERMINATED_FROM_NEW_EVENT = terminatedEvent(Service.State.NEW);
        TERMINATED_FROM_STARTING_EVENT = terminatedEvent(Service.State.STARTING);
        TERMINATED_FROM_RUNNING_EVENT = terminatedEvent(Service.State.RUNNING);
        TERMINATED_FROM_STOPPING_EVENT = terminatedEvent(Service.State.STOPPING);
    }

    public AbstractService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.monitor = new Monitor();
        this.isStartable = new IsStartableGuard(this);
        this.isStoppable = new IsStoppableGuard(this);
        this.hasReachedRunning = new HasReachedRunningGuard(this);
        this.isStopped = new IsStoppedGuard(this);
        this.listeners = new ListenerCallQueue<>();
        this.snapshot = new StateSnapshot(Service.State.NEW);
    }

    private void checkCurrentState(Service.State state) {
        Service.State state2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, state) == null) || (state2 = state()) == state) {
            return;
        }
        if (state2 == Service.State.FAILED) {
            throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but the service has FAILED", failureCause());
        }
        throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but was " + state2);
    }

    private void dispatchListenerEvents() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.monitor.isOccupiedByCurrentThread()) {
            return;
        }
        this.listeners.dispatch();
    }

    private void enqueueFailedEvent(Service.State state, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, state, th) == null) {
            this.listeners.enqueue(new ListenerCallQueue.Event<Service.Listener>(this, state, th) { // from class: com.google.common.util.concurrent.AbstractService.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbstractService this$0;
                public final /* synthetic */ Throwable val$cause;
                public final /* synthetic */ Service.State val$from;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, state, th};
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
                    this.val$from = state;
                    this.val$cause = th;
                }

                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return "failed({from = " + this.val$from + ", cause = " + this.val$cause + "})";
                    }
                    return (String) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
                public void call(Service.Listener listener) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, listener) == null) {
                        listener.failed(this.val$from, this.val$cause);
                    }
                }
            });
        }
    }

    private void enqueueRunningEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.listeners.enqueue(RUNNING_EVENT);
        }
    }

    private void enqueueStartingEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.listeners.enqueue(STARTING_EVENT);
        }
    }

    private void enqueueStoppingEvent(Service.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, state) == null) {
            if (state == Service.State.STARTING) {
                this.listeners.enqueue(STOPPING_FROM_STARTING_EVENT);
            } else if (state == Service.State.RUNNING) {
                this.listeners.enqueue(STOPPING_FROM_RUNNING_EVENT);
            } else {
                throw new AssertionError();
            }
        }
    }

    private void enqueueTerminatedEvent(Service.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, state) == null) {
            switch (AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                case 1:
                    this.listeners.enqueue(TERMINATED_FROM_NEW_EVENT);
                    return;
                case 2:
                    this.listeners.enqueue(TERMINATED_FROM_STARTING_EVENT);
                    return;
                case 3:
                    this.listeners.enqueue(TERMINATED_FROM_RUNNING_EVENT);
                    return;
                case 4:
                    this.listeners.enqueue(TERMINATED_FROM_STOPPING_EVENT);
                    return;
                case 5:
                case 6:
                    throw new AssertionError();
                default:
                    return;
            }
        }
    }

    public static ListenerCallQueue.Event<Service.Listener> stoppingEvent(Service.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, state)) == null) ? new ListenerCallQueue.Event<Service.Listener>(state) { // from class: com.google.common.util.concurrent.AbstractService.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Service.State val$from;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {state};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$from = state;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return "stopping({from = " + this.val$from + "})";
                }
                return (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Service.Listener listener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, listener) == null) {
                    listener.stopping(this.val$from);
                }
            }
        } : (ListenerCallQueue.Event) invokeL.objValue;
    }

    public static ListenerCallQueue.Event<Service.Listener> terminatedEvent(Service.State state) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, state)) == null) ? new ListenerCallQueue.Event<Service.Listener>(state) { // from class: com.google.common.util.concurrent.AbstractService.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Service.State val$from;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {state};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$from = state;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return "terminated({from = " + this.val$from + "})";
                }
                return (String) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.util.concurrent.ListenerCallQueue.Event
            public void call(Service.Listener listener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, listener) == null) {
                    listener.terminated(this.val$from);
                }
            }
        } : (ListenerCallQueue.Event) invokeL.objValue;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, listener, executor) == null) {
            this.listeners.addListener(listener, executor);
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
            try {
                checkCurrentState(Service.State.RUNNING);
            } finally {
                this.monitor.leave();
            }
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.monitor.enterWhenUninterruptibly(this.isStopped);
            try {
                checkCurrentState(Service.State.TERMINATED);
            } finally {
                this.monitor.leave();
            }
        }
    }

    public void doCancelStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public abstract void doStart();

    public abstract void doStop();

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.snapshot.failureCause() : (Throwable) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? state() == Service.State.RUNNING : invokeV.booleanValue;
    }

    public final void notifyFailed(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, th) == null) {
            n.p(th);
            this.monitor.enter();
            try {
                Service.State state = state();
                int i2 = AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3 || i2 == 4) {
                        this.snapshot = new StateSnapshot(Service.State.FAILED, false, th);
                        enqueueFailedEvent(state, th);
                    } else if (i2 != 5) {
                    }
                    return;
                }
                throw new IllegalStateException("Failed while in state:" + state, th);
            } finally {
                this.monitor.leave();
                dispatchListenerEvents();
            }
        }
    }

    public final void notifyStarted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.monitor.enter();
            try {
                if (this.snapshot.state == Service.State.STARTING) {
                    if (this.snapshot.shutdownWhenStartupFinishes) {
                        this.snapshot = new StateSnapshot(Service.State.STOPPING);
                        doStop();
                    } else {
                        this.snapshot = new StateSnapshot(Service.State.RUNNING);
                        enqueueRunningEvent();
                    }
                    return;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.snapshot.state);
                notifyFailed(illegalStateException);
                throw illegalStateException;
            } finally {
                this.monitor.leave();
                dispatchListenerEvents();
            }
        }
    }

    public final void notifyStopped() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.monitor.enter();
            try {
                Service.State state = state();
                switch (AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                    case 1:
                    case 5:
                    case 6:
                        throw new IllegalStateException("Cannot notifyStopped() when the service is " + state);
                    case 2:
                    case 3:
                    case 4:
                        this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                        enqueueTerminatedEvent(state);
                        break;
                }
            } finally {
                this.monitor.leave();
                dispatchListenerEvents();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.monitor.enterIf(this.isStartable)) {
                try {
                    this.snapshot = new StateSnapshot(Service.State.STARTING);
                    enqueueStartingEvent();
                    doStart();
                } finally {
                    try {
                        return this;
                    } finally {
                    }
                }
                return this;
            }
            throw new IllegalStateException("Service " + this + " has already been started");
        }
        return (Service) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.snapshot.externalState() : (Service.State) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.monitor.enterIf(this.isStoppable)) {
                try {
                    Service.State state = state();
                    switch (AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                        case 1:
                            this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                            enqueueTerminatedEvent(Service.State.NEW);
                            break;
                        case 2:
                            this.snapshot = new StateSnapshot(Service.State.STARTING, true, null);
                            enqueueStoppingEvent(Service.State.STARTING);
                            doCancelStart();
                            break;
                        case 3:
                            this.snapshot = new StateSnapshot(Service.State.STOPPING);
                            enqueueStoppingEvent(Service.State.RUNNING);
                            doStop();
                            break;
                        case 4:
                        case 5:
                        case 6:
                            throw new AssertionError("isStoppable is incorrectly implemented, saw: " + state);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            return this;
        }
        return (Service) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return getClass().getSimpleName() + " [" + state() + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, timeUnit) == null) {
            if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, j, timeUnit)) {
                try {
                    checkCurrentState(Service.State.RUNNING);
                    return;
                } finally {
                    this.monitor.leave();
                }
            }
            throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048580, this, j, timeUnit) == null) {
            if (this.monitor.enterWhenUninterruptibly(this.isStopped, j, timeUnit)) {
                try {
                    checkCurrentState(Service.State.TERMINATED);
                    return;
                } finally {
                    this.monitor.leave();
                }
            }
            throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + state());
        }
    }
}
