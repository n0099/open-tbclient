package com.win.opensdk;

import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes7.dex */
public class x2 implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdvancedWebView f40103a;

    public x2(AdvancedWebView advancedWebView) {
        this.f40103a = advancedWebView;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String guessFileName = URLUtil.guessFileName(str, str3, str4);
        y2 y2Var = this.f40103a.f40092c;
        if (y2Var != null) {
            y2Var.a(str, guessFileName, str4, j, str3, str2);
        }
    }
}
