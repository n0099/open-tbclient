package com.bytedance.tea.crash.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f {
    private static volatile f pvA;
    private final c pvy;

    public static f hZ(Context context) {
        if (pvA == null) {
            synchronized (f.class) {
                if (pvA == null) {
                    pvA = new f(context);
                }
            }
        }
        return pvA;
    }

    private f(@NonNull Context context) {
        this.pvy = new c(context);
    }

    public void a() {
        this.pvy.a();
    }
}
