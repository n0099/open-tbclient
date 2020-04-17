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
    private static boolean lXt = false;
    private b<DH> lWW;
    private final a.C0705a lXp;
    private float lXq;
    private boolean lXr;
    private boolean lXs;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        lXt = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.lXp = new a.C0705a();
        this.lXq = 0.0f;
        this.lXr = false;
        this.lXs = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lXp = new a.C0705a();
        this.lXq = 0.0f;
        this.lXr = false;
        this.lXs = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lXp = new a.C0705a();
        this.lXq = 0.0f;
        this.lXr = false;
        this.lXs = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.lXr) {
            this.lXr = true;
            this.lWW = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.lXs = (!lXt || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.lWW.setHierarchy(dh);
        super.setImageDrawable(this.lWW.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.lWW.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.lWW.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.lWW.setController(aVar);
        super.setImageDrawable(this.lWW.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lWW.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dpJ();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dpJ();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dpJ();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dpJ();
        onAttach();
    }

    protected void onAttach() {
        dpH();
    }

    protected void onDetach() {
        dpI();
    }

    protected void dpH() {
        this.lWW.onAttach();
    }

    protected void dpI() {
        this.lWW.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lWW.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.lWW.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.lWW.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.lWW.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.lWW.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.lXq) {
            this.lXq = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.lXq;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.lXs = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.lXp.width = i;
        this.lXp.height = i2;
        a.a(this.lXp, this.lXq, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.lXp.width, this.lXp.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dpJ();
    }

    private void dpJ() {
        Drawable drawable;
        if (this.lXs && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aI(this).C("holder", this.lWW != null ? this.lWW.toString() : "<no holder set>").toString();
    }
}
