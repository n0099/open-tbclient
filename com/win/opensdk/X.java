package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class X implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f40755a;

    public X(GifImageView gifImageView) {
        this.f40755a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f40755a;
        gifImageView.f40846b = null;
        gifImageView.f40845a = null;
        gifImageView.f40851g = null;
        gifImageView.f40850f = false;
    }
}
