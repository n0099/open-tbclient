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
    private static boolean pyN = false;
    private final a.C1061a pyI;
    private float pyJ;
    private b<DH> pyK;
    private boolean pyL;
    private boolean pyM;

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        pyN = z;
    }

    public DraweeView(Context context) {
        super(context);
        this.pyI = new a.C1061a();
        this.pyJ = 0.0f;
        this.pyL = false;
        this.pyM = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pyI = new a.C1061a();
        this.pyJ = 0.0f;
        this.pyL = false;
        this.pyM = false;
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pyI = new a.C1061a();
        this.pyJ = 0.0f;
        this.pyL = false;
        this.pyM = false;
        init(context);
    }

    private void init(Context context) {
        boolean z = true;
        if (!this.pyL) {
            this.pyL = true;
            this.pyK = b.a(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList != null) {
                    setColorFilter(imageTintList.getDefaultColor());
                } else {
                    return;
                }
            }
            this.pyM = (!pyN || context.getApplicationInfo().targetSdkVersion < 24) ? false : false;
        }
    }

    public void setHierarchy(DH dh) {
        this.pyK.setHierarchy(dh);
        super.setImageDrawable(this.pyK.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.pyK.getHierarchy();
    }

    @Nullable
    public Drawable getTopLevelDrawable() {
        return this.pyK.getTopLevelDrawable();
    }

    public void setController(@Nullable com.facebook.drawee.d.a aVar) {
        this.pyK.setController(aVar);
        super.setImageDrawable(this.pyK.getTopLevelDrawable());
    }

    @Nullable
    public com.facebook.drawee.d.a getController() {
        return this.pyK.getController();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ewE();
        onAttach();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ewE();
        onDetach();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ewE();
        onDetach();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        ewE();
        onAttach();
    }

    protected void onAttach() {
        ewC();
    }

    protected void onDetach() {
        ewD();
    }

    protected void ewC() {
        this.pyK.onAttach();
    }

    protected void ewD() {
        this.pyK.onDetach();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pyK.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.pyK.setController(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.pyK.setController(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.pyK.setController(null);
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.pyK.setController(null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f) {
        if (f != this.pyJ) {
            this.pyJ = f;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.pyJ;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.pyM = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.pyI.width = i;
        this.pyI.height = i2;
        a.a(this.pyI, this.pyJ, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.pyI.width, this.pyI.height);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        ewE();
    }

    private void ewE() {
        Drawable drawable;
        if (this.pyM && (drawable = getDrawable()) != null) {
            drawable.setVisible(getVisibility() == 0, false);
        }
    }

    @Override // android.view.View
    public String toString() {
        return f.bb(this).I("holder", this.pyK != null ? this.pyK.toString() : "<no holder set>").toString();
    }
}
