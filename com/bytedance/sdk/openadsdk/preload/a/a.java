package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.l;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class a<IN, OUT> extends l<IN, OUT> {
    protected abstract String a(b<OUT> bVar, IN in);

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bytedance.sdk.openadsdk.preload.a.b<OUT> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.a.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        String a2 = a(new m(bVar), in);
        l.a aVar = a().get(a2);
        if (aVar == null) {
            throw new IllegalArgumentException("can not found branch, branch name is：" + a2);
        }
        List<h> list = aVar.f7728a;
        Object a3 = c.a(list, ((i) bVar).f7726a, this).a((b) in);
        return !a(list) ? a3 : bVar.a((b<OUT>) a3);
    }
}
