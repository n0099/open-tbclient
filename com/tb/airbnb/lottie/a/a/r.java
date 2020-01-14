package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class r implements b, a.InterfaceC0730a {
    private final List<a.InterfaceC0730a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type npB;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> npC;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> npD;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> npE;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.npB = shapeTrimPath.dFw();
        this.npC = shapeTrimPath.dGp().dFG();
        this.npD = shapeTrimPath.dGo().dFG();
        this.npE = shapeTrimPath.dGk().dFG();
        aVar.a(this.npC);
        aVar.a(this.npD);
        aVar.a(this.npE);
        this.npC.b(this);
        this.npD.b(this);
        this.npE.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
    public void bC() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bC();
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
    public void a(a.InterfaceC0730a interfaceC0730a) {
        this.listeners.add(interfaceC0730a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dFw() {
        return this.npB;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dFx() {
        return this.npC;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dFy() {
        return this.npD;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dFz() {
        return this.npE;
    }
}
