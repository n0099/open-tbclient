package com.win.opensdk;

import android.graphics.Bitmap;
import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes6.dex */
public class W implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f37795a;

    public W(GifImageView gifImageView) {
        this.f37795a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap = this.f37795a.f37890b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GifImageView gifImageView = this.f37795a;
        gifImageView.setImageBitmap(gifImageView.f37890b);
    }
}
