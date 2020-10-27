package com.meizu.cloud.pushsdk.base;
/* loaded from: classes7.dex */
public class i<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T f4375a;
    protected T b;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(T t) {
        if (t == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.b = t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        return this.f4375a != null ? this.f4375a : this.b;
    }
}
