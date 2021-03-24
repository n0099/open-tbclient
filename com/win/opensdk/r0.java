package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class r0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s0 f40020a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t0 f40021b;

    public r0(t0 t0Var, s0 s0Var) {
        this.f40021b = t0Var;
        this.f40020a = s0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f40021b.f40031b || !this.f40021b.a(this.f40021b.f40030a)) {
                return;
            }
            this.f40021b.f40034e.removeMessages(1101);
            this.f40021b.f40030a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f40020a != null) {
                this.f40020a.a();
            }
            this.f40021b.f40031b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
