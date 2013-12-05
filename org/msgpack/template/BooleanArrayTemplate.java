package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class BooleanArrayTemplate extends AbstractTemplate<boolean[]> {

    /* renamed from: a  reason: collision with root package name */
    static final BooleanArrayTemplate f3067a = new BooleanArrayTemplate();

    private BooleanArrayTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, boolean[] zArr, boolean z) {
        if (zArr == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.c(zArr.length);
        for (boolean z2 : zArr) {
            aVar.a(z2);
        }
        aVar.a();
    }

    public static BooleanArrayTemplate a() {
        return f3067a;
    }
}
