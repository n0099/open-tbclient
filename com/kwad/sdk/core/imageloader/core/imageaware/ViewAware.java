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
/* loaded from: classes8.dex */
public abstract class ViewAware implements ImageAware {
    public static final String WARN_CANT_SET_BITMAP = "Can't set a bitmap into view. You should call ImageLoader on UI thread for it.";
    public static final String WARN_CANT_SET_DRAWABLE = "Can't set a drawable into view. You should call ImageLoader on UI thread for it.";
    public boolean checkActualViewSize;
    public Reference<View> viewRef;

    public ViewAware(View view2) {
        this(view2, true);
    }

    public ViewAware(View view2, boolean z) {
        if (view2 == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.viewRef = new WeakReference(view2);
        this.checkActualViewSize = z;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        View view2 = this.viewRef.get();
        int i = 0;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (this.checkActualViewSize && layoutParams != null && layoutParams.height != -2) {
                i = view2.getHeight();
            }
            return (i > 0 || layoutParams == null) ? i : layoutParams.height;
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getId() {
        View view2 = this.viewRef.get();
        return view2 == null ? super.hashCode() : view2.hashCode();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        return ViewScaleType.CROP;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        View view2 = this.viewRef.get();
        int i = 0;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (this.checkActualViewSize && layoutParams != null && layoutParams.width != -2) {
                i = view2.getWidth();
            }
            return (i > 0 || layoutParams == null) ? i : layoutParams.width;
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public View getWrappedView() {
        return this.viewRef.get();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public boolean isCollected() {
        return this.viewRef.get() == null;
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

    public abstract void setImageBitmapInto(Bitmap bitmap, View view2);

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

    public abstract void setImageDrawableInto(Drawable drawable, View view2);
}
