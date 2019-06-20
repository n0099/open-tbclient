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
    private final a.C0453a jWS;
    private float jWT;
    private b<DH> jWU;
    private boolean jWV;

    public DraweeView(Context context) {
        super(context);
        this.jWS = new a.C0453a();
        this.jWT = 0.0f;
        this.jWV = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jWS = new a.C0453a();
        this.jWT = 0.0f;
        this.jWV = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jWS = new a.C0453a();
        this.jWT = 0.0f;
        this.jWV = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jWS = new a.C0453a();
        this.jWT = 0.0f;
        this.jWV = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.jWV) {
            this.jWV = true;
            this.jWU = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.jWU.setHierarchy(dh);
        super.setImageDrawable(this.jWU.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.jWU.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.jWU.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.jWU.setController(aVar);
        super.setImageDrawable(this.jWU.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jWU.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cCP();
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
        cCP();
    }

    protected void cCP() {
        cEa();
    }

    protected void onDetach() {
        cEb();
    }

    protected void cEa() {
        this.jWU.cCP();
    }

    protected void cEb() {
        this.jWU.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jWU.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.jWU.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.jWU.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.jWU.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.jWU.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.jWT) {
            this.jWT = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.jWT;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.jWS.width = i;
        this.jWS.height = i2;
        a.a(this.jWS, this.jWT, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.jWS.width, this.jWS.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aC(this).t("holder", this.jWU != null ? this.jWU.toString() : "<no holder set>").toString();
    }
}
