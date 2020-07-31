package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class PolystarShape implements b {
    private final Type nOr;
    private final com.tb.airbnb.lottie.model.a.b nPD;
    private final com.tb.airbnb.lottie.model.a.b nPE;
    private final com.tb.airbnb.lottie.model.a.b nPF;
    private final com.tb.airbnb.lottie.model.a.b nPG;
    private final com.tb.airbnb.lottie.model.a.b nPH;
    private final m<PointF, PointF> nPj;
    private final com.tb.airbnb.lottie.model.a.b nPl;
    private final String name;

    /* loaded from: classes5.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, com.tb.airbnb.lottie.model.a.b bVar, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.b bVar2, com.tb.airbnb.lottie.model.a.b bVar3, com.tb.airbnb.lottie.model.a.b bVar4, com.tb.airbnb.lottie.model.a.b bVar5, com.tb.airbnb.lottie.model.a.b bVar6) {
        this.name = str;
        this.nOr = type;
        this.nPD = bVar;
        this.nPj = mVar;
        this.nPl = bVar2;
        this.nPE = bVar3;
        this.nPF = bVar4;
        this.nPG = bVar5;
        this.nPH = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dRy() {
        return this.nOr;
    }

    public com.tb.airbnb.lottie.model.a.b dRz() {
        return this.nPD;
    }

    public m<PointF, PointF> dRf() {
        return this.nPj;
    }

    public com.tb.airbnb.lottie.model.a.b dRh() {
        return this.nPl;
    }

    public com.tb.airbnb.lottie.model.a.b dRA() {
        return this.nPE;
    }

    public com.tb.airbnb.lottie.model.a.b dRB() {
        return this.nPF;
    }

    public com.tb.airbnb.lottie.model.a.b dRC() {
        return this.nPG;
    }

    public com.tb.airbnb.lottie.model.a.b dRD() {
        return this.nPH;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
