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
import com.kwad.sdk.utils.z;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class KSFrameLayout extends FrameLayout implements j {
    public final AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public h f41443b;

    /* renamed from: c  reason: collision with root package name */
    public j f41444c;

    /* renamed from: d  reason: collision with root package name */
    public i f41445d;

    /* renamed from: e  reason: collision with root package name */
    public float f41446e;

    /* renamed from: f  reason: collision with root package name */
    public final z.a f41447f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41448g;

    public KSFrameLayout(@NonNull Context context) {
        super(context);
        this.a = new AtomicBoolean(true);
        this.f41446e = 0.0f;
        this.f41447f = new z.a();
        this.f41448g = true;
        a(context, null);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new AtomicBoolean(true);
        this.f41446e = 0.0f;
        this.f41447f = new z.a();
        this.f41448g = true;
        a(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new AtomicBoolean(true);
        this.f41446e = 0.0f;
        this.f41447f = new z.a();
        this.f41448g = true;
        a(context, attributeSet);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f040321};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.f41446e = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f040321), 0.0f);
            obtainStyledAttributes.recycle();
        }
        h hVar = new h(this, this);
        this.f41443b = hVar;
        hVar.a(n());
        i iVar = new i();
        this.f41445d = iVar;
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
        this.f41443b.b();
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f41445d.a(b(f2, f3, f4, f5));
        postInvalidate();
    }

    @CallSuper
    public void a(View view) {
        j jVar = this.f41444c;
        if (jVar != null) {
            jVar.a(view);
        }
    }

    @CallSuper
    public void b() {
        this.f41443b.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f41445d.c(canvas);
        super.dispatchDraw(canvas);
        this.f41445d.d(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f41447f.a(getWidth(), getHeight());
            this.f41447f.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f41447f.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f41445d.a(canvas);
        super.draw(canvas);
        this.f41445d.b(canvas);
    }

    @MainThread
    public z.a getTouchCoords() {
        return this.f41447f;
    }

    public float getVisiblePercent() {
        return this.f41443b.a();
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
    public void onMeasure(int i, int i2) {
        if (this.f41446e != 0.0f) {
            if (this.f41448g) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.f41446e), 1073741824);
            } else {
                i = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) / this.f41446e), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f41443b.a(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.f41443b.b(i, i2, i3, i4);
        this.f41445d.a(i, i2);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        d();
    }

    public void setRadius(float f2) {
        this.f41445d.a(f2);
        postInvalidate();
    }

    public void setRatio(float f2) {
        this.f41446e = f2;
    }

    public void setViewVisibleListener(j jVar) {
        this.f41444c = jVar;
    }

    public void setVisiblePercent(float f2) {
        this.f41443b.a(f2);
    }

    public void setWidthBasedRatio(boolean z) {
        this.f41448g = z;
    }
}
