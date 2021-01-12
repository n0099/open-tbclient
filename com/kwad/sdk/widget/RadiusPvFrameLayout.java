package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ao;
/* loaded from: classes4.dex */
public class RadiusPvFrameLayout extends com.kwad.sdk.widget.a {

    /* renamed from: a  reason: collision with root package name */
    private float f10846a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f10847b;
    private Path c;
    private a d;

    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    public RadiusPvFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public RadiusPvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        this.f10846a = ao.a(getContext(), 4.0f);
        setLayerType(1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        if (this.d != null) {
            this.d.a();
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void b() {
        this.d = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f10846a == 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        if (this.f10847b == null) {
            this.c = new Path();
            this.f10847b = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            this.f10847b.right = canvas.getWidth();
            this.f10847b.bottom = canvas.getHeight();
            this.c.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        fArr[0] = this.f10846a;
        fArr[1] = this.f10846a;
        fArr[2] = this.f10846a;
        fArr[3] = this.f10846a;
        fArr[4] = this.f10846a;
        fArr[5] = this.f10846a;
        fArr[6] = this.f10846a;
        fArr[7] = this.f10846a;
        this.c.addRoundRect(this.f10847b, fArr, Path.Direction.CW);
        canvas.clipPath(this.c);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void setRadius(float f) {
        this.f10846a = f;
        invalidate();
    }
}
