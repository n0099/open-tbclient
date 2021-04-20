package com.bytedance.sdk.openadsdk.preload.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class i extends l implements Iterable<l> {

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f29821a = new ArrayList();

    public void a(l lVar) {
        if (lVar == null) {
            lVar = n.f29822a;
        }
        this.f29821a.add(lVar);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public String b() {
        if (this.f29821a.size() == 1) {
            return this.f29821a.get(0).b();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public double c() {
        if (this.f29821a.size() == 1) {
            return this.f29821a.get(0).c();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public long d() {
        if (this.f29821a.size() == 1) {
            return this.f29821a.get(0).d();
        }
        throw new IllegalStateException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public int e() {
        if (this.f29821a.size() == 1) {
            return this.f29821a.get(0).e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f29821a.equals(this.f29821a));
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public boolean f() {
        if (this.f29821a.size() == 1) {
            return this.f29821a.get(0).f();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f29821a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f29821a.iterator();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public Number a() {
        if (this.f29821a.size() == 1) {
            return this.f29821a.get(0).a();
        }
        throw new IllegalStateException();
    }
}
