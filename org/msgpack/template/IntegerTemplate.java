package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class IntegerTemplate extends AbstractTemplate<Integer> {

    /* renamed from: a  reason: collision with root package name */
    static final IntegerTemplate f2902a = new IntegerTemplate();

    private IntegerTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Integer num, boolean z) {
        if (num == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(num.intValue());
    }

    public static IntegerTemplate a() {
        return f2902a;
    }
}
