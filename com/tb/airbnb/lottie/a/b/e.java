package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes16.dex */
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
        if (aVar.Hn == null || aVar.Ho == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.oHW == null || (num = (Integer) this.oHW.b(aVar.Bo, aVar.Hq.floatValue(), aVar.Hn, aVar.Ho, f, jj(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.Hn.intValue(), aVar.Ho.intValue(), f)) : num;
    }
}
