package com.tb.airbnb.lottie.model.content;

import com.tb.airbnb.lottie.a.a.p;
/* loaded from: classes7.dex */
public class k implements b {
    private final int index;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.h ojI;

    public k(String str, int i, com.tb.airbnb.lottie.model.a.h hVar) {
        this.name = str;
        this.index = i;
        this.ojI = hVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.h edM() {
        return this.ojI;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new p(fVar, aVar, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + '}';
    }
}
