package com.win.opensdk;

import android.graphics.Bitmap;
import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class W implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f40648a;

    public W(GifImageView gifImageView) {
        this.f40648a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap = this.f40648a.f40743b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GifImageView gifImageView = this.f40648a;
        gifImageView.setImageBitmap(gifImageView.f40743b);
    }
}
