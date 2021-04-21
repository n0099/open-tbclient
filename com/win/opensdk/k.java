package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40345a;

    public k(PBSplash pBSplash) {
        this.f40345a = pBSplash;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PBSplash pBSplash = this.f40345a;
        if (pBSplash.f40148e != null) {
            pBSplash.f40149f = true;
            this.f40345a.f40148e.onSkip();
        }
    }
}
