package com.bytedance.sdk.openadsdk.preload.geckox.c;

import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.p;
import com.bytedance.sdk.openadsdk.preload.a.v;
import java.io.IOException;
/* loaded from: classes6.dex */
public class a extends v<Boolean> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(c cVar, Boolean bool) throws IOException {
        if (bool == null) {
            cVar.f();
        } else {
            cVar.a(bool);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    /* renamed from: a */
    public Boolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.d.b f = aVar.f();
        switch (f) {
            case BOOLEAN:
                return Boolean.valueOf(aVar.i());
            case NULL:
                aVar.j();
                return null;
            case NUMBER:
                return Boolean.valueOf(aVar.m() != 0);
            default:
                throw new p("Expected BOOLEAN or NUMBER but was " + f);
        }
    }
}
