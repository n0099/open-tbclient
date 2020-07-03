package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final Type nFT;
    private final com.tb.airbnb.lottie.model.a.b nGZ;
    private final com.tb.airbnb.lottie.model.a.b nHc;
    private final com.tb.airbnb.lottie.model.a.b nHd;
    private final String name;

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
        this.nFT = type;
        this.nHc = bVar;
        this.nHd = bVar2;
        this.nGZ = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dNs() {
        return this.nFT;
    }

    public com.tb.airbnb.lottie.model.a.b dOk() {
        return this.nHd;
    }

    public com.tb.airbnb.lottie.model.a.b dOl() {
        return this.nHc;
    }

    public com.tb.airbnb.lottie.model.a.b dOg() {
        return this.nGZ;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nHc + ", end: " + this.nHd + ", offset: " + this.nGZ + "}";
    }
}
