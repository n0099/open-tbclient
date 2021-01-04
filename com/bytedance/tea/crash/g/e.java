package com.bytedance.tea.crash.g;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f7964a = new HashSet();

    static {
        f7964a.add("HeapTaskDaemon");
        f7964a.add("ThreadPlus");
        f7964a.add("ApiDispatcher");
        f7964a.add("ApiLocalDispatcher");
        f7964a.add("AsyncLoader");
        f7964a.add("AsyncTask");
        f7964a.add("Binder");
        f7964a.add("PackageProcessor");
        f7964a.add("SettingsObserver");
        f7964a.add("WifiManager");
        f7964a.add("JavaBridge");
        f7964a.add("Compiler");
        f7964a.add("Signal Catcher");
        f7964a.add("GC");
        f7964a.add("ReferenceQueueDaemon");
        f7964a.add("FinalizerDaemon");
        f7964a.add("FinalizerWatchdogDaemon");
        f7964a.add("CookieSyncManager");
        f7964a.add("RefQueueWorker");
        f7964a.add("CleanupReference");
        f7964a.add("VideoManager");
        f7964a.add("DBHelper-AsyncOp");
        f7964a.add("InstalledAppTracker2");
        f7964a.add("AppData-AsyncOp");
        f7964a.add("IdleConnectionMonitor");
        f7964a.add("LogReaper");
        f7964a.add("ActionReaper");
        f7964a.add("Okio Watchdog");
        f7964a.add("CheckWaitingQueue");
        f7964a.add("NPTH-CrashTimer");
        f7964a.add("NPTH-JavaCallback");
        f7964a.add("NPTH-LocalParser");
        f7964a.add("ANR_FILE_MODIFY");
    }

    public static Set<String> a() {
        return f7964a;
    }
}
