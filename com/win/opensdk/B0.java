package com.win.opensdk;

import android.content.Context;
/* loaded from: classes7.dex */
public class B0 extends C0 {
    public F0 q;

    public B0(Context context, K0 k0, F0 f0) {
        super(context, null, 0, k0);
        this.q = f0;
    }

    @Override // com.win.opensdk.C0
    public void b() {
        ((I0) this.q).a();
    }

    @Override // com.win.opensdk.C0
    public L0 getMraidState() {
        return L0.STATE_EXPANDED;
    }
}
