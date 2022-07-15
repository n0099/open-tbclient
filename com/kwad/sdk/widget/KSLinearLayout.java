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
import com.kwad.sdk.utils.y;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class KSLinearLayout extends LinearLayout implements i {
    public final AtomicBoolean a;
    public g b;
    public i c;
    public h d;
    public float e;
    public final y.a f;

    public KSLinearLayout(@NonNull Context context) {
        super(context);
        this.a = new AtomicBoolean(true);
        this.e = 0.0f;
        this.f = new y.a();
        a(context, null);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new AtomicBoolean(true);
        this.e = 0.0f;
        this.f = new y.a();
        a(context, attributeSet);
    }

    public KSLinearLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new AtomicBoolean(true);
        this.e = 0.0f;
        this.f = new y.a();
        a(context, attributeSet);
    }

    private void a() {
        if (this.a.getAndSet(false)) {
            com.kwad.sdk.core.d.b.c("KSLinearLayout", "onViewAttached");
            c();
        }
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f040377};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.e = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f040377), 0.0f);
            obtainStyledAttributes.recycle();
        }
        g gVar = new g(this, this);
        this.b = gVar;
        gVar.a(true);
        h hVar = new h();
        this.d = hVar;
        hVar.a(context, attributeSet);
    }

    private void b() {
        if (this.a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.b.c("KSLinearLayout", "onViewDetached");
        d();
    }

    @CallSuper
    private void c() {
        this.b.c();
    }

    @CallSuper
    private void d() {
        this.b.d();
    }

    @Override // com.kwad.sdk.widget.i
    @CallSuper
    public final void a(View view2) {
        i iVar = this.c;
        if (iVar != null) {
            iVar.a(view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.d.c(canvas);
        super.dispatchDraw(canvas);
        this.d.d(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f.a(getWidth(), getHeight());
            this.f.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.d.a(canvas);
        super.draw(canvas);
        this.d.b(canvas);
    }

    @MainThread
    public y.a getTouchCoords() {
        return this.f;
    }

    public float getVisiblePercent() {
        return this.b.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        a();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.e != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.e), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.b.a(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.b.b();
        this.d.a(i, i2);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        b();
    }

    public void setRadius(float f) {
        this.d.a(f);
        postInvalidate();
    }

    public void setRatio(float f) {
        this.e = f;
    }

    public void setViewVisibleListener(i iVar) {
        this.c = iVar;
    }

    public void setVisiblePercent(float f) {
        this.b.a(f);
    }
}
