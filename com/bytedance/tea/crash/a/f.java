package com.bytedance.tea.crash.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class f {
    private static volatile f pll;
    private final c plj;

    public static f hW(Context context) {
        if (pll == null) {
            synchronized (f.class) {
                if (pll == null) {
                    pll = new f(context);
                }
            }
        }
        return pll;
    }

    private f(@NonNull Context context) {
        this.plj = new c(context);
    }

    public void a() {
        this.plj.a();
    }
}
