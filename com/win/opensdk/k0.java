package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes6.dex */
public class k0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f37902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f37903b;

    public k0(m0 m0Var, l0 l0Var) {
        this.f37903b = m0Var;
        this.f37902a = l0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f37903b.f37907b || !this.f37903b.a(this.f37903b.f37906a)) {
                return;
            }
            this.f37903b.f37910e.removeMessages(1101);
            this.f37903b.f37906a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f37902a != null) {
                this.f37902a.a();
            }
            this.f37903b.f37907b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
