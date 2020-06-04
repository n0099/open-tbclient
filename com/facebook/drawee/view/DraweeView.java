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
    private static boolean msC = false;
    private boolean msA;
    private boolean msB;
    private b<DH> mse;
    private final a.C0782a msy;
    private float msz;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        msC = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.msy = new a.C0782a();
        this.msz = 0.0f;
        this.msA = false;
        this.msB = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.msy = new a.C0782a();
        this.msz = 0.0f;
        this.msA = false;
        this.msB = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.msy = new a.C0782a();
        this.msz = 0.0f;
        this.msA = false;
        this.msB = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.msA) {
            this.msA = true;
            this.mse = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.msB = (!msC || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.mse.setHierarchy(dh);
        super.setImageDrawable(this.mse.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.mse.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.mse.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.mse.setController(aVar);
        super.setImageDrawable(this.mse.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mse.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dxn();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dxn();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dxn();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dxn();
        onAttach();
    }

    protected void onAttach() {
        dxl();
    }

    protected void onDetach() {
        dxm();
    }

    protected void dxl() {
        this.mse.onAttach();
    }

    protected void dxm() {
        this.mse.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mse.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mse.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mse.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mse.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mse.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.msz) {
            this.msz = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.msz;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.msB = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.msy.width = i;
        this.msy.height = i2;
        a.a(this.msy, this.msz, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.msy.width, this.msy.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dxn();
    }

    private void dxn() {
        Drawable drawable;
        if (this.msB && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aN(this).F("holder", this.mse != null ? this.mse.toString() : "<no holder set>").toString();
    }
}
