package com.bytedance.tea.crash.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f {
    private static volatile f pwa;
    private final c pvY;

    public static f hZ(Context context) {
        if (pwa == null) {
            synchronized (f.class) {
                if (pwa == null) {
                    pwa = new f(context);
                }
            }
        }
        return pwa;
    }

    private f(@NonNull Context context) {
        this.pvY = new c(context);
    }

    public void a() {
        this.pvY.a();
    }
}
