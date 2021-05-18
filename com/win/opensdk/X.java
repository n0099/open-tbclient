package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class X implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f37044a;

    public X(GifImageView gifImageView) {
        this.f37044a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f37044a;
        gifImageView.f37135b = null;
        gifImageView.f37134a = null;
        gifImageView.f37140g = null;
        gifImageView.f37139f = false;
    }
}
