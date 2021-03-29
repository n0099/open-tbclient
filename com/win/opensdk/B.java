package com.win.opensdk;

import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class B implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f39623a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C f39624b;

    public B(C c2, Info info) {
        this.f39624b = c2;
        this.f39623a = info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a1.a(this.f39624b.f39637c).a(new b1(this.f39623a)).a();
            if (this.f39624b.f39641g != null) {
                this.f39624b.f39641g.onClosed();
            }
        } catch (Exception unused) {
        }
        this.f39624b.f39636b.destroy();
    }
}
