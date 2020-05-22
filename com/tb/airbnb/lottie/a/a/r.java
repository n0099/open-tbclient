package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0844a {
    private final List<a.InterfaceC0844a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type niU;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> niV;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> niW;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> niX;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.niU = shapeTrimPath.dIy();
        this.niV = shapeTrimPath.dJr().dII();
        this.niW = shapeTrimPath.dJq().dII();
        this.niX = shapeTrimPath.dJm().dII();
        aVar.a(this.niV);
        aVar.a(this.niW);
        aVar.a(this.niX);
        this.niV.b(this);
        this.niW.b(this);
        this.niX.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0844a
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
    public void a(a.InterfaceC0844a interfaceC0844a) {
        this.listeners.add(interfaceC0844a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dIy() {
        return this.niU;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dIz() {
        return this.niV;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dIA() {
        return this.niW;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dIB() {
        return this.niX;
    }
}
