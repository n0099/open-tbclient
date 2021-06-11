package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes6.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31834c;

    /* renamed from: d  reason: collision with root package name */
    public final a<Float, Float> f31835d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31836e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f31834c = new PointF();
        this.f31835d = aVar;
        this.f31836e = aVar2;
        a(f());
    }

    @Override // com.ksad.lottie.a.b.a
    public void a(float f2) {
        this.f31835d.a(f2);
        this.f31836e.a(f2);
        this.f31834c.set(this.f31835d.e().floatValue(), this.f31836e.e().floatValue());
        for (int i2 = 0; i2 < this.f31816a.size(); i2++) {
            this.f31816a.get(i2).a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        return this.f31834c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: g */
    public PointF e() {
        return a(null, 0.0f);
    }
}
