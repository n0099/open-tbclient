package com.tb.airbnb.lottie.a.b;

import java.util.List;
/* loaded from: classes20.dex */
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
        if (aVar.If == null || aVar.Ig == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        return (this.pBu == null || (num = (Integer) this.pBu.b(aVar.Ce, aVar.Ii.floatValue(), aVar.If, aVar.Ig, f, jj(), getProgress())) == null) ? Integer.valueOf(com.tb.airbnb.lottie.d.e.lerp(aVar.If.intValue(), aVar.Ig.intValue(), f)) : num;
    }
}
