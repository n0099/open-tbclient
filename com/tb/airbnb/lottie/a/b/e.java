package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes6.dex */
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
        if (aVar.FL == null || aVar.FM == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.mOQ == null || (num = (Integer) this.mOQ.b(aVar.zN, aVar.FO.floatValue(), aVar.FL, aVar.FM, f, hq(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.FL.intValue(), aVar.FM.intValue(), f)) : num;
    }
}
