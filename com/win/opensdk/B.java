package com.win.opensdk;

import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class B implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f39622a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f39623b;

    public B(C c2, Info info) {
        this.f39623b = c2;
        this.f39622a = info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a1.a(this.f39623b.f39636c).a(new b1(this.f39622a)).a();
            if (this.f39623b.f39640g != null) {
                this.f39623b.f39640g.onClosed();
            }
        } catch (Exception unused) {
        }
        this.f39623b.f39635b.destroy();
    }
}
