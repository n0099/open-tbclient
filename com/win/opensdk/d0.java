package com.win.opensdk;

import android.graphics.Bitmap;
import com.win.opensdk.image.gif2.GifImageView;
/* loaded from: classes7.dex */
public class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GifImageView f40299a;

    public d0(GifImageView gifImageView) {
        this.f40299a = gifImageView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap = this.f40299a.f40332b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        GifImageView gifImageView = this.f40299a;
        gifImageView.setImageBitmap(gifImageView.f40332b);
    }
}
