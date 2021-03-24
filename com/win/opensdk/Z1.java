package com.win.opensdk;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes7.dex */
public final class Z1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f39851a;

    public Z1(Context context) {
        this.f39851a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        a2.f39865a = new WebView(this.f39851a).getSettings().getUserAgentString();
    }
}
