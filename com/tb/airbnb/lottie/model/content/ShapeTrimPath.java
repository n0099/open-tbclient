package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes16.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pAv;
    private final com.tb.airbnb.lottie.model.a.b pAy;
    private final com.tb.airbnb.lottie.model.a.b pAz;
    private final Type pzp;

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
        this.pzp = type;
        this.pAy = bVar;
        this.pAz = bVar2;
        this.pAv = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type euM() {
        return this.pzp;
    }

    public com.tb.airbnb.lottie.model.a.b evE() {
        return this.pAz;
    }

    public com.tb.airbnb.lottie.model.a.b evF() {
        return this.pAy;
    }

    public com.tb.airbnb.lottie.model.a.b evA() {
        return this.pAv;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.pAy + ", end: " + this.pAz + ", offset: " + this.pAv + "}";
    }
}
