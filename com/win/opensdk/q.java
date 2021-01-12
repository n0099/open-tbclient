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
    private y pZk;
    private MraidLayout pZu;
    public bq pZv;
    public bo pZw;

    public q(Context context, af afVar) {
        this.pZk = new y(context, afVar);
        this.pZk.pYZ = this;
        this.pZu = new MraidLayout(context);
        this.pZu.addView(this.pZk, new FrameLayout.LayoutParams(-1, -1));
        this.pZk.setMraidListener(this);
    }

    @Override // com.win.opensdk.bn
    public final void a(String str, Info info) {
        if (!TextUtils.isEmpty(str)) {
            if (this.pZv != null) {
                this.pZv.eGz();
            }
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.pZk.aaD(str);
            } else {
                this.pZk.loadUrl(str);
            }
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.pZw = boVar;
    }

    @Override // com.win.opensdk.bn
    public final View eGC() {
        return this.pZu;
    }

    @Override // com.win.opensdk.bn
    public final void eGz() {
        if (this.pZu != null) {
            this.pZu.removeAllViews();
        }
        if (this.pZk != null) {
            this.pZk.eGA();
            this.pZk.destroy();
        }
    }

    @Override // com.win.opensdk.k
    public final void eGA() {
        if (this.pZv != null) {
            this.pZv.eGA();
        }
    }

    @Override // com.win.opensdk.k
    public final boolean aaC(String str) {
        if (this.pZw != null) {
            return this.pZw.ht(str, "");
        }
        return false;
    }
}
