package org.chromium.base;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.TraceEvent;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.MainDex;
@JNINamespace("base::android")
@MainDex
/* loaded from: classes2.dex */
public class TraceEvent implements AutoCloseable {
    public static final long ATRACE_TAG_APP = 4096;
    public static final long ATRACE_TAG_WEBVIEW = 16;
    public static ATrace sATrace;
    public static volatile boolean sEnabled;
    public final String mName;

    /* loaded from: classes2.dex */
    public interface Natives {
        void begin(String str, String str2);

        void beginToplevel(String str);

        void end(String str, String str2);

        void endToplevel(String str);

        void finishAsync(String str, long j);

        void instant(String str, String str2);

        void registerEnabledObserver();

        void setupATraceStartupTrace(String str);

        void startATrace(String str);

        void startAsync(String str, long j);

        void stopATrace();
    }

    /* loaded from: classes2.dex */
    public static class ATrace implements MessageQueue.IdleHandler {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final String TAG = "ATrace";
        public Method mAsyncTraceBeginMethod;
        public Method mAsyncTraceEndMethod;
        public Method mGetSystemPropertyMethod;
        public Method mIsTraceTagEnabledMethod;
        public boolean mShouldWriteToSystemTrace;
        public Class<?> mSystemPropertiesClass;
        public Method mTraceBeginMethod;
        public Class<?> mTraceClass;
        public Method mTraceEndMethod;
        public final long mTraceTag;
        public final AtomicBoolean mNativeTracingReady = new AtomicBoolean();
        public final AtomicBoolean mUiThreadReady = new AtomicBoolean();
        public final AtomicBoolean mTraceTagActive = new AtomicBoolean();

        /* loaded from: classes2.dex */
        public static class CategoryConfig {
            public String filter;
            public boolean shouldWriteToATrace;

            public CategoryConfig() {
                this.filter = "";
                this.shouldWriteToATrace = true;
            }
        }

        private void disableNativeATrace() {
            TraceEventJni.get().stopATrace();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: startPolling */
        public void b() {
            ThreadUtils.assertOnUiThread();
            Looper.myQueue().addIdleHandler(this);
            a();
        }

        public boolean hasActiveSession() {
            return this.mTraceTagActive.get();
        }

        @AnyThread
        public void onNativeTracingReady() {
            this.mNativeTracingReady.set(true);
            this.mTraceTagActive.set(false);
            if (this.mUiThreadReady.get()) {
                ThreadUtils.postOnUiThread(new Runnable() { // from class: com.baidu.tieba.r5c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            TraceEvent.ATrace.this.a();
                        }
                    }
                });
            }
        }

        @AnyThread
        public void onUiThreadReady() {
            this.mUiThreadReady.set(true);
            if (!ThreadUtils.runningOnUiThread()) {
                ThreadUtils.postOnUiThread(new Runnable() { // from class: com.baidu.tieba.q5c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            TraceEvent.ATrace.this.b();
                        }
                    }
                });
            } else {
                b();
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            a();
            return true;
        }

        public void traceEnd() {
            if (!this.mShouldWriteToSystemTrace) {
                return;
            }
            try {
                this.mTraceEndMethod.invoke(this.mTraceClass, Long.valueOf(this.mTraceTag));
            } catch (Exception unused) {
            }
        }

        public ATrace(long j) {
            try {
                Class<?> cls = Class.forName("android.os.Trace");
                this.mTraceClass = cls;
                this.mIsTraceTagEnabledMethod = cls.getMethod("isTagEnabled", Long.TYPE);
                this.mTraceBeginMethod = this.mTraceClass.getMethod("traceBegin", Long.TYPE, String.class);
                this.mTraceEndMethod = this.mTraceClass.getMethod("traceEnd", Long.TYPE);
                this.mAsyncTraceBeginMethod = this.mTraceClass.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                this.mAsyncTraceEndMethod = this.mTraceClass.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                Class<?> cls2 = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                this.mSystemPropertiesClass = cls2;
                this.mGetSystemPropertyMethod = cls2.getMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class);
            } catch (Exception e) {
                Log.w(TAG, "Reflection error", e);
                this.mIsTraceTagEnabledMethod = null;
            }
            this.mTraceTag = j;
            a();
        }

        private void enableNativeATrace(String str) {
            TraceEventJni.get().startATrace(str);
        }

        private Integer getIntegerSystemProperty(String str) {
            String systemProperty = getSystemProperty(str);
            if (systemProperty == null) {
                return null;
            }
            try {
                return Integer.decode(systemProperty);
            } catch (NumberFormatException unused) {
                return null;
            }
        }

        @Nullable
        private String getSystemProperty(String str) {
            try {
                return (String) this.mGetSystemPropertyMethod.invoke(this.mSystemPropertiesClass, str);
            } catch (Exception unused) {
                return null;
            }
        }

        private boolean isTraceTagEnabled(long j) {
            try {
                return ((Boolean) this.mIsTraceTagEnabledMethod.invoke(this.mTraceClass, Long.valueOf(j))).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private void setupATraceStartupTrace(String str) {
            TraceEventJni.get().setupATraceStartupTrace(str);
        }

        public void traceBegin(String str) {
            if (!this.mShouldWriteToSystemTrace) {
                return;
            }
            try {
                this.mTraceBeginMethod.invoke(this.mTraceClass, Long.valueOf(this.mTraceTag), str);
            } catch (Exception unused) {
            }
        }

        private CategoryConfig getCategoryConfigFromATrace() {
            String[] split;
            CategoryConfig categoryConfig = new CategoryConfig();
            Integer integerSystemProperty = getIntegerSystemProperty("debug.atrace.app_number");
            if (integerSystemProperty != null && integerSystemProperty.intValue() > 0 && ContextUtils.getApplicationContext() != null) {
                String packageName = ContextUtils.getApplicationContext().getPackageName();
                for (int i = 0; i < integerSystemProperty.intValue(); i++) {
                    String systemProperty = getSystemProperty("debug.atrace.app_" + i);
                    if (systemProperty != null && systemProperty.startsWith(packageName)) {
                        String substring = systemProperty.substring(packageName.length());
                        if (substring.startsWith("/")) {
                            for (String str : substring.substring(1).split(":")) {
                                if (str.equals("-atrace")) {
                                    categoryConfig.shouldWriteToATrace = false;
                                } else {
                                    if (categoryConfig.filter.length() > 0) {
                                        categoryConfig.filter += ",";
                                    }
                                    categoryConfig.filter += str;
                                }
                            }
                        }
                    }
                }
            }
            return categoryConfig;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @UiThread
        /* renamed from: pollConfig */
        public boolean a() {
            boolean z = this.mTraceTagActive.get();
            boolean isTraceTagEnabled = isTraceTagEnabled(this.mTraceTag);
            if (z == isTraceTagEnabled) {
                return false;
            }
            this.mTraceTagActive.set(isTraceTagEnabled);
            if (!isTraceTagEnabled) {
                EarlyTraceEvent.disable();
                disableNativeATrace();
                this.mShouldWriteToSystemTrace = false;
                ThreadUtils.getUiThreadLooper().setMessageLogging(null);
                return true;
            }
            CategoryConfig categoryConfigFromATrace = getCategoryConfigFromATrace();
            this.mShouldWriteToSystemTrace = false;
            if (this.mNativeTracingReady.get()) {
                if (categoryConfigFromATrace.shouldWriteToATrace) {
                    enableNativeATrace(categoryConfigFromATrace.filter);
                } else {
                    setupATraceStartupTrace(categoryConfigFromATrace.filter);
                }
            } else if (categoryConfigFromATrace.shouldWriteToATrace) {
                this.mShouldWriteToSystemTrace = true;
            } else {
                EarlyTraceEvent.enable();
            }
            if (!categoryConfigFromATrace.shouldWriteToATrace) {
                ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.sInstance);
            }
            return true;
        }

        public void asyncTraceBegin(String str, int i) {
            if (!this.mShouldWriteToSystemTrace) {
                return;
            }
            try {
                this.mAsyncTraceBeginMethod.invoke(this.mTraceClass, Long.valueOf(this.mTraceTag), str, Integer.valueOf(i));
            } catch (Exception unused) {
            }
        }

        public void asyncTraceEnd(String str, int i) {
            if (!this.mShouldWriteToSystemTrace) {
                return;
            }
            try {
                this.mAsyncTraceEndMethod.invoke(this.mTraceClass, Long.valueOf(this.mTraceTag), str, Integer.valueOf(i));
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class BasicLooperMonitor implements Printer {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final String LOOPER_TASK_PREFIX = "Looper.dispatch: ";
        public static final int SHORTEST_LOG_PREFIX_LENGTH = 18;
        public String mCurrentTarget;

        public BasicLooperMonitor() {
        }

        public static String getTarget(String str) {
            int indexOf;
            int indexOf2 = str.indexOf(40, SHORTEST_LOG_PREFIX_LENGTH);
            if (indexOf2 == -1) {
                indexOf = -1;
            } else {
                indexOf = str.indexOf(41, indexOf2);
            }
            if (indexOf != -1) {
                return str.substring(indexOf2 + 1, indexOf);
            }
            return "";
        }

        public static String getTargetName(String str) {
            int indexOf;
            int indexOf2 = str.indexOf(125, SHORTEST_LOG_PREFIX_LENGTH);
            if (indexOf2 == -1) {
                indexOf = -1;
            } else {
                indexOf = str.indexOf(58, indexOf2);
            }
            if (indexOf == -1) {
                indexOf = str.length();
            }
            if (indexOf2 != -1) {
                return str.substring(indexOf2 + 2, indexOf);
            }
            return "";
        }

        public static String getTraceEventName(String str) {
            return LOOPER_TASK_PREFIX + getTarget(str) + "(" + getTargetName(str) + SmallTailInfo.EMOTION_SUFFIX;
        }

        public void beginHandling(String str) {
            boolean enabled = EarlyTraceEvent.enabled();
            if (TraceEvent.sEnabled || enabled) {
                this.mCurrentTarget = getTraceEventName(str);
                if (TraceEvent.sEnabled) {
                    TraceEventJni.get().beginToplevel(this.mCurrentTarget);
                } else {
                    EarlyTraceEvent.begin(this.mCurrentTarget, true);
                }
            }
        }

        public void endHandling(String str) {
            boolean enabled = EarlyTraceEvent.enabled();
            if ((TraceEvent.sEnabled || enabled) && this.mCurrentTarget != null) {
                if (TraceEvent.sEnabled) {
                    TraceEventJni.get().endToplevel(this.mCurrentTarget);
                } else {
                    EarlyTraceEvent.end(this.mCurrentTarget, true);
                }
            }
            this.mCurrentTarget = null;
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str.startsWith(">")) {
                beginHandling(str);
            } else {
                endHandling(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class IdleTracingLooperMonitor extends BasicLooperMonitor implements MessageQueue.IdleHandler {
        public static final long FRAME_DURATION_MILLIS = 16;
        public static final String IDLE_EVENT_NAME = "Looper.queueIdle";
        public static final long MIN_INTERESTING_BURST_DURATION_MILLIS = 48;
        public static final long MIN_INTERESTING_DURATION_MILLIS = 16;
        public static final String TAG = "TraceEvent_LooperMonitor";
        public boolean mIdleMonitorAttached;
        public long mLastIdleStartedAt;
        public long mLastWorkStartedAt;
        public int mNumIdlesSeen;
        public int mNumTasksSeen;
        public int mNumTasksSinceLastIdle;

        public IdleTracingLooperMonitor() {
            super();
        }

        @Override // org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void beginHandling(String str) {
            if (this.mNumTasksSinceLastIdle == 0) {
                TraceEvent.end(IDLE_EVENT_NAME);
            }
            this.mLastWorkStartedAt = SystemClock.elapsedRealtime();
            syncIdleMonitoring();
            super.beginHandling(str);
        }

        private final void syncIdleMonitoring() {
            if (TraceEvent.sEnabled && !this.mIdleMonitorAttached) {
                this.mLastIdleStartedAt = SystemClock.elapsedRealtime();
                Looper.myQueue().addIdleHandler(this);
                this.mIdleMonitorAttached = true;
                android.util.Log.v(TAG, "attached idle handler");
            } else if (this.mIdleMonitorAttached && !TraceEvent.sEnabled) {
                Looper.myQueue().removeIdleHandler(this);
                this.mIdleMonitorAttached = false;
                android.util.Log.v(TAG, "detached idle handler");
            }
        }

        public static void traceAndLog(int i, String str) {
            TraceEvent.instant("TraceEvent.LooperMonitor:IdleStats", str);
            android.util.Log.println(i, TAG, str);
        }

        @Override // org.chromium.base.TraceEvent.BasicLooperMonitor
        public final void endHandling(String str) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLastWorkStartedAt;
            if (elapsedRealtime > 16) {
                traceAndLog(5, "observed a task that took " + elapsedRealtime + "ms: " + str);
            }
            super.endHandling(str);
            syncIdleMonitoring();
            this.mNumTasksSeen++;
            this.mNumTasksSinceLastIdle++;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.mLastIdleStartedAt == 0) {
                this.mLastIdleStartedAt = elapsedRealtime;
            }
            long j = elapsedRealtime - this.mLastIdleStartedAt;
            this.mNumIdlesSeen++;
            TraceEvent.begin(IDLE_EVENT_NAME, this.mNumTasksSinceLastIdle + " tasks since last idle.");
            if (j > 48) {
                traceAndLog(3, this.mNumTasksSeen + " tasks and " + this.mNumIdlesSeen + " idles processed so far, " + this.mNumTasksSinceLastIdle + " tasks bursted and " + j + "ms elapsed since last idle");
            }
            this.mLastIdleStartedAt = elapsedRealtime;
            this.mNumTasksSinceLastIdle = 0;
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class LooperMonitorHolder {
        public static final BasicLooperMonitor sInstance;

        static {
            BasicLooperMonitor basicLooperMonitor;
            if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_IDLE_TRACING)) {
                basicLooperMonitor = new IdleTracingLooperMonitor();
            } else {
                basicLooperMonitor = new BasicLooperMonitor();
            }
            sInstance = basicLooperMonitor;
        }
    }

    public TraceEvent(String str, String str2) {
        this.mName = str;
        begin(str, str2);
    }

    public static void begin(String str, String str2) {
        EarlyTraceEvent.begin(str, false);
        if (sEnabled) {
            TraceEventJni.get().begin(str, str2);
            return;
        }
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.traceBegin(str);
        }
    }

    public static void end(String str, String str2) {
        EarlyTraceEvent.end(str, false);
        if (sEnabled) {
            TraceEventJni.get().end(str, str2);
            return;
        }
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.traceEnd();
        }
    }

    public static void finishAsync(String str, long j) {
        EarlyTraceEvent.finishAsync(str, j);
        if (sEnabled) {
            TraceEventJni.get().finishAsync(str, j);
            return;
        }
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.asyncTraceEnd(str, (int) j);
        }
    }

    public static void instant(String str, String str2) {
        if (sEnabled) {
            TraceEventJni.get().instant(str, str2);
        }
    }

    public static void maybeEnableEarlyTracing(long j, boolean z) {
        if (z) {
            EarlyTraceEvent.maybeEnable();
        }
        if (j != 0) {
            sATrace = new ATrace(j);
        }
        if (EarlyTraceEvent.enabled()) {
            ATrace aTrace = sATrace;
            if (aTrace == null || !aTrace.hasActiveSession()) {
                ThreadUtils.getUiThreadLooper().setMessageLogging(LooperMonitorHolder.sInstance);
            }
        }
    }

    public static TraceEvent scoped(String str, String str2) {
        if (!EarlyTraceEvent.enabled() && !enabled()) {
            return null;
        }
        return new TraceEvent(str, str2);
    }

    public static void startAsync(String str, long j) {
        EarlyTraceEvent.startAsync(str, j);
        if (sEnabled) {
            TraceEventJni.get().startAsync(str, j);
            return;
        }
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.asyncTraceBegin(str, (int) j);
        }
    }

    public static boolean enabled() {
        return sEnabled;
    }

    public static void onNativeTracingReady() {
        TraceEventJni.get().registerEnabledObserver();
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.onNativeTracingReady();
        }
    }

    public static void onUiThreadReady() {
        ATrace aTrace = sATrace;
        if (aTrace != null) {
            aTrace.onUiThreadReady();
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end(this.mName);
    }

    public static void begin(String str) {
        begin(str, null);
    }

    public static void end(String str) {
        end(str, null);
    }

    public static void instant(String str) {
        if (sEnabled) {
            TraceEventJni.get().instant(str, null);
        }
    }

    public static TraceEvent scoped(String str) {
        return scoped(str, null);
    }

    @CalledByNative
    public static void setEnabled(boolean z) {
        BasicLooperMonitor basicLooperMonitor;
        if (z) {
            EarlyTraceEvent.disable();
        }
        if (sEnabled != z) {
            sEnabled = z;
            ATrace aTrace = sATrace;
            if (aTrace != null && !aTrace.hasActiveSession()) {
                Looper uiThreadLooper = ThreadUtils.getUiThreadLooper();
                if (z) {
                    basicLooperMonitor = LooperMonitorHolder.sInstance;
                } else {
                    basicLooperMonitor = null;
                }
                uiThreadLooper.setMessageLogging(basicLooperMonitor);
            }
        }
    }
}
