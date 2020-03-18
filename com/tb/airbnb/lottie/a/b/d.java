package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class d extends f<com.tb.airbnb.lottie.model.content.c> {
    private final com.tb.airbnb.lottie.model.content.c nsj;

    public d(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.c>> list) {
        super(list);
        com.tb.airbnb.lottie.model.content.c cVar = list.get(0).kp;
        int size = cVar == null ? 0 : cVar.getSize();
        this.nsj = new com.tb.airbnb.lottie.model.content.c(new float[size], new int[size]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: d */
    public com.tb.airbnb.lottie.model.content.c a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.model.content.c> aVar, float f) {
        this.nsj.a(aVar.kp, aVar.kq, f);
        return this.nsj;
    }
}
