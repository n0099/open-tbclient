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
    private static boolean lXx = false;
    private b<DH> lXa;
    private final a.C0726a lXt;
    private float lXu;
    private boolean lXv;
    private boolean lXw;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        lXx = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.lXt = new a.C0726a();
        this.lXu = 0.0f;
        this.lXv = false;
        this.lXw = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lXt = new a.C0726a();
        this.lXu = 0.0f;
        this.lXv = false;
        this.lXw = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lXt = new a.C0726a();
        this.lXu = 0.0f;
        this.lXv = false;
        this.lXw = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.lXv) {
            this.lXv = true;
            this.lXa = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.lXw = (!lXx || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.lXa.setHierarchy(dh);
        super.setImageDrawable(this.lXa.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.lXa.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.lXa.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.lXa.setController(aVar);
        super.setImageDrawable(this.lXa.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.lXa.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dpH();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dpH();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dpH();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dpH();
        onAttach();
    }

    protected void onAttach() {
        dpF();
    }

    protected void onDetach() {
        dpG();
    }

    protected void dpF() {
        this.lXa.onAttach();
    }

    protected void dpG() {
        this.lXa.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.lXa.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.lXa.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.lXa.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.lXa.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.lXa.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.lXu) {
            this.lXu = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.lXu;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.lXw = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.lXt.width = i;
        this.lXt.height = i2;
        a.a(this.lXt, this.lXu, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.lXt.width, this.lXt.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dpH();
    }

    private void dpH() {
        Drawable drawable;
        if (this.lXw && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aJ(this).C("holder", this.lXa != null ? this.lXa.toString() : "<no holder set>").toString();
    }
}
