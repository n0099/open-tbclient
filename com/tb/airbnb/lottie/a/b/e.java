package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes17.dex */
public class e extends f<Integer> {
    public e(List<com.tb.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.tb.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.GX == null || aVar.GY == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.osG == null || (num = (Integer) this.osG.b(aVar.AX, aVar.Ha.floatValue(), aVar.GX, aVar.GY, f, ji(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.GX.intValue(), aVar.GY.intValue(), f)) : num;
    }
}
