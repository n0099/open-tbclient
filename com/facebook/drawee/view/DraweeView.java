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
/* loaded from: classes14.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean oSA = false;
    private b<DH> oSe;
    private final a.C0978a oSw;
    private float oSx;
    private boolean oSy;
    private boolean oSz;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        oSA = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.oSw = new a.C0978a();
        this.oSx = 0.0f;
        this.oSy = false;
        this.oSz = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oSw = new a.C0978a();
        this.oSx = 0.0f;
        this.oSy = false;
        this.oSz = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oSw = new a.C0978a();
        this.oSx = 0.0f;
        this.oSy = false;
        this.oSz = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.oSy) {
            this.oSy = true;
            this.oSe = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.oSz = (!oSA || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.oSe.setHierarchy(dh);
        super.setImageDrawable(this.oSe.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.oSe.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.oSe.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.oSe.setController(aVar);
        super.setImageDrawable(this.oSe.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.oSe.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        emI();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        emI();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        emI();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        emI();
        onAttach();
    }

    protected void onAttach() {
        emG();
    }

    protected void onDetach() {
        emH();
    }

    protected void emG() {
        this.oSe.onAttach();
    }

    protected void emH() {
        this.oSe.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oSe.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.oSe.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.oSe.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.oSe.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.oSe.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.oSx) {
            this.oSx = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.oSx;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.oSz = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.oSw.width = i;
        this.oSw.height = i2;
        a.a(this.oSw, this.oSx, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.oSw.width, this.oSw.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        emI();
    }

    private void emI() {
        Drawable drawable;
        if (this.oSz && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.ba(this).F("holder", this.oSe != null ? this.oSe.toString() : "<no holder set>").toString();
    }
}
