package com.bytedance.tea.crash.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class f {
    private static volatile f pyd;
    private final c pyb;

    public static f hY(Context context) {
        if (pyd == null) {
            synchronized (f.class) {
                if (pyd == null) {
                    pyd = new f(context);
                }
            }
        }
        return pyd;
    }

    private f(@NonNull Context context) {
        this.pyb = new c(context);
    }

    public void a() {
        this.pyb.a();
    }
}
