package com.win.opensdk;

import android.graphics.Bitmap;
import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class W implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f40751a;

    public W(GifImageView gifImageView) {
        this.f40751a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap = this.f40751a.f40846b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GifImageView gifImageView = this.f40751a;
        gifImageView.setImageBitmap(gifImageView.f40846b);
    }
}
