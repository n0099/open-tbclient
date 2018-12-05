package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.facebook.common.internal.f;
import com.facebook.drawee.d.b;
import com.facebook.drawee.view.a;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private float mAspectRatio;
    private b<DH> mDraweeHolder;
    private boolean mInitialised;
    private final a.C0363a mMeasureSpec;

    public DraweeView(Context context) {
        super(context);
        this.mMeasureSpec = new a.C0363a();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMeasureSpec = new a.C0363a();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMeasureSpec = new a.C0363a();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMeasureSpec = new a.C0363a();
        this.mAspectRatio = 0.0f;
        this.mInitialised = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.mInitialised) {
            this.mInitialised = true;
            this.mDraweeHolder = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.mDraweeHolder.setHierarchy(dh);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.mDraweeHolder.getHierarchy();
    }

    public boolean hasHierarchy() {
        return this.mDraweeHolder.hasHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.mDraweeHolder.setController(aVar);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mDraweeHolder.getController();
    }

    public boolean hasController() {
        return this.mDraweeHolder.getController() != null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        onAttach();
    }

    protected void onAttach() {
        doAttach();
    }

    protected void onDetach() {
        doDetach();
    }

    protected void doAttach() {
        this.mDraweeHolder.onAttach();
    }

    protected void doDetach() {
        this.mDraweeHolder.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mDraweeHolder.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mDraweeHolder.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mDraweeHolder.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mDraweeHolder.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mDraweeHolder.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.mAspectRatio) {
            this.mAspectRatio = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mMeasureSpec.width = i;
        this.mMeasureSpec.height = i2;
        a.a(this.mMeasureSpec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mMeasureSpec.width, this.mMeasureSpec.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.ao(this).n("holder", this.mDraweeHolder != null ? this.mDraweeHolder.toString() : "<no holder set>").toString();
    }
}
