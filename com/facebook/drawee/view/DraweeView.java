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
    private final a.C0564a kfL;
    private float kfM;
    private b<DH> kfN;
    private boolean kfO;

    public DraweeView(Context context) {
        super(context);
        this.kfL = new a.C0564a();
        this.kfM = 0.0f;
        this.kfO = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kfL = new a.C0564a();
        this.kfM = 0.0f;
        this.kfO = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kfL = new a.C0564a();
        this.kfM = 0.0f;
        this.kfO = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.kfL = new a.C0564a();
        this.kfM = 0.0f;
        this.kfO = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.kfO) {
            this.kfO = true;
            this.kfN = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.kfN.setHierarchy(dh);
        super.setImageDrawable(this.kfN.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.kfN.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.kfN.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.kfN.setController(aVar);
        super.setImageDrawable(this.kfN.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.kfN.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cDX();
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
        cDX();
    }

    protected void cDX() {
        cFj();
    }

    protected void onDetach() {
        cFk();
    }

    protected void cFj() {
        this.kfN.cDX();
    }

    protected void cFk() {
        this.kfN.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kfN.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.kfN.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.kfN.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.kfN.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.kfN.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.kfM) {
            this.kfM = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.kfM;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.kfL.width = i;
        this.kfL.height = i2;
        a.a(this.kfL, this.kfM, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.kfL.width, this.kfL.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.ax(this).q("holder", this.kfN != null ? this.kfN.toString() : "<no holder set>").toString();
    }
}
