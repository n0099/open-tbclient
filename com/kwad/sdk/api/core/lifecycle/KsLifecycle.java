package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class KsLifecycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Lifecycle mBase;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Keep
    /* loaded from: classes10.dex */
    public static final class KsLifeEvent {
        public static final /* synthetic */ KsLifeEvent[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final KsLifeEvent ON_ANY;
        public static final KsLifeEvent ON_CREATE;
        public static final KsLifeEvent ON_DESTROY;
        public static final KsLifeEvent ON_PAUSE;
        public static final KsLifeEvent ON_RESUME;
        public static final KsLifeEvent ON_START;
        public static final KsLifeEvent ON_STOP;
        public transient /* synthetic */ FieldHolder $fh;
        public Lifecycle.Event mRealValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-658019316, "Lcom/kwad/sdk/api/core/lifecycle/KsLifecycle$KsLifeEvent;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-658019316, "Lcom/kwad/sdk/api/core/lifecycle/KsLifecycle$KsLifeEvent;");
                    return;
                }
            }
            ON_CREATE = new KsLifeEvent("ON_CREATE", 0, Lifecycle.Event.ON_CREATE);
            ON_START = new KsLifeEvent("ON_START", 1, Lifecycle.Event.ON_START);
            ON_RESUME = new KsLifeEvent("ON_RESUME", 2, Lifecycle.Event.ON_RESUME);
            ON_PAUSE = new KsLifeEvent("ON_PAUSE", 3, Lifecycle.Event.ON_PAUSE);
            ON_STOP = new KsLifeEvent("ON_STOP", 4, Lifecycle.Event.ON_STOP);
            ON_DESTROY = new KsLifeEvent("ON_DESTROY", 5, Lifecycle.Event.ON_DESTROY);
            KsLifeEvent ksLifeEvent = new KsLifeEvent("ON_ANY", 6, Lifecycle.Event.ON_ANY);
            ON_ANY = ksLifeEvent;
            $VALUES = new KsLifeEvent[]{ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ksLifeEvent};
        }

        public KsLifeEvent(String str, int i2, Lifecycle.Event event) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), event};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mRealValue = event;
        }

        public static KsLifeEvent createfrom(Lifecycle.Event event) {
            InterceptResult invokeL;
            KsLifeEvent[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, event)) == null) {
                for (KsLifeEvent ksLifeEvent : values()) {
                    if (ksLifeEvent.getReal() == event) {
                        return ksLifeEvent;
                    }
                }
                return null;
            }
            return (KsLifeEvent) invokeL.objValue;
        }

        public static KsLifeEvent valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (KsLifeEvent) Enum.valueOf(KsLifeEvent.class, str) : (KsLifeEvent) invokeL.objValue;
        }

        public static KsLifeEvent[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (KsLifeEvent[]) $VALUES.clone() : (KsLifeEvent[]) invokeV.objValue;
        }

        @Keep
        public Lifecycle.Event getReal() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRealValue : (Lifecycle.Event) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class KsLifeState {
        public static final /* synthetic */ KsLifeState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final KsLifeState CREATED;
        public static final KsLifeState DESTROYED;
        public static final KsLifeState INITIALIZED;
        public static final KsLifeState RESUMED;
        public static final KsLifeState STARTED;
        public transient /* synthetic */ FieldHolder $fh;
        public Lifecycle.State mReal;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-259172107, "Lcom/kwad/sdk/api/core/lifecycle/KsLifecycle$KsLifeState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-259172107, "Lcom/kwad/sdk/api/core/lifecycle/KsLifecycle$KsLifeState;");
                    return;
                }
            }
            DESTROYED = new KsLifeState("DESTROYED", 0, Lifecycle.State.DESTROYED);
            INITIALIZED = new KsLifeState("INITIALIZED", 1, Lifecycle.State.DESTROYED);
            CREATED = new KsLifeState("CREATED", 2, Lifecycle.State.DESTROYED);
            STARTED = new KsLifeState("STARTED", 3, Lifecycle.State.DESTROYED);
            KsLifeState ksLifeState = new KsLifeState("RESUMED", 4, Lifecycle.State.DESTROYED);
            RESUMED = ksLifeState;
            $VALUES = new KsLifeState[]{DESTROYED, INITIALIZED, CREATED, STARTED, ksLifeState};
        }

        public KsLifeState(String str, int i2, Lifecycle.State state) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), state};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mReal = state;
        }

        public static KsLifeState createFrom(Lifecycle.State state) {
            InterceptResult invokeL;
            KsLifeState[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, state)) == null) {
                for (KsLifeState ksLifeState : values()) {
                    if (ksLifeState.mReal == state) {
                        return ksLifeState;
                    }
                }
                return null;
            }
            return (KsLifeState) invokeL.objValue;
        }

        public static KsLifeState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (KsLifeState) Enum.valueOf(KsLifeState.class, str) : (KsLifeState) invokeL.objValue;
        }

        public static KsLifeState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (KsLifeState[]) $VALUES.clone() : (KsLifeState[]) invokeV.objValue;
        }

        public boolean isAtLeast(@NonNull KsLifeState ksLifeState) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ksLifeState)) == null) ? compareTo(ksLifeState) >= 0 : invokeL.booleanValue;
        }
    }

    public KsLifecycle(Lifecycle lifecycle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lifecycle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBase = lifecycle;
    }

    @MainThread
    public void addObserver(@NonNull KsLifecycleObserver ksLifecycleObserver) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ksLifecycleObserver) == null) && (ksLifecycleObserver instanceof KsGenericLifecycleObserver)) {
            GenericLifecycleObserver genericLifecycleObserver = new GenericLifecycleObserver(this, ksLifecycleObserver) { // from class: com.kwad.sdk.api.core.lifecycle.KsLifecycle.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KsLifecycle this$0;
                public final /* synthetic */ KsLifecycleObserver val$observer;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ksLifecycleObserver};
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
                    this.val$observer = ksLifecycleObserver;
                }

                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) {
                        ((KsGenericLifecycleObserver) this.val$observer).onStateChanged(KsLifeEvent.createfrom(event));
                    }
                }
            };
            ksLifecycleObserver.setBase(genericLifecycleObserver);
            this.mBase.addObserver(genericLifecycleObserver);
        }
    }

    @MainThread
    public KsLifeState getCurrentState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? KsLifeState.createFrom(this.mBase.getCurrentState()) : (KsLifeState) invokeV.objValue;
    }

    @MainThread
    public void removeObserver(@NonNull KsLifecycleObserver ksLifecycleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksLifecycleObserver) == null) {
            this.mBase.removeObserver(ksLifecycleObserver.getBase());
        }
    }
}
