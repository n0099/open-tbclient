package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes5.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type npw;
    private final com.tb.airbnb.lottie.model.a.b nqC;
    private final com.tb.airbnb.lottie.model.a.b nqF;
    private final com.tb.airbnb.lottie.model.a.b nqG;

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
        this.npw = type;
        this.nqF = bVar;
        this.nqG = bVar2;
        this.nqC = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dFu() {
        return this.npw;
    }

    public com.tb.airbnb.lottie.model.a.b dGm() {
        return this.nqG;
    }

    public com.tb.airbnb.lottie.model.a.b dGn() {
        return this.nqF;
    }

    public com.tb.airbnb.lottie.model.a.b dGi() {
        return this.nqC;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nqF + ", end: " + this.nqG + ", offset: " + this.nqC + "}";
    }
}
