package com.bytedance.sdk.openadsdk.k.e;

import com.bytedance.sdk.openadsdk.k.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g extends a {

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.b.d.b f30243c;

    public g(d.b.c.b.d.b bVar, f fVar) {
        this.f30243c = bVar;
        this.f30234a = new ArrayList();
        for (int i2 = 0; i2 < this.f30243c.c().size(); i2++) {
            d.b.c.b.d.a aVar = this.f30243c.c().get(i2);
            if (aVar != null) {
                this.f30234a.add(new i.b(aVar.a(), aVar.b()));
            }
        }
        this.f30235b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public int a() {
        return this.f30243c.d();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public boolean b() {
        return this.f30243c.d() >= 200 && this.f30243c.d() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public List<i.b> c() {
        return this.f30234a;
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public InputStream d() {
        return this.f30243c.a();
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String f() {
        return a(this.f30243c.d());
    }

    @Override // com.bytedance.sdk.openadsdk.k.e.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).f30313b : str2;
    }
}
