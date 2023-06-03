package org.chromium.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
@JNINamespace("base::android")
/* loaded from: classes2.dex */
public class ApplicationStatus {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TOOLBAR_CALLBACK_WRAPPER_CLASS = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";
    @SuppressLint({"StaticFieldLeak"})
    public static Activity sActivity;
    public static ApplicationStateListener sNativeApplicationStateListener;
    public static final Map<Activity, ActivityInfo> sActivityInfo = Collections.synchronizedMap(new HashMap());
    @GuardedBy("sActivityInfo")
    @SuppressLint({"SupportAnnotationUsage"})
    public static int sCurrentApplicationState = 0;
    public static final ObserverList<ActivityStateListener> sGeneralActivityStateListeners = new ObserverList<>();
    public static final ObserverList<ApplicationStateListener> sApplicationStateListeners = new ObserverList<>();
    public static final ObserverList<WindowFocusChangedListener> sWindowFocusListeners = new ObserverList<>();

    /* loaded from: classes2.dex */
    public interface ActivityStateListener {
        void onActivityStateChange(Activity activity, int i);
    }

    /* loaded from: classes2.dex */
    public interface ApplicationStateListener {
        void onApplicationStateChange(int i);
    }

    /* loaded from: classes2.dex */
    public interface Natives {
        void onApplicationStateChange(int i);
    }

    /* loaded from: classes2.dex */
    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(Activity activity, boolean z);
    }

    /* loaded from: classes2.dex */
    public static class ActivityInfo {
        public ObserverList<ActivityStateListener> mListeners;
        public int mStatus;

        public ActivityInfo() {
            this.mStatus = 6;
            this.mListeners = new ObserverList<>();
        }

        public ObserverList<ActivityStateListener> getListeners() {
            return this.mListeners;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static class WindowCallbackProxy implements InvocationHandler {
        public final Activity mActivity;
        public final Window.Callback mCallback;

        public WindowCallbackProxy(Activity activity, Window.Callback callback) {
            this.mCallback = callback;
            this.mActivity = activity;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getName().equals("onWindowFocusChanged") && objArr.length == 1 && (objArr[0] instanceof Boolean)) {
                onWindowFocusChanged(((Boolean) objArr[0]).booleanValue());
                return null;
            }
            try {
                return method.invoke(this.mCallback, objArr);
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof AbstractMethodError) {
                    throw e.getCause();
                }
                throw e;
            }
        }

        public void onWindowFocusChanged(boolean z) {
            this.mCallback.onWindowFocusChanged(z);
            Iterator it = ApplicationStatus.sWindowFocusListeners.iterator();
            while (it.hasNext()) {
                ((WindowFocusChangedListener) it.next()).onWindowFocusChanged(this.mActivity, z);
            }
        }
    }

    @MainThread
    public static void destroyForJUnitTests() {
        synchronized (sActivityInfo) {
            sApplicationStateListeners.clear();
            sGeneralActivityStateListeners.clear();
            sActivityInfo.clear();
            sWindowFocusListeners.clear();
            sCurrentApplicationState = 0;
            sActivity = null;
            sNativeApplicationStateListener = null;
        }
    }

    @MainThread
    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
    }

    @AnyThread
    public static List<Activity> getRunningActivities() {
        ArrayList arrayList;
        synchronized (sActivityInfo) {
            arrayList = new ArrayList(sActivityInfo.keySet());
        }
        return arrayList;
    }

    @AnyThread
    @CalledByNative
    public static int getStateForApplication() {
        int i;
        synchronized (sActivityInfo) {
            i = sCurrentApplicationState;
        }
        return i;
    }

    @AnyThread
    @CalledByNative
    public static boolean hasVisibleActivities() {
        int stateForApplication = getStateForApplication();
        if (stateForApplication == 1 || stateForApplication == 2) {
            return true;
        }
        return false;
    }

    @AnyThread
    public static boolean isEveryActivityDestroyed() {
        return sActivityInfo.isEmpty();
    }

    public static boolean isInitialized() {
        boolean z;
        synchronized (sActivityInfo) {
            if (sCurrentApplicationState != 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @CalledByNative
    public static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: org.chromium.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.sNativeApplicationStateListener != null) {
                    return;
                }
                ApplicationStateListener unused = ApplicationStatus.sNativeApplicationStateListener = new ApplicationStateListener() { // from class: org.chromium.base.ApplicationStatus.3.1
                    @Override // org.chromium.base.ApplicationStatus.ApplicationStateListener
                    public void onApplicationStateChange(int i) {
                        ApplicationStatusJni.get().onApplicationStateChange(i);
                    }
                };
                ApplicationStatus.registerApplicationStateListener(ApplicationStatus.sNativeApplicationStateListener);
            }
        });
    }

    @AnyThread
    public static int getStateForActivity(@Nullable Activity activity) {
        ActivityInfo activityInfo;
        if (activity == null || (activityInfo = sActivityInfo.get(activity)) == null) {
            return 6;
        }
        return activityInfo.getStatus();
    }

    @MainThread
    public static void initialize(Application application) {
        synchronized (sActivityInfo) {
            sCurrentApplicationState = 4;
        }
        registerWindowFocusChangedListener(new WindowFocusChangedListener() { // from class: org.chromium.base.ApplicationStatus.1
            @Override // org.chromium.base.ApplicationStatus.WindowFocusChangedListener
            public void onWindowFocusChanged(Activity activity, boolean z) {
                int stateForActivity;
                if (z && activity != ApplicationStatus.sActivity && (stateForActivity = ApplicationStatus.getStateForActivity(activity)) != 6 && stateForActivity != 5) {
                    Activity unused = ApplicationStatus.sActivity = activity;
                }
            }
        });
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: org.chromium.base.ApplicationStatus.2
            public static final /* synthetic */ boolean $assertionsDisabled = false;

            private void checkCallback(Activity activity) {
                boolean z = BuildConfig.DCHECK_IS_ON;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ApplicationStatus.onStateChange(activity, 6);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ApplicationStatus.onStateChange(activity, 4);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ApplicationStatus.onStateChange(activity, 3);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ApplicationStatus.onStateChange(activity, 2);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ApplicationStatus.onStateChange(activity, 5);
                checkCallback(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ApplicationStatus.onStateChange(activity, 1);
                activity.getWindow().setCallback(ApplicationStatus.createWindowCallbackProxy(activity, activity.getWindow().getCallback()));
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                checkCallback(activity);
            }
        });
    }

    @MainThread
    public static void registerApplicationStateListener(ApplicationStateListener applicationStateListener) {
        sApplicationStateListeners.addObserver(applicationStateListener);
    }

    @MainThread
    public static void registerStateListenerForAllActivities(ActivityStateListener activityStateListener) {
        sGeneralActivityStateListeners.addObserver(activityStateListener);
    }

    @MainThread
    public static void registerWindowFocusChangedListener(WindowFocusChangedListener windowFocusChangedListener) {
        sWindowFocusListeners.addObserver(windowFocusChangedListener);
    }

    @MainThread
    public static void unregisterActivityStateListener(ActivityStateListener activityStateListener) {
        sGeneralActivityStateListeners.removeObserver(activityStateListener);
        synchronized (sActivityInfo) {
            for (ActivityInfo activityInfo : sActivityInfo.values()) {
                activityInfo.getListeners().removeObserver(activityStateListener);
            }
        }
    }

    @MainThread
    public static void unregisterApplicationStateListener(ApplicationStateListener applicationStateListener) {
        sApplicationStateListeners.removeObserver(applicationStateListener);
    }

    @MainThread
    public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener windowFocusChangedListener) {
        sWindowFocusListeners.removeObserver(windowFocusChangedListener);
    }

    @VisibleForTesting
    public static Window.Callback createWindowCallbackProxy(Activity activity, Window.Callback callback) {
        return (Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new WindowCallbackProxy(activity, callback));
    }

    @MainThread
    @VisibleForTesting
    public static void onStateChangeForTesting(Activity activity, int i) {
        onStateChange(activity, i);
    }

    @SuppressLint({"NewApi"})
    @MainThread
    public static void registerStateListenerForActivity(ActivityStateListener activityStateListener, Activity activity) {
        sActivityInfo.get(activity).getListeners().addObserver(activityStateListener);
    }

    @GuardedBy("sActivityInfo")
    public static int determineApplicationStateLocked() {
        boolean z = false;
        boolean z2 = false;
        for (ActivityInfo activityInfo : sActivityInfo.values()) {
            int status = activityInfo.getStatus();
            if (status != 4 && status != 5 && status != 6) {
                return 1;
            }
            if (status == 4) {
                z = true;
            } else if (status == 5) {
                z2 = true;
            }
        }
        if (z) {
            return 2;
        }
        if (!z2) {
            return 4;
        }
        return 3;
    }

    public static void onStateChange(Activity activity, int i) {
        ActivityInfo activityInfo;
        if (activity != null) {
            if (sActivity == null || i == 1 || i == 3 || i == 2) {
                sActivity = activity;
            }
            int stateForApplication = getStateForApplication();
            synchronized (sActivityInfo) {
                if (i == 1) {
                    sActivityInfo.put(activity, new ActivityInfo());
                }
                activityInfo = sActivityInfo.get(activity);
                activityInfo.setStatus(i);
                if (i == 6) {
                    sActivityInfo.remove(activity);
                    if (activity == sActivity) {
                        sActivity = null;
                    }
                }
                sCurrentApplicationState = determineApplicationStateLocked();
            }
            Iterator<ActivityStateListener> it = activityInfo.getListeners().iterator();
            while (it.hasNext()) {
                it.next().onActivityStateChange(activity, i);
            }
            Iterator<ActivityStateListener> it2 = sGeneralActivityStateListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onActivityStateChange(activity, i);
            }
            int stateForApplication2 = getStateForApplication();
            if (stateForApplication2 != stateForApplication) {
                Iterator<ApplicationStateListener> it3 = sApplicationStateListeners.iterator();
                while (it3.hasNext()) {
                    it3.next().onApplicationStateChange(stateForApplication2);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("null activity is not supported");
    }

    @VisibleForTesting
    public static boolean reachesWindowCallback(@Nullable Window.Callback callback) {
        Field[] declaredFields;
        if (callback == null) {
            return false;
        }
        if (callback.getClass().getName().equals(TOOLBAR_CALLBACK_WRAPPER_CLASS)) {
            return true;
        }
        if (Proxy.isProxyClass(callback.getClass())) {
            return Proxy.getInvocationHandler(callback) instanceof WindowCallbackProxy;
        }
        for (Class<?> cls = callback.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType().isAssignableFrom(Window.Callback.class)) {
                    boolean isAccessible = field.isAccessible();
                    field.setAccessible(true);
                    try {
                        Window.Callback callback2 = (Window.Callback) field.get(callback);
                        field.setAccessible(isAccessible);
                        if (reachesWindowCallback(callback2)) {
                            return true;
                        }
                    } catch (IllegalAccessException unused) {
                        field.setAccessible(isAccessible);
                    } catch (Throwable th) {
                        field.setAccessible(isAccessible);
                        throw th;
                    }
                }
            }
        }
        return false;
    }
}
