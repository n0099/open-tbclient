package com.win.opensdk;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes14.dex */
public final class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8136a;

    public by(Context context) {
        this.f8136a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        cb.f8139a = new WebView(this.f8136a).getSettings().getUserAgentString();
    }
}
