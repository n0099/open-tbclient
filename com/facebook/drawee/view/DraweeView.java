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
    private final a.C0341a jEO;
    private float jEP;
    private b<DH> jEQ;
    private boolean jER;

    public DraweeView(Context context) {
        super(context);
        this.jEO = new a.C0341a();
        this.jEP = 0.0f;
        this.jER = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jEO = new a.C0341a();
        this.jEP = 0.0f;
        this.jER = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEO = new a.C0341a();
        this.jEP = 0.0f;
        this.jER = false;
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.jEO = new a.C0341a();
        this.jEP = 0.0f;
        this.jER = false;
        init(context);
    }

    private void init(Context context) {
        ColorStateList imageTintList;
        if (!this.jER) {
            this.jER = true;
            this.jEQ = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21 && (imageTintList = getImageTintList()) != null) {
                setColorFilter(imageTintList.getDefaultColor());
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.jEQ.setHierarchy(dh);
        super.setImageDrawable(this.jEQ.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.jEQ.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.jEQ.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.jEQ.setController(aVar);
        super.setImageDrawable(this.jEQ.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.jEQ.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cuW();
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
        cuW();
    }

    protected void cuW() {
        cwh();
    }

    protected void onDetach() {
        cwi();
    }

    protected void cwh() {
        this.jEQ.cuW();
    }

    protected void cwi() {
        this.jEQ.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jEQ.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.jEQ.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.jEQ.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.jEQ.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.jEQ.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.jEP) {
            this.jEP = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.jEP;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.jEO.width = i;
        this.jEO.height = i2;
        a.a(this.jEO, this.jEP, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.jEO.width, this.jEO.height);
    }

    @Override // android.view.View
    public String toString() {
        return f.aE(this).q("holder", this.jEQ != null ? this.jEQ.toString() : "<no holder set>").toString();
    }
}
