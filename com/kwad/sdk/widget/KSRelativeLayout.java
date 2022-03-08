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
import com.kwad.sdk.utils.z;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class KSRelativeLayout extends RelativeLayout implements j {
    public final AtomicBoolean a;

    /* renamed from: b  reason: collision with root package name */
    public h f56582b;

    /* renamed from: c  reason: collision with root package name */
    public j f56583c;

    /* renamed from: d  reason: collision with root package name */
    public i f56584d;

    /* renamed from: e  reason: collision with root package name */
    public float f56585e;

    /* renamed from: f  reason: collision with root package name */
    public final z.a f56586f;

    public KSRelativeLayout(@NonNull Context context) {
        super(context);
        this.a = new AtomicBoolean(true);
        this.f56585e = 0.0f;
        this.f56586f = new z.a();
        a(context, null);
    }

    public KSRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new AtomicBoolean(true);
        this.f56585e = 0.0f;
        this.f56586f = new z.a();
        a(context, attributeSet);
    }

    public KSRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new AtomicBoolean(true);
        this.f56585e = 0.0f;
        this.f56586f = new z.a();
        a(context, attributeSet);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int[] iArr = {R.attr.ksad_ratio};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.f56585e = obtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, (int) R.attr.ksad_ratio), 0.0f);
            obtainStyledAttributes.recycle();
        }
        h hVar = new h(this, this);
        this.f56582b = hVar;
        hVar.a(c());
        i iVar = new i();
        this.f56584d = iVar;
        iVar.a(context, attributeSet);
    }

    private void d() {
        if (this.a.getAndSet(false)) {
            com.kwad.sdk.core.d.a.c("KSRelativeLayout", "onViewAttached");
            a();
        }
    }

    private void e() {
        if (this.a.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.a.c("KSRelativeLayout", "onViewDetached");
        b();
    }

    @CallSuper
    public void a() {
        this.f56582b.b();
    }

    @Override // com.kwad.sdk.widget.j
    @CallSuper
    public void a(View view) {
        j jVar = this.f56583c;
        if (jVar != null) {
            jVar.a(view);
        }
    }

    @CallSuper
    public void b() {
        this.f56582b.c();
    }

    public boolean c() {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f56584d.c(canvas);
        super.dispatchDraw(canvas);
        this.f56584d.d(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f56586f.a(getWidth(), getHeight());
            this.f56586f.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f56586f.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f56584d.a(canvas);
        super.draw(canvas);
        this.f56584d.b(canvas);
    }

    @MainThread
    public z.a getTouchCoords() {
        return this.f56586f;
    }

    public float getVisiblePercent() {
        return this.f56582b.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        d();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f56585e != 0.0f) {
            i3 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) * this.f56585e), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f56582b.a(i2, i3, i4, i5);
        super.onSizeChanged(i2, i3, i4, i5);
        this.f56582b.b(i2, i3, i4, i5);
        this.f56584d.a(i2, i3);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        e();
    }

    public void setRadius(float f2) {
        this.f56584d.a(f2);
        postInvalidate();
    }

    public void setRatio(float f2) {
        this.f56585e = f2;
    }

    public void setViewVisibleListener(j jVar) {
        this.f56583c = jVar;
    }

    public void setVisiblePercent(float f2) {
        this.f56582b.a(f2);
    }
}
