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
public class f implements d, j, a.InterfaceC0352a {

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.layer.a f31741c;

    /* renamed from: d  reason: collision with root package name */
    public final String f31742d;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f31744f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<Integer, Integer> f31745g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> f31746h;

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.f f31747i;

    /* renamed from: a  reason: collision with root package name */
    public final Path f31739a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f31740b = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    public final List<l> f31743e = new ArrayList();

    public f(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.i iVar) {
        this.f31741c = aVar;
        this.f31742d = iVar.a();
        this.f31747i = fVar;
        if (iVar.b() == null || iVar.c() == null) {
            this.f31744f = null;
            this.f31745g = null;
            return;
        }
        this.f31739a.setFillType(iVar.d());
        com.ksad.lottie.a.b.a<Integer, Integer> a2 = iVar.b().a();
        this.f31744f = a2;
        a2.a(this);
        aVar.a(this.f31744f);
        com.ksad.lottie.a.b.a<Integer, Integer> a3 = iVar.c().a();
        this.f31745g = a3;
        a3.a(this);
        aVar.a(this.f31745g);
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
    public void a() {
        this.f31747i.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.ksad.lottie.c.c("FillContent#draw");
        this.f31740b.setColor(this.f31744f.e().intValue());
        this.f31740b.setAlpha(com.ksad.lottie.d.e.a((int) ((((i2 / 255.0f) * this.f31745g.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.ksad.lottie.a.b.a<ColorFilter, ColorFilter> aVar = this.f31746h;
        if (aVar != null) {
            this.f31740b.setColorFilter(aVar.e());
        }
        this.f31739a.reset();
        for (int i3 = 0; i3 < this.f31743e.size(); i3++) {
            this.f31739a.addPath(this.f31743e.get(i3).d(), matrix);
        }
        canvas.drawPath(this.f31739a, this.f31740b);
        com.ksad.lottie.c.d("FillContent#draw");
    }

    @Override // com.ksad.lottie.a.a.d
    public void a(RectF rectF, Matrix matrix) {
        this.f31739a.reset();
        for (int i2 = 0; i2 < this.f31743e.size(); i2++) {
            this.f31739a.addPath(this.f31743e.get(i2).d(), matrix);
        }
        this.f31739a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            b bVar = list2.get(i2);
            if (bVar instanceof l) {
                this.f31743e.add((l) bVar);
            }
        }
    }
}
