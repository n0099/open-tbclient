package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type npQ;
    private final m<PointF, PointF> nqI;
    private final com.tb.airbnb.lottie.model.a.b nqK;
    private final com.tb.airbnb.lottie.model.a.b nrc;
    private final com.tb.airbnb.lottie.model.a.b nrd;
    private final com.tb.airbnb.lottie.model.a.b nre;
    private final com.tb.airbnb.lottie.model.a.b nrf;
    private final com.tb.airbnb.lottie.model.a.b nrg;

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
        this.npQ = type;
        this.nrc = bVar;
        this.nqI = mVar;
        this.nqK = bVar2;
        this.nrd = bVar3;
        this.nre = bVar4;
        this.nrf = bVar5;
        this.nrg = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dHj() {
        return this.npQ;
    }

    public com.tb.airbnb.lottie.model.a.b dHk() {
        return this.nrc;
    }

    public m<PointF, PointF> dGQ() {
        return this.nqI;
    }

    public com.tb.airbnb.lottie.model.a.b dGS() {
        return this.nqK;
    }

    public com.tb.airbnb.lottie.model.a.b dHl() {
        return this.nrd;
    }

    public com.tb.airbnb.lottie.model.a.b dHm() {
        return this.nre;
    }

    public com.tb.airbnb.lottie.model.a.b dHn() {
        return this.nrf;
    }

    public com.tb.airbnb.lottie.model.a.b dHo() {
        return this.nrg;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
