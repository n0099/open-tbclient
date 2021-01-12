package com.win.opensdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class MraidLayout extends FrameLayout {

    /* loaded from: classes3.dex */
    public enum java {
        TOP_LEFT,
        TOP_RIGHT,
        CENTER,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP_CENTER,
        BOTTOM_CENTER
    }

    public MraidLayout(@NonNull Context context) {
        this(context, null);
    }

    public MraidLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MraidLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
