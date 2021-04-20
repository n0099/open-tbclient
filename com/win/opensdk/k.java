package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40250a;

    public k(PBSplash pBSplash) {
        this.f40250a = pBSplash;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PBSplash pBSplash = this.f40250a;
        if (pBSplash.f40053e != null) {
            pBSplash.f40054f = true;
            this.f40250a.f40053e.onSkip();
        }
    }
}
