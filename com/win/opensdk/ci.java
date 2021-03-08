package com.win.opensdk;

import android.graphics.Bitmap;
import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes14.dex */
public class ci implements Runnable {
    public final /* synthetic */ GifImageView qlz;

    public ci(GifImageView gifImageView) {
        this.qlz = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap = this.qlz.b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GifImageView gifImageView = this.qlz;
        gifImageView.setImageBitmap(gifImageView.b);
    }
}
