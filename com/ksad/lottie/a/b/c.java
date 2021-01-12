package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes4.dex */
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
        if (aVar.f8001a == null || aVar.f8002b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.f7958b == null || (f2 = (Float) this.f7958b.a(aVar.d, aVar.e.floatValue(), aVar.f8001a, aVar.f8002b, f, c(), f())) == null) ? Float.valueOf(com.ksad.lottie.d.e.a(aVar.f8001a.floatValue(), aVar.f8002b.floatValue(), f)) : f2;
    }
}
