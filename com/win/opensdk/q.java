package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.MraidLayout;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public final class q implements bn, k {
    private y qcd;
    private MraidLayout qcn;
    public bq qco;
    public bo qcp;

    public q(Context context, af afVar) {
        this.qcd = new y(context, afVar);
        this.qcd.qbS = this;
        this.qcn = new MraidLayout(context);
        this.qcn.addView(this.qcd, new FrameLayout.LayoutParams(-1, -1));
        this.qcd.setMraidListener(this);
    }

    @Override // com.win.opensdk.bn
    public final void a(String str, Info info) {
        if (!TextUtils.isEmpty(str)) {
            if (this.qco != null) {
                this.qco.eJL();
            }
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.qcd.abK(str);
            } else {
                this.qcd.loadUrl(str);
            }
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.qcp = boVar;
    }

    @Override // com.win.opensdk.bn
    public final View eJO() {
        return this.qcn;
    }

    @Override // com.win.opensdk.bn
    public final void eJL() {
        if (this.qcn != null) {
            this.qcn.removeAllViews();
        }
        if (this.qcd != null) {
            this.qcd.eJM();
            this.qcd.destroy();
        }
    }

    @Override // com.win.opensdk.k
    public final void eJM() {
        if (this.qco != null) {
            this.qco.eJM();
        }
    }

    @Override // com.win.opensdk.k
    public final boolean abJ(String str) {
        if (this.qcp != null) {
            return this.qcp.ht(str, "");
        }
        return false;
    }
}
