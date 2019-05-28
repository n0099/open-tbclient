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
    private final a.C0453a jWP;
    private float jWQ;
    private b<DH> jWR;
    private boolean jWS;

    public DraweeView(Context context) {
        super(context);
        this.jWP = new a.C0453a();
        this.jWQ = 0.0f;
        this.jWS = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jWP = new a.C0453a();
        this.jWQ = 0.0f;
        this.jWS = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jWP = new a.C0453a();
        this.jWQ = 0.0f;
        this.jWS = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jWP = new a.C0453a();
        this.jWQ = 0.0f;
        this.jWS = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.jWS) {
            this.jWS = true;
            this.jWR = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.jWR.setHierarchy(dh);
        super.setImageDrawable(this.jWR.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.jWR.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.jWR.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.jWR.setController(aVar);
        super.setImageDrawable(this.jWR.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jWR.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cCQ();
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
        cCQ();
    }

    protected void cCQ() {
        cEb();
    }

    protected void onDetach() {
        cEc();
    }

    protected void cEb() {
        this.jWR.cCQ();
    }

    protected void cEc() {
        this.jWR.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jWR.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.jWR.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.jWR.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.jWR.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.jWR.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.jWQ) {
            this.jWQ = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.jWQ;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.jWP.width = i;
        this.jWP.height = i2;
        a.a(this.jWP, this.jWQ, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.jWP.width, this.jWP.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aC(this).t("holder", this.jWR != null ? this.jWR.toString() : "<no holder set>").toString();
    }
}
