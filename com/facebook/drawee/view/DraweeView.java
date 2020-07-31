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
/* loaded from: classes9.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean mWL = false;
    private final a.C0811a mWH;
    private float mWI;
    private boolean mWJ;
    private boolean mWK;
    private b<DH> mWo;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        mWL = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.mWH = new a.C0811a();
        this.mWI = 0.0f;
        this.mWJ = false;
        this.mWK = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWH = new a.C0811a();
        this.mWI = 0.0f;
        this.mWJ = false;
        this.mWK = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWH = new a.C0811a();
        this.mWI = 0.0f;
        this.mWJ = false;
        this.mWK = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.mWJ) {
            this.mWJ = true;
            this.mWo = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.mWK = (!mWL || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.mWo.setHierarchy(dh);
        super.setImageDrawable(this.mWo.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.mWo.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.mWo.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.mWo.setController(aVar);
        super.setImageDrawable(this.mWo.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.mWo.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        dFf();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dFf();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        dFf();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        dFf();
        onAttach();
    }

    protected void onAttach() {
        dFd();
    }

    protected void onDetach() {
        dFe();
    }

    protected void dFd() {
        this.mWo.onAttach();
    }

    protected void dFe() {
        this.mWo.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mWo.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mWo.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mWo.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mWo.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mWo.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.mWI) {
            this.mWI = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.mWI;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mWK = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWH.width = i;
        this.mWH.height = i2;
        a.a(this.mWH, this.mWI, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mWH.width, this.mWH.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        dFf();
    }

    private void dFf() {
        Drawable drawable;
        if (this.mWK && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.aO(this).F("holder", this.mWo != null ? this.mWo.toString() : "<no holder set>").toString();
    }
}
