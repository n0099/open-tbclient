package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes6.dex */
public class X implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f37799a;

    public X(GifImageView gifImageView) {
        this.f37799a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f37799a;
        gifImageView.f37890b = null;
        gifImageView.f37889a = null;
        gifImageView.f37895g = null;
        gifImageView.f37894f = false;
    }
}
