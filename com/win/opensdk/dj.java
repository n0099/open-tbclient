package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes14.dex */
public class dj implements eg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f8152a;
    public final /* synthetic */ dv qlM;

    public dj(dv dvVar, View view) {
        this.qlM = dvVar;
        this.f8152a = view;
    }

    @Override // com.win.opensdk.eg
    public void a() {
        if (this.f8152a != null) {
            new Handler().postDelayed(new df(this), this.qlM.qkh.getSpet());
        }
    }
}
