package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final Type nFW;
    private final com.tb.airbnb.lottie.model.a.b nHc;
    private final com.tb.airbnb.lottie.model.a.b nHf;
    private final com.tb.airbnb.lottie.model.a.b nHg;
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
        this.nFW = type;
        this.nHf = bVar;
        this.nHg = bVar2;
        this.nHc = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dNw() {
        return this.nFW;
    }

    public com.tb.airbnb.lottie.model.a.b dOo() {
        return this.nHg;
    }

    public com.tb.airbnb.lottie.model.a.b dOp() {
        return this.nHf;
    }

    public com.tb.airbnb.lottie.model.a.b dOk() {
        return this.nHc;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nHf + ", end: " + this.nHg + ", offset: " + this.nHc + "}";
    }
}
