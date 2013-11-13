package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class ShortTemplate extends AbstractTemplate<Short> {

    /* renamed from: a  reason: collision with root package name */
    static final ShortTemplate f2929a = new ShortTemplate();

    private ShortTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Short sh, boolean z) {
        if (sh == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(sh);
    }

    public static ShortTemplate a() {
        return f2929a;
    }
}
