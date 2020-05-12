package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0784a {
    private final List<a.InterfaceC0784a> listeners = new ArrayList();
    private final ShapeTrimPath.Type mOP;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOQ;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOR;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> mOS;
    private final String name;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.mOP = shapeTrimPath.dBf();
        this.mOQ = shapeTrimPath.dBY().dBp();
        this.mOR = shapeTrimPath.dBX().dBp();
        this.mOS = shapeTrimPath.dBT().dBp();
        aVar.a(this.mOQ);
        aVar.a(this.mOR);
        aVar.a(this.mOS);
        this.mOQ.b(this);
        this.mOR.b(this);
        this.mOS.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0784a
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
    public void a(a.InterfaceC0784a interfaceC0784a) {
        this.listeners.add(interfaceC0784a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dBf() {
        return this.mOP;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBg() {
        return this.mOQ;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBh() {
        return this.mOR;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dBi() {
        return this.mOS;
    }
}
