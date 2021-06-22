package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class e extends f<Integer> {
    public e(List<com.ksad.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.ksad.lottie.e.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.f32011a == null || aVar.f32012b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.ksad.lottie.e.c<A> cVar = this.f31915b;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.f32014d, aVar.f32015e.floatValue(), aVar.f32011a, aVar.f32012b, f2, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.e.a(aVar.f32011a.intValue(), aVar.f32012b.intValue(), f2)) : num;
    }
}
