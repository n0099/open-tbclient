package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class d extends e<Drawable> {
    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.request.a.e
    /* renamed from: d */
    public void a(@Nullable Drawable drawable) {
        ((ImageView) this.f10346a).setImageDrawable(drawable);
    }
}
