package com.ksad.lottie.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class f implements d, j, a.InterfaceC0351a {

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31218c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31219d;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f31221f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f31222g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f31223h;
    public final com.ksad.lottie.f i;

    /* renamed from: a  reason: collision with root package name */
    public final Path f31216a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f31217b = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f31220e = new ArrayList();

    public f(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.i iVar) {
        this.f31218c = aVar;
        this.f31219d = iVar.a();
        this.i = fVar;
        if (iVar.b() == null || iVar.c() == null) {
            this.f31221f = null;
            this.f31222g = null;
            return;
        }
        this.f31216a.setFillType(iVar.d());
        com.ksad.lottie.a.b.a<Integer, Integer> a2 = iVar.b().a();
        this.f31221f = a2;
        a2.a(this);
        aVar.a(this.f31221f);
        com.ksad.lottie.a.b.a<Integer, Integer> a3 = iVar.c().a();
        this.f31222g = a3;
        a3.a(this);
        aVar.a(this.f31222g);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0351a
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i) {
        com.ksad.lottie.c.c("FillContent#draw");
        this.f31217b.setColor(this.f31221f.e().intValue());
        this.f31217b.setAlpha(com.ksad.lottie.d.e.a((int) ((((i / 255.0f) * this.f31222g.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f31223h;
        if (aVar != null) {
            this.f31217b.setColorFilter(aVar.e());
        }
        this.f31216a.reset();
        for (int i2 = 0; i2 < this.f31220e.size(); i2++) {
            this.f31216a.addPath(this.f31220e.get(i2).d(), matrix);
        }
        canvas.drawPath(this.f31216a, this.f31217b);
        com.ksad.lottie.c.d("FillContent#draw");
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f31216a.reset();
        for (int i = 0; i < this.f31220e.size(); i++) {
            this.f31216a.addPath(this.f31220e.get(i).d(), matrix);
        }
        this.f31216a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list2.size(); i++) {
            b bVar = list2.get(i);
            if (bVar instanceof l) {
                this.f31220e.add((l) bVar);
            }
        }
    }
}
