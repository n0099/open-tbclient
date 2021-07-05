package com.meizu.cloud.pushsdk.base;
/* loaded from: classes7.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f40321a;

    /* renamed from: b  reason: collision with root package name */
    public T f40322b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f40322b = t;
    }

    public T c() {
        T t = this.f40321a;
        return t != null ? t : this.f40322b;
    }
}
