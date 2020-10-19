package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes16.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type oHS;
    private final com.tb.airbnb.lottie.model.a.b oIY;
    private final com.tb.airbnb.lottie.model.a.b oJb;
    private final com.tb.airbnb.lottie.model.a.b oJc;

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
        this.oHS = type;
        this.oJb = bVar;
        this.oJc = bVar2;
        this.oIY = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type ekM() {
        return this.oHS;
    }

    public com.tb.airbnb.lottie.model.a.b elE() {
        return this.oJc;
    }

    public com.tb.airbnb.lottie.model.a.b elF() {
        return this.oJb;
    }

    public com.tb.airbnb.lottie.model.a.b elA() {
        return this.oIY;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.oJb + ", end: " + this.oJc + ", offset: " + this.oIY + "}";
    }
}
