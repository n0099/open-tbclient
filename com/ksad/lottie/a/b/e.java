package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes3.dex */
public class e extends f<Integer> {
    public e(List<com.ksad.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.ksad.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.f5351a == null || aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.b == null || (num = (Integer) this.b.a(aVar.d, aVar.e.floatValue(), aVar.f5351a, aVar.b, f, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.e.a(aVar.f5351a.intValue(), aVar.b.intValue(), f)) : num;
    }
}
