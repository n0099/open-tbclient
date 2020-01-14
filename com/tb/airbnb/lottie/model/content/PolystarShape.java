package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type npo;
    private final com.tb.airbnb.lottie.model.a.b nqA;
    private final com.tb.airbnb.lottie.model.a.b nqB;
    private final com.tb.airbnb.lottie.model.a.b nqC;
    private final com.tb.airbnb.lottie.model.a.b nqD;
    private final com.tb.airbnb.lottie.model.a.b nqE;
    private final m<PointF, PointF> nqg;
    private final com.tb.airbnb.lottie.model.a.b nqi;

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
        this.npo = type;
        this.nqA = bVar;
        this.nqg = mVar;
        this.nqi = bVar2;
        this.nqB = bVar3;
        this.nqC = bVar4;
        this.nqD = bVar5;
        this.nqE = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dGc() {
        return this.npo;
    }

    public com.tb.airbnb.lottie.model.a.b dGd() {
        return this.nqA;
    }

    public m<PointF, PointF> dFJ() {
        return this.nqg;
    }

    public com.tb.airbnb.lottie.model.a.b dFL() {
        return this.nqi;
    }

    public com.tb.airbnb.lottie.model.a.b dGe() {
        return this.nqB;
    }

    public com.tb.airbnb.lottie.model.a.b dGf() {
        return this.nqC;
    }

    public com.tb.airbnb.lottie.model.a.b dGg() {
        return this.nqD;
    }

    public com.tb.airbnb.lottie.model.a.b dGh() {
        return this.nqE;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
