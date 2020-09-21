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
        if (aVar.GX == null || aVar.GY == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.osG == null || (f2 = (Float) this.osG.b(aVar.AX, aVar.Ha.floatValue(), aVar.GX, aVar.GY, f, ji(), getProgress())) == null) ? Float.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.GX.floatValue(), aVar.GY.floatValue(), f)) : f2;
    }
}
