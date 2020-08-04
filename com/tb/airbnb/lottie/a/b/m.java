package com.tb.airbnb.lottie.a.b;

import android.graphics.PointF;
import java.util.Collections;
/* loaded from: classes5.dex */
public class m extends a<PointF, PointF> {
    private final PointF CX;
    private final a<Float, Float> nOP;
    private final a<Float, Float> nOQ;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.CX = new PointF();
        this.nOP = aVar;
        this.nOQ = aVar2;
        setProgress(getProgress());
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public void setProgress(float f) {
        this.nOP.setProgress(f);
        this.nOQ.setProgress(f);
        this.CX.set(this.nOP.getValue().floatValue(), this.nOQ.getValue().floatValue());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).hq();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: hN */
    public PointF getValue() {
        return a(null, 0.0f);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tb.airbnb.lottie.a.b.a
    /* renamed from: e */
    public PointF a(com.tb.airbnb.lottie.e.a<PointF> aVar, float f) {
        return this.CX;
    }
}
