package com.win.opensdk;

import android.view.ViewTreeObserver;
/* loaded from: classes7.dex */
public class k0 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f37076a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m0 f37077b;

    public k0(m0 m0Var, l0 l0Var) {
        this.f37077b = m0Var;
        this.f37076a = l0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.f37077b.f37081b || !this.f37077b.a(this.f37077b.f37080a)) {
                return;
            }
            this.f37077b.f37084e.removeMessages(1101);
            this.f37077b.f37080a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.f37076a != null) {
                this.f37076a.a();
            }
            this.f37077b.f37081b = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
