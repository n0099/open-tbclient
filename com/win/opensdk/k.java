package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39960a;

    public k(PBSplash pBSplash) {
        this.f39960a = pBSplash;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PBSplash pBSplash = this.f39960a;
        if (pBSplash.f39763e != null) {
            pBSplash.f39764f = true;
            this.f39960a.f39763e.onSkip();
        }
    }
}
