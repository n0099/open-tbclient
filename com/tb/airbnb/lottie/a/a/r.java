package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class r implements b, a.InterfaceC1019a {
    private final List<a.InterfaceC1019a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type pzp;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pzq;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pzr;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pzs;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.pzp = shapeTrimPath.euM();
        this.pzq = shapeTrimPath.evF().euW();
        this.pzr = shapeTrimPath.evE().euW();
        this.pzs = shapeTrimPath.evA().euW();
        aVar.a(this.pzq);
        aVar.a(this.pzr);
        aVar.a(this.pzs);
        this.pzq.b(this);
        this.pzr.b(this);
        this.pzs.b(this);
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
    public ShapeTrimPath.Type euM() {
        return this.pzp;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> euN() {
        return this.pzq;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> euO() {
        return this.pzr;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> euP() {
        return this.pzs;
    }
}
