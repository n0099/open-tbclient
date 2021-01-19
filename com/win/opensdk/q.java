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
    private y pZl;
    private MraidLayout pZv;
    public bq pZw;
    public bo pZx;

    public q(Context context, af afVar) {
        this.pZl = new y(context, afVar);
        this.pZl.pZa = this;
        this.pZv = new MraidLayout(context);
        this.pZv.addView(this.pZl, new FrameLayout.LayoutParams(-1, -1));
        this.pZl.setMraidListener(this);
    }

    @Override // com.win.opensdk.bn
    public final void a(String str, Info info) {
        if (!TextUtils.isEmpty(str)) {
            if (this.pZw != null) {
                this.pZw.eGz();
            }
            if (!str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.pZl.aaE(str);
            } else {
                this.pZl.loadUrl(str);
            }
        }
    }

    @Override // com.win.opensdk.bn
    public final void a(bo boVar) {
        this.pZx = boVar;
    }

    @Override // com.win.opensdk.bn
    public final View eGC() {
        return this.pZv;
    }

    @Override // com.win.opensdk.bn
    public final void eGz() {
        if (this.pZv != null) {
            this.pZv.removeAllViews();
        }
        if (this.pZl != null) {
            this.pZl.eGA();
            this.pZl.destroy();
        }
    }

    @Override // com.win.opensdk.k
    public final void eGA() {
        if (this.pZw != null) {
            this.pZw.eGA();
        }
    }

    @Override // com.win.opensdk.k
    public final boolean aaD(String str) {
        if (this.pZx != null) {
            return this.pZx.ht(str, "");
        }
        return false;
    }
}
