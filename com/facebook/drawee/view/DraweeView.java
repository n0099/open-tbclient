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
    private final a.C0453a jWO;
    private float jWP;
    private b<DH> jWQ;
    private boolean jWR;

    public DraweeView(Context context) {
        super(context);
        this.jWO = new a.C0453a();
        this.jWP = 0.0f;
        this.jWR = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jWO = new a.C0453a();
        this.jWP = 0.0f;
        this.jWR = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jWO = new a.C0453a();
        this.jWP = 0.0f;
        this.jWR = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jWO = new a.C0453a();
        this.jWP = 0.0f;
        this.jWR = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.jWR) {
            this.jWR = true;
            this.jWQ = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.jWQ.setHierarchy(dh);
        super.setImageDrawable(this.jWQ.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.jWQ.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.jWQ.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.jWQ.setController(aVar);
        super.setImageDrawable(this.jWQ.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jWQ.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cCO();
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
        cCO();
    }

    protected void cCO() {
        cDZ();
    }

    protected void onDetach() {
        cEa();
    }

    protected void cDZ() {
        this.jWQ.cCO();
    }

    protected void cEa() {
        this.jWQ.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jWQ.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.jWQ.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.jWQ.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.jWQ.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.jWQ.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.jWP) {
            this.jWP = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.jWP;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.jWO.width = i;
        this.jWO.height = i2;
        a.a(this.jWO, this.jWP, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.jWO.width, this.jWO.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aC(this).t("holder", this.jWQ != null ? this.jWQ.toString() : "<no holder set>").toString();
    }
}
