package com.thunder.livesdk.system;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class LifecycleEventDispatcher {
    private static final HashSet<WeakReference<ILifecycleCallbacks>> observers = new HashSet<>();
    private static AtomicInteger foregroundCounter = new AtomicInteger(0);
    private static int counter = 0;

    public static void registerCallback(ILifecycleCallbacks iLifecycleCallbacks) {
        synchronized (observers) {
            observers.add(new WeakReference<>(iLifecycleCallbacks));
            if (foregroundCounter.get() > 0) {
                iLifecycleCallbacks.onForeground();
            }
        }
    }

    public static void removeCallback(ILifecycleCallbacks iLifecycleCallbacks) {
        synchronized (observers) {
            WeakReference<ILifecycleCallbacks> weakReference = null;
            Iterator<WeakReference<ILifecycleCallbacks>> it = observers.iterator();
            while (it.hasNext()) {
                WeakReference<ILifecycleCallbacks> next = it.next();
                if (iLifecycleCallbacks != next.get()) {
                    next = weakReference;
                }
                weakReference = next;
            }
            if (weakReference != null) {
                observers.remove(weakReference);
            }
        }
    }

    public static void dispatchEvent(boolean z) {
        int i = counter;
        counter = (z ? 1 : -1) + counter;
        LcLogger.d("count:" + counter);
        synchronized (observers) {
            if (counter == 1 && i == 0) {
                LcLogger.d("onForeground");
                if (observers.isEmpty()) {
                    foregroundCounter.incrementAndGet();
                }
                Iterator<WeakReference<ILifecycleCallbacks>> it = observers.iterator();
                while (it.hasNext()) {
                    WeakReference<ILifecycleCallbacks> next = it.next();
                    if (next.get() != null) {
                        next.get().onForeground();
                    } else {
                        LcLogger.d("onForeground null ref");
                    }
                }
            } else if (counter == 0 && i == 1) {
                LcLogger.d("onBackground");
                if (observers.isEmpty()) {
                    foregroundCounter.decrementAndGet();
                }
                Iterator<WeakReference<ILifecycleCallbacks>> it2 = observers.iterator();
                while (it2.hasNext()) {
                    WeakReference<ILifecycleCallbacks> next2 = it2.next();
                    if (next2.get() != null) {
                        next2.get().onBackground();
                    } else {
                        LcLogger.d("onBackground null ref");
                    }
                }
            }
        }
    }
}
