package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes5.dex */
public class k extends f<com.ksad.lottie.e.d> {
    public k(List<com.ksad.lottie.e.a<com.ksad.lottie.e.d>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public com.ksad.lottie.e.d a(com.ksad.lottie.e.a<com.ksad.lottie.e.d> aVar, float f) {
        com.ksad.lottie.e.d dVar;
        if (aVar.f8300a == null || aVar.f8301b == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.ksad.lottie.e.d dVar2 = aVar.f8300a;
        com.ksad.lottie.e.d dVar3 = aVar.f8301b;
        return (this.f8257b == null || (dVar = (com.ksad.lottie.e.d) this.f8257b.a(aVar.d, aVar.e.floatValue(), dVar2, dVar3, f, c(), f())) == null) ? new com.ksad.lottie.e.d(com.ksad.lottie.d.e.a(dVar2.a(), dVar3.a(), f), com.ksad.lottie.d.e.a(dVar2.b(), dVar3.b(), f)) : dVar;
    }
}
