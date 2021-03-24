package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f39926a;

    public e0(GifImageView gifImageView) {
        this.f39926a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f39926a;
        gifImageView.f39947b = null;
        gifImageView.f39946a = null;
        gifImageView.f39952g = null;
        gifImageView.f39951f = false;
    }
}
