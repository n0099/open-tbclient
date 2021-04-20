package com.win.opensdk;

import android.graphics.Bitmap;
import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f40204a;

    public d0(GifImageView gifImageView) {
        this.f40204a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap = this.f40204a.f40237b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GifImageView gifImageView = this.f40204a;
        gifImageView.setImageBitmap(gifImageView.f40237b);
    }
}
