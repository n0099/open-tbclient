package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class r implements b, a.InterfaceC0947a {
    private final List<a.InterfaceC0947a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type oHS;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oHT;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oHU;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> oHV;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.oHS = shapeTrimPath.ekM();
        this.oHT = shapeTrimPath.elF().ekW();
        this.oHU = shapeTrimPath.elE().ekW();
        this.oHV = shapeTrimPath.elA().ekW();
        aVar.a(this.oHT);
        aVar.a(this.oHU);
        aVar.a(this.oHV);
        this.oHT.b(this);
        this.oHU.b(this);
        this.oHV.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0947a
    public void iT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iT();
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
    public void a(a.InterfaceC0947a interfaceC0947a) {
        this.listeners.add(interfaceC0947a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type ekM() {
        return this.oHS;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ekN() {
        return this.oHT;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ekO() {
        return this.oHU;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ekP() {
        return this.oHV;
    }
}
