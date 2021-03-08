package com.bytedance.sdk.openadsdk.preload.b;
/* loaded from: classes6.dex */
final class m<IN> implements b<IN> {

    /* renamed from: a  reason: collision with root package name */
    private b<IN> f5048a;

    public m(b<IN> bVar) {
        this.f5048a = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public Object a(IN in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public <I> I a(Class<? extends d<I, ?>> cls) {
        return (I) this.f5048a.a((Class<? extends d<Object, ?>>) cls);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b
    public <O> O b(Class<? extends d<?, O>> cls) {
        return (O) this.f5048a.b(cls);
    }
}
