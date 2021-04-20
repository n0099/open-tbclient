package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.openadsdk.k.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.b.d.b f29333c;

    public g(d.c.c.b.d.b bVar, f fVar) {
        this.f29333c = bVar;
        this.f29324a = new ArrayList();
        for (int i = 0; i < this.f29333c.c().size(); i++) {
            d.c.c.b.d.a aVar = this.f29333c.c().get(i);
            if (aVar != null) {
                this.f29324a.add(new i.b(aVar.a(), aVar.b()));
            }
        }
        this.f29325b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public int a() {
        return this.f29333c.d();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public boolean b() {
        return this.f29333c.d() >= 200 && this.f29333c.d() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public List<i.b> c() {
        return this.f29324a;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public InputStream d() {
        return this.f29333c.a();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String f() {
        return a(this.f29333c.d());
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).f29402b : str2;
    }
}
