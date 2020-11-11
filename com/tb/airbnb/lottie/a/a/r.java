package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class r implements b, a.InterfaceC1038a {
    private final List<a.InterfaceC1038a> listeners = new ArrayList();
    private final String name;
    private final ShapeTrimPath.Type pIJ;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pIK;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pIL;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> pIM;

    public r(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.pIJ = shapeTrimPath.eyB();
        this.pIK = shapeTrimPath.ezu().eyL();
        this.pIL = shapeTrimPath.ezt().eyL();
        this.pIM = shapeTrimPath.ezp().eyL();
        aVar.a(this.pIK);
        aVar.a(this.pIL);
        aVar.a(this.pIM);
        this.pIK.b(this);
        this.pIL.b(this);
        this.pIM.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC1038a
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
    public void a(a.InterfaceC1038a interfaceC1038a) {
        this.listeners.add(interfaceC1038a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type eyB() {
        return this.pIJ;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eyC() {
        return this.pIK;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eyD() {
        return this.pIL;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> eyE() {
        return this.pIM;
    }
}
