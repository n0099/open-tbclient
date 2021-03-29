package com.ksad.lottie.a.a;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.ksad.lottie.a.b.a;
import com.ksad.lottie.model.content.ShapeTrimPath;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements j, l, a.InterfaceC0352a {

    /* renamed from: a  reason: collision with root package name */
    public final Path f31209a = new Path();

    /* renamed from: b  reason: collision with root package name */
    public final String f31210b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.f f31211c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f31212d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.a.b.a<?, PointF> f31213e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.content.a f31214f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public r f31215g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31216h;

    public e(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar, com.ksad.lottie.model.content.a aVar2) {
        this.f31210b = aVar2.a();
        this.f31211c = fVar;
        this.f31212d = aVar2.c().a();
        this.f31213e = aVar2.b().a();
        this.f31214f = aVar2;
        aVar.a(this.f31212d);
        aVar.a(this.f31213e);
        this.f31212d.a(this);
        this.f31213e.a(this);
    }

    private void b() {
        this.f31216h = false;
        this.f31211c.invalidateSelf();
    }

    @Override // com.ksad.lottie.a.b.a.InterfaceC0352a
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
                    this.f31215g = rVar;
                    rVar.a(this);
                }
            }
        }
    }

    @Override // com.ksad.lottie.a.a.l
    public Path d() {
        if (this.f31216h) {
            return this.f31209a;
        }
        this.f31209a.reset();
        PointF e2 = this.f31212d.e();
        float f2 = e2.x / 2.0f;
        float f3 = e2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.f31209a.reset();
        if (this.f31214f.d()) {
            float f6 = -f3;
            this.f31209a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.f31209a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.f31209a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.f31209a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.f31209a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.f31209a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.f31209a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.f31209a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.f31209a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.f31209a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF e3 = this.f31213e.e();
        this.f31209a.offset(e3.x, e3.y);
        this.f31209a.close();
        com.ksad.lottie.d.f.a(this.f31209a, this.f31215g);
        this.f31216h = true;
        return this.f31209a;
    }
}
