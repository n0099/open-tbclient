package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes7.dex */
public class e0 implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f40713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i0 f40714b;

    public e0(i0 i0Var, View view) {
        this.f40714b = i0Var;
        this.f40713a = view;
    }

    @Override // com.win.opensdk.l0
    public void a() {
        if (this.f40713a != null) {
            new Handler().postDelayed(new d0(this), this.f40714b.f40735c.getSpet());
        }
    }
}
