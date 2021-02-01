package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HandlerThread f7652a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f7653b;
    private static volatile Handler c = null;

    public static HandlerThread a() {
        if (f7652a == null) {
            synchronized (h.class) {
                if (f7652a == null) {
                    f7652a = new HandlerThread("default_npth_thread");
                    f7652a.start();
                    f7653b = new Handler(f7652a.getLooper());
                }
            }
        }
        return f7652a;
    }

    public static Handler b() {
        if (f7653b == null) {
            a();
        }
        return f7653b;
    }
}
