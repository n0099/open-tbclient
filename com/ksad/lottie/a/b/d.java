package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes4.dex */
public class d extends f<com.ksad.lottie.model.content.c> {
    private final com.ksad.lottie.model.content.c c;

    public d(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.c>> list) {
        super(list);
        com.ksad.lottie.model.content.c cVar = list.get(0).f8001a;
        int c = cVar == null ? 0 : cVar.c();
        this.c = new com.ksad.lottie.model.content.c(new float[c], new int[c]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public com.ksad.lottie.model.content.c a(com.ksad.lottie.e.a<com.ksad.lottie.model.content.c> aVar, float f) {
        this.c.a(aVar.f8001a, aVar.f8002b, f);
        return this.c;
    }
}
