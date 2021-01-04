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
        if (aVar.f8300a == null || aVar.f8301b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.f8300a.intValue();
        int intValue2 = aVar.f8301b.intValue();
        return (this.f8257b == null || (num = (Integer) this.f8257b.a(aVar.d, aVar.e.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.b.a(f, intValue, intValue2)) : num;
    }
}
