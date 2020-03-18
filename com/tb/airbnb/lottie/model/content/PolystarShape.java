package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type nrQ;
    private final m<PointF, PointF> nsI;
    private final com.tb.airbnb.lottie.model.a.b nsK;
    private final com.tb.airbnb.lottie.model.a.b ntc;
    private final com.tb.airbnb.lottie.model.a.b ntd;
    private final com.tb.airbnb.lottie.model.a.b nte;
    private final com.tb.airbnb.lottie.model.a.b ntf;
    private final com.tb.airbnb.lottie.model.a.b ntg;

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
        this.nrQ = type;
        this.ntc = bVar;
        this.nsI = mVar;
        this.nsK = bVar2;
        this.ntd = bVar3;
        this.nte = bVar4;
        this.ntf = bVar5;
        this.ntg = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dHM() {
        return this.nrQ;
    }

    public com.tb.airbnb.lottie.model.a.b dHN() {
        return this.ntc;
    }

    public m<PointF, PointF> dHt() {
        return this.nsI;
    }

    public com.tb.airbnb.lottie.model.a.b dHv() {
        return this.nsK;
    }

    public com.tb.airbnb.lottie.model.a.b dHO() {
        return this.ntd;
    }

    public com.tb.airbnb.lottie.model.a.b dHP() {
        return this.nte;
    }

    public com.tb.airbnb.lottie.model.a.b dHQ() {
        return this.ntf;
    }

    public com.tb.airbnb.lottie.model.a.b dHR() {
        return this.ntg;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
