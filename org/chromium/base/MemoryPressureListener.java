package org.chromium.base;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.chromium.base.MemoryPressureListenerJni;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.MainDex;
import org.chromium.base.memory.MemoryPressureCallback;
@MainDex
/* loaded from: classes2.dex */
public class MemoryPressureListener {
    public static final String ACTION_LOW_MEMORY = "org.chromium.base.ACTION_LOW_MEMORY";
    public static final String ACTION_TRIM_MEMORY = "org.chromium.base.ACTION_TRIM_MEMORY";
    public static final String ACTION_TRIM_MEMORY_MODERATE = "org.chromium.base.ACTION_TRIM_MEMORY_MODERATE";
    public static final String ACTION_TRIM_MEMORY_RUNNING_CRITICAL = "org.chromium.base.ACTION_TRIM_MEMORY_RUNNING_CRITICAL";
    public static final ObserverList<MemoryPressureCallback> sCallbacks = new ObserverList<>();

    /* loaded from: classes2.dex */
    public interface Natives {
        void onMemoryPressure(int i);
    }

    @CalledByNative
    public static void addNativeCallback() {
        addCallback(new MemoryPressureCallback() { // from class: com.baidu.tieba.uqb
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // org.chromium.base.memory.MemoryPressureCallback
            public final void onPressure(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                    MemoryPressureListenerJni.get().onMemoryPressure(i);
                }
            }
        });
    }

    public static void addCallback(MemoryPressureCallback memoryPressureCallback) {
        sCallbacks.addObserver(memoryPressureCallback);
    }

    public static void notifyMemoryPressure(int i) {
        Iterator<MemoryPressureCallback> it = sCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onPressure(i);
        }
    }

    public static void removeCallback(MemoryPressureCallback memoryPressureCallback) {
        sCallbacks.removeObserver(memoryPressureCallback);
    }

    public static void simulateLowMemoryPressureSignal(Activity activity) {
        activity.getApplication().onLowMemory();
        activity.onLowMemory();
    }

    public static boolean handleDebugIntent(Activity activity, String str) {
        if (ACTION_LOW_MEMORY.equals(str)) {
            simulateLowMemoryPressureSignal(activity);
            return true;
        } else if (ACTION_TRIM_MEMORY.equals(str)) {
            simulateTrimMemoryPressureSignal(activity, 80);
            return true;
        } else if (ACTION_TRIM_MEMORY_RUNNING_CRITICAL.equals(str)) {
            simulateTrimMemoryPressureSignal(activity, 15);
            return true;
        } else if (ACTION_TRIM_MEMORY_MODERATE.equals(str)) {
            simulateTrimMemoryPressureSignal(activity, 60);
            return true;
        } else {
            return false;
        }
    }

    public static void simulateTrimMemoryPressureSignal(Activity activity, int i) {
        activity.getApplication().onTrimMemory(i);
        activity.onTrimMemory(i);
    }
}
