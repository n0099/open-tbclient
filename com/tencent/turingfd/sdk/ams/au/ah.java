package com.tencent.turingfd.sdk.ams.au;

import com.tencent.turingfd.sdk.ams.au.g;
/* loaded from: classes3.dex */
public abstract class ah<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f13470a;

    public final T a() {
        T t = this.f13470a;
        if (t == null) {
            synchronized (this) {
                t = this.f13470a;
                if (t == null) {
                    g.b bVar = (g.b) this;
                    t = (T) new g();
                    this.f13470a = t;
                }
            }
        }
        return t;
    }
}
