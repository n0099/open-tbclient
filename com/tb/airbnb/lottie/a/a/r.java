package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0738a {
    private final List<a.InterfaceC0738a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type nqd;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqe;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqf;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqg;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nqd = shapeTrimPath.dGD();
        this.nqe = shapeTrimPath.dHw().dGN();
        this.nqf = shapeTrimPath.dHv().dGN();
        this.nqg = shapeTrimPath.dHr().dGN();
        aVar.a(this.nqe);
        aVar.a(this.nqf);
        aVar.a(this.nqg);
        this.nqe.b(this);
        this.nqf.b(this);
        this.nqg.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0738a
    public void bD() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bD();
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
    public void a(a.InterfaceC0738a interfaceC0738a) {
        this.listeners.add(interfaceC0738a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dGD() {
        return this.nqd;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGE() {
        return this.nqe;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGF() {
        return this.nqf;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGG() {
        return this.nqg;
    }
}
