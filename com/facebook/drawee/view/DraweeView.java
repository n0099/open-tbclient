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
/* loaded from: classes15.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean oQX = false;
    private b<DH> oQB;
    private final a.C0975a oQT;
    private float oQU;
    private boolean oQV;
    private boolean oQW;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        oQX = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.oQT = new a.C0975a();
        this.oQU = 0.0f;
        this.oQV = false;
        this.oQW = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oQT = new a.C0975a();
        this.oQU = 0.0f;
        this.oQV = false;
        this.oQW = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oQT = new a.C0975a();
        this.oQU = 0.0f;
        this.oQV = false;
        this.oQW = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.oQV) {
            this.oQV = true;
            this.oQB = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.oQW = (!oQX || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.oQB.setHierarchy(dh);
        super.setImageDrawable(this.oQB.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.oQB.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.oQB.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.oQB.setController(aVar);
        super.setImageDrawable(this.oQB.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.oQB.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        emK();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        emK();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        emK();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        emK();
        onAttach();
    }

    protected void onAttach() {
        emI();
    }

    protected void onDetach() {
        emJ();
    }

    protected void emI() {
        this.oQB.onAttach();
    }

    protected void emJ() {
        this.oQB.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oQB.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.oQB.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.oQB.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.oQB.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.oQB.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.oQU) {
            this.oQU = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.oQU;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.oQW = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.oQT.width = i;
        this.oQT.height = i2;
        a.a(this.oQT, this.oQU, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.oQT.width, this.oQT.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        emK();
    }

    private void emK() {
        Drawable drawable;
        if (this.oQW && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aZ(this).F("holder", this.oQB != null ? this.oQB.toString() : "<no holder set>").toString();
    }
}
