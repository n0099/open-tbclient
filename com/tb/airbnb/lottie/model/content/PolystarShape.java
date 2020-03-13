package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final String name;
    private final m<PointF, PointF> nqV;
    private final com.tb.airbnb.lottie.model.a.b nqX;
    private final Type nqd;
    private final com.tb.airbnb.lottie.model.a.b nrp;
    private final com.tb.airbnb.lottie.model.a.b nrq;
    private final com.tb.airbnb.lottie.model.a.b nrr;
    private final com.tb.airbnb.lottie.model.a.b nrs;
    private final com.tb.airbnb.lottie.model.a.b nrt;

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
        this.nqd = type;
        this.nrp = bVar;
        this.nqV = mVar;
        this.nqX = bVar2;
        this.nrq = bVar3;
        this.nrr = bVar4;
        this.nrs = bVar5;
        this.nrt = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dHm() {
        return this.nqd;
    }

    public com.tb.airbnb.lottie.model.a.b dHn() {
        return this.nrp;
    }

    public m<PointF, PointF> dGT() {
        return this.nqV;
    }

    public com.tb.airbnb.lottie.model.a.b dGV() {
        return this.nqX;
    }

    public com.tb.airbnb.lottie.model.a.b dHo() {
        return this.nrq;
    }

    public com.tb.airbnb.lottie.model.a.b dHp() {
        return this.nrr;
    }

    public com.tb.airbnb.lottie.model.a.b dHq() {
        return this.nrs;
    }

    public com.tb.airbnb.lottie.model.a.b dHr() {
        return this.nrt;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
