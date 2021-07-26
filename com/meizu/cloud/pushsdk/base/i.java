package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f37524a;

    /* renamed from: b  reason: collision with root package name */
    public T f37525b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f37525b = t;
    }

    public T c() {
        T t = this.f37524a;
        return t != null ? t : this.f37525b;
    }
}
