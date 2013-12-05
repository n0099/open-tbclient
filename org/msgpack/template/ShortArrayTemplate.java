package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class ShortArrayTemplate extends AbstractTemplate<short[]> {

    /* renamed from: a  reason: collision with root package name */
    static final ShortArrayTemplate f3093a = new ShortArrayTemplate();

    private ShortArrayTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, short[] sArr, boolean z) {
        if (sArr == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.c(sArr.length);
        for (short s : sArr) {
            aVar.a(s);
        }
        aVar.a();
    }

    public static ShortArrayTemplate a() {
        return f3093a;
    }
}
