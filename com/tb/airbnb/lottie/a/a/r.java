package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0738a {
    private final List<a.InterfaceC0738a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type nqf;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqg;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqh;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nqi;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nqf = shapeTrimPath.dGF();
        this.nqg = shapeTrimPath.dHy().dGP();
        this.nqh = shapeTrimPath.dHx().dGP();
        this.nqi = shapeTrimPath.dHt().dGP();
        aVar.a(this.nqg);
        aVar.a(this.nqh);
        aVar.a(this.nqi);
        this.nqg.b(this);
        this.nqh.b(this);
        this.nqi.b(this);
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
    public ShapeTrimPath.Type dGF() {
        return this.nqf;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGG() {
        return this.nqg;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGH() {
        return this.nqh;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dGI() {
        return this.nqi;
    }
}
