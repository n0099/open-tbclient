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
    public bq qjA;
    public bo qjB;
    private y qjp;
    private MraidLayout qjz;

    public q(Context context, af afVar) {
        this.qjp = new y(context, afVar);
        this.qjp.qje = this;
        this.qjz = new MraidLayout(context);
        this.qjz.addView(this.qjp, new FrameLayout.LayoutParams(-1, -1));
        this.qjp.setMraidListener(this);
    }

    @Override // com.win.opensdk.bn
    public final void a(String str, Info info) {
        if (!TextUtils.isEmpty(str)) {
            if (this.qjA != null) {
                this.qjA.eIP();
            }
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.qjp.abF(str);
            } else {
                this.qjp.loadUrl(str);
            }
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.qjB = boVar;
    }

    @Override // com.win.opensdk.bn
    public final View eIS() {
        return this.qjz;
    }

    @Override // com.win.opensdk.bn
    public final void eIP() {
        if (this.qjz != null) {
            this.qjz.removeAllViews();
        }
        if (this.qjp != null) {
            this.qjp.eIQ();
            this.qjp.destroy();
        }
    }

    @Override // com.win.opensdk.k
    public final void eIQ() {
        if (this.qjA != null) {
            this.qjA.eIQ();
        }
    }

    @Override // com.win.opensdk.k
    public final boolean abE(String str) {
        if (this.qjB != null) {
            return this.qjB.hA(str, "");
        }
        return false;
    }
}
