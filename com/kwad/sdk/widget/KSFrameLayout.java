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
import com.kwad.sdk.R;
import com.kwad.sdk.utils.z;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class KSFrameLayout extends FrameLayout implements j {
    public final AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public h f58000b;

    /* renamed from: c  reason: collision with root package name */
    public j f58001c;

    /* renamed from: d  reason: collision with root package name */
    public i f58002d;

    /* renamed from: e  reason: collision with root package name */
    public float f58003e;

    /* renamed from: f  reason: collision with root package name */
    public final z.a f58004f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58005g;

    public KSFrameLayout(@NonNull Context context) {
        super(context);
        this.a = new AtomicBoolean(true);
        this.f58003e = 0.0f;
        this.f58004f = new z.a();
        this.f58005g = true;
        a(context, null);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new AtomicBoolean(true);
        this.f58003e = 0.0f;
        this.f58004f = new z.a();
        this.f58005g = true;
        a(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new AtomicBoolean(true);
        this.f58003e = 0.0f;
        this.f58004f = new z.a();
        this.f58005g = true;
        a(context, attributeSet);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i2 = R.attr.ksad_ratio;
            int[] iArr = {i2};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.f58003e = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i2), 0.0f);
            obtainStyledAttributes.recycle();
        }
        h hVar = new h(this, this);
        this.f58000b = hVar;
        hVar.a(n());
        i iVar = new i();
        this.f58002d = iVar;
        iVar.a(context, attributeSet);
    }

    private float[] b(float f2, float f3, float f4, float f5) {
        return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
    }

    private void c() {
        if (this.a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("KSFrameLayout", "onViewAttached");
            a();
        }
    }

    private void d() {
        if (this.a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("KSFrameLayout", "onViewDetached");
        b();
    }

    @CallSuper
    public void a() {
        this.f58000b.b();
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f58002d.a(b(f2, f3, f4, f5));
        postInvalidate();
    }

    @CallSuper
    public void a(View view) {
        j jVar = this.f58001c;
        if (jVar != null) {
            jVar.a(view);
        }
    }

    @CallSuper
    public void b() {
        this.f58000b.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f58002d.c(canvas);
        super.dispatchDraw(canvas);
        this.f58002d.d(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f58004f.a(getWidth(), getHeight());
            this.f58004f.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f58004f.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f58002d.a(canvas);
        super.draw(canvas);
        this.f58002d.b(canvas);
    }

    @MainThread
    public z.a getTouchCoords() {
        return this.f58004f;
    }

    public float getVisiblePercent() {
        return this.f58000b.a();
    }

    public boolean n() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        c();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f58003e != 0.0f) {
            if (this.f58005g) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) * this.f58003e), 1073741824);
            } else {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i3) / this.f58003e), 1073741824);
            }
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f58000b.a(i2, i3, i4, i5);
        super.onSizeChanged(i2, i3, i4, i5);
        this.f58000b.b(i2, i3, i4, i5);
        this.f58002d.a(i2, i3);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        d();
    }

    public void setRadius(float f2) {
        this.f58002d.a(f2);
        postInvalidate();
    }

    public void setRatio(float f2) {
        this.f58003e = f2;
    }

    public void setViewVisibleListener(j jVar) {
        this.f58001c = jVar;
    }

    public void setVisiblePercent(float f2) {
        this.f58000b.a(f2);
    }

    public void setWidthBasedRatio(boolean z) {
        this.f58005g = z;
    }
}
