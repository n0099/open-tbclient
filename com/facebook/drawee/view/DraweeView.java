package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.internal.f;
import com.facebook.drawee.d.b;
import com.facebook.drawee.view.a;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean mOz = false;
    private b<DH> mOc;
    private final a.C0801a mOv;
    private float mOw;
    private boolean mOx;
    private boolean mOy;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        mOz = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.mOv = new a.C0801a();
        this.mOw = 0.0f;
        this.mOx = false;
        this.mOy = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOv = new a.C0801a();
        this.mOw = 0.0f;
        this.mOx = false;
        this.mOy = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOv = new a.C0801a();
        this.mOw = 0.0f;
        this.mOx = false;
        this.mOy = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.mOx) {
            this.mOx = true;
            this.mOc = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.mOy = (!mOz || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.mOc.setHierarchy(dh);
        super.setImageDrawable(this.mOc.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.mOc.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.mOc.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.mOc.setController(aVar);
        super.setImageDrawable(this.mOc.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mOc.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dBP();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dBP();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dBP();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dBP();
        onAttach();
    }

    protected void onAttach() {
        dBN();
    }

    protected void onDetach() {
        dBO();
    }

    protected void dBN() {
        this.mOc.onAttach();
    }

    protected void dBO() {
        this.mOc.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mOc.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mOc.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mOc.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mOc.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mOc.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.mOw) {
            this.mOw = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.mOw;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mOy = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mOv.width = i;
        this.mOv.height = i2;
        a.a(this.mOv, this.mOw, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mOv.width, this.mOv.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dBP();
    }

    private void dBP() {
        Drawable drawable;
        if (this.mOy && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aO(this).F("holder", this.mOc != null ? this.mOc.toString() : "<no holder set>").toString();
    }
}
