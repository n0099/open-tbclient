package com.win.opensdk;

import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class B implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f40007a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f40008b;

    public B(C c2, Info info) {
        this.f40008b = c2;
        this.f40007a = info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a1.a(this.f40008b.f40021c).a(new b1(this.f40007a)).a();
            if (this.f40008b.f40025g != null) {
                this.f40008b.f40025g.onClosed();
            }
        } catch (Exception unused) {
        }
        this.f40008b.f40020b.destroy();
    }
}
