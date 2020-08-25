package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class r implements b, a.InterfaceC0932a {
    private final List<a.InterfaceC0932a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type oiA;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oiB;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oiC;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oiD;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.oiA = shapeTrimPath.ecV();
        this.oiB = shapeTrimPath.edO().edf();
        this.oiC = shapeTrimPath.edN().edf();
        this.oiD = shapeTrimPath.edJ().edf();
        aVar.a(this.oiB);
        aVar.a(this.oiC);
        aVar.a(this.oiD);
        this.oiB.b(this);
        this.oiC.b(this);
        this.oiD.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0932a
    public void iR() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iR();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public void b(List<b> list, List<b> list2) {
    }

    @Override // com.tb.airbnb.lottie.a.a.b
    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a.InterfaceC0932a interfaceC0932a) {
        this.listeners.add(interfaceC0932a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type ecV() {
        return this.oiA;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ecW() {
        return this.oiB;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ecX() {
        return this.oiC;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ecY() {
        return this.oiD;
    }
}
