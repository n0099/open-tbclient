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
    private static boolean nQm = false;
    private b<DH> nPP;
    private final a.C0884a nQi;
    private float nQj;
    private boolean nQk;
    private boolean nQl;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        nQm = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.nQi = new a.C0884a();
        this.nQj = 0.0f;
        this.nQk = false;
        this.nQl = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQi = new a.C0884a();
        this.nQj = 0.0f;
        this.nQk = false;
        this.nQl = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQi = new a.C0884a();
        this.nQj = 0.0f;
        this.nQk = false;
        this.nQl = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.nQk) {
            this.nQk = true;
            this.nPP = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.nQl = (!nQm || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.nPP.setHierarchy(dh);
        super.setImageDrawable(this.nPP.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.nPP.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.nPP.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.nPP.setController(aVar);
        super.setImageDrawable(this.nPP.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.nPP.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dYX();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dYX();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dYX();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dYX();
        onAttach();
    }

    protected void onAttach() {
        dYV();
    }

    protected void onDetach() {
        dYW();
    }

    protected void dYV() {
        this.nPP.onAttach();
    }

    protected void dYW() {
        this.nPP.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nPP.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.nPP.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.nPP.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.nPP.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.nPP.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.nQj) {
            this.nQj = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.nQj;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.nQl = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.nQi.width = i;
        this.nQi.height = i2;
        a.a(this.nQi, this.nQj, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.nQi.width, this.nQi.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dYX();
    }

    private void dYX() {
        Drawable drawable;
        if (this.nQl && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aV(this).F("holder", this.nPP != null ? this.nPP.toString() : "<no holder set>").toString();
    }
}
