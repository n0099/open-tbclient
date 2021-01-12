package com.bytedance.sdk.openadsdk.i;

import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.openadsdk.core.h;
/* loaded from: classes4.dex */
public class b implements d.InterfaceC0993d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7208a;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.h.a.d f7209b;

    public void a(String str) {
        if (this.f7208a && this.f7209b != null) {
            this.f7209b.c(str);
        }
    }

    public void a(int i) {
        if (this.f7208a && this.f7209b != null) {
            this.f7209b.a(i);
        }
    }

    public void b(String str) {
        if (this.f7208a && this.f7209b != null) {
            this.f7209b.f(str);
        }
    }

    public void c(String str) {
        if (this.f7208a && this.f7209b != null) {
            this.f7209b.d(str);
        }
    }

    public void d(String str) {
        if (this.f7208a && this.f7209b != null) {
            this.f7209b.h(str);
        }
    }

    public b(boolean z) {
        this.f7208a = z;
        if (this.f7208a) {
            this.f7209b = com.bytedance.sdk.openadsdk.h.a.d.b();
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0993d
    public void a() {
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0993d
    public void a(d.c cVar, boolean z) {
        if (this.f7208a && this.f7209b != null) {
            if (cVar == null || cVar.a() == null) {
                this.f7209b.b(202).g(h.a(202));
                com.bytedance.sdk.openadsdk.h.a.a().k(this.f7209b);
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0993d
    public void b() {
    }

    @Override // com.bytedance.sdk.adnet.core.p.a
    public void a(p<Bitmap> pVar) {
    }

    @Override // com.bytedance.sdk.adnet.core.p.a
    public void b(p<Bitmap> pVar) {
        if (this.f7208a && this.f7209b != null) {
            this.f7209b.b(201).g(h.a(201));
            com.bytedance.sdk.openadsdk.h.a.a().k(this.f7209b);
        }
    }
}
