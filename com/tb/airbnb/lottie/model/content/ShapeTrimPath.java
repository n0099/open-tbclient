package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes5.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type npB;
    private final com.tb.airbnb.lottie.model.a.b nqH;
    private final com.tb.airbnb.lottie.model.a.b nqK;
    private final com.tb.airbnb.lottie.model.a.b nqL;

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
        this.npB = type;
        this.nqK = bVar;
        this.nqL = bVar2;
        this.nqH = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dFw() {
        return this.npB;
    }

    public com.tb.airbnb.lottie.model.a.b dGo() {
        return this.nqL;
    }

    public com.tb.airbnb.lottie.model.a.b dGp() {
        return this.nqK;
    }

    public com.tb.airbnb.lottie.model.a.b dGk() {
        return this.nqH;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nqK + ", end: " + this.nqL + ", offset: " + this.nqH + "}";
    }
}
