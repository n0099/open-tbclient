package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes7.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type oiS;
    private final com.tb.airbnb.lottie.model.a.b ojY;
    private final com.tb.airbnb.lottie.model.a.b okb;
    private final com.tb.airbnb.lottie.model.a.b okc;

    /* loaded from: classes7.dex */
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
        this.oiS = type;
        this.okb = bVar;
        this.okc = bVar2;
        this.ojY = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type ede() {
        return this.oiS;
    }

    public com.tb.airbnb.lottie.model.a.b edW() {
        return this.okc;
    }

    public com.tb.airbnb.lottie.model.a.b edX() {
        return this.okb;
    }

    public com.tb.airbnb.lottie.model.a.b edS() {
        return this.ojY;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.okb + ", end: " + this.okc + ", offset: " + this.ojY + "}";
    }
}
