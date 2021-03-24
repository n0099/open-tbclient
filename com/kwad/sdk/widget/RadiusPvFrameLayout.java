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
    public float f36817a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f36818b;

    /* renamed from: c  reason: collision with root package name */
    public Path f36819c;

    /* renamed from: d  reason: collision with root package name */
    public a f36820d;

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
        this.f36817a = ao.a(getContext(), 4.0f);
        setLayerType(1, null);
    }

    @Override // com.kwad.sdk.widget.a
    public void a() {
        super.a();
        a aVar = this.f36820d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(a aVar) {
        this.f36820d = aVar;
    }

    public void b() {
        this.f36820d = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f36817a == 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        RectF rectF = this.f36818b;
        if (rectF == null) {
            this.f36819c = new Path();
            this.f36818b = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            rectF.right = canvas.getWidth();
            this.f36818b.bottom = canvas.getHeight();
            this.f36819c.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        float f2 = this.f36817a;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f2;
        fArr[3] = f2;
        fArr[4] = f2;
        fArr[5] = f2;
        fArr[6] = f2;
        fArr[7] = f2;
        this.f36819c.addRoundRect(this.f36818b, fArr, Path.Direction.CW);
        canvas.clipPath(this.f36819c);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void setRadius(float f2) {
        this.f36817a = f2;
        invalidate();
    }
}
