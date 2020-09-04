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
/* loaded from: classes4.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean nqV = false;
    private final a.C0869a nqR;
    private float nqS;
    private boolean nqT;
    private boolean nqU;
    private b<DH> nqy;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        nqV = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.nqR = new a.C0869a();
        this.nqS = 0.0f;
        this.nqT = false;
        this.nqU = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nqR = new a.C0869a();
        this.nqS = 0.0f;
        this.nqT = false;
        this.nqU = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nqR = new a.C0869a();
        this.nqS = 0.0f;
        this.nqT = false;
        this.nqU = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.nqT) {
            this.nqT = true;
            this.nqy = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.nqU = (!nqV || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.nqy.setHierarchy(dh);
        super.setImageDrawable(this.nqy.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.nqy.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.nqy.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.nqy.setController(aVar);
        super.setImageDrawable(this.nqy.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.nqy.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dRo();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dRo();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dRo();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dRo();
        onAttach();
    }

    protected void onAttach() {
        dRm();
    }

    protected void onDetach() {
        dRn();
    }

    protected void dRm() {
        this.nqy.onAttach();
    }

    protected void dRn() {
        this.nqy.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nqy.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.nqy.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.nqy.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.nqy.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.nqy.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.nqS) {
            this.nqS = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.nqS;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.nqU = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.nqR.width = i;
        this.nqR.height = i2;
        a.a(this.nqR, this.nqS, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.nqR.width, this.nqR.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dRo();
    }

    private void dRo() {
        Drawable drawable;
        if (this.nqU && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aQ(this).E("holder", this.nqy != null ? this.nqy.toString() : "<no holder set>").toString();
    }
}
