package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
/* loaded from: classes6.dex */
public class RCRatioFrameLayout extends RatioFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public d f36817a;

    public RCRatioFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RCRatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RCRatioFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d dVar = new d();
        this.f36817a = dVar;
        dVar.a(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f36817a.c(canvas);
        super.dispatchDraw(canvas);
        this.f36817a.d(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f36817a.a(canvas);
        super.draw(canvas);
        this.f36817a.b(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f36817a.a(i, i2);
    }

    public void setRadius(float f2) {
        this.f36817a.a(f2);
        postInvalidate();
    }
}
