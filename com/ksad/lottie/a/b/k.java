package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class k extends f<com.ksad.lottie.e.d> {
    public k(List<com.ksad.lottie.e.a<com.ksad.lottie.e.d>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public com.ksad.lottie.e.d a(com.ksad.lottie.e.a<com.ksad.lottie.e.d> aVar, float f2) {
        com.ksad.lottie.e.d dVar;
        com.ksad.lottie.e.d dVar2;
        com.ksad.lottie.e.d dVar3 = aVar.f32011a;
        if (dVar3 == null || (dVar = aVar.f32012b) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.ksad.lottie.e.d dVar4 = dVar3;
        com.ksad.lottie.e.d dVar5 = dVar;
        com.ksad.lottie.e.c<A> cVar = this.f31915b;
        return (cVar == 0 || (dVar2 = (com.ksad.lottie.e.d) cVar.a(aVar.f32014d, aVar.f32015e.floatValue(), dVar4, dVar5, f2, c(), f())) == null) ? new com.ksad.lottie.e.d(com.ksad.lottie.d.e.a(dVar4.a(), dVar5.a(), f2), com.ksad.lottie.d.e.a(dVar4.b(), dVar5.b(), f2)) : dVar2;
    }
}
