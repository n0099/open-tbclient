package com.tb.airbnb.lottie.a.a;

import com.tb.airbnb.lottie.a.b.a;
import com.tb.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class q implements b, a.InterfaceC0577a {
    private final ShapeTrimPath.Type ktu;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ktv;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ktw;
    private final com.tb.airbnb.lottie.a.b.a<?, Float> ktx;
    private final List<a.InterfaceC0577a> listeners = new ArrayList();
    private String name;

    public q(com.tb.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        this.name = shapeTrimPath.getName();
        this.ktu = shapeTrimPath.cLf();
        this.ktv = shapeTrimPath.cMe().cLn();
        this.ktw = shapeTrimPath.cMd().cLn();
        this.ktx = shapeTrimPath.cLZ().cLn();
        aVar.a(this.ktv);
        aVar.a(this.ktw);
        aVar.a(this.ktx);
        this.ktv.b(this);
        this.ktw.b(this);
        this.ktx.b(this);
    }

    @Override // com.tb.airbnb.lottie.a.b.a.InterfaceC0577a
    public void bt() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.listeners.size()) {
                this.listeners.get(i2).bt();
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
    public void a(a.InterfaceC0577a interfaceC0577a) {
        this.listeners.add(interfaceC0577a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type cLf() {
        return this.ktu;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> cLg() {
        return this.ktv;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> cLh() {
        return this.ktw;
    }

    public com.tb.airbnb.lottie.a.b.a<?, Float> cLi() {
        return this.ktx;
    }
}
