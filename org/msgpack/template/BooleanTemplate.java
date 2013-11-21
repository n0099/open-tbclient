package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class BooleanTemplate extends AbstractTemplate<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    static final BooleanTemplate f2887a = new BooleanTemplate();

    private BooleanTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Boolean bool, boolean z) {
        if (bool == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(bool.booleanValue());
    }

    public static BooleanTemplate a() {
        return f2887a;
    }
}
