package com.kwad.sdk.core.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.kwad.sdk.core.imageloader.core.assist.ImageSize;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
/* loaded from: classes10.dex */
public class NonViewAware implements ImageAware {
    public final ImageSize imageSize;
    public final String imageUri;
    public final ViewScaleType scaleType;

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public View getWrappedView() {
        return null;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }

    public NonViewAware(ImageSize imageSize, ViewScaleType viewScaleType) {
        this(null, imageSize, viewScaleType);
    }

    public NonViewAware(String str, ImageSize imageSize, ViewScaleType viewScaleType) {
        if (imageSize != null) {
            if (viewScaleType != null) {
                this.imageUri = str;
                this.imageSize = imageSize;
                this.scaleType = viewScaleType;
                return;
            }
            throw new IllegalArgumentException("scaleType must not be null");
        }
        throw new IllegalArgumentException("imageSize must not be null");
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        return this.imageSize.getHeight();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getId() {
        if (TextUtils.isEmpty(this.imageUri)) {
            return super.hashCode();
        }
        return this.imageUri.hashCode();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        return this.scaleType;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        return this.imageSize.getWidth();
    }
}
