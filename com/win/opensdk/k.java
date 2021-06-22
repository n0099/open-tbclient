package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40857a;

    public k(PBSplash pBSplash) {
        this.f40857a = pBSplash;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PBSplash pBSplash = this.f40857a;
        if (pBSplash.f40689e != null) {
            pBSplash.f40690f = true;
            this.f40857a.f40689e.onSkip();
        }
    }
}
