package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
/* loaded from: classes4.dex */
public class RCRatioFrameLayout extends RatioFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private d f10845a;

    public RCRatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RCRatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCRatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10845a = new d();
        this.f10845a.a(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f10845a.c(canvas);
        super.dispatchDraw(canvas);
        this.f10845a.d(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f10845a.a(canvas);
        super.draw(canvas);
        this.f10845a.b(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f10845a.a(i, i2);
    }

    public void setRadius(float f) {
        this.f10845a.a(f);
        postInvalidate();
    }
}
