package com.kwad.components.core.webview.tachikoma.c;

import android.app.Activity;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.j;
import com.kwad.sdk.core.response.model.AdResultData;
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.mvp.a {
    public com.kwad.components.core.webview.tachikoma.e.c So;
    public StyleTemplate Sq;
    public e Yv;
    public com.kwad.sdk.widget.e aam;
    public j aan;
    public k aao;
    public boolean aap;
    public e.a aaq;
    public Activity mActivity;
    public AdResultData mAdResultData;
    public String xm;
    public long xr;

    @Override // com.kwad.sdk.mvp.a
    public void release() {
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.m(adResultData);
    }
}
