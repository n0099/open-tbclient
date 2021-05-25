package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes7.dex */
public class U0 implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f36962a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Y0 f36963b;

    public U0(Y0 y0, View view) {
        this.f36963b = y0;
        this.f36962a = view;
    }

    @Override // com.win.opensdk.l0
    public void a() {
        if (this.f36962a != null) {
            new Handler().postDelayed(new T0(this), this.f36963b.f36983c.getSpet());
        }
    }
}
