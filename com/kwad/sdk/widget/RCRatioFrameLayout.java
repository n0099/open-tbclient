package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
/* loaded from: classes7.dex */
public class RCRatioFrameLayout extends RatioFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public d f37673a;

    public RCRatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RCRatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCRatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d dVar = new d();
        this.f37673a = dVar;
        dVar.a(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f37673a.c(canvas);
        super.dispatchDraw(canvas);
        this.f37673a.d(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f37673a.a(canvas);
        super.draw(canvas);
        this.f37673a.b(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f37673a.a(i2, i3);
    }

    public void setRadius(float f2) {
        this.f37673a.a(f2);
        postInvalidate();
    }
}
