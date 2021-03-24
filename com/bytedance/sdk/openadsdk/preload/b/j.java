package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.i;
import com.bytedance.sdk.openadsdk.preload.b.l;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public String f30169d;

    public abstract String a(b<OUT> bVar, IN in);

    public abstract String a(b<OUT> bVar, IN in, Throwable th, String str);

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0017 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.bytedance.sdk.openadsdk.preload.b.b<OUT> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: com.bytedance.sdk.openadsdk.preload.b.b<OUT> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: com.bytedance.sdk.openadsdk.preload.b.b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        this.f30169d = a(new m(bVar), in);
        l.a aVar = a().get(this.f30169d);
        while (aVar != null) {
            List<h> list = aVar.f30172a;
            try {
                Object a2 = c.a(list, bVar.f30165a, this).a((b) in);
                return !a(list) ? a2 : bVar.a((b<OUT>) a2);
            } catch (i.a e2) {
                this.f30169d = a(new m(bVar), in, e2.getCause(), this.f30169d);
                aVar = a().get(this.f30169d);
            } catch (Throwable th) {
                this.f30169d = a(new m(bVar), in, th, this.f30169d);
                aVar = a().get(this.f30169d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.f30169d);
    }
}
