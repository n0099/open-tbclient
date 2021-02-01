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
    private static boolean pEv = false;
    private final a.C1048a pEq;
    private float pEr;
    private b<DH> pEs;
    private boolean pEt;
    private boolean pEu;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        pEv = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.pEq = new a.C1048a();
        this.pEr = 0.0f;
        this.pEt = false;
        this.pEu = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pEq = new a.C1048a();
        this.pEr = 0.0f;
        this.pEt = false;
        this.pEu = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pEq = new a.C1048a();
        this.pEr = 0.0f;
        this.pEt = false;
        this.pEu = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.pEt) {
            this.pEt = true;
            this.pEs = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.pEu = (!pEv || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.pEs.setHierarchy(dh);
        super.setImageDrawable(this.pEs.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.pEs.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.pEs.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.pEs.setController(aVar);
        super.setImageDrawable(this.pEs.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pEs.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        eve();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        eve();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        eve();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        eve();
        onAttach();
    }

    protected void onAttach() {
        evc();
    }

    protected void onDetach() {
        evd();
    }

    protected void evc() {
        this.pEs.onAttach();
    }

    protected void evd() {
        this.pEs.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pEs.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.pEs.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.pEs.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.pEs.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.pEs.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.pEr) {
            this.pEr = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.pEr;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.pEu = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.pEq.width = i;
        this.pEq.height = i2;
        a.a(this.pEq, this.pEr, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.pEq.width, this.pEq.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        eve();
    }

    private void eve() {
        Drawable drawable;
        if (this.pEu && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.bb(this).H("holder", this.pEs != null ? this.pEs.toString() : "<no holder set>").toString();
    }
}
