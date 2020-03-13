package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0738a {
    private final List<a.InterfaceC0738a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type nqq;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqr;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqs;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqt;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nqq = shapeTrimPath.dGG();
        this.nqr = shapeTrimPath.dHz().dGQ();
        this.nqs = shapeTrimPath.dHy().dGQ();
        this.nqt = shapeTrimPath.dHu().dGQ();
        aVar.a(this.nqr);
        aVar.a(this.nqs);
        aVar.a(this.nqt);
        this.nqr.b(this);
        this.nqs.b(this);
        this.nqt.b(this);
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
    public ShapeTrimPath.Type dGG() {
        return this.nqq;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGH() {
        return this.nqr;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGI() {
        return this.nqs;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGJ() {
        return this.nqt;
    }
}
