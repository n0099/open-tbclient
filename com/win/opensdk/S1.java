package com.win.opensdk;

import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import com.win.opensdk.webviewbase.AdvancedWebView;
/* loaded from: classes7.dex */
public class S1 implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AdvancedWebView f40724a;

    public S1(AdvancedWebView advancedWebView) {
        this.f40724a = advancedWebView;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        String guessFileName = URLUtil.guessFileName(str, str3, str4);
        T1 t1 = this.f40724a.f40945c;
        if (t1 != null) {
            t1.a(str, guessFileName, str4, j, str3, str2);
        }
    }
}
