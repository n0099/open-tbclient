package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0845a {
    private final List<a.InterfaceC0845a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type nke;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nkf;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nkg;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nkh;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nke = shapeTrimPath.dIM();
        this.nkf = shapeTrimPath.dJF().dIW();
        this.nkg = shapeTrimPath.dJE().dIW();
        this.nkh = shapeTrimPath.dJA().dIW();
        aVar.a(this.nkf);
        aVar.a(this.nkg);
        aVar.a(this.nkh);
        this.nkf.b(this);
        this.nkg.b(this);
        this.nkh.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0845a
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
    public void a(a.InterfaceC0845a interfaceC0845a) {
        this.listeners.add(interfaceC0845a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dIM() {
        return this.nke;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dIN() {
        return this.nkf;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dIO() {
        return this.nkg;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dIP() {
        return this.nkh;
    }
}
