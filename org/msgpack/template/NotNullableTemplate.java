package org.msgpack.template;
/* loaded from: classes.dex */
public class NotNullableTemplate<T> extends AbstractTemplate<T> {

    /* renamed from: a  reason: collision with root package name */
    private d<T> f2876a;

    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, T t, boolean z) {
        this.f2876a.a(aVar, t, z);
    }

    @Override // org.msgpack.template.AbstractTemplate, org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, T t) {
        a(aVar, t, true);
    }
}
