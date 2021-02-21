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
    private static boolean pEV = false;
    private final a.C1050a pEQ;
    private float pER;
    private b<DH> pES;
    private boolean pET;
    private boolean pEU;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        pEV = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.pEQ = new a.C1050a();
        this.pER = 0.0f;
        this.pET = false;
        this.pEU = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pEQ = new a.C1050a();
        this.pER = 0.0f;
        this.pET = false;
        this.pEU = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pEQ = new a.C1050a();
        this.pER = 0.0f;
        this.pET = false;
        this.pEU = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.pET) {
            this.pET = true;
            this.pES = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.pEU = (!pEV || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.pES.setHierarchy(dh);
        super.setImageDrawable(this.pES.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.pES.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.pES.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.pES.setController(aVar);
        super.setImageDrawable(this.pES.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pES.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        evm();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        evm();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        evm();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        evm();
        onAttach();
    }

    protected void onAttach() {
        evk();
    }

    protected void onDetach() {
        evl();
    }

    protected void evk() {
        this.pES.onAttach();
    }

    protected void evl() {
        this.pES.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pES.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.pES.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.pES.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.pES.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.pES.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.pER) {
            this.pER = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.pER;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.pEU = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.pEQ.width = i;
        this.pEQ.height = i2;
        a.a(this.pEQ, this.pER, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.pEQ.width, this.pEQ.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        evm();
    }

    private void evm() {
        Drawable drawable;
        if (this.pEU && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.bb(this).H("holder", this.pES != null ? this.pES.toString() : "<no holder set>").toString();
    }
}
