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
    public C0 f39782a;

    /* renamed from: b  reason: collision with root package name */
    public MraidLayout f39783b;

    /* renamed from: c  reason: collision with root package name */
    public C2 f39784c;

    /* renamed from: d  reason: collision with root package name */
    public A2 f39785d;

    public R0(Context context, K0 k0) {
        C0 c0 = new C0(context, null, 0, k0);
        this.f39782a = c0;
        c0.a(this);
        this.f39783b = new MraidLayout(context);
        this.f39783b.addView(this.f39782a, new FrameLayout.LayoutParams(-1, -1));
        this.f39782a.setMraidListener(this);
    }

    @Override // com.win.opensdk.z2
    public void a() {
        MraidLayout mraidLayout = this.f39783b;
        if (mraidLayout != null) {
            mraidLayout.removeAllViews();
        }
        C0 c0 = this.f39782a;
        if (c0 != null) {
            c0.b();
            this.f39782a.destroy();
        }
    }

    @Override // com.win.opensdk.z2
    public void a(A2 a2) {
        this.f39785d = a2;
    }

    public void a(C2 c2) {
        this.f39784c = c2;
    }

    @Override // com.win.opensdk.z2
    public void a(String str, Info info) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C2 c2 = this.f39784c;
        if (c2 != null) {
            c2.a();
        }
        if (str.startsWith("http")) {
            this.f39782a.b(str);
        } else {
            this.f39782a.a(str);
        }
    }

    @Override // com.win.opensdk.z2
    public View b() {
        return this.f39783b;
    }

    public void c() {
    }
}
