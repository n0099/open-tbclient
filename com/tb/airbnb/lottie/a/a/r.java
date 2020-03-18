package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0739a {
    private final List<a.InterfaceC0739a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type nsd;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nse;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nsf;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nsg;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nsd = shapeTrimPath.dHg();
        this.nse = shapeTrimPath.dHZ().dHq();
        this.nsf = shapeTrimPath.dHY().dHq();
        this.nsg = shapeTrimPath.dHU().dHq();
        aVar.a(this.nse);
        aVar.a(this.nsf);
        aVar.a(this.nsg);
        this.nse.b(this);
        this.nsf.b(this);
        this.nsg.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0739a
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
    public void a(a.InterfaceC0739a interfaceC0739a) {
        this.listeners.add(interfaceC0739a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dHg() {
        return this.nsd;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dHh() {
        return this.nse;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dHi() {
        return this.nsf;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dHj() {
        return this.nsg;
    }
}
