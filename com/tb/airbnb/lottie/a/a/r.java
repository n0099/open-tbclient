package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class r implements b, a.InterfaceC1041a {
    private final List<a.InterfaceC1041a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type pKm;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pKn;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pKo;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pKp;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.pKm = shapeTrimPath.eyC();
        this.pKn = shapeTrimPath.ezv().eyM();
        this.pKo = shapeTrimPath.ezu().eyM();
        this.pKp = shapeTrimPath.ezq().eyM();
        aVar.a(this.pKn);
        aVar.a(this.pKo);
        aVar.a(this.pKp);
        this.pKn.b(this);
        this.pKo.b(this);
        this.pKp.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1041a
    public void iT() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).iT();
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
    public void a(a.InterfaceC1041a interfaceC1041a) {
        this.listeners.add(interfaceC1041a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type eyC() {
        return this.pKm;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eyD() {
        return this.pKn;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eyE() {
        return this.pKo;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eyF() {
        return this.pKp;
    }
}
