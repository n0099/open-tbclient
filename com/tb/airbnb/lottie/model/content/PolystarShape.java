package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type npS;
    private final m<PointF, PointF> nqK;
    private final com.tb.airbnb.lottie.model.a.b nqM;
    private final com.tb.airbnb.lottie.model.a.b nre;
    private final com.tb.airbnb.lottie.model.a.b nrf;
    private final com.tb.airbnb.lottie.model.a.b nrg;
    private final com.tb.airbnb.lottie.model.a.b nrh;
    private final com.tb.airbnb.lottie.model.a.b nri;

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
        this.npS = type;
        this.nre = bVar;
        this.nqK = mVar;
        this.nqM = bVar2;
        this.nrf = bVar3;
        this.nrg = bVar4;
        this.nrh = bVar5;
        this.nri = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dHl() {
        return this.npS;
    }

    public com.tb.airbnb.lottie.model.a.b dHm() {
        return this.nre;
    }

    public m<PointF, PointF> dGS() {
        return this.nqK;
    }

    public com.tb.airbnb.lottie.model.a.b dGU() {
        return this.nqM;
    }

    public com.tb.airbnb.lottie.model.a.b dHn() {
        return this.nrf;
    }

    public com.tb.airbnb.lottie.model.a.b dHo() {
        return this.nrg;
    }

    public com.tb.airbnb.lottie.model.a.b dHp() {
        return this.nrh;
    }

    public com.tb.airbnb.lottie.model.a.b dHq() {
        return this.nri;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
