package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes17.dex */
public class c extends f<Float> {
    public c(List<com.tb.airbnb.lottie.e.a<Float>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: c */
    public Float a(com.tb.airbnb.lottie.e.a<Float> aVar, float f) {
        Float f2;
        if (aVar.Hn == null || aVar.Ho == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.pKq == null || (f2 = (Float) this.pKq.b(aVar.Bo, aVar.Hq.floatValue(), aVar.Hn, aVar.Ho, f, jj(), getProgress())) == null) ? Float.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.Hn.floatValue(), aVar.Ho.floatValue(), f)) : f2;
    }
}
