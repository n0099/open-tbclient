package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class r implements b, a.InterfaceC0874a {
    private final List<a.InterfaceC0874a> listeners = new ArrayList();
    private final ShapeTrimPath.Type nOE;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOF;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOG;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nOH;
    private final String name;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nOE = shapeTrimPath.dQS();
        this.nOF = shapeTrimPath.dRL().dRc();
        this.nOG = shapeTrimPath.dRK().dRc();
        this.nOH = shapeTrimPath.dRG().dRc();
        aVar.a(this.nOF);
        aVar.a(this.nOG);
        aVar.a(this.nOH);
        this.nOF.b(this);
        this.nOG.b(this);
        this.nOH.b(this);
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
    public ShapeTrimPath.Type dQS() {
        return this.nOE;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dQT() {
        return this.nOF;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dQU() {
        return this.nOG;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dQV() {
        return this.nOH;
    }
}
