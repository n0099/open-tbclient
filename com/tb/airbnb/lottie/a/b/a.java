package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.a.a<K>> eR;
    @Nullable
    private com.tb.airbnb.lottie.a.a<K> ksH;
    final List<InterfaceC0572a> listeners = new ArrayList();
    private boolean eQ = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0572a {
        void bt();
    }

    abstract A a(com.tb.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.a.a<K>> list) {
        this.eR = list;
    }

    public void bH() {
        this.eQ = true;
    }

    public void b(InterfaceC0572a interfaceC0572a) {
        this.listeners.add(interfaceC0572a);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f < bK()) {
            f = bK();
        } else if (f > bp()) {
            f = bp();
        }
        if (f != this.progress) {
            this.progress = f;
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
    }

    private com.tb.airbnb.lottie.a.a<K> cLh() {
        if (this.eR.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.ksH != null && this.ksH.g(this.progress)) {
            return this.ksH;
        }
        com.tb.airbnb.lottie.a.a<K> aVar = this.eR.get(this.eR.size() - 1);
        if (this.progress < aVar.bo()) {
            for (int size = this.eR.size() - 1; size >= 0; size--) {
                aVar = this.eR.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.ksH = aVar;
        return aVar;
    }

    private float bJ() {
        if (this.eQ) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.a.a<K> cLh = cLh();
        if (cLh.bq()) {
            return 0.0f;
        }
        return cLh.dM.getInterpolation((this.progress - cLh.bo()) / (cLh.bp() - cLh.bo()));
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bK() {
        if (this.eR.isEmpty()) {
            return 0.0f;
        }
        return this.eR.get(0).bo();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bp() {
        if (this.eR.isEmpty()) {
            return 1.0f;
        }
        return this.eR.get(this.eR.size() - 1).bp();
    }

    public A getValue() {
        return a(cLh(), bJ());
    }

    public float getProgress() {
        return this.progress;
    }
}
