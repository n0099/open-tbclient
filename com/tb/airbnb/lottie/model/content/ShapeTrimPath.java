package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes20.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type pBs;
    private final com.tb.airbnb.lottie.model.a.b pCB;
    private final com.tb.airbnb.lottie.model.a.b pCC;
    private final com.tb.airbnb.lottie.model.a.b pCy;

    /* loaded from: classes20.dex */
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
        this.pBs = type;
        this.pCB = bVar;
        this.pCC = bVar2;
        this.pCy = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type eAZ() {
        return this.pBs;
    }

    public com.tb.airbnb.lottie.model.a.b eBR() {
        return this.pCC;
    }

    public com.tb.airbnb.lottie.model.a.b eBS() {
        return this.pCB;
    }

    public com.tb.airbnb.lottie.model.a.b eBN() {
        return this.pCy;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.pCB + ", end: " + this.pCC + ", offset: " + this.pCy + "}";
    }
}
