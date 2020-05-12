package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final Type mOP;
    private final com.tb.airbnb.lottie.model.a.b mPX;
    private final com.tb.airbnb.lottie.model.a.b mQa;
    private final com.tb.airbnb.lottie.model.a.b mQb;
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
        this.mOP = type;
        this.mQa = bVar;
        this.mQb = bVar2;
        this.mPX = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dBf() {
        return this.mOP;
    }

    public com.tb.airbnb.lottie.model.a.b dBX() {
        return this.mQb;
    }

    public com.tb.airbnb.lottie.model.a.b dBY() {
        return this.mQa;
    }

    public com.tb.airbnb.lottie.model.a.b dBT() {
        return this.mPX;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.mQa + ", end: " + this.mQb + ", offset: " + this.mPX + "}";
    }
}
