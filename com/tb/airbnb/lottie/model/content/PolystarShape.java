package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class PolystarShape implements b {
    private final String name;
    private final Type njR;
    private final m<PointF, PointF> nkJ;
    private final com.tb.airbnb.lottie.model.a.b nkL;
    private final com.tb.airbnb.lottie.model.a.b nld;
    private final com.tb.airbnb.lottie.model.a.b nle;
    private final com.tb.airbnb.lottie.model.a.b nlf;
    private final com.tb.airbnb.lottie.model.a.b nlg;
    private final com.tb.airbnb.lottie.model.a.b nlh;

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
        this.njR = type;
        this.nld = bVar;
        this.nkJ = mVar;
        this.nkL = bVar2;
        this.nle = bVar3;
        this.nlf = bVar4;
        this.nlg = bVar5;
        this.nlh = bVar6;
    }

    public String getName() {
        return this.name;
    }

    public Type dJs() {
        return this.njR;
    }

    public com.tb.airbnb.lottie.model.a.b dJt() {
        return this.nld;
    }

    public m<PointF, PointF> dIZ() {
        return this.nkJ;
    }

    public com.tb.airbnb.lottie.model.a.b dJb() {
        return this.nkL;
    }

    public com.tb.airbnb.lottie.model.a.b dJu() {
        return this.nle;
    }

    public com.tb.airbnb.lottie.model.a.b dJv() {
        return this.nlf;
    }

    public com.tb.airbnb.lottie.model.a.b dJw() {
        return this.nlg;
    }

    public com.tb.airbnb.lottie.model.a.b dJx() {
        return this.nlh;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.m(fVar, aVar, this);
    }
}
