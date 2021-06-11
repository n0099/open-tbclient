package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class X implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f40652a;

    public X(GifImageView gifImageView) {
        this.f40652a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f40652a;
        gifImageView.f40743b = null;
        gifImageView.f40742a = null;
        gifImageView.f40748g = null;
        gifImageView.f40747f = false;
    }
}
