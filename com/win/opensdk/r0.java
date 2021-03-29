package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class r0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s0 f40021a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t0 f40022b;

    public r0(t0 t0Var, s0 s0Var) {
        this.f40022b = t0Var;
        this.f40021a = s0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f40022b.f40032b || !this.f40022b.a(this.f40022b.f40031a)) {
                return;
            }
            this.f40022b.f40035e.removeMessages(1101);
            this.f40022b.f40031a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f40021a != null) {
                this.f40021a.a();
            }
            this.f40022b.f40032b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
