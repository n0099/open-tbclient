package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes6.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31595c;

    /* renamed from: d  reason: collision with root package name */
    public final a<Float, Float> f31596d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31597e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f31595c = new PointF();
        this.f31596d = aVar;
        this.f31597e = aVar2;
        a(f());
    }

    @Override // com.ksad.lottie.a.b.a
    public void a(float f2) {
        this.f31596d.a(f2);
        this.f31597e.a(f2);
        this.f31595c.set(this.f31596d.e().floatValue(), this.f31597e.e().floatValue());
        for (int i = 0; i < this.f31577a.size(); i++) {
            this.f31577a.get(i).a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        return this.f31595c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: g */
    public PointF e() {
        return a(null, 0.0f);
    }
}
