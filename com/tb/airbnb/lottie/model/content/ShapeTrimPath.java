package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes16.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type pIJ;
    private final com.tb.airbnb.lottie.model.a.b pJP;
    private final com.tb.airbnb.lottie.model.a.b pJS;
    private final com.tb.airbnb.lottie.model.a.b pJT;

    /* loaded from: classes16.dex */
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
        this.pIJ = type;
        this.pJS = bVar;
        this.pJT = bVar2;
        this.pJP = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type eyB() {
        return this.pIJ;
    }

    public com.tb.airbnb.lottie.model.a.b ezt() {
        return this.pJT;
    }

    public com.tb.airbnb.lottie.model.a.b ezu() {
        return this.pJS;
    }

    public com.tb.airbnb.lottie.model.a.b ezp() {
        return this.pJP;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.pJS + ", end: " + this.pJT + ", offset: " + this.pJP + "}";
    }
}
