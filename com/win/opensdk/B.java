package com.win.opensdk;

import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class B implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f39912a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f39913b;

    public B(C c2, Info info) {
        this.f39913b = c2;
        this.f39912a = info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a1.a(this.f39913b.f39926c).a(new b1(this.f39912a)).a();
            if (this.f39913b.f39930g != null) {
                this.f39913b.f39930g.onClosed();
            }
        } catch (Exception unused) {
        }
        this.f39913b.f39925b.destroy();
    }
}
