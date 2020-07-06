package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class r implements b, a.InterfaceC0865a {
    private final List<a.InterfaceC0865a> listeners = new ArrayList();
    private final ShapeTrimPath.Type nFW;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nFX;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nFY;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> nFZ;
    private final String name;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.nFW = shapeTrimPath.dNw();
        this.nFX = shapeTrimPath.dOp().dNG();
        this.nFY = shapeTrimPath.dOo().dNG();
        this.nFZ = shapeTrimPath.dOk().dNG();
        aVar.a(this.nFX);
        aVar.a(this.nFY);
        aVar.a(this.nFZ);
        this.nFX.b(this);
        this.nFY.b(this);
        this.nFZ.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0865a
    public void hq() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).hq();
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
    public void a(a.InterfaceC0865a interfaceC0865a) {
        this.listeners.add(interfaceC0865a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type dNw() {
        return this.nFW;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dNx() {
        return this.nFX;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dNy() {
        return this.nFY;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> dNz() {
        return this.nFZ;
    }
}
