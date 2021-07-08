package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f37335a;

    /* renamed from: b  reason: collision with root package name */
    public T f37336b;

    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f37336b = t;
    }

    public T c() {
        T t = this.f37335a;
        return t != null ? t : this.f37336b;
    }
}
