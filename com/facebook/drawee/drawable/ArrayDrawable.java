package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ArrayDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable {
    public final DrawableParent[] mDrawableParents;
    public final Drawable[] mLayers;
    public TransformCallback mTransformCallback;
    public final DrawableProperties mDrawableProperties = new DrawableProperties();
    public final Rect mTmpRect = new Rect();
    public boolean mIsStateful = false;
    public boolean mIsStatefulCalculated = false;
    public boolean mIsMutated = false;

    public ArrayDrawable(Drawable[] drawableArr) {
        int i2 = 0;
        Preconditions.checkNotNull(drawableArr);
        this.mLayers = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.mLayers;
            if (i2 < drawableArr2.length) {
                DrawableUtils.setCallbacks(drawableArr2[i2], this, this);
                i2++;
            } else {
                this.mDrawableParents = new DrawableParent[drawableArr2.length];
                return;
            }
        }
    }

    private DrawableParent createDrawableParentForIndex(final int i2) {
        return new DrawableParent() { // from class: com.facebook.drawee.drawable.ArrayDrawable.1
            @Override // com.facebook.drawee.drawable.DrawableParent
            public Drawable getDrawable() {
                return ArrayDrawable.this.getDrawable(i2);
            }

            @Override // com.facebook.drawee.drawable.DrawableParent
            public Drawable setDrawable(Drawable drawable) {
                return ArrayDrawable.this.setDrawable(i2, drawable);
            }
        };
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.draw(canvas);
            }
            i2++;
        }
    }

    @Nullable
    public Drawable getDrawable(int i2) {
        Preconditions.checkArgument(i2 >= 0);
        Preconditions.checkArgument(i2 < this.mLayers.length);
        return this.mLayers[i2];
    }

    public DrawableParent getDrawableParentForIndex(int i2) {
        Preconditions.checkArgument(i2 >= 0);
        Preconditions.checkArgument(i2 < this.mDrawableParents.length);
        DrawableParent[] drawableParentArr = this.mDrawableParents;
        if (drawableParentArr[i2] == null) {
            drawableParentArr[i2] = createDrawableParentForIndex(i2);
        }
        return this.mDrawableParents[i2];
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicHeight());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicWidth());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    public int getNumberOfLayers() {
        return this.mLayers.length;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mLayers.length == 0) {
            return -2;
        }
        int i2 = -1;
        int i3 = 1;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i3 >= drawableArr.length) {
                return i2;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                i2 = Drawable.resolveOpacity(i2, drawable.getOpacity());
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int i2 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.mTmpRect;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i2++;
        }
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getRootBounds(RectF rectF) {
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getRootBounds(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getTransform(Matrix matrix) {
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.mIsStatefulCalculated) {
            this.mIsStateful = false;
            int i2 = 0;
            while (true) {
                Drawable[] drawableArr = this.mLayers;
                boolean z = true;
                if (i2 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i2];
                boolean z2 = this.mIsStateful;
                if (drawable == null || !drawable.isStateful()) {
                    z = false;
                }
                this.mIsStateful = z2 | z;
                i2++;
            }
            this.mIsStatefulCalculated = true;
        }
        return this.mIsStateful;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.mutate();
                }
                i2++;
            } else {
                this.mIsMutated = true;
                return this;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        int i3 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i3 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null && drawable.setLevel(i2)) {
                z = true;
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.mDrawableProperties.setAlpha(i2);
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i3 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                drawable.setAlpha(i2);
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mDrawableProperties.setDither(z);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setDither(z);
            }
            i2++;
        }
    }

    @Nullable
    public Drawable setDrawable(int i2, @Nullable Drawable drawable) {
        Preconditions.checkArgument(i2 >= 0);
        Preconditions.checkArgument(i2 < this.mLayers.length);
        Drawable drawable2 = this.mLayers[i2];
        if (drawable != drawable2) {
            if (drawable != null && this.mIsMutated) {
                drawable.mutate();
            }
            DrawableUtils.setCallbacks(this.mLayers[i2], null, null);
            DrawableUtils.setCallbacks(drawable, null, null);
            DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
            DrawableUtils.copyProperties(drawable, this);
            DrawableUtils.setCallbacks(drawable, this, this);
            this.mIsStatefulCalculated = false;
            this.mLayers[i2] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mDrawableProperties.setFilterBitmap(z);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f2, float f3) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setHotspot(f2, f3);
            }
            i2++;
        }
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
