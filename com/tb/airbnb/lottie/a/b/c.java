package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes7.dex */
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
        if (aVar.GX == null || aVar.GY == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.oiW == null || (f2 = (Float) this.oiW.b(aVar.AX, aVar.Ha.floatValue(), aVar.GX, aVar.GY, f, jh(), getProgress())) == null) ? Float.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.GX.floatValue(), aVar.GY.floatValue(), f)) : f2;
    }
}
