package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
public class b extends f<Integer> {
    public b(List<com.tb.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.tb.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.FO == null || aVar.FP == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.FO.intValue();
        int intValue2 = aVar.FP.intValue();
        return (this.niY == null || (num = (Integer) this.niY.b(aVar.zN, aVar.FR.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, hq(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.b.b(f, intValue, intValue2)) : num;
    }
}
