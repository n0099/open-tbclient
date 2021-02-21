package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.MraidLayout;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public final class q implements bn, k {
    private y qjP;
    private MraidLayout qjZ;
    public bq qka;
    public bo qkb;

    public q(Context context, af afVar) {
        this.qjP = new y(context, afVar);
        this.qjP.qjE = this;
        this.qjZ = new MraidLayout(context);
        this.qjZ.addView(this.qjP, new FrameLayout.LayoutParams(-1, -1));
        this.qjP.setMraidListener(this);
    }

    @Override // com.win.opensdk.bn
    public final void a(String str, Info info) {
        if (!TextUtils.isEmpty(str)) {
            if (this.qka != null) {
                this.qka.eIX();
            }
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.qjP.abR(str);
            } else {
                this.qjP.loadUrl(str);
            }
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.qkb = boVar;
    }

    @Override // com.win.opensdk.bn
    public final View eJa() {
        return this.qjZ;
    }

    @Override // com.win.opensdk.bn
    public final void eIX() {
        if (this.qjZ != null) {
            this.qjZ.removeAllViews();
        }
        if (this.qjP != null) {
            this.qjP.eIY();
            this.qjP.destroy();
        }
    }

    @Override // com.win.opensdk.k
    public final void eIY() {
        if (this.qka != null) {
            this.qka.eIY();
        }
    }

    @Override // com.win.opensdk.k
    public final boolean abQ(String str) {
        if (this.qkb != null) {
            return this.qkb.hC(str, "");
        }
        return false;
    }
}
