package com.kwad.sdk.api.core.lifecycle;

import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
/* loaded from: classes5.dex */
public class KsLifecycle {
    private Lifecycle mBase;

    @Keep
    /* loaded from: classes5.dex */
    public enum KsLifeEvent {
        ON_CREATE(Lifecycle.Event.ON_CREATE),
        ON_START(Lifecycle.Event.ON_START),
        ON_RESUME(Lifecycle.Event.ON_RESUME),
        ON_PAUSE(Lifecycle.Event.ON_PAUSE),
        ON_STOP(Lifecycle.Event.ON_STOP),
        ON_DESTROY(Lifecycle.Event.ON_DESTROY),
        ON_ANY(Lifecycle.Event.ON_ANY);
        
        Lifecycle.Event mRealValue;

        KsLifeEvent(Lifecycle.Event event) {
            this.mRealValue = event;
        }

        public static KsLifeEvent createfrom(Lifecycle.Event event) {
            KsLifeEvent[] values;
            for (KsLifeEvent ksLifeEvent : values()) {
                if (ksLifeEvent.getReal() == event) {
                    return ksLifeEvent;
                }
            }
            return null;
        }

        @Keep
        public Lifecycle.Event getReal() {
            return this.mRealValue;
        }
    }

    /* loaded from: classes5.dex */
    public enum KsLifeState {
        DESTROYED(Lifecycle.State.DESTROYED),
        INITIALIZED(Lifecycle.State.DESTROYED),
        CREATED(Lifecycle.State.DESTROYED),
        STARTED(Lifecycle.State.DESTROYED),
        RESUMED(Lifecycle.State.DESTROYED);
        
        Lifecycle.State mReal;

        KsLifeState(Lifecycle.State state) {
            this.mReal = state;
        }

        public static KsLifeState createFrom(Lifecycle.State state) {
            KsLifeState[] values;
            for (KsLifeState ksLifeState : values()) {
                if (ksLifeState.mReal == state) {
                    return ksLifeState;
                }
            }
            return null;
        }

        public boolean isAtLeast(@NonNull KsLifeState ksLifeState) {
            return compareTo(ksLifeState) >= 0;
        }
    }

    public KsLifecycle(Lifecycle lifecycle) {
        this.mBase = lifecycle;
    }

    @MainThread
    public void addObserver(@NonNull final KsLifecycleObserver ksLifecycleObserver) {
        if (ksLifecycleObserver instanceof KsGenericLifecycleObserver) {
            GenericLifecycleObserver genericLifecycleObserver = new GenericLifecycleObserver() { // from class: com.kwad.sdk.api.core.lifecycle.KsLifecycle.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ((KsGenericLifecycleObserver) ksLifecycleObserver).onStateChanged(KsLifeEvent.createfrom(event));
                }
            };
            ksLifecycleObserver.setBase(genericLifecycleObserver);
            this.mBase.addObserver(genericLifecycleObserver);
        }
    }

    @MainThread
    public KsLifeState getCurrentState() {
        return KsLifeState.createFrom(this.mBase.getCurrentState());
    }

    @MainThread
    public void removeObserver(@NonNull KsLifecycleObserver ksLifecycleObserver) {
        this.mBase.removeObserver(ksLifecycleObserver.getBase());
    }
}
