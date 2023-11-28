package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.ac;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class KSLinearLayout extends LinearLayout implements i {
    public final AtomicBoolean Uy;
    public final ac.a aBE;
    public g aQU;
    public i aQV;
    public float mRatio;
    public h mViewRCHelper;

    public KSLinearLayout(@NonNull Context context) {
        super(context);
        this.Uy = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aBE = new ac.a();
        init(context, null);
    }

    @Override // com.kwad.sdk.widget.i
    @CallSuper
    public final void A(View view2) {
        i iVar = this.aQV;
        if (iVar != null) {
            iVar.A(view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public void setViewVisibleListener(i iVar) {
        this.aQV = iVar;
    }

    public void setVisiblePercent(float f) {
        this.aQU.setVisiblePercent(f);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Uy = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aBE = new ac.a();
        init(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Uy = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.aBE = new ac.a();
        init(context, attributeSet);
    }

    @CallSuper
    private void ac() {
        this.aQU.onAttachedToWindow();
    }

    @CallSuper
    private void ad() {
        this.aQU.onDetachedFromWindow();
    }

    private void tb() {
        if (this.Uy.getAndSet(false)) {
            ac();
        }
    }

    private void tc() {
        if (!this.Uy.getAndSet(true)) {
            ad();
        }
    }

    @MainThread
    public ac.a getTouchCoords() {
        return this.aBE;
    }

    public float getVisiblePercent() {
        return this.aQU.getVisiblePercent();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        tb();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tc();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        tb();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        tc();
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f0403e0};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f0403e0), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(this, this);
        this.aQU = gVar;
        gVar.cb(true);
        h hVar = new h();
        this.mViewRCHelper = hVar;
        hVar.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.aBE.g(motionEvent.getX(), motionEvent.getY());
            }
        } else {
            this.aBE.B(getWidth(), getHeight());
            this.aBE.f(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.aQU.b(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.aQU.Mq();
        this.mViewRCHelper.onSizeChanged(i, i2);
    }
}
