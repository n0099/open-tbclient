package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.openadsdk.k.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public d.c.c.b.d.b f29647c;

    public g(d.c.c.b.d.b bVar, f fVar) {
        this.f29647c = bVar;
        this.f29638a = new ArrayList();
        for (int i = 0; i < this.f29647c.c().size(); i++) {
            d.c.c.b.d.a aVar = this.f29647c.c().get(i);
            if (aVar != null) {
                this.f29638a.add(new i.b(aVar.a(), aVar.b()));
            }
        }
        this.f29639b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public int a() {
        return this.f29647c.d();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public boolean b() {
        return this.f29647c.d() >= 200 && this.f29647c.d() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public List<i.b> c() {
        return this.f29638a;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public InputStream d() {
        return this.f29647c.a();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String f() {
        return a(this.f29647c.d());
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).f29716b : str2;
    }
}
