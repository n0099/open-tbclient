package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes7.dex */
public class b extends f<Integer> {
    public b(List<com.tb.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.tb.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.GX == null || aVar.GY == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.GX.intValue();
        int intValue2 = aVar.GY.intValue();
        return (this.oiW == null || (num = (Integer) this.oiW.b(aVar.AX, aVar.Ha.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, jh(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.b.b(f, intValue, intValue2)) : num;
    }
}
