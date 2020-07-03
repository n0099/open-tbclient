package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final Type nFG;
    private final com.tb.airbnb.lottie.model.a.b nGA;
    private final com.tb.airbnb.lottie.model.a.b nGS;
    private final com.tb.airbnb.lottie.model.a.b nGT;
    private final com.tb.airbnb.lottie.model.a.b nGU;
    private final com.tb.airbnb.lottie.model.a.b nGV;
    private final com.tb.airbnb.lottie.model.a.b nGW;
    private final m<PointF, PointF> nGy;
    private final String name;

    /* loaded from: classes6.dex */
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
        this.nFG = type;
        this.nGS = bVar;
        this.nGy = mVar;
        this.nGA = bVar2;
        this.nGT = bVar3;
        this.nGU = bVar4;
        this.nGV = bVar5;
        this.nGW = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dNY() {
        return this.nFG;
    }

    public com.tb.airbnb.lottie.model.a.b dNZ() {
        return this.nGS;
    }

    public m<PointF, PointF> dNF() {
        return this.nGy;
    }

    public com.tb.airbnb.lottie.model.a.b dNH() {
        return this.nGA;
    }

    public com.tb.airbnb.lottie.model.a.b dOa() {
        return this.nGT;
    }

    public com.tb.airbnb.lottie.model.a.b dOb() {
        return this.nGU;
    }

    public com.tb.airbnb.lottie.model.a.b dOc() {
        return this.nGV;
    }

    public com.tb.airbnb.lottie.model.a.b dOd() {
        return this.nGW;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
