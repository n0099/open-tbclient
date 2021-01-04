package com.bytedance.tea.crash.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class f {
    private static volatile f ppQ;
    private final c ppO;

    public static f hY(Context context) {
        if (ppQ == null) {
            synchronized (f.class) {
                if (ppQ == null) {
                    ppQ = new f(context);
                }
            }
        }
        return ppQ;
    }

    private f(@NonNull Context context) {
        this.ppO = new c(context);
    }

    public void a() {
        this.ppO.a();
    }
}
