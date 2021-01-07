package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes5.dex */
public class b extends f<Integer> {
    public b(List<com.ksad.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.ksad.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.f8301a == null || aVar.f8302b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.f8301a.intValue();
        int intValue2 = aVar.f8302b.intValue();
        return (this.f8258b == null || (num = (Integer) this.f8258b.a(aVar.d, aVar.e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.b.a(f, intValue, intValue2)) : num;
    }
}
