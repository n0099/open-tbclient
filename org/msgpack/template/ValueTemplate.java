package org.msgpack.template;

import org.msgpack.MessageTypeException;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public class ValueTemplate extends AbstractTemplate<r> {

    /* renamed from: a  reason: collision with root package name */
    static final ValueTemplate f2884a = new ValueTemplate();

    private ValueTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, r rVar, boolean z) {
        if (rVar == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        rVar.writeTo(aVar);
    }

    public static ValueTemplate a() {
        return f2884a;
    }
}
