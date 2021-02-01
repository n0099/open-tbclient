package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes3.dex */
public class c extends f<Float> {
    public c(List<com.ksad.lottie.e.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Float a(com.ksad.lottie.e.a<Float> aVar, float f) {
        Float f2;
        if (aVar.f8003a == null || aVar.f8004b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.f7960b == null || (f2 = (Float) this.f7960b.a(aVar.d, aVar.e.floatValue(), aVar.f8003a, aVar.f8004b, f, c(), f())) == null) ? Float.valueOf(com.ksad.lottie.d.e.a(aVar.f8003a.floatValue(), aVar.f8004b.floatValue(), f)) : f2;
    }
}
