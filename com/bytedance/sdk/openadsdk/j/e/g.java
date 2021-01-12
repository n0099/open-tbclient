package com.bytedance.sdk.openadsdk.j.e;

import com.bytedance.sdk.openadsdk.j.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class g extends a {
    private com.bytedance.sdk.adnet.core.b c;

    public g(com.bytedance.sdk.adnet.core.b bVar, f fVar) {
        this.c = bVar;
        this.f7258a = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.eot().size()) {
                com.bytedance.sdk.adnet.core.a aVar = this.c.eot().get(i2);
                if (aVar != null) {
                    this.f7258a.add(new i.b(aVar.getName(), aVar.getValue()));
                }
                i = i2 + 1;
            } else {
                this.f7259b = fVar;
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.a
    public int a() {
        return this.c.getStatusCode();
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.a
    public boolean b() {
        return this.c.getStatusCode() >= 200 && this.c.getStatusCode() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.a
    public String a(String str, String str2) {
        if (a(str) != null) {
            return a(str).f7302b;
        }
        return str2;
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.a
    public List<i.b> c() {
        return this.f7258a;
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.a
    public InputStream d() {
        return this.c.getContent();
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.j.e.a
    public String f() {
        return a(this.c.getStatusCode());
    }
}
