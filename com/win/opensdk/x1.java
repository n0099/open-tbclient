package com.win.opensdk;

import android.os.Handler;
import android.view.View;
/* loaded from: classes7.dex */
public class x1 implements s0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f40485a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ B1 f40486b;

    public x1(B1 b1, View view) {
        this.f40486b = b1;
        this.f40485a = view;
    }

    @Override // com.win.opensdk.s0
    public void a() {
        if (this.f40485a != null) {
            new Handler().postDelayed(new w1(this), this.f40486b.f40011c.getSpet());
        }
    }
}
