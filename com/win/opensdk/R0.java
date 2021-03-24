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
    public C0 f39781a;

    /* renamed from: b  reason: collision with root package name */
    public MraidLayout f39782b;

    /* renamed from: c  reason: collision with root package name */
    public C2 f39783c;

    /* renamed from: d  reason: collision with root package name */
    public A2 f39784d;

    public R0(Context context, K0 k0) {
        C0 c0 = new C0(context, null, 0, k0);
        this.f39781a = c0;
        c0.a(this);
        this.f39782b = new MraidLayout(context);
        this.f39782b.addView(this.f39781a, new FrameLayout.LayoutParams(-1, -1));
        this.f39781a.setMraidListener(this);
    }

    @Override // com.win.opensdk.z2
    public void a() {
        MraidLayout mraidLayout = this.f39782b;
        if (mraidLayout != null) {
            mraidLayout.removeAllViews();
        }
        C0 c0 = this.f39781a;
        if (c0 != null) {
            c0.b();
            this.f39781a.destroy();
        }
    }

    @Override // com.win.opensdk.z2
    public void a(A2 a2) {
        this.f39784d = a2;
    }

    public void a(C2 c2) {
        this.f39783c = c2;
    }

    @Override // com.win.opensdk.z2
    public void a(String str, Info info) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C2 c2 = this.f39783c;
        if (c2 != null) {
            c2.a();
        }
        if (str.startsWith("http")) {
            this.f39781a.b(str);
        } else {
            this.f39781a.a(str);
        }
    }

    @Override // com.win.opensdk.z2
    public View b() {
        return this.f39782b;
    }

    public void c() {
    }
}
