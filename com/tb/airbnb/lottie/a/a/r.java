package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class r implements b, a.InterfaceC0730a {
    private final List<a.InterfaceC0730a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type npw;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> npx;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> npy;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> npz;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.npw = shapeTrimPath.dFu();
        this.npx = shapeTrimPath.dGn().dFE();
        this.npy = shapeTrimPath.dGm().dFE();
        this.npz = shapeTrimPath.dGi().dFE();
        aVar.a(this.npx);
        aVar.a(this.npy);
        aVar.a(this.npz);
        this.npx.b(this);
        this.npy.b(this);
        this.npz.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0730a
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
    public void a(a.InterfaceC0730a interfaceC0730a) {
        this.listeners.add(interfaceC0730a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dFu() {
        return this.npw;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dFv() {
        return this.npx;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dFw() {
        return this.npy;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dFx() {
        return this.npz;
    }
}
