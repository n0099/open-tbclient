package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes5.dex */
public class ShapeTrimPath implements b {
    private final Type nOE;
    private final com.tb.airbnb.lottie.model.a.b nPK;
    private final com.tb.airbnb.lottie.model.a.b nPN;
    private final com.tb.airbnb.lottie.model.a.b nPO;
    private final String name;

    /* loaded from: classes5.dex */
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
        this.nOE = type;
        this.nPN = bVar;
        this.nPO = bVar2;
        this.nPK = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dQS() {
        return this.nOE;
    }

    public com.tb.airbnb.lottie.model.a.b dRK() {
        return this.nPO;
    }

    public com.tb.airbnb.lottie.model.a.b dRL() {
        return this.nPN;
    }

    public com.tb.airbnb.lottie.model.a.b dRG() {
        return this.nPK;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nPN + ", end: " + this.nPO + ", offset: " + this.nPK + "}";
    }
}
