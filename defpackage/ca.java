package defpackage;

import android.view.View;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ca  reason: default package */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ bw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bw bwVar) {
        this.a = bwVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        webView = this.a.h;
        webView.reload();
    }
}
