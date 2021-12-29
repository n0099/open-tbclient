package com.kwad.sdk.splashscreen.a;

import android.content.Context;
import android.widget.Toast;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes3.dex */
public class h extends Presenter {
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.c f60074b;

    public static String b(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e2) {
            e2.printStackTrace();
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
                    String b2 = h.b(q);
                    if (b2 != null) {
                        str = b2 + ":已开始下载";
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
            public void onProgressUpdate(int i2) {
            }
        };
        this.f60074b = cVar;
        this.a.f60161g.a(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        com.kwad.sdk.core.download.a.c cVar = this.f60074b;
        if (cVar != null) {
            this.a.f60161g.b(cVar);
        }
    }
}
