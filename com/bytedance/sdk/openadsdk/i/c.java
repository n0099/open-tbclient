package com.bytedance.sdk.openadsdk.i;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.core.h;
import d.c.c.b.b.d;
import d.c.c.b.d.o;
/* loaded from: classes6.dex */
public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f29497a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.h.a.c f29498b;

    public c(boolean z) {
        this.f29497a = z;
        if (z) {
            this.f29498b = com.bytedance.sdk.openadsdk.h.a.c.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.b.d.k
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.d.o.a
    public void a(o<Bitmap> oVar) {
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.h.a.c cVar;
        if (!this.f29497a || (cVar = this.f29498b) == null) {
            return;
        }
        cVar.c(str);
    }

    @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.b.d.k
    public void b() {
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.h.a.c cVar;
        if (!this.f29497a || (cVar = this.f29498b) == null) {
            return;
        }
        cVar.f(str);
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.h.a.c cVar;
        if (!this.f29497a || (cVar = this.f29498b) == null) {
            return;
        }
        cVar.d(str);
    }

    public void d(String str) {
        com.bytedance.sdk.openadsdk.h.a.c cVar;
        if (!this.f29497a || (cVar = this.f29498b) == null) {
            return;
        }
        cVar.h(str);
    }

    public void a(int i) {
        com.bytedance.sdk.openadsdk.h.a.c cVar;
        if (!this.f29497a || (cVar = this.f29498b) == null) {
            return;
        }
        cVar.a(i);
    }

    @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.d.o.a
    public void b(o<Bitmap> oVar) {
        com.bytedance.sdk.openadsdk.h.a.c cVar;
        if (!this.f29497a || (cVar = this.f29498b) == null) {
            return;
        }
        cVar.b(201).g(h.a(201));
        com.bytedance.sdk.openadsdk.h.a.a().k(this.f29498b);
    }

    @Override // com.bytedance.sdk.openadsdk.i.b, d.c.c.b.b.d.k
    public void a(d.i iVar, boolean z) {
        if (!this.f29497a || this.f29498b == null) {
            return;
        }
        if (iVar == null || iVar.a() == null) {
            this.f29498b.b(202).g(h.a(202));
            com.bytedance.sdk.openadsdk.h.a.a().k(this.f29498b);
        }
    }
}
