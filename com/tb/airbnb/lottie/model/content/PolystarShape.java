package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type oHF;
    private final com.tb.airbnb.lottie.model.a.b oIR;
    private final com.tb.airbnb.lottie.model.a.b oIS;
    private final com.tb.airbnb.lottie.model.a.b oIT;
    private final com.tb.airbnb.lottie.model.a.b oIU;
    private final com.tb.airbnb.lottie.model.a.b oIV;
    private final m<PointF, PointF> oIx;
    private final com.tb.airbnb.lottie.model.a.b oIz;

    /* loaded from: classes16.dex */
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
        this.oHF = type;
        this.oIR = bVar;
        this.oIx = mVar;
        this.oIz = bVar2;
        this.oIS = bVar3;
        this.oIT = bVar4;
        this.oIU = bVar5;
        this.oIV = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type els() {
        return this.oHF;
    }

    public com.tb.airbnb.lottie.model.a.b elt() {
        return this.oIR;
    }

    public m<PointF, PointF> ekZ() {
        return this.oIx;
    }

    public com.tb.airbnb.lottie.model.a.b elb() {
        return this.oIz;
    }

    public com.tb.airbnb.lottie.model.a.b elu() {
        return this.oIS;
    }

    public com.tb.airbnb.lottie.model.a.b elv() {
        return this.oIT;
    }

    public com.tb.airbnb.lottie.model.a.b elw() {
        return this.oIU;
    }

    public com.tb.airbnb.lottie.model.a.b elx() {
        return this.oIV;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
