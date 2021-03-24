package com.bytedance.sdk.openadsdk.preload.b;

import com.bytedance.sdk.openadsdk.preload.b.i;
/* loaded from: classes6.dex */
public abstract class k<IN, OUT> extends d<IN, OUT> {

    /* renamed from: d  reason: collision with root package name */
    public IN f30170d;

    private Object a(b<OUT> bVar, IN in, Throwable th) throws Throwable {
        while (a(th)) {
            try {
                return bVar.a((b<OUT>) b());
            } catch (i.a e2) {
                th = e2.getCause();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        throw th;
    }

    public abstract boolean a(Throwable th);

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        this.f30170d = in;
        try {
            return bVar.a((b<OUT>) b());
        } catch (i.a e2) {
            return a(bVar, in, e2.getCause());
        } catch (Throwable th) {
            return a(bVar, in, th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [IN, OUT] */
    public OUT b() {
        return this.f30170d;
    }

    public final IN g() {
        return this.f30170d;
    }
}
