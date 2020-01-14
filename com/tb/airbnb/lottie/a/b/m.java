package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes5.dex */
public class m extends a<PointF, PointF> {
    private final PointF gK;
    private final a<Float, Float> npK;
    private final a<Float, Float> npL;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.gK = new PointF();
        this.npK = aVar;
        this.npL = aVar2;
        setProgress(getProgress());
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.npK.setProgress(f);
        this.npL.setProgress(f);
        this.gK.set(this.npK.getValue().floatValue(), this.npL.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bC();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: bZ */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        return this.gK;
    }
}
