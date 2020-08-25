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
/* loaded from: classes4.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean nqD = false;
    private float nqA;
    private boolean nqB;
    private boolean nqC;
    private b<DH> nqg;
    private final a.C0869a nqz;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        nqD = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.nqz = new a.C0869a();
        this.nqA = 0.0f;
        this.nqB = false;
        this.nqC = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nqz = new a.C0869a();
        this.nqA = 0.0f;
        this.nqB = false;
        this.nqC = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nqz = new a.C0869a();
        this.nqA = 0.0f;
        this.nqB = false;
        this.nqC = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.nqB) {
            this.nqB = true;
            this.nqg = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.nqC = (!nqD || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.nqg.setHierarchy(dh);
        super.setImageDrawable(this.nqg.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.nqg.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.nqg.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.nqg.setController(aVar);
        super.setImageDrawable(this.nqg.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.nqg.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dRf();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dRf();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dRf();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dRf();
        onAttach();
    }

    protected void onAttach() {
        dRd();
    }

    protected void onDetach() {
        dRe();
    }

    protected void dRd() {
        this.nqg.onAttach();
    }

    protected void dRe() {
        this.nqg.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nqg.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.nqg.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.nqg.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.nqg.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.nqg.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.nqA) {
            this.nqA = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.nqA;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.nqC = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.nqz.width = i;
        this.nqz.height = i2;
        a.a(this.nqz, this.nqA, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.nqz.width, this.nqz.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dRf();
    }

    private void dRf() {
        Drawable drawable;
        if (this.nqC && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aQ(this).E("holder", this.nqg != null ? this.nqg.toString() : "<no holder set>").toString();
    }
}
