package com.bytedance.tea.crash.a;

import android.content.Context;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public class f {
    private static volatile f plk;
    private final c pli;

    public static f hW(Context context) {
        if (plk == null) {
            synchronized (f.class) {
                if (plk == null) {
                    plk = new f(context);
                }
            }
        }
        return plk;
    }

    private f(@NonNull Context context) {
        this.pli = new c(context);
    }

    public void a() {
        this.pli.a();
    }
}
