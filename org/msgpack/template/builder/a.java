package org.msgpack.template.builder;

import org.msgpack.MessageTypeException;
import org.msgpack.template.AbstractTemplate;
/* loaded from: classes.dex */
class a extends AbstractTemplate {

    /* renamed from: a  reason: collision with root package name */
    private Class f3107a;
    private org.msgpack.template.d b;

    public a(Class cls, org.msgpack.template.d dVar) {
        this.f3107a = cls;
        this.b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class a() {
        return this.f3107a;
    }

    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Object obj, boolean z) {
        if (obj == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
        } else if (!(obj instanceof Object[]) || !this.f3107a.isAssignableFrom(obj.getClass().getComponentType())) {
            throw new MessageTypeException();
        } else {
            Object[] objArr = (Object[]) obj;
            aVar.c(objArr.length);
            for (Object obj2 : objArr) {
                this.b.a(aVar, obj2, z);
            }
            aVar.a();
        }
    }
}
