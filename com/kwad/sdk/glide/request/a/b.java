package com.kwad.sdk.glide.request.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.request.a.e
    public void a(Bitmap bitmap) {
        ((ImageView) this.f10646a).setImageBitmap(bitmap);
    }
}
