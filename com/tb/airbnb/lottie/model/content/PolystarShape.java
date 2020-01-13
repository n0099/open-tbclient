package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type npj;
    private final m<PointF, PointF> nqb;
    private final com.tb.airbnb.lottie.model.a.b nqd;
    private final com.tb.airbnb.lottie.model.a.b nqv;
    private final com.tb.airbnb.lottie.model.a.b nqw;
    private final com.tb.airbnb.lottie.model.a.b nqx;
    private final com.tb.airbnb.lottie.model.a.b nqy;
    private final com.tb.airbnb.lottie.model.a.b nqz;

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
        this.npj = type;
        this.nqv = bVar;
        this.nqb = mVar;
        this.nqd = bVar2;
        this.nqw = bVar3;
        this.nqx = bVar4;
        this.nqy = bVar5;
        this.nqz = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dGa() {
        return this.npj;
    }

    public com.tb.airbnb.lottie.model.a.b dGb() {
        return this.nqv;
    }

    public m<PointF, PointF> dFH() {
        return this.nqb;
    }

    public com.tb.airbnb.lottie.model.a.b dFJ() {
        return this.nqd;
    }

    public com.tb.airbnb.lottie.model.a.b dGc() {
        return this.nqw;
    }

    public com.tb.airbnb.lottie.model.a.b dGd() {
        return this.nqx;
    }

    public com.tb.airbnb.lottie.model.a.b dGe() {
        return this.nqy;
    }

    public com.tb.airbnb.lottie.model.a.b dGf() {
        return this.nqz;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
