package com.bytedance.tea.crash.g;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f7667a = new HashSet();

    static {
        f7667a.add("HeapTaskDaemon");
        f7667a.add("ThreadPlus");
        f7667a.add("ApiDispatcher");
        f7667a.add("ApiLocalDispatcher");
        f7667a.add("AsyncLoader");
        f7667a.add("AsyncTask");
        f7667a.add("Binder");
        f7667a.add("PackageProcessor");
        f7667a.add("SettingsObserver");
        f7667a.add("WifiManager");
        f7667a.add("JavaBridge");
        f7667a.add("Compiler");
        f7667a.add("Signal Catcher");
        f7667a.add("GC");
        f7667a.add("ReferenceQueueDaemon");
        f7667a.add("FinalizerDaemon");
        f7667a.add("FinalizerWatchdogDaemon");
        f7667a.add("CookieSyncManager");
        f7667a.add("RefQueueWorker");
        f7667a.add("CleanupReference");
        f7667a.add("VideoManager");
        f7667a.add("DBHelper-AsyncOp");
        f7667a.add("InstalledAppTracker2");
        f7667a.add("AppData-AsyncOp");
        f7667a.add("IdleConnectionMonitor");
        f7667a.add("LogReaper");
        f7667a.add("ActionReaper");
        f7667a.add("Okio Watchdog");
        f7667a.add("CheckWaitingQueue");
        f7667a.add("NPTH-CrashTimer");
        f7667a.add("NPTH-JavaCallback");
        f7667a.add("NPTH-LocalParser");
        f7667a.add("ANR_FILE_MODIFY");
    }

    public static Set<String> a() {
        return f7667a;
    }
}
