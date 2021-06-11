package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
public final class m<IN> implements b<IN> {

    /* renamed from: a  reason: collision with root package name */
    public b<IN> f30059a;

    public m(b<IN> bVar) {
        this.f30059a = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(IN in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public <O> O b(Class<? extends d<?, O>> cls) {
        return (O) this.f30059a.b(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public <I> I a(Class<? extends d<I, ?>> cls) {
        return (I) this.f30059a.a((Class<? extends d<Object, ?>>) cls);
    }
}
