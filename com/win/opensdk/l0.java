package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes7.dex */
public class l0 implements s0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f40351a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0 f40352b;

    public l0(p0 p0Var, View view) {
        this.f40352b = p0Var;
        this.f40351a = view;
    }

    @Override // com.win.opensdk.s0
    public void a() {
        if (this.f40351a != null) {
            new Handler().postDelayed(new k0(this), this.f40352b.f40391c.getSpet());
        }
    }
}
