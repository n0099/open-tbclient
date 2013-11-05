package defpackage;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bx  reason: default package */
/* loaded from: classes.dex */
public class bx extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f390a;

    private bx(bw bwVar) {
        this.f390a = bwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bx(bw bwVar, bz bzVar) {
        this(bwVar);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        this.f390a.onBackPressed();
    }
}
