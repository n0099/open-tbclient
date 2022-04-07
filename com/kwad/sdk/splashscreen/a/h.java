package com.kwad.sdk.splashscreen.a;

import android.content.Context;
import android.widget.Toast;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class h extends Presenter {
    public com.kwad.sdk.splashscreen.g a;
    public com.kwad.sdk.core.download.a.c b;

    public static String b(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.a = (com.kwad.sdk.splashscreen.g) p();
        com.kwad.sdk.core.download.a.c cVar = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.sdk.splashscreen.a.h.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context q = h.this.q();
                if (h.this.q() instanceof ResContext) {
                    q = ((ResContext) h.this.q()).getDelegatedContext();
                }
                if (q != null) {
                    String b = h.b(q);
                    if (b != null) {
                        str = b + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    Toast.makeText(q, str, 0).show();
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
            }
        };
        this.b = cVar;
        this.a.g.a(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        com.kwad.sdk.core.download.a.c cVar = this.b;
        if (cVar != null) {
            this.a.g.b(cVar);
        }
    }
}
