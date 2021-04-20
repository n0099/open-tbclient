package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f40216a;

    public e0(GifImageView gifImageView) {
        this.f40216a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f40216a;
        gifImageView.f40237b = null;
        gifImageView.f40236a = null;
        gifImageView.f40242g = null;
        gifImageView.f40241f = false;
    }
}
