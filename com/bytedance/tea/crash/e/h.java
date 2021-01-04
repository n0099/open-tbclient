package com.bytedance.tea.crash.e;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HandlerThread f7949a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Handler f7950b;
    private static volatile Handler c = null;

    public static HandlerThread a() {
        if (f7949a == null) {
            synchronized (h.class) {
                if (f7949a == null) {
                    f7949a = new HandlerThread("default_npth_thread");
                    f7949a.start();
                    f7950b = new Handler(f7949a.getLooper());
                }
            }
        }
        return f7949a;
    }

    public static Handler b() {
        if (f7950b == null) {
            a();
        }
        return f7950b;
    }
}
