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
    private final a.C0469a khA;
    private float khB;
    private b<DH> khC;
    private boolean khD;

    public DraweeView(Context context) {
        super(context);
        this.khA = new a.C0469a();
        this.khB = 0.0f;
        this.khD = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.khA = new a.C0469a();
        this.khB = 0.0f;
        this.khD = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.khA = new a.C0469a();
        this.khB = 0.0f;
        this.khD = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.khA = new a.C0469a();
        this.khB = 0.0f;
        this.khD = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.khD) {
            this.khD = true;
            this.khC = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.khC.setHierarchy(dh);
        super.setImageDrawable(this.khC.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.khC.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.khC.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.khC.setController(aVar);
        super.setImageDrawable(this.khC.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.khC.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cGZ();
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
        cGZ();
    }

    protected void cGZ() {
        cIm();
    }

    protected void onDetach() {
        cIn();
    }

    protected void cIm() {
        this.khC.cGZ();
    }

    protected void cIn() {
        this.khC.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.khC.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.khC.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.khC.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.khC.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.khC.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.khB) {
            this.khB = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.khB;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.khA.width = i;
        this.khA.height = i2;
        a.a(this.khA, this.khB, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.khA.width, this.khA.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aC(this).t("holder", this.khC != null ? this.khC.toString() : "<no holder set>").toString();
    }
}
