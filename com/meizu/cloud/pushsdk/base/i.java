package com.meizu.cloud.pushsdk.base;
/* loaded from: classes6.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T f11541a;

    /* renamed from: b  reason: collision with root package name */
    protected T f11542b;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.f11542b = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        return this.f11541a != null ? this.f11541a : this.f11542b;
    }
}
