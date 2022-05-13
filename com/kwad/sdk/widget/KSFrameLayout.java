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
/* loaded from: classes5.dex */
public class KSFrameLayout extends FrameLayout implements j {
    public final AtomicBoolean a;
    public h b;
    public j c;
    public i d;
    public float e;
    public final z.a f;
    public boolean g;

    public KSFrameLayout(@NonNull Context context) {
        super(context);
        this.a = new AtomicBoolean(true);
        this.e = 0.0f;
        this.f = new z.a();
        this.g = true;
        a(context, null);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new AtomicBoolean(true);
        this.e = 0.0f;
        this.f = new z.a();
        this.g = true;
        a(context, attributeSet);
    }

    public KSFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new AtomicBoolean(true);
        this.e = 0.0f;
        this.f = new z.a();
        this.g = true;
        a(context, attributeSet);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.obfuscated_res_0x7f040371};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.e = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, (int) R.attr.obfuscated_res_0x7f040371), 0.0f);
            obtainStyledAttributes.recycle();
        }
        h hVar = new h(this, this);
        this.b = hVar;
        hVar.a(n());
        i iVar = new i();
        this.d = iVar;
        iVar.a(context, attributeSet);
    }

    private float[] b(float f, float f2, float f3, float f4) {
        return new float[]{f, f, f2, f2, f3, f3, f4, f4};
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
        this.b.b();
    }

    public void a(float f, float f2, float f3, float f4) {
        this.d.a(b(f, f2, f3, f4));
        postInvalidate();
    }

    @CallSuper
    public void a(View view2) {
        j jVar = this.c;
        if (jVar != null) {
            jVar.a(view2);
        }
    }

    @CallSuper
    public void b() {
        this.b.c();
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
    public z.a getTouchCoords() {
        return this.f;
    }

    public float getVisiblePercent() {
        return this.b.a();
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
        if (this.e != 0.0f) {
            if (this.g) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.e), 1073741824);
            } else {
                i = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) / this.e), 1073741824);
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.b.a(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.b.b(i, i2, i3, i4);
        this.d.a(i, i2);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        d();
    }

    public void setRadius(float f) {
        this.d.a(f);
        postInvalidate();
    }

    public void setRatio(float f) {
        this.e = f;
    }

    public void setViewVisibleListener(j jVar) {
        this.c = jVar;
    }

    public void setVisiblePercent(float f) {
        this.b.a(f);
    }

    public void setWidthBasedRatio(boolean z) {
        this.g = z;
    }
}
