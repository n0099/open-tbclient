package com.tb.airbnb.lottie.a.b;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import com.baidu.mapapi.map.WeightedLatLng;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<K, A> {
    private final List<? extends com.tb.airbnb.lottie.a.a<K>> fu;
    @Nullable
    private com.tb.airbnb.lottie.a.a<K> kty;
    final List<InterfaceC0577a> listeners = new ArrayList();
    private boolean ft = false;
    private float progress = 0.0f;

    /* renamed from: com.tb.airbnb.lottie.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0577a {
        void bt();
    }

    abstract A a(com.tb.airbnb.lottie.a.a<K> aVar, float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.tb.airbnb.lottie.a.a<K>> list) {
        this.fu = list;
    }

    public void bH() {
        this.ft = true;
    }

    public void b(InterfaceC0577a interfaceC0577a) {
        this.listeners.add(interfaceC0577a);
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

    private com.tb.airbnb.lottie.a.a<K> cLj() {
        if (this.fu.isEmpty()) {
            throw new IllegalStateException("There are no keyframes");
        }
        if (this.kty != null && this.kty.g(this.progress)) {
            return this.kty;
        }
        com.tb.airbnb.lottie.a.a<K> aVar = this.fu.get(this.fu.size() - 1);
        if (this.progress < aVar.bo()) {
            for (int size = this.fu.size() - 1; size >= 0; size--) {
                aVar = this.fu.get(size);
                if (aVar.g(this.progress)) {
                    break;
                }
            }
        }
        this.kty = aVar;
        return aVar;
    }

    private float bJ() {
        if (this.ft) {
            return 0.0f;
        }
        com.tb.airbnb.lottie.a.a<K> cLj = cLj();
        if (cLj.bq()) {
            return 0.0f;
        }
        return cLj.el.getInterpolation((this.progress - cLj.bo()) / (cLj.bp() - cLj.bo()));
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bK() {
        if (this.fu.isEmpty()) {
            return 0.0f;
        }
        return this.fu.get(0).bo();
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float bp() {
        if (this.fu.isEmpty()) {
            return 1.0f;
        }
        return this.fu.get(this.fu.size() - 1).bp();
    }

    public A getValue() {
        return a(cLj(), bJ());
    }

    public float getProgress() {
        return this.progress;
    }
}
