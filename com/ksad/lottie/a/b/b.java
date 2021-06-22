package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class b extends f<Integer> {
    public b(List<com.ksad.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.ksad.lottie.e.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.f32011a;
        if (num2 == null || aVar.f32012b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = num2.intValue();
        int intValue2 = aVar.f32012b.intValue();
        com.ksad.lottie.e.c<A> cVar = this.f31915b;
        return (cVar == 0 || (num = (Integer) cVar.a(aVar.f32014d, aVar.f32015e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.b.a(f2, intValue, intValue2)) : num;
    }
}
