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
/* loaded from: classes8.dex */
public class DraweeView<DH extends com.facebook.drawee.d.b> extends ImageView {
    private static boolean phw = false;
    private final a.C0994a phr;
    private float phs;
    private b<DH> pht;
    private boolean phu;
    private boolean phv;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        phw = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.phr = new a.C0994a();
        this.phs = 0.0f;
        this.phu = false;
        this.phv = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.phr = new a.C0994a();
        this.phs = 0.0f;
        this.phu = false;
        this.phv = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.phr = new a.C0994a();
        this.phs = 0.0f;
        this.phu = false;
        this.phv = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.phu) {
            this.phu = true;
            this.pht = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.phv = (!phw || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.pht.setHierarchy(dh);
        super.setImageDrawable(this.pht.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.pht.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.pht.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.pht.setController(aVar);
        super.setImageDrawable(this.pht.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pht.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        est();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        est();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        est();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        est();
        onAttach();
    }

    protected void onAttach() {
        esr();
    }

    protected void onDetach() {
        ess();
    }

    protected void esr() {
        this.pht.onAttach();
    }

    protected void ess() {
        this.pht.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pht.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.pht.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.pht.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.pht.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.pht.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.phs) {
            this.phs = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.phs;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.phv = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.phr.width = i;
        this.phr.height = i2;
        a.a(this.phr, this.phs, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.phr.width, this.phr.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        est();
    }

    private void est() {
        Drawable drawable;
        if (this.phv && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.ba(this).E("holder", this.pht != null ? this.pht.toString() : "<no holder set>").toString();
    }
}
