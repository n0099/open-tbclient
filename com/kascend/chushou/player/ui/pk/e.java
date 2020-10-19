package com.kascend.chushou.player.ui.pk;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public class e {
    private static final e owc = new e();
    private Handler b = new Handler(Looper.getMainLooper());

    public static e eih() {
        return owc;
    }

    private e() {
    }

    public void a(c cVar, long j) {
        this.b.postDelayed(cVar, j);
    }

    public void a(c cVar) {
        this.b.postDelayed(cVar, cVar.c);
    }

    public void b(c cVar) {
        this.b.postDelayed(cVar, cVar.f);
    }

    public void c(c cVar) {
        if (cVar != null) {
            cVar.a();
            this.b.removeCallbacks(cVar);
        }
    }
}
