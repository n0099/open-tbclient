package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes17.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type osC;
    private final com.tb.airbnb.lottie.model.a.b otI;
    private final com.tb.airbnb.lottie.model.a.b otL;
    private final com.tb.airbnb.lottie.model.a.b otM;

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
        this.osC = type;
        this.otL = bVar;
        this.otM = bVar2;
        this.otI = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type ehb() {
        return this.osC;
    }

    public com.tb.airbnb.lottie.model.a.b ehT() {
        return this.otM;
    }

    public com.tb.airbnb.lottie.model.a.b ehU() {
        return this.otL;
    }

    public com.tb.airbnb.lottie.model.a.b ehP() {
        return this.otI;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.otL + ", end: " + this.otM + ", offset: " + this.otI + "}";
    }
}
