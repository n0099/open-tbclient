package com.win.opensdk;

import android.view.View;
/* loaded from: classes7.dex */
public class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PBSplash f40754a;

    public k(PBSplash pBSplash) {
        this.f40754a = pBSplash;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PBSplash pBSplash = this.f40754a;
        if (pBSplash.f40586e != null) {
            pBSplash.f40587f = true;
            this.f40754a.f40586e.onSkip();
        }
    }
}
