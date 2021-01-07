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
    private y qdL;
    private MraidLayout qdV;
    public bq qdW;
    public bo qdX;

    public q(Context context, af afVar) {
        this.qdL = new y(context, afVar);
        this.qdL.qdA = this;
        this.qdV = new MraidLayout(context);
        this.qdV.addView(this.qdL, new FrameLayout.LayoutParams(-1, -1));
        this.qdL.setMraidListener(this);
    }

    @Override // com.win.opensdk.bn
    public final void a(String str, Info info) {
        if (!TextUtils.isEmpty(str)) {
            if (this.qdW != null) {
                this.qdW.eKp();
            }
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.qdL.abL(str);
            } else {
                this.qdL.loadUrl(str);
            }
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.qdX = boVar;
    }

    @Override // com.win.opensdk.bn
    public final View eKs() {
        return this.qdV;
    }

    @Override // com.win.opensdk.bn
    public final void eKp() {
        if (this.qdV != null) {
            this.qdV.removeAllViews();
        }
        if (this.qdL != null) {
            this.qdL.eKq();
            this.qdL.destroy();
        }
    }

    @Override // com.win.opensdk.k
    public final void eKq() {
        if (this.qdW != null) {
            this.qdW.eKq();
        }
    }

    @Override // com.win.opensdk.k
    public final boolean abK(String str) {
        if (this.qdX != null) {
            return this.qdX.hu(str, "");
        }
        return false;
    }
}
