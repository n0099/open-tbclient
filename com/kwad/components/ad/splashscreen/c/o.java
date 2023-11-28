package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import com.kwad.sdk.utils.v;
/* loaded from: classes10.dex */
public final class o extends e {
    public com.kwad.sdk.core.download.a.a DS;

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.download.a.a aVar = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.splashscreen.c.o.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
            }

            @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = o.this.getContext();
                if (context != null) {
                    String bR = com.kwad.sdk.utils.k.bR(context);
                    if (bR != null) {
                        str = bR + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    v.O(context, str);
                }
            }
        };
        this.DS = aVar;
        this.Df.mApkDownloadHelper.b(aVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.download.a.a aVar = this.DS;
        if (aVar != null) {
            this.Df.mApkDownloadHelper.c(aVar);
        }
    }
}
