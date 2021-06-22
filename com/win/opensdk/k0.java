package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class k0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f40858a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f40859b;

    public k0(m0 m0Var, l0 l0Var) {
        this.f40859b = m0Var;
        this.f40858a = l0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f40859b.f40863b || !this.f40859b.a(this.f40859b.f40862a)) {
                return;
            }
            this.f40859b.f40866e.removeMessages(1101);
            this.f40859b.f40862a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f40858a != null) {
                this.f40858a.a();
            }
            this.f40859b.f40863b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
