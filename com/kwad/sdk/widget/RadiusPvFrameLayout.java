package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class RadiusPvFrameLayout extends com.kwad.sdk.widget.a {

    /* renamed from: a  reason: collision with root package name */
    public float f37107a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f37108b;

    /* renamed from: c  reason: collision with root package name */
    public Path f37109c;

    /* renamed from: d  reason: collision with root package name */
    public a f37110d;

    /* loaded from: classes6.dex */
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
        this.f37107a = ao.a(getContext(), 4.0f);
        setLayerType(1, null);
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        a aVar = this.f37110d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(a aVar) {
        this.f37110d = aVar;
    }

    public void b() {
        this.f37110d = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f37107a == 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        RectF rectF = this.f37108b;
        if (rectF == null) {
            this.f37109c = new Path();
            this.f37108b = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            rectF.right = canvas.getWidth();
            this.f37108b.bottom = canvas.getHeight();
            this.f37109c.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float f2 = this.f37107a;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = f2;
        fArr[7] = f2;
        this.f37109c.addRoundRect(this.f37108b, fArr, Path.Direction.CW);
        canvas.clipPath(this.f37109c);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void setRadius(float f2) {
        this.f37107a = f2;
        invalidate();
    }
}
