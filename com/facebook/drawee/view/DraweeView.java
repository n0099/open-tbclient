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
    private static boolean pHa = false;
    private final a.C1065a pGV;
    private float pGW;
    private b<DH> pGX;
    private boolean pGY;
    private boolean pGZ;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        pHa = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.pGV = new a.C1065a();
        this.pGW = 0.0f;
        this.pGY = false;
        this.pGZ = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pGV = new a.C1065a();
        this.pGW = 0.0f;
        this.pGY = false;
        this.pGZ = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pGV = new a.C1065a();
        this.pGW = 0.0f;
        this.pGY = false;
        this.pGZ = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.pGY) {
            this.pGY = true;
            this.pGX = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.pGZ = (!pHa || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.pGX.setHierarchy(dh);
        super.setImageDrawable(this.pGX.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.pGX.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.pGX.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.pGX.setController(aVar);
        super.setImageDrawable(this.pGX.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pGX.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        evv();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        evv();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        evv();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        evv();
        onAttach();
    }

    protected void onAttach() {
        evt();
    }

    protected void onDetach() {
        evu();
    }

    protected void evt() {
        this.pGX.onAttach();
    }

    protected void evu() {
        this.pGX.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pGX.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.pGX.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.pGX.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.pGX.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.pGX.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.pGW) {
            this.pGW = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.pGW;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.pGZ = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.pGV.width = i;
        this.pGV.height = i2;
        a.a(this.pGV, this.pGW, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.pGV.width, this.pGV.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        evv();
    }

    private void evv() {
        Drawable drawable;
        if (this.pGZ && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.bd(this).G("holder", this.pGX != null ? this.pGX.toString() : "<no holder set>").toString();
    }
}
