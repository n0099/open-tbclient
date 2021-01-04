package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class RCPVFrameLayout extends a {

    /* renamed from: a  reason: collision with root package name */
    private d f11143a;

    public RCPVFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RCPVFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCPVFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11143a = new d();
        this.f11143a.a(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f11143a.c(canvas);
        super.dispatchDraw(canvas);
        this.f11143a.d(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f11143a.a(canvas);
        super.draw(canvas);
        this.f11143a.b(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.a, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11143a.a(i, i2);
    }

    public void setRadius(float f) {
        this.f11143a.a(f);
        postInvalidate();
    }
}
