package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class MessagePackableTemplate extends AbstractTemplate<org.msgpack.b> {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f2875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessagePackableTemplate(Class<?> cls) {
        this.f2875a = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, org.msgpack.b bVar, boolean z) {
        if (bVar == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        bVar.a(aVar);
    }
}
