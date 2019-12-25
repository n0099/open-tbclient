package com.meizu.cloud.pushsdk.base;
/* loaded from: classes5.dex */
public class j<T> {
    protected T a;
    protected T b;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(T t) {
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
