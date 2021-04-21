package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class r0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s0 f40405a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t0 f40406b;

    public r0(t0 t0Var, s0 s0Var) {
        this.f40406b = t0Var;
        this.f40405a = s0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f40406b.f40416b || !this.f40406b.a(this.f40406b.f40415a)) {
                return;
            }
            this.f40406b.f40419e.removeMessages(1101);
            this.f40406b.f40415a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f40405a != null) {
                this.f40405a.a();
            }
            this.f40406b.f40416b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
