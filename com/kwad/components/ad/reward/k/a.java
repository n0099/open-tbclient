package com.kwad.components.ad.reward.k;

import android.content.Context;
/* loaded from: classes9.dex */
public class a implements b {
    public Context mContext;
    public com.kwad.components.ad.reward.k nM;

    public a(Context context, com.kwad.components.ad.reward.k kVar) {
        this.nM = kVar;
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void gn() {
        this.nM.a(this.mContext, 1, 1);
    }

    @Override // com.kwad.components.ad.reward.k.b
    public void hA() {
        this.nM.a(this.mContext, 117, 2);
    }

    @Override // com.kwad.components.ad.reward.k.b
    public void hz() {
        this.nM.a(this.mContext, 13, 2);
    }
}
