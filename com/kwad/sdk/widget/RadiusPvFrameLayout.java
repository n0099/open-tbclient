package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class RadiusPvFrameLayout extends com.kwad.sdk.widget.a {

    /* renamed from: a  reason: collision with root package name */
    private float f7162a;
    private RectF b;
    private Path c;
    private a d;

    /* loaded from: classes3.dex */
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
        this.f7162a = ao.a(getContext(), 4.0f);
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
        if (this.f7162a == 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        if (this.b == null) {
            this.c = new Path();
            this.b = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        } else {
            this.b.right = canvas.getWidth();
            this.b.bottom = canvas.getHeight();
            this.c.reset();
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        fArr[0] = this.f7162a;
        fArr[1] = this.f7162a;
        fArr[2] = this.f7162a;
        fArr[3] = this.f7162a;
        fArr[4] = this.f7162a;
        fArr[5] = this.f7162a;
        fArr[6] = this.f7162a;
        fArr[7] = this.f7162a;
        this.c.addRoundRect(this.b, fArr, Path.Direction.CW);
        canvas.clipPath(this.c);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public void setRadius(float f) {
        this.f7162a = f;
        invalidate();
    }
}
