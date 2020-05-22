package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type niU;
    private final com.tb.airbnb.lottie.model.a.b nka;
    private final com.tb.airbnb.lottie.model.a.b nkd;
    private final com.tb.airbnb.lottie.model.a.b nke;

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
        this.niU = type;
        this.nkd = bVar;
        this.nke = bVar2;
        this.nka = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dIy() {
        return this.niU;
    }

    public com.tb.airbnb.lottie.model.a.b dJq() {
        return this.nke;
    }

    public com.tb.airbnb.lottie.model.a.b dJr() {
        return this.nkd;
    }

    public com.tb.airbnb.lottie.model.a.b dJm() {
        return this.nka;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nkd + ", end: " + this.nke + ", offset: " + this.nka + "}";
    }
}
