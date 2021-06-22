package com.win.opensdk;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes7.dex */
public final class w1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f40942a;

    public w1(Context context) {
        this.f40942a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        x1.f40958a = new WebView(this.f40942a).getSettings().getUserAgentString();
    }
}
