package com.kwad.components.core.page.c.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
/* loaded from: classes10.dex */
public final class b extends com.kwad.sdk.mvp.a {
    @Nullable
    public KsAdWebView.c OA;
    @Nullable
    public f.a OB;
    @Nullable
    public at.b OC;
    public boolean OD = false;
    public boolean OE = false;
    @NonNull
    public AdWebViewActivityProxy.a Oj;
    @Nullable
    public com.kwad.components.core.page.a.a Oz;
    @NonNull
    public ViewGroup gS;
    @NonNull
    public AdTemplate mAdTemplate;
    @NonNull
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;
    @NonNull
    public Context mContext;
    @Nullable
    public String mPageTitle;
    @NonNull
    public String mPageUrl;
    public boolean mShowPermission;
    @Nullable
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    public final boolean oX() {
        return this.mShowPermission;
    }

    public final void pc() {
        at.b bVar = this.OC;
        if (bVar != null) {
            bVar.pu();
        }
    }

    public final boolean pi() {
        return this.OE;
    }

    public final boolean pj() {
        if (oX()) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.OA = null;
        this.OB = null;
        this.mWebCardCloseListener = null;
        this.OC = null;
    }

    private void aF(boolean z) {
        this.OE = true;
    }

    public final void a(f.a aVar) {
        this.OB = aVar;
    }

    public final void setWebCardCloseListener(@Nullable com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public final void a(at.b bVar) {
        this.OC = bVar;
        aF(true);
    }

    public final void a(KsAdWebView.c cVar) {
        this.OA = cVar;
    }
}
