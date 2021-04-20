package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes7.dex */
public class x1 implements s0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f40390a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ B1 f40391b;

    public x1(B1 b1, View view) {
        this.f40391b = b1;
        this.f40390a = view;
    }

    @Override // com.win.opensdk.s0
    public void a() {
        if (this.f40390a != null) {
            new Handler().postDelayed(new w1(this), this.f40391b.f39916c.getSpet());
        }
    }
}
