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
    private static boolean oHE = false;
    private final a.C0956a oHA;
    private float oHB;
    private boolean oHC;
    private boolean oHD;
    private b<DH> oHi;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        oHE = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.oHA = new a.C0956a();
        this.oHB = 0.0f;
        this.oHC = false;
        this.oHD = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oHA = new a.C0956a();
        this.oHB = 0.0f;
        this.oHC = false;
        this.oHD = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oHA = new a.C0956a();
        this.oHB = 0.0f;
        this.oHC = false;
        this.oHD = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.oHC) {
            this.oHC = true;
            this.oHi = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.oHD = (!oHE || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.oHi.setHierarchy(dh);
        super.setImageDrawable(this.oHi.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.oHi.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.oHi.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.oHi.setController(aVar);
        super.setImageDrawable(this.oHi.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.oHi.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        eiV();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        eiV();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        eiV();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        eiV();
        onAttach();
    }

    protected void onAttach() {
        eiT();
    }

    protected void onDetach() {
        eiU();
    }

    protected void eiT() {
        this.oHi.onAttach();
    }

    protected void eiU() {
        this.oHi.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oHi.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.oHi.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.oHi.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.oHi.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.oHi.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.oHB) {
            this.oHB = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.oHB;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.oHD = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.oHA.width = i;
        this.oHA.height = i2;
        a.a(this.oHA, this.oHB, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.oHA.width, this.oHA.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        eiV();
    }

    private void eiV() {
        Drawable drawable;
        if (this.oHD && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aZ(this).F("holder", this.oHi != null ? this.oHi.toString() : "<no holder set>").toString();
    }
}
