package com.ksad.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class d extends f<com.ksad.lottie.model.content.c> {

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.content.c f31822c;

    public d(List<com.ksad.lottie.e.a<com.ksad.lottie.model.content.c>> list) {
        super(list);
        com.ksad.lottie.model.content.c cVar = list.get(0).f31913a;
        int c2 = cVar != null ? cVar.c() : 0;
        this.f31822c = new com.ksad.lottie.model.content.c(new float[c2], new int[c2]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.a.b.a
    /* renamed from: b */
    public com.ksad.lottie.model.content.c a(com.ksad.lottie.e.a<com.ksad.lottie.model.content.c> aVar, float f2) {
        this.f31822c.a(aVar.f31913a, aVar.f31914b, f2);
        return this.f31822c;
    }
}
