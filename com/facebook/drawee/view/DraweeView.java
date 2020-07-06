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
    private static boolean mOC = false;
    private boolean mOA;
    private boolean mOB;
    private b<DH> mOf;
    private final a.C0802a mOy;
    private float mOz;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        mOC = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.mOy = new a.C0802a();
        this.mOz = 0.0f;
        this.mOA = false;
        this.mOB = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOy = new a.C0802a();
        this.mOz = 0.0f;
        this.mOA = false;
        this.mOB = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOy = new a.C0802a();
        this.mOz = 0.0f;
        this.mOA = false;
        this.mOB = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.mOA) {
            this.mOA = true;
            this.mOf = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.mOB = (!mOC || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.mOf.setHierarchy(dh);
        super.setImageDrawable(this.mOf.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.mOf.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.mOf.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.mOf.setController(aVar);
        super.setImageDrawable(this.mOf.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mOf.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dBT();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dBT();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dBT();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dBT();
        onAttach();
    }

    protected void onAttach() {
        dBR();
    }

    protected void onDetach() {
        dBS();
    }

    protected void dBR() {
        this.mOf.onAttach();
    }

    protected void dBS() {
        this.mOf.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mOf.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mOf.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mOf.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mOf.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mOf.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.mOz) {
            this.mOz = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.mOz;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mOB = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mOy.width = i;
        this.mOy.height = i2;
        a.a(this.mOy, this.mOz, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mOy.width, this.mOy.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dBT();
    }

    private void dBT() {
        Drawable drawable;
        if (this.mOB && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aO(this).F("holder", this.mOf != null ? this.mOf.toString() : "<no holder set>").toString();
    }
}
