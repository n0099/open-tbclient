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
    private static boolean pun = false;
    private final a.C1044a pui;
    private float puj;
    private b<DH> puk;
    private boolean pul;
    private boolean pum;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        pun = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.pui = new a.C1044a();
        this.puj = 0.0f;
        this.pul = false;
        this.pum = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pui = new a.C1044a();
        this.puj = 0.0f;
        this.pul = false;
        this.pum = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pui = new a.C1044a();
        this.puj = 0.0f;
        this.pul = false;
        this.pum = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.pul) {
            this.pul = true;
            this.puk = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.pum = (!pun || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.puk.setHierarchy(dh);
        super.setImageDrawable(this.puk.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.puk.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.puk.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.puk.setController(aVar);
        super.setImageDrawable(this.puk.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.puk.getController();
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
        this.puk.onAttach();
    }

    protected void esL() {
        this.puk.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.puk.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.puk.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.puk.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.puk.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.puk.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.puj) {
            this.puj = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.puj;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.pum = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.pui.width = i;
        this.pui.height = i2;
        a.a(this.pui, this.puj, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.pui.width, this.pui.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        esM();
    }

    private void esM() {
        Drawable drawable;
        if (this.pum && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.bb(this).I("holder", this.puk != null ? this.puk.toString() : "<no holder set>").toString();
    }
}
