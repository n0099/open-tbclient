package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes20.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type pBq;
    private final com.tb.airbnb.lottie.model.a.b pCA;
    private final com.tb.airbnb.lottie.model.a.b pCw;
    private final com.tb.airbnb.lottie.model.a.b pCz;

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
        this.pBq = type;
        this.pCz = bVar;
        this.pCA = bVar2;
        this.pCw = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type eAY() {
        return this.pBq;
    }

    public com.tb.airbnb.lottie.model.a.b eBQ() {
        return this.pCA;
    }

    public com.tb.airbnb.lottie.model.a.b eBR() {
        return this.pCz;
    }

    public com.tb.airbnb.lottie.model.a.b eBM() {
        return this.pCw;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.pCz + ", end: " + this.pCA + ", offset: " + this.pCw + "}";
    }
}
