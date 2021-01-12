package com.ksad.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes4.dex */
public class m extends a<PointF, PointF> {
    private final PointF c;
    private final a<Float, Float> d;
    private final a<Float, Float> e;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.c = new PointF();
        this.d = aVar;
        this.e = aVar2;
        a(f());
    }

    @Override // com.ksad.lottie.a.b.a
    public void a(float f) {
        this.d.a(f);
        this.e.a(f);
        this.c.set(this.d.e().floatValue(), this.e.e().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f7957a.size()) {
                return;
            }
            this.f7957a.get(i2).a();
            i = i2 + 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public PointF a(com.ksad.lottie.e.a<PointF> aVar, float f) {
        return this.c;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: g */
    public PointF e() {
        return a(null, 0.0f);
    }
}
