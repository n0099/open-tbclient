package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class LongTemplate extends AbstractTemplate<Long> {

    /* renamed from: a  reason: collision with root package name */
    static final LongTemplate f2873a = new LongTemplate();

    private LongTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Long l, boolean z) {
        if (l == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(l.longValue());
    }

    public static LongTemplate a() {
        return f2873a;
    }
}
