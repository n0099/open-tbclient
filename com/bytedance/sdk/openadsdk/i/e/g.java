package com.bytedance.sdk.openadsdk.i.e;

import com.bytedance.sdk.openadsdk.i.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g extends a {
    private com.bytedance.sdk.adnet.core.b c;

    public g(com.bytedance.sdk.adnet.core.b bVar, f fVar) {
        this.c = bVar;
        this.f4827a = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.erb().size()) {
                com.bytedance.sdk.adnet.core.a aVar = this.c.erb().get(i2);
                if (aVar != null) {
                    this.f4827a.add(new i.b(aVar.getName(), aVar.getValue()));
                }
                i = i2 + 1;
            } else {
                this.b = fVar;
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public int a() {
        return this.c.getStatusCode();
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public boolean b() {
        return this.c.getStatusCode() >= 200 && this.c.getStatusCode() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public String a(String str, String str2) {
        if (a(str) != null) {
            return a(str).b;
        }
        return str2;
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public List<i.b> c() {
        return this.f4827a;
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public InputStream d() {
        return this.c.getContent();
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public String f() {
        return a(this.c.getStatusCode());
    }
}
