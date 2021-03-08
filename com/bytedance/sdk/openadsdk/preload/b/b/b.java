package com.bytedance.sdk.openadsdk.preload.b.b;

import com.bytedance.sdk.openadsdk.preload.b.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f5040a = new CopyOnWriteArrayList();

    public b(a... aVarArr) {
        if (aVarArr != null) {
            this.f5040a.addAll(Arrays.asList(aVarArr));
        }
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f5040a.add(aVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.f5040a) {
            if (aVar != null) {
                aVar.c(bVar, dVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.f5040a) {
            if (aVar != null) {
                aVar.b(bVar, dVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        for (a aVar : this.f5040a) {
            if (aVar != null) {
                aVar.a(bVar, dVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.f5040a) {
            if (aVar != null) {
                aVar.a(bVar, dVar, th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void f(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.f5040a) {
            if (aVar != null) {
                aVar.f(bVar, dVar, th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        for (a aVar : this.f5040a) {
            if (aVar != null) {
                aVar.b(bVar, dVar, th);
            }
        }
    }
}
