package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes6.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31932c;

    /* renamed from: d  reason: collision with root package name */
    public final a<Float, Float> f31933d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31934e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f31932c = new PointF();
        this.f31933d = aVar;
        this.f31934e = aVar2;
        a(f());
    }

    @Override // com.ksad.lottie.a.b.a
    public void a(float f2) {
        this.f31933d.a(f2);
        this.f31934e.a(f2);
        this.f31932c.set(this.f31933d.e().floatValue(), this.f31934e.e().floatValue());
        for (int i2 = 0; i2 < this.f31914a.size(); i2++) {
            this.f31914a.get(i2).a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        return this.f31932c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: g */
    public PointF e() {
        return a(null, 0.0f);
    }
}
