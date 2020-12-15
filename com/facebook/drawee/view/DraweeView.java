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
    private static boolean phy = false;
    private final a.C0994a pht;
    private float phu;
    private b<DH> phv;
    private boolean phw;
    private boolean phx;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        phy = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.pht = new a.C0994a();
        this.phu = 0.0f;
        this.phw = false;
        this.phx = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pht = new a.C0994a();
        this.phu = 0.0f;
        this.phw = false;
        this.phx = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pht = new a.C0994a();
        this.phu = 0.0f;
        this.phw = false;
        this.phx = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.phw) {
            this.phw = true;
            this.phv = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.phx = (!phy || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.phv.setHierarchy(dh);
        super.setImageDrawable(this.phv.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.phv.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.phv.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.phv.setController(aVar);
        super.setImageDrawable(this.phv.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.phv.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        esu();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        esu();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        esu();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        esu();
        onAttach();
    }

    protected void onAttach() {
        ess();
    }

    protected void onDetach() {
        est();
    }

    protected void ess() {
        this.phv.onAttach();
    }

    protected void est() {
        this.phv.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.phv.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.phv.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.phv.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.phv.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.phv.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.phu) {
            this.phu = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.phu;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.phx = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.pht.width = i;
        this.pht.height = i2;
        a.a(this.pht, this.phu, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.pht.width, this.pht.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        esu();
    }

    private void esu() {
        Drawable drawable;
        if (this.phx && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.ba(this).E("holder", this.phv != null ? this.phv.toString() : "<no holder set>").toString();
    }
}
