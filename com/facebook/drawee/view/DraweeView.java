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
    private static boolean mrr = false;
    private b<DH> mqU;
    private final a.C0781a mrn;
    private float mro;
    private boolean mrp;
    private boolean mrq;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        mrr = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.mrn = new a.C0781a();
        this.mro = 0.0f;
        this.mrp = false;
        this.mrq = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mrn = new a.C0781a();
        this.mro = 0.0f;
        this.mrp = false;
        this.mrq = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mrn = new a.C0781a();
        this.mro = 0.0f;
        this.mrp = false;
        this.mrq = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.mrp) {
            this.mrp = true;
            this.mqU = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.mrq = (!mrr || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.mqU.setHierarchy(dh);
        super.setImageDrawable(this.mqU.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.mqU.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.mqU.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.mqU.setController(aVar);
        super.setImageDrawable(this.mqU.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mqU.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dwZ();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dwZ();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dwZ();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dwZ();
        onAttach();
    }

    protected void onAttach() {
        dwX();
    }

    protected void onDetach() {
        dwY();
    }

    protected void dwX() {
        this.mqU.onAttach();
    }

    protected void dwY() {
        this.mqU.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mqU.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mqU.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mqU.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mqU.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mqU.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.mro) {
            this.mro = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.mro;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mrq = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mrn.width = i;
        this.mrn.height = i2;
        a.a(this.mrn, this.mro, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mrn.width, this.mrn.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dwZ();
    }

    private void dwZ() {
        Drawable drawable;
        if (this.mrq && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aN(this).F("holder", this.mqU != null ? this.mqU.toString() : "<no holder set>").toString();
    }
}
