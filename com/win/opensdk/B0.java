package com.win.opensdk;

import android.content.Context;
/* loaded from: classes14.dex */
public class B0 extends C0 {
    public t qkg;

    public B0(Context context, K0 k0, t tVar) {
        super(context, null, 0, k0);
        this.qkg = tVar;
    }

    @Override // com.win.opensdk.C0
    public void b() {
        ((ad) this.qkg).a();
    }

    @Override // com.win.opensdk.C0
    public L0 getMraidState() {
        return L0.STATE_EXPANDED;
    }
}
