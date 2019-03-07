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
    private final a.C0338a jEv;
    private float jEw;
    private b<DH> jEx;
    private boolean jEy;

    public DraweeView(Context context) {
        super(context);
        this.jEv = new a.C0338a();
        this.jEw = 0.0f;
        this.jEy = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jEv = new a.C0338a();
        this.jEw = 0.0f;
        this.jEy = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEv = new a.C0338a();
        this.jEw = 0.0f;
        this.jEy = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jEv = new a.C0338a();
        this.jEw = 0.0f;
        this.jEy = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.jEy) {
            this.jEy = true;
            this.jEx = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.jEx.setHierarchy(dh);
        super.setImageDrawable(this.jEx.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.jEx.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.jEx.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.jEx.setController(aVar);
        super.setImageDrawable(this.jEx.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jEx.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cuM();
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
        cuM();
    }

    protected void cuM() {
        cvX();
    }

    protected void onDetach() {
        cvY();
    }

    protected void cvX() {
        this.jEx.cuM();
    }

    protected void cvY() {
        this.jEx.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jEx.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.jEx.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.jEx.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.jEx.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.jEx.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.jEw) {
            this.jEw = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.jEw;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.jEv.width = i;
        this.jEv.height = i2;
        a.a(this.jEv, this.jEw, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.jEv.width, this.jEv.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aD(this).q("holder", this.jEx != null ? this.jEx.toString() : "<no holder set>").toString();
    }
}
