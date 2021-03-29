package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes6.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31306c;

    /* renamed from: d  reason: collision with root package name */
    public final a<Float, Float> f31307d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31308e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f31306c = new PointF();
        this.f31307d = aVar;
        this.f31308e = aVar2;
        a(f());
    }

    @Override // com.ksad.lottie.a.b.a
    public void a(float f2) {
        this.f31307d.a(f2);
        this.f31308e.a(f2);
        this.f31306c.set(this.f31307d.e().floatValue(), this.f31308e.e().floatValue());
        for (int i = 0; i < this.f31288a.size(); i++) {
            this.f31288a.get(i).a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        return this.f31306c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: g */
    public PointF e() {
        return a(null, 0.0f);
    }
}
