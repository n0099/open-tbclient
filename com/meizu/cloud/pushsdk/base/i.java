package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f37960a;

    /* renamed from: b  reason: collision with root package name */
    public T f37961b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f37961b = t;
    }

    public T c() {
        T t = this.f37960a;
        return t != null ? t : this.f37961b;
    }
}
