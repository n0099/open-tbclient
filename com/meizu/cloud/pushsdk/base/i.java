package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T f11542a;

    /* renamed from: b  reason: collision with root package name */
    protected T f11543b;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f11543b = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        return this.f11542a != null ? this.f11542a : this.f11543b;
    }
}
