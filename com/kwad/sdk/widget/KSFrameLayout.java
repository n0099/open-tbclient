package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.aa;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class KSFrameLayout extends FrameLayout implements e, i {
    public final AtomicBoolean Kt;
    public h Pq;
    public final aa.a afd;
    public g aqH;
    public i aqI;
    public float aqJ;
    public boolean aqK;
    public View aqL;

    public KSFrameLayout(@NonNull Context context) {
        super(context);
        this.Kt = new AtomicBoolean(true);
        this.aqJ = 0.0f;
        this.afd = new aa.a();
        this.aqK = true;
        b(context, null);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kt = new AtomicBoolean(true);
        this.aqJ = 0.0f;
        this.afd = new aa.a();
        this.aqK = true;
        b(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Kt = new AtomicBoolean(true);
        this.aqJ = 0.0f;
        this.afd = new aa.a();
        this.aqK = true;
        b(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, View view2) {
        super(context);
        this.Kt = new AtomicBoolean(true);
        this.aqJ = 0.0f;
        this.afd = new aa.a();
        this.aqK = true;
        this.aqL = view2;
        b(context, null);
    }

    private void b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f0403b6};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.aqJ = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f0403b6), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(getPvView(), this);
        this.aqH = gVar;
        gVar.bs(true);
        h hVar = new h();
        this.Pq = hVar;
        hVar.d(context, attributeSet);
    }

    public static float[] b(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
    }

    private View getPvView() {
        View view2 = this.aqL;
        return view2 == null ? this : view2;
    }

    private void pY() {
        if (this.Kt.getAndSet(false)) {
            com.kwad.sdk.core.e.b.i("KSFrameLayout", "onViewAttached");
            am();
        }
    }

    private void pZ() {
        if (this.Kt.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.b.i("KSFrameLayout", "onViewDetached");
        an();
    }

    @CallSuper
    public void am() {
        this.aqH.onAttachedToWindow();
    }

    @CallSuper
    public void an() {
        this.aqH.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.Pq.f(canvas);
        super.dispatchDraw(canvas);
        this.Pq.g(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.afd.q(getWidth(), getHeight());
            this.afd.e(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.afd.f(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.Pq.d(canvas);
        super.draw(canvas);
        this.Pq.e(canvas);
    }

    @Override // com.kwad.sdk.widget.e
    @MainThread
    public aa.a getTouchCoords() {
        return this.afd;
    }

    public float getVisiblePercent() {
        return this.aqH.getVisiblePercent();
    }

    @CallSuper
    public void k(View view2) {
        i iVar = this.aqI;
        if (iVar != null) {
            iVar.k(view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        pY();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pZ();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        pY();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aqJ != 0.0f) {
            if (this.aqK) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.aqJ), 1073741824);
            } else {
                i = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) / this.aqJ), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.aqH.b(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.aqH.Bw();
        this.Pq.w(i, i2);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        pZ();
    }

    public void setRadius(float f) {
        this.Pq.setRadius(f);
        postInvalidate();
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.Pq.setRadius(b(f, f2, f3, f4));
        postInvalidate();
    }

    public void setRatio(float f) {
        this.aqJ = f;
    }

    public void setViewVisibleListener(i iVar) {
        this.aqI = iVar;
    }

    public void setVisiblePercent(float f) {
        this.aqH.setVisiblePercent(f);
    }

    public void setWidthBasedRatio(boolean z) {
        this.aqK = z;
    }
}
