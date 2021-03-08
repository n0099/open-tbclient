package com.bytedance.sdk.openadsdk.preload.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public final class i extends l implements Iterable<l> {

    /* renamed from: a  reason: collision with root package name */
    private final List<l> f5033a = new ArrayList();

    public void a(l lVar) {
        if (lVar == null) {
            lVar = n.f5034a;
        }
        this.f5033a.add(lVar);
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f5033a.iterator();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public Number a() {
        if (this.f5033a.size() == 1) {
            return this.f5033a.get(0).a();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public String b() {
        if (this.f5033a.size() == 1) {
            return this.f5033a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public double c() {
        if (this.f5033a.size() == 1) {
            return this.f5033a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public long d() {
        if (this.f5033a.size() == 1) {
            return this.f5033a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public int e() {
        if (this.f5033a.size() == 1) {
            return this.f5033a.get(0).e();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public boolean f() {
        if (this.f5033a.size() == 1) {
            return this.f5033a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f5033a.equals(this.f5033a));
    }

    public int hashCode() {
        return this.f5033a.hashCode();
    }
}
