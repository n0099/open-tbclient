package com.bytedance.tea.crash.g;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5188a = new HashSet();

    static {
        f5188a.add("HeapTaskDaemon");
        f5188a.add("ThreadPlus");
        f5188a.add("ApiDispatcher");
        f5188a.add("ApiLocalDispatcher");
        f5188a.add("AsyncLoader");
        f5188a.add("AsyncTask");
        f5188a.add("Binder");
        f5188a.add("PackageProcessor");
        f5188a.add("SettingsObserver");
        f5188a.add("WifiManager");
        f5188a.add("JavaBridge");
        f5188a.add("Compiler");
        f5188a.add("Signal Catcher");
        f5188a.add("GC");
        f5188a.add("ReferenceQueueDaemon");
        f5188a.add("FinalizerDaemon");
        f5188a.add("FinalizerWatchdogDaemon");
        f5188a.add("CookieSyncManager");
        f5188a.add("RefQueueWorker");
        f5188a.add("CleanupReference");
        f5188a.add("VideoManager");
        f5188a.add("DBHelper-AsyncOp");
        f5188a.add("InstalledAppTracker2");
        f5188a.add("AppData-AsyncOp");
        f5188a.add("IdleConnectionMonitor");
        f5188a.add("LogReaper");
        f5188a.add("ActionReaper");
        f5188a.add("Okio Watchdog");
        f5188a.add("CheckWaitingQueue");
        f5188a.add("NPTH-CrashTimer");
        f5188a.add("NPTH-JavaCallback");
        f5188a.add("NPTH-LocalParser");
        f5188a.add("ANR_FILE_MODIFY");
    }

    public static Set<String> a() {
        return f5188a;
    }
}
