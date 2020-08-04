package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class r implements b, a.InterfaceC0874a {
    private final List<a.InterfaceC0874a> listeners = new ArrayList();
    private final ShapeTrimPath.Type nOG;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOH;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOI;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOJ;
    private final String name;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nOG = shapeTrimPath.dQT();
        this.nOH = shapeTrimPath.dRM().dRd();
        this.nOI = shapeTrimPath.dRL().dRd();
        this.nOJ = shapeTrimPath.dRH().dRd();
        aVar.a(this.nOH);
        aVar.a(this.nOI);
        aVar.a(this.nOJ);
        this.nOH.b(this);
        this.nOI.b(this);
        this.nOJ.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0874a
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
    public void a(a.InterfaceC0874a interfaceC0874a) {
        this.listeners.add(interfaceC0874a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dQT() {
        return this.nOG;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dQU() {
        return this.nOH;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dQV() {
        return this.nOI;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dQW() {
        return this.nOJ;
    }
}
