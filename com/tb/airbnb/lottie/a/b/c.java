package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
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
        if (aVar.kq == null || aVar.kr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.nqh == null || (f2 = (Float) this.nqh.b(aVar.ed, aVar.kt.floatValue(), aVar.kq, aVar.kr, f, bT(), getProgress())) == null) ? Float.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.kq.floatValue(), aVar.kr.floatValue(), f)) : f2;
    }
}
