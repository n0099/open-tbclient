package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.MraidLayout;
import org.apache.http.HttpHost;
/* loaded from: classes14.dex */
public class be implements ag, fe {
    public MraidLayout qkY;
    public m qkZ;
    public C0 qkf;
    public g qla;

    public be(Context context, K0 k0) {
        this.qkf = new C0(context, null, 0, k0);
        this.qkf.a(this);
        this.qkY = new MraidLayout(context);
        this.qkY.addView(this.qkf, new FrameLayout.LayoutParams(-1, -1));
        this.qkf.setMraidListener(this);
    }

    @Override // com.win.opensdk.fe
    public void a() {
        MraidLayout mraidLayout = this.qkY;
        if (mraidLayout != null) {
            mraidLayout.removeAllViews();
        }
        C0 c0 = this.qkf;
        if (c0 != null) {
            c0.b();
            this.qkf.destroy();
        }
    }

    @Override // com.win.opensdk.fe
    public void a(g gVar) {
        this.qla = gVar;
    }

    public void a(m mVar) {
        this.qkZ = mVar;
    }

    @Override // com.win.opensdk.fe
    public void a(String str, Info info) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m mVar = this.qkZ;
        if (mVar != null) {
            mVar.a();
        }
        if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            this.qkf.b(str);
        } else {
            this.qkf.a(str);
        }
    }

    @Override // com.win.opensdk.fe
    public View b() {
        return this.qkY;
    }

    public void c() {
    }
}
