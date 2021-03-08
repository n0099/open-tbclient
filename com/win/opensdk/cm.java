package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes14.dex */
public class cm implements Runnable {
    public final /* synthetic */ GifImageView qlz;

    public cm(GifImageView gifImageView) {
        this.qlz = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.qlz;
        gifImageView.b = null;
        gifImageView.qlH = null;
        gifImageView.g = null;
        gifImageView.f = false;
    }
}
