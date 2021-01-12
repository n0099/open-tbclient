package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HandlerThread f7650a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f7651b;
    private static volatile Handler c = null;

    public static HandlerThread a() {
        if (f7650a == null) {
            synchronized (h.class) {
                if (f7650a == null) {
                    f7650a = new HandlerThread("default_npth_thread");
                    f7650a.start();
                    f7651b = new Handler(f7650a.getLooper());
                }
            }
        }
        return f7650a;
    }

    public static Handler b() {
        if (f7651b == null) {
            a();
        }
        return f7651b;
    }
}
