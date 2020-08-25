package com.meizu.cloud.pushsdk.base;
/* loaded from: classes20.dex */
public class i<T> {
    protected T a;
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
        return this.a != null ? this.a : this.b;
    }
}
