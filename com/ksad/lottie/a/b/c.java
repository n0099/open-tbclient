package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class c extends f<Float> {
    public c(List<com.ksad.lottie.e.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public Float a(com.ksad.lottie.e.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.f31383a == null || aVar.f31384b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.ksad.lottie.e.c<A> cVar = this.f31289b;
        return (cVar == 0 || (f3 = (Float) cVar.a(aVar.f31386d, aVar.f31387e.floatValue(), aVar.f31383a, aVar.f31384b, f2, c(), f())) == null) ? Float.valueOf(com.ksad.lottie.d.e.a(aVar.f31383a.floatValue(), aVar.f31384b.floatValue(), f2)) : f3;
    }
}
