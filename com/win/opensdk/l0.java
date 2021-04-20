package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes7.dex */
public class l0 implements s0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f40256a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0 f40257b;

    public l0(p0 p0Var, View view) {
        this.f40257b = p0Var;
        this.f40256a = view;
    }

    @Override // com.win.opensdk.s0
    public void a() {
        if (this.f40256a != null) {
            new Handler().postDelayed(new k0(this), this.f40257b.f40296c.getSpet());
        }
    }
}
