package com.bytedance.tea.crash.g;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f7665a = new HashSet();

    static {
        f7665a.add("HeapTaskDaemon");
        f7665a.add("ThreadPlus");
        f7665a.add("ApiDispatcher");
        f7665a.add("ApiLocalDispatcher");
        f7665a.add("AsyncLoader");
        f7665a.add("AsyncTask");
        f7665a.add("Binder");
        f7665a.add("PackageProcessor");
        f7665a.add("SettingsObserver");
        f7665a.add("WifiManager");
        f7665a.add("JavaBridge");
        f7665a.add("Compiler");
        f7665a.add("Signal Catcher");
        f7665a.add("GC");
        f7665a.add("ReferenceQueueDaemon");
        f7665a.add("FinalizerDaemon");
        f7665a.add("FinalizerWatchdogDaemon");
        f7665a.add("CookieSyncManager");
        f7665a.add("RefQueueWorker");
        f7665a.add("CleanupReference");
        f7665a.add("VideoManager");
        f7665a.add("DBHelper-AsyncOp");
        f7665a.add("InstalledAppTracker2");
        f7665a.add("AppData-AsyncOp");
        f7665a.add("IdleConnectionMonitor");
        f7665a.add("LogReaper");
        f7665a.add("ActionReaper");
        f7665a.add("Okio Watchdog");
        f7665a.add("CheckWaitingQueue");
        f7665a.add("NPTH-CrashTimer");
        f7665a.add("NPTH-JavaCallback");
        f7665a.add("NPTH-LocalParser");
        f7665a.add("ANR_FILE_MODIFY");
    }

    public static Set<String> a() {
        return f7665a;
    }
}
