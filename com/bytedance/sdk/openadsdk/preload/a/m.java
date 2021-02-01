package com.bytedance.sdk.openadsdk.preload.a;
/* loaded from: classes6.dex */
final class m<IN> implements b<IN> {

    /* renamed from: a  reason: collision with root package name */
    private b<IN> f7433a;

    public m(b<IN> bVar) {
        this.f7433a = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.b
    public Object a(IN in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.b
    public <I> I a(Class<? extends d<I, ?>> cls) {
        return (I) this.f7433a.a((Class<? extends d<Object, ?>>) cls);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.b
    public <O> O b(Class<? extends d<?, O>> cls) {
        return (O) this.f7433a.b(cls);
    }
}
