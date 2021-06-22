package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes7.dex */
public class U0 implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f40744a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Y0 f40745b;

    public U0(Y0 y0, View view) {
        this.f40745b = y0;
        this.f40744a = view;
    }

    @Override // com.win.opensdk.l0
    public void a() {
        if (this.f40744a != null) {
            new Handler().postDelayed(new T0(this), this.f40745b.f40765c.getSpet());
        }
    }
}
