package org.msgpack.template;

import java.lang.reflect.Type;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class TemplateReference<T> extends AbstractTemplate<T> {

    /* renamed from: a  reason: collision with root package name */
    private e f2883a;
    private Type b;
    private d<T> c;

    public TemplateReference(e eVar, Type type) {
        this.f2883a = eVar;
        this.b = type;
    }

    private void a() {
        if (this.c == null) {
            this.c = (d<T>) this.f2883a.f2902a.get(this.b);
            if (this.c == null) {
                throw new MessageTypeException("Actual template have not been created");
            }
        }
    }

    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, T t, boolean z) {
        a();
        this.c.a(aVar, t, z);
    }

    @Override // org.msgpack.template.AbstractTemplate, org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, T t) {
        a();
        this.c.a(aVar, t, false);
    }
}
