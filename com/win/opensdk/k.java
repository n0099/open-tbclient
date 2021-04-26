package com.win.opensdk;

import android.view.View;
/* loaded from: classes6.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f37901a;

    public k(PBSplash pBSplash) {
        this.f37901a = pBSplash;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PBSplash pBSplash = this.f37901a;
        if (pBSplash.f37733e != null) {
            pBSplash.f37734f = true;
            this.f37901a.f37733e.onSkip();
        }
    }
}
