package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class r0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s0 f40310a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t0 f40311b;

    public r0(t0 t0Var, s0 s0Var) {
        this.f40311b = t0Var;
        this.f40310a = s0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f40311b.f40321b || !this.f40311b.a(this.f40311b.f40320a)) {
                return;
            }
            this.f40311b.f40324e.removeMessages(1101);
            this.f40311b.f40320a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f40310a != null) {
                this.f40310a.a();
            }
            this.f40311b.f40321b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
