package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class PolystarShape implements b {
    private final Type nOt;
    private final com.tb.airbnb.lottie.model.a.b nPF;
    private final com.tb.airbnb.lottie.model.a.b nPG;
    private final com.tb.airbnb.lottie.model.a.b nPH;
    private final com.tb.airbnb.lottie.model.a.b nPI;
    private final com.tb.airbnb.lottie.model.a.b nPJ;
    private final m<PointF, PointF> nPl;
    private final com.tb.airbnb.lottie.model.a.b nPn;
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
        this.nOt = type;
        this.nPF = bVar;
        this.nPl = mVar;
        this.nPn = bVar2;
        this.nPG = bVar3;
        this.nPH = bVar4;
        this.nPI = bVar5;
        this.nPJ = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dRz() {
        return this.nOt;
    }

    public com.tb.airbnb.lottie.model.a.b dRA() {
        return this.nPF;
    }

    public m<PointF, PointF> dRg() {
        return this.nPl;
    }

    public com.tb.airbnb.lottie.model.a.b dRi() {
        return this.nPn;
    }

    public com.tb.airbnb.lottie.model.a.b dRB() {
        return this.nPG;
    }

    public com.tb.airbnb.lottie.model.a.b dRC() {
        return this.nPH;
    }

    public com.tb.airbnb.lottie.model.a.b dRD() {
        return this.nPI;
    }

    public com.tb.airbnb.lottie.model.a.b dRE() {
        return this.nPJ;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
