package com.win.opensdk;

import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class X implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f36973a;

    public X(GifImageView gifImageView) {
        this.f36973a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        GifImageView gifImageView = this.f36973a;
        gifImageView.f37064b = null;
        gifImageView.f37063a = null;
        gifImageView.f37069g = null;
        gifImageView.f37068f = false;
    }
}
