package com.win.opensdk;

import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes14.dex */
public class ey implements DownloadListener {
    public final /* synthetic */ AdvancedWebView qlt;

    public ey(AdvancedWebView advancedWebView) {
        this.qlt = advancedWebView;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String guessFileName = URLUtil.guessFileName(str, str3, str4);
        fb fbVar = this.qlt.qmu;
        if (fbVar != null) {
            fbVar.b(str, guessFileName, str4, j, str3, str2);
        }
    }
}
