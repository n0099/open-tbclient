package com.win.opensdk;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes6.dex */
public final class w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f37986a;

    public w1(Context context) {
        this.f37986a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        x1.f38002a = new WebView(this.f37986a).getSettings().getUserAgentString();
    }
}
