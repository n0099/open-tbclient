package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.openadsdk.k.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.b.d.b f29341c;

    public g(d.c.c.b.d.b bVar, f fVar) {
        this.f29341c = bVar;
        this.f29332a = new ArrayList();
        for (int i = 0; i < this.f29341c.c().size(); i++) {
            d.c.c.b.d.a aVar = this.f29341c.c().get(i);
            if (aVar != null) {
                this.f29332a.add(new i.b(aVar.a(), aVar.b()));
            }
        }
        this.f29333b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public int a() {
        return this.f29341c.d();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public boolean b() {
        return this.f29341c.d() >= 200 && this.f29341c.d() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public List<i.b> c() {
        return this.f29332a;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public InputStream d() {
        return this.f29341c.a();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String f() {
        return a(this.f29341c.d());
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).f29410b : str2;
    }
}
