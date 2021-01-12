package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes4.dex */
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
        if (aVar.f8001a == null || aVar.f8002b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.f7958b == null || (num = (Integer) this.f7958b.a(aVar.d, aVar.e.floatValue(), aVar.f8001a, aVar.f8002b, f, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.e.a(aVar.f8001a.intValue(), aVar.f8002b.intValue(), f)) : num;
    }
}
