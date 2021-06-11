package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class k0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f40755a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f40756b;

    public k0(m0 m0Var, l0 l0Var) {
        this.f40756b = m0Var;
        this.f40755a = l0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f40756b.f40760b || !this.f40756b.a(this.f40756b.f40759a)) {
                return;
            }
            this.f40756b.f40763e.removeMessages(1101);
            this.f40756b.f40759a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f40755a != null) {
                this.f40755a.a();
            }
            this.f40756b.f40760b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
