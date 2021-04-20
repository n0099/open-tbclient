package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.MraidLayout;
/* loaded from: classes7.dex */
public class R0 implements z2, J0 {

    /* renamed from: a  reason: collision with root package name */
    public C0 f40071a;

    /* renamed from: b  reason: collision with root package name */
    public MraidLayout f40072b;

    /* renamed from: c  reason: collision with root package name */
    public C2 f40073c;

    /* renamed from: d  reason: collision with root package name */
    public A2 f40074d;

    public R0(Context context, K0 k0) {
        C0 c0 = new C0(context, null, 0, k0);
        this.f40071a = c0;
        c0.a(this);
        this.f40072b = new MraidLayout(context);
        this.f40072b.addView(this.f40071a, new FrameLayout.LayoutParams(-1, -1));
        this.f40071a.setMraidListener(this);
    }

    @Override // com.win.opensdk.z2
    public void a() {
        MraidLayout mraidLayout = this.f40072b;
        if (mraidLayout != null) {
            mraidLayout.removeAllViews();
        }
        C0 c0 = this.f40071a;
        if (c0 != null) {
            c0.b();
            this.f40071a.destroy();
        }
    }

    @Override // com.win.opensdk.z2
    public void a(A2 a2) {
        this.f40074d = a2;
    }

    public void a(C2 c2) {
        this.f40073c = c2;
    }

    @Override // com.win.opensdk.z2
    public void a(String str, Info info) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C2 c2 = this.f40073c;
        if (c2 != null) {
            c2.a();
        }
        if (str.startsWith("http")) {
            this.f40071a.b(str);
        } else {
            this.f40071a.a(str);
        }
    }

    @Override // com.win.opensdk.z2
    public View b() {
        return this.f40072b;
    }

    public void c() {
    }
}
