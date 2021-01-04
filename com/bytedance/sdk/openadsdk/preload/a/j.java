package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.i;
import com.bytedance.sdk.openadsdk.preload.a.l;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {
    private String d;

    protected abstract String a(b<OUT> bVar, IN in);

    protected abstract String a(b<OUT> bVar, IN in, Throwable th, String str);

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bytedance.sdk.openadsdk.preload.a.b<OUT> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.a.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        this.d = a(new m(bVar), in);
        l.a aVar = a().get(this.d);
        while (aVar != null) {
            List<h> list = aVar.f7727a;
            try {
                Object a2 = c.a(list, ((i) bVar).f7725a, this).a((b) in);
                if (a(list)) {
                    a2 = bVar.a((b<OUT>) a2);
                }
                return a2;
            } catch (i.a e) {
                this.d = a(new m(bVar), in, e.getCause(), this.d);
                aVar = a().get(this.d);
            } catch (Throwable th) {
                this.d = a(new m(bVar), in, th, this.d);
                aVar = a().get(this.d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.d);
    }
}
