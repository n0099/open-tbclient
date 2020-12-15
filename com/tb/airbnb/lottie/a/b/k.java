package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes20.dex */
public class k extends f<com.tb.airbnb.lottie.e.d> {
    public k(List<com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.e.d>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: f */
    public com.tb.airbnb.lottie.e.d a(com.tb.airbnb.lottie.e.a<com.tb.airbnb.lottie.e.d> aVar, float f) {
        com.tb.airbnb.lottie.e.d dVar;
        if (aVar.If == null || aVar.Ig == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.tb.airbnb.lottie.e.d dVar2 = aVar.If;
        com.tb.airbnb.lottie.e.d dVar3 = aVar.Ig;
        if (this.pBw != null && (dVar = (com.tb.airbnb.lottie.e.d) this.pBw.b(aVar.Ce, aVar.Ii.floatValue(), dVar2, dVar3, f, jj(), getProgress())) != null) {
            return dVar;
        }
        return new com.tb.airbnb.lottie.e.d(com.tb.airbnb.lottie.d.e.lerp(dVar2.getScaleX(), dVar3.getScaleX(), f), com.tb.airbnb.lottie.d.e.lerp(dVar2.getScaleY(), dVar3.getScaleY(), f));
    }
}
