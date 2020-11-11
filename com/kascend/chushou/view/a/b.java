package com.kascend.chushou.view.a;

import android.os.SystemClock;
import android.view.View;
/* loaded from: classes6.dex */
public class b<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    private long f4224a = 0;
    private a<T> pju;

    public b(a<T> aVar) {
        this.pju = aVar;
    }

    @Override // com.kascend.chushou.view.a.a
    public void b(View view, T t) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f4224a > 500) {
            this.f4224a = uptimeMillis;
            if (this.pju != null) {
                this.pju.b(view, t);
            }
        }
    }
}
