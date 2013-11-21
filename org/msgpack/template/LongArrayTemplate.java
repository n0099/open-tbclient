package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class LongArrayTemplate extends AbstractTemplate<long[]> {

    /* renamed from: a  reason: collision with root package name */
    static final LongArrayTemplate f2904a = new LongArrayTemplate();

    private LongArrayTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, long[] jArr, boolean z) {
        if (jArr == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.c(jArr.length);
        for (long j : jArr) {
            aVar.a(j);
        }
        aVar.a();
    }

    public static LongArrayTemplate a() {
        return f2904a;
    }
}
