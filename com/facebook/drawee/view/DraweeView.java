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
    private static boolean pyG = false;
    private final a.C1023a pyB;
    private float pyC;
    private b<DH> pyD;
    private boolean pyE;
    private boolean pyF;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        pyG = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.pyB = new a.C1023a();
        this.pyC = 0.0f;
        this.pyE = false;
        this.pyF = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pyB = new a.C1023a();
        this.pyC = 0.0f;
        this.pyE = false;
        this.pyF = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pyB = new a.C1023a();
        this.pyC = 0.0f;
        this.pyE = false;
        this.pyF = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.pyE) {
            this.pyE = true;
            this.pyD = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.pyF = (!pyG || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.pyD.setHierarchy(dh);
        super.setImageDrawable(this.pyD.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.pyD.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.pyD.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.pyD.setController(aVar);
        super.setImageDrawable(this.pyD.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pyD.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ewx();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ewx();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ewx();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ewx();
        onAttach();
    }

    protected void onAttach() {
        ewv();
    }

    protected void onDetach() {
        eww();
    }

    protected void ewv() {
        this.pyD.onAttach();
    }

    protected void eww() {
        this.pyD.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pyD.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.pyD.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.pyD.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.pyD.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.pyD.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.pyC) {
            this.pyC = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.pyC;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.pyF = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.pyB.width = i;
        this.pyB.height = i2;
        a.a(this.pyB, this.pyC, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.pyB.width, this.pyB.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        ewx();
    }

    private void ewx() {
        Drawable drawable;
        if (this.pyF && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.bb(this).I("holder", this.pyD != null ? this.pyD.toString() : "<no holder set>").toString();
    }
}
