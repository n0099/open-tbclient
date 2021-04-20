package com.bytedance.sdk.openadsdk.preload.a;

import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class v<T> {
    public final v<T> a() {
        return new v<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.v.1
            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.f();
                } else {
                    v.this.a(cVar, t);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                    aVar.j();
                    return null;
                }
                return (T) v.this.b(aVar);
            }
        };
    }

    public abstract void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException;

    public abstract T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException;

    public final l a(T t) {
        try {
            com.bytedance.sdk.openadsdk.preload.a.b.a.f fVar = new com.bytedance.sdk.openadsdk.preload.a.b.a.f();
            a(fVar, t);
            return fVar.a();
        } catch (IOException e2) {
            throw new m(e2);
        }
    }
}
