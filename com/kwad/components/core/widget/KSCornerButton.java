package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.h;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes10.dex */
public class KSCornerButton extends Button {
    public h Pq;

    public KSCornerButton(Context context) {
        super(context);
        c(context, null);
    }

    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(context, attributeSet);
    }

    @RequiresApi(api = 21)
    public KSCornerButton(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        c(context, attributeSet);
    }

    private void c(Context context, @Nullable AttributeSet attributeSet) {
        h.a aVar = new h.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCornerImageView);
        aVar.bt(obtainStyledAttributes.getBoolean(1, true));
        aVar.bu(obtainStyledAttributes.getBoolean(3, true));
        aVar.bv(obtainStyledAttributes.getBoolean(2, true));
        aVar.bw(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        h hVar = new h(aVar);
        this.Pq = hVar;
        hVar.d(context, attributeSet);
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.Pq.f(canvas);
        super.dispatchDraw(canvas);
        this.Pq.g(canvas);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.Pq.d(canvas);
        super.draw(canvas);
        this.Pq.e(canvas);
    }

    @NonNull
    public h.a getCornerConf() {
        return this.Pq.getCornerConf();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.Pq.w(i, i2);
    }

    public void setRadius(float f) {
        this.Pq.setRadius(f);
        postInvalidate();
    }
}
