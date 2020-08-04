package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes5.dex */
public class ShapeTrimPath implements b {
    private final Type nOG;
    private final com.tb.airbnb.lottie.model.a.b nPM;
    private final com.tb.airbnb.lottie.model.a.b nPP;
    private final com.tb.airbnb.lottie.model.a.b nPQ;
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
        this.nOG = type;
        this.nPP = bVar;
        this.nPQ = bVar2;
        this.nPM = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dQT() {
        return this.nOG;
    }

    public com.tb.airbnb.lottie.model.a.b dRL() {
        return this.nPQ;
    }

    public com.tb.airbnb.lottie.model.a.b dRM() {
        return this.nPP;
    }

    public com.tb.airbnb.lottie.model.a.b dRH() {
        return this.nPM;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nPP + ", end: " + this.nPQ + ", offset: " + this.nPM + "}";
    }
}
