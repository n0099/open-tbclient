package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q implements b, a.InterfaceC0687a {
    private final List<a.InterfaceC0687a> listeners = new ArrayList();
    private final ShapeTrimPath.Type mNr;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNs;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNt;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mNu;
    private String name;

    public q(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.mNr = shapeTrimPath.dBh();
        this.mNs = shapeTrimPath.dCl().dBq();
        this.mNt = shapeTrimPath.dCk().dBq();
        this.mNu = shapeTrimPath.dCg().dBq();
        aVar.a(this.mNs);
        aVar.a(this.mNt);
        aVar.a(this.mNu);
        this.mNs.b(this);
        this.mNt.b(this);
        this.mNu.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0687a
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
    public void a(a.InterfaceC0687a interfaceC0687a) {
        this.listeners.add(interfaceC0687a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dBh() {
        return this.mNr;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBi() {
        return this.mNs;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBj() {
        return this.mNt;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBk() {
        return this.mNu;
    }
}
