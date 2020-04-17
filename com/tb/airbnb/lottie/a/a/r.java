package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0763a {
    private final List<a.InterfaceC0763a> listeners = new ArrayList();
    private final ShapeTrimPath.Type mOM;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mON;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOO;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOP;
    private final String name;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.mOM = shapeTrimPath.dBi();
        this.mON = shapeTrimPath.dCb().dBs();
        this.mOO = shapeTrimPath.dCa().dBs();
        this.mOP = shapeTrimPath.dBW().dBs();
        aVar.a(this.mON);
        aVar.a(this.mOO);
        aVar.a(this.mOP);
        this.mON.b(this);
        this.mOO.b(this);
        this.mOP.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0763a
    public void ha() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).ha();
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
    public void a(a.InterfaceC0763a interfaceC0763a) {
        this.listeners.add(interfaceC0763a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dBi() {
        return this.mOM;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBj() {
        return this.mON;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBk() {
        return this.mOO;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBl() {
        return this.mOP;
    }
}
