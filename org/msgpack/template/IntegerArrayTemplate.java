package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class IntegerArrayTemplate extends AbstractTemplate<int[]> {

    /* renamed from: a  reason: collision with root package name */
    static final IntegerArrayTemplate f2869a = new IntegerArrayTemplate();

    private IntegerArrayTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.c(iArr.length);
        for (int i : iArr) {
            aVar.a(i);
        }
        aVar.a();
    }

    public static IntegerArrayTemplate a() {
        return f2869a;
    }
}
