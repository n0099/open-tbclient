package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class k0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f37147a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f37148b;

    public k0(m0 m0Var, l0 l0Var) {
        this.f37148b = m0Var;
        this.f37147a = l0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f37148b.f37152b || !this.f37148b.a(this.f37148b.f37151a)) {
                return;
            }
            this.f37148b.f37155e.removeMessages(1101);
            this.f37148b.f37151a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f37147a != null) {
                this.f37147a.a();
            }
            this.f37148b.f37152b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
