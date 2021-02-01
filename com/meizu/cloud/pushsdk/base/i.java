package com.meizu.cloud.pushsdk.base;
/* loaded from: classes4.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T f11244a;

    /* renamed from: b  reason: collision with root package name */
    protected T f11245b;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f11245b = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        return this.f11244a != null ? this.f11244a : this.f11245b;
    }
}
