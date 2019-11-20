package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class k extends f<com.tb.airbnb.lottie.model.k> {
    public k(List<com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.k>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: f */
    public com.tb.airbnb.lottie.model.k a(com.tb.airbnb.lottie.a.a<com.tb.airbnb.lottie.model.k> aVar, float f) {
        if (aVar.dK == null || aVar.dL == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.tb.airbnb.lottie.model.k kVar = aVar.dK;
        com.tb.airbnb.lottie.model.k kVar2 = aVar.dL;
        return new com.tb.airbnb.lottie.model.k(com.tb.airbnb.lottie.c.e.lerp(kVar.getScaleX(), kVar2.getScaleX(), f), com.tb.airbnb.lottie.c.e.lerp(kVar.getScaleY(), kVar2.getScaleY(), f));
    }
}
