package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class ObjectArrayTemplate extends AbstractTemplate {

    /* renamed from: a  reason: collision with root package name */
    protected Class f2909a;
    protected d b;

    public ObjectArrayTemplate(Class cls, d dVar) {
        this.f2909a = cls;
        this.b = dVar;
    }

    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Object obj, boolean z) {
        if (obj == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
        } else if (!(obj instanceof Object[]) || !this.f2909a.isAssignableFrom(obj.getClass().getComponentType())) {
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
