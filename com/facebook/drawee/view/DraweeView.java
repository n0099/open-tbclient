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
/* loaded from: classes11.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean nAT = false;
    private final a.C0866a nAP;
    private float nAQ;
    private boolean nAR;
    private boolean nAS;
    private b<DH> nAw;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        nAT = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.nAP = new a.C0866a();
        this.nAQ = 0.0f;
        this.nAR = false;
        this.nAS = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nAP = new a.C0866a();
        this.nAQ = 0.0f;
        this.nAR = false;
        this.nAS = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nAP = new a.C0866a();
        this.nAQ = 0.0f;
        this.nAR = false;
        this.nAS = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.nAR) {
            this.nAR = true;
            this.nAw = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.nAS = (!nAT || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.nAw.setHierarchy(dh);
        super.setImageDrawable(this.nAw.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.nAw.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.nAw.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.nAw.setController(aVar);
        super.setImageDrawable(this.nAw.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.nAw.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dVm();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dVm();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dVm();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dVm();
        onAttach();
    }

    protected void onAttach() {
        dVk();
    }

    protected void onDetach() {
        dVl();
    }

    protected void dVk() {
        this.nAw.onAttach();
    }

    protected void dVl() {
        this.nAw.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nAw.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.nAw.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.nAw.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.nAw.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.nAw.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.nAQ) {
            this.nAQ = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.nAQ;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.nAS = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.nAP.width = i;
        this.nAP.height = i2;
        a.a(this.nAP, this.nAQ, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.nAP.width, this.nAP.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dVm();
    }

    private void dVm() {
        Drawable drawable;
        if (this.nAS && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aS(this).E("holder", this.nAw != null ? this.nAw.toString() : "<no holder set>").toString();
    }
}
