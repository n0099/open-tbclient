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
    private final a.C0458a kfd;
    private float kfe;
    private b<DH> kff;
    private boolean kfg;

    public DraweeView(Context context) {
        super(context);
        this.kfd = new a.C0458a();
        this.kfe = 0.0f;
        this.kfg = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kfd = new a.C0458a();
        this.kfe = 0.0f;
        this.kfg = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kfd = new a.C0458a();
        this.kfe = 0.0f;
        this.kfg = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.kfd = new a.C0458a();
        this.kfe = 0.0f;
        this.kfg = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.kfg) {
            this.kfg = true;
            this.kff = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.kff.setHierarchy(dh);
        super.setImageDrawable(this.kff.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.kff.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.kff.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.kff.setController(aVar);
        super.setImageDrawable(this.kff.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.kff.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cGl();
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
        cGl();
    }

    protected void cGl() {
        cHy();
    }

    protected void onDetach() {
        cHz();
    }

    protected void cHy() {
        this.kff.cGl();
    }

    protected void cHz() {
        this.kff.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kff.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.kff.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.kff.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.kff.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.kff.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.kfe) {
            this.kfe = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.kfe;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.kfd.width = i;
        this.kfd.height = i2;
        a.a(this.kfd, this.kfe, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.kfd.width, this.kfd.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aC(this).t("holder", this.kff != null ? this.kff.toString() : "<no holder set>").toString();
    }
}
