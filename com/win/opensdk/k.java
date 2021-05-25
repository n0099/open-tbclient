package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37075a;

    public k(PBSplash pBSplash) {
        this.f37075a = pBSplash;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PBSplash pBSplash = this.f37075a;
        if (pBSplash.f36907e != null) {
            pBSplash.f36908f = true;
            this.f37075a.f36907e.onSkip();
        }
    }
}
