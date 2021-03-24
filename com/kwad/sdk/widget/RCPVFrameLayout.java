package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class RCPVFrameLayout extends a {

    /* renamed from: a  reason: collision with root package name */
    public d f36815a;

    public RCPVFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RCPVFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCPVFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d dVar = new d();
        this.f36815a = dVar;
        dVar.a(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f36815a.c(canvas);
        super.dispatchDraw(canvas);
        this.f36815a.d(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f36815a.a(canvas);
        super.draw(canvas);
        this.f36815a.b(canvas);
    }

    @Override // com.kwad.sdk.widget.a, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f36815a.a(i, i2);
    }

    public void setRadius(float f2) {
        this.f36815a.a(f2);
        postInvalidate();
    }
}
