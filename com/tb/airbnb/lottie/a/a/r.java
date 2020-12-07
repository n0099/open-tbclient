package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class r implements b, a.InterfaceC1019a {
    private final List<a.InterfaceC1019a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type pBq;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pBr;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pBs;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pBt;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.pBq = shapeTrimPath.eAY();
        this.pBr = shapeTrimPath.eBR().eBi();
        this.pBs = shapeTrimPath.eBQ().eBi();
        this.pBt = shapeTrimPath.eBM().eBi();
        aVar.a(this.pBr);
        aVar.a(this.pBs);
        aVar.a(this.pBt);
        this.pBr.b(this);
        this.pBs.b(this);
        this.pBt.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1019a
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
    public void a(a.InterfaceC1019a interfaceC1019a) {
        this.listeners.add(interfaceC1019a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type eAY() {
        return this.pBq;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eAZ() {
        return this.pBr;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eBa() {
        return this.pBs;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eBb() {
        return this.pBt;
    }
}
