package com.bytedance.sdk.openadsdk.i;

import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.openadsdk.core.h;
/* loaded from: classes4.dex */
public class b implements d.InterfaceC1010d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7508a;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.h.a.d f7509b;

    public void a(String str) {
        if (this.f7508a && this.f7509b != null) {
            this.f7509b.c(str);
        }
    }

    public void a(int i) {
        if (this.f7508a && this.f7509b != null) {
            this.f7509b.a(i);
        }
    }

    public void b(String str) {
        if (this.f7508a && this.f7509b != null) {
            this.f7509b.f(str);
        }
    }

    public void c(String str) {
        if (this.f7508a && this.f7509b != null) {
            this.f7509b.d(str);
        }
    }

    public void d(String str) {
        if (this.f7508a && this.f7509b != null) {
            this.f7509b.h(str);
        }
    }

    public b(boolean z) {
        this.f7508a = z;
        if (this.f7508a) {
            this.f7509b = com.bytedance.sdk.openadsdk.h.a.d.b();
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1010d
    public void a() {
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1010d
    public void a(d.c cVar, boolean z) {
        if (this.f7508a && this.f7509b != null) {
            if (cVar == null || cVar.a() == null) {
                this.f7509b.b(202).g(h.a(202));
                com.bytedance.sdk.openadsdk.h.a.a().k(this.f7509b);
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1010d
    public void b() {
    }

    @Override // com.bytedance.sdk.adnet.core.p.a
    public void a(p<Bitmap> pVar) {
    }

    @Override // com.bytedance.sdk.adnet.core.p.a
    public void b(p<Bitmap> pVar) {
        if (this.f7508a && this.f7509b != null) {
            this.f7509b.b(201).g(h.a(201));
            com.bytedance.sdk.openadsdk.h.a.a().k(this.f7509b);
        }
    }
}
