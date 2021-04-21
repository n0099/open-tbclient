package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes6.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: c  reason: collision with root package name */
    public final PointF f31690c;

    /* renamed from: d  reason: collision with root package name */
    public final a<Float, Float> f31691d;

    /* renamed from: e  reason: collision with root package name */
    public final a<Float, Float> f31692e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f31690c = new PointF();
        this.f31691d = aVar;
        this.f31692e = aVar2;
        a(f());
    }

    @Override // com.ksad.lottie.a.b.a
    public void a(float f2) {
        this.f31691d.a(f2);
        this.f31692e.a(f2);
        this.f31690c.set(this.f31691d.e().floatValue(), this.f31692e.e().floatValue());
        for (int i = 0; i < this.f31672a.size(); i++) {
            this.f31672a.get(i).a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f2) {
        return this.f31690c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: g */
    public PointF e() {
        return a(null, 0.0f);
    }
}
