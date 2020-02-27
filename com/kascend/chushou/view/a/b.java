package com.kascend.chushou.view.a;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes5.dex */
public class b<T> implements a<T> {
    private long a = 0;
    private a<T> mQH;

    public b(a<T> aVar) {
        this.mQH = aVar;
    }

    @Override // com.kascend.chushou.view.a.a
    public void b(View view, T t) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.a > 500) {
            this.a = uptimeMillis;
            if (this.mQH != null) {
                this.mQH.b(view, t);
            }
        }
    }
}
