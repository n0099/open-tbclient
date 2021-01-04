package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.util.w;
/* loaded from: classes3.dex */
public class b extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f12131a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f12132b;
    private RectF c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private com.qq.e.comm.plugin.aa.b.f i;
    private int j;
    private int k;
    private a l;
    private Runnable m;

    /* loaded from: classes3.dex */
    public interface a {
        void i();
    }

    public b(Context context) {
        super(context);
        this.m = new Runnable() { // from class: com.qq.e.comm.plugin.ac.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.i == null || b.this.j <= 0 || b.this.i.f() >= b.this.j) {
                    return;
                }
                b.this.invalidate();
                b.this.c();
                w.a(b.this.m, b.this.k);
            }
        };
        setLayerType(1, null);
        b();
    }

    private void b() {
        this.f12131a = new Paint();
        this.f12131a.setAntiAlias(true);
        this.f12132b = new Paint();
        this.f12132b.setColor(-1);
        this.f12132b.setTextAlign(Paint.Align.CENTER);
        this.c = new RectF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.l != null) {
            this.l.i();
        }
    }

    public void a() {
        w.c(this.m);
    }

    public void a(float f) {
        this.d = f;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(com.qq.e.comm.plugin.aa.b.f fVar, int i, a aVar) {
        if (fVar == null || i <= 0 || fVar.e() <= 0) {
            return;
        }
        this.i = fVar;
        this.j = fVar.e();
        this.k = i;
        this.l = aVar;
        invalidate();
        c();
        w.a(this.m, i);
    }

    public void b(float f) {
        this.f12132b.setTextSize(f);
        Paint.FontMetricsInt fontMetricsInt = this.f12132b.getFontMetricsInt();
        this.h = (fontMetricsInt.bottom + fontMetricsInt.top) / 2;
    }

    public void b(int i) {
        this.f = i;
    }

    public void c(int i) {
        this.g = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int f;
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.i == null || this.j <= 0 || (f = this.i.f()) > this.j) {
            return;
        }
        this.f12131a.setStyle(Paint.Style.FILL);
        this.f12131a.setColor(this.g);
        canvas.drawCircle(measuredWidth / 2, measuredHeight / 2, (measuredWidth / 2) - this.d, this.f12131a);
        this.f12131a.setStyle(Paint.Style.STROKE);
        this.f12131a.setStrokeWidth(this.d);
        this.f12131a.setColor(this.e);
        canvas.drawCircle(measuredWidth / 2, measuredHeight / 2, (measuredWidth / 2) - this.d, this.f12131a);
        this.c.left = this.d;
        this.c.top = this.d;
        this.c.right = measuredWidth - this.d;
        this.c.bottom = measuredWidth - this.d;
        this.f12131a.setStyle(Paint.Style.STROKE);
        this.f12131a.setStrokeWidth(this.d);
        this.f12131a.setColor(this.f);
        canvas.drawArc(this.c, -90.0f, (f / this.j) * 360.0f, false, this.f12131a);
        long j = (this.j - f) / 1000;
        String valueOf = String.valueOf(1);
        if (j > 0) {
            valueOf = String.valueOf(j);
        }
        if (TextUtils.isEmpty(valueOf)) {
            return;
        }
        canvas.drawText(valueOf, measuredWidth / 2, (measuredHeight / 2) - this.h, this.f12132b);
    }
}
