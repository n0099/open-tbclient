package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type nsd;
    private final com.tb.airbnb.lottie.model.a.b ntj;
    private final com.tb.airbnb.lottie.model.a.b ntm;
    private final com.tb.airbnb.lottie.model.a.b ntn;

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
        this.nsd = type;
        this.ntm = bVar;
        this.ntn = bVar2;
        this.ntj = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dHg() {
        return this.nsd;
    }

    public com.tb.airbnb.lottie.model.a.b dHY() {
        return this.ntn;
    }

    public com.tb.airbnb.lottie.model.a.b dHZ() {
        return this.ntm;
    }

    public com.tb.airbnb.lottie.model.a.b dHU() {
        return this.ntj;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.ntm + ", end: " + this.ntn + ", offset: " + this.ntj + "}";
    }
}
