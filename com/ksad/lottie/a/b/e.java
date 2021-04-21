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
        if (aVar.f31767a == null || aVar.f31768b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.ksad.lottie.e.c<A> cVar = this.f31673b;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.f31770d, aVar.f31771e.floatValue(), aVar.f31767a, aVar.f31768b, f2, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.e.a(aVar.f31767a.intValue(), aVar.f31768b.intValue(), f2)) : num;
    }
}
