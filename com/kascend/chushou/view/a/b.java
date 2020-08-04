package com.kascend.chushou.view.a;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes6.dex */
public class b<T> implements a<T> {
    private long a = 0;
    private a<T> npo;

    public b(a<T> aVar) {
        this.npo = aVar;
    }

    @Override // com.kascend.chushou.view.a.a
    public void b(View view, T t) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.a > 500) {
            this.a = uptimeMillis;
            if (this.npo != null) {
                this.npo.b(view, t);
            }
        }
    }
}
