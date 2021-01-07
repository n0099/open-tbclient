package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HandlerThread f7950a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f7951b;
    private static volatile Handler c = null;

    public static HandlerThread a() {
        if (f7950a == null) {
            synchronized (h.class) {
                if (f7950a == null) {
                    f7950a = new HandlerThread("default_npth_thread");
                    f7950a.start();
                    f7951b = new Handler(f7950a.getLooper());
                }
            }
        }
        return f7950a;
    }

    public static Handler b() {
        if (f7951b == null) {
            a();
        }
        return f7951b;
    }
}
