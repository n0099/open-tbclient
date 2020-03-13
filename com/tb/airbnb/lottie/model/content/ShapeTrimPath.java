package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type nqq;
    private final com.tb.airbnb.lottie.model.a.b nrA;
    private final com.tb.airbnb.lottie.model.a.b nrw;
    private final com.tb.airbnb.lottie.model.a.b nrz;

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
        this.nqq = type;
        this.nrz = bVar;
        this.nrA = bVar2;
        this.nrw = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dGG() {
        return this.nqq;
    }

    public com.tb.airbnb.lottie.model.a.b dHy() {
        return this.nrA;
    }

    public com.tb.airbnb.lottie.model.a.b dHz() {
        return this.nrz;
    }

    public com.tb.airbnb.lottie.model.a.b dHu() {
        return this.nrw;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nrz + ", end: " + this.nrA + ", offset: " + this.nrw + "}";
    }
}
