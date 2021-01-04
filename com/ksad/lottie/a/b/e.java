package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes5.dex */
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
        if (aVar.f8300a == null || aVar.f8301b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.f8257b == null || (num = (Integer) this.f8257b.a(aVar.d, aVar.e.floatValue(), aVar.f8300a, aVar.f8301b, f, c(), f())) == null) ? Integer.valueOf(com.ksad.lottie.d.e.a(aVar.f8300a.intValue(), aVar.f8301b.intValue(), f)) : num;
    }
}
