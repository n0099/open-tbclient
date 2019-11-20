package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q implements b, a.InterfaceC0577a {
    private final ShapeTrimPath.Type ksD;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksE;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksF;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ksG;
    private final List<a.InterfaceC0577a> listeners = new ArrayList();
    private String name;

    public q(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.ksD = shapeTrimPath.cLd();
        this.ksE = shapeTrimPath.cMc().cLl();
        this.ksF = shapeTrimPath.cMb().cLl();
        this.ksG = shapeTrimPath.cLX().cLl();
        aVar.a(this.ksE);
        aVar.a(this.ksF);
        aVar.a(this.ksG);
        this.ksE.b(this);
        this.ksF.b(this);
        this.ksG.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bt();
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
    public void a(a.InterfaceC0577a interfaceC0577a) {
        this.listeners.add(interfaceC0577a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type cLd() {
        return this.ksD;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> cLe() {
        return this.ksE;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> cLf() {
        return this.ksF;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> cLg() {
        return this.ksG;
    }
}
