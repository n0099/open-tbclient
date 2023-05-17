package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.kwad.sdk.utils.t;
/* loaded from: classes9.dex */
public final class l extends e {
    public com.kwad.sdk.core.download.kwai.a zn;

    public static String Z(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return context.getResources().getString(packageInfo.applicationInfo.labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.sdk.core.download.kwai.a aVar = new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.l.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
            }

            @Override // com.kwad.sdk.core.download.kwai.a, com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadStarted() {
                String str;
                super.onDownloadStarted();
                Context context = l.this.getContext();
                if (context != null) {
                    String Z = l.Z(context);
                    if (Z != null) {
                        str = Z + ":已开始下载";
                    } else {
                        str = "已开始下载";
                    }
                    t.z(context, str);
                }
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
        };
        this.zn = aVar;
        this.yF.mApkDownloadHelper.b(aVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.sdk.core.download.kwai.a aVar = this.zn;
        if (aVar != null) {
            this.yF.mApkDownloadHelper.c(aVar);
        }
    }
}
