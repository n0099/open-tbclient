package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f34781a;

    /* renamed from: b  reason: collision with root package name */
    public T f34782b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f34782b = t;
    }

    public T c() {
        T t = this.f34781a;
        return t != null ? t : this.f34782b;
    }
}
