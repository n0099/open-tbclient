package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0864a {
    private final List<a.InterfaceC0864a> listeners = new ArrayList();
    private final ShapeTrimPath.Type nFT;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nFU;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nFV;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nFW;
    private final String name;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nFT = shapeTrimPath.dNs();
        this.nFU = shapeTrimPath.dOl().dNC();
        this.nFV = shapeTrimPath.dOk().dNC();
        this.nFW = shapeTrimPath.dOg().dNC();
        aVar.a(this.nFU);
        aVar.a(this.nFV);
        aVar.a(this.nFW);
        this.nFU.b(this);
        this.nFV.b(this);
        this.nFW.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0864a
    public void hq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).hq();
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
    public void a(a.InterfaceC0864a interfaceC0864a) {
        this.listeners.add(interfaceC0864a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dNs() {
        return this.nFT;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dNt() {
        return this.nFU;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dNu() {
        return this.nFV;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dNv() {
        return this.nFW;
    }
}
