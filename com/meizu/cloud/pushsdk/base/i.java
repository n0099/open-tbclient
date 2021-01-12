package com.meizu.cloud.pushsdk.base;
/* loaded from: classes5.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T f11242a;

    /* renamed from: b  reason: collision with root package name */
    protected T f11243b;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f11243b = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        return this.f11242a != null ? this.f11242a : this.f11243b;
    }
}
