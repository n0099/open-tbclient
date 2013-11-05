package defpackage;

import android.view.View;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ca  reason: default package */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bw bwVar) {
        this.f394a = bwVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebView webView;
        webView = this.f394a.h;
        webView.reload();
    }
}
