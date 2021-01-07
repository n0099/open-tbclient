package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes5.dex */
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
        if (aVar.f8301a == null || aVar.f8302b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.f8258b == null || (f2 = (Float) this.f8258b.a(aVar.d, aVar.e.floatValue(), aVar.f8301a, aVar.f8302b, f, c(), f())) == null) ? Float.valueOf(com.ksad.lottie.d.e.a(aVar.f8301a.floatValue(), aVar.f8302b.floatValue(), f)) : f2;
    }
}
