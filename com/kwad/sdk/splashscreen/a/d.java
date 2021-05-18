package com.kwad.sdk.splashscreen.a;

import android.content.Context;
import android.widget.Toast;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class d extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f34014a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.c f34015b;

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
        this.f34014a = (com.kwad.sdk.splashscreen.c) k();
        com.kwad.sdk.core.download.b.c cVar = new com.kwad.sdk.core.download.b.c() { // from class: com.kwad.sdk.splashscreen.a.d.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.b.c, com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context l = d.this.l();
                if (d.this.l() instanceof ResContext) {
                    l = ((ResContext) d.this.l()).getDelegatedContext();
                }
                if (l != null) {
                    String b2 = d.b(l);
                    if (b2 != null) {
                        str = b2 + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    Toast.makeText(l, str, 0).show();
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
        this.f34015b = cVar;
        this.f34014a.f34061f.a(cVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        com.kwad.sdk.core.download.b.c cVar = this.f34015b;
        if (cVar != null) {
            this.f34014a.f34061f.b(cVar);
        }
    }
}
