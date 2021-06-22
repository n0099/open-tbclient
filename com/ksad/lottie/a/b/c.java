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
        if (aVar.f32011a == null || aVar.f32012b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.ksad.lottie.e.c<A> cVar = this.f31915b;
        return (cVar == 0 || (f3 = (Float) cVar.a(aVar.f32014d, aVar.f32015e.floatValue(), aVar.f32011a, aVar.f32012b, f2, c(), f())) == null) ? Float.valueOf(com.ksad.lottie.d.e.a(aVar.f32011a.floatValue(), aVar.f32012b.floatValue(), f2)) : f3;
    }
}
