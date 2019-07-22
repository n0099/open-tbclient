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
    private final a.C0452a kdW;
    private float kdX;
    private b<DH> kdY;
    private boolean kdZ;

    public DraweeView(Context context) {
        super(context);
        this.kdW = new a.C0452a();
        this.kdX = 0.0f;
        this.kdZ = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdW = new a.C0452a();
        this.kdX = 0.0f;
        this.kdZ = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdW = new a.C0452a();
        this.kdX = 0.0f;
        this.kdZ = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.kdW = new a.C0452a();
        this.kdX = 0.0f;
        this.kdZ = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.kdZ) {
            this.kdZ = true;
            this.kdY = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.kdY.setHierarchy(dh);
        super.setImageDrawable(this.kdY.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.kdY.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.kdY.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.kdY.setController(aVar);
        super.setImageDrawable(this.kdY.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.kdY.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cFQ();
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
        cFQ();
    }

    protected void cFQ() {
        cHd();
    }

    protected void onDetach() {
        cHe();
    }

    protected void cHd() {
        this.kdY.cFQ();
    }

    protected void cHe() {
        this.kdY.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kdY.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.kdY.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.kdY.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.kdY.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.kdY.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.kdX) {
            this.kdX = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.kdX;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.kdW.width = i;
        this.kdW.height = i2;
        a.a(this.kdW, this.kdX, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.kdW.width, this.kdW.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aC(this).t("holder", this.kdY != null ? this.kdY.toString() : "<no holder set>").toString();
    }
}
