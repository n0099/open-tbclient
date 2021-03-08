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
        if (aVar.f5351a == null || aVar.b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.b == null || (f2 = (Float) this.b.a(aVar.d, aVar.e.floatValue(), aVar.f5351a, aVar.b, f, c(), f())) == null) ? Float.valueOf(com.ksad.lottie.d.e.a(aVar.f5351a.floatValue(), aVar.b.floatValue(), f)) : f2;
    }
}
