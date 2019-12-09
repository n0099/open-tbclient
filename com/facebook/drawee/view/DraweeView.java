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
    private final a.C0559a keU;
    private float keV;
    private b<DH> keW;
    private boolean keX;

    public DraweeView(Context context) {
        super(context);
        this.keU = new a.C0559a();
        this.keV = 0.0f;
        this.keX = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.keU = new a.C0559a();
        this.keV = 0.0f;
        this.keX = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.keU = new a.C0559a();
        this.keV = 0.0f;
        this.keX = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.keU = new a.C0559a();
        this.keV = 0.0f;
        this.keX = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.keX) {
            this.keX = true;
            this.keW = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.keW.setHierarchy(dh);
        super.setImageDrawable(this.keW.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.keW.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.keW.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.keW.setController(aVar);
        super.setImageDrawable(this.keW.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.keW.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cDV();
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
        cDV();
    }

    protected void cDV() {
        cFh();
    }

    protected void onDetach() {
        cFi();
    }

    protected void cFh() {
        this.keW.cDV();
    }

    protected void cFi() {
        this.keW.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.keW.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.keW.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.keW.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.keW.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.keW.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.keV) {
            this.keV = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.keV;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.keU.width = i;
        this.keU.height = i2;
        a.a(this.keU, this.keV, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.keU.width, this.keU.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.ax(this).q("holder", this.keW != null ? this.keW.toString() : "<no holder set>").toString();
    }
}
