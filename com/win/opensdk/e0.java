package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f39927a;

    public e0(GifImageView gifImageView) {
        this.f39927a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f39927a;
        gifImageView.f39948b = null;
        gifImageView.f39947a = null;
        gifImageView.f39953g = null;
        gifImageView.f39952f = false;
    }
}
