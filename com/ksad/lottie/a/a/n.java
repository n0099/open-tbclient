package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class n implements j, l, a.InterfaceC0366a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31545a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f31546b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public final String f31547c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.f f31548d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f31549e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f31550f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, Float> f31551g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public r f31552h;
    public boolean i;

    public n(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.f fVar2) {
        this.f31547c = fVar2.a();
        this.f31548d = fVar;
        this.f31549e = fVar2.d().a();
        this.f31550f = fVar2.c().a();
        this.f31551g = fVar2.b().a();
        aVar.a(this.f31549e);
        aVar.a(this.f31550f);
        aVar.a(this.f31551g);
        this.f31549e.a(this);
        this.f31550f.a(this);
        this.f31551g.a(this);
    }

    private void b() {
        this.i = false;
        this.f31548d.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0366a
    public void a() {
        b();
    }

    @Override // com.ksad.lottie.a.a.b
    public void a(List<b> list, List<b> list2) {
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar instanceof r) {
                r rVar = (r) bVar;
                if (rVar.b() == ShapeTrimPath.Type.Simultaneously) {
                    this.f31552h = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.i) {
            return this.f31545a;
        }
        this.f31545a.reset();
        PointF e2 = this.f31550f.e();
        float f2 = e2.x / 2.0f;
        float f3 = e2.y / 2.0f;
        com.ksad.lottie.a.b.a<?, Float> aVar = this.f31551g;
        float floatValue = aVar == null ? 0.0f : aVar.e().floatValue();
        float min = Math.min(f2, f3);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF e3 = this.f31549e.e();
        this.f31545a.moveTo(e3.x + f2, (e3.y - f3) + floatValue);
        this.f31545a.lineTo(e3.x + f2, (e3.y + f3) - floatValue);
        int i = (floatValue > 0.0f ? 1 : (floatValue == 0.0f ? 0 : -1));
        if (i > 0) {
            RectF rectF = this.f31546b;
            float f4 = e3.x;
            float f5 = floatValue * 2.0f;
            float f6 = e3.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.f31545a.arcTo(this.f31546b, 0.0f, 90.0f, false);
        }
        this.f31545a.lineTo((e3.x - f2) + floatValue, e3.y + f3);
        if (i > 0) {
            RectF rectF2 = this.f31546b;
            float f7 = e3.x;
            float f8 = e3.y;
            float f9 = floatValue * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.f31545a.arcTo(this.f31546b, 90.0f, 90.0f, false);
        }
        this.f31545a.lineTo(e3.x - f2, (e3.y - f3) + floatValue);
        if (i > 0) {
            RectF rectF3 = this.f31546b;
            float f10 = e3.x;
            float f11 = e3.y;
            float f12 = floatValue * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.f31545a.arcTo(this.f31546b, 180.0f, 90.0f, false);
        }
        this.f31545a.lineTo((e3.x + f2) - floatValue, e3.y - f3);
        if (i > 0) {
            RectF rectF4 = this.f31546b;
            float f13 = e3.x;
            float f14 = floatValue * 2.0f;
            float f15 = e3.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.f31545a.arcTo(this.f31546b, 270.0f, 90.0f, false);
        }
        this.f31545a.close();
        com.ksad.lottie.d.f.a(this.f31545a, this.f31552h);
        this.i = true;
        return this.f31545a;
    }
}
