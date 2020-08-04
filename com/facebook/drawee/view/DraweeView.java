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
/* loaded from: classes9.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean mWO = false;
    private final a.C0811a mWJ;
    private float mWK;
    private boolean mWL;
    private boolean mWN;
    private b<DH> mWq;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        mWO = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.mWJ = new a.C0811a();
        this.mWK = 0.0f;
        this.mWL = false;
        this.mWN = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWJ = new a.C0811a();
        this.mWK = 0.0f;
        this.mWL = false;
        this.mWN = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWJ = new a.C0811a();
        this.mWK = 0.0f;
        this.mWL = false;
        this.mWN = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.mWL) {
            this.mWL = true;
            this.mWq = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.mWN = (!mWO || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.mWq.setHierarchy(dh);
        super.setImageDrawable(this.mWq.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.mWq.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.mWq.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.mWq.setController(aVar);
        super.setImageDrawable(this.mWq.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mWq.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dFg();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dFg();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dFg();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dFg();
        onAttach();
    }

    protected void onAttach() {
        dFe();
    }

    protected void onDetach() {
        dFf();
    }

    protected void dFe() {
        this.mWq.onAttach();
    }

    protected void dFf() {
        this.mWq.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mWq.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mWq.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mWq.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mWq.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mWq.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.mWK) {
            this.mWK = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.mWK;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mWN = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWJ.width = i;
        this.mWJ.height = i2;
        a.a(this.mWJ, this.mWK, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mWJ.width, this.mWJ.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dFg();
    }

    private void dFg() {
        Drawable drawable;
        if (this.mWN && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aO(this).F("holder", this.mWq != null ? this.mWq.toString() : "<no holder set>").toString();
    }
}
