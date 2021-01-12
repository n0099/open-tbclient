package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.qq.e.comm.plugin.util.ak;
/* loaded from: classes3.dex */
public class a extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f11830a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f11831b;
    private int c;
    private int d;
    private int e;
    private RectF f;

    public a(Context context) {
        super(context);
        this.d = ak.a(getContext().getApplicationContext(), 4);
        this.e = 100;
        setLayerType(1, null);
        a();
    }

    private void a() {
        this.f11830a = new Paint();
        this.f11830a.setAntiAlias(true);
        this.f11830a.setColor(Color.parseColor("#C3C4C5"));
        this.f11830a.setStyle(Paint.Style.STROKE);
        this.f11830a.setStrokeWidth(this.d);
        this.f11831b = new Paint();
        this.f11831b.setAntiAlias(true);
        this.f11831b.setStyle(Paint.Style.STROKE);
        this.f11831b.setColor(-1);
        this.f11831b.setStrokeWidth(this.d);
        this.f = new RectF();
    }

    public void a(int i) {
        if (i <= 0) {
            this.c = 0;
        } else if (i >= 100) {
            this.c = 100;
        } else {
            this.c = i;
        }
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        canvas.drawCircle(measuredWidth / 2, getMeasuredHeight() / 2, (measuredWidth / 2) - this.d, this.f11830a);
        if (this.c > 0) {
            this.f.left = this.d;
            this.f.top = this.d;
            this.f.right = measuredWidth - this.d;
            this.f.bottom = measuredWidth - this.d;
            canvas.drawArc(this.f, -90.0f, (this.c / this.e) * 360.0f, false, this.f11831b);
        }
    }
}
