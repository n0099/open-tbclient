package com.bytedance.tea.crash.g;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f7965a = new HashSet();

    static {
        f7965a.add("HeapTaskDaemon");
        f7965a.add("ThreadPlus");
        f7965a.add("ApiDispatcher");
        f7965a.add("ApiLocalDispatcher");
        f7965a.add("AsyncLoader");
        f7965a.add("AsyncTask");
        f7965a.add("Binder");
        f7965a.add("PackageProcessor");
        f7965a.add("SettingsObserver");
        f7965a.add("WifiManager");
        f7965a.add("JavaBridge");
        f7965a.add("Compiler");
        f7965a.add("Signal Catcher");
        f7965a.add("GC");
        f7965a.add("ReferenceQueueDaemon");
        f7965a.add("FinalizerDaemon");
        f7965a.add("FinalizerWatchdogDaemon");
        f7965a.add("CookieSyncManager");
        f7965a.add("RefQueueWorker");
        f7965a.add("CleanupReference");
        f7965a.add("VideoManager");
        f7965a.add("DBHelper-AsyncOp");
        f7965a.add("InstalledAppTracker2");
        f7965a.add("AppData-AsyncOp");
        f7965a.add("IdleConnectionMonitor");
        f7965a.add("LogReaper");
        f7965a.add("ActionReaper");
        f7965a.add("Okio Watchdog");
        f7965a.add("CheckWaitingQueue");
        f7965a.add("NPTH-CrashTimer");
        f7965a.add("NPTH-JavaCallback");
        f7965a.add("NPTH-LocalParser");
        f7965a.add("ANR_FILE_MODIFY");
    }

    public static Set<String> a() {
        return f7965a;
    }
}
