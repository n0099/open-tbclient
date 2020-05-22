package com.kascend.chushou.view.a;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes5.dex */
public class b<T> implements a<T> {
    private long a = 0;
    private a<T> mJp;

    public b(a<T> aVar) {
        this.mJp = aVar;
    }

    @Override // com.kascend.chushou.view.a.a
    public void b(View view, T t) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.a > 500) {
            this.a = uptimeMillis;
            if (this.mJp != null) {
                this.mJp.b(view, t);
            }
        }
    }
}
