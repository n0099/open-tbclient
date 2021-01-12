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
/* loaded from: classes3.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean pum = false;
    private final a.C1044a puh;
    private float pui;
    private b<DH> puj;
    private boolean puk;
    private boolean pul;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        pum = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.puh = new a.C1044a();
        this.pui = 0.0f;
        this.puk = false;
        this.pul = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.puh = new a.C1044a();
        this.pui = 0.0f;
        this.puk = false;
        this.pul = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.puh = new a.C1044a();
        this.pui = 0.0f;
        this.puk = false;
        this.pul = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.puk) {
            this.puk = true;
            this.puj = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.pul = (!pum || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.puj.setHierarchy(dh);
        super.setImageDrawable(this.puj.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.puj.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.puj.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.puj.setController(aVar);
        super.setImageDrawable(this.puj.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.puj.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        esM();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        esM();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        esM();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        esM();
        onAttach();
    }

    protected void onAttach() {
        esK();
    }

    protected void onDetach() {
        esL();
    }

    protected void esK() {
        this.puj.onAttach();
    }

    protected void esL() {
        this.puj.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.puj.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.puj.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.puj.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.puj.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.puj.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.pui) {
            this.pui = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.pui;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.pul = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.puh.width = i;
        this.puh.height = i2;
        a.a(this.puh, this.pui, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.puh.width, this.puh.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        esM();
    }

    private void esM() {
        Drawable drawable;
        if (this.pul && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.bb(this).I("holder", this.puj != null ? this.puj.toString() : "<no holder set>").toString();
    }
}
