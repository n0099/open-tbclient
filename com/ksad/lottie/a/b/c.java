package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class c extends f<Float> {
    public c(List<com.ksad.lottie.e.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Float a(com.ksad.lottie.e.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f31767a == null || aVar.f31768b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.ksad.lottie.e.c<A> cVar = this.f31673b;
        return (cVar == 0 || (f3 = (Float) cVar.a(aVar.f31770d, aVar.f31771e.floatValue(), aVar.f31767a, aVar.f31768b, f2, c(), f())) == null) ? Float.valueOf(com.ksad.lottie.d.e.a(aVar.f31767a.floatValue(), aVar.f31768b.floatValue(), f2)) : f3;
    }
}
