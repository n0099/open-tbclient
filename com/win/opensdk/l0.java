package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes7.dex */
public class l0 implements s0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f39966a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0 f39967b;

    public l0(p0 p0Var, View view) {
        this.f39967b = p0Var;
        this.f39966a = view;
    }

    @Override // com.win.opensdk.s0
    public void a() {
        if (this.f39966a != null) {
            new Handler().postDelayed(new k0(this), this.f39967b.f40006c.getSpet());
        }
    }
}
