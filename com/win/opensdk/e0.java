package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes6.dex */
public class e0 implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f37860a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i0 f37861b;

    public e0(i0 i0Var, View view) {
        this.f37861b = i0Var;
        this.f37860a = view;
    }

    @Override // com.win.opensdk.l0
    public void a() {
        if (this.f37860a != null) {
            new Handler().postDelayed(new d0(this), this.f37861b.f37882c.getSpet());
        }
    }
}
