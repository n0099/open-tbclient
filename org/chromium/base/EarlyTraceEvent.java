package org.chromium.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
@JNINamespace("base::android")
@MainDex
/* loaded from: classes2.dex */
public class EarlyTraceEvent {
    public static final String BACKGROUND_STARTUP_TRACING_ENABLED_KEY = "bg_startup_tracing";
    @VisibleForTesting
    public static final int STATE_DISABLED = 0;
    @VisibleForTesting
    public static final int STATE_ENABLED = 1;
    @VisibleForTesting
    public static final int STATE_FINISHED = 2;
    public static final String TRACE_CONFIG_FILENAME = "/data/local/chrome-trace-config.json";
    @GuardedBy("sLock")
    @VisibleForTesting
    public static List<AsyncEvent> sAsyncEvents;
    public static boolean sCachedBackgroundStartupTracingFlag;
    @GuardedBy("sLock")
    @VisibleForTesting
    public static List<Event> sEvents;
    public static final Object sLock = new Object();
    @VisibleForTesting
    public static volatile int sState;

    /* loaded from: classes2.dex */
    public interface Natives {
        void recordEarlyAsyncBeginEvent(String str, long j, long j2);

        void recordEarlyAsyncEndEvent(String str, long j, long j2);

        void recordEarlyBeginEvent(String str, long j, int i, long j2);

        void recordEarlyEndEvent(String str, long j, int i, long j2);

        void recordEarlyToplevelBeginEvent(String str, long j, int i, long j2);

        void recordEarlyToplevelEndEvent(String str, long j, int i, long j2);
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class AsyncEvent {
        public final long mId;
        public final boolean mIsStart;
        public final String mName;
        public final long mTimestampNanos = Event.elapsedRealtimeNanos();

        public AsyncEvent(String str, long j, boolean z) {
            this.mName = str;
            this.mId = j;
            this.mIsStart = z;
        }
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    public static final class Event {
        public final boolean mIsStart;
        public final boolean mIsToplevel;
        public final String mName;
        public final int mThreadId = Process.myTid();
        public final long mTimeNanos = elapsedRealtimeNanos();
        public final long mThreadTimeMillis = SystemClock.currentThreadTimeMillis();

        public Event(String str, boolean z, boolean z2) {
            this.mIsStart = z;
            this.mIsToplevel = z2;
            this.mName = str;
        }

        @SuppressLint({"NewApi"})
        @VisibleForTesting
        public static long elapsedRealtimeNanos() {
            if (Build.VERSION.SDK_INT >= 17) {
                return SystemClock.elapsedRealtimeNanos();
            }
            return SystemClock.elapsedRealtime() * 1000000;
        }
    }

    public static void enable() {
        synchronized (sLock) {
            if (sState != 0) {
                return;
            }
            sEvents = new ArrayList();
            sAsyncEvents = new ArrayList();
            sState = 1;
        }
    }

    public static boolean enabled() {
        if (sState == 1) {
            return true;
        }
        return false;
    }

    @CalledByNative
    public static boolean getBackgroundStartupTracingFlag() {
        return sCachedBackgroundStartupTracingFlag;
    }

    public static long getOffsetNanos() {
        return (TimeUtilsJni.get().getTimeTicksNowUs() * 1000) - Event.elapsedRealtimeNanos();
    }

    @VisibleForTesting
    public static void resetForTesting() {
        synchronized (sLock) {
            sState = 0;
            sEvents = null;
            sAsyncEvents = null;
        }
    }

    public static void begin(String str, boolean z) {
        if (!enabled()) {
            return;
        }
        Event event = new Event(str, true, z);
        synchronized (sLock) {
            if (!enabled()) {
                return;
            }
            sEvents.add(event);
        }
    }

    public static void end(String str, boolean z) {
        if (!enabled()) {
            return;
        }
        Event event = new Event(str, false, z);
        synchronized (sLock) {
            if (!enabled()) {
                return;
            }
            sEvents.add(event);
        }
    }

    public static void finishAsync(String str, long j) {
        if (!enabled()) {
            return;
        }
        AsyncEvent asyncEvent = new AsyncEvent(str, j, false);
        synchronized (sLock) {
            if (!enabled()) {
                return;
            }
            sAsyncEvents.add(asyncEvent);
        }
    }

    public static void startAsync(String str, long j) {
        if (!enabled()) {
            return;
        }
        AsyncEvent asyncEvent = new AsyncEvent(str, j, true);
        synchronized (sLock) {
            if (!enabled()) {
                return;
            }
            sAsyncEvents.add(asyncEvent);
        }
    }

    public static void disable() {
        synchronized (sLock) {
            if (!enabled()) {
                return;
            }
            if (!sEvents.isEmpty()) {
                dumpEvents(sEvents);
                sEvents.clear();
            }
            if (!sAsyncEvents.isEmpty()) {
                dumpAsyncEvents(sAsyncEvents);
                sAsyncEvents.clear();
            }
            sState = 2;
            sEvents = null;
            sAsyncEvents = null;
        }
    }

    public static void dumpAsyncEvents(List<AsyncEvent> list) {
        long offsetNanos = getOffsetNanos();
        for (AsyncEvent asyncEvent : list) {
            if (asyncEvent.mIsStart) {
                EarlyTraceEventJni.get().recordEarlyAsyncBeginEvent(asyncEvent.mName, asyncEvent.mId, asyncEvent.mTimestampNanos + offsetNanos);
            } else {
                EarlyTraceEventJni.get().recordEarlyAsyncEndEvent(asyncEvent.mName, asyncEvent.mId, asyncEvent.mTimestampNanos + offsetNanos);
            }
        }
    }

    public static void dumpEvents(List<Event> list) {
        long offsetNanos = getOffsetNanos();
        for (Event event : list) {
            if (event.mIsStart) {
                if (event.mIsToplevel) {
                    EarlyTraceEventJni.get().recordEarlyToplevelBeginEvent(event.mName, event.mTimeNanos + offsetNanos, event.mThreadId, event.mThreadTimeMillis);
                } else {
                    EarlyTraceEventJni.get().recordEarlyBeginEvent(event.mName, event.mTimeNanos + offsetNanos, event.mThreadId, event.mThreadTimeMillis);
                }
            } else if (event.mIsToplevel) {
                EarlyTraceEventJni.get().recordEarlyToplevelEndEvent(event.mName, event.mTimeNanos + offsetNanos, event.mThreadId, event.mThreadTimeMillis);
            } else {
                EarlyTraceEventJni.get().recordEarlyEndEvent(event.mName, event.mTimeNanos + offsetNanos, event.mThreadId, event.mThreadTimeMillis);
            }
        }
    }

    @VisibleForTesting
    public static String makeEventKeyForCurrentThread(String str) {
        return str + "@" + Process.myTid();
    }

    @CalledByNative
    public static void setBackgroundStartupTracingFlag(boolean z) {
        ContextUtils.getAppSharedPreferences().edit().putBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, z).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void maybeEnable() {
        boolean z;
        ThreadUtils.assertOnUiThread();
        if (sState != 0) {
            return;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            boolean z2 = true;
            if (CommandLine.getInstance().hasSwitch("trace-startup")) {
                z = true;
            } else {
                try {
                    z = new File(TRACE_CONFIG_FILENAME).exists();
                } catch (SecurityException unused) {
                    z = false;
                }
            }
            if (ContextUtils.getAppSharedPreferences().getBoolean(BACKGROUND_STARTUP_TRACING_ENABLED_KEY, false)) {
                if (z) {
                    setBackgroundStartupTracingFlag(false);
                    sCachedBackgroundStartupTracingFlag = false;
                } else {
                    sCachedBackgroundStartupTracingFlag = true;
                    if (!z2) {
                        enable();
                        return;
                    }
                    return;
                }
            }
            z2 = z;
            if (!z2) {
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
