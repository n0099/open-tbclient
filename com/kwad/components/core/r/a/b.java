package com.kwad.components.core.r.a;

import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.k;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.core.l.a {
    public StyleTemplate Sq;
    public k St;
    public com.kwad.components.core.webview.tachikoma.k Su;
    public AdResultData mAdResultData;
    public AdBaseFrameLayout mRootContainer;

    public b(a aVar) {
        super(aVar);
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = c.m(adResultData);
    }
}
