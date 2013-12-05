package org.msgpack.template;

import java.lang.reflect.Type;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class AnyTemplate<T> extends AbstractTemplate<T> {

    /* renamed from: a  reason: collision with root package name */
    private e f3064a;

    public AnyTemplate(e eVar) {
        this.f3064a = eVar;
    }

    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, T t, boolean z) {
        if (t == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        this.f3064a.a((Type) t.getClass()).a(aVar, t);
    }
}
