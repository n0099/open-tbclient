package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f40311a;

    public e0(GifImageView gifImageView) {
        this.f40311a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f40311a;
        gifImageView.f40332b = null;
        gifImageView.f40331a = null;
        gifImageView.f40337g = null;
        gifImageView.f40336f = false;
    }
}
