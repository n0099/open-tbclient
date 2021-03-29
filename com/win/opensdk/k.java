package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f39961a;

    public k(PBSplash pBSplash) {
        this.f39961a = pBSplash;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PBSplash pBSplash = this.f39961a;
        if (pBSplash.f39764e != null) {
            pBSplash.f39765f = true;
            this.f39961a.f39764e.onSkip();
        }
    }
}
