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
        if (aVar.f31913a == null || aVar.f31914b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.ksad.lottie.e.c<A> cVar = this.f31817b;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.f31916d, aVar.f31917e.floatValue(), aVar.f31913a, aVar.f31914b, f2, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.e.a(aVar.f31913a.intValue(), aVar.f31914b.intValue(), f2)) : num;
    }
}
