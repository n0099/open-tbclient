package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.openadsdk.k.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.b.d.b f29648c;

    public g(d.c.c.b.d.b bVar, f fVar) {
        this.f29648c = bVar;
        this.f29639a = new ArrayList();
        for (int i = 0; i < this.f29648c.c().size(); i++) {
            d.c.c.b.d.a aVar = this.f29648c.c().get(i);
            if (aVar != null) {
                this.f29639a.add(new i.b(aVar.a(), aVar.b()));
            }
        }
        this.f29640b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public int a() {
        return this.f29648c.d();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public boolean b() {
        return this.f29648c.d() >= 200 && this.f29648c.d() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public List<i.b> c() {
        return this.f29639a;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public InputStream d() {
        return this.f29648c.a();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String f() {
        return a(this.f29648c.d());
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).f29717b : str2;
    }
}
