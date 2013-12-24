package defpackage;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bx  reason: default package */
/* loaded from: classes.dex */
public class bx extends WebChromeClient {
    final /* synthetic */ bw a;

    private bx(bw bwVar) {
        this.a = bwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bx(bw bwVar, bz bzVar) {
        this(bwVar);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        this.a.onBackPressed();
    }
}
