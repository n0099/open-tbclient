package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.aa;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class KSRelativeLayout extends RelativeLayout implements i {
    public final AtomicBoolean Kt;
    public h Pq;
    public final aa.a afd;
    public g aqH;
    public i aqI;
    public float aqJ;

    public KSRelativeLayout(@NonNull Context context) {
        super(context);
        this.Kt = new AtomicBoolean(true);
        this.aqJ = 0.0f;
        this.afd = new aa.a();
        b(context, null);
    }

    public KSRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kt = new AtomicBoolean(true);
        this.aqJ = 0.0f;
        this.afd = new aa.a();
        b(context, attributeSet);
    }

    public KSRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Kt = new AtomicBoolean(true);
        this.aqJ = 0.0f;
        this.afd = new aa.a();
        b(context, attributeSet);
    }

    @CallSuper
    private void am() {
        this.aqH.onAttachedToWindow();
    }

    @CallSuper
    private void an() {
        this.aqH.onDetachedFromWindow();
    }

    private void b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f0403b5};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.aqJ = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f0403b5), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(this, this);
        this.aqH = gVar;
        gVar.bs(true);
        h hVar = new h();
        this.Pq = hVar;
        hVar.d(context, attributeSet);
    }

    private void pY() {
        if (this.Kt.getAndSet(false)) {
            com.kwad.sdk.core.e.b.i("KSRelativeLayout", "onViewAttached");
            am();
        }
    }

    private void pZ() {
        if (this.Kt.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.e.b.i("KSRelativeLayout", "onViewDetached");
        an();
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

    @MainThread
    public aa.a getTouchCoords() {
        return this.afd;
    }

    public float getVisiblePercent() {
        return this.aqH.getVisiblePercent();
    }

    @Override // com.kwad.sdk.widget.i
    @CallSuper
    public final void k(View view2) {
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

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.aqJ != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.aqJ), 1073741824);
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

    public void setRatio(float f) {
        this.aqJ = f;
    }

    public void setViewVisibleListener(i iVar) {
        this.aqI = iVar;
    }

    public void setVisiblePercent(float f) {
        this.aqH.setVisiblePercent(f);
    }
}
