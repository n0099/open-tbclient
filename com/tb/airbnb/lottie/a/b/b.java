package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes20.dex */
public class b extends f<Integer> {
    public b(List<com.tb.airbnb.lottie.e.a<Integer>> list) {
        super(list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: b */
    public Integer a(com.tb.airbnb.lottie.e.a<Integer> aVar, float f) {
        Integer num;
        if (aVar.If == null || aVar.Ig == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = aVar.If.intValue();
        int intValue2 = aVar.Ig.intValue();
        return (this.pBu == null || (num = (Integer) this.pBu.b(aVar.Ce, aVar.Ii.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f, jj(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.b.b(f, intValue, intValue2)) : num;
    }
}
