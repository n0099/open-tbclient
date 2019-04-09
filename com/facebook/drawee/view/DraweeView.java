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
    private final a.C0434a jEb;
    private float jEc;
    private b<DH> jEd;
    private boolean jEe;

    public DraweeView(Context context) {
        super(context);
        this.jEb = new a.C0434a();
        this.jEc = 0.0f;
        this.jEe = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jEb = new a.C0434a();
        this.jEc = 0.0f;
        this.jEe = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEb = new a.C0434a();
        this.jEc = 0.0f;
        this.jEe = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jEb = new a.C0434a();
        this.jEc = 0.0f;
        this.jEe = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.jEe) {
            this.jEe = true;
            this.jEd = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.jEd.setHierarchy(dh);
        super.setImageDrawable(this.jEd.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.jEd.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.jEd.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.jEd.setController(aVar);
        super.setImageDrawable(this.jEd.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jEd.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cuS();
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
        cuS();
    }

    protected void cuS() {
        cwd();
    }

    protected void onDetach() {
        cwe();
    }

    protected void cwd() {
        this.jEd.cuS();
    }

    protected void cwe() {
        this.jEd.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jEd.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.jEd.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.jEd.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.jEd.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.jEd.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.jEc) {
            this.jEc = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.jEc;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.jEb.width = i;
        this.jEb.height = i2;
        a.a(this.jEb, this.jEc, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.jEb.width, this.jEb.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aA(this).q("holder", this.jEd != null ? this.jEd.toString() : "<no holder set>").toString();
    }
}
