package com.kwad.sdk.core.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.core.imageloader.utils.L;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public abstract class ViewAware implements ImageAware {
    public static final String WARN_CANT_SET_BITMAP = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
    public static final String WARN_CANT_SET_DRAWABLE = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
    public boolean checkActualViewSize;
    public Reference<View> viewRef;

    public abstract void setImageBitmapInto(Bitmap bitmap, View view2);

    public abstract void setImageDrawableInto(Drawable drawable, View view2);

    public ViewAware(View view2) {
        this(view2, true);
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean setImageBitmap(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view2 = this.viewRef.get();
            if (view2 != null) {
                setImageBitmapInto(bitmap, view2);
                return true;
            }
        } else {
            L.w(WARN_CANT_SET_BITMAP, new Object[0]);
        }
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean setImageDrawable(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view2 = this.viewRef.get();
            if (view2 != null) {
                setImageDrawableInto(drawable, view2);
                return true;
            }
        } else {
            L.w(WARN_CANT_SET_DRAWABLE, new Object[0]);
        }
        return false;
    }

    public ViewAware(View view2, boolean z) {
        if (view2 != null) {
            this.viewRef = new WeakReference(view2);
            this.checkActualViewSize = z;
            return;
        }
        throw new IllegalArgumentException("view must not be null");
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        View view2 = this.viewRef.get();
        int i = 0;
        if (view2 == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (this.checkActualViewSize && layoutParams != null && layoutParams.height != -2) {
            i = view2.getHeight();
        }
        if (i <= 0 && layoutParams != null) {
            return layoutParams.height;
        }
        return i;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getId() {
        View view2 = this.viewRef.get();
        if (view2 == null) {
            return super.hashCode();
        }
        return view2.hashCode();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        View view2 = this.viewRef.get();
        int i = 0;
        if (view2 == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (this.checkActualViewSize && layoutParams != null && layoutParams.width != -2) {
            i = view2.getWidth();
        }
        if (i <= 0 && layoutParams != null) {
            return layoutParams.width;
        }
        return i;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public View getWrappedView() {
        return this.viewRef.get();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        if (this.viewRef.get() == null) {
            return true;
        }
        return false;
    }
}
