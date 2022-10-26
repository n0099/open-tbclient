package com.meizu.cloud.pushsdk.base;
/* loaded from: classes8.dex */
public class i {
    public Object a;
    public Object b;

    public i(Object obj) {
        if (obj == null) {
            throw new RuntimeException("proxy must be has a default implementation");
        }
        this.b = obj;
    }

    public Object c() {
        Object obj = this.a;
        return obj != null ? obj : this.b;
    }
}
