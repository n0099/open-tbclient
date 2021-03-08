package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HandlerThread f5178a;
    private static volatile Handler b;
    private static volatile Handler c = null;

    public static HandlerThread a() {
        if (f5178a == null) {
            synchronized (h.class) {
                if (f5178a == null) {
                    f5178a = new HandlerThread("default_npth_thread");
                    f5178a.start();
                    b = new Handler(f5178a.getLooper());
                }
            }
        }
        return f5178a;
    }

    public static Handler b() {
        if (b == null) {
            a();
        }
        return b;
    }
}
