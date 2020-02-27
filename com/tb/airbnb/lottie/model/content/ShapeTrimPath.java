package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.r;
/* loaded from: classes6.dex */
public class ShapeTrimPath implements b {
    private final String name;
    private final Type nqd;
    private final com.tb.airbnb.lottie.model.a.b nrj;
    private final com.tb.airbnb.lottie.model.a.b nrm;
    private final com.tb.airbnb.lottie.model.a.b nrn;

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
        this.nqd = type;
        this.nrm = bVar;
        this.nrn = bVar2;
        this.nrj = bVar3;
    }

    public String getName() {
        return this.name;
    }

    public Type dGD() {
        return this.nqd;
    }

    public com.tb.airbnb.lottie.model.a.b dHv() {
        return this.nrn;
    }

    public com.tb.airbnb.lottie.model.a.b dHw() {
        return this.nrm;
    }

    public com.tb.airbnb.lottie.model.a.b dHr() {
        return this.nrj;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new r(aVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.nrm + ", end: " + this.nrn + ", offset: " + this.nrj + "}";
    }
}
