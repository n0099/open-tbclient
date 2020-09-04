package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class r implements b, a.InterfaceC0932a {
    private final List<a.InterfaceC0932a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type oiS;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oiT;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oiU;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oiV;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.oiS = shapeTrimPath.ede();
        this.oiT = shapeTrimPath.edX().edo();
        this.oiU = shapeTrimPath.edW().edo();
        this.oiV = shapeTrimPath.edS().edo();
        aVar.a(this.oiT);
        aVar.a(this.oiU);
        aVar.a(this.oiV);
        this.oiT.b(this);
        this.oiU.b(this);
        this.oiV.b(this);
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
    public ShapeTrimPath.Type ede() {
        return this.oiS;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> edf() {
        return this.oiT;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> edg() {
        return this.oiU;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> edh() {
        return this.oiV;
    }
}
