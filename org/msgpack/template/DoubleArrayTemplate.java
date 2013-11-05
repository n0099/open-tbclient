package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class DoubleArrayTemplate extends AbstractTemplate<double[]> {

    /* renamed from: a  reason: collision with root package name */
    static final DoubleArrayTemplate f2862a = new DoubleArrayTemplate();

    private DoubleArrayTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, double[] dArr, boolean z) {
        if (dArr == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.c(dArr.length);
        for (double d : dArr) {
            aVar.a(d);
        }
        aVar.a();
    }

    public static DoubleArrayTemplate a() {
        return f2862a;
    }
}
