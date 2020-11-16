package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes17.dex */
public class b extends f<Integer> {
    public b(List<com.tb.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.tb.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.Hn == null || aVar.Ho == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.Hn.intValue();
        int intValue2 = aVar.Ho.intValue();
        return (this.pKq == null || (num = (Integer) this.pKq.b(aVar.Bo, aVar.Hq.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, jj(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.b.b(f, intValue, intValue2)) : num;
    }
}
