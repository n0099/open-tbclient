package com.bytedance.sdk.openadsdk.h;

import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.openadsdk.core.h;
/* loaded from: classes6.dex */
public class b implements d.InterfaceC1007d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4796a;
    private com.bytedance.sdk.openadsdk.g.a.c b;

    public void a(String str) {
        if (this.f4796a && this.b != null) {
            this.b.c(str);
        }
    }

    public void a(int i) {
        if (this.f4796a && this.b != null) {
            this.b.a(i);
        }
    }

    public void b(String str) {
        if (this.f4796a && this.b != null) {
            this.b.f(str);
        }
    }

    public void c(String str) {
        if (this.f4796a && this.b != null) {
            this.b.d(str);
        }
    }

    public void d(String str) {
        if (this.f4796a && this.b != null) {
            this.b.h(str);
        }
    }

    public b(boolean z) {
        this.f4796a = z;
        if (this.f4796a) {
            this.b = com.bytedance.sdk.openadsdk.g.a.c.b();
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1007d
    public void a() {
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1007d
    public void a(d.c cVar, boolean z) {
        if (this.f4796a && this.b != null) {
            if (cVar == null || cVar.a() == null) {
                this.b.b(202).g(h.a(202));
                com.bytedance.sdk.openadsdk.g.a.a().k(this.b);
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.b.d.InterfaceC1007d
    public void b() {
    }

    @Override // com.bytedance.sdk.adnet.core.o.a
    public void a(o<Bitmap> oVar) {
    }

    @Override // com.bytedance.sdk.adnet.core.o.a
    public void b(o<Bitmap> oVar) {
        if (this.f4796a && this.b != null) {
            this.b.b(201).g(h.a(201));
            com.bytedance.sdk.openadsdk.g.a.a().k(this.b);
        }
    }
}
