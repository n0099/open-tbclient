package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes17.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type pKm;
    private final com.tb.airbnb.lottie.model.a.b pLs;
    private final com.tb.airbnb.lottie.model.a.b pLv;
    private final com.tb.airbnb.lottie.model.a.b pLw;

    /* loaded from: classes17.dex */
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
        this.pKm = type;
        this.pLv = bVar;
        this.pLw = bVar2;
        this.pLs = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type eyC() {
        return this.pKm;
    }

    public com.tb.airbnb.lottie.model.a.b ezu() {
        return this.pLw;
    }

    public com.tb.airbnb.lottie.model.a.b ezv() {
        return this.pLv;
    }

    public com.tb.airbnb.lottie.model.a.b ezq() {
        return this.pLs;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.pLv + ", end: " + this.pLw + ", offset: " + this.pLs + "}";
    }
}
