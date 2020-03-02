package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type nqf;
    private final com.tb.airbnb.lottie.model.a.b nrl;
    private final com.tb.airbnb.lottie.model.a.b nro;
    private final com.tb.airbnb.lottie.model.a.b nrp;

    /* loaded from: classes6.dex */
    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    throw new IllegalArgumentException("Unknown trim path type " + i);
            }
        }
    }

    public ShapeTrimPath(String str, Type type, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, com.tb.airbnb.lottie.model.a.b bVar3) {
        this.name = str;
        this.nqf = type;
        this.nro = bVar;
        this.nrp = bVar2;
        this.nrl = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dGF() {
        return this.nqf;
    }

    public com.tb.airbnb.lottie.model.a.b dHx() {
        return this.nrp;
    }

    public com.tb.airbnb.lottie.model.a.b dHy() {
        return this.nro;
    }

    public com.tb.airbnb.lottie.model.a.b dHt() {
        return this.nrl;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nro + ", end: " + this.nrp + ", offset: " + this.nrl + "}";
    }
}
