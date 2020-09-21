package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class r implements b, a.InterfaceC0929a {
    private final List<a.InterfaceC0929a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type osC;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> osD;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> osE;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> osF;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.osC = shapeTrimPath.ehb();
        this.osD = shapeTrimPath.ehU().ehl();
        this.osE = shapeTrimPath.ehT().ehl();
        this.osF = shapeTrimPath.ehP().ehl();
        aVar.a(this.osD);
        aVar.a(this.osE);
        aVar.a(this.osF);
        this.osD.b(this);
        this.osE.b(this);
        this.osF.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0929a
    public void iS() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iS();
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
    public void a(a.InterfaceC0929a interfaceC0929a) {
        this.listeners.add(interfaceC0929a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type ehb() {
        return this.osC;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ehc() {
        return this.osD;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ehd() {
        return this.osE;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> ehe() {
        return this.osF;
    }
}
